package br.com.manageTask.controller;

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
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping
	public ModelAndView home() {
		
		List<Tarefa> tarefas = tarefaRepository.findAll();
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("tarefas", tarefas);
		
	}
	
	@GetMapping("/{status}")
	public ModelAndView pendentes(@PathVariable("status") String status) {
		
		List<Tarefa> tarefas = tarefaRepository.findByStatus(StatusTarefa.valueOf(status.toUpperCase()));
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("status", status);
		return mv.addObject("tarefas", tarefas);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
