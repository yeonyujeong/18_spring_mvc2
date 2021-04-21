package com.spring.mvc2.data_transfer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc2.data_transfer.dao.MemberDAO;

@Controller
@RequestMapping("cTov")
public class ControllerToView {

	@Autowired
	MemberDAO memberDAO;
	
	/*
	 * 
	 *  예시 1) Model
	 *  
	 *  메서드의 파라미터로 Model을 추가하여 addAddtribute() 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */
	@RequestMapping(value="/list1")
	public String list1(Model model) {
		model.addAttribute("from" , "list1"); // memberList에 어떤방식으로 받은건지 보여주기용
		model.addAttribute("memberList" , memberDAO.selectAllMember());
		return "member/memberList";
	}
	
	
	/*
	 * 예시 2) ModelAndView 클래스 이용
	 * 
	 * ModelAndView객체를 생성하여  addObject() 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 관용적으로 객체명으로 mv 혹은 mav로 작성한다.
	 * 
	 * */
	@RequestMapping(value="/list2")
	public ModelAndView list2() {	// return 타입은 String이 아닌 ModelAndView 클래스
		
		ModelAndView mv = new ModelAndView();	// ModelAndView 객체생성
		mv.setViewName("member/memberList");	// 포워딩할 jsp 파일명 작성
		
		// setViewName 메서드 대신 생성자의 인수로 jsp 페이지명을 지정할 수 있다.
		//ModelAndView mv2 = new ModelAndView("member/memberList"); 
		
		mv.addObject("from", "list2");			// addObject 메서드를 이용하여 데이터 전송
		mv.addObject("memberList" , memberDAO.selectAllMember());
		
		return mv;//??		순서?						// ModelAndView 객체를 반환
		
	}
	
	// 예시 3) httpServeletRequest 인터페이스 이용
	@RequestMapping("/list3")
	public String list3(HttpServletRequest request) {
		request.setAttribute("from", "list3");
		request.setAttribute("memberList", memberDAO.selectAllMember());
		return "member/memberList";
	}
	
	
}
