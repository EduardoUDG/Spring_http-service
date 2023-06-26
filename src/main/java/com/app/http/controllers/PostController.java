package com.app.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.http.pojo.Post;
import com.app.http.pojo.Response;
import com.app.http.pojo.User;
import com.app.http.services.HttpService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/home")
public class PostController {
	
	@Autowired
	private HttpService httpService;
	
	@GetMapping("/users")
	public ResponseEntity<?> getHome(){

		String url = "https://jsonplaceholder.typicode.com/users";		
		User[] users = this.httpService.get(url, User[].class);

		return new ResponseEntity<>(new Response("success", true, users), HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<?> getPosts(){

		String url = "https://jsonplaceholder.typicode.com/posts";		
		Post[] posts = this.httpService.get(url, Post[].class);

		return new ResponseEntity<>(new Response("success", true, posts), HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<?> postHome(@RequestBody Post newPost ){

		String url = "https://jsonplaceholder.typicode.com/posts";
		
		Post post = this.httpService.post(url, newPost, Post.class);	
		return new ResponseEntity<>(new Response("success", true, post), HttpStatus.OK);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<?> updatePost(@PathVariable Long id , @RequestBody Post newPost ){

		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
		
		Post post = this.httpService.put(url, newPost, Post.class);	
		return new ResponseEntity<>(new Response("success", true, post), HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable Long id){

		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
		
		Post post = this.httpService.delete(url, null);	
		return new ResponseEntity<>(new Response("success", true, post), HttpStatus.OK);
	}

}
