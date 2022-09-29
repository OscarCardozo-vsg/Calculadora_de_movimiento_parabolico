package fisica.jpaneles;

import fisica.logica.Formulas;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafica extends javax.swing.JPanel {
    XYSeriesCollection graficaVelocidad = new XYSeriesCollection();
    XYSeries puntos1 = new XYSeries("Velocidad");
    Formulas formulas;
    ArrayList<String> listaAngulo = new ArrayList<>();
    ArrayList<String> listaTiempo = new ArrayList<>();

    public Grafica() {
        initComponents();
    }

    private void graficaVelocidad() {
        
        for (int i=0; i<listaAngulo.size(); i++) {
            float angulo = Float.valueOf(listaAngulo.get(i));
            float tiempo = Float.valueOf(listaTiempo.get(i));
            float anguloRadianes = (float) Math.toRadians(angulo);
            float sinAngulo = (float) Math.sin(Math.toRadians(anguloRadianes));  
            
            puntos1.add(sinAngulo,tiempo);   
        }
        graficaVelocidad.addSeries(puntos1);        
        JFreeChart chart1 = ChartFactory.createXYLineChart("Velocidad", "seno del angulo", "Tiempo de vuelo", graficaVelocidad, PlotOrientation.VERTICAL, true, false, false);
        
        ChartPanel panel1 = new ChartPanel(chart1);
        panelGrafica.setLayout(new java.awt.BorderLayout());
        panelGrafica.add(panel1);
        panelGrafica.validate();
    }
    
    
    public void loadBundler() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("Proyectil.txt"))) {
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] list = data.split("\t");
                    listaAngulo.add(list[2]);
                    listaTiempo.add(list[4]);
                }
            }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrafica = new javax.swing.JPanel();
        botonGrafica = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        panelGrafica.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout panelGraficaLayout = new javax.swing.GroupLayout(panelGrafica);
        panelGrafica.setLayout(panelGraficaLayout);
        panelGraficaLayout.setHorizontalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelGraficaLayout.setVerticalGroup(
            panelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        botonGrafica.setText("Generar grafica");
        botonGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonGrafica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficaActionPerformed

        try {
            loadBundler();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0; i<listaAngulo.size(); i++) {
            System.out.println(listaTiempo.get(i));
        }
        
        graficaVelocidad();
    }//GEN-LAST:event_botonGraficaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGrafica;
    private javax.swing.JPanel panelGrafica;
    // End of variables declaration//GEN-END:variables
}
