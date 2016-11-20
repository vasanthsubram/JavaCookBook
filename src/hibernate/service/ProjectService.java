package hibernate.service;

import javax.persistence.EntityManager;

import hibernate.data.emp.Project;

public class ProjectService {
	
	public Project createProject(int id, String name){
		Project p = new Project();
		p.setId(id);
		p.setName(name);
		return p;
	}
	
	public Project creatProject1(){
		return createProject(1, "ProjectA");
	}
	
	public Project creatProject2(){
		return createProject(2, "ProjectB");
	}
}
