package fisica.jpaneles;

import fisica.modelos.Proyectil;
import javax.swing.table.DefaultTableModel;

public class Tabla extends javax.swing.JPanel {
    int id = 1;
    Proyectil proyectil = new Proyectil();
    DefaultTableModel modelo;

    public Tabla() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane = new javax.swing.JScrollPane();
        tablaTabla = new javax.swing.JTable();

        tablaTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Velocidad inicial", "Angulo", "Planeta", "Gravedad", "Tiempo de Vuelo", "Alcance maximo", "Altura maxima"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JScrollPane.setViewportView(tablaTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     public void anadirTabla(String planeta, float gravedad, float velocidadInicial, float angulo, float tiempoVuelo, float Xmax, float Ymax){
        modelo = (DefaultTableModel) tablaTabla.getModel();
        Object[] fila = {id,velocidadInicial,angulo,planeta,gravedad,tiempoVuelo,Xmax,Ymax};
        
        modelo.addRow(fila);
        id++;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JTable tablaTabla;
    // End of variables declaration//GEN-END:variables
}
