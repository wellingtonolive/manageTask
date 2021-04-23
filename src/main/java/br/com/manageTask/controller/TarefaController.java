package br.com.manageTask.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.manageTask.controller.form.TarefaForm;
import br.com.manageTask.model.Tarefa;
import br.com.manageTask.model.Usuarios;
import br.com.manageTask.repository.TarefaRepository;
import br.com.manageTask.repository.UsuarioRepository;

@Controller
@RequestMapping("tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("formulario")
	public String formulario(TarefaForm tarefaForm) {
		return "tarefa/formulario";
	}
	
	@PostMapping("nova")
	public String nova(@Valid TarefaForm tarefaForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "tarefa/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuarios usuario = usuarioRepository.findByUsername(username);
		Tarefa tarefa = tarefaForm.toTarefa();
		tarefa.setUser(usuario);
		tarefaRepository.save(tarefa);
		return "redirect:/home";
	}

}
