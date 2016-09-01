package ttowang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttowang.dao.JooyongDao;


@Service("JooyongService")
public class JooyongService {
	
	@Resource(name="JooyongDao")
	private JooyongDao dao;

	
	//가맹점 리스트
	public List<Map<String, Object>> selectbusinessList(Map<String, Object> Map) throws Exception {
		return dao.selectbusinessList(Map);
	}
	
	
	//가맹점 상세정보
	public List<Map<String, Object>> businessView(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.businessView(map);
	}
	
	//가맹점 사진
	public List<Map<String, Object>> businessPhoto(Map<String, Object> map) {
		return dao.businessPhoto(map);
	}
	
	
	
	//가맹점 등록
	public void businessAdd(Map<String, Object> map) {
		dao.businessAdd(map);
	}
	
	
	//가맹점 등록 후 아이디 받아오기
	public List<Map<String, Object>> businessAddplus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.businessAddplus(map);
	}
	
	
	//가맹점 수정
	public void businessUpdate(Map<String, Object> map) {
		dao.businessUpdate(map);
	}
		
	
	//가맹점 검색
	public List<Map<String, Object>> businessSearch(Map<String, Object> Map) throws Exception {
		return dao.businessSearch(Map);
	}
	
	
	//내 가맹점 상세정보
	public List<Map<String, Object>> businessAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.businessAll(map);
	}
		
	
	//내 가맹점 모든 사진
	public List<Map<String, Object>> businessAllPhoto(Map<String, Object> map) {
		return dao.businessAllPhoto(map);
	}
//////////////////////////////////////////////////////////////////////////////////////////
	
	//모든 쿠폰 리스트
	public List<Map<String, Object>> selectcouponList(Map<String, Object> Map) throws Exception {
		return dao.selectcouponList(Map);
	}
	
	//해당 가맹점 쿠폰 상세정보
	public List<Map<String, Object>> couponView(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.couponView(map);
	}
	
	//쿠폰 등록
	public void couponAdd(Map<String, Object> map) {
		dao.couponAdd(map);
	}
	
	//쿠폰 수정
	public void couponUpdate(Map<String, Object> map) {
		dao.couponUpdate(map);
	}
	
	//쿠폰 수정
	public void couponDelete(Map<String, Object> map) {
		dao.couponDelete(map);
	}

/////////////////////////////////////////////////////////////////////////
	
	public void staffAdd(Map<String, Object> map) {
		dao.staffAdd(map);
	}
	
	public String searchStaffByTel(Map<String, Object> map) {
		return dao.searchStaffByTel(map);
	}
	
	public String searchUserIdByTel(Map<String, Object> map) {
		return dao.searchUserIdByTel(map);
	}
}
