package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ModFuncaoColaboradores")
@Table(name = "funcaocolabordores")
public class ModFuncoesColaboradores implements Serializable{

	@Id
	@Column(name = "funcaocolaboradores", nullable = false, length = 20)
	private String funcaoColaboradores;
	
	@Column(name = "proventos", nullable = true)
	private BigDecimal proventos;
	
	@Column(name = "cargahoraria", nullable = true)
	private Integer cargaHoraria;

	public ModFuncoesColaboradores() {
		super();
	}

	public ModFuncoesColaboradores(String funcaoColaboradores, BigDecimal proventos, Integer cargaHoraria) {
		super();
		this.funcaoColaboradores = funcaoColaboradores;
		this.proventos = proventos;
		this.cargaHoraria = cargaHoraria;
	}

	public String getFuncaoColaboradores() {
		return funcaoColaboradores;
	}

	public void setFuncaoColaboradores(String funcaoColaboradores) {
		this.funcaoColaboradores = funcaoColaboradores;
	}

	public BigDecimal getProventos() {
		return proventos;
	}

	public void setProventos(BigDecimal proventos) {
		this.proventos = proventos;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "ModFuncoesColaboradores [funcaoColaboradores=" + funcaoColaboradores + ", proventos=" + proventos
				+ ", cargaHoraria=" + cargaHoraria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcaoColaboradores == null) ? 0 : funcaoColaboradores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModFuncoesColaboradores other = (ModFuncoesColaboradores) obj;
		if (funcaoColaboradores == null) {
			if (other.funcaoColaboradores != null)
				return false;
		} else if (!funcaoColaboradores.equals(other.funcaoColaboradores))
			return false;
		return true;
	}

}
