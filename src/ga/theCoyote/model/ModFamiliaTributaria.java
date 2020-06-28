package ga.theCoyote.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author flavio
 */

@Entity(name = "ModFamiliaTributaria")
@Table(name = "familiatributaria")
public class ModFamiliaTributaria implements Serializable{
	
	@Id
	@Column(name = "familiatributaria")
	private String familiaTributaria;
	
	@Column(name = "ipi", nullable = true)
	private BigDecimal ipi;
	
	@Column(name = "icms", nullable = true)
	private BigDecimal icms;
	
	@Column(name = "cofins", nullable = true)
	private BigDecimal cofins;
	
	@Column(name = "pis", nullable = true)
	private BigDecimal pis;
	
	@Column(name = "iss", nullable = true)
	private BigDecimal iss;

	public ModFamiliaTributaria() {
		super();
	}

	public ModFamiliaTributaria(String familiaTributaria, BigDecimal ipi, BigDecimal icms, BigDecimal cofins,
			BigDecimal pis, BigDecimal iss) {
		super();
		this.familiaTributaria = familiaTributaria;
		this.ipi = ipi;
		this.icms = icms;
		this.cofins = cofins;
		this.pis = pis;
		this.iss = iss;
	}

	public String getFamiliaTributaria() {
		return familiaTributaria;
	}

	public void setFamiliaTributaria(String familiaTributaria) {
		this.familiaTributaria = familiaTributaria;
	}

	public BigDecimal getIpi() {
		return ipi;
	}

	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getCofins() {
		return cofins;
	}

	public void setCofins(BigDecimal cofins) {
		this.cofins = cofins;
	}

	public BigDecimal getPis() {
		return pis;
	}

	public void setPis(BigDecimal pis) {
		this.pis = pis;
	}

	public BigDecimal getIss() {
		return iss;
	}

	public void setIss(BigDecimal iss) {
		this.iss = iss;
	}

	@Override
	public String toString() {
		return "ModFamiliaTributaria [familiaTributaria=" + familiaTributaria + ", ipi=" + ipi + ", icms=" + icms
				+ ", cofins=" + cofins + ", pis=" + pis + ", iss=" + iss + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familiaTributaria == null) ? 0 : familiaTributaria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ModFamiliaTributaria)) {
			return false;
		}
		ModFamiliaTributaria other = (ModFamiliaTributaria) obj;
		if (familiaTributaria == null) {
			if (other.familiaTributaria != null) {
				return false;
			}
		} else if (!familiaTributaria.equals(other.familiaTributaria)) {
			return false;
		}
		return true;
	}


}
