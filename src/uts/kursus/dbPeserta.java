/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.kursus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mypc
 */
public class dbPeserta {
    
    private pesertaModel  dt = new pesertaModel();    
    public pesertaModel getPesertaModel(){ 
        return(dt);
    }
    public void setPesertaModel(pesertaModel s){ 
        dt = s;
    }
    
    public ObservableList<pesertaModel>  Load() {
        try {
            ObservableList<pesertaModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodePeserta, namaPeserta, jkPeserta, alamatPeserta, teleponPeserta from peserta");
            int i = 1;
            while (rs.next()) {
                pesertaModel d = new pesertaModel();
                
                d.setKodePeserta(rs.getString("kodePeserta"));                
                d.setNamaPeserta(rs.getString("namaPeserta"));        
                d.setJkPeserta(rs.getString("jkPeserta"));
                d.setAlamatPeserta(rs.getString("alamatPeserta"));
                d.setTeleponPeserta(rs.getString("teleponPeserta"));  
                
                tableData.add(d);                
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
        }
    }
    public int validasi(String nomor) {
        int val = 0;
        try {         
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from peserta where kodePeserta = '" + nomor + "'");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
    
    public boolean insert() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {       
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into peserta (kodePeserta ,namaPeserta, jkPeserta, alamatPeserta, teleponPeserta) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getPesertaModel().getKodePeserta());           
            con.preparedStatement.setString(2, getPesertaModel().getNamaPeserta());
            con.preparedStatement.setString(3, getPesertaModel().getJkPeserta()); 
            con.preparedStatement.setString(4, getPesertaModel().getAlamatPeserta());   
            con.preparedStatement.setString(5, getPesertaModel().getTeleponPeserta()); 
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }  
    }
    public boolean delete(String nomor) {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from peserta where kodePeserta  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }
    public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update peserta set namaPeserta = ?, jkPeserta = ?, alamatPeserta = ?, teleponPeserta = ? where  kodePeserta = ? ");
            con.preparedStatement.setString(1, getPesertaModel().getKodePeserta());           
            con.preparedStatement.setString(2, getPesertaModel().getNamaPeserta());
            con.preparedStatement.setString(3, getPesertaModel().getJkPeserta()); 
            con.preparedStatement.setString(4, getPesertaModel().getAlamatPeserta());   
            con.preparedStatement.setString(4, getPesertaModel().getTeleponPeserta()); 
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
    }
    public ObservableList<pesertaModel>  cariPeserta(String namaPeserta) {
        try {    
            ObservableList<pesertaModel> 	tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from peserta WHERE namaPeserta LIKE '" + namaPeserta + "%'");
        int i = 1;
        while(rs.next()){
            pesertaModel d = new pesertaModel();
            d.setKodePeserta(rs.getString("kodePeserta"));
            d.setNamaPeserta(rs.getString("namaPeserta"));
            d.setJkPeserta(rs.getString("jkPeserta"));
            d.setAlamatPeserta(rs.getString("alamatPeserta"));
            d.setTeleponPeserta(rs.getString("teleponPeserta"));
            tableData.add(d);
            i++;
        }
        con.tutupKoneksi();
        return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
