package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class PruebaConexion {

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
			resultado=sentencia.executeQuery("select cod_empleado, nombre, salario from empleados");
			System.out.println("Cod. Empleado\tNombre\tSalario");
			
			// Paso 4. Recorrer el resultado
			while(resultado.next()) {
				int codEmpleado = resultado.getInt("cod_empleado");
				String nombre = resultado.getString("nombre");
				int salario = resultado.getInt("salario");
				
				System.out.println(codEmpleado+"\t"+nombre+ "\t"+salario);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al liberar los recursos");
		}finally {			
			
		}		//Liberamos la conexión
		System.out.println("Desconectando de la base de datos...");
		conexion.desconectar();
	}

}
