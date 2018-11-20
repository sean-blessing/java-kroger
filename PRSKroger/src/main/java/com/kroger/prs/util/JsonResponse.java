package com.kroger.prs.util;

import java.util.ArrayList;


public class JsonResponse {

	private Object data = null;
	private Object errors = null;
	private Object meta = null;

	// Good response - single resource
	public JsonResponse(Object d) {
		data = d;
		meta = new ArrayList<>();
	}
	
	// 500 / error response
	public JsonResponse(Exception e) {
		errors = e;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	public Object getMeta() {
		return meta;
	}

	public void setMeta(Object meta) {
		this.meta = meta;
	}

	public static JsonResponse getInstance(Object d) {
		return new JsonResponse(d);
	}

	public static JsonResponse getInstance(Exception e) {
		return new JsonResponse(e);
	}

}