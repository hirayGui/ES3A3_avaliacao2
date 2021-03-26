package avaliacao.main;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import avaliacao.projeto.*;
import avaliacao.participacao.*;

public class Main {

	public static ProjetoRepository projetos = new ProjetoRepository();
	public static void main(String[] args) {
		Projeto projeto = null;
		List<Participacao> participacoes = new ArrayList<>();
		Scanner s = new Scanner(System.in);

		/*
		 * tive problemas com o LocalDate que era submetido ao Scanner e não consegui
		 * arrumar esse erro (Unparseable date), então a data tem que ser modificada no
		 * código para testar as condições da data de término e da data de inicio*/
		LocalDate dataInicio = LocalDate.of(2020, 6, 9);
		LocalDate dataTermino = LocalDate.of(2022, 5, 8);
		
		int opcao = 0, id;
		String aux, titulo;
		boolean ativo = true;
		
		

		do {
			System.out.println("Gerenciador de Projetos"
					+ "\n======================="
					+ "\n\nEscolha uma opção:"
					+ "\n[1] Criar Projeto"
					+ "\n[2] Adicionar Participação ao Projeto"
					+ "\n[3] Listar Participações"
					+ "\n[4] Pesquisar Participação por ID"
					+ "\n[5] Remover Participação do Projeto"
					+ "\n[6] Salvar Projeto"
					+ "\n[7] Listar Projetos"
					+ "\n[8] Pesquisar Projeto por ID"
					+ "\n[9] Remover Projeto"
					+ "\n[0] Sair"
					+ "\n");
			opcao = s.nextInt();
			
			s.nextLine();
			System.out.println("\n\n\n");
			switch(opcao) {
			case 1:
				System.out.println("<Criar Projeto>");

				System.out.println("Informe o titulo do Projeto: ");
				titulo = s.nextLine();

				System.out.println("O projeto está ativo ? (S/N)");
				aux = s.nextLine();
				if(aux == "S" || aux == "s") {
					ativo = true;
				}else 
					if(aux == "N" || aux == "n") {
						ativo = true;
					}

				projeto = new Projeto(titulo, dataInicio, dataTermino, ativo, participacoes = new ArrayList<>());
				break;

			case 2:
				System.out.println("<Adicionar Participações ao Projeto>");

				System.out.println("Informe o ID do funcionário: ");
				id = s.nextInt();

				projeto.saveParticipacao(new Participacao(id, dataInicio, dataTermino));
				break;

			case 3:
				System.out.println("<Listar Participações>");

				System.out.println(projeto.getAllParticipacoes());
				break;

			case 4:
				System.out.println("<Buscar Participação por ID>");

				System.out.println("Informe o ID: ");
				id = s.nextInt();
				
				System.out.println(projeto.getById(id));
				break;

			case 5:
				System.out.println("<Remover Participação do Projeto>");
				
				System.out.println("Informe o ID: ");
				id = s.nextInt();
				
				projeto.removeParticipacao(projeto.getById(id));
				break;

			case 6:
				System.out.println("<Salvar Projeto>");
				
				System.out.println("Salvando projeto...");
				projetos.save(projeto);
				
				break;

			case 7:
				System.out.println("<Listar Projetos>");
				
				projetos.getAll();
				System.out.println(projetos.getAll());
				break;

			case 8:
				System.out.println("<Pesquisar Projeto por ID>");
				
				System.out.println("Informe o ID do Projeto: ");
				id = s.nextInt();
				
				projetos.getById(id);
				break;

			case 9:
				System.out.println("<Remover Projeto>");
				
				System.out.println("Informe o ID do Projeto a ser removido: ");
				id = s.nextInt();
				
				projetos.delete(projetos.getById(id));
				break;

			case 0:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (opcao != 0);

		s.close();
	}

}
