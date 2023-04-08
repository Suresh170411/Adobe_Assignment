package com.adobe.service;

import java.util.List;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;

public interface PostService {

	public String createPost(Integer userId, Post post);

	public Post getPostById(Integer id) throws PostException;

	public Post updatePostById(Integer id, Post post) throws PostException;

	public String deletePostById(Integer id) throws PostException;

	public String increamentLike(Integer id) throws PostException;

	public String decreamentLike(Integer id) throws PostException;
	
	public List<Post> getAllPost() throws PostException;
	
	public List<Post> getMostLikedTopFivePosts();
}
