package com.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=4,message="category title must be atleast 4 chars!")
	private String categoryTitle;
	@NotEmpty
	private String categoryDescription;

}
