
package com.ifpb.BestPlaces.Entidades;

public class AvaliacaoLocal {
    
    private int idLocal;
    private String avaliador;
    private int nota;
    
    public AvaliacaoLocal(){
        
    }

    public AvaliacaoLocal(int idLocal, String avaliador, int nota) {
        this.idLocal = idLocal;
        this.avaliador = avaliador;
        this.nota = nota;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "AvaliacaoLocal{" + "idLocal=" + idLocal + ", avaliador=" + avaliador + ", nota=" + nota + '}';
    }

}
