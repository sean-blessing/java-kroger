package com.kroger.prs.business.purchaserequest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kroger.prs.business.user.User;

@Entity
public class PurchaseRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	private String description;
	private String justification;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateNeeded;
	private String deliveryMode;
	private String status;
	private double total;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =
	// "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private LocalDateTime submittedDate;
	private String reasonForRejection;
	public static final String STATUS_NEW = "New";
	public static final String STATUS_REVIEW = "Review";
	public static final String STATUS_EDIT = "Edit";
	public static final String STATUS_APPROVED = "Approved";
	public static final String STATUS_REJECTED = "Rejected";

	public PurchaseRequest() {
		id = 0;
		user = null;
		description = "";
		justification = "";
		dateNeeded = new Date(System.currentTimeMillis());
		deliveryMode = "";
		status = "New";
		total = 0.0;
		submittedDate = LocalDateTime.now();

	}

	public PurchaseRequest(int inID, User inUser, String inDescription, String inJustification, Date inDN,
			String inDlvMode, String inStatus, double inTotal, LocalDateTime inSubmitDate) {
		id = inID;
		user = inUser;
		description = inDescription;
		justification = inJustification;
		dateNeeded = inDN;
		deliveryMode = inDlvMode;
		status = inStatus;
		total = inTotal;
		submittedDate = inSubmitDate;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Date dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String statusDesc) {
		this.status = statusDesc;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getReasonForRejection() {
		return reasonForRejection;
	}

	public void setReasonForRejection(String reasonForRejection) {
		this.reasonForRejection = reasonForRejection;
	}

	@Override
	public String toString() {
		return "PurchaseRequest [id=" + id + ", user=" + user + ", description=" + description + ", justification="
				+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", status=" + status
				+ ", total=" + total + ", submittedDate=" + submittedDate + "]";
	}

}
