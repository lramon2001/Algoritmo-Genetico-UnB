/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runner;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author Lucas
 */
public class Arquivo {
    
    
     public static List<Produto> criaListaDeProdutos(){
       List<Produto> listaProdutos = new ArrayList<Produto>();
        listaProdutos.add(new Produto("Geladeira Marca A", 0.751, 999.0));
        listaProdutos.add(new Produto("Celular caro", 0.000089, 2911.12));
        listaProdutos.add(new Produto("TV 55", 0.400, 4346.99));
        listaProdutos.add(new Produto("TV 50", 0.290, 3999.90));
        listaProdutos.add(new Produto("TV 42", 0.200, 2999.00));
        listaProdutos.add(new Produto("Computador ", 0.00350, 2499.00));
        listaProdutos.add(new Produto("Ventilador", 0.496, 199.90));
        listaProdutos.add(new Produto("Microondas marca A", 0.0424, 308.66));
        listaProdutos.add(new Produto("Microondas marca B", 0.0544, 429.90));
        listaProdutos.add(new Produto("Microondas marca C", 0.0319, 299.29));
        listaProdutos.add(new Produto("Geladeira marca B", 0.635, 849.00));
        listaProdutos.add(new Produto("Geladeira marca C", 0.870, 1999.90));
        listaProdutos.add(new Produto("Computador marca B", 0.498, 1999.90));
        listaProdutos.add(new Produto("Computador marca C", 0.527, 3999.00));
        return listaProdutos;
    }
    
     
}
