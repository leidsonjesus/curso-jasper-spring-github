package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.curso.entity.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	List<Contato> findByNome(String nome);
	
	List<Contato> findByEnderecoCidadeOrderByNomeAsc(String cidade);
	
	@Query("from Contato c where c.nome like %?1% order by c.nome asc")
	List<Contato> findBySobrenome(String sobrenome);

	List<Contato> findByIdIn(List<Long> ids, Sort sort);

	@Query("from Contato c where c.nome like %?1% and c.endereco.cidade like %?2%"
			+ " order by c.nome asc, c.endereco.cidade asc, c.endereco.bairro asc")
	List<Contato> findByNomeAndCidade(String nome, String cidade);
}
