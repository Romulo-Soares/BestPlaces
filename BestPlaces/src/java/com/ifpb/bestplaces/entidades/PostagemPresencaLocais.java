
package com.ifpb.bestplaces.entidades;

public class PostagemPresencaLocais {
    
    private String idLocal;
    private String nomeLocal;
    private String ruaLocal;
    private String cidadeLocal;
    private String descricaoLocal;
    private String estadoLocal;
    private String tipoLocal;
    private String usuarioPresenciador;
    private String comentarioPresenciador;
    private String statusPresenciador;
    private String dataPresenca;
    
    public PostagemPresencaLocais(){
    
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getRuaLocal() {
        return ruaLocal;
    }

    public void setRuaLocal(String ruaLocal) {
        this.ruaLocal = ruaLocal;
    }

    public String getCidadeLocal() {
        return cidadeLocal;
    }

    public void setCidadeLocal(String cidadeLocal) {
        this.cidadeLocal = cidadeLocal;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public String getEstadoLocal() {
        return estadoLocal;
    }

    public void setEstadoLocal(String estadoLocal) {
        this.estadoLocal = estadoLocal;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getUsuarioPresenciador() {
        return usuarioPresenciador;
    }

    public void setUsuarioPresenciador(String usuarioPresenciador) {
        this.usuarioPresenciador = usuarioPresenciador;
    }

    public String getComentarioPresenciador() {
        return comentarioPresenciador;
    }

    public void setComentarioPresenciador(String comentarioPresenciador) {
        this.comentarioPresenciador = comentarioPresenciador;
    }

    public String getStatusPresenciador() {
        return statusPresenciador;
    }

    public void setStatusPresenciador(String statusPresenciador) {
        this.statusPresenciador = statusPresenciador;
    }

    public String getDataPresenca() {
        return dataPresenca;
    }

    public void setDataPresenca(String dataPresenca) {
        this.dataPresenca = dataPresenca;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public String toString() {
        return "PostagemPresencaLocais{" + "idLocal=" + idLocal + ", nomeLocal=" + nomeLocal + ", ruaLocal=" + ruaLocal + ", cidadeLocal=" + cidadeLocal + ", descricaoLocal=" + descricaoLocal + ", estadoLocal=" + estadoLocal + ", tipoLocal=" + tipoLocal + ", usuarioPresenciador=" + usuarioPresenciador + ", comentarioPresenciador=" + comentarioPresenciador + ", statusPresenciador=" + statusPresenciador + ", dataPresenca=" + dataPresenca + '}';
    }

   
    
}
