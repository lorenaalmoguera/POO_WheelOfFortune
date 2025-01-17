package RunGame;

/**
 * Clase partida que contiene todo lo relacionado con el funcionamiento de la partida.
 * @author Lorena Almoguera Romero
 *
 */
public class partida{

	
	// 		--------------- !!!!!		MENU_JUEGO		!!!!!	-----------------	//
	private static final String CADENA_BIENVENIDO_MENU = "Bienvenido al juego de la ruleta! Por favor, selecciona una de las siguientes opciones: ";
	private static final String CADENA_TIENDA_MENU = "(1) - COMPRAR VOCAL";
	private static final String CADENA_TIRADA_MENU = "(2) - TIRAR DE LA RULETA";
	private static final String CADENA_RESOLVER_MENU = "(3) - RESOLVER FRASE";
	private static final String CADENA_BIENVENIDO_TIENDA = "Bienvenido a la tienda de LA RULETA DE LA SUERTE";
	private static final String CADENA_TIRADA = "Pulsa la tecla enter para realizar tu tirada";
	private static final String CADENA_RESUELVE = "Dime tu respuesta: ";

	// 		---------------		MENSAJES DE ERROR 		-----------------	//
	private static final String CADENA_ESO_NO_ES_UN_NUMERO ="ERROR: Has introducido un caracter no numerico. Por favor, intentalo de nuevo.";
	private static final String CADENA_OPCION_ERROR = "ERROR: Has introducido una opcion no existente. Intentalo de nuevo";
	private static final String CADENA_ERROR_LENGTH = "ERROR: Introduce solo un caracter";
	private static final String CADENA_ERROR_CONSONANTE = "ERROR: Lo que has introducido no es una consonante. Intentalo de nuevo";
	private static final String CADENA_ERROR_VOCAL ="ERROR: Lo que has introducido no es una vocal. Intenalo de nuevo";
	
	// 		---------------		MENSAJES LETRAS 		-----------------	//
	private static final String CADENA_INTRODUCIDA = "LETRA INTRODUCIDA: ";
	private static final String CADENA_CONSONANTE = "Introduce una consonante: ";
	private static final String CADENA_VOCAL = "Introduce una vocal: ";
	private static final String CADENA_BANCO_VOCALES = "Vocales utilizadas: ";
	private static final String CADENA_BANCO_CONSONANTES = "Consonantes utilizadas: ";
	
	// 		---------------		MENSAJES LETRAS 		-----------------	//
	private static final String CADENA_SIN_DINERO = "No tienes el dinero suficiente como para comprar una vocal.";
	
