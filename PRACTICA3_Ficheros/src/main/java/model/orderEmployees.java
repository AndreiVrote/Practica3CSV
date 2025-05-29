/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class orderEmployees {
    /*
    clase para las diferentes ordenaciones
    Collections para uso de sort para ordenacion junto con
    el uso de 'compare' para comparar su valor segun el caso
    en caso de algun valor null, como pasa con el empleado 178, en la ordenacion por department_id
    aparece el primero
    */
    //metodo para ordenar por Id del empleado, de forma ascendente
    
    public static void OrdenPorId (ArrayList<employees> lista){
        Collections.sort(lista, new Comparator<employees>() {
             
            @Override
            public int compare(employees emp1, employees emp2){
                return Integer.compare(emp1.getEmployee_id(), emp2.getEmployee_id());
            }
        });
    }
    
    //metodo para ordenar por apellido por orden alfabetico.
    //uso de compareToIgnoreCase para evitar problemas de mayusculas y minusculas (las ignora)
    
    public static void OrdenPorApellido(ArrayList<employees> lista){
        Collections.sort(lista, new  Comparator<employees>(){
                @Override
                public int compare (employees emp1, employees emp2){
                    return emp1.getLast_name().compareToIgnoreCase(emp2.getLast_name());
                }
        });
    }
    
    /*
    metodo para ordenar por departamento
    uso de compareToIgnoreCase para evitar problemas de mayusculas y minusculas (las ignora)
    aunque sean datos numericos debido a un null en departamento, se usa String para que salgan todos,
    si fuese int, llegaria hasta el null, 178 y no imprime el resto (total de 206)
    */
    
    public static void OrdenPorDepartamento(ArrayList<employees> lista){
        Collections.sort(lista, new Comparator<employees>(){
            
            @Override
            public int compare(employees emp1, employees emp2){
                return emp1.getDepartment_id().compareToIgnoreCase(emp2.getDepartment_id());
            }
        });
    }
}
