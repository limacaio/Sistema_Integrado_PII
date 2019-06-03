package Model;

import java.awt.image.BufferedImage;

public class Produto
{
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private double precoVenda;
	private int estoque;
	private int estoqueMin;
	private Categoria categoria;
	private Marca marca;
	private BufferedImage imagem;
	
	
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
	public void setPrecoVenda(double precoVenda)
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
	public int getEstoqueMin()
	{
		return estoqueMin;
	}
	public void setEstoqueMin(int estoqueMin)
	{
		this.estoqueMin = estoqueMin;
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
	public BufferedImage getImagem()
	{
		return imagem;
	}
	public void setImagem(BufferedImage imagem)
	{
		this.imagem = imagem;
	}
	
	
}
