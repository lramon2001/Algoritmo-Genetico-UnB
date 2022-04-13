/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Avaliacao {
    private Double valor;
    private Double espacoOcupado;

    public Avaliacao() {
        this.espacoOcupado=0.0;
        this.valor = 0.0;
    }

    public Avaliacao(Double valor, Double espacoOcupado) {
        this.valor = valor;
        this.espacoOcupado = espacoOcupado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getEspacoOcupado() {
        return espacoOcupado;
    }

    public void setEspacoOcupado(Double espacoOcupado) {
        this.espacoOcupado = espacoOcupado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.valor);
        hash = 19 * hash + Objects.hashCode(this.espacoOcupado);
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
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.espacoOcupado, other.espacoOcupado)) {
            return false;
        }
        return true;
    }
    
   
    
}
