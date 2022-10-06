package com.astinel.pword.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
import static org.junit.Assert.fail;

@Log4j
public class JDBCTests {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con =
				DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/pword",
							"root",
							"admin")){
			log.info(con);;
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}