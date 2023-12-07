
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author gikas
 */
public interface IEleicao extends Remote{
    public boolean inicia() throws RemoteException;
    public boolean cadastrar(Candidato candidato) throws RemoteException;
    public boolean deletar(Candidato candidato) throws RemoteException;
    public boolean enviarVotos(Candidato candidato) throws RemoteException;
}
