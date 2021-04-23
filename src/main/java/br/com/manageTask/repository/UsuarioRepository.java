package br.com.manageTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.manageTask.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, String>{
	
	Usuarios findByUsername(String username);
}
