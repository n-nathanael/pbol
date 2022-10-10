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
public class FXMLdisplayPesertaController implements Initializable {

    @FXML
    private TableView<pesertaModel> viewPeserta;
    @FXML
    private Button pesertaInsert;
    @FXML
    private Button pesertaUpdate;
    @FXML
    private Button pesertaDelete;
    @FXML
    private Button pesertaLast;
    @FXML
    private Button pesertaPrevious;
    @FXML
    private Button pesertaNext;
    @FXML
    private Button pesertaFirst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }    

    public void showdata(){
        ObservableList<pesertaModel> data=FXMLDocumentController.dtPeserta.Load();
        if(data!=null){            
            viewPeserta.getColumns().clear();            
            viewPeserta.getItems().clear();
            
            TableColumn col=new TableColumn("KODE");
            col.setCellValueFactory(new PropertyValueFactory<pesertaModel, String>("kodePeserta"));
            viewPeserta.getColumns().addAll(col);
            
            col=new TableColumn("NAMA");
            col.setCellValueFactory(new PropertyValueFactory<pesertaModel, String>("namaPeserta"));
            viewPeserta.getColumns().addAll(col);
            
            col=new TableColumn("JENIS KELAMIN");
            col.setCellValueFactory(new PropertyValueFactory<pesertaModel, String>("jkPeserta"));
            viewPeserta.getColumns().addAll(col);
            
            col=new TableColumn("ALAMAT");
            col.setCellValueFactory(new PropertyValueFactory<pesertaModel, String>("alamatPeserta"));
            viewPeserta.getColumns().addAll(col);
            
            col=new TableColumn("TELEPON");
            col.setCellValueFactory(new PropertyValueFactory<pesertaModel, String>("teleponPeserta"));
            viewPeserta.getColumns().addAll(col);
            
            viewPeserta.setItems(data);            
    }
        else {  
            Alert a=new Alert(Alert.AlertType.ERROR,"NO DATA",ButtonType.OK);
            a.showAndWait();
            viewPeserta.getScene().getWindow().hide();;
        }                
    }

    @FXML
    private void pesertaInsertClick(ActionEvent event) {
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
            stg.showAndWait();
        } 
            catch (IOException e){   
            e.printStackTrace();   }
            showdata();        
            pesertaFirstClick(event);
    }

    @FXML
    private void pesertaUpdateClick(ActionEvent event) {
        pesertaModel s = new pesertaModel();
        s=viewPeserta.getSelectionModel().getSelectedItem();
        try
        {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLinputPeserta.fxml"));    
        Parent root = (Parent)loader.load();
        FXMLinputPesertaController isidt=(FXMLinputPesertaController)loader.getController();
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
        pesertaFirstClick(event);
    }

    @FXML
    private void pesertaDeleteClick(ActionEvent event) {
        pesertaModel s = new pesertaModel();       
        s=viewPeserta.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"D E L E T E ?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtKelas.delete(s.getKodePeserta())){
               Alert b=new Alert(Alert.AlertType.INFORMATION,"D E L E T E D", ButtonType.OK);
               b.showAndWait();
           } else {
               Alert b=new Alert(Alert.AlertType.ERROR,"FA I L E D", ButtonType.OK);
               b.showAndWait();               
           }    
           showdata();           
           pesertaFirstClick(event);       
           }
    }

    @FXML
    private void pesertaLastClick(ActionEvent event) {
        viewPeserta.getSelectionModel().selectLast();        
        viewPeserta.requestFocus();
    }

    @FXML
    private void pesertaPreviousClick(ActionEvent event) {
        viewPeserta.getSelectionModel().selectAboveCell();       
        viewPeserta.requestFocus(); 
    }

    @FXML
    private void pesertaNextClick(ActionEvent event) {
        viewPeserta.getSelectionModel().selectBelowCell();        
        viewPeserta.requestFocus();
    }

    @FXML
    private void pesertaFirstClick(ActionEvent event) {
        viewPeserta.getSelectionModel().selectFirst();        
        viewPeserta.requestFocus(); 
    }
}
