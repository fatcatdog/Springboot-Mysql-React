package com.jacob.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jacob.demo.model.Blog;

@Transactional
@Repository
public class BlogDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BlogDao(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }
    
	 public int getANewId() {
		 String sql = "SELECT MAX(id) from blog";
		 Integer number = jdbcTemplate.queryForObject(sql, Integer.class);
		 return (number + 1);
//		 return 1; 
	 }
	 
    public void saveBlog(Blog blog) {
 	   String sql = "INSERT INTO blog (id, title, content) values (?, ?, ?)";
 	   int tempBlogId = getANewId();
 	   try {
 		   jdbcTemplate.update(sql, tempBlogId, blog.getTitle(), blog.getContent());
 	   } catch (Exception e) {
			System.out.println("Blog Dao save blog failed");
			System.out.println(e);
 	  }
    }
    
    public Blog getBlog(int id) {
    	String sql = "SELECT id, title, content FROM blog WHERE id = ?";
    	 RowMapper<Blog> rowMapper = new BeanPropertyRowMapper<Blog>(Blog.class);
		 Blog blog = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return blog;
    }
    
    public List<Blog> getAllBlogs() {
    	String sql = "SELECT blog.id, blog.title, blog.content FROM blog";
    	  
    	RowMapper<Blog> rowMapper = new BeanPropertyRowMapper<Blog>(Blog.class);
	   return this.jdbcTemplate.query(sql, rowMapper);
    }
}
