package com.spring.mvc2.data_transfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc2.data_transfer.dao.OrderDAO;
import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Controller
@RequestMapping("dTom")
public class DaoToMapper {

	@Autowired
	OrderDAO orderDAO;

	// DAO > Mapper 전송 예시1) 단일 데이터 전송
	@RequestMapping(value = "/insertData1")
	public String insertData1() {
		String productName = "장패드";
		orderDAO.insertOne(productName);
		return "redirect:/mTod/orderList";
	}
	
	// DAO > Mapper 전송 예시2) DTO 클래스 전송
	@RequestMapping(value = "/insertData2")
	public String insertData2() {
		
		OrderDTO oDto = new OrderDTO();
		oDto.setMemberId("임시유저1");
		oDto.setProductCode("임시상품코드1");
		oDto.setProductName("임시상품명1");
		orderDAO.insertDTO(oDto);
		
		return "redirect:/mTod/orderList";
	}
	
	// DAO > Mapper 전송 예시3) Map 데이터 전송
	@RequestMapping(value = "/insertData3")
	public String insertData3() {
		
		Map<String,String> orderMap = new HashMap<String, String>();
		orderMap.put("memberId" , "임시유저2");
		orderMap.put("productCode" , "임시상품코드2");
		orderMap.put("productName" , "임시상품명2");
		orderDAO.insertMap(orderMap);
		
		return "redirect:/mTod/orderList";
	}
	
}
