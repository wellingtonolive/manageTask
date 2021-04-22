package br.com.manageTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.manageTask.controller.form.TarefaForm;
import br.com.manageTask.model.Tarefa;
import br.com.manageTask.repository.TarefaRepository;

@Controller
@RequestMapping("tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("formulario")
	public String formulario(TarefaForm tarefaForm) {
		return "tarefa/formulario";
	}
	
	@PostMapping("nova")
	public String nova(@Valid TarefaForm tarefaForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "tarefa/formulario";
		}
		
		Tarefa tarefa = tarefaForm.toTarefa();
		tarefaRepository.save(tarefa);
		return "tarefa/formulario";
	}

}
