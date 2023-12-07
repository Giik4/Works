
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gikas
 */
public class EleicaoImpl extends UnicastRemoteObject implements IEleicao, Serializable{
   
    public static ArrayList<Candidato> candidatos;

    public EleicaoImpl() throws RemoteException{
         super();
    }

    @Override
    public boolean inicia() throws RemoteException {
        candidatos = new ArrayList<Candidato>();
        
        return true;
    }

    @Override
    public boolean cadastrar(Candidato candidato) throws RemoteException {
        this.candidatos.add(candidato);
        
        return true;
    }
    
     @Override
    public boolean deletar(Candidato candidato) throws RemoteException {
         for (Candidato candidatoLista : this.candidatos) {
            if((numSaoIguais(candidatoLista,candidato))||(nomeSaoIguais(candidatoLista,candidato))){
                this.candidatos.remove(candidatoLista);
                return true;
            }
        }
        return false;
    }
    

    @Override
    public boolean enviarVotos(Candidato candidato) throws RemoteException {
        for (Candidato candidatoLista : this.candidatos) {
            if((numSaoIguais(candidatoLista,candidato))||(nomeSaoIguais(candidatoLista,candidato))){
               candidatoLista.setVotos((candidatoLista.getVotos())+(candidato.getVotos()));
                return true;
            }
        }
        return false;
    }
    
    private boolean numSaoIguais(Candidato candidato, Candidato candidatoAComparar) {
        return candidato.getNum() ==  candidatoAComparar.getNum();
    }
    
    private boolean nomeSaoIguais(Candidato candidato, Candidato candidatoAComparar) {
        return (candidato.getNome()).equals(candidatoAComparar.getNome());
    }

    void apurar(){
       int totalVotos = 0;
       System.out.println("Resultados:");
       for (Candidato candidatoLista : this.candidatos){
           totalVotos = totalVotos + (candidatoLista.getVotos());
           System.out.println(candidatoLista.getNome() + " - " + (candidatoLista.getVotos() + " votos"));
       }
       System.out.println("Total de votos: " + totalVotos);
        
    }
   
}
