/*
*Clase usada para cargar/configurar la informacion de conexion
*a la base de datos
 */
package forms.settings;

import static sistema_clinica_obregon.JFrame_Sistema.iconos;
import javax.swing.JOptionPane;
import miselaneos.Encripta;
import miselaneos.FileConexion;
import miselaneos.FrmIntern;

/**
 *
 * @author pablo
 */
public class FrmSetting extends FrmIntern {

    public static int id = 5;

    /**
     * Creates new form FrmSetting
     */
    public FrmSetting() {
        initComponents();
        loadFile();
    }

    public void loadFile() {
        FileConexion f = new FileConexion();
        boolean isOk = f.loadFile();
        if (!isOk) {
            f.createFile();
            f.loadFile();
        }
        loadConfig(f);
    }

    public void loadConfig(FileConexion f) {
        Encripta encry = new Encripta();
        
        txtHostName.setText(f.getValorPropiedad("hostname").trim());
        txtDB.setText(f.getValorPropiedad("nameDB").trim());
        txtUser.setText(f.getValorPropiedad("user").trim());
        txtPws.setText(encry.desencrypt(f.getValorPropiedad("pws").trim()));
        txtPort.setText(f.getValorPropiedad("port").trim());
    }

    private boolean validFields() {
        boolean isOk = true;
        if (txtHostName.getText().trim().isEmpty()
                || txtDB.getText().trim().isEmpty()
                || txtUser.getText().trim().isEmpty()
                || txtPws.getText().trim().isEmpty()
                || txtPort.getText().trim().isEmpty()) {
            isOk = false;
        }
        return isOk;
    }

    public boolean updateConfig(){
        boolean isOk = false;
        Encripta encry = new Encripta();
        FileConexion f = new FileConexion();
        if (f.loadFile()) {
            f.setValorPropiedad("hostname", txtHostName.getText().trim());
            f.setValorPropiedad("nameDB", txtDB.getText().trim());
            f.setValorPropiedad("user", txtUser.getText().trim());
            f.setValorPropiedad("pws", encry.encryt(txtPws.getText().trim()));
            f.setValorPropiedad("port", txtPort.getText().trim());
            isOk = true;
        }
        return isOk;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHostName = new javax.swing.JTextArea();
        id1 = new etiquetas.Id();
        id2 = new etiquetas.Id();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDB = new javax.swing.JTextArea();
        id3 = new etiquetas.Id();
        id4 = new etiquetas.Id();
        id5 = new etiquetas.Id();
        txtUser = new javax.swing.JTextField();
        txtPws = new javax.swing.JPasswordField();
        txtPort = new javax.swing.JTextField();
        pnlBoton = new javax.swing.JPanel();
        btnSetting = new botones.BtnSetting();
        btnCancel = new botones.BtnCancel();

        setClosable(false);
        setMaximizable(false);
        setTitle("Config. de Conexión");
        setFrameIcon(iconos.getSetting(16)
        );
        setPreferredSize(new java.awt.Dimension(321, 341));
        getContentPane().setLayout(new java.awt.BorderLayout());

        txtHostName.setColumns(20);
        txtHostName.setRows(5);
        jScrollPane1.setViewportView(txtHostName);

        id1.setText("HostName");

        id2.setText("Base De Datos");

        txtDB.setColumns(20);
        txtDB.setRows(5);
        jScrollPane2.setViewportView(txtDB);

        id3.setText("Usuario:");

        id4.setText("Contraseña:");

        id5.setText("Puerto:");

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCentroLayout.createSequentialGroup()
                        .addComponent(id5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCentroLayout.createSequentialGroup()
                        .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPws, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(txtUser))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlBoton.setPreferredSize(new java.awt.Dimension(433, 40));

        btnSetting.setText("Actualizar");
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });
        pnlBoton.add(btnSetting);

        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlBoton.add(btnCancel);

        getContentPane().add(pnlBoton, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        if(validFields()){
            if(updateConfig()){
               this.hide();
            }else{
                JOptionPane.showMessageDialog(pnlCentro, "No Se Actualizo El Archivo de Configuración...", "Atención!!!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(pnlCentro, "Controle los datos cargados.-", "Atención!!!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSettingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botones.BtnCancel btnCancel;
    private botones.BtnSetting btnSetting;
    private etiquetas.Id id1;
    private etiquetas.Id id2;
    private etiquetas.Id id3;
    private etiquetas.Id id4;
    private etiquetas.Id id5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlBoton;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JTextArea txtDB;
    private javax.swing.JTextArea txtHostName;
    private javax.swing.JTextField txtPort;
    private javax.swing.JPasswordField txtPws;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}