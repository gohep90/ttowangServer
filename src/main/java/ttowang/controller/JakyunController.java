package ttowang.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ttowang.service.JakyunService;

@Controller
public class JakyunController {

	@Resource(name = "JakyunService")
	private JakyunService service;
	
	//정회원은 회원가입 없이 바로 어플이용
	//준회원이거나 회원이 아닌 사람들은 회원가입
	@RequestMapping(value="/checkUser.do")
	public ModelAndView checkUser(Map<String, Object> commandMap, HttpServletRequest request)throws Exception {		
		try{
			ModelAndView mv = new ModelAndView("jsonView");
			
			String userTel = request.getParameter("userTel");
			
			commandMap.put("userTel", userTel);
			
			List<Map<String, Object>> list = service.checkUser(commandMap);
			mv.addObject("checkUser", list);
			
			System.out.println("checkUser 성공");
			return mv;
					
		}catch(Exception e){
			System.out.println("checkUser 실패");
			return null;
		}
	}
	
	//준회원은 있던 번호에 userName, userBirth, userGender, userCode, userEmail 업데이트
	//회원이 아닌 사람들은 추가(userTel, userName, userBirth, userGender, userCode, userEmail)
	@RequestMapping("/insertUser.do")
	public void insertUser(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		String userTel = request.getParameter("userTel");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		map.put("userTel", userTel);
		map.put("userName", userName);
		map.put("userBirth", userBirth);
		map.put("userGender", userGender);
		map.put("userEmail", userEmail);

		// userCode=1 -> 정회원
		// userCode=4 -> 준회원
		
		//회원이 아닌 경우
		if(service.checkCode(map) == null) {
			map.put("userCode", 1);
			service.insertUser(map);
			System.out.println("insertUser 성공");
		}
		
		//준회원인 경우
		else {
			service.updateUser(map);
			System.out.println("updateUser 성공");
		}
	}	
	
	@RequestMapping("/myInfoEdit.do")
	public void myIndoEdit(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		String userTel = request.getParameter("userTel");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		map.put("userTel", userTel);
		map.put("userName", userName);
		map.put("userBirth", userBirth);
		map.put("userGender", userGender);
		map.put("userEmail", userEmail);
		
		System.out.println("myInfoEdit 성공");
		
		service.myInfoEdit(map);
	}
	
	@RequestMapping(value="/checkTel.do")
	public ModelAndView checkTel(Map<String, Object> commandMap, HttpServletRequest request)throws Exception {		
		try{
			ModelAndView mv = new ModelAndView("jsonView");
			
			String tel = request.getParameter("tel");
			
			commandMap.put("tel", tel);
			
			System.out.println(tel);
			
			List<Map<String, Object>> list = service.checkTel(commandMap);
			mv.addObject("checkTel", list);
			
			System.out.println(list);
			
			System.out.println("checkTel 성공");
			return mv;
					
		}catch(Exception e){
			System.out.println("checkTel 실패");
			return null;
		}
	}
}
