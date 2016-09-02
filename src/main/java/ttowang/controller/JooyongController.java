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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ttowang.service.JooyongService;


@Controller
public class JooyongController {

	@Resource(name = "JooyongService")
	private JooyongService service;

	
		//가맹점 리스트
		//모든 가맹점 상세 정보를 출력한다.
		@RequestMapping(value="/businessList.do")
		public ModelAndView businessList(Map<String, Object> commandMap)throws Exception {
			
			try{
				ModelAndView mv = new ModelAndView("jsonView");

				List<Map<String, Object>> list = service.selectbusinessList(commandMap);
				mv.addObject("businessList", list);
	
				System.out.println("businessList 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("businessList 실패");
				return null;
			}
		}
		
		//가맹점 상세정보
		//businessId를 받으면 businessId의 상세 정보 뿌려줌
		@RequestMapping(value="/businessView.do",method= RequestMethod.POST)
		public ModelAndView businessView(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				
				ModelAndView mv = new ModelAndView("jsonView");
				
				String businessId = request.getParameter("businessId");
				
				commandMap.put("businessId", businessId);
	
				List<Map<String, Object>> list = service.businessView(commandMap);
				List<Map<String, Object>> photo = service.businessPhoto(commandMap);
				
				mv.addObject("List", list);
				mv.addObject("Photo", photo);
				
				
				System.out.println("businessView 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("businessView 실패");
				return null;
				
			}
		}
		
		
		
		
		//가맹점 등록
		//정보 받으면 등록하고 비즈니스 아이디 리턴 해주기 
		@RequestMapping(value="/businessAdd.do",method= RequestMethod.POST)
		public ModelAndView businessAdd(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				
				ModelAndView mv = new ModelAndView("jsonView");
				
				String businessLicense = request.getParameter("businessLicense");
				String businessName = request.getParameter("businessName");
				String businessTel = request.getParameter("businessTel");
				String businessInfo = request.getParameter("businessInfo");
				String businessTime = request.getParameter("businessTime");
				String businessAddress = request.getParameter("businessAddress");
				String businessMenu = request.getParameter("businessMenu");
				String businessBenefit = request.getParameter("businessBenefit");
				
				String businessLat = request.getParameter("businessLat");
				String businessLng = request.getParameter("businessLng");
				String userId = request.getParameter("userId");
				String businessType = request.getParameter("businessType");
			
				String businessGroup = request.getParameter("businessGroup");
				System.out.println("businessAdd 데이터 받아옥 성공");
			
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("businessLicense", businessLicense);
				map.put("businessName", businessName);
				map.put("businessTel", businessTel);
				map.put("businessInfo", businessInfo);
				map.put("businessTime", businessTime);
				map.put("businessAddress", businessAddress);
				map.put("businessMenu", businessMenu);
				map.put("businessBenefit", businessBenefit);
				
				map.put("businessLat", businessLat);
				map.put("businessLng", businessLng);
				map.put("userId", userId);
				map.put("businessType", businessType);
				
				map.put("businessGroup", businessGroup);
				
				System.out.println("businessAdd map 넣기성공");
				
				service.businessAdd(map);
				
				System.out.println("businessAdd 디비 넣기 성공");
				
				commandMap.put("businessLicense", businessLicense);
				commandMap.put("businessName", businessName);
				commandMap.put("userId", userId);
				
				System.out.println("businessAdd commandMap 넣기 성공");
				
				List<Map<String, Object>> list = service.businessAddplus(commandMap);
				System.out.println("businessAdd 아이디 받아오기 성공");
				
				mv.addObject("List", list);
				
				
				System.out.println("businessAdd 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("businessAdd 실패");
				return null;
				
			}
		}
		
		
		//가맹점 수정
		//우선 가맹점 상세정보를 businessId로 받은 다음에 정보를 입력하면 businessId를 찾아서 정보 삽입
		@RequestMapping("/businessUpdate.do")
		public void businessUpdate(HttpServletRequest request) throws Exception {
		
			try{
			
				Map<String, Object> map = new HashMap<String, Object>();
				
				String businessId = request.getParameter("businessId");
				String businessLicense = request.getParameter("businessLicense");
				String businessName = request.getParameter("businessName");
				String businessTel = request.getParameter("businessTel");
				String businessInfo = request.getParameter("businessInfo");
				String businessTime = request.getParameter("businessTime");
				String businessAddress = request.getParameter("businessAddress");
				String businessMenu = request.getParameter("businessMenu");
				String businessBenefit = request.getParameter("businessBenefit");
				
				String businessLat = request.getParameter("businessLat");
				String businessLng = request.getParameter("businessLng");
				String userId = request.getParameter("userId");
				String businessType = request.getParameter("businessType");
				
				String businessGroup = request.getParameter("businessGroup");
				
				map.put("businessId", businessId);
				map.put("businessLicense", businessLicense);
				map.put("businessName", businessName);
				map.put("businessTel", businessTel);
				map.put("businessInfo", businessInfo);
				map.put("businessTime", businessTime);
				map.put("businessAddress", businessAddress);
				map.put("businessMenu", businessMenu);
				map.put("businessBenefit", businessBenefit);
				
				map.put("businessLat", businessLat);
				map.put("businessLng", businessLng);
				map.put("userId", userId);
				map.put("businessType", businessType);
				
				map.put("businessGroup", businessGroup);
				
				service.businessUpdate(map);
				System.out.println("businessUpdate 성공");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("businessUpdate 실패");
			}
		}
				
		//가맹점 검색	
		//키워드를 받아서 businessName에 키워드가 있는놈 출력
		@RequestMapping(value="/businessSearch.do")
		public ModelAndView businessSearch(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				ModelAndView mv = new ModelAndView("jsonView");
				String businessKeyword = request.getParameter("businessId");
				
				commandMap.put("businessKeyword", businessKeyword);
	
				List<Map<String, Object>> list = service.businessSearch(commandMap);
				mv.addObject("businessSearch", list);
				
				
				System.out.println("businessSearch 성공");
				return mv;
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("businessSearch 실패");
				return null;
			}
		}
		
		
		//내 모든 가맹점 정보
		//businessId를 받으면 businessId의 상세 정보 뿌려줌
		@RequestMapping(value="/businessAll.do",method= RequestMethod.POST)
		public ModelAndView businessAll(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				
				ModelAndView mv = new ModelAndView("jsonView");
				
				String userId = request.getParameter("userId");
				
				commandMap.put("userId", userId);
	
				List<Map<String, Object>> list = service.businessAll(commandMap);
				List<Map<String, Object>> photo = service.businessAllPhoto(commandMap);
				
				mv.addObject("List", list);
				mv.addObject("Photo", photo);
				
				
				System.out.println("businessAll 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("businessAll 실패");
				return null;
				
			}
		}
//////////////////////////////////////////////////////////////////////////////////////////
		
