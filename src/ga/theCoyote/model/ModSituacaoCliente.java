package ga.theCoyote.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModSituacaoCliente")
@Table(name = "situacaocliente")
public class ModSituacaoCliente implements Serializable {

	@Id
	@Column(name = "situacaoCliente", nullable = false, length = 20)
	private String situacaoCliente;
	
	@Column(name = "bloquear", nullable = true)
	private boolean bloquear;

	public ModSituacaoCliente() {
		super();
	}

	public ModSituacaoCliente(String situacaoCliente, boolean bloquear) {
		super();
		this.situacaoCliente = situacaoCliente;
		this.bloquear = bloquear;
	}

	public String getSituacaoCliente() {
		return situacaoCliente;
	}

	public void setSituacaoCliente(String situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}

	public boolean isBloquear() {
		return bloquear;
	}

	public void setBloquear(boolean bloquear) {
		this.bloquear = bloquear;
	}

	@Override
	public String toString() {
		return "ModSituacaoCliente [situacaoCliente=" + situacaoCliente + ", bloquear=" + bloquear + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((situacaoCliente == null) ? 0 : situacaoCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModSituacaoCliente)) {
			return false;
		}
		ModSituacaoCliente other = (ModSituacaoCliente) obj;
		if (situacaoCliente == null) {
			if (other.situacaoCliente != null) {
				return false;
			}
		} else if (!situacaoCliente.equals(other.situacaoCliente)) {
			return false;
		}
		return true;
	}
	
}
