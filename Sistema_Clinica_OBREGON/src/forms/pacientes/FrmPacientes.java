package forms.pacientes;

import datos.Pacientes;
import entidades.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import miselaneos.FrmIntern;
import static sistema_clinica_obregon.JFrame_Sistema.iconos;	

/**
 *
 * @author OBREGON
 */
public class FrmPacientes extends FrmIntern {
    
    public static int id = 2;
    private DefaultTableModel modelo;
    private TableRowSorter<TableModel> orden;

    /**
     * Creates new form Frm_Pacientes
     */
    public FrmPacientes() {
        initComponents();
        _loadPacientes();
    }
    
    private void _initTable() {
        modelo = new DefaultTableModel();
        modelo.addColumn("#");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Domicilio");
        modelo.addColumn("DNI");
        modelo.addColumn("Localidad");
        modelo.addColumn("Provincia");
        modelo.addColumn("Celular");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        
        jTable.setRowSorter(null); //Elimino Filtro
        jTable.setModel(modelo);
    }
    
    private void _loadPacientes() {
        if (!btnNew.isEnabled()) {
            return;
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                btnNew.setEnabled(false);
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                
                _initTable();

                progressPacientes.setValue(0);
                ArrayList<Paciente> pacientesList = new ArrayList<Paciente>();
                Pacientes cnx = new Pacientes();
                if (cnx.isOkConexion()) {
                    pacientesList = cnx.list("SELECT * FROM " + cnx.getTabla());
                    cnx.isCloseConexion();
                }
                progressPacientes.setMaximum(pacientesList.size());
                progressPacientes.setVisible(true);

                modelo.setRowCount(0); //Soluciona el problema de la Exception(java.lang.ArrayIndexOutOfBoundsException)

                for (int index = 0; index < pacientesList.size(); index++) {
                    Paciente p = pacientesList.get(index);
                    modelo.addRow(p.toObject());
                    progressPacientes.setValue(index);
                }

                progressPacientes.setVisible(false);
                progressPacientes.setValue(0);

                setTitle("Pacientes...cantidad:" + pacientesList.size());
                
                btnNew.setEnabled(true);
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });
        t.start();
    }

    private boolean _isValidate(Paciente p) {
        boolean isOk = false;
        if (p.getApellido().trim().isEmpty()) {
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Apellido.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getNombre().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Nombre.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getDomicilio().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Domicilio.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getNroDocumento().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado DNI.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getLocalidad().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Localidad.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getProvincia().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Provincia.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getCelular().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Celular.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getTelefono().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Telefono.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }else if(p.getEmail().trim().isEmpty()){
            JOptionPane.showMessageDialog(pnlFicha, "No Ha Ingresado Email.-", "Aviso", JOptionPane.WARNING_MESSAGE);
            return isOk;
        }
        isOk = true;
        return isOk;
    }

    private Paciente _getPacienteForm() {
        Paciente p = new Paciente(0, "", "", "", "", "", "", "", "", "");

        p.setId(txtId.toEntero());
        p.setApellido(txtApellido.getText().trim());
        p.setNombre(txtNombre.getText().trim());
        p.setDomicilio(txtDomicilio.getText().trim());
        p.setNroDocumento(txtDoc.getText().trim());
        p.setLocalidad(txtLocalidad.getText().trim());
        p.setProvincia(txtProvincia.getText().trim());
        p.setCelular(txtCel.getText().trim());
        p.setTelefono(txtTel.getText().trim());
        p.setEmail(txtEmail.getText().trim());

        return p;
    }

    private void _setForm(Paciente p) {
        txtId.setText(String.valueOf(p.getId()));
        txtApellido.setText(p.getApellido().trim());
        txtNombre.setText(p.getNombre().trim());
        txtDomicilio.setText(p.getDomicilio().trim());
        txtDoc.setText(p.getNroDocumento().trim());
        txtLocalidad.setText(p.getLocalidad().trim());
        txtProvincia.setText(p.getProvincia().trim());
        txtCel.setText(p.getCelular().trim());
        txtTel.setText(p.getTelefono().trim());
        txtEmail.setText(p.getEmail().trim());

        txtApellido.requestFocus();
        txtNombre.requestFocus();
        txtDomicilio.requestFocus();
        txtDoc.requestFocus();
        txtLocalidad.requestFocus();
        txtProvincia.requestFocus();
        txtCel.requestFocus();
        txtTel.requestFocus();
        txtEmail.requestFocus();
    }

    private void _selectionRow() {
        int indexRow = jTable.getSelectedRow();
        int indexModel = jTable.convertRowIndexToModel(indexRow);

        int id = (int) modelo.getValueAt(indexModel, 0);
        String apellido = (String) modelo.getValueAt(indexModel, 1);
        String nombre = (String) modelo.getValueAt(indexModel, 2);
        String domicilio = (String) modelo.getValueAt(indexModel, 3);
        String documento = (String) modelo.getValueAt(indexModel, 4);
        String localidad = (String) modelo.getValueAt(indexModel, 5);
        String provincia = (String) modelo.getValueAt(indexModel, 6);
        String celular = (String) modelo.getValueAt(indexModel, 7);
        String telefono = (String) modelo.getValueAt(indexModel, 8);
        String email = (String) modelo.getValueAt(indexModel, 9);

        Paciente p = new Paciente(id, apellido, nombre, domicilio, documento, localidad, provincia, celular, telefono, email);
        _setForm(p);
    }
    
    private void _filter(String texto){
        try{
            orden = new TableRowSorter<TableModel>(modelo);
            this.jTable.setRowSorter(orden);
            RowFilter<TableModel, Object> filtro = RowFilter.regexFilter(texto.trim());
            orden.setRowFilter(filtro);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
    }

    private boolean _isNew() {
        boolean isOk = false;
        Paciente p = _getPacienteForm();
        if (_isValidate(p)) {
            //Esta en codiciones
            Pacientes cnx = new Pacientes();
            if (cnx.isOkConexion()) {
                isOk = cnx.isNew(p);
                if (isOk) {
                    cnx.isCloseConexion();
                } else {
                    cnx.isCancelConexion();
                }
            }
        }
        return isOk;
    }

    private boolean _isUpdate() {
        boolean isOk = false;
        Paciente p = _getPacienteForm();
        if (_isValidate(p)) {
            //Esta en codiciones
            Pacientes cnx = new Pacientes();
            if (cnx.isOkConexion()) {
                isOk = cnx.isUpdate(p);
                if (isOk) {
                    cnx.isCloseConexion();
                } else {
                    cnx.isCancelConexion();
                }
            }
        }
        return isOk;
    }

    private boolean _isDelete() {
        boolean isOk = false;
        Paciente p = _getPacienteForm();
        if (_isValidate(p)) {
            //Esta en codiciones
            if (JOptionPane.showConfirmDialog(pnlFicha, "Desea Eliminar.", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                return isOk;
            }
            Pacientes cnx = new Pacientes();
            if (cnx.isOkConexion()) {
                isOk = cnx.isDelete(p);
                if (isOk) {
                    cnx.isCloseConexion();
                } else {
                    cnx.isCancelConexion();
                }
            }
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

        jTabbedPane = new javax.swing.JTabbedPane();
        pnlLista = new javax.swing.JPanel();
        pnlFilList = new javax.swing.JPanel();
        lblFilter1 = new etiquetas.LblFilter();
        txtFilter = new texto.TxtMayusculas();
        pnlList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        progressPacientes = new javax.swing.JProgressBar();
        pnlFichaPaciente = new javax.swing.JPanel();
        pnlFicha = new javax.swing.JPanel();
        id1 = new etiquetas.Id();
        lblCheck1 = new etiquetas.LblCheck();
        lblCheck2 = new etiquetas.LblCheck();
        lblCheck3 = new etiquetas.LblCheck();
        lblCheck4 = new etiquetas.LblCheck();
        txtApellido = new texto.TxtMayusculas();
        txtNombre = new texto.TxtMayusculas();
        txtDomicilio = new texto.TxtMayusculas();
        txtId = new texto.TxtNro();
        lblCheck6 = new etiquetas.LblCheck();
        txtLocalidad = new texto.TxtMayusculas();
        txtDoc = new javax.swing.JTextField();
        lblCheck7 = new etiquetas.LblCheck();
        txtCel = new texto.TxtMayusculas();
        lblCheck8 = new etiquetas.LblCheck();
        txtTel = new texto.TxtMayusculas();
        lblCheck9 = new etiquetas.LblCheck();
        txtEmail = new texto.TxtMayusculas();
        lblCheck5 = new etiquetas.LblCheck();
        txtProvincia = new texto.TxtMayusculas();
        pnlButtons = new javax.swing.JPanel();
        btnEdit = new botones.BtnEdit();
        btnDelete = new botones.BtnDelete();
        btnNew = new botones.BtnNew();

        setTitle("Pacientes");
        setFrameIcon(iconos.getPaciente(16));

        pnlLista.setLayout(new java.awt.BorderLayout());

        pnlFilList.setPreferredSize(new java.awt.Dimension(762, 40));

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlFilListLayout = new javax.swing.GroupLayout(pnlFilList);
        pnlFilList.setLayout(pnlFilListLayout);
        pnlFilListLayout.setHorizontalGroup(
            pnlFilListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );
        pnlFilListLayout.setVerticalGroup(
            pnlFilListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilListLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnlFilListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlLista.add(pnlFilList, java.awt.BorderLayout.NORTH);

        pnlList.setLayout(new java.awt.BorderLayout());

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        pnlList.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        progressPacientes.setVisible(false);
        pnlList.add(progressPacientes, java.awt.BorderLayout.PAGE_START);

        pnlLista.add(pnlList, java.awt.BorderLayout.CENTER);

        jTabbedPane.addTab("Lista", iconos.getList(16)
            , pnlLista);

        pnlFichaPaciente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFicha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCheck1.setText("Apellido:");

        lblCheck2.setText("Nombre(s):");

        lblCheck3.setText("Documento:");

        lblCheck4.setText("Domicilio:");

        txtApellido.setLenghtText(25);

        txtNombre.setLenghtText(30);

        txtDomicilio.setLenghtText(60);

        txtId.setEditable(false);
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCheck6.setText("Localidad");

        txtLocalidad.setLenghtText(60);

        lblCheck7.setText("Nro. Celular");

        txtCel.setLenghtText(60);

        lblCheck8.setText("Nro. Telefono");

        txtTel.setLenghtText(60);

        lblCheck9.setText("Email");

        txtEmail.setLenghtText(60);

        lblCheck5.setText("Provincia:");

        txtProvincia.setLenghtText(60);

        javax.swing.GroupLayout pnlFichaLayout = new javax.swing.GroupLayout(pnlFicha);
        pnlFicha.setLayout(pnlFichaLayout);
        pnlFichaLayout.setHorizontalGroup(
            pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFichaLayout.createSequentialGroup()
                        .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCheck9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFichaLayout.createSequentialGroup()
                                .addComponent(lblCheck5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)))
                        .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(143, 143, 143))
        );
        pnlFichaLayout.setVerticalGroup(
            pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFichaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblCheck2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFichaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblCheck3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheck4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCheck8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheck9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlFichaPaciente.add(pnlFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 450));

        pnlButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlButtons.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, -1));

        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        pnlButtons.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        pnlFichaPaciente.add(pnlButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 140, 140));

        jTabbedPane.addTab("Ficha Paciente", pnlFichaPaciente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        _filter(txtFilter.getText().trim());
    }//GEN-LAST:event_txtFilterKeyReleased

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        _selectionRow();
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyReleased
        _selectionRow();
    }//GEN-LAST:event_jTableKeyReleased

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if (_isNew()) {
            _setForm(new Paciente());
            _loadPacientes();
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (!btnEdit.isEnabled()) {
            return;
        }
        if (_isUpdate()) {
            _loadPacientes();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!btnDelete.isEnabled()) {
            return;
        }
        if (_isDelete()) {
            _loadPacientes();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botones.BtnDelete btnDelete;
    private botones.BtnEdit btnEdit;
    private botones.BtnNew btnNew;
    private etiquetas.Id id1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable;
    private etiquetas.LblCheck lblCheck1;
    private etiquetas.LblCheck lblCheck2;
    private etiquetas.LblCheck lblCheck3;
    private etiquetas.LblCheck lblCheck4;
    private etiquetas.LblCheck lblCheck5;
    private etiquetas.LblCheck lblCheck6;
    private etiquetas.LblCheck lblCheck7;
    private etiquetas.LblCheck lblCheck8;
    private etiquetas.LblCheck lblCheck9;
    private etiquetas.LblFilter lblFilter1;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlFicha;
    private javax.swing.JPanel pnlFichaPaciente;
    private javax.swing.JPanel pnlFilList;
    private javax.swing.JPanel pnlList;
    private javax.swing.JPanel pnlLista;
    private javax.swing.JProgressBar progressPacientes;
    private texto.TxtMayusculas txtApellido;
    private texto.TxtMayusculas txtCel;
    private javax.swing.JTextField txtDoc;
    private texto.TxtMayusculas txtDomicilio;
    private texto.TxtMayusculas txtEmail;
    private texto.TxtMayusculas txtFilter;
    private texto.TxtNro txtId;
    private texto.TxtMayusculas txtLocalidad;
    private texto.TxtMayusculas txtNombre;
    private texto.TxtMayusculas txtProvincia;
    private texto.TxtMayusculas txtTel;
    // End of variables declaration//GEN-END:variables
}
