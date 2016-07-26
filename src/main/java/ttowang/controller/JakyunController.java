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
		// userCode=0 -> 준회원
		
		//준회원도 아닌 경우
		if(service.checkCode(map) == null) {
			map.put("userCode", 1);
			service.insertUser(map);
		}
		
		//준회원인 경우
		else {
			service.updateUser(map);
		}
	}	
}
