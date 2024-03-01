package com.nisum.controller.dto.mapper;

public interface ResponseMapper<R,M> {

	public R getApiModel(M model);
	
	public default M getModel(R response) {
		return null;
	}
}
