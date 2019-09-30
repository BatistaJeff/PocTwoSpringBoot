package com.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.demo.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -3022986767547290005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "valor_hora", nullable = false)
	private BigDecimal valorHora;
	
	@Column(name = "qtd_hr_trabalho_dia", nullable = false)
	private Float qtdHrTrabalhoDia;
	
	@Column(name = "qtd_hr_almoco", nullable = false)
	private Float qtdHrAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;

	@Transient
	private BigDecimal valorHoraOpt;
	@Transient
	private Float qtdHorasTrabalhoDiaOpt;
	@Transient
	private Float qtdHorasAlmocoOpt;
	
	public Funcionario() {	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtdHrTrabalhoDia() {
		return qtdHrTrabalhoDia;
	}

	public void setQtdHrTrabalhoDia(Float qtdHrTrabalhoDia) {
		this.qtdHrTrabalhoDia = qtdHrTrabalhoDia;
	}

	public Float getQtdHrAlmoco() {
		return qtdHrAlmoco;
	}

	public void setQtdHrAlmoco(Float qtdHrAlmoco) {
		this.qtdHrAlmoco = qtdHrAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHrTrabalhoDia=" + qtdHrTrabalhoDia + ", qtdHrAlmoco=" + qtdHrAlmoco
				+ ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao
				+ ", empresa=" + empresa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHoraOpt);
	}

	public void setValorHoraOpt(BigDecimal valorHoraOpt) {
		this.valorHoraOpt = valorHoraOpt;
	}

	public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDiaOpt);
	}

	public void setQtdHorasTrabalhoDiaOpt(Float qtdHorasTrabalhoDiaOpt) {
		this.qtdHorasTrabalhoDiaOpt = qtdHorasTrabalhoDiaOpt;
	}

	public Optional<Float> getQtdHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmocoOpt);
	}

	public void setQtdHorasAlmocoOpt(Float qtdHorasAlmocoOpt) {
		this.qtdHorasAlmocoOpt = qtdHorasAlmocoOpt;
	}


	
}
