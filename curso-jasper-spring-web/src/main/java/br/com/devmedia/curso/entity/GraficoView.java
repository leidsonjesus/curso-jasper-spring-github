package br.com.devmedia.curso.entity;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
		name = "GraficoView",
		query = "select * from graficoview",
		resultClass = GraficoView.class)
public class GraficoView {

	@Id
	private String cidade;
	
	private Long totalContatosCidade;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getTotalContatosCidade() {
		return totalContatosCidade;
	}

	public void setTotalContatosCidade(Long totalContatosCidade) {
		this.totalContatosCidade = totalContatosCidade;
	}

	@Override
	public String toString() {
		return "GraficoView [cidade=" + cidade + ", totalContatosCidade=" + totalContatosCidade + "]";
	}
	
	
}
