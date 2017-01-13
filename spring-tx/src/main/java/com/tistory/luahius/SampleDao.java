package com.tistory.luahius;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*주입받기 위하여 빈이 되어야 한다 */
@Repository
public class SampleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public int insertSample(Sample sample){
									//ns+id 
		return sqlSession.insert("com.tistory.luahius.SampleMapper.insertSample", sample);
	}
	

}
