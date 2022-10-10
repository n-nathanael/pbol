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
public class FXMLdisplayKelasController implements Initializable {

    @FXML
    private TableView<kelasModel> viewKelas;
    @FXML
    private Button kelasInsert;
    @FXML
    private Button kelasUpdate;
    @FXML
    private Button kelasDelete;
    @FXML
    private Button kelasLast;
    @FXML
    private Button kelasPrevious;
    @FXML
    private Button kelasNext;
    @FXML
    private Button kelasFirst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }    
    
    public void showdata(){
        ObservableList<kelasModel> data=FXMLDocumentController.dtKelas.Load();
        if(data!=null){            
            viewKelas.getColumns().clear();            
            viewKelas.getItems().clear();
            
            TableColumn col=new TableColumn("KODE");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("kodeKelas"));
            viewKelas.getColumns().addAll(col);
            
            col=new TableColumn("NAMA");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("namaKelas"));
            viewKelas.getColumns().addAll(col);
            
            col=new TableColumn("KATEGORI");
            col.setCellValueFactory(new PropertyValueFactory<pengajarModel, String>("kategoriKelas"));
            viewKelas.getColumns().addAll(col);
            
            viewKelas.setItems(data);
    }
        else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            viewKelas.getScene().getWindow().hide();;
        }                
    }

    @FXML
    private void kelasInsertClick(ActionEvent event) {
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
            stg.showAndWait();
        } 
            catch (IOException e){   
            e.printStackTrace();   }
            showdata();        
            kelasFirstClick(event);
    }

    @FXML
    private void kelasUpdateClick(ActionEvent event) {
        kelasModel s = new kelasModel();
        s=viewKelas.getSelectionModel().getSelectedItem();
        try
        {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputKelas.fxml"));    
        Parent root = (Parent)loader.load();
        FXMLinputKelasController isidt=(FXMLinputKelasController)loader.getController();
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
        kelasFirstClick(event);
    }

    @FXML
    private void kelasDeleteClick(ActionEvent event) {
        kelasModel s = new kelasModel();       
        s=viewKelas.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"D E L E T E ?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtKelas.delete(s.getKodeKelas())){
               Alert b=new Alert(Alert.AlertType.INFORMATION,"D E L E T E D", ButtonType.OK);
               b.showAndWait();
           } else {
               Alert b=new Alert(Alert.AlertType.ERROR,"FA I L E D", ButtonType.OK);
               b.showAndWait();               
           }    
           showdata();           
           kelasFirstClick(event);       
           }
    }

    @FXML
    private void kelasLastClick(ActionEvent event) {
        viewKelas.getSelectionModel().selectLast();        
        viewKelas.requestFocus();
    }

    @FXML
    private void kelasPreviousClick(ActionEvent event) {
        viewKelas.getSelectionModel().selectAboveCell();       
        viewKelas.requestFocus(); 
    }

    @FXML
    private void kelasNextClick(ActionEvent event) {
        viewKelas.getSelectionModel().selectBelowCell();        
        viewKelas.requestFocus();
    }

    @FXML
    private void kelasFirstClick(ActionEvent event) {
        viewKelas.getSelectionModel().selectFirst();        
        viewKelas.requestFocus(); 
    }
    
}
