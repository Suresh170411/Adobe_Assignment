package com.adobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.exceptions.PostException;
import com.adobe.model.Post;
import com.adobe.model.User;
import com.adobe.repository.PostRepositoty;
import com.adobe.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepositoty postRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public String createPost(Integer userId, Post post) {
		User user = userRepo.findById(userId).get();
		
		post.setUser(user);
		
		postRepo.save(post);
		
		return "Post added Successfully !";
	}

	@Override
	public Post getPostById(Integer id) throws PostException {
		return postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
	}

	@Override
	public Post updatePostById(Integer id, Post post) throws PostException {
		Post existingPost = postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
		
		existingPost.setContent(post.getContent());
		
		return postRepo.save(existingPost);
	}

	@Override
	public String deletePostById(Integer id) throws PostException {
		postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
		postRepo.deleteById(id);
		return "Post deleted successfully !";
	}

	@Override
	public String increamentLike(Integer id) throws PostException {
		Post existingPost = postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
		
		existingPost.setLikes(existingPost.getLikes() + 1);
		
		return "Liked Successfully !";
	}

	@Override
	public String decreamentLike(Integer id) throws PostException {
		Post existingPost = postRepo.findById(id).orElseThrow(() -> new PostException("No post found with the id : " + id));
		
		if (existingPost.getLikes() > 0) {
			existingPost.setLikes(existingPost.getLikes() - 1);
		}else {
			throw new PostException("You have already unliked this post !");
		}
		
		return "Unliked Successfully !";
	}

	@Override
	public List<Post> getAllPost() throws PostException {
		return postRepo.findAll();
	}

	@Override
	public List<Post> getMostLikedTopFivePosts() {
		// TODO Auto-generated method stub
		return null;
	}

}
