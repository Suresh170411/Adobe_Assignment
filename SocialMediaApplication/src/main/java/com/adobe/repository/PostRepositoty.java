package com.adobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adobe.model.Post;

@Repository
public interface PostRepositoty extends JpaRepository<Post, Integer> {

}
