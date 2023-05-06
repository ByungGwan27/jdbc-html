package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	
	private static SqlSessionFactory sqlSessionFactory;

	private DataSource() {
		
	}

	public static SqlSessionFactory getInstance() {
		//mybatis에서 복사
		String resource = "com/yedam/common/mybatis-config.xml"; //이 경로에 xml파일 만들고 mybatis2 내용 복사
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource); //특정 파일을 읽어와서 Stream으로 읽어준다
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
