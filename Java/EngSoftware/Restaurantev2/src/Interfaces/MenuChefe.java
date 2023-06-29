/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Giovanni
 */
public class MenuChefe extends javax.swing.JFrame {

    /**
     * Creates new form MenuChefe
     */
    public MenuChefe() {
        initComponents();
    }
    
    //private FuncGerente fg = new FuncGerente();
    private Ingrediente ingre = new Ingrediente();
    private ConBD c = new ConBD();
    private ResultSet rst  = null;
  
    public void cadIngrediente() throws SQLException{
      ingre = new Ingrediente();
      try{
        ingre.setNomeIngrediente(cxNome.getText());
        ingre.setCodIngrediente(Integer.parseInt(cxCod.getText()));
        ingre.setQtdIngrediente(Integer.parseInt(cxQuant.getText()));//Entrda de ingredientes
        if(ingre.getCodIngrediente() != 0){
          if(c.TstBD("select coalesce((select idI from Ingredientes where idI = " + ingre.getCodIngrediente() +"),0)") == false){//Teste
            c.EntBD("insert into Ingredientes values (" + ingre.getCodIngrediente() +",'"+ ingre.getNomeIngrediente() + "',"+ingre.getQtdIngrediente() + ");");//Entrada no BD
            JOptionPane.showMessageDialog(null,"Ingrediente cadastrado com sucesso!","Cadastro realizado",JOptionPane.INFORMATION_MESSAGE);
            limpeza();
         }else{
            JOptionPane.showMessageDialog(null, "Já existe um ingrediente com este código!","ERRO Cadastro", 0);
            cxCod.setText("");
            cxCod.requestFocus();
          }
        }else{
          JOptionPane.showMessageDialog(null, "O código do ingrediente não pode ser 0!","ERRO Cadastro", 0);
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O valor deve ser um número!","Erro", JOptionPane.ERROR_MESSAGE);
        cxCod.setText("");
        cxQuant.setText("");
        cxCod.requestFocus();
      }
    }

    public void consIngrediente() throws SQLException{
      ingre = new Ingrediente();

      try{
        ingre.setCodIngrediente(Integer.parseInt(cxCod.getText()));
        //ingre = fg.ConsCodIngrediente(ingre);
        if(c.TstBD("select coalesce((select idI from Ingredientes where idI = " + ingre.getCodIngrediente() +"),0)") == true){
          rst = null;
          rst = c.OutBD("select * from Ingredientes where idI = " + ingre.getCodIngrediente() + ";");
          rst.next();

          ingre.setNomeIngrediente(rst.getString("nome"));
          ingre.setQtdIngrediente(rst.getInt("quantidade"));
          ingre.setCodIngrediente(rst.getInt("idI"));
          
          cxCod.setText(Integer.toString(ingre.getCodIngrediente()));
          cxQuant.setText(Integer.toString(ingre.getQtdIngrediente()));
          cxNome.setText(ingre.getNomeIngrediente());
        }else{
          JOptionPane.showMessageDialog(null, " Não existe um ingrediente cadastrado com esse código!","ERRO Consulta", 0);
          cxCod.setText("");
          cxCod.requestFocus();
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O Código deve ser um inteiro!","Erro de Código", JOptionPane.ERROR_MESSAGE);
        cxCod.setText("");
        cxCod.requestFocus();
      }
    }

    public void AlteraQtd() throws SQLException{
      ingre = new Ingrediente();
      
      //ingre.setNomeIngrediente(cxNome.getText());
      try{
        ingre.setCodIngrediente(Integer.parseInt(cxCod.getText()));
        //ingre = fg.ConsCodIngrediente(ingre);
        ingre.setQtdIngrediente(Integer.parseInt(cxQuant.getText()));
        
        if(c.TstBD("select coalesce((select idI from Ingredientes where idI = " + ingre.getCodIngrediente() +"),0)") == true){
          c.EntBD("update Ingredientes set quantidade =  " + ingre.getQtdIngrediente() + " where idI = "+ ingre.getCodIngrediente());
          JOptionPane.showMessageDialog(null, "Ingrediente alterado com sucesso!","Alteração OK", JOptionPane.INFORMATION_MESSAGE);
          limpeza();
        }else{
          JOptionPane.showMessageDialog(null, "Não existe um ingrediente com este código!","ERRO Alteração", 0);
          cxCod.setText("");
          cxCod.requestFocus();
        }
      }
      catch(NumberFormatException nfe){
        JOptionPane.showMessageDialog(null, "O valor deve ser um inteiro!","Erro de Código", JOptionPane.ERROR_MESSAGE);
        cxCod.setText("");
        cxQuant.setText("");
        cxCod.requestFocus();
      }
      catch(NullPointerException np){
        JOptionPane.showMessageDialog(null, "Mudança Inválida!","Erro de Código", JOptionPane.ERROR_MESSAGE);  
      }
    }
    
    public void limpeza(){
        cxCod.setText("");
        cxNome.setText("");
        cxQuant.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rtMenuGerente = new javax.swing.JLabel();
        pnBotoes = new javax.swing.JPanel();
        btAltIngrediente = new javax.swing.JButton();
        btConsultIngrediente = new javax.swing.JButton();
        btCadIngrediente = new javax.swing.JButton();
        rtCodigo = new javax.swing.JLabel();
        cxQuant = new javax.swing.JTextField();
        rtNome = new javax.swing.JLabel();
        rtQuant = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cxCod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 510));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rtMenuGerente.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        rtMenuGerente.setText("Menu Chefe");
        getContentPane().add(rtMenuGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 280, -1));

