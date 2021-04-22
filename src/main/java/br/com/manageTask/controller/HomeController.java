package br.com.manageTask.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.manageTask.model.Tarefa;
import br.com.manageTask.repository.TarefaRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping("/home")
	public ModelAndView home() {
		
		List<Tarefa> tarefas = tarefaRepository.findAll();
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("tarefas", tarefas);
		
	}
	
}
