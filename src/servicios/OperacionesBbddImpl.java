package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.LibroDto;
import util.ADto;

/**
 * Clase que implementa la interfaz que dan servicio al CRUD para las operaciones con BBDD
 */
public class OperacionesBbddImpl implements OperacionesBbddInterface {

	@Override
	public List<LibroDto> readLibro(Connection conexionGenerada) {
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		List<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();
		
		try {
			
			//Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			//Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");
		    
			//Llamada a la conversión a dtoAlumno
			listaLibros = adto.pasarResultSetALibrosDto(resultadoConsulta);
			int cantidadDeLibros = listaLibros.size();
			System.out.println("**INFO OperacionesBbddImpl readLibros** Número libros: "+cantidadDeLibros);
			
			System.out.println("**INFO OperacionesBbddImpl readLibros** Cierre conexión, declaración y resultado");				
		    resultadoConsulta.close();
		    declaracionSQL.close();
		    conexionGenerada.close();
			
		} catch (SQLException e) {
			
			System.out.println("**ERROR OperacionesBbddImpl readLibros** Error generando o ejecutando la declaracionSQL: " + e);
			return listaLibros;
			
		}
		return listaLibros;
	}

	@Override
	public List<LibroDto> createLibro(Connection conexionGenerada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibroDto> updateLibro(Connection conexionGenerada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LibroDto> deleteLibro(Connection conexionGenerada) {
		// TODO Auto-generated method stub
		return null;
	}

}
