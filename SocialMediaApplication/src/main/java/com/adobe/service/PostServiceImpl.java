package com.adobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;
import com.adobe.repository.PostRepositoty;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepositoty postRepo;

	@Override
	public String createPost(Post post) {
		postRepo.save(post);
		return "Post added Successfully !";
	}

	@Override
	public Post getPostById(Integer id) throws PostException {
		return postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
	}

	@Override
	public Post updatePostById(Integer id, Post post) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePostById(Integer id) throws PostException {
		postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
		postRepo.deleteById(id);
		return "Post deleted successfully !";
	}

	@Override
	public String increamentLike(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decreamentLike(Integer id) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

}
