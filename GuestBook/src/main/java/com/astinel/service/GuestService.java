package com.astinel.service;

import java.util.List;

import com.astinel.domain.GuestVO;

public interface GuestService {
	public List<GuestVO> getList();
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);
	public void modify(GuestVO gvo);
}