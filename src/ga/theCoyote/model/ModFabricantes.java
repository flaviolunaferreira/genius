package ga.theCoyote.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModFabricantes")
@Table(name = "fabricantes")
public class ModFabricantes implements Serializable {
	
	@Id
	@Column(name = "fabricante", nullable =false, length = 20)
	private String fabricante;

	public ModFabricantes() {
		super();
	}

	public ModFabricantes(String fabricante) {
		super();
		this.fabricante = fabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "ModFabricantes [fabricante=" + fabricante + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModFabricantes)) {
			return false;
		}
		ModFabricantes other = (ModFabricantes) obj;
		if (fabricante == null) {
			if (other.fabricante != null) {
				return false;
			}
		} else if (!fabricante.equals(other.fabricante)) {
			return false;
		}
		return true;
	}
	
}
