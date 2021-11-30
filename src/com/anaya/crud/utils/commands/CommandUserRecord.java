package com.anaya.crud.utils.commands;

import java.util.Calendar;

public class CommandUserRecord {

    public String validateRecord(String nombre, String correo, String fecha){
        if((nombre.length()<=100)&&(correo.length()<=100)&&(validarEdad(fecha)>=18)){
            return "OK";
        }else{
            return "revisa los campos";
        } 
    }

    public int validarEdad(String fecha){
        Calendar cal = Calendar.getInstance();
        int annioActual = cal.get(Calendar.YEAR);

        int annioComparar = Integer.parseInt(fecha.substring(0,4));

        int edad = annioActual - annioComparar;

        return edad;
    }
}
