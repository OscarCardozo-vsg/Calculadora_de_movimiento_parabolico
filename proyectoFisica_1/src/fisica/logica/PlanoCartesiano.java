package fisica.logica;

import fisica.modelos.Proyectil;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PlanoCartesiano extends JPanel {

    private int alto;
    private int ancho;
    private int tamanoRayita;
    private int separacionRayita;
    private Color colorFondo;
    private Proyectil proyectil;
    private Formulas formual;

    public PlanoCartesiano(Color fondo, Dimension tamanno) {
        super();
        tamanoRayita = 8;
        separacionRayita = 60;

        colorFondo = fondo;
        alto = (int) tamanno.getHeight();
        ancho = (int) tamanno.getWidth();
        configurar();
    }

    private void configurar() {
        this.setBackground(colorFondo);
        this.setPreferredSize(new Dimension(ancho, alto));
    }

    @Override
    public void paint(Graphics lienzo) {
        super.paint(lienzo);
        int i, mitadX, mitadY, cantiRayitaX, cantiRayitaY, control;

        mitadY = alto / 2;
        mitadX = ancho / 2;

        lienzo.setColor(Color.black);
        // Eje X
        lienzo.drawLine(0, mitadY, ancho, mitadY);
        // Eje Y
        lienzo.drawLine(mitadX, 0, mitadX, alto);
        
        // Nombres de los ejes
        lienzo.drawString("eje y", mitadX + 10, 20);
        lienzo.drawString("eje x", ancho - 40, mitadY + 20);


        // Rayita del eje X
        control = separacionRayita;
        cantiRayitaX = cantidadRayitas(ancho);
        lienzo.setColor(Color.red);
        for (i = 0; i < cantiRayitaX; i++) {
            lienzo.drawLine(control, mitadY - tamanoRayita, control, mitadY + tamanoRayita);
            control = control + separacionRayita;
        }

        // Rayita del eje Y
        control = separacionRayita;
        cantiRayitaY = cantidadRayitas(alto);
        lienzo.setColor(Color.red);
        for (i = 0; i < cantiRayitaY; i++) {
            lienzo.drawLine(mitadX - tamanoRayita, control, mitadX + tamanoRayita, control);
            control = control + separacionRayita;
        }

        // Ejemplito del seno, copiado de Internet
        ejemplitoSeno(lienzo);

    }

    private int cantidadRayitas(int tamanno) {
        int cantidad, control;

        control = 0;
        cantidad = 0;
        while (control < tamanno) {
            control = control + tamanoRayita;
            cantidad++;
        }
        return cantidad;
    }

    private void ejemplitoSeno(Graphics lienzoSeno) {
        lienzoSeno.setColor(Color.gray);
        double w = 0.05;
        double incremento = 1;

        double temporalX = -ancho / 2;
        double temporalY = alto * 0.2 * Math.sin(-ancho / 2 * w);

        for (double x = -ancho / 2; x < ancho / 2; x = x + incremento) {
            double y = alto * 0.2 * Math.sin(w * x);
            lienzoSeno.drawLine(
                    (int) (temporalX + ancho / 2),
                    (int) (alto / 2 - temporalY),
                    (int) (x + ancho / 2),
                    (int) (alto / 2 - y));
            temporalX = x;
            temporalY = y;
        }

    }
}
