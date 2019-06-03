package Model;

public class Endereco
{
	private int idEndereco;
	private Cliente cliente;
	private String descricao;
	private String logradouro;
	private int numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	public int getIdEndereco()
	{
		return idEndereco;
	}
	
	public void setIdEndereco(int idEndereco)
	{
		this.idEndereco = idEndereco;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getLogradouro()
	{
		return logradouro;
	}
	
	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public String getComplemento()
	{
		return complemento;
	}
	
	public void setComplemento(String complemento)
	{
		this.complemento = complemento;
	}
	
	public String getCep()
	{
		return cep;
	}
	
	public void setCep(String cep)
	{
		this.cep = cep;
	}
	
	public String getBairro()
	{
		return bairro;
	}
	
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}
	
	public String getCidade()
	{
		return cidade;
	}
	
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
	
	public String getUf()
	{
		return uf;
	}
	
	public void setUf(String uf)
	{
		this.uf = uf;
	}
	
	
}
