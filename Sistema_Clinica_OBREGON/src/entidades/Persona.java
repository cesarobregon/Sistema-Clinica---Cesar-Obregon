/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author OBREGON
 */
public class Persona {
    private int id;
    private String apellido;
    private String nombre;

    public Persona(int id, String apellido, String nombre) {
        this.setId(id);
        this.setApellido(apellido);
        this.setNombre(nombre);
        
    }

    public Persona() {
        this.setId(0);
        this.setApellido("");
        this.setNombre("");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
