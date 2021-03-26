package avaliacao.participacao;

import java.time.LocalDate;

public class Participacao {

	private int id = 0, idFuncionario;
	private static int countId;
	private LocalDate dataInicio, dataTermino;
	
	public Participacao(int idFuncionario, LocalDate dataInicio, LocalDate dataTermino) {
		if(dataTermino.isAfter(dataInicio) == true) {
			this.id = countId++;
			this.idFuncionario = idFuncionario;
			this.dataInicio = dataInicio;
			this.dataTermino = dataTermino;
		}else
			System.out.println("Erro: data de término é menor que a data de início!");	
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
