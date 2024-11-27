import java.util.List;

public class Validaciones {



    public boolean validarCarga (List<Integer> codigosIngresados,String codigo) {
        int codigo2 = Integer.valueOf(codigo);
        boolean resultado = false;
        if(codigosIngresados.contains(codigo2)){
            resultado = true;
        }else {
            resultado = false;
        }
        return resultado;
    }

}
