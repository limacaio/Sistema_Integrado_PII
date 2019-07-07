package Controller;

import java.util.ArrayList;
import DAO.SituacaoDAO;
import Model.Situacao;



public class SituacaoController {
	public ArrayList<Situacao> buscarSituacaoController(){
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		return situacaoDAO.buscarSituacaoDAO();
	}
public void atualizaSituacaoDescricaoController(Situacao situacao) {
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		
		if(situacaoDAO.atualizarDescricaoDAO(situacao)) {
			System.out.println("AtualizaDO COM SUCESSO");
		}else {
			System.out.println("Erro na atualização");
		}

}
}