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
	
	
	//가맹점 등록
	public void businessAdd(Map<String, Object> map) {
		dao.businessAdd(map);
	}
	
	
	//가맹점 수정
	public void businessUpdate(Map<String, Object> map) {
		dao.businessUpdate(map);
	}
		
	
	//가맹점 검색
	public List<Map<String, Object>> businessSearch(Map<String, Object> Map) throws Exception {
		return dao.businessSearch(Map);
	}
		
	
}
