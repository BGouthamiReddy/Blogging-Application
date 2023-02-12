package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);	//create
	PostDto updatePost(PostDto postDto, Integer postId);	//update
	void deletePost(Integer postId);	//delete
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);	//get all posts
	PostDto getPostById(Integer postId);	//get single post
	List<PostDto> getPostsByCategory(Integer categoryId);	//get all post by category
	List<PostDto> getPostsByUser(Integer userId);	//get all posts by user
	List<PostDto> searchPosts(String keyword);		//serach post
}
