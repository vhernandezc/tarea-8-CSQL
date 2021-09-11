/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.clsAlumno;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vh367
 */
public class clsAlumnoJDBC {
     
    Scanner t = new Scanner(System.in);//lee los datos que ingresamos
    Scanner j = new Scanner(System.in);
    Scanner j2 = new Scanner(System.in);
    String r;
    private static final String SQL_SELECT="select*from tb_alumnos";
    private static final String SQL_INSERT="insert into tb_alumnos(empleado, Enero,Febrero,Marzo) values(?,?,?,?)";
    private static final String SQL_UPDATE="update tb_alumnos set empleado=?,Enero=?,Febrero=?,Marzo=? where codigo=?";
    private static final String SQL_DELETE="DELETE FROM tb_alumnos WHERE codigo =?";

//seleccionar informacion
    public List<clsAlumno> seleccion(){
  Connection conn=null;
  PreparedStatement stmt=null; 
  ResultSet rs=null;
  clsAlumno alumno=null;
  
   List<clsAlumno>alumnos=new ArrayList<clsAlumno>();
  
  
        try {
            conn=ClsConexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery() ;
            
            while(rs.next()){
                int codigo=rs.getInt("codigo");
                String nombre= rs.getString("empleado");
                int nota1=rs.getInt("Enero");
                int nota2=rs.getInt("Febrero");
                int nota3=rs.getInt("Marzo");
                alumno=new clsAlumno(); 
                alumno.setCodigo(codigo);
                alumno.setEmpleado(nombre);
                alumno.setEnero(nota1);
                alumno.setFebrero(nota2);
                alumno.setMarzo(nota3);
                 alumnos.add(alumno);
            }
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
           
        }finally{
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return alumnos;
}
    
   
    
    //METODO PARA INSERTAR DATOS A LA TABLA
  public int insert(clsAlumno alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getEmpleado());
            stmt.setInt(2, alumno.getEnero());
            stmt.setInt(3, alumno.getFebrero());
            stmt.setInt(4, alumno.getMarzo());
         
            
            System.out.println("empleado agregado...");
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
      
 
        
        return rows;}
  
  //metodo para eliminar datos
  public int eliminar(clsAlumno empleado){
      Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getCodigo());//le decimos que va a recibir un parametro
            
            
            System.out.println("se eliminó el dato:" );
            rows = stmt.executeUpdate();
            System.out.println("error de eliminación:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);// cerramos conexiones
            ClsConexion.close(conn);
        }
        return rows;
  }
  
  //menu principal
 public void menu(){
          boolean salir = false;
        String opc = "";
        do{
            clsAlumnoJDBC alJDBC=new clsAlumnoJDBC();
            System.out.println("1- Insertar Informacion");
           
            System.out.println("2- Ver Informacion");
            System.out.println("3- eliminar información");
            System.out.println("4- salir");
            opc = t.nextLine();
            switch(opc){
               
                case "1":
               clsAlumno agregar=new clsAlumno();
               
                    System.out.println("ingrese empleado:");
                   r= j.nextLine();
                    agregar.setEmpleado(r);//agregamos el nombre en la columna empleado
                   
                    System.out.println("ingrese Enero");
                    r=j.nextLine();
                    agregar.setEnero(Integer.parseInt(r));
                   
                    System.out.println("ingrese Febrero");
                    r=j.nextLine();
                    agregar.setFebrero(Integer.parseInt(r));
                    
                    System.out.println("ingrese Marzo");
                    r=j.nextLine();
                    agregar.setMarzo(Integer.parseInt(r));
                    alJDBC.insert(agregar);
                   
             
                 
                break;
                case "2":  List<clsAlumno>todos=alJDBC.seleccion();//declaramos una lista para mostrar datos
     
     for (clsAlumno alumno:todos){
         System.out.println("alumnos"+alumno);//alumno va a llevar todos los datos de la tabla
     }
                break;    
                
                
                case "3":   clsAlumno quitar=new clsAlumno();
                             
                    System.out.println("ingrese codigo a eliminar:");
                   r= j2.nextLine();
                  
                    quitar.setCodigo(Integer.parseInt(r));//mandamos comomparametro el codigo ingresado
                    alJDBC.eliminar(quitar);
                           break;
               
               
            
            case "4": salir=true;//terminamos la ejecución
                      
                
            break;}
        }while(!salir);
    }
}