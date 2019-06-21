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
	//public static final String USUARIO_ADMINISTRADOR = "administrador";
	
	
	
	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private Boolean administrador;
	
	
	public Usuario () {
		
	}
	
	public Usuario (String nome, String email, String senha, Boolean administrador) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.administrador = administrador;
		
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

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	
	

	
}
