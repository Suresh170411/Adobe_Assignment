package com.adobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;
import com.adobe.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	public ResponseEntity<String> createPostHandler(@RequestBody Post post){
		return new ResponseEntity<String>(postService.createPost(post),HttpStatus.CREATED);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(postService.getPostById(id),HttpStatus.OK);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePostHandler(@RequestBody Post post, @PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(postService.updatePostById(id, post), HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePostHandler(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<String>(postService.deletePostById(id), HttpStatus.OK);
	}
	
	
}
