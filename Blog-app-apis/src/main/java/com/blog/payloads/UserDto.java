package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min=4, message="username must be mininum of 4 charecters!")
	private String name;
	@Email(message = "email address is not valid!")
	private String email;
	@NotEmpty
	@Size(min=6, max =12, message="password must be minimum of 6 chars and maximum of 12 chars!")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-z])(?=.*\\d)(?=.*[!@#$%^?&*])[A-Za-z\\d@$!%*#?&]{6,}$")
	private String password;
	@NotEmpty
	private String about;
	
	private Set<CommentDto> comments=new HashSet<>();
	
}
