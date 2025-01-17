package RunGame;
import java.util.Scanner;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.time.LocalDate;

/**
 * Clase Publica del main que contiene el menu principal y el acceso a todas las funciones.
 * @author Lorena Almoguera Romero
 *
 */
public class main {
	
//		---------------		MENSAJES 		-----------------	//
//		---------------		MENSAJES GENERALES		-----------------	//
	
	private static final String CADENA_PARTIDA_INVITADO = "BIENVENIDO JUGADOR INVITADO!";
	private static final String CADENA_FIN_PROGRAMA = "FIN DEL PROGRAMA";
	
//		---------------		MENSAJES DE ERROR		-----------------	//
	private static final String CADENA_EDAD_NO_VALIDA ="Usted tiene menos de 10 años. Lo sentimos pero no puede jugar";
	private static final String CADENA_DEMASIADOS_INTENTOS ="Lo siento. Has fallado demasiados intentos. Vuelva a intentarlo más tarde.";

	//	---------------			VARIABLES 		-----------------	//
	private static final String CADENA_INVITADO ="invitado";
	final static int KEY_PARTIDA_INVITADO = 1;
	final static int KEY_PARTIDA_INICIAR_SESION = 2;
	final static int KEY_PARTIDA_REGISTRARSE = 3;
	final static int KEY_PARTIDA_EXIT = 4;
	static Scanner scanIn = new Scanner(System.in);
	private static LocalDate fechaHoy = LocalDate.now();
	
	/**
	 * Funcion que se encarga de imprimir mensajes por pantalla
	 * @param mensaje a imprimir
	 */
	public static void imprimir(String mensaje) {
		System.out.println(mensaje);
	}
	
	/**
	 * El main.
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int int_input;
		Boolean check = false;
		String fecha;
		
		
		while(check == false) {
			
			Jugador player = new Jugador();
			partida game = new partida();
			
			imprimir(" "); // para dejar hueco entre ejecuciones
			game.bienvenida();
			int_input = game.opcion();
			
			switch(int_input) {
				case KEY_PARTIDA_INVITADO: imprimir(CADENA_PARTIDA_INVITADO);
					fecha = Jugador.pedir_cumple();	// comprobamos si el usuario puede jugar
					if(Jugador.check_Edad(fecha, fechaHoy) == false) {
						imprimir(CADENA_EDAD_NO_VALIDA);	
						break;	// si tiene <10 no puede jugar
					}
					if(Jugador.pedir_invitado() == false) { // le pedimos al invitado las credenciales
						imprimir(CADENA_DEMASIADOS_INTENTOS);
						break;	// si no las conoce no puede jugar
					}
					player.setNombre(CADENA_INVITADO);
					game.elegir_dificultad_y_escoger_frases(int_input, player);
			
					break;
				case KEY_PARTIDA_INICIAR_SESION: 
					if(player.iniciar_sesion(player) == true) {
						game.elegir_dificultad_y_escoger_frases(int_input, player);
					}else {
						imprimir(CADENA_DEMASIADOS_INTENTOS);
						break;	// si no las conoce no puede jugar
					}
					break;
				case KEY_PARTIDA_REGISTRARSE:
					fecha = Jugador.pedir_cumple();
					if(Jugador.check_Edad(fecha, fechaHoy) == false) {
						imprimir(CADENA_EDAD_NO_VALIDA);
						break;
					}
					player.pedir_datos(fecha);
					player.imprimir_datos();
					Jugador.add_user(player);
					
					break;
				case KEY_PARTIDA_EXIT:
						System.exit(-1);
					break;
			}

		}
		scanIn.close();
		imprimir(CADENA_FIN_PROGRAMA);
		
	}
	
	

}
