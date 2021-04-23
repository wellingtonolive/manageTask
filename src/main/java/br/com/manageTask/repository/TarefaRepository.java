package br.com.manageTask.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.manageTask.model.StatusTarefa;
import br.com.manageTask.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByStatus(StatusTarefa status);
}
