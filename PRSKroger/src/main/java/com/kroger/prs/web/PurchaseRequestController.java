package com.kroger.prs.web;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kroger.prs.business.purchaserequest.PurchaseRequest;
import com.kroger.prs.business.purchaserequest.PurchaseRequestRepository;
import com.kroger.prs.util.JsonResponse;

@RestController
@RequestMapping("/purchase-requests")
public class PurchaseRequestController {
	private static final String NEW = "New";
	private static final String REVIEW = "Review";
	private static final String APPROVED = "Approved";
	private static final String REJECTED = "Rejected";
	
	@Autowired
	private PurchaseRequestRepository purchaseRequestRepo;
	
	@GetMapping("/")
	public ResponseEntity<JsonResponse> getAll() {
		ResponseEntity<JsonResponse> re;
		try {
			re = ResponseEntity.ok().body(JsonResponse.getInstance(purchaseRequestRepo.findAll()));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JsonResponse> get(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		Optional<PurchaseRequest> u = null;
		try {
			u = purchaseRequestRepo.findById(id);
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
	public ResponseEntity<JsonResponse> save(@PathVariable int id, @RequestBody PurchaseRequest u) {
		if (purchaseRequestRepo.findById(id).isPresent()) {
			u.setId(id);
			return savePurchaseRequest(u);
		}
		else {
			Exception e = new Exception("PurchaseRequest id "+id+" does not exist.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					JsonResponse.getInstance(e));
		}
	}

	@PostMapping("/")
	public ResponseEntity<JsonResponse> save(@RequestBody PurchaseRequest pr) {
		pr.setStatus(NEW);
		pr.setSubmittedDate(LocalDateTime.now());
		pr.setTotal(0.0);
		return savePurchaseRequest(pr);
	}

	private ResponseEntity<JsonResponse> savePurchaseRequest(PurchaseRequest pr) {
		try {
			purchaseRequestRepo.save(pr);
			ResponseEntity<JsonResponse> re;
			if (pr.getId()<=0)
				re = ResponseEntity.created(null).body(JsonResponse.getInstance(
						purchaseRequestRepo.findById(pr.getId()).get()));
			else
				re = ResponseEntity.ok().body(JsonResponse.getInstance(
							purchaseRequestRepo.findById(pr.getId()).get()));
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
			purchaseRequestRepo.deleteById(id);
			re = ResponseEntity.ok().build();
		} catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}
		return re;
	}
}
