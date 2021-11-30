package com.anaya.crud.utils.commands;

import java.util.ArrayList;
import java.util.List;

import com.anaya.crud.model.BO.UserModel;
import com.anaya.crud.model.BO.VMM.UserInternalConsult;
import com.anaya.crud.model.BO.VMM.UserPublicConsult;
import com.anaya.crud.model.BO.VMM.UserRegisterModel;
import com.anaya.crud.model.BO.VMM.UserUpdateModel;
import com.anaya.crud.model.DAO.ClientDAO;

public class CommandHandler {

    public void insertUserValidation(UserRegisterModel urm) throws Exception{    
        CommandUserRecord cur = new CommandUserRecord();
        if(cur.validateRecord(urm.getNameUser(), urm.getMailUser(), urm.getBirthDate()).equals("OK")){
            ClientDAO cd = new ClientDAO();
            UserModel um = new UserModel(0, urm.getNameUser(), urm.getNickName(),urm.getBirthDate(),urm.getMailUser());
            
            cd.insertUser(um);
            
        }
    }
    
    public void updateUserValidation(UserUpdateModel urm) throws Exception{
        CommandUserUpdate cuu = new CommandUserUpdate();
        if(cuu.validateUser(urm.getUserCipher()).equals("OK")){
            ClientDAO cd = new ClientDAO();
            UserModel um = new UserModel();
            um.setIdUsuario(urm.getUserCipher());
            um.setUserName(urm.getNickName());
            um.setCorreo(urm.getMailUser());
            cd.updateUser(um.getIdUsuario(),um.getUserName(),um.getCorreo());
            
        }
    }

    public List<UserPublicConsult> publicConsult(int userCipher) throws Exception{
        List<UserPublicConsult> listUser = new ArrayList<>();
        List<UserModel> listaConsulta = new ArrayList<>();
        ClientDAO cd = new ClientDAO();
        listaConsulta = cd.getUserByID(userCipher);
        for (int i = 0; i < listaConsulta.size(); i++) {
            UserPublicConsult upc = new UserPublicConsult();
            upc.setUserCipher(listaConsulta.get(i).getIdUsuario());
            upc.setNickName(listaConsulta.get(i).getUserName());

            //* Agrega el objeto del modelo de consulta publica al ArrayList
            listUser.add(upc);
        }

        //*Regresa la lista de tipo UserPublicConsult
        return listUser;
    }

    public List<UserInternalConsult> internalConsult(int userCipher) throws Exception{
        List<UserInternalConsult> listUser = new ArrayList<>();
        List<UserModel> listaConsulta = new ArrayList<>();
        ClientDAO cd = new ClientDAO();
        listaConsulta = cd.getUserByID(userCipher);
        for (int i = 0; i < listaConsulta.size(); i++) {
            UserInternalConsult uic = new UserInternalConsult();
            uic.setUserCipher(listaConsulta.get(i).getIdUsuario());
            uic.setUserName(listaConsulta.get(i).getNombre());
            uic.setNickName(listaConsulta.get(i).getUserName());
            uic.setBirthDate(listaConsulta.get(i).getFechaNacimiento());
            uic.setMailUser(listaConsulta.get(i).getCorreo());

            //* Agrega el objeto del modelo de consulta publica al ArrayList
            listUser.add(uic);
        }

        //*Regresa la lista de tipo UserPublicConsult
        return listUser;
    }

    public List<UserModel> allUsersConsult() throws Exception{
        List<UserModel> listUser = new ArrayList<>();
        //sList<UserModel> listaReturn = new ArrayList<>();
        ClientDAO cd = new ClientDAO();
        listUser = cd.getUser();
        return listUser;
       /* for(int i=0; i < listUser.size(); i++){
            UserModel um = new UserModel();
            um.setIdUsuario(listUser.get(i).getIdUsuario());
            um.setNombre(listUser.get(i).getNombre());
            um.setUserName(listUser.get(i).getUserName());
            um.setFechaNacimiento(listUser.get(i).getFechaNacimiento());
            um.setCorreo(listUser.get(i).getCorreo());
            
            listaReturn.add(um);
        }*/
    }
}