        pnBotoes.setBackground(new java.awt.Color(255, 255, 255));
        pnBotoes.setLayout(null);

        btAltIngrediente.setText("Alterar Ingrediente");
        btAltIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btAltIngrediente);
        btAltIngrediente.setBounds(480, 10, 190, 60);

        btConsultIngrediente.setText("Consultar Ingrediente");
        btConsultIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btConsultIngrediente);
        btConsultIngrediente.setBounds(240, 10, 190, 60);

        btCadIngrediente.setText("Cadastrar Ingrediente");
        btCadIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btCadIngrediente);
        btCadIngrediente.setBounds(10, 10, 180, 60);

        getContentPane().add(pnBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 90));

        rtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtCodigo.setText("Código");
        getContentPane().add(rtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 20));

        cxQuant.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(cxQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 190, 60));

        rtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtNome.setText("Nome ");
        getContentPane().add(rtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 60, -1));

        rtQuant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtQuant.setText("Quantidade");
        getContentPane().add(rtQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 110, -1));

        cxNome.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(cxNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 190, 60));

        jButton1.setText("LIMPAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, -1, 30));

        cxCod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cxCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxCodActionPerformed(evt);
            }
        });
        getContentPane().add(cxCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadIngredienteActionPerformed
        try {
            cadIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(MenuChefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCadIngredienteActionPerformed

    private void btConsultIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultIngredienteActionPerformed
        try {
            consIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(MenuChefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsultIngredienteActionPerformed

    private void btAltIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltIngredienteActionPerformed
        try {
            AlteraQtd();
        } catch (SQLException ex) {
            Logger.getLogger(MenuChefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAltIngredienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpeza();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cxCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxCodActionPerformed

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
            java.util.logging.Logger.getLogger(MenuChefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuChefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuChefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuChefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuChefe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAltIngrediente;
    private javax.swing.JButton btCadIngrediente;
    private javax.swing.JButton btConsultIngrediente;
    private javax.swing.JTextField cxCod;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxQuant;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JLabel rtCodigo;
    private javax.swing.JLabel rtMenuGerente;
    private javax.swing.JLabel rtNome;
    private javax.swing.JLabel rtQuant;
    // End of variables declaration//GEN-END:variables
}
