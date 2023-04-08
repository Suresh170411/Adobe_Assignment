package com.adobe.service;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;

public interface PostService {

	public String createPost(Post post);

	public Post getPostById(Integer id) throws PostException;

	public Post updatePostById(Integer id, Post post) throws PostException;

	public String deletePostById(Integer id) throws PostException;

	public String increamentLike(Integer id) throws PostException;

	public String decreamentLike(Integer id) throws PostException;
}
