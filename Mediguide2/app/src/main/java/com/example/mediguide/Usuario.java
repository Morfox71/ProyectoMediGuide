package com.example.mediguide;

public class Usuario {
    private String usuario;
    private String contra;
    private String correo;
    private String inicio_sesion;


    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public String getCorreo() {
        return correo;
    }

    public String getInicio_sesion() {
        return inicio_sesion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setInicio_sesion(String inicio_sesion) {
        this.inicio_sesion = inicio_sesion;
    }
}
