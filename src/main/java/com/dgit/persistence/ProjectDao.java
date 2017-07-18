package com.dgit.persistence;

import java.sql.SQLException;
import java.util.List;

import com.dgit.domain.Project;

public interface ProjectDao {	
	public List<Project> selectByAll() throws SQLException;	
	public void register(Project project) throws SQLException;
	public void deleteById(int id) throws SQLException;
	public void update(Project project) throws SQLException;
	public Project selectById(int id) throws SQLException;	
}
