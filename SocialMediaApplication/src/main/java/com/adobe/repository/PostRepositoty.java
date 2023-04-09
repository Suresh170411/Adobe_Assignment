package com.adobe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adobe.model.Post;

@Repository
public interface PostRepositoty extends JpaRepository<Post, Integer> {

	@Query(value = "select id,content,likes from post order by likes desc limit 5", nativeQuery = true)
	public List<Post> getTopFivePost();
}
