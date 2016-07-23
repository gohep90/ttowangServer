package ttowang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttowang.dao.MinsuDao;

@Service("MinsuService")
public class MinsuService {
	
	@Resource(name="MinsuDao")
	private MinsuDao dao;

	public List<Map<String, Object>> selectUserTest(Map<String, Object> map) {
		return dao.selectUserTest(map);
	}

	public void insertAddStamp(Map<String, Object> map) {
		dao.insertAddStamp(map);
	}

	public String selectCheck(Map<String, Object> map) {
		return dao.selectCheck(map);
	}

	public void insertUser(Map<String, Object> map) {
		dao.insertUser(map);
	}

	public void insertJunMembership(Map<String, Object> map) {
		dao.insertJunMembership(map);
		
	}




	
	

	

}
