
package com.ifpb.bestplaces01.entidades;

public class Foto {
    
    private int id;
    private String foto;

    public Foto() {
    }

    public Foto(int id, String foto) {
        this.id = id;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Fotos{" + "id=" + id + ", foto=" + foto + '}';
    }
  
}
