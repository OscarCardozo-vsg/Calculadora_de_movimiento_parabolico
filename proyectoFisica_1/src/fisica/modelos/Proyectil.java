package fisica.modelos;

public class Proyectil {
    private float angulo, velocidadInicial, gravedad,tiempoVuelo, Xmax, Ymax;
    private String planeta;

    public Proyectil() {
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public float getVelocidadInicial() {
        return velocidadInicial;
    }

    public void setVelocidadInicial(float velocidadInicial) {
        this.velocidadInicial = velocidadInicial;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }

    public float getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(float tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public float getXmax() {
        return Xmax;
    }

    public void setXmax(float xmax) {
        Xmax = xmax;
    }

    public float getYmax() {
        return Ymax;
    }

    public void setYmax(float Ymax) {
        this.Ymax = Ymax;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString(){
        return "Para un proyectil con angulo: "+angulo+"°, y un tiempo vuelo de: "+tiempoVuelo+"s, tiene:"
                + "\n*Una velocidad inicial de: "+velocidadInicial+"m/s."
                + "\n*Un alcance maximo de: "+Xmax+"m."
                + "\n*Una altura maxima de: "+Ymax+"m.";
    }
}

