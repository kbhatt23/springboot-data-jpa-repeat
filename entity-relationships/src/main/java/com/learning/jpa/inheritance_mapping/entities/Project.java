package com.learning.jpa.inheritance_mapping.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String clientName;
	
	private String description;
	//if project is updated/inserted it should reflect that in programmer but not while deleting the project
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, 
			//if we do n set mapped by here , it will create two table one project_progarmmer and another programmer_projects
			//mapped by ignores table creation form this entity side
			mappedBy = "projects"
			)
	private List<Programmer> programmers;
	
	public void addProgrammer(Programmer programmer,  boolean updateOnBothEntities) {
		if(programmer == null) {
			return;
		}
		if(programmers == null) {
			programmers = new ArrayList<>();
		}
		programmers.add(programmer);
		if(updateOnBothEntities) {
			programmer.addProject(this,false);
		}
	}
	
	public void removeProgrammer(Programmer programmer,  boolean updateOnBothEntities) {
		if(programmer == null || programmers == null) {
			return;
		}
		programmers.remove(programmer);
		if(updateOnBothEntities) {
			programmer.removeProject(this, false);
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Programmer> getProgrammers() {
		return programmers;
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
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
