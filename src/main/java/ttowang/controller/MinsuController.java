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

import ttowang.service.MinsuService;

@Controller
public class MinsuController {

	@Resource(name = "MinsuService")
	private MinsuService service;
	
	//전화번호를 통한 스템프 적립
	//등록 안되있을 경우 준회원으로 회원가입!!
	@RequestMapping(value="/userTest.do")
	public ModelAndView userTest(Map<String, Object> map)throws Exception {
		
		try{
			ModelAndView mv = new ModelAndView("jsonView");
			List<Map<String, Object>> list = service.selectUserTest(map);
			mv.addObject("userTest", list);
		
			System.out.println("userTest 성공");
			return mv;
					
		}catch(Exception e){
			System.out.println("userTest 실패");
			return null;
		}
	}
	
	

}
