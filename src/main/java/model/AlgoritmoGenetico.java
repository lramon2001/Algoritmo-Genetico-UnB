/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class AlgoritmoGenetico {
    
    private Integer tamanho;
    private List<Individuo> populacao;
    private Integer geracao;
    private Individuo melhorIndividuo;
    private List<Individuo> melhores = new ArrayList<Individuo>();
   

    public AlgoritmoGenetico(Integer tamanho) {
        populacao = new ArrayList<Individuo>();
        this.tamanho = tamanho;
    }

 
    
    public void melhorIndividuo(Individuo individuo){
        if(individuo.getAvaliacao().getValor()> this.melhorIndividuo.getAvaliacao().getValor()){
            this.melhorIndividuo = individuo;
        }
        
    }
    
    public Double somaAvaliacoes(){
        Double soma =0.0;
        for(Individuo individuo : populacao){
            soma+=individuo.getAvaliacao().getValor();       
        }
        return soma;
    }
    public void inicializaPopulacao(Lista lista, Double limiteEspacos){
        for(int i=0; i<this.tamanho;i++)
        {
            this.populacao.add(new Individuo(lista, limiteEspacos));
        }
        
        this.melhorIndividuo = this.populacao.get(0);
    }
    
    public void avaliaPopulacao(){
        for(int i=0;i<this.populacao.size();i++)
        {
            this.populacao.get(i).avaliar();
        }
        
        
    }
    public int selecionaPai(Double somaAvaliacao){
        int pai = -1;
        Double ValorSorteado = Math.random()*somaAvaliacao;
        Double soma =0.0;
        int contador =0;
      
        while(contador<this.getPopulacao().size() && soma<ValorSorteado)
        {
           soma+= this.getPopulacao().get(contador).getAvaliacao().getValor();
           contador+=1;
           pai+=1;
        }
        return pai;
    }
    
    public String visualizaGeracao()
    {
        this.avaliaPopulacao();
        this.ordenaPopulacao();
        Individuo melhorIndividuo = this.populacao.get(0);
        melhores.add(melhorIndividuo);
        String output ="Geração: "+melhorIndividuo.getGeracao()
        +"\nValor: "+melhorIndividuo.getAvaliacao().getValor()
        +"\nEspaço Ocupado: "+ melhorIndividuo.getAvaliacao().getEspacoOcupado()
        +"\nCromossomo: "+melhorIndividuo.getCromossomo()+"\n\n";
        return output;
    }
    
    public List<String> resolver(Double taxaDeMutacao, Integer numeroDeGeracoes, Double limiteDeEspaco,Lista lista){
        this.inicializaPopulacao(lista, limiteDeEspaco);
        this.avaliaPopulacao();
        this.ordenaPopulacao();
        this.visualizaGeracao();
        String melhores ="";
        for(int geracao = 0; geracao< numeroDeGeracoes;geracao++){
            Double somaDasAvaliacoes = this.somaAvaliacoes();
           
            List<Individuo> novaPopulacao = new ArrayList<Individuo>();
            
            for(int i=0; i< this.getPopulacao().size()/2;i++){
                int pai1 = this.selecionaPai(somaDasAvaliacoes);
                int pai2 = this.selecionaPai(somaDasAvaliacoes);
                
                List<Individuo> filhos = new ArrayList<Individuo>();
                filhos = Crossover.crossover(this.getPopulacao().get(pai1),this.getPopulacao().get(pai2) , lista);
                Mutacao.mutar(filhos.get(0), taxaDeMutacao);
                Mutacao.mutar(filhos.get(1), taxaDeMutacao);
                
                novaPopulacao.add(filhos.get(0));
                novaPopulacao.add(filhos.get(1));
            }
            this.setPopulacao(novaPopulacao);
            this.avaliaPopulacao();
            this.ordenaPopulacao();
            melhores+=  this.visualizaGeracao();
            melhorIndividuo(this.getPopulacao().get(0));
            
        }
        String melhorSolucao ="Melhor soulução geração: "+ this.melhorIndividuo.getGeracao()+
        "\nValor: "+this.melhorIndividuo.getAvaliacao().getValor()+
        "\nEspaço: "+this.melhorIndividuo.getAvaliacao().getEspacoOcupado()+
        "\nCromossomo: "+this.melhorIndividuo.getCromossomo();
        List <String> outputList = new ArrayList<String>();
        outputList.add(melhorSolucao);
        outputList.add(melhores);
        return outputList;
    }
    public void ordenaPopulacao(){
        Collections.sort(this.populacao);
    }
    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public List<Individuo> getPopulacao() {
        return populacao;
    }

    public void setPopulacao(List<Individuo> populacao) {
        this.populacao = populacao;
    }

    public Integer getGeracao() {
        return geracao;
    }

    public void setGeracao(Integer geracao) {
        this.geracao = geracao;
    }

    public Individuo getMelhorIndividuo() {
        return melhorIndividuo;
    }

    public void setMelhorIndividuo(Individuo melhorIndividuo) {
        this.melhorIndividuo = melhorIndividuo;
    }

    public List<Individuo> getMelhores() {
        return melhores;
    }

    public void setMelhores(List<Individuo> melhores) {
        this.melhores = melhores;
    }
          
    
        
}
