package ga.theCoyote.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModGrupo")
@Table(name = "grupo")
public class ModGrupo implements Serializable{
	
	@Id
	@Column(name = "grupo", nullable = false, length = 20)
	private String grupo;
	
	@Column(name="referencia", nullable = true, length = 30)
	private String referrencia;

	public ModGrupo() {
		super();
	}

	public ModGrupo(String grupo, String referrencia) {
		super();
		this.grupo = grupo;
		this.referrencia = referrencia;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getReferrencia() {
		return referrencia;
	}

	public void setReferrencia(String referrencia) {
		this.referrencia = referrencia;
	}

	@Override
	public String toString() {
		return "ModGrupo [grupo=" + grupo + ", referrencia=" + referrencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModGrupo)) {
			return false;
		}
		ModGrupo other = (ModGrupo) obj;
		if (grupo == null) {
			if (other.grupo != null) {
				return false;
			}
		} else if (!grupo.equals(other.grupo)) {
			return false;
		}
		return true;
	}
	
}
