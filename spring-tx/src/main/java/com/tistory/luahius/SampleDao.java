package com.tistory.luahius;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*���Թޱ� ���Ͽ� ���� �Ǿ�� �Ѵ� */
@Repository
public class SampleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	public int insertSample(Sample sample){
									//ns+id 
		return sqlSession.insert("com.tistory.luahius.SampleMapper.insertSample", sample);
	}
	

}
