package com.mycompany.clienteservidortcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ThreadServidor implements Runnable {

    private JTable tabela;    
    private ServerSocket servidor;
    private int porta;
    private int cliente = 0;
    private DefaultTableModel modelo;

    public ThreadServidor() {
    }

    public ThreadServidor(DefaultTableModel jT, int porta) {
        this.modelo = jT;
        this.porta = porta;
    }

    @Override
    public void run() {
        try {
            servidor = new ServerSocket(porta);            
            while (true) {                     
                this.modelo.addRow(new Object[]{"","Aguardando Conexão",""});
                new Thread(new ThreadAtendeCliente(modelo, servidor.accept(),cliente)).start();
                modelo.setValueAt(("Cliente "+cliente), cliente, 0);
                modelo.setValueAt("Conectado", cliente, 1);
                cliente++;
                
            }            
            
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
