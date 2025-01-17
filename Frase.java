package RunGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Frase que contiene todo lo relacionado con el manejo de frases.
 * @author Lorena Almoguera Romero
 *
 */
public class Frase {
	
	// 		---------------		DEFINICION DE FRASES X DEFECTO 		-----------------	//
	
	private static final String CADENA_FACIL = "Facil";
	private static final String CADENA_MEDIO = "Intermedio";
	private static final String CADENA_DIFICIL = "Dificil";
	private static char Especial = '*';
	
	// 		---------------		TODAS LAS FRASES 		-----------------	//
	// 		---------------		FRASES FACILES 		-----------------	//
	private final ArrayList<String> frases_facil = new ArrayList<String>(List.of(
			"Soy una frase facil",
			"Ohana significa familia",
			"Vivimos en una simulacion",
			"Me divierte jugar a la ruleta"
	));
	// 		---------------		FRASES INTERMEDIAS 		-----------------	//
	private final ArrayList<String> frases_intermedias = new ArrayList<String>(List.of(
			"Te va a costar resolver esta frase un poco mas",
			"El ordenador resuelve problemas que antes no existian",
			"Quiero aprender a programar muy bien",
			"El juego de la ruleta es el mejor juego del mundo"
	));
	// 		---------------		FRASES DIFICILES		-----------------	//
	private final ArrayList<String> frases_dificiles = new ArrayList<String>(List.of(
			"Esta frase te va a costar resolverla muchisimo mas",
			"Quiero que mi programa aplique la programacion orientada a objetos",
			"Tengo muchas ganas de ver la pelicula de avatar",
			"En aleman la palabra aeropuerto es flughafen"
	));

	
	// 		---------------		MENSAJES A IMPRMIR POR PANTALLA 		-----------------	//
	private static final String CADENA_FRASE_ADIVINADA = "ENHORABUENA!!! HAS ADIVINADO LA FRASE";
	private static final String CADENA_FRASE_NO_ADIVINADA = "Oh no!! Esa no es la frase!";
	// 		---------------		DEFINICION DE VARIABLES 		-----------------	//
	
	private String frase = null;
	private String frase_oculta = null;

	
	
	// 		---------------		FUNCIONES RELACIONADAS CON LAS FRASES Y SU MANEJO 		-----------------	//
	
	/**
	 * Funcion que comprueba si la frase ha sido adivinada
	 * @param Frase
	 * @return boolean
	 */
	boolean  resolverFrase(String Frase) {
		
		String input = main.scanIn.nextLine();
		String Fraseaux = Frase;
		input = input.toLowerCase();
		Fraseaux = Fraseaux.toLowerCase();
		if(input.equals(Fraseaux) == true) {
			System.out.println(CADENA_FRASE_ADIVINADA);
			return true;
		}else {
			System.out.println(CADENA_FRASE_NO_ADIVINADA);
		}
		
		return false; 
	}
	
	/**
	 * Funcion que pasa por parametros la dificultad previamente especificada y devuelve una frase aleatoria de esa dificultad.
	 * @param Dificultad pasa como parametro
	 * @return la frase a resolver
	 */
	public String dameFrase(String Dificultad){
		Random aleatorio = new Random();
		int numero_aleatorio;
		switch(Dificultad) {
		case CADENA_FACIL: numero_aleatorio = aleatorio.nextInt(frases_facil.size()); //devuelve un numero aleatorio
			setFrase(frases_facil.get(numero_aleatorio));
			break;
		case CADENA_MEDIO: numero_aleatorio = aleatorio.nextInt(frases_intermedias.size());//devuelve un numero aleatorio
		setFrase(frases_intermedias.get(numero_aleatorio));
			break;
		case CADENA_DIFICIL: numero_aleatorio = aleatorio.nextInt(frases_dificiles.size());//devuelve un numero aleatorio
		setFrase(frases_dificiles.get(numero_aleatorio));
			break;
		}
		
		return frase;
	}
	
	/**
	 * Funcion que se encarga de remplazar un caracter por otro dentro de un string
	 * @param pos posicion
	 * @param ch caracter
	 * @param str cadena
	 * @return la frase, con el caracter remplazado
	 */
	public String RemplazarCaracter(int pos, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[pos] = ch;
	    return new String(charArray);
	}
	
	/**
	 * Funcion que se encarga de ocultar una frase
	 * @param FraseOculta pasa como parametro la frase oculta
	 * @return la frase oculta con el caracter especial *
	 */
	public String ocultarFrase(String FraseOculta) {
		for(int i = 0 ; i < FraseOculta.length(); i++) {
			if(FraseOculta.charAt(i) == ' ') {
				
			}else {
				FraseOculta = RemplazarCaracter(i, Especial, FraseOculta);
			}
		}
		setFrase_oculta(FraseOculta);
		return FraseOculta;
	}
	
	/**
	 * Funcion que se encarga de remplazar un caracter especifico dentro de una frase
	 * @param Letra utilizada
	 * @param Frase de la partida
	 * @param Frase_Oculta frase a resolver
	 * @return un String con la frase oculta actualizada
	 */
	public String letra_dentro_FraseOculta(String Letra, String Frase, String Frase_Oculta) {
		String auxFrase = Frase.toLowerCase();
		char miletra = Letra.charAt(0);
		if(Character.isUpperCase(miletra) == true) {
			miletra = Character.toLowerCase(miletra);
		}
		
		for(int i = 0 ; i < Frase.length(); i++) {
			if(auxFrase.charAt(i) == miletra) {
				char aux = Frase.charAt(i);
				if(Character.isUpperCase(aux) == true) {
					aux = Character.toUpperCase(aux);
					Frase_Oculta = RemplazarCaracter(i, aux, Frase_Oculta);
				}else {
					Frase_Oculta = RemplazarCaracter(i, aux, Frase_Oculta);
				}
			}else {
				
			}
		}
		setFrase_oculta(Frase_Oculta);
		return Frase_Oculta;
	}
	
	/**
	 * Comprueba la existencia del char dentro de una frase y devuelve la cantidad de veces que se ha encontrado
	 * @param input del usuario
	 * @param frase_no_oculta frase original
	 * @return devuelve la cantidad de veces que se ha encontrado la letra
	 */
	public int comprobar_existencia(String input, String frase_no_oculta) {
		String frase_aux = frase_no_oculta.toLowerCase();
		input = input.toLowerCase();
		char aux_char = input.charAt(0);
		int check = 0;
		for(int i = 0 ; i < frase_aux.length(); i++) {
			if(frase_aux.charAt(i) == aux_char) {
				check++;
			}
		}
		if(check > 0) {
			return check;
		}
		return check;
		
	}
	
	// 		---------------		GETTERS Y SETTERS 		-----------------	//

	/**
	 * Getter de frase
	 * @return devuelve la frase
	 */
	public String getFrase() {
		return frase;
	}

	/**
	 * Setter de frase
	 * @param frase a settear
	 */
	public void setFrase(String frase) {
		this.frase = frase;
	}
	
	/**
	 * getter de la frase oculta
	 * @return devuelfe la frase oculta
	 */
	public String getFrase_oculta() {
		return frase_oculta;
	}
	
	/**
	 * setter de la frase oculta
	 * @param frase_oculta a settear
	 */
	public void setFrase_oculta(String frase_oculta) {
		this.frase_oculta = frase_oculta;
	}
	
	
	
}
