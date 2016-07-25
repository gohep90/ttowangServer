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

import ttowang.service.JaehoonService;

@Controller
public class JaehoonController {

	@Resource(name = "JaehoonService")
	private JaehoonService service;

	//json storeList형식 테스트
			@RequestMapping(value="/storeList.do")
			public ModelAndView storeList(Map<String, Object> commandMap)throws Exception {
				ModelAndView mv = new ModelAndView("jsonView");

				List<Map<String, Object>> list = service.selectStoreList(commandMap);
				mv.addObject("List", list);

				return mv;
			}
			
			//json storeList형식 테스트
			@RequestMapping(value="/searchStore.do")
			public ModelAndView searchStore(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
				ModelAndView mv = new ModelAndView("jsonView");
				String edt_search = request.getParameter("edt_search");
				
				commandMap.put("edt_search", edt_search);
				
				List<Map<String, Object>> list = service.selectSearchStore(commandMap);
				mv.addObject("List", list);

				return mv;
			}
					
					
			
			//json store형식 테스트
			@RequestMapping(value="/store.do")
			public ModelAndView store(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
				ModelAndView mv = new ModelAndView("jsonView");
				String index = request.getParameter("index");
				
			//	String index="1";
				commandMap.put("INDEX", index);
				
				List<Map<String, Object>> list = service.selectStore(commandMap);
				mv.addObject("List", list);
				return mv;
			}
			
			
			
			//json checkID
			@RequestMapping(value="/checkid.do")
				public ModelAndView checkId(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
					ModelAndView mv = new ModelAndView("jsonView");
					String email = request.getParameter("email");
					String name = request.getParameter("name");
						
				//	String email2 ="gohep30@naver.com";
				//	String name2	="박민수";
					commandMap.put("email", email);
					commandMap.put("name", name);
						
					System.out.println("checkId : "+email);
					List<Map<String, Object>> list = service.selectCheck(commandMap);
					mv.addObject("List", list);
					return mv;
				}
			
			//json stampList
			@RequestMapping(value="/stampList.do")
			public ModelAndView myStamp(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
				ModelAndView mv = new ModelAndView("jsonView");
				String phone = request.getParameter("phone");
					
			//	String email2 ="gohep30@naver.com";
			//	String name2	="박민수";
				commandMap.put("phone", phone);
					
				System.out.println("Phone : "+phone);
				List<Map<String, Object>> list = service.selectStampList(commandMap);
				mv.addObject("List", list);
				return mv;
			}
			
			
			
			
			//json stamp형식 테스트
					@RequestMapping(value="/stamp.do")
					public ModelAndView stamp(Map<String, Object> commandMap,HttpServletRequest request)throws Exception {
						ModelAndView mv = new ModelAndView("jsonView");
						String index = request.getParameter("index");
						String phone = request.getParameter("phone");
						
					//	String index="1";
						commandMap.put("index", index);
						commandMap.put("phone", phone);
						
						List<Map<String, Object>> list = service.selectStamp(commandMap);
						mv.addObject("List", list);
						return mv;
					}
					
					
					
					@RequestMapping("/plusStamp.do")
					public void plusStamp(HttpServletRequest request) throws Exception {
						Map<String, Object> map = new HashMap<String, Object>();

						String index = request.getParameter("index");
						String phone = request.getParameter("phone");

						map.put("index", index);
						map.put("phone", phone);

						service.updateStamp(map);
					}
					
					@RequestMapping("/deleteStamp.do")
					public void deleteStamp(HttpServletRequest request) throws Exception {
						Map<String, Object> map = new HashMap<String, Object>();

						String index = request.getParameter("index");
						String phone = request.getParameter("phone");

						map.put("index", index);
						map.put("phone", phone);

						service.deleteStamp(map);
					}
					
		
		

		//json data형식 테스트
		@RequestMapping(value="/jsonTest.do")
		public ModelAndView jsonTest(Map<String, Object> commandMap)throws Exception {
			ModelAndView mv = new ModelAndView("jsonView");

			List<Map<String, Object>> list = service.selectMemberList(commandMap);
			mv.addObject("list", list);

			return mv;
		}

		@RequestMapping("/main.do")
		public String memberMain() {
			return "main";
		}

		@RequestMapping("/insert.do")
		public void memberInput(HttpServletRequest request) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();

			String userTel = request.getParameter("phone");
			String userName = request.getParameter("name");
			String userBirth = request.getParameter("birthday");
			String userEmail = request.getParameter("email");
			String userGender = request.getParameter("gender");
			
			
			
			String userCode="1";

			System.out.println(userName);
			map.put("userName", userName);
			map.put("userEmail", userEmail);
			map.put("userGender", userGender);
			map.put("userBirth", userBirth);
			map.put("userTel", userTel);
			map.put("userCode", userCode);

			service.insertMember(map);
		}

		@RequestMapping("/delete.do")
		public void memberDelete(HttpServletRequest request) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();

			String name = request.getParameter("name");
			map.put("name", name);

			service.deleteMember(map);
		}
		
		
		
		
		
		@RequestMapping("/enrollStamp.do")
		public void enrollStamp(HttpServletRequest request) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();

			String index = request.getParameter("index");
			String phone = request.getParameter("phone");

			System.out.println(phone);
			map.put("index", index);
			map.put("phone", phone);

			service.insertEnrollStamp(map);
		}

}
