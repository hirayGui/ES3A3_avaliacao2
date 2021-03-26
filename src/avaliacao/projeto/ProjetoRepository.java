package avaliacao.projeto;

import java.util.ArrayList;
import java.util.List;

public class ProjetoRepository {

	private List<Projeto> projetos = new ArrayList<>();
	
	public Projeto save(Projeto projeto) {
		projetos.add(projeto);
		return projeto;
	}
	
	public void delete(Projeto projeto) {
		projetos.remove(projeto);
	}
	
	public List<Projeto> getAll(){
		return projetos;
	}
	
	public Projeto getById(int id) {
		return projetos.stream()
				.filter(proj -> proj.getId() == id)
				.findAny()
				.orElse(null);
}
}
