package ttowang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttowang.dao.JakyunDao;

@Service("JakyunService")
public class JakyunService {
	
	@Resource(name="JakyunDao")
	private JakyunDao dao;

	public void insertUser(Map<String, Object> map) {
		dao.insertUser(map);
	}
	
	public String checkUser(Map<String, Object> map) {
		return dao.checkUser(map);
	}
	
	public void updateUser(Map<String, Object> map) {
		dao.updateUser(map);
	}
	
}
