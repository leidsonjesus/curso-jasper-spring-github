package br.com.devmedia.curso.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TELEFONES")
public class Telefone implements Serializable {
	@Transient
	public final static String CELULAR = "Celular";
	@Transient
	public final static String FIXO = "Fixo";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	
	private String tipoFone;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Contato contato;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoFone() {
		return tipoFone;
	}

	public void setTipoFone(String tipoFone) {
		this.tipoFone = tipoFone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipoFone=" + tipoFone + ", contato=" + contato + "]";
	}


}
