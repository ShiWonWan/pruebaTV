package com.example.pruebatv;

import java.io.Serializable;

public class Movie implements Serializable {
    private String titulo;
    private String descripcion;
    private String videoUrl;
    private String categoria;
    private String poster;
    public Movie(){
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    @Override
    public String toString(){
        return "Movie{"+
                "titulo=\'" + titulo + "\'" +
                ", descripcion=\'" + descripcion + "\'" +
                ", videoUrl=\'" + videoUrl + "\'" +
                ", categoria=\'" + categoria + "\'" +
                ", poster=\'" + poster + "\'" +
                "}";
    }
}
