
package com.fvgprinc.jlogintest.persistencia;

import com.fvgprinc.jlogintest.logica.Rol;
import com.fvgprinc.jlogintest.logica.Usuario;
import com.fvgprinc.jlogintest.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garfi
 */
public class ControladoraPersistencia {
    UsuarioJpaController usuJpa;
    RolJpaController rolJpa;

    public ControladoraPersistencia() {
        this.usuJpa = new UsuarioJpaController();
        this.rolJpa = new RolJpaController();
    }
   
    
    public List<Usuario> traerUsuarios() {
        return  usuJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }

    public void borrarUsuario(int idUsuario) {
        try {
            usuJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int idUsuario) {
          return usuJpa.findUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     

    
    
    
}
