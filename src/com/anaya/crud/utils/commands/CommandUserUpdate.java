package com.anaya.crud.utils.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anaya.crud.model.BO.UserModel;
import com.anaya.crud.model.DAO.Conexion;

public class CommandUserUpdate {
    public String validateUser(int idUserP) throws Exception{
        //Query que nos regresara los usuarios registrados
        String query = "SELECT * FROM usuario WHERE id=" +idUserP;

        //Abrir conexion de mysql
        Conexion conn = new Conexion();
        Connection conne = conn.openConnection();

        //Obtenemos los registros
        PreparedStatement pst = conne.prepareStatement(query);

        //Se ejecuta la consulta y se obtiene el ResultSet
        ResultSet rset = pst.executeQuery();  
        
        List<UserModel> users = new ArrayList<>();
        while (rset.next()){
            UserModel u = new UserModel();
            
            u.setIdUsuario(rset.getInt("id"));
            u.setNombre(rset.getString("nombre"));
            u.setUserName(rset.getString("userNamer"));
            u.setFechaNacimiento(rset.getString("fechaNacimiento"));
            u.setCorreo(rset.getString("correo"));
            
            users.add(u);
        }

        if(users.size()>0){
            return "OK";
        }else{
            return "No existe el usuario";
        }
    }
}
