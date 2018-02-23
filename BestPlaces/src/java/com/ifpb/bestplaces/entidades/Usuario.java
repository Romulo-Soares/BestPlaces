
package com.ifpb.bestplaces.entidades;

public class Usuario {
    
    private String nome;
    private String nascimento;
    private String sexo;
    private String email;
    private String senha;
    private String cidade;
    private String fotoPerfil;
    private String profissao;

    public Usuario(){
    }

    public Usuario(String nome, String nascimento, String sexo, String email, 
            String senha, String cidade, String fotoPerfil, String profissao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.fotoPerfil = fotoPerfil;
        this.profissao = profissao;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo + ", email=" + email + ", senha=" + senha + ", cidade=" + cidade + ", fotoPerfil=" + fotoPerfil + ", profissao=" + profissao + '}';
    }

    

    
    
}
