package br.edu.ifms.horasc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Horas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String curso;
	private double horaContemplada;
	private String certificado;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCurso;
	
	@JoinColumn(name="usuario_id")
	@ManyToOne
	private Usuario usuario;
	@JoinColumn(name="cursovalido_id")
	@ManyToOne
	private CursoValido cursoValido;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getHoraContemplada() {
		return horaContemplada;
	}
	public void setHoraContemplada(double horaContemplada) {
		this.horaContemplada = horaContemplada;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public LocalDate getDataCurso() {
		return dataCurso;
	}
	public void setDataCurso(LocalDate dataCurso) {
		this.dataCurso = dataCurso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public CursoValido getCursoValido() {
		return cursoValido;
	}
	public void setCursoValido(CursoValido cursoValido) {
		this.cursoValido = cursoValido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horas other = (Horas) obj;
		return Objects.equals(id, other.id);
	}
	
}