package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModProdutos")
@Table(name = "produtos")
public class ModProdutos implements Serializable{
	
	public enum Medidas{Kg,Lt,Cx,Un,Mt}

	@Id
	@Column(name = "idProduto", nullable = false, length = 13)
	private String idProduto;
	
	@Column(name = "cadastro", nullable = false)
	private LocalDate cadastro;
	
	@Column(name = "descricao", nullable = false, length = 64)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fabricante", nullable = true)
	private ModFabricantes fabricante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo", nullable = true)
	private ModTipoProduto tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "familia", nullable = true)
	private ModFamiliaTributaria familia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grupo", nullable = true)
	private ModGrupo grupo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subGrupo", nullable = true)
	private ModSubGrupo subGrupo;
	
	@Column(name = "un", nullable = true, length = 2)
	private Medidas un;
	
	@Column(name = "precoCusto", nullable = false)
	private BigDecimal precoCusto;
	
	@Column(name = "precoVenda", nullable = false)
	private BigDecimal precoVenda;
	
	@Column(name = "pesoBruto", nullable = true)
	private BigDecimal pesoBruto;
	
	@Column(name = "pesoLiquido", nullable = true)
	private BigDecimal pesoLiquido;
	
	public ModProdutos() {	}

	public ModProdutos(String idProduto, LocalDate cadastro, String descricao, ModFabricantes fabricante,
			ModTipoProduto tipo, ModFamiliaTributaria familia, ModGrupo grupo, ModSubGrupo subGrupo, Medidas un,
			BigDecimal precoCusto, BigDecimal precoVenda, BigDecimal pesoBruto, BigDecimal pesoLiquido) {
		super();
		this.idProduto = idProduto;
		this.cadastro = cadastro;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.tipo = tipo;
		this.familia = familia;
		this.grupo = grupo;
		this.subGrupo = subGrupo;
		this.un = un;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.pesoBruto = pesoBruto;
		this.pesoLiquido = pesoLiquido;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public LocalDate getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ModFabricantes getFabricante() {
		return fabricante;
	}

	public void setFabricante(ModFabricantes fabricante) {
		this.fabricante = fabricante;
	}

	public ModTipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(ModTipoProduto tipo) {
		this.tipo = tipo;
	}

	public ModFamiliaTributaria getFamilia() {
		return familia;
	}

	public void setFamilia(ModFamiliaTributaria familia) {
		this.familia = familia;
	}

	public ModGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(ModGrupo grupo) {
		this.grupo = grupo;
	}

	public ModSubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(ModSubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public Medidas getUn() {
		return un;
	}

	public void setUn(Medidas un) {
		this.un = un;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	@Override
	public String toString() {
		return "ModProdutos [idProduto=" + idProduto + ", cadastro=" + cadastro + ", descricao=" + descricao
				+ ", fabricante=" + fabricante + ", tipo=" + tipo + ", familia=" + familia + ", grupo=" + grupo
				+ ", subGrupo=" + subGrupo + ", un=" + un + ", precoCusto=" + precoCusto + ", precoVenda=" + precoVenda
				+ ", pesoBruto=" + pesoBruto + ", pesoLiquido=" + pesoLiquido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		ModProdutos other = (ModProdutos) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}


	
}
