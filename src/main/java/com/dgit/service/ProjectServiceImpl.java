package com.dgit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Project;
import com.dgit.persistence.ProjectDao;

@Service
public class ProjectServiceImpl implements ProjectService {	//DAO를 호출, DB관련 처리
	
	@Autowired	
	private SqlSession session;
	
	@Autowired
	private ProjectDao dao;
	private static final String namespace ="com.dgit.persistence.ProjectDao";	/*맵퍼에 있는 네임스페이스와 일치시킨다*/	
			
	@Override
	public List<Project> selectByAll() throws SQLException {
		return dao.selectByAll();
	}

	@Override
	public void register(Project project) throws SQLException {
		dao.register(project);		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		dao.deleteById(id);		
	}

	@Override
	public void update(Project project) throws SQLException {
		dao.update(project);		
	}

	@Override
	public Project selectById(int id) throws SQLException {
		return dao.selectById(id);
	}

}
