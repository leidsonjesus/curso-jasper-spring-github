package br.com.devmedia.curso.factory;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.devmedia.curso.entity.Contato;
import br.com.devmedia.curso.entity.Telefone;
import br.com.devmedia.curso.util.JpaUtil;

public class DataFactory {

	/*public static List<Telefone> getTelefones() {
		
		EntityManager manager = null;
		
		try {
			
			manager = JpaUtil.getEntityManager();
			
			return manager.createQuery("from Telefone t", Telefone.class).getResultList();
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}
	
	public static List<Contato> getContatos() {
		
		EntityManager manager = null;
		
		try {
			
			manager = JpaUtil.getEntityManager();
			
			return manager.createQuery("from Contato c", Contato.class).getResultList();
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}*/
}
