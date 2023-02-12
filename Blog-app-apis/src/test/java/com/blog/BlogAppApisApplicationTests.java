package com.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.repository.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		String classname=this.userRepo.getClass().getName();
		String pak = this.userRepo.getClass().getPackageName();
		
		System.out.println(classname);
		System.out.println(pak);
	}
}
