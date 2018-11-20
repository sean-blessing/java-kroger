package com.kroger.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kroger.prs.business.product.Product;
import com.kroger.prs.business.product.ProductRepository;
import com.kroger.prs.util.JsonResponse;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/")
	public ResponseEntity<JsonResponse> getAll() {
		ResponseEntity<JsonResponse> re;
		try {
			re = ResponseEntity.ok().body(JsonResponse.getInstance(productRepo.findAll()));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JsonResponse> get(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		Optional<Product> u = null;
		try {
			u = productRepo.findById(id);
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
	public ResponseEntity<JsonResponse> save(@PathVariable int id, @RequestBody Product u) {
		if (productRepo.findById(id).isPresent()) {
			u.setId(id);
			return saveProduct(u);
		}
		else {
			Exception e = new Exception("Product id "+id+" does not exist.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					JsonResponse.getInstance(e));
		}
	}

	@PostMapping("/")
	public ResponseEntity<JsonResponse> save(@RequestBody Product p) {	
		return saveProduct(p);
	}

	private ResponseEntity<JsonResponse> saveProduct(Product p) {
		try {
			productRepo.save(p);
			ResponseEntity<JsonResponse> re;
			if (p.getId()<=0)
				re = ResponseEntity.created(null).body(JsonResponse.getInstance(
						productRepo.findById(p.getId()).get()));
			else
				re = ResponseEntity.ok().body(JsonResponse.getInstance(
							productRepo.findById(p.getId()).get()));
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
			productRepo.deleteById(id);
			re = ResponseEntity.ok().build();
		} catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}
		return re;
	}
}
