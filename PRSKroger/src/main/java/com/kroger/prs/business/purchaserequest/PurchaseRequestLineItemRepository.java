package com.kroger.prs.business.purchaserequest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRequestLineItemRepository extends CrudRepository<PurchaseRequestLineItem, Integer>{

	List<PurchaseRequestLineItem> findByPurchaseRequestId(int prid);
}