	// 		---------------		MENSAJES GENERALES 		-----------------	//
	private static final String CADENA_PRESENTACION = "Bienvenido al juego de LA RULETA DE LA FORTUNA, realizado por LORENA ALMOGUERA ROMERO";
	private static final String CADENA_INICIO = "Por favor, indique si (1) desea jugar como INVITADO, (2) si desea INICIAR SESION o (3) si desea REGISTRARSE";
	private static final String CADENA_OPCION = "Por favor, seleccione una de las siguientes opciones: ";
	private static final String CADENA_DIFICULTADES_DISPONIBLES = "Las dificultades disponibles son: - Facil - Intermedio - Dificil -";
	private static final String CADENA_INVITADO = "(1) - Iniciar Sesión como Jugador Invitado: ";
	private static final String CADENA_REGISTRADO = "(2) - Iniciar Sesión como Jugador existente: ";
	private static final String CADENA_NUEVO_USUARIO = "(3) - Registrarse como nuevo Usuario";
	private static final String CADENA_SALIR = "(4) - Cerrar el programa";
	private static final String CADENA_SI = "(1) - Si";
	private static final String CADENA_NO = "(2) - No";
	private static final String CADENA_FACIL = "Facil";
	private static final String CADENA_MEDIO = "Intermedio";
	private static final String CADENA_DIFICIL = "Dificil";
	private static final String CADENA_AUX = "------------------------";
	private static final String CADENA_0_INTENTOS = "Ya no te quedan mas intentos";
	private static final String CADENA_SELECT_FACIL = "Has seleccionado la dificultad FACIL.";
	private static final String CADENA_SELECT_MED = "Has seleccionado la dificultad INTERMEDIO.";
	private static final String CADENA_SELECT_DIF = "Has seleccionado la dificultad DIFICIL.";
	private static final String CADENA_SELECT_DEF = "Por defecto, se ha seleccionado la dificultad FACIL.";
	private static final String CADENA_DESEAS_SEGUIR = "Deaseas seguir jugando?";
	private static final String CADENA_PARTIDAS_RES = "Partidas restantes:";
	private static final String CADENA_INTENTOS_RES = "Intentos restantes:";
	private static final String CADENA_PARTIDAS = "Cuantas partidas deseas jugar en esta dificultad?";
	private static final String CADENA_CONTINUAR = "Has decidido continuar";
	private static final String CADENA_NO_CONTINUAR = "Has decidido dejar de jugar";
	private static final String CADENA_PUNTUACION = "Puntuacion actual: ";
	private static final String CADENA_N_PARTIDAS = "Vas a jugar la siguiente cantidad de partidas: ";
	private static final String CADENA_SALDO_SUFICIENTE = "Tienes suficiente dinero para comprar una VOCAL. Si deseas comprar una vocal pulsa 1.";
	private static final String CADENA_3_DEFAULT = "Ha introducido el valor 0. Por defecto, va a jugar 3 partidas";
	private static final String CADENA_RECUERDA ="Recuerda incluir la mayuscula del principio.";
	private static final String CADENA_PUNTUACION_FINAL = "Puntuacion Final Obtenida: ";
	private static final String CADENA_GANADOR = "Eres un ganador!";
	private static final String CADENA_PERDEDOR = "Eres un perdedor!";
	
	// 		---------------		VARIABLES 		-----------------	//
	final int KEY_INVITADO = 1, KEY_INICIAR_SESION = 2, KEY_REGISTRARSE = 3, KEY_TIENDA = 1, KEY_TIRADA = 2, KEY_RESOLVER = 3, KEY_CONTINUAR = 1, KEY_NO_CONTINUAR = 2;
	final int precio = 30;
	
	private String nivel;
	private int intentos;
	private int Puntuacion_total;

	// 		---------------		FUNCIONES QUE IMPRIMEN POR PANTALLA 		-----------------	//
	
	/**
	 * Funcion que le muestra al usuario las opciones de inicio de sesion
	 */
	public void bienvenida() {
		System.out.println(CADENA_PRESENTACION);
		System.out.println(CADENA_INICIO);
		System.out.println(CADENA_OPCION);
		System.out.println(CADENA_INVITADO);
		System.out.println(CADENA_REGISTRADO);
		System.out.println(CADENA_NUEVO_USUARIO);
		System.out.println(CADENA_SALIR);
	}

	// 		---------------		DIFICULTAD Y TIPO DE USUARIO 		-----------------	//
	
	/**
	 * Funcion que pide al usuario un numero y devuelve la opcion seleccionada
	 * @return la opcion seleccionada
	 */
	public int opcion() {
		int opcion_int, num_aux = 0;
		
		String opcion = main.scanIn.nextLine();
		while(num_aux > 4 || num_aux < 1) {
			
			while(isNumeric(opcion)!= true) {
				System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
				opcion = main.scanIn.nextLine();
				
				while(opcion.length()>1) {
					System.out.println(CADENA_ERROR_LENGTH);
					opcion = main.scanIn.nextLine();
				}
			}
			num_aux = Integer.parseInt(opcion);
			if(num_aux > 4 || num_aux <1) {
				System.out.println(CADENA_OPCION_ERROR);
				opcion = main.scanIn.nextLine();
			}
		}

		opcion_int = Integer.parseInt(opcion);
		System.out.println("");
		return opcion_int;
		
	}
	
	
	/**
	 * Funcion que se encarga de establecer el nivel default en caso de que la persona haya introducido algo distinto a los 3 niveles disponibles
	 * @return nivel
	 */
	public String nivel_Default() {
		String nivel = main.scanIn.nextLine();
		
		switch(nivel) {
			case(CADENA_FACIL): if(nivel.equals(CADENA_FACIL) == true) {
				System.out.println(CADENA_SELECT_FACIL);
				return nivel;
			}break;
			case(CADENA_MEDIO): if(nivel.equals(CADENA_MEDIO) == true) {
				System.out.println(CADENA_SELECT_MED);
				return nivel;
			}break;
			case(CADENA_DIFICIL): if(nivel.equals(CADENA_MEDIO) == true) {
				System.out.println(CADENA_SELECT_DIF);
				return nivel;
			}break;
			default: nivel = CADENA_FACIL; System.out.println(CADENA_SELECT_DEF); return nivel;
		}
		return nivel;
	}
	
