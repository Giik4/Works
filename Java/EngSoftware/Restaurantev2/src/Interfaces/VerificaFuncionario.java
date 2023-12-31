/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;


import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Giovanni
 */
public class VerificaFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form VerificaFuncionario
     */
    public VerificaFuncionario() {
        initComponents();
    }

    private Funcionario funcio = new Funcionario();
    private ConBD c = new ConBD();
    private ResultSet rst  = null;

    public void CadFuncionario() throws SQLException {
        funcio = new Funcionario();
        funcio.setCargo(cxCargo.getText().toLowerCase());
        funcio.setLogin(cxLogin.getText());
        funcio.setSenha(cxSenha.getText());
        if(!"".equals(funcio.getLogin()) || !"".equals(funcio.getSenha())){
            if("gerente".equals(funcio.getCargo()) ||  "caixa".equals(funcio.getCargo()) || "chefe".equals(funcio.getCargo()) || "motoboy".equals(funcio.getCargo()) || "garcom".equals(funcio.getCargo())){
                if (c.TstBDStr("select coalesce((select login from Funcionario where login = '"+funcio.getLogin()+"'),'')")==false) {
                c.EntBD("insert into Funcionario values ('"+funcio.getLogin()+"','"+funcio.getSenha()+"','"+funcio.getCargo()+"',true);");
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE);
                limpeza();
            }else {
                JOptionPane.showMessageDialog(null, "Já existe um funcionário com esse Login!", "ERRO Cadastro", 0);
                cxLogin.requestFocus();
            }
            }else{
                JOptionPane.showMessageDialog(null, "Insira um cargo válido!", "ERRO Cadastro", 0);
            }
        }else{
          JOptionPane.showMessageDialog(null, "Insira um valor no campo de login/senha!", "ERRO Cadastro", 0);
          limpeza();
          cxLogin.requestFocus();
        }
    }
  
  public void consFuncionario() throws SQLException{
    funcio = new Funcionario();

    funcio.setLogin(cxLogin.getText());
    if(c.TstBDStr("select coalesce((select login from Funcionario where login = '"+funcio.getLogin()+"'),'')")==true){
      rst = null;
      rst = c.OutBD("select * from Funcionario where login = '" + funcio.getLogin() + "';");
      rst.next();

      funcio.setLogin(rst.getString("login"));
      funcio.setSenha(rst.getString("senha"));
      funcio.setCargo(rst.getString("cargo"));

      cxLogin.setText(funcio.getLogin());
      cxSenha.setText(funcio.getSenha());
      cxCargo.setText(funcio.getCargo());//<- Arrumar para o comboBox
    }else{
      JOptionPane.showMessageDialog(null, "Não existe um funcionário cadastrado com esses dados!", "ERRO Consulta", 0);
      limpeza();
      cxLogin.requestFocus();
    }
  }

  public void demiteFuncionario() throws SQLException{
    funcio = new Funcionario();

    funcio.setLogin(cxLogin.getText());
    if(c.TstBDStr("select coalesce((select login from Funcionario where login = '"+funcio.getLogin()+"'),'')")==true){
      c.EntBD("update Funcionario set ativo = false where login = '"+ funcio.getLogin()+"';");
      JOptionPane.showMessageDialog(null, "Funcionario demitido com sucesso!","Demissão OK", JOptionPane.INFORMATION_MESSAGE);
    }else{
      JOptionPane.showMessageDialog(null, "Não existe um funcionário cadastrado com esses dados!", "ERRO Consulta", 0);
      limpeza();
      cxLogin.requestFocus();
    }
  }

    public void limpeza() {
        cxCargo.setText("");
        cxLogin.setText("");
        cxSenha.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cxCargo = new javax.swing.JTextField();
        rtCargo = new javax.swing.JLabel();
        cxLogin = new javax.swing.JTextField();
        rtLogin = new javax.swing.JLabel();
        cxSenha = new javax.swing.JTextField();
        rtSenha = new javax.swing.JLabel();
        bntVerificarFuncionario = new javax.swing.JToggleButton();
        bntDemitirFuncionario = new javax.swing.JToggleButton();
        btnLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bntCadastrarFuncionario = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxCargoActionPerformed(evt);
            }
        });

        rtCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtCargo.setText("Cargo");

        cxLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxLoginActionPerformed(evt);
            }
        });

        rtLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtLogin.setText("Login");

        cxSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSenhaActionPerformed(evt);
            }
        });

        rtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rtSenha.setText("Senha");

        bntVerificarFuncionario.setText("Verificar Funcionário");
        bntVerificarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerificarFuncionarioActionPerformed(evt);
            }
        });

        bntDemitirFuncionario.setText("Demitir Funcionario");
        bntDemitirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDemitirFuncionarioActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu funcionario");
        jLabel1.setPreferredSize(new java.awt.Dimension(257, 54));

        bntCadastrarFuncionario.setText("Cadastrar Funcionario");
        bntCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastrarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rtSenha)
                    .addComponent(cxLogin)
                    .addComponent(rtLogin)
                    .addComponent(rtCargo)
                    .addComponent(cxCargo)
                    .addComponent(cxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntVerificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntDemitirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rtCargo)
                        .addGap(23, 23, 23)
                        .addComponent(cxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(rtLogin)
                        .addGap(18, 18, 18)
                        .addComponent(cxLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rtSenha))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bntVerificarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntDemitirFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cxSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVerificarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerificarFuncionarioActionPerformed
        try {
            consFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(VerificaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntVerificarFuncionarioActionPerformed

    private void bntDemitirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDemitirFuncionarioActionPerformed
        try {
            demiteFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(VerificaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntDemitirFuncionarioActionPerformed

    private void bntCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastrarFuncionarioActionPerformed
        try {
            CadFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(VerificaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntCadastrarFuncionarioActionPerformed
	
    private void cxCargoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void cxLoginActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void cxSenhaActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {                                          
        limpeza();
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
            java.util.logging.Logger.getLogger(VerificaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerificaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerificaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerificaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerificaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bntCadastrarFuncionario;
    private javax.swing.JToggleButton bntDemitirFuncionario;
    private javax.swing.JToggleButton bntVerificarFuncionario;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField cxCargo;
    private javax.swing.JTextField cxLogin;
    private javax.swing.JTextField cxSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel rtCargo;
    private javax.swing.JLabel rtLogin;
    private javax.swing.JLabel rtSenha;
    // End of variables declaration//GEN-END:variables
}
