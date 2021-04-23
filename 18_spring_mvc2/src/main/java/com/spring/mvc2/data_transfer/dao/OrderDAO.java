package com.spring.mvc2.data_transfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// DAO > Mapper 전송 예시1) 단일 데이터 전송
	public void insertOne(String productName) {
		sqlSession.insert("order.insertOneData" , productName);
	}

	// DAO > Mapper 전송 예시2) DTO 클래스 전송
	public void insertDTO(OrderDTO oDto) {
		sqlSession.insert("order.insertDTO" , oDto);
	}
	
	// DAO > Mapper 전송 예시3) Map 데이터 전송
	public void insertMap(Map<String, String> orderMap) {
		sqlSession.insert("order.insertMap",orderMap);
	}
	
	
	public List<OrderDTO> selectAllData() {
		return sqlSession.selectList("order.selectAll");
	}
	
	// Mapper > DAO 전송 예시1) 단일 데이터 전송
	public int selectData1() {
		return sqlSession.selectOne("order.select1");
	}
	
	// Mapper > DAO 전송 예시2) DTO 전송
	public List<OrderDTO> selectData2() {
		return sqlSession.selectList("order.select2");
	}
	
	// Mapper > DAO 전송 예시3) Map 전송
	public List<Map<String,Object>> selectData3() {
		return sqlSession.selectList("order.select3");
	}
	
	// Mapper > DAO 전송 예시4) Map 전송
	public List<Map<String,Object>> selectData4() {
		return sqlSession.selectList("order.select4");
	}
	
}
