package com.learning.jpa.inheritance_mapping.entities.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.jpa.inheritance_mapping.entities.Image;
import com.learning.jpa.inheritance_mapping.entities.ImageDTO;
import com.learning.jpa.inheritance_mapping.repositories.ImageRepostiory;

@Service
public class ImageService {

	private static final String FILE_DIRECTORY_SEPERATOR = "/";
	@Autowired
	private ImageRepostiory repository;

	public void uploadImage(ImageDTO imageDTO) {

		String fileName = imageDTO.getFileName();
		File file = new File(imageDTO.getFilePath() + FILE_DIRECTORY_SEPERATOR + fileName);
		try (FileInputStream fis = new FileInputStream(file);) {
			byte[] imageData = new byte[(int) file.length()];
			fis.read(imageData);
			Image image = new Image(fileName, imageData);
			repository.save(image);
		} catch (IOException e) {

		}
	}
	
	public void downloadImage(String idStr ) {
		int id = Integer.parseInt(idStr);
		Image imageFound = repository.findById(id).orElseThrow(() -> new RuntimeException("image not present with id "+id));
		
		byte[] imageData = imageFound.getImageData();
		
		try(FileOutputStream fos = new FileOutputStream(new File("C:/Kanishk/learning/spring-boot-jpa-bharth-udemy/files/downloads"+FILE_DIRECTORY_SEPERATOR+imageFound.getName()))){
			
			fos.write(imageData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
