package com.mycompany.clienteservidortcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ThreadAtendeCliente implements Runnable {

    private DefaultTableModel modelo;
    private Socket conexao;
    private DataInputStream entrada;
    private String dado;
    private int cliente;

    public ThreadAtendeCliente() {
    }

    public ThreadAtendeCliente(DefaultTableModel jT, Socket c, int cliente) {
        this.modelo = jT;
        this.conexao = c;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            entrada = new DataInputStream(conexao.getInputStream());  
            while(true){
                dado = entrada.readUTF();
                this.modelo.setValueAt(dado, cliente, 2);
                
            }
        } catch (IOException ex) {
            this.modelo.setValueAt("Desconectado", cliente, 1);
            this.modelo.setValueAt("Fim", cliente, 2);
        }

    }


}
