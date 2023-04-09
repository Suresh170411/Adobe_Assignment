package com.adobe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;
import com.adobe.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@CrossOrigin
	@PostMapping("/posts")
	public ResponseEntity<String> createPostHandler(@RequestBody Post post, @RequestParam Integer userId){
		return new ResponseEntity<String>(postService.createPost(userId,post),HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(postService.getPostById(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePostHandler(@RequestBody Post post, @PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(postService.updatePostById(id, post), HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePostHandler(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<String>(postService.deletePostById(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/posts/{id}/like")
	public ResponseEntity<String> getLikeIncreamentHandler(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<String>(postService.increamentLike(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/posts/{id}/unlike")
	public ResponseEntity<String> getLikeDecreamentHandler(@PathVariable ("id") Integer id) throws PostException{
		return new ResponseEntity<String>(postService.decreamentLike(id),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/analytics/posts")
	public ResponseEntity<List<Post>> getAllPostHandler() throws PostException{
		return new ResponseEntity<List<Post>>(postService.getAllPost(),HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/analytics/posts/top-liked")
	public ResponseEntity<List<Post>> getTopFiveLikedPostHandler(){
		return new ResponseEntity<List<Post>>(postService.getMostLikedTopFivePosts(),HttpStatus.OK);
	}
	
}
