package com.ifpb.bestplaces.entidades;

public class PresencaEvento {

    private int idEvento;
    private String usuario;
    private String comentario;
    private String status;
    private String data;

    public PresencaEvento() {

    }

    public PresencaEvento(int idEvento, String usuario, String comentario, String status, String data) {
        this.idEvento = idEvento;
        this.usuario = usuario;
        this.comentario = comentario;
        this.status = status;
        this.data = data;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PresencaEvento{" + "idEvento=" + idEvento + ", usuario="
                + usuario + ", comentario=" + comentario + ", status="
                + status + ", data=" + data + '}';
    }

}