package fisica.logica;

import fisica.jpaneles.Tabla;
import fisica.modelos.Proyectil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Formulas {
    private final Proyectil proyectil = new Proyectil();
    int id = 1;
    Tabla tabla = new Tabla();

    //aqui hace la operacion
    public void operacion(float gravedad, float angulo, float sinAngulo, String planeta, float tiempoVuelo) {
        float velocidadInicial,Xmax,Ymax;
        if(angulo < 90 && angulo > 0){  
            float anguloRadianes = (float) Math.toRadians(angulo);

            velocidadInicial = (float) ((gravedad * tiempoVuelo)/2 * Math.sin(anguloRadianes));
            Xmax = (float) ((Math.pow(velocidadInicial, 2) * Math.sin(2 * anguloRadianes)) / gravedad);
            Ymax = (float) ((Math.pow(velocidadInicial, 2)) * (Math.pow(Math.sin(anguloRadianes), 2) / 2 * gravedad));
            //guardo los datos en la clase proyectil
            proyectil.setVelocidadInicial(velocidadInicial);
            proyectil.setAngulo(angulo);
            proyectil.setPlaneta(planeta);
            proyectil.setGravedad(gravedad);
            proyectil.setTiempoVuelo(tiempoVuelo);
            proyectil.setXmax(Xmax);
            proyectil.setYmax(Ymax);

            JOptionPane.showMessageDialog(null, proyectil);
        }else{
            JOptionPane.showMessageDialog(null, "Coloque un angulo mayor a 0.0° y menor a 90.0°", "ERROR", JOptionPane.ERROR_MESSAGE);            
        }
    }
    
    public Proyectil enviarProyectil(){
        return proyectil;
    }
       
    public void anadirTxt() throws FileNotFoundException, IOException{
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File file = new File("Proyectil.txt");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar información al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(id+"\t"+proyectil.getVelocidadInicial()+"\t"+proyectil.getAngulo()+"\t"+proyectil.getGravedad()+"("+proyectil.getPlaneta()+")\t"+proyectil.getTiempoVuelo()+"\t"+proyectil.getXmax()+"\t"+proyectil.getYmax()+"\n");
            id++;
            JOptionPane.showMessageDialog(null, "Informacion agregada");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } 

        finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
}
