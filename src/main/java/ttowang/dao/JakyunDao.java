package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@SuppressWarnings("unchecked")
@Repository("JakyunDao")
public class JakyunDao extends abDAO{
	
	public List<Map<String, Object>> checkUser(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("jakyun.checkUser", map);
	}
	
	public void insertUser(Map<String, Object> map) {
		insert("jakyun.insertUser", map);
	}
	
	public String checkCode(Map<String, Object> map) {
		return (String)selectOne("jakyun.checkCode", map);
	}
	
	public void updateUser(Map<String, Object> map) {
		update("jakyun.updateUser", map);
	}
	
	public void myInfoEdit(Map<String, Object> map) {
		update("jakyun.myInfoEdit", map);
	}
}
