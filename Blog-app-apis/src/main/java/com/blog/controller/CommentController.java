package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.APIResponse;
import com.blog.payloads.CommentDto;
import com.blog.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@PostMapping("/users/{userId}/posts/{postId}/comments")
	public ResponseEntity<CommentDto> writeComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId,@PathVariable Integer userId){
		
		CommentDto writeComment=this.commentService.writeComment(commentDto, postId,userId);
		return new ResponseEntity<CommentDto>(writeComment,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<APIResponse> deleteComment(@PathVariable Integer commentId){
		
		this.commentService.deleteComment(commentId);
		return	new ResponseEntity<APIResponse>(new APIResponse("comment deleted successfully!",true),HttpStatus.CREATED);
	}
	
	//edit comment
		@PutMapping("/comments/{commentId}")
		public ResponseEntity<CommentDto> editComment(@RequestBody CommentDto commentDto,@PathVariable Integer commentId)
		{
		CommentDto editedComment=this.commentService.editComment(commentDto, commentId);
		return new ResponseEntity<CommentDto>(editedComment,HttpStatus.OK);
		}
	
}
