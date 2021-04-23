package br.com.manageTask.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.manageTask.model.StatusTarefa;
import br.com.manageTask.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByStatus(StatusTarefa status);

	@Query("select t from Tarefa t join t.user u where u.username = :username")
	List<Tarefa> findAllByUser(@Param("username") String usuario);

	@Query("Select t from Tarefa t join t.user u WHERE u.username = :username AND t.status = :status")
	List<Tarefa> findByStatusAndUsuario(@Param("status") StatusTarefa status, @Param("username") String username);
	
}
