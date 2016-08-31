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
	
	
	@RequestMapping(value="/userTest.do")
	public ModelAndView userTest(Map<String, Object> map)throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list =null;
		
		try{
			list = service.selectUserTest(map);
			mv.addObject("userTest", list);
		
			System.out.println("userTest 성공");
			return mv;
					
		}catch(Exception e){
			System.out.println("userTest 실패");
			return null;
		}
	}
	
	//전화번호를 통한 스템프 적립
	//등록 안되있을 경우 준회원으로 회원가입!!
	//전화번호를 통한 (정회원)스템프 적립
	@RequestMapping(value="/addStamp.do")
	public void addStamp(HttpServletRequest request)throws Exception {
			
		Map<String, Object> map = new HashMap<String, Object>();
		
		String businessId=request.getParameter("businessId");
		String userTel=request.getParameter("userTel");
		String count=request.getParameter("stampNum");
		
		try{
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
	
	
	//(스피너) 내가 등록한 가맹점 리스트
	@RequestMapping(value="/spinnerList.do")
	public ModelAndView spinnerList(Map<String, Object> map, HttpServletRequest request)throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> list =null;
		String userId=request.getParameter("userId");
		
		try{
			map.put("userId", userId);
			list = service.selectSpinnerList(map);
			mv.addObject("spinnerList", list);
		
			System.out.println("spinnerList 성공");
			return mv;
					
		}catch(Exception e){
			System.out.println("spinnerList 실패");
			return null;
		}
	}
	
	// 스탬프 쿠폰 전환
	@RequestMapping(value="/stampToCoupon.do")
    public ModelAndView stampToCoupon(Map<String, Object> map,HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String couponCode = request.getParameter("couponCode");
		String stampNeed = request.getParameter("stampNeed");
		String couponNum = businessId + (System.currentTimeMillis()%10000);
		String result="초기";
		
    	try {
    		map.put("userId", userId);
    		map.put("businessId", businessId);
    		map.put("couponCode", couponCode);
    		map.put("stampNeed", Integer.parseInt(stampNeed));
    		map.put("couponNum", couponNum);
    		
    		if(Integer.parseInt(service.selectCheckStampNeed(map)) < Integer.parseInt(stampNeed)){
    			result="필요한 스탬프가 부족합니다.";
	        }else{
	        	service.insertUserCoupon(map);   
	    		service.updateStampList(map);
	        	result="쿠폰 전환이 완료되었습니다.";
	        }
	        mv.addObject("result",result);
	        
    	} catch (Exception e) {}
    	
    	return mv;
    }
	
	
	// 스탬프 선물
	@SuppressWarnings("unused")
	@RequestMapping(value="/giftStamp.do")
    public ModelAndView giftStamp(Map<String, Object> map,HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	String userId = request.getParameter("userId");
		String businessId = request.getParameter("businessId");
		String userTel = request.getParameter("userTel");
		String result="초기";
    	
    	try {
    		map.put("userId", userId);
    		map.put("businessId", businessId);
    		map.put("userTel", userTel);
    		
    		if(1 < 2){
    			result="필요한 스탬프가 부족합니다.";
	        }else{
	        	service.insertUserCoupon(map);   
	    		service.updateStampList(map);
	        	result="쿠폰 전환이 완료되었습니다.";
	        }
	        mv.addObject("result",result);
	        
    	} catch (Exception e) {}
    	
    	return mv;
    }
	
}
