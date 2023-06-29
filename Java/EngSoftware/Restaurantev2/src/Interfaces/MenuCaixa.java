/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovanni
 */
public class MenuCaixa extends javax.swing.JFrame {

    /**
     * Creates new form MenuCaixa
     */
    public MenuCaixa() {
        initComponents();
    }
    
    private Fisico fisi = new Fisico();
    private Delivery deli = new Delivery();
    private ConBD c = new ConBD();
    private ResultSet rst  = null;


    public void consPedidoFis() throws SQLException{
      fisi = new Fisico();

      try{
        fisi.setCodigo(Integer.parseInt(cxCodPedido.getText()));

        //fisi=fpf.consFisCod(fisi);

        if(c.TstBD("select coalesce((select cod from PedidoFisico where cod = " +fisi.getCodigo()+ "),0)") == true){
          rst = null;
          rst = c.OutBD("select * from PedidoFisico where cod = "+ fisi.getCodigo()+ ";");
          rst.next();
          fisi.setPrato(rst.getInt("prato"));
          fisi.setBebida(rst.getFloat("bebida"));
          fisi.setMesa(rst.getInt("mesa"));
          cxPratos.setText(Integer.toString(fisi.getPrato()));
          cxBebidas.setText(Float.toString(fisi.getBebida()));
          cxCodPedido.setText(Integer.toString(fisi.getCodigo()));
          cxNumMesa.setText(Integer.toString(fisi.getMesa()));
          cxEndereco.setText("");
        }else{
          JOptionPane.showMessageDialog(null, " Não existe um pedido com esse código!","ERRO Consulta", 0);
          cxCodPedido.setText("");
          cxCodPedido.requestFocus();
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O Código deve ser um inteiro!","Erro de Código", JOptionPane.ERROR_MESSAGE);
        cxCodPedido.setText("");
        cxNumMesa.setText("");
        cxCodPedido.requestFocus();
      }
    }


public void consPedidoDeliv() throws SQLException{
      deli = new Delivery();

      try{
        deli.setCodigo(Integer.parseInt(cxCodPedido.getText()));

        //deli = fpd.consDelivCod(deli);

        if(c.TstBD("select coalesce((select cod from PedidoDelivery where cod = " +deli.getCodigo()+ "),0)") == true){
          rst = null;
          rst = c.OutBD("select * from PedidoDelivery where cod = "+ deli.getCodigo() +";");
          rst.next();
          deli.setPrato(rst.getInt("prato"));
          deli.setBebida(rst.getFloat("bebida"));
          deli.setEndereco(rst.getString("endereco"));
          cxPratos.setText(Integer.toString(deli.getPrato()));
          cxBebidas.setText(Float.toString(deli.getBebida()));
          cxCodPedido.setText(Integer.toString(deli.getCodigo()));
          cxEndereco.setText(deli.getEndereco());
          cxNumMesa.setText("");
        }else{
          JOptionPane.showMessageDialog(null, " Não existe um pedido com esse código!","ERRO Consulta", 0);
          cxCodPedido.setText("");
          cxCodPedido.requestFocus();
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O Código deve ser um inteiro!","Erro de Código", JOptionPane.ERROR_MESSAGE);
        cxCodPedido.setText("");
        cxCodPedido.requestFocus();
      }
    }

    public void listarVendas() throws SQLException {
        String[] nomes = {"Codigo","Prato","Bebida","Mesa/Endereço"};
        DefaultTableModel modeloVendas = (DefaultTableModel) tabelaVendas.getModel();
        modeloVendas.setColumnIdentifiers(nomes);
        ResultSet rstF = c.OutBD("Select cod,prato,bebida,mesa from PedidoFisico where conclusao = true");
        java.sql.ResultSetMetaData mtdF = rstF.getMetaData();
        ResultSet rstD = c.OutBD("Select cod,prato,bebida,endereco from PedidoDelivery where conclusao = true");
        java.sql.ResultSetMetaData mtdD = rstD.getMetaData();
        int qtdCol = mtdD.getColumnCount();
        while(rstF.next()){
            Object[] objects = new Object[qtdCol];
            for(int i = 0; i < qtdCol; i++){
                objects[i] = rstF.getObject(i+1);
            }
            modeloVendas.addRow(objects);
        }
        qtdCol = mtdF.getColumnCount();
        while(rstD.next()){
            Object[] objects = new Object[qtdCol];
            for(int i = 0; i < qtdCol; i++){
                objects[i] = rstD.getObject(i+1);
            }
            modeloVendas.addRow(objects);
        }
        tabelaVendas.setModel(modeloVendas);
    }
    
    public void limparVendas() {
        DefaultTableModel modeloVendas = (DefaultTableModel) tabelaVendas.getModel();
        modeloVendas.setRowCount(0);
        tabelaVendas.setModel(modeloVendas);
    }


    public void limpeza(){
        cxNumMesa.setText("");
        cxCodPedido.setText("");
        cxEndereco.setText("");
        cxPratos.setText("");
        cxBebidas.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtMenuCaixa = new javax.swing.JLabel();
        pnBotoes = new javax.swing.JPanel();
        btImprimir = new javax.swing.JButton();
        btVerificPedidoCliente = new javax.swing.JButton();
        btVerificPedidoClienteDeliv = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnVendas = new javax.swing.JPanel();
        btClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        pnInfo = new javax.swing.JPanel();
        rtCodPedido = new javax.swing.JLabel();
        cxCodPedido = new javax.swing.JTextField();
        rtPratos = new javax.swing.JLabel();
        cxBebidas = new javax.swing.JTextField();
        rtBebidas = new javax.swing.JLabel();
        cxEndereco = new javax.swing.JTextField();
        rtNumMesa = new javax.swing.JLabel();
        cxPratos = new javax.swing.JTextField();
        rtEndereco = new javax.swing.JLabel();
        cxNumMesa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rtMenuCaixa.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        rtMenuCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rtMenuCaixa.setText("Menu Caixa");
        getContentPane().add(rtMenuCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 280, 60));

        pnBotoes.setBackground(new java.awt.Color(255, 255, 255));
        pnBotoes.setLayout(null);

        btImprimir.setText("Imprimir Endereço");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        pnBotoes.add(btImprimir);
        btImprimir.setBounds(610, 10, 160, 78);

        btVerificPedidoCliente.setText("Verificar Pedido Cliente");
        btVerificPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificPedidoClienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btVerificPedidoCliente);
        btVerificPedidoCliente.setBounds(10, 10, 150, 78);

        btVerificPedidoClienteDeliv.setText("Verificar Pedido Cliente Delivery");
        btVerificPedidoClienteDeliv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificPedidoClienteDelivActionPerformed(evt);
            }
        });
        pnBotoes.add(btVerificPedidoClienteDeliv);
        btVerificPedidoClienteDeliv.setBounds(190, 10, 200, 78);

        jButton2.setText("Listar Vendas");
        jButton2.setMaximumSize(new java.awt.Dimension(128, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(128, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(128, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarVendasActionPerformed(evt);
            }
        });
        pnBotoes.add(jButton2);
        jButton2.setBounds(420, 10, 160, 78);

        getContentPane().add(pnBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 780, 100));

        pnVendas.setBackground(new java.awt.Color(255, 255, 255));
        pnVendas.setLayout(null);

        btClose.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        btClose.setText("x");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        pnVendas.add(btClose);
        btClose.setBounds(700, 10, 60, 30);

        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Prato", "Bebida", "Mesa/Endereço"
            }
        ));
        jScrollPane1.setViewportView(tabelaVendas);

        pnVendas.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 770, 380);

        getContentPane().add(pnVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 151, 780, -1));

        pnInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnInfo.setLayout(null);

        rtCodPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtCodPedido.setText("Código do Pedido");
        pnInfo.add(rtCodPedido);
        rtCodPedido.setBounds(20, 20, 130, 20);
        pnInfo.add(cxCodPedido);
        cxCodPedido.setBounds(20, 50, 300, 70);

        rtPratos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtPratos.setText("Pratos");
        pnInfo.add(rtPratos);
        rtPratos.setBounds(20, 140, 50, 20);
        pnInfo.add(cxBebidas);
        cxBebidas.setBounds(20, 310, 300, 80);

        rtBebidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtBebidas.setText("Bebidas");
        pnInfo.add(rtBebidas);
        rtBebidas.setBounds(20, 280, 50, 20);
        pnInfo.add(cxEndereco);
        cxEndereco.setBounds(440, 250, 300, 90);

        rtNumMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtNumMesa.setText("Número da Mesa");
        pnInfo.add(rtNumMesa);
        rtNumMesa.setBounds(440, 70, 120, 17);

        cxPratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxPratosActionPerformed(evt);
            }
        });
        pnInfo.add(cxPratos);
        cxPratos.setBounds(20, 170, 300, 80);

        rtEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rtEndereco.setText("Endereço");
        pnInfo.add(rtEndereco);
        rtEndereco.setBounds(440, 220, 70, 20);
        pnInfo.add(cxNumMesa);
        cxNumMesa.setBounds(440, 90, 300, 80);

        jButton1.setText("LIMPAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnInfo.add(jButton1);
        jButton1.setBounds(650, 360, 90, 30);

        getContentPane().add(pnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 780, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVerificPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificPedidoClienteActionPerformed
        try {
            consPedidoFis();
        } catch (SQLException ex) {
            Logger.getLogger(MenuCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVerificPedidoClienteActionPerformed

    private void btVerificPedidoClienteDelivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificPedidoClienteDelivActionPerformed
        try {
            consPedidoDeliv();
        } catch (SQLException ex) {
            Logger.getLogger(MenuCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVerificPedidoClienteDelivActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpeza();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        try {
            imprimirEndereco();
        } catch (SQLException ex) {
            Logger.getLogger(MenuCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btListarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarVendasActionPerformed
        try {
            listarVendas();
        } catch (SQLException ex) {
            Logger.getLogger(MenuCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnVendas.setSize(780,430);
    }//GEN-LAST:event_btListarVendasActionPerformed

    private void cxPratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxPratosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxPratosActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        pnVendas.setSize(780,0);
        limparVendas();
    }//GEN-LAST:event_btCloseActionPerformed

    public void imprimirEndereco() throws SQLException{
      deli = new Delivery();
      
      try{
        deli.setCodigo(Integer.parseInt(cxCodPedido.getText()));
        
        //deli = fpd.consDelivCod(deli);
        
        if(c.TstBD("select coalesce((select cod from PedidoDelivery where cod = " +deli.getCodigo()+ "),0)") == true){
            rst = null;
            rst = c.OutBD("select endereco from PedidoDelivery where cod = "+ deli.getCodigo() +";");
            rst.next();
          JOptionPane.showMessageDialog(null, "Endereço: "+ rst.getString(1) ,"Imprindo endereço", 1);
        }else{
          JOptionPane.showMessageDialog(null, " Não existe um pedido com esse código!","ERRO", 0);
          cxCodPedido.setText("");
          cxCodPedido.requestFocus();
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O Código deve ser um inteiro!","Erro de Código", JOptionPane.ERROR_MESSAGE);
        cxCodPedido.setText("");
        cxCodPedido.requestFocus();
      }
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btVerificPedidoCliente;
    private javax.swing.JButton btVerificPedidoClienteDeliv;
    private javax.swing.JTextField cxBebidas;
    private javax.swing.JTextField cxCodPedido;
    private javax.swing.JTextField cxEndereco;
    private javax.swing.JTextField cxNumMesa;
    private javax.swing.JTextField cxPratos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnVendas;
    private javax.swing.JLabel rtBebidas;
    private javax.swing.JLabel rtCodPedido;
    private javax.swing.JLabel rtEndereco;
    private javax.swing.JLabel rtMenuCaixa;
    private javax.swing.JLabel rtNumMesa;
    private javax.swing.JLabel rtPratos;
    private javax.swing.JTable tabelaVendas;
    // End of variables declaration//GEN-END:variables

    
    
}
