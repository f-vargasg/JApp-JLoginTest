
package com.fvgprinc.jlogintest.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author garfi
 */

@Entity
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }
    
        private String nombreRol;

    /**
     * Get the value of nombreRol
     *
     * @return the value of nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Set the value of nombreRol
     *
     * @param nombreRol new value of nombreRol
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

        private String descripcion;

    /**
     * Get the value of descripcion
     *
     * @return the value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @param descripcion new value of descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @OneToMany(mappedBy = "unRol")
    List<Usuario> listaUsuarios;

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    

    public Rol() {
    }

    public Rol(int id, String nombreRol, String descripcion, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }



    
}
