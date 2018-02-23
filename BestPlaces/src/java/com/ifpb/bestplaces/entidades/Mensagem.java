
package com.ifpb.bestplaces.entidades;

public class Mensagem {
    
    private String remetente;
    private String destinatario;
    private String mensagem;
    
    public Mensagem(){
        
    }

    public Mensagem(String remetente, String destinatario, String mensagem) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }
    
    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "remetente=" + remetente + ", destinatario=" + 
                destinatario + ", mensagem=" + mensagem + '}';
    }
    
}
