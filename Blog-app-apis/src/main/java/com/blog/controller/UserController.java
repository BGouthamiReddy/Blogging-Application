package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.APIResponse;
import com.blog.payloads.UserDto;
import com.blog.services.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	private UserService userService;
	
	// create/Add
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createuserDto= this.userService.createUser(userDto);
		return new ResponseEntity<> (createuserDto, HttpStatus.CREATED);
	}
	
	//Update 
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
	{
		UserDto updateuserDto = this.userService.updateUser(userDto, userId);
		return  ResponseEntity.ok(updateuserDto);
		
	}
	
	//Delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<APIResponse> deleteUser(@PathVariable ("userId") Integer UserId)
	{
		this.userService.deleteUser(UserId);
		return new ResponseEntity<APIResponse>(new APIResponse("user deleted successfully",true),HttpStatus.OK);
	}
	
	//Get All
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
		
	}
	
	//Get single
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
