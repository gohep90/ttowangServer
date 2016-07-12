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



}
