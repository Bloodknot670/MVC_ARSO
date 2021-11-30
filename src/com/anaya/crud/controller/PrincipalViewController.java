package com.anaya.crud.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.anaya.crud.model.BO.UserModel;
import com.anaya.crud.model.BO.VMM.UserInternalConsult;
import com.anaya.crud.model.BO.VMM.UserPublicConsult;
import com.anaya.crud.model.BO.VMM.UserRegisterModel;
import com.anaya.crud.model.BO.VMM.UserUpdateModel;
import com.anaya.crud.utils.appservice.AppService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class PrincipalViewController implements Initializable{

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtUserN;
    @FXML private TextField txtCorreo;
    @FXML private DatePicker dPFechaNacimiento;
    
    
    @FXML private Button btnRegister;
    @FXML private Button btnUpdate;
    @FXML private Button btnIC;
    @FXML private Button btnPC;
    @FXML private Button btnAU;

    //* Tabla para mostrar registros
    @FXML private TableView<UserInternalConsult> tblRegistros;
    @FXML private TableColumn<UserInternalConsult, Integer> tbcId;
    @FXML private TableColumn<UserInternalConsult,String> tbcNombre;
    @FXML private TableColumn<UserInternalConsult,String> tbcUserName;
    @FXML private TableColumn<UserInternalConsult,String> tbcFecha;
    @FXML private TableColumn<UserInternalConsult,String> tbcCorreo;

    //* Tabla para mostrar registros
    @FXML private TableView<UserModel> tblARegistros;
    @FXML private TableColumn<UserModel, Integer> tbcAId;
    @FXML private TableColumn<UserModel,String> tbcANombre;
    @FXML private TableColumn<UserModel,String> tbcAUName;
    @FXML private TableColumn<UserModel,String> tbcAFech;
    @FXML private TableColumn<UserModel,String> tbcACorreo;

    //* Tabla consulta publica
    @FXML private TableView<UserPublicConsult> tblPC;
    @FXML private TableColumn<UserPublicConsult,Integer> tbcPId;
    @FXML private TableColumn<UserPublicConsult,String> tbcPUname;




    @FXML private void handleButtonActionR(ActionEvent event){
        String nombreU = txtNombre.getText();
        String userNU = txtUserN.getText();
        String correoU = txtCorreo.getText();
        String fechaNU = dPFechaNacimiento.getValue().toString();

        UserRegisterModel urm = new UserRegisterModel(nombreU,userNU,correoU,fechaNU);
        AppService as = new AppService();
        try {
            as.insertValidate(urm);            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
    }

    @FXML private void handleButtonActionU(ActionEvent event){
        int cipheru = Integer.parseInt(txtId.getText());
        String nickNameu = txtUserN.getText();
        String mailu = txtCorreo.getText();

        UserUpdateModel uum = new UserUpdateModel(cipheru, nickNameu, mailu);

        AppService as = new AppService();
        try {
            as.updateValidation(uum);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML private void handleButtonActionIC(ActionEvent event){
        int cipheru = Integer.parseInt(txtId.getText());
        UserInternalConsult ic = new UserInternalConsult();
        List<UserInternalConsult> icl = new ArrayList<>();
        ic.setUserCipher(cipheru);
        AppService as = new AppService();
        try {
            icl = as.internalConsultById(ic);  
            System.out.println(icl.get(0).getMailUser());          
            tbcId.setCellValueFactory(new PropertyValueFactory<>("userCipher"));
            tbcNombre.setCellValueFactory(new PropertyValueFactory<>("userName"));
            tbcUserName.setCellValueFactory(new PropertyValueFactory<>("nickName"));
            tbcFecha.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
            tbcCorreo.setCellValueFactory(new PropertyValueFactory<>("MailUser"));           
            ObservableList<UserInternalConsult> items = FXCollections.observableArrayList(icl);
            tblRegistros.setItems(items);            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML private void handleButtonActionPC(ActionEvent event){
        int cipheru = Integer.parseInt(txtId.getText());
        UserPublicConsult pc = new UserPublicConsult();
        List<UserPublicConsult> upl = new ArrayList<>();
        pc.setUserCipher(cipheru);
        AppService as = new AppService();
        try {            
            upl = as.publicConsultById(pc);
            tbcPId.setCellValueFactory(new PropertyValueFactory<>("UserCipher"));
            tbcPUname.setCellValueFactory(new PropertyValueFactory<>("nickName"));
            ObservableList<UserPublicConsult> items = FXCollections.observableArrayList(upl);
            tblPC.setItems(items);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @FXML private void handleButtonActionGC(ActionEvent event){
        List<UserModel> uml = new ArrayList<>();
        AppService as = new AppService();
        try {
            uml = as.allUsers();
            System.out.println(uml.get(0).getIdUsuario());
            tbcAId.setCellValueFactory(new PropertyValueFactory<>("IdUsuario"));
            tbcANombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            tbcAUName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
            tbcAFech.setCellValueFactory(new PropertyValueFactory<>("FechaNacimiento"));
            tbcACorreo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
            
            ObservableList<UserModel> items = FXCollections.observableArrayList(uml);
            tblARegistros.setItems(items);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub 
         
    }
    
}
