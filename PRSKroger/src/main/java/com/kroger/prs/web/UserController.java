package com.kroger.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kroger.prs.business.user.User;
import com.kroger.prs.business.user.UserRepository;
import com.kroger.prs.util.JsonResponse;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/authenticate")
	public ResponseEntity<JsonResponse> authenticate(@RequestBody User u) {

		ResponseEntity<JsonResponse> re;
		try {
			User user = userRepo.findByUserNameAndPassword(u.getUserName(), u.getPassword());
			re = ResponseEntity.ok().body(JsonResponse.getInstance(user));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;

	}
	@GetMapping("/")
	public ResponseEntity<JsonResponse> getAll() {
		ResponseEntity<JsonResponse> re;
		try {
			re = ResponseEntity.ok().body(JsonResponse.getInstance(userRepo.findAll()));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JsonResponse> get(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		Optional<User> u = null;
		try {
			u = userRepo.findById(id);
			if (u.isPresent()) {
				re = ResponseEntity.ok().body(
						JsonResponse.getInstance(u.get()));
			}
			else {
				// Note, we're not returning JsonResponse, only setting HttpStatus to 404
				re = ResponseEntity.notFound().build();
			}
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<JsonResponse> save(@PathVariable int id, @RequestBody User u) {
		if (userRepo.findById(id).isPresent()) {
			u.setId(id);
			return saveUser(u);
		}
		else {
			Exception e = new Exception("User id "+id+" does not exist.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					JsonResponse.getInstance(e));
		}
	}

	@PostMapping("/")
	public ResponseEntity<JsonResponse> save(@RequestBody User u) {		
		return saveUser(u);
	}

	private ResponseEntity<JsonResponse> saveUser(User u) {
		try {
			userRepo.save(u);
			ResponseEntity<JsonResponse> re;
			if (u.getId()<=0)
				re = ResponseEntity.created(null).body(JsonResponse.getInstance(
						userRepo.findById(u.getId()).get()));
			else
				re = ResponseEntity.ok().body(JsonResponse.getInstance(
							userRepo.findById(u.getId()).get()));
			return re;
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<JsonResponse> delete(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		try {
			userRepo.deleteById(id);
			re = ResponseEntity.ok().build();
		} catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}
		return re;
	}
}
