/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Crossover {
    
    public static List<Integer> misturaVetores(int c,List<Integer> cromossomo1, List<Integer> cromossomo2)
    {
        List<Integer> cromossomo = new ArrayList<Integer>();
        for(int i=0;i<c;i++)
        {
            cromossomo.add(cromossomo1.get(i));
        }
        
        for(int j=c;j<cromossomo2.size();j++)
        {
             cromossomo.add(cromossomo2.get(j));
        }
        
        return cromossomo;
    }
            
    
    public static List<Individuo> crossover(Individuo a, Individuo b, Lista lista)
    {
    
     int corte = (int) Math.round(Math.random()*a.getCromossomo().size());
     List<Individuo> output = new ArrayList<Individuo>();
     
     Individuo filho1 = new Individuo(lista,a.getLimite());
     filho1.setGeracao(a.getGeracao()+1);
     filho1.setCromossomo(misturaVetores(corte,a.getCromossomo(),b.getCromossomo()));
     output.add(filho1);
     
     Individuo filho2 = new Individuo(lista,b.getLimite());
     filho2.setGeracao(b.getGeracao()+1);
     filho2.setCromossomo(misturaVetores(corte,b.getCromossomo(),a.getCromossomo()));
     output.add(filho2);
      //  System.out.println("Corte: "+ corte);
     return output;
    }
}
