package ttowang.controller;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	
	
	@RequestMapping(value="/giftStamp.do")
    public ModelAndView giftStamp(Map<String, Object> map,HttpServletRequest request) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	try {
    		String userId = request.getParameter("userId");
    		String businessId = request.getParameter("businessId");
    		String userTel = request.getParameter("userTel");
    		String stampNumber = request.getParameter("stampNumber");
    		String result="초기";
    		
    		
    		map.put("userId", userId);
    		map.put("businessId", businessId);
    		map.put("userTel", userTel);
    		map.put("stampNumber", Integer.parseInt(stampNumber));
    		
    		        
    		//System.out.println("map에 넣기 성공 " + userId + " " +businessId+ " " +userTel+ " " +stampNumber);
    		
    		//선물할 스탬프 개수보다 내 스탬프 개수가 적으면
    		if(Integer.parseInt(service.selectCheckStampNeed(map)) < Integer.parseInt(stampNumber)){
    			System.out.println("스탬프 부족");
    			result = "스탬프 부족";
    			mv.addObject("result",result);
    			return mv;
	        }
    		
    		System.out.println("스탬프 개수 가져오기 성공");
    		
    		//상대 전화번호를 통해서 유저 아이디 찾기
    		if(service.searchUserIdByTel(map) == null){
    			System.out.println("전화번호 검색 실패");
    			result = "전화번호 없음";
	        	mv.addObject("result",result);
	        	return mv;
	        	
	        }else{
	        	
	        	System.out.println("전화번호 검색 성공");
	        	
	        	service.deleteStamp(map);
	        	System.out.println("내 스탬프 삭제 성공");
	        	
				//스탬프 추가
	        	for(int i=0; i < Integer.parseInt(stampNumber); i++){
					service.insertAddStamp(map);
				}
	        	
	    		result="선물 성공";
	        }
    		
	        mv.addObject("result",result);
	        System.out.println("스탬프 선물 성공");
	        
    	} catch (Exception e) {
    		mv.addObject("result","선물 실패");
    		
    		System.out.println("스탬프 선물 실패");
    	}
    	
    	return mv;
    }
	
	
	
	//// redirect 해서 다시 받아야함
	//파일 업로드(insert DB)
	@RequestMapping(value="/uploadFile.do")
	public ModelAndView  uploadFile(MultipartHttpServletRequest request)throws Exception {
	
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, MultipartFile> files = request.getFileMap();
		Map<String, Object> map = new HashMap<String, Object>();
		CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadfile");
		
		String filename=cmf.getOriginalFilename();
				
		String savePath ="C:/Users/Park/workspace/ttowang/src/main/webapp/image/"+filename;
		File file = new File(savePath);
		cmf.transferTo(file);	//파일 업로드처리
		
		String businessName = request.getParameter("businessName");
		//String year = request.getParameter("year");
		//String month = request.getParameter("month");
		//String day = request.getParameter("day");
		
		System.out.println("filename:  "+filename);
		System.out.println("businessName:  "+businessName);
						
		//map.put("filename", filename);
		//map.put("email", email);
		//map.put("year", year);
		//map.put("month", month);
		//map.put("day", day);
					
		//service.updateFile(map);
		return mv;
		
	}
	
	
	//파일 다운로드
	@RequestMapping("/downloadFile.do")
	public void downloadFile(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String fileName = URLDecoder.decode(request.getParameter("fileName"),"utf-8");
		String client = request.getHeader("User-Agent");
		boolean ie = client.indexOf("MSIE") > -1;
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:/apache-tomcat-8.0.36/webapps/ROOT/ttowang/"+fileName));
		
		response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    
	    //IE
	    if(ie){
	    	fileName = URLEncoder.encode(fileName, "euc-kr");
	    }else{
	    	fileName=new String(fileName.getBytes("euc-kr"),"iso-8859-1");
	    }
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	
	
	
	
}
