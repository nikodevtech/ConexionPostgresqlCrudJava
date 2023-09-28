package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LibroDto;

/**
 * Clase util para pasar a DTO contiene los métodos que se usan frecuentemente
 */
public class ADto {

	/**
	 * Método que convierte una estructura de datos ResultSet con campos de libros a list de LibroDto
	 * @param resultadoConsulta --> estructura similar a array con datos de los libros
	 * @return list con LibroDtos
	 */
	public List<LibroDto> pasarResultSetALibrosDto(ResultSet resultadoConsulta) {

		List<LibroDto> listaLibros = new ArrayList<LibroDto>();

		// Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {

				listaLibros.add(new LibroDto(resultadoConsulta.getLong("id_libro"),
						resultadoConsulta.getString("titulo"), resultadoConsulta.getString("autor"),
						resultadoConsulta.getString("isbn"), resultadoConsulta.getInt("edicion")));
			}

			int i = listaLibros.size();
			System.out.println("**INFO ConvertirADto resultsALibrosDto** Número libros: " + i);

		} catch (SQLException e) {
			System.out.println("**ERROR ADto pasarResultSetALibrosDto** Error al pasar el resultset a lista de LibroDto" + e);
		}

		return listaLibros;

	}
}
