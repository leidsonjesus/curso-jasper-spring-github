package br.com.devmedia.curso.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.devmedia.curso.entity.Contato;

public class JpaUtil {

	/*private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager() {
		
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("JPAUnit");
		}
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		List<Contato> contatos = getEntityManager().createQuery("from Contato c").getResultList();
		for (Contato c : contatos) {
			System.out.println(c.getId());
		}
	}*/
}
