package br.edu.ifms.sicac.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CursoValido implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String categoriaCurso;
	@NotNull(message = "O campo total hora da categoria é obrigatório")
	@DateTimeFormat(pattern = "hh:mm")
	private double totalHoraValida;
	@OneToMany(mappedBy="cursoValido")
	private List<Horas> horas;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoriaCurso() {
		return categoriaCurso;
	}
	public void setCategoriaCurso(String categoriaCurso) {
		this.categoriaCurso = categoriaCurso;
	}
	public double getTotalHoraValida() {
		return totalHoraValida;
	}
	public void setTotalHoraValida(double totalHoraValida) {
		this.totalHoraValida = totalHoraValida;
	}
	public List<Horas> getHoras() {
		return horas;
	}
	public void setHoras(List<Horas> horas) {
		this.horas = horas;
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
		CursoValido other = (CursoValido) obj;
		return Objects.equals(id, other.id);
	}
	
}
