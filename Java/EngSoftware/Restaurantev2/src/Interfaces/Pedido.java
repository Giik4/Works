package Interfaces;

public abstract class Pedido{
	
	private int prato;
	private float bebida;
	private int codigo;

//===============================================================


	public Pedido(){
		prato = 0;
		bebida = 0;
		codigo = 0;
		
	}

	public void setPrato(int prato){
		this.prato = prato;
	}

	public void setBebida(float bebida){
		this.bebida = bebida;
	}


	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public int getPrato(){
		return prato;
	}

	public float getBebida(){
		return bebida;
	}

	public int getCodigo(){
		return codigo;
	}
}



