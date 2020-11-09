package com.learning.jpa.inheritance_mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.jpa.inheritance_mapping.entities.ImageDTO;
import com.learning.jpa.inheritance_mapping.entities.services.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping()
	public void updaloadImage(@RequestBody ImageDTO imageDTO) {
		imageService.uploadImage(imageDTO);
	}
	
	@GetMapping("/{id}")
	public void downloadImage(@PathVariable String id) {
		imageService.downloadImage(id);
	}
}
