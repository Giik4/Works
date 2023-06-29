/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Giovanni
 */
public class MenuGerente extends javax.swing.JFrame {

    /**
     * Creates new form MenuGerente
     */
    public MenuGerente() {
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
            c.EntBD("insert into Ingredientes values (" + ingre.getCodIngrediente() + ",'" + ingre.getNomeIngrediente() +"',"+ingre.getQtdIngrediente() + ");");//Entrada no BD
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
//        ingre = fg.ConsCodIngrediente(ingre);
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
        btCadIngrediente = new javax.swing.JButton();
        btConsIngrediente = new javax.swing.JButton();
        btAltIngrediente = new javax.swing.JButton();
        rtCodigo = new javax.swing.JLabel();
        cxQuant = new javax.swing.JTextField();
        rtNome = new javax.swing.JLabel();
        rtQuant = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cxCod = new javax.swing.JTextField();
        btGerenciarFuncionario = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 510));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rtMenuGerente.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        rtMenuGerente.setText("Menu Gerente");
        getContentPane().add(rtMenuGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 280, -1));

        pnBotoes.setBackground(new java.awt.Color(255, 255, 255));
        pnBotoes.setLayout(null);

        btCadIngrediente.setText("Cadastrar Ingrediente");
        btCadIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btCadIngrediente);
        btCadIngrediente.setBounds(20, 10, 190, 60);

        btConsIngrediente.setText("Consultar Ingrediente");
        btConsIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btConsIngrediente);
        btConsIngrediente.setBounds(240, 10, 190, 60);

        btAltIngrediente.setText("Alterar Ingrediente");
        btAltIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltIngredienteActionPerformed(evt);
            }
        });
        pnBotoes.add(btAltIngrediente);
        btAltIngrediente.setBounds(470, 10, 190, 60);

        getContentPane().add(pnBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 90));

        rtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtCodigo.setText("Código");
        getContentPane().add(rtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 30));

        cxQuant.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cxQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxQuantActionPerformed(evt);
            }
        });
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

        btGerenciarFuncionario.setText("Gerenciar Funcionário");
        btGerenciarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btGerenciarFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 230, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cxQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxQuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cxQuantActionPerformed

    private void btGerenciarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarFuncionarioActionPerformed
        VerificaFuncionario telaGerenciarfuncionario = new VerificaFuncionario ();
        telaGerenciarfuncionario.setVisible(true);
    }//GEN-LAST:event_btGerenciarFuncionarioActionPerformed

    private void btCadIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadIngredienteActionPerformed
        try {
            cadIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btCadIngredienteActionPerformed

    private void btConsIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsIngredienteActionPerformed
        try {
            consIngrediente();
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsIngredienteActionPerformed

    private void btAltIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltIngredienteActionPerformed
        try {
            AlteraQtd();
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAltIngredienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        limpeza();
    }                                                                                       

    private void cxCodActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntCadastrarFuncionario;
    private javax.swing.JToggleButton bntCadastrarFuncionario1;
    private javax.swing.JButton btAltIngrediente;
    private javax.swing.JButton btCadIngrediente;
    private javax.swing.JButton btConsIngrediente;
    private javax.swing.JToggleButton btGerenciarFuncionario;
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
