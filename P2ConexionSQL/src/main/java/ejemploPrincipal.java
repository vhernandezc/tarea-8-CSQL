
import datos.clsAlumnoJDBC;
import dominio.clsAlumno;
import java.sql.*;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vh367
 */
public class ejemploPrincipal {
    
    
    public static void main(String[]args){
        
        clsAlumnoJDBC menu=new clsAlumnoJDBC();
        menu.menu();
     
             
    }
}
