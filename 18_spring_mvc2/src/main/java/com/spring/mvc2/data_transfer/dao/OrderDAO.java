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
	
	public List<OrderDTO> selectAllData(){
		return sqlSession.selectList("order.selectAll");
	}
	
	// Mapper > DAO전송 예시  1)단일 데이터 전송
	public int selectData1() {
		return sqlSession.selectOne("order.select1");
	}
	
	// Mapper > DAO전송 예시  2) DTO 전송
	public List<OrderDTO> selectData2() {
		return sqlSession.selectList("order.select2");
	}
	
	// Mapper > DAO전송 예시  3) Map 전송
	public List<Map<String, Object>> selectData3() {
		return sqlSession.selectList("order.select3");
	}
	
	
	
}
