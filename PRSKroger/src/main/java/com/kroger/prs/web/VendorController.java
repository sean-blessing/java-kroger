package com.kroger.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kroger.prs.business.vendor.Vendor;
import com.kroger.prs.business.vendor.VendorRepository;
import com.kroger.prs.util.JsonResponse;

@RestController
@RequestMapping("/vendors")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping("/")
	public ResponseEntity<JsonResponse> getAll() {
		ResponseEntity<JsonResponse> re;
		try {
			re = ResponseEntity.ok().body(JsonResponse.getInstance(vendorRepo.findAll()));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JsonResponse> get(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		Optional<Vendor> u = null;
		try {
			u = vendorRepo.findById(id);
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
	public ResponseEntity<JsonResponse> save(@PathVariable int id, @RequestBody Vendor u) {
		if (vendorRepo.findById(id).isPresent()) {
			u.setId(id);
			return saveVendor(u);
		}
		else {
			Exception e = new Exception("Vendor id "+id+" does not exist.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					JsonResponse.getInstance(e));
		}
	}

	@PostMapping("/")
	public ResponseEntity<JsonResponse> save(@RequestBody Vendor u) {		
		return saveVendor(u);
	}

	private ResponseEntity<JsonResponse> saveVendor(Vendor u) {
		try {
			vendorRepo.save(u);
			ResponseEntity<JsonResponse> re;
			if (u.getId()<=0)
				re = ResponseEntity.created(null).body(JsonResponse.getInstance(
						vendorRepo.findById(u.getId()).get()));
			else
				re = ResponseEntity.ok().body(JsonResponse.getInstance(
							vendorRepo.findById(u.getId()).get()));
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
			vendorRepo.deleteById(id);
			re = ResponseEntity.ok().build();
		} catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}
		return re;
	}
}
