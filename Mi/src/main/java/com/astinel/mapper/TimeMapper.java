package com.astinel.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	/* @Select("SELECT sysdate FROM dual") //oracle */
	@Select("SELECT now() FROM dual")
	public String getTime();
	
	public String getTime2();
}
