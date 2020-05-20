package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.curso.entity.GraficoView;

public interface GraficoViewRepository extends JpaRepository<GraficoView, String> {

	@Query(name = "GraficoView", nativeQuery = true)
	List<GraficoView> findGraicoView();
}
