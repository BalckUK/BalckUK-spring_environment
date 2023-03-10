package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.test2DAO;
import kh.spring.dao.testDAO;
import kh.spring.dto.testDTO;

@Service
public class testService {
	
	@Autowired
	private testDAO testdao;
	
	@Autowired
	private test2DAO test2dao;
	
	public int testcount() {
		return testdao.selectconuttest();
	}
	
	public List<testDTO> selectlistservice(){
		return testdao.testlist();
	}
	
	public List<testDTO> test2DAOlist(){
		return test2dao.listdto();
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public int insertUser() {
		testdao.insertuser();
		return testdao.insertuser2();
	}
	
}
