package com.learning.jpa.inheritance_mapping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private	Double salary;
	
	//we can not create/remove or update project if progarmmer is created -> hence not setting cascade
	@ManyToMany
	@JoinTable(name = "programmers_projects" , joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"),
		inverseJoinColumns  = @JoinColumn(referencedColumnName = "id", name ="project_id" )
			)
	private List<Project> projects;
	
	//lets not mutate projects from programmer side, addition to this happens only from , made it default access
	 public void addProject(Project project, boolean updateOnBothEntities) {
		if(project == null) {
			return;
		}
		if(projects == null) {
			projects = new ArrayList<>();
		}
		projects.add(project);
		if(updateOnBothEntities) {
			project.addProgrammer(this,false);
		}
	}
	 //do not allow others to muate apart fomr smae package classes
	public void removeProject(Project project, boolean updateOnBothEntities) {
			if(project == null || projects == null) {
				return;
			}
			projects.remove(project);
			if(updateOnBothEntities) {
				project.removeProgrammer(this,false);
			}
		}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Project> getProjects() {
		return projects;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
