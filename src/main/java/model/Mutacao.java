/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lucas
 */
public class Mutacao {
    public static Individuo mutar(Individuo individuo, Double taxa)
    {
        for(int i=0;i<individuo.getCromossomo().size();i++)
        {
            if(Math.random()<taxa)
            {
                if(individuo.getCromossomo().get(i).equals(1))
                {
                    individuo.getCromossomo().set(i, 0);
                }
                else
                {
                    individuo.getCromossomo().set(i, 1);
                }
            }
        }
        return individuo;
    }
}
