/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package websockets;

/**
 *
 * @author xmnislas
 */
public class Mensaje {
    private String usuario;
    private Alumno entidad;

    public Mensaje() {
    }

    public Mensaje(String usuario, Alumno entidad) {
        this.usuario = usuario;
        this.entidad = entidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Alumno getEntidad() {
        return entidad;
    }

    public void setEntidad(Alumno entidad) {
        this.entidad = entidad;
    }
}
