package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itensprodutos")
public class ModItensProdutos implements Serializable{

	@Id
	@Column(name = "produtoId", nullable = false, length = 13)
	private String produtoId;
	
	@Id
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto", nullable = false)
	private ModProdutos produto;
		
	@Column(name = "quantidade", nullable = false)
	private BigDecimal quantidade;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	public ModItensProdutos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModItensProdutos(String produtoId, ModProdutos produto, BigDecimal quantidade, BigDecimal valor) {
		super();
		this.produtoId = produtoId;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	public ModProdutos getProduto() {
		return produto;
	}

	public void setProduto(ModProdutos produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
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
		ModItensProdutos other = (ModItensProdutos) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModItensProdutos [produtoId=" + produtoId + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", valor=" + valor + "]";
	}	
	
}


