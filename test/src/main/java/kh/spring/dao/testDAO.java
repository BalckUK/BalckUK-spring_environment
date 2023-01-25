package kh.spring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.testDTO;

@Repository
public class testDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private SqlSessionTemplate  mybaits;
	
	
	public int selectconuttest() {
		return mybaits.selectOne("mapper.test.numbercount");
	}
	
	public List<testDTO> testlist(){
		List<testDTO> list = mybaits.selectList("mapper.test.selecttest");
		return list;
	}
	
	public void insertuser() {
		mybaits.insert("mapper.test.inserttest");
	}
	
	public int insertuser2() {
		return mybaits.insert("mapper.test.inserttest2");
	}
}
