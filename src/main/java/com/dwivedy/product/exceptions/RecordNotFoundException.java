package com.dwivedy.product.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String record) {
		super("No such " + record + " record found");
	}

	public RecordNotFoundException(Long id) {
		super("No such " + id + " id found");
	}
}