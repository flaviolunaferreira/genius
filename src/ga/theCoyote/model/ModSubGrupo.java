package ga.theCoyote.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModSubGrupo")
@Table(name = "subgrupo")
public class ModSubGrupo implements Serializable{
	
	@Id
	@Column(name = "subgrupo", nullable = false, length = 20)
	private String subGrupo;
	
	@Column(name = "referencia",nullable = true, length = 30)
	private String referencia;

	public ModSubGrupo() {
		super();
	}

	public ModSubGrupo(String subGrupo, String referencia) {
		super();
		this.subGrupo = subGrupo;
		this.referencia = referencia;
	}

	public String getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(String subGrupo) {
		this.subGrupo = subGrupo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public String toString() {
		return "ModSubGrupo [subGrupo=" + subGrupo + ", referencia=" + referencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subGrupo == null) ? 0 : subGrupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModSubGrupo)) {
			return false;
		}
		ModSubGrupo other = (ModSubGrupo) obj;
		if (subGrupo == null) {
			if (other.subGrupo != null) {
				return false;
			}
		} else if (!subGrupo.equals(other.subGrupo)) {
			return false;
		}
		return true;
	}
		

}