	/**
	 * Funcion que establece la cantidad de intentos
	 * @param nivel dificultad
	 * @return intentos (cantidad de intentos)
	 */
	public int Cantidad_Intentos(String nivel) {
		
		if(nivel.equals(CADENA_FACIL) == true) {
			intentos = 10;
			return intentos;
		}else if(nivel.equals(CADENA_MEDIO) == true) {
			intentos = 8;
			return intentos;
		}else if(nivel.equals(CADENA_DIFICIL) == true) {
			intentos = 5;
			return intentos;
		}
		return -1;
	}
	
	/**
	 * Funcion que permite al usuario especificar la cantidad de partidas que desea jugar.
	 * @return n_partidas (cantidad de partidas)
	 */
	public int elegir_n_partidas() {
		String n_partidas_aux;
		int n_partidas;
		
		System.out.println(CADENA_PARTIDAS);
		n_partidas_aux = main.scanIn.nextLine();
		
		if(n_partidas_aux.length() == 0) {
			n_partidas = 3;
			return n_partidas;
		}
		
		while(isNumeric(n_partidas_aux)!= true) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			System.out.println(CADENA_PARTIDAS);
			n_partidas_aux = main.scanIn.nextLine();
		}
		
		n_partidas = Integer.parseInt(n_partidas_aux);
		
		if(n_partidas == 0) {
			System.out.println(CADENA_3_DEFAULT);
			n_partidas = 3;
			return n_partidas;
		}
		n_partidas = Integer.parseInt(n_partidas_aux);
		
