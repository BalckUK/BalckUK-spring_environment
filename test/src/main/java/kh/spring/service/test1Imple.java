package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.testDAO;
import kh.spring.dto.testDTO;

@Service
public class test1Imple implements test1{

	@Autowired
	public testDAO testdao;
	
	@Override
	public List<testDTO> test1list() {
		return testdao.testlist();
	}

	
}
