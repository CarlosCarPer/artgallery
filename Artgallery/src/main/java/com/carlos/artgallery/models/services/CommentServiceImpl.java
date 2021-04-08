package com.carlos.artgallery.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carlos.artgallery.models.dao.ICommentDao;
import com.carlos.artgallery.models.entities.Comment;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private ICommentDao commentDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Comment> findAll() {
		return (List<Comment>) commentDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Comment findById(Integer id) {
		// TODO Auto-generated method stub
		return commentDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Comment save(Comment comment) {
		return commentDao.save(comment);
	}
	
	@Override
	@Transactional
	public void delete(Comment comment) {
		commentDao.delete(comment);		
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		commentDao.deleteById(id);		
	}
	
}

