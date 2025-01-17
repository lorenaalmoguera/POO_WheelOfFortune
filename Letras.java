package RunGame;

/**
 * Clase Letras que contiene todo lo relacionado con el manejo de los caracteres.
 * @author Lorena Almoguera Romero
 *
 */
public class Letras {
	
	// 		---------------		MENSAJES A IMPRIMIR POR PANTALLA		-----------------	//
	
	private final static String CADENA_VOCAL_NO_DISPONIBLE = "Esa Vocal NO está disponible!";
	private final static String CADENA_CONSONANTE_NO_DISPONIBLE = "Esa Consonante NO está disponible!";
	private final static String CADENA_OTRA_LETRA = "Introduce otra letra";
	
	// 		---------------		Declaracion de variables		-----------------	//
	private static String Vocales ="AEIOUaeiou";
	private static String Consonantes = "bcdhgjklmnpqrstvwxyzñBCDHGfFJKLMNPQRSTVWXYZÑ";
	private String consonantes_usadas = "";
	private String vocales_usadas = "";

	

	
	// 		---------------		FUNCIONES QUE VALIDAN 		-----------------	//
	
	/**
	 * Funcion que comprueba si el input es una Vocal.
	 * @param input del usuario
	 * @return booleano
	 */
	public static boolean esVocal(String input) {
		char aux_char = input.charAt(0);
		int check = 0;
		for(int i = 0 ; i < Vocales.length(); i++) {
			if(Vocales.charAt(i) == aux_char ) {
				check++;
			}
		}
		if(check>0) {
			return true;
		}
		return false;
	}

	/**
	 * Funcion que comprueba si el input es una Consonante
	 * @param input del usuario
	 * @return booleano
	 */
	public static boolean esCons(String input) {
		char aux_char = input.charAt(0);
		int check = 0;
		for(int i = 0 ; i < Consonantes.length(); i++) {
			if(Consonantes.charAt(i) == aux_char ) {
				check++;
			}
		}
		if(check>0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Funcion que comprueba si la vocal ha sido usada
	 * @param input la vocal a comprobar
	 * @return boolean
	 */
	public boolean comprobar_vocal(String input) {
		String vocales_aux = vocales_usadas.toLowerCase();
		input = input.toLowerCase();
		char aux_char = input.charAt(0);
		int check = 0;
		for(int i = 0 ; i < vocales_usadas.length(); i++) {
			if(vocales_aux.charAt(i) == aux_char) {
				check++;
			}
		}
		
		if(check > 0) {
			System.out.println(CADENA_VOCAL_NO_DISPONIBLE);
			System.out.println(CADENA_OTRA_LETRA);
			return true;
		}
		return false;
		
	}
	
	/**
	 * Funcion que comprueba si la consonante ha sido usada
	 * @param input del usuario
	 * @return boolean
	 */
	public boolean comprobar_consonante(String input) {
		String consonantes_aux = consonantes_usadas.toLowerCase();
		input = input.toLowerCase();
		char aux_char = input.charAt(0);
		int check = 0;
		for(int i = 0 ; i < consonantes_usadas.length(); i++) {
			if(consonantes_aux.charAt(i) == aux_char) {
				check++;
			}
		}
		
		if(check > 0) {
			System.out.println(CADENA_CONSONANTE_NO_DISPONIBLE);
			System.out.println(CADENA_OTRA_LETRA);
			return true;
		}
		return false;
		
	}
	
	/**
	 * Funcion que permite añade la consonante utilizada al string de consonantes usadas.
	 * @param consonante a utilizar
	 * @return String de las vocales
	 */
	public String usarconsonante(String consonante) {
		
		String MisConsonantes;
		char aux_char = consonante.charAt(0);
		aux_char = Character.toLowerCase(aux_char);
		
		consonantes_usadas = consonantes_usadas + aux_char;
		setConsonantes_usadas(consonantes_usadas);
		
		MisConsonantes = getConsonantes_usadas();
		return MisConsonantes;
	}
	
	/**
	 * Funcion que permite añade la vocal utilizada al string de vocales
	 * @param vocal a utilizar
	 * @return String de las vocales
	 */
	public String usarvocal(String vocal) {
		
		String MisVocales;
		char aux_char = vocal.charAt(0);
		aux_char = Character.toLowerCase(aux_char);
		
		vocales_usadas = vocales_usadas + vocal;
		setVocales_usadas(vocales_usadas);
		
		MisVocales = getVocales_usadas();
		return MisVocales;
		
	}

	
	// 		---------------		GETTERS Y SETTERS 		-----------------	//
	
	/**
	 * Getter de las consonantes utilizadas
	 * @return consonantes usadas
	 */
	public String getConsonantes_usadas() {
		return consonantes_usadas;
	}
	
	/**
	 * Setter de las consonantes usadas
	 * @param consonantes_usadas pasadas por parametro
	 */
	public void setConsonantes_usadas(String consonantes_usadas) {
		this.consonantes_usadas = consonantes_usadas;
	}
	
	/**
	 * Getter de las vocales usadas
	 * @return devuelve las vocales usadas
	 */
	public String getVocales_usadas() {
		return vocales_usadas;
	}
	
	/**
	 * Setter de las vocales usadas
	 * @param vocales_usadas pasadas por parametro
	 */
	public void setVocales_usadas(String vocales_usadas) {
		this.vocales_usadas = vocales_usadas;
	}



}