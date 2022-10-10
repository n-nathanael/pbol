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
public class dbKelas {
    
    private kelasModel  dt = new kelasModel();    
    public kelasModel getKelasModel(){ 
        return(dt);
    }
    public void setKelasModel(kelasModel s){ 
        dt = s;
    }
    
    public ObservableList<kelasModel>  Load() {
        try {
            ObservableList<kelasModel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodeKelas, namaKelas, kategoriKelas from kelas");
            int i = 1;
            while (rs.next()) {
                kelasModel d = new kelasModel();
                
                d.setKodeKelas(rs.getString("kodeKelas"));                
                d.setNamaKelas(rs.getString("namaKelas"));        
                d.setKategoriKelas(rs.getString("kategoriKelas"));
                
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
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from kelas where kodeKelas = '" + nomor + "'");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into kelas (kodeKelas ,namaKelas, kategoriKelas) values (?,?,?)");
            con.preparedStatement.setString(1, getKelasModel().getKodeKelas());           
            con.preparedStatement.setString(2, getKelasModel().getNamaKelas());
            con.preparedStatement.setString(3, getKelasModel().getKategoriKelas()); 
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from kelas where kodeKelas  = ? ");
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("update kelas set namaKelas = ?, kategoriKelas = ?");
            con.preparedStatement.setString(1, getKelasModel().getKodeKelas());           
            con.preparedStatement.setString(2, getKelasModel().getNamaKelas());
            con.preparedStatement.setString(3, getKelasModel().getKategoriKelas());  
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
    public ObservableList<kelasModel>  cariKelas(String namaKelas) {
        try {    
            ObservableList<kelasModel> 	tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select * from kelas WHERE namaKelas LIKE '" + namaKelas + "%'");
        int i = 1;
        while(rs.next()){
            kelasModel d = new kelasModel();
            d.setKodeKelas(rs.getString("kodeKelas"));
            d.setNamaKelas(rs.getString("namaKelas"));
            d.setKategoriKelas(rs.getString("kategoriKelas"));
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