		return n_partidas;
	}
	
	/**
	 * Funcion que le permite al usuario seleccionar la opcion que desea utilizar dentro del juego
	 * @return seleccion
	 */
	public int seleccion_menu() {
		
		int seleccion;
		String input;
		
		System.out.println(CADENA_BIENVENIDO_MENU);
		System.out.println(CADENA_TIENDA_MENU);
		System.out.println(CADENA_TIRADA_MENU);
		System.out.println(CADENA_RESOLVER_MENU);
		
		input = main.scanIn.nextLine();
		
		while(isNumeric(input)!= true) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			input = main.scanIn.nextLine();
		}
		seleccion = Integer.parseInt(input);
		
		while(seleccion>3 || seleccion<1 ) {
			System.out.println(CADENA_OPCION_ERROR);
			input = main.scanIn.nextLine();
			while(isNumeric(input)!= true) {
				System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
				input = main.scanIn.nextLine();
			}
			seleccion = Integer.parseInt(input);
		}
		return seleccion;
	}
	
	/**
	 * Funcion que comprueba si el usuario puede o no puede seguir jugando
	 * @param intentos restantes
	 * @return devuelve un booleano
	 */
	public boolean puedeSeguirJugando(int intentos) {
		if(intentos == 0) {

			return false;
		}
		
		return true;
	}
	/**
	 * Funcion que le dice al usuario que ha ganado la partida
	 */
	public void esGanador() {
		
		System.out.println(CADENA_GANADOR);
	}
	
	/**
	 * Funcion que le dice al usuario que ha ganado la partida
	 */
	public void esPerdedor() {
		System.out.println(CADENA_PERDEDOR);
	}
	/**
	 * Funcion que nos muestra los resultados de cada tirad apor pantalla
	 * @param puntuacion actual
	 * @param intentos restantes
	 * @param frase_oculta actualizada
	 */
	public void mostrarInfoResultado(int puntuacion, int intentos, String frase_oculta) {
		
		System.out.println(CADENA_INTENTOS_RES + " " + intentos);
		System.out.println(CADENA_PUNTUACION + " " + puntuacion);
		System.out.println("");
		System.out.println(CADENA_AUX);
		System.out.println("Resuelve: " + frase_oculta);
		System.out.println(CADENA_AUX);
	}
	

	
	// 		---------------		ACCIONES PARTIDA 		-----------------	//
	/*
	public boolean deseas_guardar() {
		
		String str_respuesta;
		int res_numeric;
		System.out.println(CADENA_GUARDAR);
		str_respuesta = main.scanIn.nextLine();
		
		while(isNumeric(str_respuesta)!= true) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			str_respuesta = main.scanIn.nextLine();
		}
		res_numeric = Integer.parseInt(str_respuesta);
		while(res_numeric>2 || res_numeric<1 ) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			str_respuesta = main.scanIn.nextLine();
			while(isNumeric(str_respuesta)!= true) {
				System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
				str_respuesta = main.scanIn.nextLine();
			}
			res_numeric = Integer.parseInt(str_respuesta);
		}
		if(res_numeric == 1) {
			return true;
		}
		return false;
	}
	 */
	
	/**
	 * funcion que comprueba si el input introducido coincide con SI o NO.
	 * @param partidas numero de partidas
	 * @return int
	 */
	public int deseas_continuar(int partidas) {
		
		String str_respuesta;
		int res_numeric;
		
		System.out.println(CADENA_DESEAS_SEGUIR);
		System.out.println(CADENA_PARTIDAS_RES + partidas);
		System.out.println(CADENA_SI + " o " + CADENA_NO);
		
		str_respuesta = main.scanIn.nextLine();
		while(isNumeric(str_respuesta)!= true) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			str_respuesta = main.scanIn.nextLine();
		}
		res_numeric = Integer.parseInt(str_respuesta);
		while(res_numeric>2 || res_numeric<1 ) {
			System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
			str_respuesta = main.scanIn.nextLine();
			while(isNumeric(str_respuesta)!= true) {
				System.out.println(CADENA_ESO_NO_ES_UN_NUMERO);
				str_respuesta = main.scanIn.nextLine();
			}
			res_numeric = Integer.parseInt(str_respuesta);
		}
		
		switch(res_numeric) {
			case(KEY_CONTINUAR):System.out.println(CADENA_CONTINUAR);
				break;
			case(KEY_NO_CONTINUAR): System.out.println(CADENA_NO_CONTINUAR);
				partidas = 0;
				break;
		}
		
		return  partidas;
	}
	
	/**
	 * Funcion que pide al usuario una consonante y realiza comprobaciones para ver si es o no es una consonante
	 * @return devuelve la consonante
	 */
	public String dameLetra_Consonante() {
		String mi_consonante;
		
		System.out.println(CADENA_CONSONANTE);
		mi_consonante = main.scanIn.nextLine();
		
		while(Letras.esCons(mi_consonante)==false) {
			System.out.println(CADENA_ERROR_CONSONANTE);
			mi_consonante = main.scanIn.nextLine();
			
			while(char_len(mi_consonante) == false) {
				System.out.println(CADENA_ERROR_LENGTH);
				mi_consonante = main.scanIn.nextLine();
			}
		}
		return mi_consonante;
		
	}
	
	/**
	 * Funcion que pide al usuario una vocal y realiza comprobaciones para ver si es o no es una vocal
	 * @return devuelve la vocal
	 */
	public String dameLetra_Vocal() {
		String mi_vocal;
		
		System.out.println(CADENA_VOCAL);
		mi_vocal = main.scanIn.nextLine();
		
		while(Letras.esVocal(mi_vocal)==false) {
			System.out.println(CADENA_ERROR_VOCAL);
			mi_vocal = main.scanIn.nextLine();
			
			while(char_len(mi_vocal) == false) {
				System.out.println(CADENA_ERROR_LENGTH);
				mi_vocal = main.scanIn.nextLine();
			}
		}
		
		return mi_vocal;
	}
	
	
	// 		---------------		FUNCIONES QUE VALIDAN 		-----------------	//
	
	/**
	 * Funcion que comprueba si el input del usuario coincide con el valor 1
	 * @param input del usuario
	 * @return si es correcto o no correcto
	 */
	public boolean char_len(String input) {
		int str_len = 1;
		if(input.length()!= str_len) {
			return false;
		}return true;
	}
	
	/**
	 * Funcion que comprueba si el String es un int
	 * @param str string a comprobar
	 * @return si es correcto o no correcto
	 */
	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
		
	// 		---------------		INICIO DE PARTIDA 		-----------------	//
	
	/**
	 * Funcion que establece la frase, la dificultad, la cantidad de intentos y la cantidad de partidas a jugar.
	 * @param int_input pasamos el numero de partidas
	 * @param player el jugador
	 */
	public void elegir_dificultad_y_escoger_frases(int int_input, Jugador player) {
		String dificultad, frase_no_oculta;	
		int intentos, n_partidas, puntuacion;
		Frase frase = new Frase();
		
		System.out.println(" ");
		System.out.println(CADENA_PRESENTACION);
		System.out.println(CADENA_DIFICULTADES_DISPONIBLES);
		System.out.println(CADENA_RECUERDA);
		dificultad = nivel_Default();
		n_partidas = elegir_n_partidas();
		System.out.println(CADENA_N_PARTIDAS + n_partidas);
		while(n_partidas > 0) {
			intentos = Cantidad_Intentos(dificultad);
			switch(dificultad) {
				case CADENA_FACIL:
					frase.dameFrase(dificultad);
					frase_no_oculta = frase.getFrase();
					break;
				case CADENA_MEDIO:
					frase.dameFrase(dificultad);
					frase_no_oculta = frase.getFrase();
					break;
				case CADENA_DIFICIL:
					frase.dameFrase(dificultad);
					frase_no_oculta = frase.getFrase();
					break;
			}
			
			puntuacion = iniciarpartida(frase, intentos);
			/*if(deseas_guardar() == true) {
				player.setPuntuacion(puntuacion);
				try {
					player.escribirEnFichero_puntuacion(player);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			n_partidas = n_partidas -1;
			
			if(n_partidas == 0) { // si no quedan mas partidas continuamos
				continue;
			}else {
				n_partidas = deseas_continuar(n_partidas);
			}
		}
	}
	
	/**
	 * El juego en si.
	 * @param frase seleccionada
	 * @param intentos cantidad total
	 * @return la puntuacion obtenida
	 */
	public int iniciarpartida(Frase frase, int intentos) {
		//DEFINICION DE VARIABLES A USAR
		int puntuacion = 0, check, seleccion, tirada_obtenida;
		boolean vamos_a_resolver;
		Tirada miTirada = new Tirada();
		Letras banco_letras = new Letras();
		String vocales_usadas = banco_letras.getVocales_usadas(), consonantes_usadas = banco_letras.getConsonantes_usadas(), input;
		String La_frase = frase.getFrase(), frase_oculta = frase.ocultarFrase(La_frase);	// guardamos la frase en una variable, y  la copiamos en otra para ocultarla
		
		while(intentos > 0) {	
			check = 0; // reseteamos el valor de check, que indica la cantidad de veces que se encuentra un caracter en el string
			
			mostrarInfoResultado(puntuacion, intentos, frase_oculta);
			//System.out.println(La_frase);
			
			System.out.println("");
			
			if(puntuacion >= 30) {
				System.out.println("**** " + CADENA_SALDO_SUFICIENTE + " ****");
				System.out.println("");
			}
			seleccion = seleccion_menu();
			
			
			switch(seleccion) {
			case(KEY_TIENDA): System.out.println(CADENA_BIENVENIDO_TIENDA);
				break;
			case (KEY_TIRADA): System.out.println(CADENA_TIRADA);
				break;
			case (KEY_RESOLVER): System.out.println(CADENA_RESUELVE);
				break;
			}
			
			if(seleccion == KEY_TIENDA) {
				
				if(puntuacion-precio <= 0) {
					System.out.println(CADENA_SIN_DINERO);
					intentos = intentos + 1;
				}else{
					System.out.println("Puntuacion antes de la compra: "+puntuacion);
					System.out.println(CADENA_AUX);
					System.out.println(CADENA_BANCO_VOCALES + vocales_usadas);
					input = dameLetra_Vocal();
					System.out.println(CADENA_INTRODUCIDA + input);
	
					while(banco_letras.comprobar_vocal(input) == true) {
						input = dameLetra_Vocal();
						System.out.println(CADENA_INTRODUCIDA + input);
					}
					
					check = frase.comprobar_existencia(input, La_frase);
					vocales_usadas = banco_letras.usarvocal(input);
					
					if(check>0) {
						System.out.println("La letra " + input + " se ha encontrado " + check + " veces");
						puntuacion = puntuacion - precio;
						frase_oculta = frase.letra_dentro_FraseOculta(input, La_frase, frase_oculta);
					}else if(check == 0) {
						System.out.println("La letra " + input + " no se ha encontrado dentro de la frase" );
						puntuacion = puntuacion - precio;
					}
					
					System.out.println("Puntuacion despues de la compra: " + puntuacion);
					intentos = intentos + 1;
				}
				
			}else if(seleccion == KEY_TIRADA) {
				tirada_obtenida = miTirada.Tirar();       
				if(tirada_obtenida == 0) {
					puntuacion = 0;
				}
				System.out.println(CADENA_AUX);
				System.out.println(CADENA_BANCO_CONSONANTES + consonantes_usadas);
				
				input = dameLetra_Consonante();
				System.out.println(CADENA_INTRODUCIDA + input);
				
				while(banco_letras.comprobar_consonante(input) == true) {
					input = dameLetra_Consonante();
					System.out.println(CADENA_INTRODUCIDA + input);
				}
				
				check = frase.comprobar_existencia(input, La_frase);
				consonantes_usadas = banco_letras.usarconsonante(input);
				
				if(check>0) {
					System.out.println("La letra " + input + " se ha encontrado " + check + " veces");
					frase_oculta = frase.letra_dentro_FraseOculta(input, La_frase, frase_oculta);
					puntuacion = puntuacion + tirada_obtenida*check;
				}else if(check == 0) {
					System.out.println("La letra " + input + " no se ha encontrado dentro de la frase" );
				}
								
			}else if(seleccion == KEY_RESOLVER) {
				vamos_a_resolver = frase.resolverFrase(La_frase);
				
				if(vamos_a_resolver == true) {
					esGanador();
					System.out.println(CADENA_PUNTUACION_FINAL + puntuacion);
					System.out.println(" ");
					break;
				}
			}
				intentos = intentos - 1;
				
				if(puedeSeguirJugando(intentos) == false) {
					System.out.println(CADENA_0_INTENTOS);
					esPerdedor();
					System.out.println("LA RESPUESTA ERA : " + La_frase);
				}
			
			System.out.println(" ");
			
		}
		return puntuacion;
	}
	
	// 		---------------		GETTERS Y SETTERS 		-----------------	//
	
	/**
	 * Funcion que se encarga de devolver la puntuacion total
	 * @return puntuacion total
	 */
	public int getPuntuacion_total() {
		return Puntuacion_total;
	} 	
	
	/**
	 * Funcion que se encarga de devolver el nivel establecido
	 * @return la dificultad
	 */
	public String getNivel() {
		return nivel;
	}


	/**
	 * Funcion que se encarga de establecer el nivel a usar
	 * @param nivel la dificultad
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
}
