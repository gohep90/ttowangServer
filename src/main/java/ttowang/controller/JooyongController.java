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
				
				//commandMap.put("businessId", businessId);
				
				//테스트용  Id = 1
				commandMap.put("businessId", "1");
	
				List<Map<String, Object>> list = service.businessView(commandMap);
				mv.addObject("List", list);
				System.out.println("businessView 성공");
				return mv;
				
			}catch(Exception e){
				
				System.out.println("businessView 실패");
				return null;
				
			}
		}
				
		//가맹점 등록
		//정보 받으면 등록
		@RequestMapping("/businessAdd.do")
		public void businessAdd(HttpServletRequest request) throws Exception {
			
			try{
				String businessLicense = request.getParameter("businessLicense");
				String businessName = request.getParameter("businessName");
				String businessTel = request.getParameter("businessTel");
				String businessInfo = request.getParameter("businessInfo");
				String businessTime = request.getParameter("businessTime");
				String businessAddress = request.getParameter("businessAddress");
				String businessMenu = request.getParameter("businessMenu");
				String businessBenefit = request.getParameter("businessBenefit");
				String businessPhoto = request.getParameter("businessPhoto");
				String businessLat = request.getParameter("businessLat");
				String businessLng = request.getParameter("businessLng");
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("businessLicense", businessLicense);
				map.put("businessName", businessName);
				map.put("businessTel", businessTel);
				map.put("businessInfo", businessInfo);
				map.put("businessTime", businessTime);
				map.put("businessAddress", businessAddress);
				map.put("businessMenu", businessMenu);
				map.put("businessBenefit", businessBenefit);
				map.put("businessPhoto", businessPhoto);
				map.put("businessLat", businessLat);
				map.put("businessLng", businessLng);
				
				service.businessAdd(map);
				
				System.out.println("businessAdd 성공");
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("businessAdd 실패");
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
				String businessPhoto = request.getParameter("businessPhoto");
				String businessLat = request.getParameter("businessLat");
				String businessLng = request.getParameter("businessLng");
				
	
				map.put("businessId", businessId);
				map.put("businessLicense", businessLicense);
				map.put("businessName", businessName);
				map.put("businessTel", businessTel);
				map.put("businessInfo", businessInfo);
				map.put("businessTime", businessTime);
				map.put("businessAddress", businessAddress);
				map.put("businessMenu", businessMenu);
				map.put("businessBenefit", businessBenefit);
				map.put("businessPhoto", businessPhoto);
				map.put("businessLat", businessLat);
				map.put("businessLng", businessLng);
				
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
				mv.addObject("List", list);
				
				System.out.println("businessSearch 성공");
				return mv;
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("businessSearch 실패");
				return null;
			}
		}

}
