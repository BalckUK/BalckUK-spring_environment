package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.testDTO;

@Repository
public class test2DAO {

	@Autowired
	private SqlSessionTemplate  mybaits;
	
	public List<testDTO> listdto(){
		return mybaits.selectList("mapper.test1-mapper.selecttest");
	}
}
