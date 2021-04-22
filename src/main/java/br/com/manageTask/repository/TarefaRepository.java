package br.com.manageTask.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.manageTask.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
}
