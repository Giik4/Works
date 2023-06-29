package Interfaces;


public class Funcionario {
	private String cargo;
	private String login;
	private String senha;

		
		public Funcionario(){
		cargo = "";
		login = "";
		senha = "";
	}

	public String getCargo (){
		return cargo;
	}

	public String getLogin (){
		return login;
	}

	public String getSenha(){
		return senha;
	}

	public void setCargo (String cargo){
		this.cargo = cargo;
	}

	public void setLogin (String login){
		this.login = login;
	}

	public void setSenha (String senha){
		this.senha = senha;
	}
}
