/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts.kursus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mypc
 */
public class FXMLdisplayPengajarController implements Initializable {

    @FXML
    private TableView<pengajarModel> viewPengajar;
    @FXML
    private Button pengajarFirst;
    @FXML
    private Button pengajarNext;
    @FXML
    private Button pengajarPrevious;
    @FXML
    private Button pengajarLast;
    @FXML
    private Button pengajarDelete;
    @FXML
    private Button pengajarUpdate;
    @FXML
    private Button pengajarInsert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }    
    
    public void showdata(){
        ObservableList<pengajarModel> data=FXMLDocumentController.dtPengajar.Load();
        if(data!=null){            
            viewPengajar.getColumns().clear();            
            viewPengajar.getItems().clear();
            
            TableColumn col=new TableColumn("KODE");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("kodePengajar"));
            viewPengajar.getColumns().addAll(col);
            
            col=new TableColumn("NAMA");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("namaPengajar"));
            viewPengajar.getColumns().addAll(col);
            
            col=new TableColumn("JENIS KELAMIN");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("jkPengajar"));
            viewPengajar.getColumns().addAll(col);
            
            col=new TableColumn("ALAMAT");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("alamatPengajar"));
            viewPengajar.getColumns().addAll(col);
            
            col=new TableColumn("TELEPON");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("teleponPengajar"));
            viewPengajar.getColumns().addAll(col);
            
            viewPengajar.setItems(data);
    }
        else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            viewPengajar.getScene().getWindow().hide();;
        }                
    }   

    @FXML
    private void pengajarFirstClick(ActionEvent event) {
        viewPengajar.getSelectionModel().selectFirst();        
        viewPengajar.requestFocus(); 
    }

    @FXML
    private void pengajarNextClick(ActionEvent event) {
        viewPengajar.getSelectionModel().selectBelowCell();        
        viewPengajar.requestFocus();
    }

    @FXML
    private void pengajarPreviousClick(ActionEvent event) {
        viewPengajar.getSelectionModel().selectAboveCell();       
        viewPengajar.requestFocus(); 
    }

    @FXML
    private void pengajarLastClick(ActionEvent event) {
        viewPengajar.getSelectionModel().selectLast();        
        viewPengajar.requestFocus();
    }

    @FXML
    private void pengajarDeleteClick(ActionEvent event) {
        pengajarModel s = new pengajarModel();       
        s=viewPengajar.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"D E L E T E ?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtKelas.delete(s.getKodePengajar())){
               Alert b=new Alert(Alert.AlertType.INFORMATION,"D E L E T E D", ButtonType.OK);
               b.showAndWait();
           } else {
               Alert b=new Alert(Alert.AlertType.ERROR,"FA I L E D", ButtonType.OK);
               b.showAndWait();               
           }    
           showdata();           
           pengajarFirstClick(event);       
           }
    }

    @FXML
    private void pengajarUpdateClick(ActionEvent event) {
        pengajarModel s = new pengajarModel();
        s=viewPengajar.getSelectionModel().getSelectedItem();
        try
        {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputPengajar.fxml"));    
        Parent root = (Parent)loader.load();
        FXMLinputPengajarController isidt=(FXMLinputPengajarController)loader.getController();
        isidt.execute(s);                
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.showAndWait();
        } catch (IOException e){   e.printStackTrace();   }
        showdata();  
        pengajarFirstClick(event);
    }

    @FXML
    private void pengajarInsertClick(ActionEvent event) {
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
            stg.showAndWait();
        } 
            catch (IOException e){   
            e.printStackTrace();   }
            showdata();        
            pengajarFirstClick(event);
    }
}
