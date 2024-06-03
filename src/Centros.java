import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class Centros {
	public static void main(String[] args) {
		ConexionBD conexion= new ConexionBD();
		
		System.out.println("Conectando a la base de datos...");
		// Paso 1. Obtener la conexión
		Connection con = conexion.getConexion();
		
		//Objetos necesarios para hacer una consulta
				Statement sentencia= null;
				ResultSet resultado=null;
				
		//Algún procesamiento con la base de datos..
		// Paso 2. Obtener el Statement
		try {
			sentencia =con.createStatement();
		
		//Paso 3. Ejecutar la sentencia
			resultado=sentencia.executeQuery("select * from centros"); 
			System.out.println("Cod. Centro\tNombre del Cenltro\tDirección");
			
			// Paso 4. Recorrer el resultado
			while(resultado.next()) {
				int codCentro = resultado.getInt("cod_centro");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				System.out.println(codCentro+"\t"+nombre+ "\t"+direccion);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al liberar los recursos");
		}finally {			
			
		}
		//Liberamos la conexión
		System.out.println("Desconectando de la base de datos...");
		conexion.desconectar();
	}

}
