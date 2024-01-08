/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botones;

import static sistema_clinica_obregon.JFrame_Sistema.iconos;

/**
 *
 * @author OBREGON
 */
public class BtnPacientes extends Btn{
    public BtnPacientes(){
        setText("Pacientes");
        setIcon(iconos.getPaciente(32));
    }
}
