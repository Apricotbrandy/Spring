package com.astinel.pword.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select now() from dual")
	public String getTime();
	public String getTime2();
}
