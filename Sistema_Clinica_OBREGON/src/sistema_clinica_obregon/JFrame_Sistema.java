/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema_clinica_obregon;

import forms.Profesionales.FrmProfesionales;
import forms.especialidades.FrmEspecialidades;
import forms.obrasocial.FrmObraSocial;
import forms.pacientes.FrmPacientes;
import forms.settings.FrmSetting;
import javax.swing.JOptionPane;
import miselaneos.Fecha;
import miselaneos.GUI;
import miselaneos.Iconos;
import miselaneos.Imagenes;



/**
 *
 * @author OBREGON
 */
public class JFrame_Sistema extends javax.swing.JFrame {

    public static Iconos iconos = new Iconos();//Declaro public y static para poder acceder luego desde cualquier lugar del proyecto en cualquier objeto
    public static Imagenes imgs = new Imagenes(); //Misma situacion que Iconos
    public static Fecha fe = new Fecha(); //Misma situacion que Iconos
    
    private GUI gui;
    /**
     * Creates new form JFrame_Sistema
     */
    public JFrame_Sistema() {
        initComponents();
        setExtendedState(JFrame_Sistema.MAXIMIZED_BOTH);
        gui = new GUI();
        _initClock();
    }
    
     private void _loadEspecialidad(){
        gui.loadEspecialidad(FrmEspecialidades.id, true);
    }
    
    private void _loadPacientes(){
        gui.loadPacientes(FrmPacientes.id, true);
    }
    
    private void _loadProfesionales(){
        gui.loadProfesionales(FrmProfesionales.id, true);
    }
    
    private void _loadObrasocial(){
        gui.loadObraSocial(FrmObraSocial.id, true);
    }
    
    public void _loadSetting(){
        gui.loadSetting(FrmSetting.id, true);
    }
    
    private void _initClock(){
        Thread t = new Thread(lblFechaHora);
        t.start();
    }

    private void salirSistema(){
        if(JOptionPane.showConfirmDialog(null, "Desea salir del Sistema?", "Atención!!!",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarButtons = new javax.swing.JToolBar();
        btnEspecialidades2 = new botones.BtnEspecialidades();
        btnPacientes1 = new botones.BtnPacientes();
        btnObrasocial1 = new botones.BtnObrasocial();
        btnExit2 = new botones.BtnExit();
        jDeskTopSis = new miselaneos.JDeskTopSis();
        jStatusToolBar = new javax.swing.JToolBar();
        lblFechaHora = new etiquetas.LblFechaHora();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuProfesionales = new javax.swing.JMenuItem();
        jMenuItemTurnos = new javax.swing.JMenuItem();
        jMenuItemSetting = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Clinica");
        setIconImage(iconos.getSys(16).getImage()
        );

        jToolBarButtons.setRollover(true);

        btnEspecialidades2.setFocusable(false);
        btnEspecialidades2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEspecialidades2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEspecialidades2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialidades2ActionPerformed(evt);
            }
        });
        jToolBarButtons.add(btnEspecialidades2);

        btnPacientes1.setFocusable(false);
        btnPacientes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPacientes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPacientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientes1ActionPerformed(evt);
            }
        });
        jToolBarButtons.add(btnPacientes1);

        btnObrasocial1.setFocusable(false);
        btnObrasocial1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnObrasocial1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnObrasocial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrasocial1ActionPerformed(evt);
            }
        });
        jToolBarButtons.add(btnObrasocial1);

        btnExit2.setFocusable(false);
        btnExit2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit2ActionPerformed(evt);
            }
        });
        jToolBarButtons.add(btnExit2);

        getContentPane().add(jToolBarButtons, java.awt.BorderLayout.NORTH);

        jDeskTopSis.setPreferredSize(new java.awt.Dimension(1024, 800));
        getContentPane().add(jDeskTopSis, java.awt.BorderLayout.CENTER);

        jStatusToolBar.setRollover(true);
        jStatusToolBar.add(lblFechaHora);

        getContentPane().add(jStatusToolBar, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("Archivo");

        jMenuProfesionales.setIcon(iconos.getProfesional(32));
        jMenuProfesionales.setText("Profesionales");
        jMenuProfesionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProfesionalesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuProfesionales);

        jMenuItemTurnos.setIcon(iconos.getTurnos(32));
        jMenuItemTurnos.setText("Turnos");
        jMenu1.add(jMenuItemTurnos);

        jMenuItemSetting.setIcon(iconos.getSetting(32));
        jMenuItemSetting.setText("Configuracion");
        jMenuItemSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSetting);

        jMenuBar.add(jMenu1);

        jMenu2.setText("Salir");

        jMenSalir.setIcon(iconos.getExit(32));
        jMenSalir.setText("Salir del Sistema");
        jMenSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenSalirActionPerformed(evt);
            }
        });
        jMenu2.add(jMenSalir);

        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenSalirActionPerformed
        salirSistema();
    }//GEN-LAST:event_jMenSalirActionPerformed

    private void btnExit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit2ActionPerformed
        salirSistema();
    }//GEN-LAST:event_btnExit2ActionPerformed

    private void btnPacientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientes1ActionPerformed
        _loadPacientes();
    }//GEN-LAST:event_btnPacientes1ActionPerformed

    private void jMenuProfesionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProfesionalesActionPerformed
    _loadProfesionales();
    }//GEN-LAST:event_jMenuProfesionalesActionPerformed

    private void btnEspecialidades2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialidades2ActionPerformed
        _loadEspecialidad();
    }//GEN-LAST:event_btnEspecialidades2ActionPerformed

    private void btnObrasocial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrasocial1ActionPerformed
        _loadObrasocial();
    }//GEN-LAST:event_btnObrasocial1ActionPerformed

    private void jMenuItemSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingActionPerformed
        _loadSetting();
    }//GEN-LAST:event_jMenuItemSettingActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botones.BtnEspecialidades btnEspecialidades2;
    private botones.BtnExit btnExit2;
    private botones.BtnObrasocial btnObrasocial1;
    private botones.BtnPacientes btnPacientes1;
    public static miselaneos.JDeskTopSis jDeskTopSis;
    private javax.swing.JMenuItem jMenSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemSetting;
    private javax.swing.JMenuItem jMenuItemTurnos;
    private javax.swing.JMenuItem jMenuProfesionales;
    private javax.swing.JToolBar jStatusToolBar;
    private javax.swing.JToolBar jToolBarButtons;
    private etiquetas.LblFechaHora lblFechaHora;
    // End of variables declaration//GEN-END:variables
}
