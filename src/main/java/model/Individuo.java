/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Individuo implements Comparable<Individuo>{
    private Lista lista;
    private List<Double> volumes;
    private List<Double> valores;
    private List<Integer>cromossomo;
    private Double espacoLimite;
    private Integer geracao;
    private Avaliacao avaliacao;
    public void aloca_vetores()
    {
        this.volumes = new ArrayList<Double>();
        this.valores = new ArrayList<Double>();
        this.cromossomo = new ArrayList<Integer>();
        
    }
    public Individuo(Lista lista,Double limite)
    {
        this.aloca_vetores();
        this.volumes = lista.getVolumes();
        this.valores = lista.getValores();
        this.espacoLimite = limite;
        this.avaliacao = new Avaliacao();
        this.geracao = 0;
        
        for(int i=0;i<this.volumes.size();i++)
        {
            if(java.lang.Math.random() <0.5)
            {
                this.cromossomo.add(0);
            }
            else
            {
                this.cromossomo.add(1);
            }
        }
    }

    public Avaliacao avaliar()
    {
        Double somaEspaco =0.0;
        Double somaValor = 0.0;
        for(int i=0;i<this.cromossomo.size();i++)
        {
            if(cromossomo.get(i).equals(1))
            {
                somaEspaco += this.volumes.get(i);
                somaValor += this.valores.get(i);
            }
            
        }
        if(somaEspaco> this.espacoLimite)
        {
            somaValor =1.0;
        }
        this.avaliacao.setEspacoOcupado(somaEspaco);
        this.avaliacao.setValor(somaValor);
        
        return this.avaliacao;
    }

    public List<Double> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Double> volumes) {
        this.volumes = volumes;
    }

    public Double getEspacoLimite() {
        return espacoLimite;
    }

    public void setEspacoLimite(Double espacoLimite) {
        this.espacoLimite = espacoLimite;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
    public List<Double> getVolume() {
        return volumes;
    }

    public void setVolume(List<Double> volume) {
        this.volumes = volume;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public List<Integer> getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(List<Integer> cromossomo) {
        this.cromossomo = cromossomo;
    }

 
    public Double getLimite() {
        return espacoLimite;
    }

    public void setLimite(Double limite) {
        this.espacoLimite = limite;
    }

    public Integer getGeracao() {
        return geracao;
    }

    public void setGeracao(Integer geracao) {
        this.geracao = geracao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.volumes);
        hash = 31 * hash + Objects.hashCode(this.valores);
        hash = 31 * hash + Objects.hashCode(this.cromossomo);
        hash = 31 * hash + Objects.hashCode(this.espacoLimite);
        hash = 31 * hash + Objects.hashCode(this.geracao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Individuo other = (Individuo) obj;
        if (!Objects.equals(this.volumes, other.volumes)) {
            return false;
        }
        if (!Objects.equals(this.valores, other.valores)) {
            return false;
        }
        if (!Objects.equals(this.cromossomo, other.cromossomo)) {
            return false;
        }
        if (!Objects.equals(this.espacoLimite, other.espacoLimite)) {
            return false;
        }
        if (!Objects.equals(this.geracao, other.geracao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Individuo"+"\nVolumes: "+this.volumes +"\nValores: "+this.valores +"\nCromossomos: "+this.cromossomo;
    }

    @Override
    public int compareTo(Individuo arg0) {
        if(this.getAvaliacao().getValor()> arg0.getAvaliacao().getValor()){
            return -1;
        }
        
          if(this.getAvaliacao().getValor()< arg0.getAvaliacao().getValor()){
            return 1;
        }
        
        return 0;
            
    }
    
    
}
