package com.learning.jpa.inheritance_mapping.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.jpa.inheritance_mapping.entities.Image;

public interface ImageRepostiory extends CrudRepository<Image, Integer>{

}
