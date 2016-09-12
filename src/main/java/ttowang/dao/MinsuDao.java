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

	public List<Map<String, Object>> selectSpinnerList(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("minsu.selectSpinnerList", map);
	}

	public void insertUserCoupon(Map<String, Object> map) {
		insert("minsu.insertUserCoupon", map);
	}

	public void updateStampList(Map<String, Object> map) {
		update("minsu.updateStampList", map);
		
	}

	public String selectCheckStampNeed(Map<String, Object> map) {
		return (String)selectOne("minsu.selectCheckStampNeed", map);
	}

	public String searchUserIdByTel(Map<String, Object> map) {
		return (String)selectOne("minsu.searchUserIdByTel", map);
	}
	
	public void deleteStamp(Map<String, Object> map) {
		delete("minsu.deleteStamp", map);
		
	}

	public void couponUse(Map<String, Object> map) {
		update("minsu.couponUse", map);
	}

	public List<Map<String, Object>> spinnerListStaff(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("minsu.spinnerListStaff", map);
	}

	public String selectCheckMembership(Map<String, Object> map) {
		return (String)selectOne("minsu.selectCheckMembership", map);
	}
	
}
