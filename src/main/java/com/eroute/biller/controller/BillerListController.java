package com.eroute.biller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eroute.biller.dto.BillerDTO;
import com.eroute.biller.service.BillerListService;

@RestController
@RequestMapping("/biller-list")
public class BillerListController {

	@Autowired
	private	BillerListService billerListService;
	
	@PostMapping(value = "/search", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<BillerDTO>> getBillerList(@RequestBody String name) {
		List<BillerDTO> billerList = billerListService.getBillerList(name);
		if (billerList != null && billerList.size() > 0) {
			return new ResponseEntity<>(billerList, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
