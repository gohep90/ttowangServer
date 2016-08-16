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

import ttowang.service.JieunService;

@Controller
public class JieunController {

	@Resource(name = "JieunService")
	private JieunService service;
     
	/**
	 * 단골 매장 리스트 전송 
	 * @return jsonView
	 */
	//selectMyBusinesses.do?USERID=1
    @RequestMapping(value="/selectMyBusinesses.do")
    public ModelAndView selectMyBusinessList(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");
        Map<String, Object> commandMap = new HashMap<String, Object>();
        List<Map<String,Object>> list = null;
        String userID;
        
        try {
	    	userID = request.getParameter("USERID");
	        commandMap.put("USERID", userID);
	        
	        System.out.println("userID = "+userID);
	        
	        list = service.selectMyBusinessList(commandMap);
	        //System.out.println("list = "+list);
	        
    	} catch (Exception e) {}

        mv.addObject("list", list);
        
        return mv;
    }
    
    /**
     * 단골 매장 삽입 혹은 삭제 후, UPDATE LIST 전송
     * @return jsonView
     */
    @RequestMapping(value="/checkMembership.do")
    public ModelAndView checkMembership(Map<String,Object> commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	List<Map<String,Object>> list = service.selectCheckMemebership(commandMap);
        mv.addObject("list", list);
        
    	return mv;
    }
    
    /**
     * 단골 매장 추가 
     * @param1 USER ID
     * @param2 BUSINESS ID
     */
    //insertMyBusiness.do?USERID=3&BUSINESSID=11
    @RequestMapping(value="/insertMyBusiness.do")
    public void insertMyBusiness(HttpServletRequest request) throws Exception{
    	//ModelAndView mv = new ModelAndView("redirect:/checkMembership.do");
    	Map<String, Object> commandMap = new HashMap<String, Object>();
    	String userID;
    	String businessID;
    	
    	try {
	    	userID = request.getParameter("USERID");
	        businessID = request.getParameter("BUSINESSID");
	        
	        commandMap.put("USERID", userID);
	        commandMap.put("BUSINESSID", businessID);
	        
	        service.insertMyBusiness(commandMap);
	        
    	} catch (Exception e) {  	}
    	
    //	return mv;
    }
    
    /**
     * 단골 매장 삭제 
     * @param1 USER ID
     * @param2 BUSINESS ID
     */
    //deleteMyBusiness.do?USERID=3&BUSINESSID=11
    @RequestMapping(value="/deleteMyBusiness.do")
    public void deleteMyBusiness(HttpServletRequest request) throws Exception{
    	//ModelAndView mv = new ModelAndView("redirect:/checkMembership.do");
    	Map<String, Object> commandMap = new HashMap<String, Object>();
    	String userID;
    	String businessID;
    	
    	try {
	    	userID = request.getParameter("USERID");
	        businessID = request.getParameter("BUSINESSID");
	        
	        commandMap.put("USERID", userID);
	        commandMap.put("BUSINESSID", businessID);
	        
	        service.deleteMyBusiness(commandMap);
	        
    	} catch (Exception e) {}
    	
    	//return mv;
    }

}
