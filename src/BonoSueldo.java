public class BonoSueldo {
    private Empleado empleado;
    private int mesLiquidacion;
    private int anioLiquidacion;
    private double montoLiquidacion;
    private String[][] bonocal;
    private double subHaberes;
    private double subDeduc;



    public void montoLiquidacion(int contador) {
        double resultado;
        double subTotalHaberes = 0;
        double subTotalDeduc=0;
        for(int i = 0;i<contador;i++){
            subTotalHaberes += Double.valueOf(bonocal[i][2]);
            subTotalDeduc += Double.valueOf(bonocal[i][3]);
        }
        this.subHaberes = subTotalHaberes;
        this.subDeduc = subTotalDeduc;
        resultado = (empleado.getSueldoBasico()+empleado.getMontoAntiguedad()+subTotalHaberes)-(subTotalDeduc);
        this.montoLiquidacion = resultado;
    }
    public void inicioBono(Empleado empleado, int mesLiquidacion,int anioLiquidacion) {
        this.empleado = empleado;
        this.mesLiquidacion = mesLiquidacion;
        this.anioLiquidacion = anioLiquidacion;
        this.montoLiquidacion = 0;
    }

    public double getSubHaberes() {
        return subHaberes;
    }

    public void setSubHaberes(double subHaberes) {
        this.subHaberes = subHaberes;
    }

    public double getSubDeduc() {
        return subDeduc;
    }

    public void setSubDeduc(double subDeduc) {
        this.subDeduc = subDeduc;
    }

    public String[][] getBonocal() {
        return bonocal;
    }

    public void setBonocal(String[][] bonocal) {
        this.bonocal = bonocal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getMesLiquidacion() {
        return mesLiquidacion;
    }

    public void setMesLiquidacion(int mesLiquidacion) {
        this.mesLiquidacion = mesLiquidacion;
    }

    public int getAnioLiquidacion() {
        return anioLiquidacion;
    }

    public void setAnioLiquidacion(int anioLiquidacion) {
        this.anioLiquidacion = anioLiquidacion;
    }

    public double getMontoLiquidacion() {
        return montoLiquidacion;
    }

    public void setMontoLiquidacion(double montoLiquidacion) {
        this.montoLiquidacion = montoLiquidacion;
    }
}
