package com.tistory.luahius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SampleService {
	
	@Autowired
	private SampleDao sampleDao;
	
	public int addSample(Sample sample) {
		//데이터 입력
		int row = sampleDao.insertSample(sample);
		//인위적 예외 발생
		boolean flag = true;
		if(flag){
			throw new RuntimeException();
		}
		return row;
	}

}
//하나라도 실패하면 트랜잭션 걸린다. 
