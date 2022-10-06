package com.astinel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astinel.domain.TestVO;
import com.astinel.mapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TestServiceImpl implements TestService {
	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;
	
	@Override
	public String getOne() {
		log.info("test============");
		TestVO tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}
	
	@Override
	public String getTwo() {
		log.info("test============");
		TestVO tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
	
	/* answer 1 */
	@Override
	public void updateVisitantCount() {
		mapper.updateVisitantCount();
	}
	
	/* answer 2 */
	@Override
	public void insertDoodle() {
		mapper.insertDoodle();
	}
	
	/* answer 3 */
	@Override
	public void delTest() {
		mapper.delTest();
	}
	
	
}
