
import java.io.Serializable;


public class Candidato implements Serializable{

    private String nome; 
    private int num; 
    private int votos;

    public Candidato(String nome, int num, int votos) {
        this.nome = nome;
        this.num = num;
        this.votos = votos;
    }

    
    public String getNome(){
        return nome;
    }
    
    public int getNum(){
        return num;
    }
    
    public int getVotos(){
        return votos;
    }
    
    public void setVotos(int votos){
        this.votos = votos;
    }
    
    
}

