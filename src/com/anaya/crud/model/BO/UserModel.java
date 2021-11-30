package com.anaya.crud.model.BO;

public class UserModel {
    private int idUsuario;
    private String nombre;
    private String userName;
    private String fechaNacimiento;
    private String correo;

    //* Constructores
    public UserModel() {

    }
    public UserModel(int idUsuario, String nombre, String userName, String fechaNacimiento,String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.userName = userName;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    //* Getters n Setters
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String getCorreo(){
        return this.correo;
    }
}
