package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import static sample.Metodos.*;

public class Controller implements Initializable {
@FXML
Button GenerarBtn, OrdenarBtn,BuscarBtn;
@FXML
TextField taskTxt,BuscarTxt;
@FXML
ListView ListaLvw, ListaLvw1;
@FXML
RadioButton BurbujRb,QSRb,MSRb,SSRb;


    public int[] valores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskTxt.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED , numeric_Validation(4));
        //BuscarTxt.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED , numeric_Validation(4));

        this.GenerarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ListaLvw.getItems().clear();
                //obtener valores que ingresa el usuario y convertir a entero
                int elementos= Integer.parseInt(taskTxt.getText());
                //Llamar al metodo y darle el numero de elementos
                ValoresAleatorios(elementos);

            }
        });




        this.OrdenarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                if(BurbujRb.isSelected()==true){
                    EnviaValores1(valores);


                }
                if(QSRb.isSelected()==true){
                    EnviaValores2(valores);
                }
                if (SSRb.isSelected()==true){
                    EnviaValores3(valores);
                }
                if (MSRb.isSelected()==true){
                    EnviaValores4(valores);
                }


            }
        });
        ToggleGroup metodos = new ToggleGroup();
        BurbujRb.setToggleGroup(metodos);
        QSRb.setToggleGroup(metodos);
        MSRb.setToggleGroup(metodos);
        SSRb.setToggleGroup(metodos);



    }


    public void EnviaValores1(int [] numeros){
        int[] nuevos=BurbujaMejorada(numeros);
        //System.out.print(Arrays.toString(nuevos));
        this.ListaLvw.getItems().clear();
        for(int i= 0; i < numeros.length; i++){
            //Envia los valores ordenados a la lista
            this.ListaLvw.getItems().addAll(nuevos[i]);
        }

        String.valueOf(nuevos);

        for (int i= numeros.length-1; i>=0; i-- ){
            this.ListaLvw1.getItems().addAll(nuevos[i]);
        }


    }
    public void EnviaValores2(int [] numeros){
        int[] nuevos=QuickSort(numeros);
        //System.out.print(Arrays.toString(nuevos));
        this.ListaLvw.getItems().clear();
        int des=numeros.length;
        for(int i= 0; i < des; i++){
            this.ListaLvw.getItems().addAll(nuevos[i]);
            //Envia los valores a la lista

        }

        String.valueOf(nuevos);

        for (int i= des-1; i>=0; i-- ){
            this.ListaLvw1.getItems().addAll(nuevos[i]);
        }

    }

    public void EnviaValores3(int [] numeros){
        int[] nuevos=Metodos.Shellsort(numeros);
        //System.out.print(Arrays.toString(nuevos));
        this.ListaLvw.getItems().clear();
        for(int i= 0; i < numeros.length; i++){
            this.ListaLvw.getItems().addAll(nuevos[i]);
            //Envia los valores a la lista

        }
        String.valueOf(nuevos);
        int des=numeros.length-1;
        for (int i= des-1; i>=0; i-- ){
            this.ListaLvw1.getItems().addAll(nuevos[i]);
        }
    }
    public void EnviaValores4(int [] numeros){
        int[] nuevos=MergeSort(numeros);

        //System.out.print(Arrays.toString(nuevos));
        this.ListaLvw.getItems().clear();
        for(int i= 0; i < numeros.length; i++){
            //Envia los valores a la lista
            this.ListaLvw.getItems().addAll(nuevos[i]);

        }
        String.valueOf(nuevos);
        int des=numeros.length-1;
        for (int i= des-1; i>=0; i-- ){
            this.ListaLvw1.getItems().addAll(nuevos[i]);
        }

    }

    public void ValoresAleatorios(int elementos){
        /*
        determinar la longitud del arreglo valores
         */

        valores = new int[elementos];
        for(int i= 0; i < valores.length; i++){
            valores[i] = (int)(Math.random()*50+1);

            //Envia los valores a la lista
            this.ListaLvw.getItems().addAll(valores[i]);
        }

    }



    public EventHandler numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[0-9.]")) {
                    if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                        e.consume();
                    } else if (txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                        e.consume();
                    }
                } else {
                    e.consume();
                }
            }

        };

    }
}
