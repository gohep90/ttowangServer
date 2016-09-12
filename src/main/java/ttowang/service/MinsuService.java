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

	public List<Map<String, Object>> selectSpinnerList(Map<String, Object> map) {
		return dao.selectSpinnerList(map);
	}

	public void insertUserCoupon(Map<String, Object> map) {
		dao.insertUserCoupon(map);
	}

	public void updateStampList(Map<String, Object> map) {
		dao.updateStampList(map);
	}

	public String selectCheckStampNeed(Map<String, Object> map) {
		return dao.selectCheckStampNeed(map);
	}

	public String searchUserIdByTel(Map<String, Object> map) {
		return dao.searchUserIdByTel(map);
	}
	
	public void deleteStamp(Map<String, Object> map) {
		dao.deleteStamp(map);
	}

	public void couponUse(Map<String, Object> map) {
		dao.couponUse(map);
	}

	public List<Map<String, Object>> spinnerListStaff(Map<String, Object> map) {
		return dao.spinnerListStaff(map);
	}

	public String selectCheckMembership(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectCheckMembership(map);
	}


}
