package Model;
 /**
  * 
  *  CLASSE USUARIO 
  *  
  *  WINSTON IGOR **/
public class Usuario {
	
	public static final String USUARIO_ID = "idUsuario";
	public static final String USUARIO_NOME = "nome";
	public static final String USUARIO_EMAIL = "email";
	public static final String USUARIO_SENHA ="senha";
	public static final String USUARIO_TIPO ="tipo";
	//public static final String USUARIO_ADMINISTRADOR = "administrador";
	public static final String USUARIO_SITUACAO ="situacao";
	
	
	
	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String tipo;
	//private Boolean administrador;
	private Boolean situacao;
	
	
	public Usuario () {
		
	}
	
	public Usuario (String nome, String email, String senha, /*Booleanadministrador*/ String tipo, int situacao) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		//this.administrador = administrador;
		
	}
	
	public Boolean getSituacao(){
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}*/
	public String getTipo() {
	return tipo;
	}

	public void setTipo(String tipo) {
	this.tipo = tipo;
	}
	
	

	
}
