/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author Andrei
 */
public class csvReader {
    public static ArrayList<employees> leerEmpleados(String ubicacion){
        //al pulsar el boton cargar datos, se introduce la ubicacion del csv, y con este metodo, imprime una lista dentro de Jlist
        ArrayList<employees> empleados = new ArrayList<>(); //lista donde se guardan los registros
        
        try{
            //en lugar de usar prepared statement que utilizamos en sql, uso de BuferedReader,
            //misma funcion pero con csv
            BufferedReader lee = new BufferedReader(new FileReader(ubicacion));
            String registro; //almacena los registros
            int cont =0; // identifica los registros. El primer registro (0), es el nombre de cada columna. 
            while((registro = lee.readLine()) != null){ // lee hasta que no hayan mas lineas ( hasta que sea null)
                if(cont > 0){ // mientras no sea la primera linea lo procesa
                    String[] lista = registro.split(","); // array de datos, con separacion entre datos por ,
                    
                    int employee_id = Integer.parseInt(lista[0].trim());
                    //valor primero de esa linea, parseo lista de String a int, para almacentar id que es un int
                    
                    String first_name = lista[1].trim();// valor segundo, String ambos, no uso de parseo, y se quitan espacios
                    String last_name = lista[2].trim(); // valor tercero, String ambos, no uso de parseo, y se quitan espacios
                    String department_id = lista[3].trim(); // valor cuarto, String ambos, no uso de parseo, y se quitan espacios
                    
                    //creacion de un nuevo objeto con los datos y se añade a la lista
                    empleados.add(new employees(employee_id, first_name, last_name, department_id));
                }
                cont++; //incrementa para saltar 
            }
        }catch (Exception ex){
            System.out.println(ex); //en caso de excepcion, se lanza en la terminal
        }
        return empleados; //devuelve la lista con todos los empleados leidos
    }
}