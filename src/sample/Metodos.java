package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;



public class Metodos {
    public static int[] BurbujaMejorada(int[] numeros) {
        int buffer;
        int i,j;
        for(i = 0; i < numeros.length; i++)
        {
            for(j = 0; j < i; j++)
            {
                if(numeros[i] < numeros[j])
                {
                    buffer = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = buffer;
                }
            }
        }
        return numeros;
    }
    private static int[] matrix;
    public static  int[]  QuickSort(int[] numeros){
        matrix =  numeros;

        /*
        al invocar al método público QuickSort(int[] numeros) se invoca al algoritmo QuickSort, depués de ser ordenado el arreglo se devuelve
         */
        _Quicksort(matrix, 0, matrix.length-1); //invocar al ordenamiento
        return  matrix; //devolver el arreglo ordenado
    }

    private static void _Quicksort(int[] numeros, int a, int b)
    {
        matrix = new int[numeros.length];
        int buf;
        int from = a;
        int to = b;
        int pivot = numeros[(from+to)/2];
        do
        {
            while(numeros[from] < pivot)
            {
                from++;
            }
            while(numeros[to] > pivot)
            {
                to--;
            }
            if(from <= to)
            {
                buf = numeros[from];
                numeros[from] = numeros[to];
                numeros[to] = buf;
                from++; to--;
            }
        }while(from <= to);
        if(a < to)
        {
            _Quicksort(numeros, a, to);
        }
        if(from < b)
        {
            _Quicksort(numeros, from, b);
        }
        matrix = numeros;
    }
    public static  int[]  MergeSort(int[] numeros){

        /*
        Este método sólo se usa para invocar al verdadero algoritmo de ordenación
        El verdadero algoritmo se divide en 2 partes (2 métodos), por lo tanto, se requiere de un arreglo compartido para que ambos funcionene
        Por lo que se optó por agregar un arreglo(matrix) como campo de la clase que al invocar al método público MergeSort(int[] numeros) se invoque al algoritmo MergeSort, depués de ser ordenado el arreglo se devuelve
         */

        matrix = numeros;
        mergesort(matrix, 0, matrix.length); //invocar al ordenamiento
        return  matrix; //devolver el arreglo ordenado
    }

    private static void mergesort(int[ ] matrix, int init, int n)
    {
        int n1;
        int n2;
        if (n > 1)
        {
            n1 = n / 2;
            n2 = n - n1;
            mergesort(matrix, init, n1);
            mergesort(matrix, init + n1, n2);
            merge(matrix, init, n1, n2);
        }
    }

    /**
     * La segunda parte de mergesort es el método que une las 2 partes
     * @param matrix
     * @param init
     * @param n1
     * @param n2
     * @return
     */
    private static void merge(int[ ] matrix, int init, int n1, int n2)
    {
        int[ ] buffer = new int[n1+n2];
        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        int i;
        while ((temp1 < n1) && (temp2 < n2))
        {
            if (matrix[init + temp1] < matrix[init + n1 + temp2])
                buffer[temp++] = matrix[init + (temp1++)];
            else
                buffer[temp++] = matrix[init + n1 + (temp2++)];
        }
        while (temp1 < n1)
            buffer[temp++] = matrix[init + (temp1++)];
        while (temp2 < n2)
            buffer[temp++] = matrix[init + n1 + (temp2++)];
        for (i = 0; i < n1+n2; i++)
            matrix[init + i] = buffer[i];
    }
    public  static int[] Shellsort(int[] numeros) {
        for ( int increment = numeros.length / 2; increment > 0; increment =
                (increment == 2 ? 1 : (int) Math.round(increment / 2.2)))
        {
            for (int i = increment; i < numeros.length; i++)
            {
                for (int j = i; j >= increment && numeros[j - increment] >
                        numeros[j]; j -= increment)
                {
                    int temp = numeros[j];
                    numeros[j] = numeros[j - increment];
                    numeros[j - increment] = temp;
                }
            }
        }

        return  numeros;
    }


}
