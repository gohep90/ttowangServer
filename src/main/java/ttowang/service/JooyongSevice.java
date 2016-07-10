package ttowang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttowang.dao.JooyongDao;

@Service("JooyongSevice")
public class JooyongSevice {
	
	@Resource(name="JooyongDao")
	private JooyongDao dao;

	
	public Object good() {
		// TODO Auto-generated method stub
		return "사랑합니다 꿀꿀이 정말로!!!";
	}
	
	//member 전체 출력
	public List<Map<String, Object>> selectMemberList(Map<String, Object> Map) throws Exception {
		return dao.selectMemberList(Map);
	}
	
	//member 한명 insert
	public void insertMember(Map<String, Object> map) {
		dao.insertMember(map);
	}

	//member 한명 delete
	public void deleteMember(Map<String, Object> map) {
		dao.deleteMember(map);
	}
	
	
	
	//store 전체 출력
		public List<Map<String, Object>> selectStoreList(Map<String, Object> Map) throws Exception {
			return dao.selectStoreList(Map);
		}

		
		public List<Map<String, Object>> selectStore(Map<String, Object> Map) {
			// TODO Auto-generated method stub
			return dao.selectStore(Map);
		}

		public List<Map<String, Object>> selectCheck(Map<String, Object> Map) {
			// TODO Auto-generated method stub
			return dao.selectCheck(Map);
		}

		public List<Map<String, Object>> selectStampList(Map<String, Object> Map) {
			// TODO Auto-generated method stub
			return dao.selectStampList(Map);
		}

		public void insertEnrollStamp(Map<String, Object> map) {
			dao.insertEnrollStamp(map);
			
		}

		public List<Map<String, Object>> selectStamp(Map<String, Object> Map) {
			// TODO Auto-generated method stub
			return dao.selectStamp(Map);
		}

		public void updateStamp(Map<String, Object> map) {
			dao.updateStamp(map);
		}

		public List<Map<String, Object>> selectSearchStore(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return dao.selectSearchStore(map);
		}

		public void deleteStamp(Map<String, Object> map) {
			// TODO Auto-generated method stub
			dao.deleteStamp(map);
		}


	

}
