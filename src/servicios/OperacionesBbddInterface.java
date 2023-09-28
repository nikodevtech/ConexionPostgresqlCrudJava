package servicios;

import java.sql.Connection;
import java.util.List;
import dto.LibroDto;

/**
 * Interfaz que contiene los métodos CRUD que realizan operaciones con la BBDD
 */
public interface OperacionesBbddInterface {

	/**
	 * Método que realiza el SELECT para ver los registros de los libros
	 * @param conexionGenerada
	 * @return Lista de los LibroDTO
	 */
	public List<LibroDto> readLibro(Connection conexionGenerada);
	/**
	 * Método que realiza el INSERT INTO para realizar un nuevo registro de libro
	 * @param conexionGenerada
	 * @return Lista de los LibroDTO
	 */
	public List<LibroDto> createLibro(Connection conexionGenerada);
	/**
	 * Método que realiza el UPDATE para modificar un registro de libro
	 * @param conexionGenerada
	 * @return Lista de los LibroDTO
	 */
	public List<LibroDto> updateLibro(Connection conexionGenerada);
	/**
	 * Método que realiza el DELETE para elinminar un registro de libro
	 * @param conexionGenerada
	 * @return Lista de los LibroDTO
	 */
	public List<LibroDto> deleteLibro(Connection conexionGenerada);
}
