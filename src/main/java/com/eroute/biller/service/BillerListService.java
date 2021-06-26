package com.eroute.biller.service;

import java.util.List;

import com.eroute.biller.dto.BillerDTO;


public interface BillerListService {
	public List<BillerDTO> getBillerList(String name);
}
