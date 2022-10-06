package com.astinel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class MysqlProc {
	static public String TABLE_BOARD = "tbl_guest";		//게시판 테이블 명
	static public int BOARD_LIST_AMOUNT = 5;		//게시판 페이지 당 보여줄 리스트 갯수
	static public int BOARD_BLOCK_PAGE_AMOUNT = 3;	//게시판 페이지 블럭 당 보여줄 페이지 갯수
	static public Connection con = null;
	static public Statement st = null;
	
	static public void dbInit() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static public void dbConnect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_board","root", "admin");
			st = con.createStatement();
			System.out.println("==== DB CONNECTION SUCCESSFUL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static public ResultSet executeQuery(String sql) {
		try {
			return st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static public int executeUpdate(String sql) {
		try {
			return st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -100;  //??????
	}
	
	static public void dbDisconnect() {
		try {
			if(st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static public int getDataCount() {
		dbConnect();
		ResultSet rs = executeQuery("select count(*) from "+TABLE_BOARD);
		try {
			rs.next();
			int count = Integer.parseInt(rs.getString("count(*)"));
			dbDisconnect();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbDisconnect();
		return 0;
	}
	
	/* searchWord 값 검색어로 검색한 글 수를 리턴하는 함수 */
	//function overloading.
	static public int getDataCount(String searchWord) {
		dbConnect();
		String sql = "select count(*) from "+TABLE_BOARD+" where title like '%"+searchWord+"%'";
		System.out.println("count number sql : " + sql);// test
		ResultSet rs = executeQuery(sql);
		try {
			rs.next();
			int count = Integer.parseInt(rs.getString("count(*)"));
			dbDisconnect();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbDisconnect();
		return 0;
	}
}
