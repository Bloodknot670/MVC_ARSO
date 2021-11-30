package com.anaya.crud.utils.appservice;

import java.util.ArrayList;
import java.util.List;

import com.anaya.crud.model.BO.UserModel;
import com.anaya.crud.model.BO.VMM.UserInternalConsult;
import com.anaya.crud.model.BO.VMM.UserPublicConsult;
import com.anaya.crud.model.BO.VMM.UserRegisterModel;
import com.anaya.crud.model.BO.VMM.UserUpdateModel;
import com.anaya.crud.utils.commands.CommandHandler;

public class AppService {

    public void insertValidate(UserRegisterModel urm) throws Exception{
        CommandHandler ch = new CommandHandler();
        
            ch.insertUserValidation(urm);
        
    }

    public void updateValidation(UserUpdateModel urm) throws Exception{
        CommandHandler cu = new CommandHandler();
        cu.updateUserValidation(urm);
    }

    public List<UserPublicConsult> publicConsultById(UserPublicConsult cons) throws Exception{
        List<UserPublicConsult> listaImprimir = new ArrayList<>();
        CommandHandler ch = new CommandHandler();
        listaImprimir = ch.publicConsult(cons.getUserCipher());
        return listaImprimir;
    }

    public List<UserInternalConsult> internalConsultById(UserInternalConsult cons) throws Exception{
        List<UserInternalConsult> listaImprimir = new ArrayList<>();
        CommandHandler ch = new CommandHandler();
        listaImprimir = ch.internalConsult(cons.getUserCipher());
        return listaImprimir;
    }

    public List<UserModel> allUsers() throws Exception{
        List<UserModel> listaImprimir = new ArrayList<>();
        CommandHandler ch = new CommandHandler();
        listaImprimir = ch.allUsersConsult();
        return listaImprimir;
    }

}
