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
        ArrayList<employees> empleados = new ArrayList<>();
        
        try{
            //en lugar de usar prepared statement que utilizamos en sql, uso de BuferedReader,
            //misma funcion pero con csv
            BufferedReader lee = new BufferedReader(new FileReader(ubicacion));
            String registro;
            int cont =0; // el primer registro (0), es el nombre de cada columna. 
            while((registro = lee.readLine()) != null){
                if(cont > 0){ // mientras no sea la primera linea lo procesa
                    String[] lista = registro.split(",");
                    
                    int employee_id = Integer.parseInt(lista[0].trim());
                    String first_name = lista[1].trim();
                    String last_name = lista[2].trim();
                    String department_id = lista[3].trim();
                    
                    empleados.add(new employees(employee_id, first_name, last_name, department_id));
                }
                cont++;
            }
            lee.close();
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        return empleados;
    }
}