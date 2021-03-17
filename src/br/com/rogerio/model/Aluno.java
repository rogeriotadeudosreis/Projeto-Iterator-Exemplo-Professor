/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rogerio.model;

/**
 *
 * @author roger
 */
public class Aluno {

    private String matricula;
    private String nome;

    public Aluno() {
    }

    public Aluno(String str) {
        String[] vetor = str.split(";");
        this.matricula = vetor[0];
        this.nome = vetor[1];
    }

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
