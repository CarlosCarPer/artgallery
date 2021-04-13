package com.carlos.artgallery.models.entities;
// Generated 12 abr. 2021 10:58:46 by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Art generated by hbm2java
 */
@Entity
@Table(name = "art")
public class Art implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int artId;
	@JsonIgnore
	private Usuario usuario;
	private String title;
	private String description;
	private String author;
	private String url;
	private String tags;
	private Integer likes;
	private Date artDate;

	public Art() {
	}

	public Art(int artId, Usuario usuario, String title, String author, Date artDate) {
		this.artId = artId;
		this.usuario = usuario;
		this.title = title;
		this.author = author;
		this.artDate = artDate;
	}

	public Art(int artId, Usuario usuario, String title, String description, String author, String url, String tags,
			Integer likes, Date artDate) {
		this.artId = artId;
		this.usuario = usuario;
		this.title = title;
		this.description = description;
		this.author = author;
		this.url = url;
		this.tags = tags;
		this.likes = likes;
		this.artDate = artDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "art_id", unique = true, nullable = false)
	public int getArtId() {
		return this.artId;
	}

	public void setArtId(int artId) {
		this.artId = artId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 10485760)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "author", nullable = false, length = 100)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "url", length = 10485760)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "tags", length = 100)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "likes")
	public Integer getLikes() {
		return this.likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Column(name = "art_date", nullable = false, length = 100)
	public Date getArtDate() {
		return this.artDate;
	}

	public void setArtDate(Date artDate) {
		this.artDate = artDate;
	}

}
