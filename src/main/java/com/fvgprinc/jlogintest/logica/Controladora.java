/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fvgprinc.jlogintest.logica;

import com.fvgprinc.jlogintest.persistencia.ControladoraPersistencia;
import static java.awt.SystemColor.control;
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

    public void crearUsuario(String usuario, String contra, String nomRol) {
        Usuario usu = new Usuario();
        Rol rol = null;

        usu.setNombreUsuario(usuario);
        usu.setContraseia(contra);
        rol = this.traerRol(nomRol);
        if (rol != null) {

            usu.setUnRol(rol);
            int id = this.buscarUltimaIdUsuarios() + 1;
            usu.setId(id);
            controlPersis.crearUsuario(usu);
        }

    }

    private Rol traerRol(String nomRol) {
        List<Rol> listRoles = controlPersis.traerRoles();

        for (Rol rol : listRoles) {
            if (rol.getNombreRol().equals(nomRol)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        Usuario usu = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (!listaUsuarios.isEmpty()) {
            usu = listaUsuarios.get(listaUsuarios.size() - 1);
            return usu.getId();
        } else {
            return 1;
        }

    }

    public void borrarUsuario(int idUsuario) {
        controlPersis.borrarUsuario(idUsuario);
    }

    public Usuario traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usu, String nomUsuario, String contra, String nomRol) {
        usu.setNombreUsuario(nomUsuario);
        usu.setContraseia(contra);
        Rol rol = this.traerRol(nomRol);
        if (rol != null) {
            usu.setUnRol(rol);
            controlPersis.editarUsuario(usu);
        }
        
    }

}
