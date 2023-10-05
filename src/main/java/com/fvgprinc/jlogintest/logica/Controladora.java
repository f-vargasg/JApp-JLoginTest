/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fvgprinc.jlogintest.logica;

import com.fvgprinc.jlogintest.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author garfi
 */
public class Controladora {

    ControladoraPersistencia controlPersis;

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        // String mensaje = MyCommonString.EMPTYSTR;
        Usuario usr = null;
        boolean ok = false;
        List<Usuario> listaUsuario = controlPersis.traerUsuarios();

        String msgDeb = String.format("Usuario => %s  Contraseña => %s", usuario, contrasenia);
        System.out.println(msgDeb);
        for (Usuario usu : listaUsuario) {
            msgDeb = String.format("Usuario Db => %s  Contraseña Db => %s", usu.getNombreUsuario(), usu.getContraseia());
            System.out.println(msgDeb);
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContraseia().equals(contrasenia)) {
                    usr = usu;
                }
            }
        } 
        return usr;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }



}
