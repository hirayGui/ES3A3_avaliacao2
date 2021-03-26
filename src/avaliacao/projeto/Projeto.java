package avaliacao.projeto;

import avaliacao.participacao.Participacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

	private int id = 0;
	private static int countId;
	private String titulo;
	private LocalDate dataInicio, dataTermino;
	private boolean ativo;
	private List<Participacao> participacoes = new ArrayList<>();

	public Projeto(String titulo, LocalDate dataInicio, LocalDate dataTermino, boolean ativo, List<Participacao> participacoes) {
		//verifica se a data de término é maior que a data de início
		if(dataTermino.isAfter(dataInicio)) {
			this.id = countId++;
			this.titulo = titulo;
			this.dataInicio = dataInicio;
			this.dataTermino = dataTermino;
			this.ativo = ativo;
			this.participacoes = participacoes;
		}else
			System.out.println("Erro: data de término é menor que data de início!");
	}

	//métodos para gerenciar a lista de participações
	public Participacao saveParticipacao(Participacao participacao) {
		//verifica se o projeto já excedeu o número máximo de participantes
		if(participacoes.size() < 10) {

			//verifica se o projeto está ativo
			if(ativo == true) {

				//verifica se possível participante já está cadastrado
				if(verificarId(participacao) == false) {
					participacoes.add(participacao);
					return participacao;
				}
			}else
				System.out.println("Aviso: O projeto não está mais ativo!");
		}else
			System.out.println("O projeto já atingiu o número máximo de participações");
		return null;		
	}

	public Participacao getById(int id) {
		return participacoes.stream()
				.filter(proj -> proj.getId() == id)
				.findAny()
				.orElse(null);
	}

	public void removeParticipacao(Participacao participacao) {
		participacoes.remove(participacao);
	}

	public List<Participacao> getAllParticipacoes(){
		System.out.println(titulo);
		return participacoes;
	}

	public boolean verificarId(Participacao participacao) {
		for(Participacao P: participacoes) {
			if(P.getId() == participacao.getId()) {
				System.out.println("O Id já está cadastrado!");
				return true;
			}
		}
		System.out.println("Id ainda não cadastrado!");
		return false;
	}

	//getters de Projeto
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public boolean getAtivo() {
		return ativo;
	}
}
