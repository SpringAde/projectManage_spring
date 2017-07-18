package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dgit.domain.Project;
import com.dgit.service.ProjectService;

@Controller
public class ProjectController {	//view관련 제어 처리 한다.	//controller에서 dao를 직접 호출하지 않고 서비스를 호출한다.	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService service;
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public String listAll(Model model) throws Exception{
		List<Project> list = service.selectByAll();
		model.addAttribute("viewData", list);		
		return "board/listProject";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() throws Exception{
		return "board/insertProjectForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Project project) throws Exception{
		service.register(project);
		return "redirect:listAll";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(int id, Model model) throws Exception{
		Project project = service.selectById(id);
		model.addAttribute("contentView", project);
		return "board/listReadProject";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int id) throws Exception{
		service.deleteById(id);
		return "redirect:listAll";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int id, Model model) throws Exception{
		Project project = service.selectById(id);
		model.addAttribute("viewData", project);
		return "board/modifyProjectForm";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Project project, RedirectAttributes rttr) throws Exception{		
		service.update(project);
		rttr.addAttribute("id", project.getId());
		return "redirect:read";
		//스프링에서는 redirect할 때, 매개변수를 가지고 갈 수 있도록 RedirectAttributes클래스를 제공(단,jsp에서는 안된다)
	}
}
