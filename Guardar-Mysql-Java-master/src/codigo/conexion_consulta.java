/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.StringTokenizer;
/**
 *
 * @author alexander
 */
public class conexion_consulta {
    static Connection conexion=null;
    static Statement sentencia;
    public static void conectar(){
    String ruta="jdbc:mysql://localhost:3306/pruebacoopc";
        String user="root";
        String pass="alcatel";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
    }
    public static void guardar(variables x){
        String q = "INSERT INTO productos VALUES('"+x.getTipoProducto()+"','"+x.getProducto()+"','"+x.getNombreProducto()+"','"+x.getSaldo()+"')";
        ejecutar(q);
    }

    
    
        public static void leer()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File ("/home/lucas/Documentos/archivoLucasdos.txt");
                fr = new FileReader (archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero
                System.out.println("Leyendo el contendio del archivo.txt");
                String linea;
                while((linea=br.readLine())!=null){
                    int contador = 3;
                    String separador= "{";
                    
                    while (linea.indexOf(separador) > -1) {
	            linea = linea.substring(linea.indexOf(
	            separador)+separador.length(),linea.length());
	            contador--; 
                    System.out.println("Reglon completo "+linea);
                    verifica(linea);
                    }
                      
                    if(contador>0 && contador!=3){
                      errorLinea(linea);
                    }
                }                      
                                
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
    }
    
    public static void verifica(String linea){
                
        System.out.println("Separando el contenido");  
        //System.out.println(linea);
        
        StringTokenizer st = new StringTokenizer(linea, "{");
     while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
        
     }            
   
    }

public static void errorLinea(String linea){
                
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	fichero = new FileWriter("/home/lucas/Documentos/rarchivoLucas.txt");
           	pw = new PrintWriter(fichero);
 
           	System.out.println("Escribiendo de error.txt");
           	for (int i = 0; i < 10; i++)
        	   pw.println("E01 " + i);
                   pw.println("Campo no puede ser vacio ");
                
 
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
    			// Nuevamente aprovechamos el finally para 
        		// asegurarnos que se cierra el fichero.
        		if (null != fichero)
        			fichero.close();
        	} catch (Exception e2) {
        		e2.printStackTrace();
        	}
        }   
    
    }

    
    public static void ejecutar(String q){
        try {
            sentencia.executeUpdate(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
  
}
