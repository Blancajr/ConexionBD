	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import conexion.ConexionBD;

	public class Departamentos {
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
				resultado=sentencia.executeQuery("select * from departamentos"); 
				System.out.println("Cod.departamento\tCod.centro\tCod.director\tTipo.dir \tPresupuesto\tCod.dpto.jefe \tNombre");
				
				// Paso 4. Recorrer el resultado
				while(resultado.next()) {
					int codDepartamento = resultado.getInt("cod_departamento");
					int codCentro = resultado.getInt("cod_Centro");
					int codDirector = resultado.getInt("cod_Director");
					String tipo_dir = resultado.getString("tipo_dir");
					String presupuesto = resultado.getString("presupuesto");
					int cod_dpto_jefe = resultado.getInt("cod_dpto_jefe");
					String nombre = resultado.getString("nombre");
					
					System.out.println(codDepartamento+"\t"+codCentro+"\t"+codDirector+"\t"+tipo_dir+"\t"+presupuesto+"\t"+cod_dpto_jefe+"\t"+nombre);
				}
				
			} catch (SQLException e) {
				System.out.println("Error al liberar los recursos. "+e.getMessage());
			}finally {			
				
			}
			//Liberamos la conexión
			System.out.println("Desconectando de la base de datos...");
			conexion.desconectar();
		}

	}