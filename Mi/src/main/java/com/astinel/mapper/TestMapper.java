package com.astinel.mapper;

import com.astinel.domain.TestVO;

public interface TestMapper {
	public TestVO getData1();
	public TestVO getData2();
	public TestVO getData3();
	public TestVO getData4();
	
	public void updateVisitantCount();	//answer 1
	public void insertDoodle();			//answer 2
	public void delTest();				//answer 3
	
}
