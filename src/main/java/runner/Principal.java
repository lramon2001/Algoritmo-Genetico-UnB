/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;


import java.util.List;
import model.AlgoritmoGenetico;
import model.Lista;
import model.Produto;


/**
 *
 * @author Lucas
 */
public class Principal {
Double limite;
Integer tamanhoDaPopulacao;
Double taxaDeMutacao;
Integer numeroDeGeracoes;


    public static void main(String[] args) {

    //cria a lista com produtos
      List<Produto> listaProdutos = Arquivo.criaListaDeProdutos();
    //preenche o atributo lista
    Lista lista = new Lista(listaProdutos);
     
    
    
    //Tamanho,mutacao,numero de geracoes,limite de espaco
      AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico(20);
      algoritmoGenetico.resolver(0.1, 500, 3.0, lista);
      
    }
    
    
    
    

}
