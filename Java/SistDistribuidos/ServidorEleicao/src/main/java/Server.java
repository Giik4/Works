
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server{
    
    public static void main(String [] args){
        
        try{
            Registry registry = LocateRegistry.createRegistry(1099);
            
            EleicaoImpl eleicao = new EleicaoImpl();
            
            
            Naming.rebind("rmi://localhost:1099/eleicao", eleicao);
            
            eleicao.inicia();
            System.out.println("Servidor online!");
            
           Timer timer = new Timer();
           
           final long segundos = (1000*5);
           
           TimerTask tarefa = new TimerTask(){
            public void run(){
                eleicao.apurar();
            }
        };
            timer.scheduleAtFixedRate(tarefa,0, segundos);
            
        }catch (RemoteException | MalformedURLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    
        
    }

}

