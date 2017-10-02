
package com.ifpb.BestPlaces.Entidades;

public class PresencaLocal {
    
    private int idLocal;
    private String usuario;
    private String comentario;
    private String status;
    private String data;
    
    public PresencaLocal(){
        
    }

    public PresencaLocal(int idLocal, String usuario, String comentario, String status, String data) {
        this.idLocal = idLocal;
        this.usuario = usuario;
        this.comentario = comentario;
        this.status = status;
        this.data = data;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
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
        return "PresencaLocal{" + "idLocal=" + idLocal + ", usuario=" + usuario + ", comentario=" + comentario + ", status=" + status + ", data=" + data + '}';
    }
    
}
