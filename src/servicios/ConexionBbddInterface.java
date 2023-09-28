package servicios;

import java.sql.Connection;
/**
 * Interface que genera conexión a BBDD con la configuración dada en el .properties
 */
public interface ConexionBbddInterface {
	/**
	 * 
	 * @return Objeto Connection que representa una canal de conexión a bbdd abierta
	 */
	public Connection generarConexion();

}
