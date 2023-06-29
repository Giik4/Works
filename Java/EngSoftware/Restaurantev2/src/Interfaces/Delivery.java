package Interfaces;

public final class Delivery extends Pedido{
	private String endereco;

//=============================================

	public Delivery(){
		endereco = "";
	}


//==============================================
	
	public String getEndereco(){
		return endereco;
	}

//==============================================
	
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
}