package Interfaces;

public final class Fisico extends Pedido{
	private int mesa;

//=============================================

	public Fisico(){
		mesa = 	0;
	}


//==============================================
	
	public int getMesa(){
		return mesa;
	}

//==============================================
	
	public void setMesa(int mesa){
		this.mesa = mesa;
	}

    String getCod(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}