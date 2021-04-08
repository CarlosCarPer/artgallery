package com.carlos.artgallery.models.entities;
// Generated 8 abr. 2021 17:12:20 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "comment")
public class Comment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int commentId;
	@JsonIgnore
	private Comment comment;
	@JsonIgnore
	private Usuario usuario;
	private String commentary;
	private Integer likes;
	private String commentDate;
	private Set<Comment> comments = new HashSet<Comment>();

	public Comment() {
	}

	public Comment(int commentId, Usuario usuario, String commentary, String commentDate) {
		this.commentId = commentId;
		this.usuario = usuario;
		this.commentary = commentary;
		this.commentDate = commentDate;
	}

	public Comment(int commentId, Comment comment, Usuario usuario, String commentary, Integer likes,
			String commentDate, Set<Comment> comments) {
		this.commentId = commentId;
		this.comment = comment;
		this.usuario = usuario;
		this.commentary = commentary;
		this.likes = likes;
		this.commentDate = commentDate;
		this.comments = comments;
	}

	@Id

	@Column(name = "comment_id", unique = true, nullable = false)
	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reply_id")
	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "commentary", nullable = false, length = 10485760)
	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	@Column(name = "likes")
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Column(name = "comment_date", nullable = false, length = 100)
	public String getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
