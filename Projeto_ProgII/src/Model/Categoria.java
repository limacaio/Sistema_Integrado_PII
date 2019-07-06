package Model;

public class Categoria{
	
	public static final String CATEGORIA_COD = "idCategoria";
	public static final String CATEGORIA_DESC = "descricao";
	
	
	private int idCategoria;
	private String descricao;
	
	public int getIdCategoria()
	{
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria)
	{
		this.idCategoria = idCategoria;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao ;
	}
	
	
}
