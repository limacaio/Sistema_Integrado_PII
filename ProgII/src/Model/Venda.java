package Model;

import java.util.Date;
import java.util.List;

public class Venda
{
	private int idVenda;
	private Cliente cliente;
	private Date dataVenda;
	private Situacao situacao;
	private List<Produto> produtos;
	private Endereco endereco;
	
	public int getIdVenda()
	{
		return idVenda;
	}
	
	public void setIdVenda(int idVenda)
	{
		this.idVenda = idVenda;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}
	
	public Date getDataVenda()
	{
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda)
	{
		this.dataVenda = dataVenda;
	}
	
	public Situacao getSituacao()
	{
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) 
	{
		this.situacao = situacao;
	}
	
	public List<Produto> getProdutos()
	{
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}
	
	
	
}
