/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Lucas
 */
public class Grafico extends JFrame {
    
    private List<Individuo> melhoresCromossomos = new ArrayList<Individuo>();
    
    public Grafico(String tituloDaJanela,String tituloDoGrafico, List melhores){
        super(tituloDaJanela);
        this.melhoresCromossomos = melhores;
        JFreeChart graficoDeLinha = ChartFactory.createLineChart(tituloDoGrafico,
                "Geração", "Valor", 
                carregaDados(), 
                PlotOrientation.VERTICAL, true, true, false);
        ChartPanel janelaGrafico = new ChartPanel(graficoDeLinha);
        janelaGrafico.setPreferredSize(new java.awt.Dimension(600,300));
        setContentPane(janelaGrafico); 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(105, 105, 105));
        setForeground(new java.awt.Color(105,105,105));
        setResizable(false);
        //janelaGrafico.
      //  janelaGrafico.
    }
    private DefaultCategoryDataset carregaDados() {
        DefaultCategoryDataset dados = new DefaultCategoryDataset();
        for(int i=0; i< melhoresCromossomos.size();i++){
            dados.addValue(melhoresCromossomos.get(i).getAvaliacao().getValor(),"Melhor solução",""+i);
        }
        return dados;
    }
}
