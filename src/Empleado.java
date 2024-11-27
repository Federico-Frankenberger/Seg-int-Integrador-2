import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombreEmpleado;
    private long cuil;
    private int anioIngreso;
    private double montoAntiguedad;
    private double sueldoBasico;
    private List<BonoSueldo> bonos;


    public void mostrarTodo(int contador){
        for(BonoSueldo bs : bonos){
            System.out.println("El bono de sueldo a Liquidar es");
            System.out.println("Nombre: "+nombreEmpleado);
            System.out.println("Cuil: "+cuil);
            System.out.println("Mes Liquidacion: "+ bs.getMesLiquidacion()+"\t\t"+"Año liquidacion: "+bs.getAnioLiquidacion());
            System.out.println("Sueldo basico: "+sueldoBasico+"\t\t"+"Año Ingreso: "+anioIngreso);
            System.out.println("Código Item\t\t"+"Denominación\t\t"+"Haberes\t\t"+"Deducciones");
            System.out.println("\t\t"+"Sueldo básico "+ "\t\t"+sueldoBasico);
            System.out.println("\t\t"+"Antiguedad"+ "\t\t"+montoAntiguedad);
            String[][] muestro = bs.getBonocal();
            for(int i = 0; i < contador; i++){
                for(int j = 0; j < 4; j++){
                    System.out.print(muestro[i][j]+"\t");
                }
                System.out.println();
            }
            System.out.println("SUBTOTAL: "+"\t\t"+(bs.getSubHaberes()+sueldoBasico+montoAntiguedad)+"\t\t"+bs.getSubDeduc());
            System.out.println("Neto: "+bs.getMontoLiquidacion());

        }
    }
    public void cargaBonos(BonoSueldo bono) {
        if(bonos==null){
            bonos = new ArrayList<BonoSueldo>();
        }
        this.bonos.add(bono);
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public double getMontoAntiguedad() {
        return montoAntiguedad;
    }

    public void setMontoAntiguedad(double montoAntiguedad) {
        this.montoAntiguedad = montoAntiguedad;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public List<BonoSueldo> getBonos() {
        return bonos;
    }

    public void setBonos(List<BonoSueldo> bonos) {
        this.bonos = bonos;
    }
}
