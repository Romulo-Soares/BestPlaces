
package com.ifpb.bestplaces.entidades;

public class PostagemPresencaEventos {
    
    private PresencaEvento presencaEvento;
    private Evento evento;
    
    public PostagemPresencaEventos(){
        
    }

    public PresencaEvento getPresencaEvento() {
        return presencaEvento;
    }

    public void setPresencaEvento(PresencaEvento presencaEvento) {
        this.presencaEvento = presencaEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "PostagemPresencaEventos{" + "presencaEvento=" + presencaEvento + ", evento=" + evento + '}';
    }
    
}
