/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entities.HoaDon;
import Tools.DatabaseToList;
import Tools.WriteDataToDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoaDonDAL {
    public static ArrayList<HoaDon> show() throws SQLException{
        try{
            ArrayList<HoaDon> a = new ArrayList<HoaDon>();
            a = DatabaseToList.Doc_HoaDon_Tu_CSDL();
            return a;
        }
        catch(SQLException e){
            return null;
        }
    }
    
    public static int getSoLuong() throws SQLException{
        try{
            ArrayList<HoaDon> a = DatabaseToList.Doc_HoaDon_Tu_CSDL();
            return a.size(); 
        }
        catch(SQLException e){
            e.printStackTrace();
            return 0;
        }     
    }
    
    public static void insert(ArrayList<HoaDon> list, HoaDon a) throws SQLException{
        
        list.add(a);
        WriteDataToDatabase.ghi_HoaDon_Vao_CSDL(a);
    }
    
    
    public static boolean delete(ArrayList<HoaDon> list, HoaDon a) throws SQLException{
        int index = -1;
        for(int i=0;i<list.size();i++)
            if(a.getMaHD().equals(list.get(i).getMaHD())){
                index = i;
            }
        if(index!=-1){
            list.remove(index);
            WriteDataToDatabase.ghi_HoaDon_Vao_CSDL(a);
            return true;
        }
        else
        return false;
    }
}
