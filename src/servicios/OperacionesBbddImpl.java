package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.LibroDto;
import util.ADto;

/**
 * Clase que implementa la interfaz que dan servicio al CRUD para las
 * operaciones con BBDD
 */
public class OperacionesBbddImpl implements OperacionesBbddInterface {

	@Override
	public List<LibroDto> readLibro(Connection conexionGenerada) {
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		List<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();

		try {

			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros");

			// Llamada a la conversión a LibroDTO y añadido en su lista
			listaLibros = adto.pasarResultSetALibrosDto(resultadoConsulta);

			// Información por consola para mostrar el flujo de ejecución
			int cantidadDeLibros = listaLibros.size();
			System.out.println("**INFO OperacionesBbddImpl readLibros** Número libros: " + cantidadDeLibros);
			System.out.println("**INFO OperacionesBbddImpl readLibros** Cierre conexión, declaración y resultado");

			// Mostrando los libros al usuario
			if (listaLibros.isEmpty()) {
				JOptionPane.showMessageDialog(null, "¡¡No hay libros registrados que mostrar!!");
			} else {
				String mostrarTodosLibros = JOptionPane
						.showInputDialog("Quiere ver todos los libros (Y = si / N = no)?:");
				if (mostrarTodosLibros.toUpperCase() == "Y") {
					mostarLibrosDeLaLista(listaLibros);
				} else {
					int idLibroAmostrar = Integer
							.parseInt(JOptionPane.showInputDialog("Introduce el id del libro a mostrar: "));
					mostrarLibroPorID(listaLibros, idLibroAmostrar);

				}
			}
			// Liberando los recursos
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.out.println(
					"**ERROR OperacionesBbddImpl readLibros** Error generando o ejecutando la declaracionSQL: " + e);
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

	/**
	 * Itera la lista con los libros y los muestra todos al usuario
	 * @param listaLibros
	 */
	private void mostarLibrosDeLaLista(List<LibroDto> listaLibros) {

		for (LibroDto libro : listaLibros) {
			JOptionPane.showMessageDialog(null, libro.toString());
		}

	}

	/**
	 * Itera la lista con los libros y muestra al usuario el libro con id que ya introdujos
	 * @param listaLibros
	 * @param idLibroAmostrar
	 */
	private void mostrarLibroPorID(List<LibroDto> listaLibros, int idLibroAmostrar) {
		boolean libroEncontrado = false;
		for(LibroDto libro : listaLibros) {
			if(libro.getIdLibro() == idLibroAmostrar) {
				JOptionPane.showMessageDialog(null,listaLibros.get(idLibroAmostrar).toString());
				libroEncontrado = true;
			} 
		}
		if(libroEncontrado == false) {		
			JOptionPane.showMessageDialog(null, "No existe libro con id "+ idLibroAmostrar);
		}
	}

}
