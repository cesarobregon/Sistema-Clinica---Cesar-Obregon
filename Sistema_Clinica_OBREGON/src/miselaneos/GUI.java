/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miselaneos;

import forms.Profesionales.FrmProfesionales;
import forms.especialidades.FrmEspecialidades;
import forms.obrasocial.FrmObraSocial;
import forms.pacientes.FrmPacientes;
import forms.settings.FrmSetting;
import java.awt.BorderLayout;
import java.util.HashMap;
import static sistema_clinica_obregon.JFrame_Sistema.jDeskTopSis;
/**
 *
 * @author OBREGON
 */
public class GUI {
    private HashMap<Integer,FrmIntern> frmList;
    
    public GUI(){
        frmList = new HashMap<Integer, FrmIntern>();
    }
    
    public FrmEspecialidades loadEspecialidad(int id, boolean isView){
        FrmEspecialidades frm = null;
        if(frmList.containsKey(id)){
            //si el id esta en la lista solo accedo al espacio/ubicacion de memoria del objeto
            frm = (FrmEspecialidades) frmList.get(id);
        }else{
            //sino creo el objeto
            frm = new FrmEspecialidades();
            //ingreso en la lista
            frmList.put(id, frm);
            //ingreso en el objeto JDeskTopSis
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }
        if(isView){
            //quiere decir que voy a mostrar el objeto FrmLocation
            frm._show();
        }
        return frm; //hago que el metodo retorne el objeto solicitado por si necesito en el futuro
    }
    
    public FrmPacientes loadPacientes(int id, boolean isView){
        FrmPacientes frm = null;
        if(frmList.containsKey(id)){
            //si el id esta en la lista solo accedo al espacio/ubicacion de memoria del objeto
            frm = (FrmPacientes) frmList.get(id);
        }else{
            //sino creo el objeto
            frm = new FrmPacientes();
            //ingreso en la lista
            frmList.put(id, frm);
            //ingreso en el objeto JDeskTopSis
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }
        if(isView){
            //quiere decir que voy a mostrar el objeto FrmLocation
            frm._show();
        }
        return frm; //hago que el metodo retorne el objeto solicitado por si necesito en el futuro
    }
    
    public FrmProfesionales loadProfesionales(int id, boolean isView){
        FrmProfesionales frm = null;
        if(frmList.containsKey(id)){
            //si el id esta en la lista solo accedo al espacio/ubicacion de memoria del objeto
            frm = (FrmProfesionales) frmList.get(id);
        }else{
            //sino creo el objeto
            frm = new FrmProfesionales();
            //ingreso en la lista
            frmList.put(id, frm);
            //ingreso en el objeto JDeskTopSis
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }
        if(isView){
            //quiere decir que voy a mostrar el objeto FrmLocation
            frm._show();
        }
        return frm; //hago que el metodo retorne el objeto solicitado por si necesito en el futuro
    }
    
    public FrmObraSocial loadObraSocial(int id, boolean isView){
        FrmObraSocial frm = null;
        if(frmList.containsKey(id)){
            //si el id esta en la lista solo accedo al espacio/ubicacion de memoria del objeto
            frm = (FrmObraSocial) frmList.get(id);
        }else{
            //sino creo el objeto
            frm = new FrmObraSocial();
            //ingreso en la lista
            frmList.put(id, frm);
            //ingreso en el objeto JDeskTopSis
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }
        if(isView){
            //quiere decir que voy a mostrar el objeto FrmLocation
            frm._show();
        }
        return frm; //hago que el metodo retorne el objeto solicitado por si necesito en el futuro
    }
    
    public FrmSetting loadSetting(int id, boolean isView){
        FrmSetting frm = null;
        if(frmList.containsKey(id)){
            //si el id esta en la lista solo accedo al espacio/ubicacion de memoria del objeto
            frm = (FrmSetting) frmList.get(id);
        }else{
            //sino creo el objeto
            frm = new FrmSetting();
            //ingreso en la lista
            frmList.put(id, frm);
            //ingreso en el objeto JDeskTopSis
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }
        if(isView){
            //quiere decir que voy a mostrar el objeto FrmLocation
            frm._show();
        }
        return frm; //hago que el metodo retorne el objeto solicitado por si necesito en el futuro
    }
}
