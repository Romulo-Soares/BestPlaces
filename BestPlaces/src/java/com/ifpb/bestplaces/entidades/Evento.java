package com.ifpb.bestplaces.entidades;

public class Evento {
    
    private int id;
    private String Usuario;
    private int idLocal;
    private String nome;
    private String data;
    private String hora;
    private String local;
    private String descricao;

    public Evento() {
    }

    public Evento(int id, String Usuario, int idLocal, String nome, String data, String hora, String local, String descricao) {
        this.id = id;
        this.Usuario = Usuario;
        this.idLocal = idLocal;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", Usuario=" + Usuario + ", idLocal=" + idLocal + ", nome=" + nome + ", data=" + data + ", hora=" + hora + ", local=" + local + ", descricao=" + descricao + '}';
    }

}
