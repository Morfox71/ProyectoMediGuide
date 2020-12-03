package com.example.mediguide;

public class Entidad {

    private int imgFoto;
    private String titulo;
    private String contenido;
    private String lugar_venta;

    public Entidad(int imgFoto, String titulo, String contenido, String lugar_venta) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
        this.lugar_venta = lugar_venta;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getLugar_venta(){ return lugar_venta; }

}
