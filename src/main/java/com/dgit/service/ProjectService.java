package com.dgit.service;

import java.sql.SQLException;
import java.util.List;

import com.dgit.domain.Project;

public interface ProjectService {
	
	public List<Project> selectByAll() throws SQLException;	
	public void register(Project project) throws SQLException;
	public void deleteById(int id) throws SQLException;
	public void update(Project project) throws SQLException;
	public Project selectById(int id) throws SQLException;

}
