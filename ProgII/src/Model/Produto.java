package Model;

public class Produto{
	
	public static final String PRODUTO_COD   ="idProduto";
	public static final String PRODUTO_NOME  ="nome";
	public static final String PRODUTO_DESC  ="descricao";
	public static final String PRODUTO_PRECO ="valor";
	public static final String PRODUTO_SALDO ="saldo";
	public static final String PRODUTO_CATEG ="idCategoria";
	public static final String PRODUTO_MARCA ="idMarca";
	public static final String PRODUTO_IMAGEM ="imagem";
	public static final String PRODUTO_U_M = "unidadeMedida";
	
	
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private float precoVenda;
	private float estoque;
	private String unidadeMedida;
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
	public float getEstoque()
	{
		return estoque;
	}
	public void setEstoque(float estoque)
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
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	
	
	
}