		//모든 쿠폰 리스트
		//모든 쿠폰 상세 정보를 출력한다.
		@RequestMapping(value="/couponList.do")
		public ModelAndView couponList(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				ModelAndView mv = new ModelAndView("jsonView");
				
				String businessId = request.getParameter("businessId");
				commandMap.put("businessId", businessId);

				List<Map<String, Object>> list = service.selectcouponList(commandMap);
				mv.addObject("couponList", list);
	
				System.out.println("couponList 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("couponList 실패");
				return null;
			}
		}
		
		//해당 가맹점 쿠폰 상세정보
		//businessId를 받으면 해당 가맹점의 쿠폰 상세 정보 뿌려줌
		@RequestMapping(value="/couponView.do",method= RequestMethod.POST)
		public ModelAndView couponView(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
			
			try{
				
				ModelAndView mv = new ModelAndView("jsonView");
				
				String businessId = request.getParameter("businessId");
				
				commandMap.put("businessId", businessId);
	
				List<Map<String, Object>> list = service.couponView(commandMap);
				mv.addObject("List", list);
				System.out.println("couponView 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("couponView 실패");
				return null;
				
			}
		}
		
		//쿠폰 등록
		//businessId와 couponCode를 입력하면 쿠폰 등록
		@RequestMapping("/couponAdd.do")
		public void couponAdd(HttpServletRequest request) throws Exception {
			
			try{
				String businessId = request.getParameter("businessId");
				String couponName = request.getParameter("couponName");
				String stampNeed = request.getParameter("stampNeed");
				
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("businessId", businessId);
				map.put("couponName", couponName);
				map.put("stampNeed", stampNeed);
				
				service.couponAdd(map);
				
				System.out.println("couponAdd 성공");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("couponAdd 실패");
			}
		}
		
		//쿠폰 수정
		//우선 가맹점 상세정보를 businessId로 받은 다음에 정보를 입력하면 businessId를 찾아서 정보 삽입
		@RequestMapping("/couponUpdate.do")
		public void couponUpdate(HttpServletRequest request) throws Exception {
		
			try{
			
				Map<String, Object> map = new HashMap<String, Object>();
				
				String businessId = request.getParameter("businessId");
				String couponCode = request.getParameter("couponCode");
				String couponName = request.getParameter("couponName");
				String stampNeed = request.getParameter("stampNeed");
	
				map.put("businessId", businessId);
				map.put("couponCode", couponCode);
				map.put("couponName", couponName);
				map.put("stampNeed", stampNeed);
				
				service.couponUpdate(map);
				System.out.println("couponUpdate 성공");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("couponUpdate 실패");
			}
		}
		
		//쿠폰 수정
		//우선 가맹점 상세정보를 businessId로 받은 다음에 정보를 입력하면 businessId를 찾아서 정보 삽입
		@RequestMapping("/couponDelete.do")
		public void couponDelete(HttpServletRequest request) throws Exception {
		
			try{
			
				Map<String, Object> map = new HashMap<String, Object>();
				
				String businessId = request.getParameter("businessId");
				String couponCode = request.getParameter("couponCode");
	
				map.put("businessId", businessId);
				map.put("couponCode", couponCode);
				
				service.couponDelete(map);
				System.out.println("couponDelete 성공");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("couponDelete 실패");
			}
		}	
		
		
		
		
		//직원 추가
		@RequestMapping("/staffAdd.do")
	    public ModelAndView staffAdd(Map<String, Object> map,HttpServletRequest request) throws Exception{
	    	ModelAndView mv = new ModelAndView("jsonView");
	    	
	    	try {
    			
				String businessId = request.getParameter("businessId");
				String userTel = request.getParameter("userTel");
				String result = "";
				
				map.put("businessId", businessId);
				map.put("userTel", userTel);
				
				if(service.searchUserIdByTel(map) == null){	//대상이 없음
	    			System.out.println("전화번호 검색 실패");
	    			result = "전화번호 없음";
		        	mv.addObject("result",result);
		        	return mv;
		        	
		        }else{	//대상이 있음
		        	
					if(service.searchStaffByTel(map)== null){	//등록 할 수 있음
						System.out.println("staff 등록 안됨");
						service.staffAdd(map);	//직원 등록
						result = "staffAdd 성공";
				        mv.addObject("result",result);
				        return mv;
					}else{
						System.out.println("이미 staff 등록 됨");	//이미 등록 됨
						result = "이미 직원";
				        mv.addObject("result",result);
				        return mv;
					}
		        }   
	    	} catch (Exception e) {
	    		mv.addObject("result","staffAdd 실패");	
	    		System.out.println("staffAdd 실패");
	    	}
	    	return mv;
	    }
		
		/*
		//직원 추가
		@RequestMapping("/searchAllMyStaff.do")
	    public ModelAndView searchAllMyStaff(Map<String, Object> map,HttpServletRequest request) throws Exception{
	    	ModelAndView mv = new ModelAndView("jsonView");
	    	
	    	try {
    			
				String userId = request.getParameter("userId");
				map.put("userId", userId);
				List<Map<String, Object>> list;
				
				if((list = service.searchAllMyStaff(map)) == null){	//직원 없음
	    			System.out.println("직원 없음");
	    			mv.addObject("result","직원 없음");
		        	return mv;
		        	
		        }else{	//직원 있음
		        	list = service.searchAllMyStaff(map);
		        	System.out.println("직원 있음");
		        	mv.addObject("result","직원 있음");
		        	mv.addObject("List", list);
	        	
			        return mv;
		        }   
	    	} catch (Exception e) {
	    		mv.addObject("result","직원찾기 실패");	
	    		System.out.println("직원찾기 실패");
	    	}
	    	return mv;
	    }
	    */
		
		//직원 가져오기
		@RequestMapping("/searchAllMyStaff.do")
	    public ModelAndView searchAllMyStaff(Map<String, Object> map,HttpServletRequest request) throws Exception{
	    	ModelAndView mv = new ModelAndView("jsonView");
	    	
	    	try {
    			
				String businessId = request.getParameter("businessId");
				map.put("businessId", businessId);
				List<Map<String, Object>> list;
				
				if((list = service.searchAllMyStaff(map)) == null){	//직원 없음
	    			System.out.println("직원 없음");
	    			mv.addObject("result","직원 없음");
		        	return mv;
		        	
		        }else{	//직원 있음
		        	System.out.println("직원 있음");
		        	mv.addObject("result","직원 있음");
		        	mv.addObject("List", list);
	        	
			        return mv;
		        }   
	    	} catch (Exception e) {
	    		mv.addObject("result","직원찾기 실패");	
	    		System.out.println("직원찾기 실패");
	    	}
	    	return mv;
	    }
		
		//직원 추가
		@RequestMapping("/staffDel.do")
	    public ModelAndView staffDel(Map<String, Object> map,HttpServletRequest request) throws Exception{
	    	ModelAndView mv = new ModelAndView("jsonView");
	    	
	    	try {
    			
				String businessId = request.getParameter("businessId");
				String userId = request.getParameter("userId");
				
				map.put("businessId", businessId);
				map.put("userId", userId);
				
				service.staffDel(map);
				
		        mv.addObject("result","staffDel 성공");
			
		        return mv;
			   
	    	} catch (Exception e) {
	    		mv.addObject("result","staffDel 실패");	
	    		System.out.println("staffDel 실패");
	    	}
	    	return mv;
	    }
		

}
