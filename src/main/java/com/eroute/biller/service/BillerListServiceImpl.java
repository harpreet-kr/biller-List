package com.eroute.biller.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.eroute.biller.dto.BillerDTO;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class BillerListServiceImpl implements BillerListService {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	WebClient webClient = WebClient.builder().baseUrl("http://103.210.73.96:8080/bbps/bbps").build();

	public String getResponseFromAPI(String agentID) {
		return webClient.post()
				.uri(uriBuilder -> uriBuilder.path("/getBillers/").queryParam("agentID", agentID).build()).retrieve()
				.bodyToMono(String.class).block();
	}

	@Override
	public List<BillerDTO> getBillerList(String name) {
		List<BillerDTO> billerDtoList = new ArrayList<BillerDTO>(); 
		String agentBillersList = getResponseFromAPI("AGT05082020064F67");
		System.out.println("getAgentBillersList:::" + agentBillersList);
		ObjectMapper mapper = new ObjectMapper();
		// convert to json object
		try {
			JsonNode jsonNode = mapper.readTree(agentBillersList).get("resultObj").get(0);
			String resultObj = jsonNode.toString();
			Gson gsonFormat = new Gson();
			String jsonResultObj = gsonFormat.fromJson(resultObj, String.class);
			JsonFactory factory = mapper.getJsonFactory();
				JsonParser parser = factory.createJsonParser(jsonResultObj);	
				JsonNode actualObj = (JsonNode) mapper.readTree(parser).get("Biller");	 
				if (actualObj.isArray()) {
				    for (final JsonNode objNode : actualObj) {
				    	String blrName = objNode.get("BlrName").textValue().trim();				    	
						BillerDTO billerDTO = new BillerDTO();
				    	if(StringUtils.startsWithIgnoreCase(blrName, name)) {
				    		System.out.println("Matching Biller :: "+objNode);
				    		billerDTO.setBlrName(objNode.get("BlrName").textValue());
				    		billerDTO.setAdhocPayment(objNode.get("AdhocPayment").asInt());
				    		billerDTO.setBillerDescription(objNode.get("BillerDescription").textValue());
				    		billerDTO.setBlrId(objNode.get("BlrId").textValue());
				    		billerDTO.setBillerValue(objNode.get("BillerValue").textValue());
				    		billerDTO.setSupportBillValidation(objNode.get("SupportBillValidation").textValue());
				    		billerDTO.setBlrCatName(objNode.get("BlrCatName").textValue());
				    		billerDTO.setBlrCatId(objNode.get("BlrCatId").asInt());
				    		billerDTO.setBillAcceptanceType(objNode.get("BillAcceptanceType").asInt());
				    		billerDTO.setPaymentAmtExactness(objNode.get("PaymentAmtExactness").textValue());
					    	billerDtoList.add(billerDTO);
				    	}
				    }
				}
		} catch (IOException e) {
			System.out.println("Exception in getting response from API :: "+e.getMessage());
		}
		return billerDtoList;
	}

}