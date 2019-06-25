package Model;

public class Marca{
	
	public static final String MARCA_ID = "idMarca";
    public static final String MARCA_DESC = "descricaoMarca";
	
	private int idMarca;
	private String descricaoMarca;
	
	public int getIdMarca() {
		return idMarca;
	}
	
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	public String getDescricaoMarca() {
		return descricaoMarca;
	}
	
	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	
}
