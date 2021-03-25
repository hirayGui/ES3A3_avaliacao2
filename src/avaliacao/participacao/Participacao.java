package avaliacao.participacao;

import java.time.LocalDate;

public class Participacao {

	private int id, idFuncionario;
	private LocalDate dataInicio, dataTermino;
	
	public Participacao(int id, int idFuncionario, LocalDate dataInicio, LocalDate dataTermino) {
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	
}
