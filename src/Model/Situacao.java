package Model;

public class Situacao
{
	public static final String SITUACAO_ID = "idSituacao";
	public static final String DESCRICAO = "descricao";
	
	private int idSituacao;
	private String descricao;
	
	public Situacao () {
		
	}
	public int getIdSituacao() {
		return idSituacao;
	}
	public void setIdSituacao(int idSituacao) {
		this.idSituacao = idSituacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	}
