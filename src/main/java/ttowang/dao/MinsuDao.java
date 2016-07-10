package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@SuppressWarnings("unchecked")
@Repository("MinsuDao")
public class MinsuDao extends abDAO{

	public List<Map<String, Object>> selectMemberList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectMemberList", commandMap);
	}

	
	public void insertMember(Map<String, Object> map) {
		insert("sample.insertMember", map);
	}


	public void deleteMember(Map<String, Object> map) {
		delete("sample.deleteMember",map);
	}
	
	
	
	
	public List<Map<String, Object>> selectStoreList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectStoreList", commandMap);
	}


	public List<java.util.Map<String, Object>> selectStore(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("sample.selectStore", commandMap);
	}

	public List<java.util.Map<String, Object>> selectCheck(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("sample.selectCheck", commandMap);
	}

	public List<java.util.Map<String, Object>> selectStampList(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("sample.selectStampList", commandMap);
	}


	public void insertEnrollStamp(Map<String, Object> commandMap) {
		insert("sample.insertEnrollStamp", commandMap);
	}

	
	public List<java.util.Map<String, Object>> selectStamp(Map<String, Object> commandMap) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("sample.selectStamp", commandMap);
	}


	public void updateStamp(Map<String, Object> map) {
		update("sample.updateStamp", map);
	}


	public List<Map<String, Object>> selectSearchStore(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("sample.selectSearchStore", map);
	}


	public void deleteStamp(Map<String, Object> map) {
		// TODO Auto-generated method stub
		delete("sample.deleteStamp",map);
	}

}
