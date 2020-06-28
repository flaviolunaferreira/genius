package ga.theCoyote.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModTipoProduto")
@Table(name = "tipoproduto")
public class ModTipoProduto implements Serializable{

	@Id
	@Column(name = "tipoproduto", nullable = false, length = 20)
	private String tipoProduto;
	
	@Column(name = "composicao", nullable = true)
	private boolean composicao;
	
	@Column(name = "custo", nullable = false)
	private boolean custo;
	
	@Column(name = "verder", nullable = true)
	private boolean vender;
	
	@Column(name = "vencimento", nullable = true)
	private boolean vencimento;

	public ModTipoProduto() {
		super();
	}

	public ModTipoProduto(String tipoProduto, boolean composicao, boolean custo, boolean vender, boolean vencimento) {
		super();
		this.tipoProduto = tipoProduto;
		this.composicao = composicao;
		this.custo = custo;
		this.vender = vender;
		this.vencimento = vencimento;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public boolean isComposicao() {
		return composicao;
	}

	public void setComposicao(boolean composicao) {
		this.composicao = composicao;
	}

	public boolean isCusto() {
		return custo;
	}

	public void setCusto(boolean custo) {
		this.custo = custo;
	}

	public boolean isVender() {
		return vender;
	}

	public void setVender(boolean vender) {
		this.vender = vender;
	}

	public boolean isVencimento() {
		return vencimento;
	}

	public void setVencimento(boolean vencimento) {
		this.vencimento = vencimento;
	}

	@Override
	public String toString() {
		return "ModTipoProduto [tipoProduto=" + tipoProduto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModTipoProduto)) {
			return false;
		}
		ModTipoProduto other = (ModTipoProduto) obj;
		if (tipoProduto == null) {
			if (other.tipoProduto != null) {
				return false;
			}
		} else if (!tipoProduto.equals(other.tipoProduto)) {
			return false;
		}
		return true;
	}
	

	
}
