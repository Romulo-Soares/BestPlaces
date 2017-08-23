
package com.ifpb.bestplaces.entidades;

import java.time.LocalDate;

public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String profissao;
    private LocalDate nascimento;
    private String fotoPerfil;
    private String cidade;

    public Usuario(){
        
    }

    public Usuario(String nome, String email, String senha, String sexo, 
            String profissao, LocalDate nascimento, String fotoPerfil, 
            String cidade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.profissao = profissao;
        this.nascimento = nascimento;
        this.fotoPerfil = fotoPerfil;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + 
                senha + ", sexo=" + sexo + ", profissao=" + profissao + 
                ", nascimento=" + nascimento + ", fotoPerfil=" + fotoPerfil + 
                ", cidade=" + cidade + '}';
    }
    
    
    
    
}
