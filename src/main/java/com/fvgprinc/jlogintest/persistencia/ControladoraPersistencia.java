
package com.fvgprinc.jlogintest.persistencia;

import com.fvgprinc.jlogintest.logica.Rol;
import com.fvgprinc.jlogintest.logica.Usuario;
import java.util.List;

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
    
    
}
