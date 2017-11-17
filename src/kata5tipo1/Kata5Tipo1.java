/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5tipo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.DoubleStream;

/**
 *
 * @author Luis Pérez
 */
public class Kata5Tipo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        
        
        Class.forName("org.sqlite.JDBC");
        
        Connection con= DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        
        Statement st= con.createStatement();    
        String query ="Select * FROM PEOPLE";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
           //System.out.println(rs.getInt(1));
           // System.out.println(rs.getInt(2));
        }
         
            
        query = " Create table if not exists mail ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Mail' Text Not null);";
        st.execute(query);

        
        BufferedReader br = new BufferedReader(new FileReader(new File("mail.txt")));
        String linea;
            //System.out.println(linea);
            while((linea=br.readLine())!=null){
                if(!linea.contains("@")){
                    continue;
                }
                //System.out.println(linea);
                query = "insert into mail (Mail) Values ('" + linea +"');";
                st.executeUpdate(query);
            }
            
            
            query= "Select count(*) from mail";
            System.out.println(st.executeQuery(query).getInt(1));
    }
    
}
//