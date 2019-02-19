package com.jacob.demo.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacob.demo.model.Blog;
import com.jacob.demo.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
	public ResponseEntity<Blog> createBlog(@Valid @RequestBody Blog tempBlog) throws URISyntaxException {
    	System.out.println("What do we have here: ");
    	System.out.println(tempBlog.getTitle());
    	System.out.println(tempBlog.getContent());
          
    	blogService.saveBlog(tempBlog);
          
  			return new ResponseEntity<>(tempBlog, HttpStatus.OK); 

   	}
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ResponseEntity<?> getBlogs(){
    	try {
    		List<Blog> tempBlogs = blogService.getAllBlogs();
    		return new ResponseEntity<>(tempBlogs, HttpStatus.OK); 
    	} catch (Exception e) {
    		return new ResponseEntity<>("We Failed You", HttpStatus.BAD_REQUEST); 
    	}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id){
    	System.out.println("method is getting called?");
    	try {
    		Blog tempBlog = blogService.getBlog(id);
    		return new ResponseEntity<>(tempBlog, HttpStatus.OK);	
    	} catch(Exception e) {
    		return new ResponseEntity<>("We failed", HttpStatus.BAD_REQUEST);
    	}
    	
    }

    
    
}
