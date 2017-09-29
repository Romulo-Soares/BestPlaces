
package com.ifpb.BestPlaces.Entidades;

public class Local {
    
    private int id;
    private String usuario;
    private String nome;
    private String rua;
    private String cidade;
    private String descricao;
    private String estado;
    private String tipo;

    public Local(){
        
    }

    public Local(int id, String usuario, String nome, String rua, String cidade, String descricao, String estado, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.descricao = descricao;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Local{" + "id=" + id + ", usuario=" + usuario + ", nome=" + nome + ", rua=" + rua + ", cidade=" + cidade + ", descricao=" + descricao + ", estado=" + estado + ", tipo=" + tipo + '}';
    }

}
