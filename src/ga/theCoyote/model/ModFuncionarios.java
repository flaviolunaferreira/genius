package ga.theCoyote.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "ModFuncionarios")
@Table(name = "funcionarios")
public class ModFuncionarios {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "cadastro", nullable = false)
	private LocalDate cadastro;
	
	@Column(name = "nome", nullable = false, length = 64)
	private String nome;
	
	@Column(name = "endereco", nullable = false, length = 64)
	private String endereco;
	
	@Column(name = "numero", nullable = true, length = 12)
	private String numero;
	
	@Column(name = "complemento", nullable = true, length = 64)
	private String complemento;
	
	@Column(name = "bairro", nullable = true, length = 32)
	private String bairro;
	
	@Column(name = "cidade", nullable = true, length = 32)
	private String cidade;
	
	@Column(name = "cep", nullable = true, length = 10)
	private String cep;
	
	@Column(name = "uf", nullable = true, length = 2)
	private String uf;
	
	@Column(name = "referencia", nullable = true, length = 64)
	private String referencia;
	
	@Column(name = "cpfcgc", nullable = true, length = 20)
	private String cpfCgc;
	
	@Column(name = "rginscricao", nullable = true, length = 20)
	private String rgInscricao;
	
	@Column(name = "celular1", nullable = true, length = 14)
	private String celular1;
	
	@Column(name = "celular2", nullable = true, length = 14)
	private String celular2;
		
	@Column(name = "email1", nullable = true, length = 32)
	private String email1;
	
	@Column(name = "email2",nullable = true, length = 32)
	private String email2;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Funcao", nullable = false)
	private ModFuncoesColaboradores funcao;
	
	@Column(name = "salario", nullable = false)
	private BigDecimal salario;
	
	@Column(name = "cargaHoraria", nullable = true)
	private Integer cargaHoraria;
	
	@Column(name = "senha", nullable = false, length = 16)
	private String senha;
	
	@Column(name = "nivelacesso", nullable = false, length = 2)
	private Integer nivelAcesso;

	public ModFuncionarios() {
		super();
	}

	public ModFuncionarios(Integer id, LocalDate cadastro, String nome, String endereco, String numero,
			String complemento, String bairro, String cidade, String cep, String uf, String referencia, String cpfCgc,
			String rgInscricao, String celular1, String celular2, String email1, String email2,
			ModFuncoesColaboradores funcao, BigDecimal salario, Integer cargaHoraria, String senha,
			Integer nivelAcesso) {
		super();
		this.id = id;
		this.cadastro = cadastro;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.referencia = referencia;
		this.cpfCgc = cpfCgc;
		this.rgInscricao = rgInscricao;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.email1 = email1;
		this.email2 = email2;
		this.funcao = funcao;
		this.salario = salario;
		this.cargaHoraria = cargaHoraria;
		this.senha = senha;
		this.nivelAcesso = nivelAcesso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDate cadastro) {
		this.cadastro = cadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCpfCgc() {
		return cpfCgc;
	}

	public void setCpfCgc(String cpfCgc) {
		this.cpfCgc = cpfCgc;
	}

	public String getRgInscricao() {
		return rgInscricao;
	}

	public void setRgInscricao(String rgInscricao) {
		this.rgInscricao = rgInscricao;
	}

	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public ModFuncoesColaboradores getFuncao() {
		return funcao;
	}

	public void setFuncao(ModFuncoesColaboradores funcao) {
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(Integer nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	@Override
	public String toString() {
		return "ModFuncionarios [id=" + id + ", cadastro=" + cadastro + ", nome=" + nome + ", endereco=" + endereco
				+ ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", cep=" + cep + ", uf=" + uf + ", referencia=" + referencia + ", cpfCgc=" + cpfCgc + ", rgInscricao="
				+ rgInscricao + ", celular1=" + celular1 + ", celular2=" + celular2 + ", email1=" + email1 + ", email2="
				+ email2 + ", funcao=" + funcao + ", salario=" + salario + ", cargaHoraria=" + cargaHoraria + ", senha="
				+ senha + ", nivelAcesso=" + nivelAcesso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCgc == null) ? 0 : cpfCgc.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		ModFuncionarios other = (ModFuncionarios) obj;
		if (cpfCgc == null) {
			if (other.cpfCgc != null)
				return false;
		} else if (!cpfCgc.equals(other.cpfCgc))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
