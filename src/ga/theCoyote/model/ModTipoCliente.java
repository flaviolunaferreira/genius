package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Autor Flavio
 */

@Entity(name = "ModTipoCliente")
@Table(name = "tipocliente")
public class ModTipoCliente implements Serializable {
	
	@Id
	@Column(name = "tipoCliente", nullable = false, length = 20)
	private String tipoCliente;
	
	@Column(name = "descontoAcrescimo", nullable = true)
	private BigDecimal descontoAcrescimo;
	
	@Column(name = "prazo", nullable = true)
	private Integer prazo;	 
	
	public ModTipoCliente() {
		super();
	}

	public ModTipoCliente(String tipoCliente, BigDecimal descontoAcrescimo, Integer prazo) {
		super();
		this.tipoCliente = tipoCliente;
		this.descontoAcrescimo = descontoAcrescimo;
		this.prazo = prazo;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public BigDecimal getDescontoAcrescimo() {
		return descontoAcrescimo;
	}

	public void setDescontoAcrescimo(BigDecimal descontoAcrescimo) {
		this.descontoAcrescimo = descontoAcrescimo;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	@Override
	public String toString() {
		return "ModTipoCliente [tipoCliente=" + tipoCliente + ", prazo=" + prazo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoCliente == null) ? 0 : tipoCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModTipoCliente)) {
			return false;
		}
		ModTipoCliente other = (ModTipoCliente) obj;
		if (tipoCliente == null) {
			if (other.tipoCliente != null) {
				return false;
			}
		} else if (!tipoCliente.equals(other.tipoCliente)) {
			return false;
		}
		return true;
	}
	
}
