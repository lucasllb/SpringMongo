package com.lucasBittencourt.springMongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommetDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private AuthoDTO autor;
	
	public CommetDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommetDTO(String text, Date date, AuthoDTO autor) {
		super();
		this.text = text;
		this.date = date;
		this.autor = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthoDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthoDTO autor) {
		this.autor = autor;
	}
	
	
	
}
