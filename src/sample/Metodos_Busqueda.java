package sample;

public class Metodos_Busqueda {
    public static int BinarioIterativo(int [] numeros, int valor){
        int max = numeros.length-1, min=0,m;
        while (min<=max){
            m=(min+max)/2;
            if (numeros[m]==valor){
                System.out.println(valor+" encontrado en la posición: ["+m+"]");
                return m;
            }
            if (valor<numeros[m]){
                /*
                si el valor buscado es menor que el central, entonces buscar a la izquierda
                 */
                max=m-1;
            }else {
                min=m+1;//se busca a la derecha
            }
        }
        System.out.println(valor + " no ha sido encontrado");
        return -1;//valor no encontrado
    }

}

