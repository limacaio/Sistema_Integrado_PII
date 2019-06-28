package Model;

public class Produto{
	
	public static final String PRODUTO_COD   ="idProduto";
	public static final String PRODUTO_NOME  ="nomeProduto";
	public static final String PRODUTO_DESC  ="descricaoproduto";
	public static final String PRODUTO_PRECO ="precoVenda";
	public static final String PRODUTO_SALDO ="estoque";
	public static final String PRODUTO_CATEG ="categoria";
	public static final String PRODUTO_MARCA ="marca";
	public static final String PRODUTO_IMAGEM ="imagem";
	
	
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private float precoVenda;
	private int estoque;
	private Categoria categoria;
	private Marca marca;
	private String imagem;
	
	
	public int getIdProduto()
	{
		return idProduto;
	}
	public void setIdProduto(int idProduto)
	{
		this.idProduto = idProduto;
	}
	public String getNomeProduto()
	{
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto)
	{
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto()
	{
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto)
	{
		this.descricaoProduto = descricaoProduto;
	}
	public double getPrecoVenda()
	{
		return precoVenda;
	}
	public void setPrecoVenda(float precoVenda)
	{
		this.precoVenda = precoVenda;
	}
	public int getEstoque()
	{
		return estoque;
	}
	public void setEstoque(int estoque)
	{
		this.estoque = estoque;
	}
	
	public Categoria getCategoria()
	{
		return categoria;
	}
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}
	public Marca getMarca()
	{
		return marca;
	}
	public void setMarca(Marca marca)
	{
		this.marca = marca;
	}
	public String getImagem()
	{
		return imagem;
	}
	public void setImagem(String imagem)
	{
		this.imagem = imagem;
	}
	
	
}
