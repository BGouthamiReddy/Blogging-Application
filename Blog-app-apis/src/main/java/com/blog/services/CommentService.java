package com.blog.services;

import com.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto writeComment(CommentDto commentDto, Integer postId, Integer userId);
	
	CommentDto editComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
