/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5tipo1;

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
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        
        Class.forName("org.sqlite.JDBC");
        
        Connection con= DriverManager.getConnection("jdbc:sqlite:KATA5.db");
        
        Statement st= con.createStatement();    
        String query ="Select * FROM PEOPLE";
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getInt(2));
        }
    }
    
}
