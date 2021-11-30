package com.anaya.crud.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.anaya.crud.model.BO.UserModel;


public class ClientDAO {

    //* CRUD methods
    
    public void insertUser(UserModel user) throws Exception{

        Conexion conn = new Conexion();
        Connection conne = conn.openConnection();
        String query = "INSERT INTO usuario (nombre,userNamer,fechaNacimiento,correo)"
        + "VALUES (?,?,?,?)";

        PreparedStatement pst = conne.prepareStatement(query);

        pst.setString(1, user.getNombre());
        pst.setString(2, user.getUserName());
        pst.setString(3,user.getFechaNacimiento());
        pst.setString(4, user.getCorreo());

        pst.execute();
    }

    public List <UserModel> getUser() throws Exception{
        //Query que nos regresara los usuarios registrados
        String query = "SELECT * FROM usuario";

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

        return users;
    }

    public List <UserModel> getUserByID(int idUserP) throws Exception{
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

        return users;
    }

    public void updateUser(int idUserP,String userNameP, String correoP) throws Exception{
        //Query de actualización
        String query = "UPDATE usuario SET userNamer = '"+ userNameP +"', correo= '"+ correoP + "' WHERE id = "+ idUserP;
        
        //Se obtine la conexion a la base de datos
        Conexion conn = new Conexion();
        Connection conne = conn.openConnection();

        Statement st = conne.createStatement();

        st.executeUpdate(query);   
    }

    public void deleteUser(int idUserP) throws Exception{
        //Query de actualizacion del campo activo
        String query = "UPDATE usuario SET activo = 0 WHERE id="+idUserP;

        //Se obtiene la conexion a base de datos
        Conexion conn = new Conexion();
        Connection conne = conn.openConnection();

        Statement st = conne.createStatement();

        st.executeUpdate(query);
    }

    public void undoDelete(int idUserP) throws Exception {
         //Query de actualizacion del campo activo
         String query = "UPDATE usuario SET activo = 1 WHERE id="+idUserP;

         //Se obtiene la conexion a base de datos
         Conexion conn = new Conexion();
         Connection conne = conn.openConnection();
 
         Statement st = conne.createStatement();
 
         st.executeUpdate(query);
    }
}
