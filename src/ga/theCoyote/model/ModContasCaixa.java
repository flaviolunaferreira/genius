package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModContasCaixa")
@Table(name = "contasCaixa")
public class ModContasCaixa implements Serializable{

	@Id
	@Column(name = "numero", nullable = false, length = 10)
	private String numero;
	
	@Column(name = "cadastro", nullable = false)
	private Date cadastro;
	
	@Column(name = "descricao", nullable = false, length = 64)
	private String descricao;
	
	@Column(name = "definirMeta", nullable = false)
	private BigDecimal definirMeta;
	
	@Column(name = "tipo", nullable = false, length = 10)
	private BigDecimal tipo;

	public ModContasCaixa() {
		super();
	}

	public ModContasCaixa(Date cadastro, String descricao, BigDecimal definirMeta, BigDecimal tipo) {
		super();
		this.cadastro = cadastro;
		this.descricao = descricao;
		this.definirMeta = definirMeta;
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getDefinirMeta() {
		return definirMeta;
	}

	public void setDefinirMeta(BigDecimal definirMeta) {
		this.definirMeta = definirMeta;
	}

	public BigDecimal getTipo() {
		return tipo;
	}

	public void setTipo(BigDecimal tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ModContasCaixa [numero=" + numero + ", cadastro=" + cadastro + ", descricao=" + descricao
				+ ", definirMeta=" + definirMeta + ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModContasCaixa)) {
			return false;
		}
		ModContasCaixa other = (ModContasCaixa) obj;
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}


}
