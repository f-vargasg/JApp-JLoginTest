
package com.fvgprinc.jlogintest.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author garfi
 */

@Entity
public class Usuario implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    private String nombreUsuario;

    /**
     * Get the value of nombreUsuario
     *
     * @return the value of nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Set the value of nombreUsuario
     *
     * @param nombreUsuario new value of nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    private String contraseia;

    public String getContraseia() {
        return contraseia;
    }

    public void setContraseia(String contraseia) {
        this.contraseia = contraseia;
    }
    
    @ManyToOne
    @JoinColumn(name = "fk_rol")
    Rol unRol;

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contraseia, Rol unRol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseia = contraseia;
        this.unRol = unRol;
    }
    
    
    
    
    
    
    
    
    

}
