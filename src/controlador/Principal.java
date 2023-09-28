package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dto.LibroDto;
import servicios.ConexionBbddImpl;
import servicios.ConexionBbddInterface;
import servicios.MenuImpl;
import servicios.MenuInterface;
import servicios.OperacionesBbddImpl;
import servicios.OperacionesBbddInterface;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean cerrarMenu = false;
		int opcion;

		MenuInterface menuInterface = new MenuImpl();
		ConexionBbddInterface conexionBbdd = new ConexionBbddImpl();
		OperacionesBbddInterface operacionBbdd = new OperacionesBbddImpl();
		List<LibroDto> listalibros = new ArrayList<LibroDto>();
		Connection conexion = null;

		do {
			try {

				conexion = conexionBbdd.generarConexion();

				if (conexion != null) {

					opcion = menuInterface.mostrarMenu();

					switch (opcion) {
					
					case 1:

						break;
					case 2:
						operacionBbdd.readLibro(conexion);
						break;
					case 3:
						break;
					case 4:
						break;
					case 0:
						cerrarMenu = true;
						break;
					}
				}

			} catch (Exception e) {
				System.out.println("\n**ERROR ocurrió una excepción no esperada" + e.getMessage() + " **");
			} 

		} while (!cerrarMenu);
		System.out.println("\nDesconectando, saliendo de la aplicación!");

	}

}
