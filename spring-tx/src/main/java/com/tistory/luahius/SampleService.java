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
		//������ �Է�
		int row = sampleDao.insertSample(sample);
		//������ ���� �߻�
		boolean flag = true;
		if(flag){
			throw new RuntimeException();
		}
		return row;
	}

}
//�ϳ��� �����ϸ� Ʈ����� �ɸ���. 
