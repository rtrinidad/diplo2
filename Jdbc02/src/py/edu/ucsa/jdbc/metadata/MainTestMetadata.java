package py.edu.ucsa.jdbc.metadata;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import py.edu.ucsa.jdbc.connectivity.ManejadorConexiones;

/**
 *
 * @author JonathanMelgoza
 */
public class MainTestMetadata {
  
	
    static DatabaseMetaData metadatos;
    static ResultSetMetaData rsmetadatos;
    
    public static void main(String args[]){
        try {
        	
        	Connection conexion = ManejadorConexiones.obtenerConexionPG();
        	
        	Statement st = conexion.createStatement() ;
                      
            /*DatabaseMetaData
             * Obteniendo Informacion sobre una base de datos
            */
            System.out.println("Obteniendo Informacion sobre una base de datos");
            metadatos = conexion.getMetaData();
            //Nombre de producto
            System.out.println("Nombre de Producto: "+metadatos.getDatabaseProductName());
            //Version de producto
            System.out.println("Version de Producto: "+metadatos.getDatabaseProductVersion());
            //Nombre de driver
            System.out.println("Nombre de Driver: "+metadatos.getDriverName());
            //Version de driver
            System.out.println("Version de Driver: "+metadatos.getDriverVersion());
            //Tablas
            ResultSet rst;
            ResultSet rsc;
            String[] filtro = {"TABLE"};
            rst = metadatos.getTables(null,"public",null,filtro);
            String tabla="";
            while(rst.next()){
                tabla = rst.getObject(3).toString();
                System.out.println("Nombre de Tabla: "+tabla);
                System.out.println("Nombre del Esquema: "+ rst.getString("TABLE_SCHEM"));
                //primary key si existe
                ResultSet rsp = metadatos.getPrimaryKeys(null, null, tabla);
                if(rsp.next())
                    System.out.println("Primary Key: "+rsp.getObject(4));
                rsp.close();
                //columnas y tipos
                rsc = metadatos.getColumns(null, null, tabla, null);
                while(rsc.next()){
                    System.out.println("    Columna: "+rsc.getString(4));
                    System.out.println("    Tipo: "+rsc.getInt(5));
                    System.out.println("     -------------");
                }
                rsc.close();
            }
            rst.close();
            
            /*ResultSetMetaData
             * Obteniendo Informacion sobre una consulta con un ResultSet
            */
            System.out.println("\nObteniendo Informacion sobre una consulta con un ResultSet");
            ResultSet rs = st.executeQuery("select * from alumnos");
            rsmetadatos =  rs.getMetaData();
            //obteniendo numero de columnas
            int col = rsmetadatos.getColumnCount();
            System.out.println("Columnas: "+col);
            for(int i=1;i<=col;i++){
                System.out.println("Nombre de Columa: "+ rsmetadatos.getColumnName(i));
                System.out.println("Tipo de Dato: "+ rsmetadatos.getColumnTypeName(i));
                System.out.println("Pertenece a la tabla: "+ rsmetadatos.getTableName(i));
                System.out.println("---------------------------");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}