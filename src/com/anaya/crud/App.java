package com.anaya.crud;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application{
    
    


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/principalView.fxml"));

        Scene escena = new Scene(root);

        primaryStage.setScene(escena);
        primaryStage.show();
        
    }

    public static void main(String[] args)  {


        launch(args);
        /*try{
            UserModel mod = new UserModel(1, "Isaac", "Elliot", "2000-03-12","3.anaya@gmail.com");
            //mod.insertUser(mod);
            //mod.updateUser(1,"Muelas","Pistolas", "2000-02-11","edmaverick@gmail.com");
            mod.deleteUser(1);
            mod.undoDelete(1);
        
        } catch (Exception e) {
            e.printStackTrace();*/
        }
}

