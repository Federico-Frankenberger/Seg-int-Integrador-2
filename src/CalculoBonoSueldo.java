import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculoBonoSueldo {
    static String[][] haberes = {
            {"100", "Presentismo", "9"},
            {"101", "Titulo Profesional", "9"},
            {"102", "Horas Extraordinarias", "M"},
            {"103", "Horas Nocturnas", "M"},
            {"104", "Otros Haberes", "M"}
    };

    static String[][] deducciones = {
            {"200", "Obra Social", "3"},
            {"201", "Jubilacion", "11"},
            {"202", "Sindicato", "2"},
            {"203", "Seguro", "1.5"},
            {"204", "Otros", "M"}
    };

    static List<Integer> codigosIngresados= new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //creo empleado
        Empleado empleado = new Empleado();

        System.out.println("Ingrese el nombre completo del empleado:");
        empleado.setNombreEmpleado(sc.nextLine());
        System.out.println("Ingrese el cuil del empleado:");
        empleado.setCuil(sc.nextInt());
        do {
            System.out.println("Ingrese el año de ingreso:");
            empleado.setAnioIngreso(sc.nextInt());
            if (empleado.getAnioIngreso() > 2024) {
                System.out.println("El año de ingreso no puede superar al actual!");
            }
        }while (empleado.getAnioIngreso() > 2024);
        System.out.println("Ingrese el sueldo básico:");
        empleado.setSueldoBasico(sc.nextDouble());
        System.out.println("Ingrese el mes de liquidacion:");
        int mes = sc.nextInt();
        int anio;
        do {
            System.out.println("Ingrese el año de liquidacion:");
            anio = sc.nextInt();
        }while (anio>2024);
        sc.nextLine();
        double porcentaje =((anio- empleado.getAnioIngreso())*0.02);

        while(true){
            //creo bono
            BonoSueldo bono = new BonoSueldo();
            bono.inicioBono(empleado,mes,anio);
            empleado.setMontoAntiguedad((empleado.getSueldoBasico())*porcentaje);
            Validaciones v = new Validaciones();
            String [][] bonoCalculado= new String[10][4];
            int contador=0;
            int contador2 = 0;
            System.out.println("Ingrese los Haberes del empleado");
            String codigo;
            do{
                while (true){
                    do{
                        System.out.println("Ingrese el codigo del item:");
                        codigo = sc.nextLine();
                        if(codigo.equalsIgnoreCase("000")){
                            break;
                        }
                        if(v.validarCarga(codigosIngresados,codigo)){
                            System.out.println("El codigo ya fue cargado intente con otro");
                        }else {
                            codigosIngresados.add(Integer.parseInt(codigo));
                            contador2 = 0;
                            for(int i = 0;i<haberes.length;i++){
                                if(codigo.equalsIgnoreCase(haberes[i][0])){
                                    contador2++;
                                    bonoCalculado[contador][0]=haberes[i][1];
                                    bonoCalculado[contador][1]=haberes[i][2];
                                    bonoCalculado[contador][3]=String.valueOf(0);
                                    if(haberes[i][2].equalsIgnoreCase("M")){
                                        System.out.println("Ingrese el valor del porcentaje:");
                                        double porcentaje2 = sc.nextDouble();
                                        sc.nextLine();
                                        double valorHaber = empleado.getSueldoBasico()*porcentaje2;
                                        bonoCalculado[contador][2]=String.valueOf(valorHaber);
                                    }else {
                                        double valorhaber = empleado.getSueldoBasico()*((Double.parseDouble(haberes[i][2]))/100);
                                        bonoCalculado[contador][2]=String.valueOf(valorhaber);
                                    }
                                    contador++;
                                    contador2++;
                                }
                                if(contador2==0&&i==haberes.length-1){
                                    System.out.println("El codigo ingresado no se encontro, vuelva a intentarlo");
                                }


                            }
                        }
                    }while (v.validarCarga(codigosIngresados,codigo)||contador2==0);
                    if(codigo.equalsIgnoreCase("000")){
                        break;
                    }
                }
                if(contador==0){
                    System.out.println("Al menos tiene que ingresar 1 haber");
                }
            }while (contador==0);

            //deducciones
            int contadorDeduc=0;
            System.out.println("Ingrese las deducciones del empleado");
            do{
                while (true){
                    do{
                        System.out.println("Ingrese el codigo del item:");
                        codigo = sc.nextLine();
                        if(codigo.equalsIgnoreCase("000")){
                            break;
                        }
                        boolean control = v.validarCarga(codigosIngresados,codigo);
                        System.out.println(control);
                        if(v.validarCarga(codigosIngresados,codigo)){
                            System.out.println("El codigo ya fue cargado intente con otro");
                        }else {
                            codigosIngresados.add(Integer.parseInt(codigo));
                            contador2 = 0;
                            for(int i = 0;i<deducciones.length;i++){
                                if(codigo.equalsIgnoreCase(deducciones[i][0])){
                                    contador2++;
                                    bonoCalculado[contador][0]=deducciones[i][1];
                                    bonoCalculado[contador][1]=deducciones[i][2];
                                    bonoCalculado[contador][2]=String.valueOf(0);
                                    if(deducciones[i][2].equalsIgnoreCase("M")){
                                        System.out.println("Ingrese el valor del porcentaje:");
                                        double porcentaje2 = sc.nextDouble();
                                        sc.nextLine();
                                        double valorHaber = empleado.getSueldoBasico()*porcentaje2;
                                        bonoCalculado[contador][3]=String.valueOf(valorHaber);
                                    }else {
                                        double valorhaber = (empleado.getSueldoBasico()*((Double.parseDouble(deducciones[i][2]))/100));
                                        bonoCalculado[contador][3]=String.valueOf(valorhaber);
                                    }
                                    contador++;
                                    contador2++;
                                }
                                if(contador2==0&&i==haberes.length-1){
                                    System.out.println("El codigo ingresado no se encontro, vuelva a intentarlo");
                                }
                            }
                            contadorDeduc++;
                        }
                    }while (v.validarCarga(codigosIngresados,codigo)||contador2==0);
                    if(codigo.equalsIgnoreCase("000")){
                        break;
                    }
                }
                if(contadorDeduc==0){
                    System.out.println("Al menos tiene que ingresar 1 una Deduccion");
                }
            }while (contadorDeduc==0);
            bono.setBonocal(bonoCalculado);
            bono.montoLiquidacion(contador);
            empleado.cargaBonos(bono);
            System.out.println("Desea cargar otro Bono ?");
            String respuesta = sc.nextLine();
            if(respuesta.equalsIgnoreCase("NO")){
                empleado.mostrarTodo(contador);
                break;
            }else{
                codigosIngresados.clear();
            }
        }


















    }















}
