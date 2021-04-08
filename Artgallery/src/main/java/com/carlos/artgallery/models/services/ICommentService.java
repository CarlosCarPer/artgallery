package com.carlos.artgallery.models.services;

import java.util.List;

import com.carlos.artgallery.models.entities.Comment;

public interface ICommentService {

	public List<Comment> findAll();
	public Comment findById(Integer id);
	public Comment save(Comment comment);
	public void delete(Comment comment);
	public void deleteById(int id);
	
}
