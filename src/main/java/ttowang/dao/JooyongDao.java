package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@SuppressWarnings("unchecked")
@Repository("JooyongDao")
public class JooyongDao extends abDAO{

	//가맹점 리스트
	public List<Map<String, Object>> selectbusinessList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("jooyong.selectbusinessList", commandMap);
	}

	
	//가맹점 상세정보
	public List<Map<String, Object>> businessView(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("jooyong.businessView", map);
	}
	
	
	//가맹점 사진
	public List<Map<String, Object>> businessPhoto(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("jooyong.businessPhoto", map);
	}

	
	//가맹점 등록
	public void businessAdd(Map<String, Object> map) {
		insert("jooyong.businessAdd", map);
	}
		
	//가맹점 등록후 아이디 받아오기
	public List<Map<String, Object>> businessAddplus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("jooyong.businessAddplus", map);
	}
	
	
	
	
	//가맹점 수정
	public void businessUpdate(Map<String, Object> map) {
		update("jooyong.businessUpdate", map);
	}
	
	
	//가맹점 검색
	public List<Map<String, Object>> businessSearch(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("jooyong.businessSearch", commandMap);
	}
	
	
	//내 모든 가맹점 
	public List<Map<String, Object>> businessAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("jooyong.businessAll", map);
	}

	//내 모든 가맹점 사진
	public List<Map<String, Object>> businessAllPhoto(Map<String, Object> map) {
		return (List<Map<String,Object>>)selectList("jooyong.businessAllPhoto", map);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////
	
	//모든 쿠폰 리스트
	public List<Map<String, Object>> selectcouponList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("jooyong.selectcouponList", commandMap);
	}
	
	//해당 가맹점 쿠폰 상세정보
	public List<Map<String, Object>> couponView(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (List<Map<String,Object>>)selectList("jooyong.couponView", map);
	}
	
	//쿠폰 등록
	public void couponAdd(Map<String, Object> map) {
		insert("jooyong.couponAdd", map);
	}

	//쿠폰 수정
	public void couponUpdate(Map<String, Object> map) {
		update("jooyong.couponUpdate", map);
	}
	
	//쿠폰 수정
	public void couponDelete(Map<String, Object> map) {
		delete("jooyong.couponDelete", map);
	}


	public void staffAdd(Map<String, Object> map) {
		insert("jooyong.staffAdd", map);
	}
	
	public String searchStaffByTel(Map<String, Object> map) {
		return (String)selectOne("jooyong.searchStaffByTel", map);
	}
	
	public String searchUserIdByTel(Map<String, Object> map) {
		return (String)selectOne("jooyong.searchUserIdByTel", map);
	}
	
}
