package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@SuppressWarnings("unchecked")
@Repository("JieunDao")
public class JieunDao extends abDAO{

	
	public List<Map<String, Object>> selectMyBusinessList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("jieun.selectMyBusinessList", map);
    }

	public List<Map<String, Object>> selectCheckMembership(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>)selectList("jieun.selectCheckMembership", map);
	}
	
	public String selectCheckMyMembership(Map<String, Object> commandMap) {
		return (String)selectOne("jieun.selectCheckMyMembership", commandMap);
	}

	public void insertMyBusiness(Map<String, Object> map) {
		insert("jieun.insertMyBusiness",map);
	}

	public void deleteMyBusiness(Map<String, Object> map) {
		delete("jieun.deleteMyBusiness",map);
	}

	public List<Map<String, Object>> selectMyCoupon(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("jieun.selectMyCoupon", map);
	}

	
	
}
