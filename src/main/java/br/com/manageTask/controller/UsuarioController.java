package br.com.manageTask.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.manageTask.model.StatusTarefa;
import br.com.manageTask.model.Tarefa;
import br.com.manageTask.repository.TarefaRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("tarefas")
	public ModelAndView home(Principal principal) {
		
		List<Tarefa> tarefas = tarefaRepository.findAllByUser(principal.getName());
		ModelAndView mv = new ModelAndView("usuario/home");
		return mv.addObject("tarefas", tarefas);
		
	}
	
	@GetMapping("tarefas/{status}")
	public ModelAndView pendentes(@PathVariable("status") String status, Principal principal) {
		
		List<Tarefa> tarefas = tarefaRepository.findByStatusAndUsuario(StatusTarefa.valueOf(status.toUpperCase()), principal.getName());
		ModelAndView mv = new ModelAndView("usuario/home");
		mv.addObject("status", status);
		return mv.addObject("tarefas", tarefas);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:usuario/home";
	}

}
