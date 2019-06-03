package Model;

import java.util.Date;
import java.util.List;

public class Cliente
{
	private int idCLiente;
	private String nome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private String senha;
	private Date dtNascimento;
	private List<Endereco> enderecos;
	
	public int getIdCLiente()
	{
		return idCLiente;
	}
	
	public void setIdCLiente(int idCLiente)
	{
		this.idCLiente = idCLiente;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCpf()
	{
		return cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	public String getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getCelular()
	{
		return celular;
	}
	
	public void setCelular(String celular)
	{
		this.celular = celular;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getSenha()
	{
		return senha;
	}
	
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public Date getDtNascimento()
	{
		return dtNascimento;
	}
	
	public void setDtNascimento(Date dtNascimento)
	{
		this.dtNascimento = dtNascimento;
	}
	
	public List<Endereco> getEnderecos()
	{
		return enderecos;
	}
	
	public void setEnderecos(List<Endereco> enderecos)
	{
		this.enderecos = enderecos;
	}
	
	
	
}
