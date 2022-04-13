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
public class Lista {
    private  List<Double> valores;
    private  List<Double> volumes;
    private  List<String> nomes;

    public Lista(List<Produto> listaDeProdutos) {
        valores = new ArrayList<Double>();
        volumes = new ArrayList<Double>();
        nomes = new ArrayList<String>();   
        for(int i=0;i<listaDeProdutos.size();i++){
            this.adiconaNome(listaDeProdutos.get(i));
            this.adiconaValor(listaDeProdutos.get(i));
            this.adiconaVolume(listaDeProdutos.get(i));
        }
    }
    
    public void adiconaValor(Produto produto)
    {
        this.valores.add(produto.getValor());
    }
    
    public void adiconaNome(Produto produto)
    {
         this.nomes.add(produto.getNome());
    }
    
    public void adiconaVolume(Produto produto)
    {
         this.volumes.add(produto.getVolume());
    }

    public int tamanho()
    {
        return this.volumes.size();
    }
    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public List<Double> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Double> volumes) {
        this.volumes = volumes;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.valores);
        hash = 97 * hash + Objects.hashCode(this.volumes);
        hash = 97 * hash + Objects.hashCode(this.nomes);
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
        final Lista other = (Lista) obj;
        if (!Objects.equals(this.valores, other.valores)) {
            return false;
        }
        if (!Objects.equals(this.volumes, other.volumes)) {
            return false;
        }
        if (!Objects.equals(this.nomes, other.nomes)) {
            return false;
        }
        return true;
    }
    
    
}
