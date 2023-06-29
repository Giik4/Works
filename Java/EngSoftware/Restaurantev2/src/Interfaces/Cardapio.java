/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.*;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Giovanni
 */
public class Cardapio extends javax.swing.JFrame {

    /**
     * Creates new form Cardapio
     */
    
    
    public Cardapio() {
        initComponents();
    }
    
    private ConBD c = new ConBD();
    private ResultSet rst  = null;
    
    public void refresh(Cardapio cardapio) throws SQLException{
        cardapio.riscoMacarronada.setVisible(false);
        cardapio.riscoCrevette.setVisible(false);
        cardapio.riscoSopa.setVisible(false);
        cardapio.riscoBandejao.setVisible(false);
        cardapio.riscoSalad.setVisible(false);
        cardapio.riscoMix.setVisible(false);
        cardapio.riscoMaracuja.setVisible(false);
        cardapio.riscoAbacaxi.setVisible(false);
        cardapio.riscoLimao.setVisible(false);
        cardapio.riscoMorango.setVisible(false);
        cardapio.riscoLaranja.setVisible(false);
        cardapio.riscoCoca.setVisible(false);
        cardapio.riscoPepsi.setVisible(false);
        cardapio.riscoGuarana.setVisible(false);
        cardapio.riscoDolly.setVisible(false);
        cardapio.riscoHeineken.setVisible(false);
        cardapio.riscoSkol.setVisible(false);
        cardapio.riscoBudweiser.setVisible(false);
        cardapio.riscoStella.setVisible(false);
        
        System.out.println("\naaaaaaaaa");
       risc(cardapio);
    }
	
	public void risc(Cardapio cardapio) throws SQLException{
		int atual, necessario;
		rst = c.OutBD("select quantidade from Ingredientes where idI = 1;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 1;");
		rst.next();
		necessario = rst.getInt(1);
                System.out.println("\n a"+ atual);
                System.out.println("\n"+ necessario);
		if (atual < necessario){
			cardapio.riscoMacarronada.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 2;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 2;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			cardapio.riscoCrevette.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 3;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 3;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			cardapio.riscoSopa.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 4;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 4;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			cardapio.riscoBandejao.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 5;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 5;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			cardapio.riscoSalad.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 6;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Pratos where idP = 6;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoMix.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 7;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 20.1;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoMaracuja.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 8;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 20.2;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoAbacaxi.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 9;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 20.3;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoLimao.setVisible(true);
		}

		rst = c.OutBD("select quantidade from Ingredientes where idI = 10;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 20.4;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoMorango.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 11;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 20.5;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoLaranja.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 12;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 21.1;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoCoca.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 13;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 21.2;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoPepsi.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 14;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 21.3;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoGuarana.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 15;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 21.4;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoDolly.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 16;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 22.1;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoHeineken.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 17;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 22.2;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoSkol.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 18;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 22.3;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoBudweiser.setVisible(true);
		}
		
		rst = c.OutBD("select quantidade from Ingredientes where idI = 19;");
		rst.next();
		atual = rst.getInt(1);
		rst = c.OutBD("select quantidade_ing from Bebidas where idB = 22.4;");
		rst.next();
		necessario = rst.getInt(1);
		if (atual < necessario){
			 cardapio.riscoStella.setVisible(true);
		}
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        riscoStella = new javax.swing.JLabel();
        riscoBudweiser = new javax.swing.JLabel();
        riscoSkol = new javax.swing.JLabel();
        riscoHeineken = new javax.swing.JLabel();
        riscoDolly = new javax.swing.JLabel();
        riscoGuarana = new javax.swing.JLabel();
        riscoPepsi = new javax.swing.JLabel();
        riscoCoca = new javax.swing.JLabel();
        riscoLaranja = new javax.swing.JLabel();
        riscoMorango = new javax.swing.JLabel();
        riscoLimao = new javax.swing.JLabel();
        riscoAbacaxi = new javax.swing.JLabel();
        riscoMaracuja = new javax.swing.JLabel();
        riscoMix = new javax.swing.JLabel();
        riscoSalad = new javax.swing.JLabel();
        riscoBandejao = new javax.swing.JLabel();
        riscoSopa = new javax.swing.JLabel();
        riscoCrevette = new javax.swing.JLabel();
        riscoMacarronada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 654));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        riscoStella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoStella, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 640, -1, 10));

        riscoBudweiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoBudweiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, -1, 10));

        riscoSkol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoSkol, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, -1, 10));

        riscoHeineken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoHeineken, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, -1, 10));

        riscoDolly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoDolly, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, -1, 20));

        riscoGuarana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoGuarana, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, -1, 20));

        riscoPepsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoPepsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, -1, 20));

        riscoCoca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoCoca, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, -1, 20));

        riscoLaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoLaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, -1, 20));

        riscoMorango.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoMorango, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, -1, 20));

        riscoLimao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoLimao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, -1, 20));

        riscoAbacaxi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoAbacaxi.png"))); // NOI18N
        getContentPane().add(riscoAbacaxi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, -1, 20));

        riscoMaracuja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoBebidas.png"))); // NOI18N
        getContentPane().add(riscoMaracuja, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, 20));

        riscoMix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoMix, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, 10));

        riscoSalad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoSalad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, 20));

        riscoBandejao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoBandejao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 10));

        riscoSopa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoSopa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 20));

        riscoCrevette.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoCrevette, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 270, 30));

        riscoMacarronada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconeCardapio/riscoPratos.png"))); // NOI18N
        getContentPane().add(riscoMacarronada, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cardapio.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 654));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cardapio cardapio = new Cardapio();
                cardapio.setVisible(true);
               
                        
                ImageIcon icon= new ImageIcon("/Imagens/riscoPratos.png");
                icon.setImage(icon.getImage().getScaledInstance(200,100,1));
                cardapio.riscoMacarronada.setIcon(icon);
                try {
                    cardapio.refresh(cardapio);
                    
                    //colocar IFs no método refresh
                } catch (SQLException ex) {
                    Logger.getLogger(Cardapio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel riscoAbacaxi;
    private javax.swing.JLabel riscoBandejao;
    private javax.swing.JLabel riscoBudweiser;
    private javax.swing.JLabel riscoCoca;
    private javax.swing.JLabel riscoCrevette;
    private javax.swing.JLabel riscoDolly;
    private javax.swing.JLabel riscoGuarana;
    private javax.swing.JLabel riscoHeineken;
    private javax.swing.JLabel riscoLaranja;
    private javax.swing.JLabel riscoLimao;
    private javax.swing.JLabel riscoMacarronada;
    private javax.swing.JLabel riscoMaracuja;
    private javax.swing.JLabel riscoMix;
    private javax.swing.JLabel riscoMorango;
    private javax.swing.JLabel riscoPepsi;
    private javax.swing.JLabel riscoSalad;
    private javax.swing.JLabel riscoSkol;
    private javax.swing.JLabel riscoSopa;
    private javax.swing.JLabel riscoStella;
    // End of variables declaration//GEN-END:variables
}
