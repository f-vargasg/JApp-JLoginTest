
package com.fvgprinc.jlogintest.persistencia;

import com.fvgprinc.jlogintest.logica.Usuario;
import java.util.List;

/**
 *
 * @author garfi
 */
public class ControladoraPersistencia {
    UsuarioJpaController usuJpa;

    public ControladoraPersistencia() {
        this.usuJpa = new UsuarioJpaController();
    }
   
    
    public List<Usuario> traerUsuarios() {
        return  usuJpa.findUsuarioEntities();
    }
    
    
}
