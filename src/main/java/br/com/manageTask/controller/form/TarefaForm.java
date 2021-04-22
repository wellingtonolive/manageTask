package br.com.manageTask.controller.form;

import javax.validation.constraints.NotBlank;


import br.com.manageTask.model.Tarefa;

public class TarefaForm {
	
	@NotBlank
	private String nomeTarefa;
	@NotBlank
	private String descricaoTarefa;
	@NotBlank
	private String statusTarefa;
	
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}
	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}
	public String getStatusTarefa() {
		return statusTarefa;
	}
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
	
	public Tarefa toTarefa() {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nomeTarefa);
		tarefa.setDescricao(descricaoTarefa);
		tarefa.setStatus(statusTarefa);
		return tarefa;
	}
	
	

}
