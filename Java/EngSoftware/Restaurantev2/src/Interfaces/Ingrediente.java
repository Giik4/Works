package Interfaces;

public class Ingrediente{
  private String nomeIngrediente;
  private int codIngrediente;
  private int qtdIngrediente;

  public Ingrediente(){
      nomeIngrediente="";
      codIngrediente=0;
      qtdIngrediente=0;
  }

  public String getNomeIngrediente(){
    return nomeIngrediente;
  }

  public int getCodIngrediente(){
    return codIngrediente;
  }

  public int getQtdIngrediente(){
    return qtdIngrediente;
  }

  public void setNomeIngrediente(String nomeIngrediente){
    this.nomeIngrediente=nomeIngrediente;
  }

  public void setCodIngrediente(int codIngrediente){
    this.codIngrediente=codIngrediente;
  }

  public void setQtdIngrediente(int qtdIngrediente){
    this.qtdIngrediente=qtdIngrediente;
  }
}