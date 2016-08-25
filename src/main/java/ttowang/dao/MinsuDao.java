package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@SuppressWarnings("unchecked")
@Repository("MinsuDao")
public class MinsuDao extends abDAO{

	public List<Map<String, Object>> selectUserTest(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("minsu.selectUserTest", map);
	}
	
	public void insertAddStamp(Map<String, Object> map) {
		insert("minsu.insertAddStamp", map);
	}

	public String selectCheck(Map<String, Object> map) {
		return (String)selectOne("minsu.selectCheck", map);
	}

	public void insertUser(Map<String, Object> map) {
		insert("minsu.insertUser", map);
	}

	public void insertJunMembership(Map<String, Object> map) {
		insert("minsu.insertJunMembership", map);
	}

	
}
