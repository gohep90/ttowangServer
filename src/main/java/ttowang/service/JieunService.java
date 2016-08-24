package ttowang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttowang.dao.JieunDao;

@Service("JieunService")
public class JieunService {
	
	@Resource(name="JieunDao")
	private JieunDao dao;
	
	public List<Map<String, Object>> selectMyBusinessList(Map<String, Object> map) throws Exception {
		return dao.selectMyBusinessList(map);
	}
	
	public List<Map<String, Object>> selectCheckMemebership(Map<String, Object> map) throws Exception {
		return dao.selectCheckMembership(map);
	}

	public void insertMyBusiness(Map<String, Object> map) {
		dao.insertMyBusiness(map);
	}

	public void deleteMyBusiness(Map<String, Object> map) {
		dao.deleteMyBusiness(map);
	}

	public List<Map<String, Object>> selectMyCoupon(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return dao.selectMyCoupon(commandMap);
	}

	public String selectCheckMyMembership(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return dao.selectCheckMyMembership(commandMap);
	}
	
	public List<Map<String, Object>> selectRecentList(Map<String, Object> map) throws Exception{
		return dao.selectRecentList(map);
	}

	public void deleteRecentStamp(Map<String, Object> map) {
		dao.deleteRecentStamp(map);
	}
}
