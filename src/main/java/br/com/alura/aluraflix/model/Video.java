package br.com.alura.aluraflix.model;

import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



@Entity
public class Video {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@NotBlank
	private String descricao;
	
	private String url;
	
	public Video() {}

	public Video(Long id, String titulo, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String string) {
		this.url = string;
	}

	
}
