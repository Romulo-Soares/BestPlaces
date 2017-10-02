package com.ifpb.BestPlaces.Entidades;

public class RecomendacaoLocal {

    private String usuario_recomendador;
    private String usuario_destino;
    private int id_local;

    public RecomendacaoLocal() {

    }

    public RecomendacaoLocal(String usuario_recomendador, String usuario_destino, int id_local) {
        this.usuario_recomendador = usuario_recomendador;
        this.usuario_destino = usuario_destino;
        this.id_local = id_local;
    }

    public String getUsuario_recomendador() {
        return usuario_recomendador;
    }

    public void setUsuario_recomendador(String usuario_recomendador) {
        this.usuario_recomendador = usuario_recomendador;
    }

    public String getUsuario_destino() {
        return usuario_destino;
    }

    public void setUsuario_destino(String usuario_destino) {
        this.usuario_destino = usuario_destino;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    @Override
    public String toString() {
        return "RecomendacaoLocal{" + "usuario_recomendador=" + usuario_recomendador + ", usuario_destino=" + usuario_destino + ", id_local=" + id_local + '}';
    }

}
