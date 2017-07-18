package com.dgit.persistence;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Project;

@Repository 	/*Dao인식*/
public class ProjectDaoImpl implements ProjectDao {
	
	@Autowired
	private SqlSession session;
	private static final String namespace ="com.dgit.persistence.ProjectDao";	/*맵퍼에 있는 네임스페이스와 일치시킨다*/
	
	@Override
	public List<Project> selectByAll() throws SQLException {
		return session.selectList(namespace+".selectByAll");		
	}
	
	@Override
	public void register(Project project) throws SQLException {
		session.insert(namespace+".register", project);		
	}
	
	@Override
	public void deleteById(int id) throws SQLException {
		session.delete(namespace+".deleteById", id);
		
	}
	@Override
	public void update(Project project) throws SQLException {
		session.update(namespace+".update", project);		
	}
	
	@Override
	public Project selectById(int id) throws SQLException {
		return session.selectOne(namespace+".selectById", id);
	}

}
