package ttowang.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ttowang.abst.dao.abDAO;

@Repository("JieunDao")
public class JieunDao extends abDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMyBusinessList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("jieun.selectBoardList", map);
    }

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectCheckMembership(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("jieun.selectCheckMembership", map);
	}

	public void insertMyBusiness(Map<String, Object> map) {
		insert("jieun.insertMyBusiness",map);
	}

	public void deleteMyBusiness(Map<String, Object> map) {
		delete("jieun.deleteMyBusiness",map);
	}
}
