 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package br.com.rogerio.dal;

import br.com.rogerio.model.Aluno;
import br.com.rogerio.model.ColecaoDeObjetos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author roger
 */
public class AlunoDal {

    private String nomeDoArquivo;

    public AlunoDal() {
    }

    public AlunoDal(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public int quantidadeDeAlunosNoArquivo() throws Exception {
        try {
            int quantidade = 0;
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                quantidade++;
            }
            br.close();
            return quantidade;

        } catch (Exception erro) {
            throw erro;
        }
    }

    public Iterator listagemDeAlunosVetor() throws Exception {
        try {
            int quantidade = this.quantidadeDeAlunosNoArquivo();
            Aluno[] array = new Aluno[quantidade];
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while ((linha = br.readLine()) != null) {
                Aluno aux = new Aluno(linha);
                array[pos] = aux;
                pos++;
            }
            br.close();
            ordenaVetorDeAlunos(array);
            ColecaoDeObjetos aux = new ColecaoDeObjetos(array);
            return aux;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public Iterator listagemDeAlunosArrayList() throws Exception {
        try {
            ArrayList<Aluno> array = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while ((linha = br.readLine()) != null) {
                Aluno aux = new Aluno(linha);
                array.add(aux);
                pos++;
            }
            br.close();
            ordenaArrayDeAlunos(array);
            return array.iterator(); 
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void ordenaVetorDeAlunos(Aluno[] lista) throws Exception {
        for (int i = 0; i < lista.length; i++) {
            for (int j = i; j < lista.length; j++) {
                if (lista[i].getNome().compareToIgnoreCase(lista[j].getNome()) >= 0) {
                    Aluno temp = lista[j];
                    lista[j] = lista[i];
                    lista[i] = temp;
                }
            }
        }
    }
    
     public void ordenaArrayDeAlunos(ArrayList<Aluno> lista) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i; j < lista.size(); j++) {
                if (lista.get(i).getNome().compareToIgnoreCase(lista.get(j).getNome()) >= 0) {
                    Aluno temp = lista.get(j);
                    lista.set(j, lista.get(i));
                    lista.set(i, temp);
                }
            }
        }
    }

}
