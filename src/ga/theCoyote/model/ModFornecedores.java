package ga.theCoyote.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModFornecedores")
@Table(name = "fornecedores")
public class ModFornecedores implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "idFornecedores", nullable = false)
	private Integer Id;
	
	@Column(name = "cadastro", nullable = false)
	private LocalDate cadastro;
	
	@Column(name = "nome", nullable = false, length = 64)
	private String nome;
	
	@Column(name = "endereco", nullable = true, length = 64)
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
	private String cpfcgc;
	
	@Column(name = "rginscricao", nullable = true, length = 20)
	private String rginscricao;
	
	@Column(name = "celular1", nullable = true, length = 14)
	private String celular1;
	
	@Column(name = "celular2", nullable = true, length = 14)
	private String celular2;
	
	@Column(name = "contato", nullable = true, length = 64)
	private String contato;
	
	@Column(name = "celularContato", nullable = true, length = 14)
	private String celularContato;
	
	@Column(name = "email1", nullable = true, length = 32)
	private String email1;
	
	@Column(name = "email2", nullable = true, length = 32)
	private String email2;

	public ModFornecedores() {
		super();
	}

	public ModFornecedores(Integer id, LocalDate cadastro, String nome, String endereco, String numero,
			String complemento, String bairro, String cidade, String cep, String uf, String referencia, String cpfcgc,
			String rginscricao, String celular1, String celular2, String contato, String celularContato, String email1,
			String email2) {
		super();
		Id = id;
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
		this.cpfcgc = cpfcgc;
		this.rginscricao = rginscricao;
		this.celular1 = celular1;
		this.celular2 = celular2;
		this.contato = contato;
		this.celularContato = celularContato;
		this.email1 = email1;
		this.email2 = email2;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
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

	public String getCpfcgc() {
		return cpfcgc;
	}

	public void setCpfcgc(String cpfcgc) {
		this.cpfcgc = cpfcgc;
	}

	public String getRginscricao() {
		return rginscricao;
	}

	public void setRginscricao(String rginscricao) {
		this.rginscricao = rginscricao;
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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCelularContato() {
		return celularContato;
	}

	public void setCelularContato(String celularContato) {
		this.celularContato = celularContato;
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

	@Override
	public String toString() {
		return "ModFornecedores [Id=" + Id + ", cadastro=" + cadastro + ", nome=" + nome + ", endereco=" + endereco
				+ ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", cep=" + cep + ", uf=" + uf + ", referencia=" + referencia + ", cpfcgc=" + cpfcgc + ", rginscricao="
				+ rginscricao + ", celular1=" + celular1 + ", celular2=" + celular2 + ", contato=" + contato
				+ ", celularContato=" + celularContato + ", email1=" + email1 + ", email2=" + email2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfcgc == null) ? 0 : cpfcgc.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		ModFornecedores other = (ModFornecedores) obj;
		if (cpfcgc == null) {
			if (other.cpfcgc != null)
				return false;
		} else if (!cpfcgc.equals(other.cpfcgc))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
