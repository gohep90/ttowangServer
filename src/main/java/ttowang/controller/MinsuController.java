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
	
	//전화번호를 통한 (정회원)스템프 적립
	@RequestMapping(value="/addStamp.do")
	public void addStamp(HttpServletRequest request)throws Exception {
			
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			
			String businessId=request.getParameter("businessId");
			String userTel=request.getParameter("userTel");
			String count=request.getParameter("stampNum");
			
			map.put("businessId", businessId);
			map.put("userTel", userTel);
			
			if(service.selectCheck(map)==null){// 정회원인지 확인!!  정회원이 아니라면(준회원)
				service.insertUser(map);	//준회원 등록
				service.insertJunMembership(map);	//준회원 멤버쉽 등록!!
			}

			//여러게 스템프 적립시!!
			for(int i=0;i<Integer.parseInt(count);i++){
				service.insertAddStamp(map);
			}
					
			System.out.println("addStamp 성공");
		}catch(Exception e){
			System.out.println("addStamp 실패");
		}
	}
	

}
