/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts.kursus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mypc
 */
public class FXMLDocumentController implements Initializable {
    
    public static dbPeserta dtPeserta = new dbPeserta();
    public static dbPengajar dtPengajar = new dbPengajar();
    public static dbKelas dtKelas = new dbKelas();
    
    @FXML
    private MenuItem masterPeserta;
    @FXML
    private MenuItem masterPengajar;
    @FXML
    private MenuItem masterKelas;
    @FXML
    private MenuItem inputPeserta;
    @FXML
    private MenuItem inputPengajar;
    @FXML
    private MenuItem inputKelas;
    @FXML
    private MenuItem helpAbout;
    @FXML
    private MenuItem helpClose;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void masterPesertaClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLdisplayPeserta.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void masterPengajarClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLdisplayPengajar.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void masterKelasClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLdisplayKelas.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void inputPesertaClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputPeserta.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void inputPengajarClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputPengajar.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void inputKelasClick(ActionEvent event) {
        try
        {  
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputKelas.fxml"));    
            Parent root = (Parent)loader.load();
            Scene scene = new Scene(root);
            Stage stg=new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();        
        } catch (IOException e){
            e.printStackTrace();   
        }
    }

    @FXML
    private void helpAboutClick(ActionEvent event) {
    }

    @FXML
    private void helpCloseClick(ActionEvent event) {
        System.exit(0);
    }
    
}
