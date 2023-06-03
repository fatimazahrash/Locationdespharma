package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	
}
