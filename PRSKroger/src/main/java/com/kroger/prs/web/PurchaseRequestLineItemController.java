package com.kroger.prs.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kroger.prs.business.purchaserequest.PurchaseRequest;
import com.kroger.prs.business.purchaserequest.PurchaseRequestLineItem;
import com.kroger.prs.business.purchaserequest.PurchaseRequestLineItemRepository;
import com.kroger.prs.business.purchaserequest.PurchaseRequestRepository;
import com.kroger.prs.util.JsonResponse;

@RestController
@RequestMapping("/purchase-requests")
public class PurchaseRequestLineItemController {
	private static final String NEW = "New";
	private static final String REVIEW = "Review";
	private static final String APPROVED = "Approved";
	private static final String REJECTED = "Rejected";
	
	@Autowired
	private PurchaseRequestLineItemRepository prliRepo;
	
	@Autowired
	private PurchaseRequestRepository prRepo;
	
	@Autowired
	private EntityManager entityManager;

	@GetMapping("{prid}/line-items")
	public ResponseEntity<JsonResponse> getAll(@PathVariable int prid) {
		ResponseEntity<JsonResponse> re;
		try {
			List<PurchaseRequestLineItem> prlis = prliRepo.findByPurchaseRequestId(prid);
			re = ResponseEntity.ok().body(JsonResponse.getInstance(prlis));
		}
		catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return re;
	}
	
	@GetMapping("/{id}/line-items/{prliId}")
	public ResponseEntity<JsonResponse> get(@PathVariable int id, @PathVariable int prliId) {
		ResponseEntity<JsonResponse> re;
		Optional<PurchaseRequestLineItem> u = null;
		try {
			u = prliRepo.findById(id);
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
	
	@PostMapping("/{id}/line-items/{prliId}")
	public ResponseEntity<JsonResponse> save(@PathVariable int id, @RequestBody PurchaseRequestLineItem u) {
		if (prliRepo.findById(id).isPresent()) {
			u.setId(id);
			return savePurchaseRequestLineItem(u);
		}
		else {
			Exception e = new Exception("PurchaseRequest id "+id+" does not exist.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					JsonResponse.getInstance(e));
		}
	}

	@PostMapping("/{id}/line-items/")
	public ResponseEntity<JsonResponse> save(@RequestBody PurchaseRequestLineItem prli) {
		return savePurchaseRequestLineItem(prli);
	}

	private ResponseEntity<JsonResponse> savePurchaseRequestLineItem(PurchaseRequestLineItem prli) {
		try {
			prliRepo.save(prli);
			ResponseEntity<JsonResponse> re;
			if (prli.getId()<=0)
				re = ResponseEntity.created(null).body(JsonResponse.getInstance(
						prliRepo.findById(prli.getId()).get()));
			else
				re = ResponseEntity.ok().body(JsonResponse.getInstance(
							prliRepo.findById(prli.getId()).get()));
			return re;
		}
		catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}

	}
	@DeleteMapping("/{id}/line-items/{prliId}")
	public ResponseEntity<JsonResponse> delete(@PathVariable int id) {
		ResponseEntity<JsonResponse> re;
		try {
			prliRepo.deleteById(id);
			re = ResponseEntity.ok().build();
		} catch (Exception e) {
			re = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(JsonResponse.getInstance(e));
		}
		return re;
	}
	
	// example of clearing cache
	private void recalcTotal() {
		entityManager.clear();
		// entityManager.flush();  something else to try?
	}
}
