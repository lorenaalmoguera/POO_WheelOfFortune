package RunGame;
import java.util.Random;

/**
 * Clase Tirada que contiene todo lo relacionado con la tirada de la partida.
 * @author Lorena Almoguera Romero
 *
 */
public class Tirada {

	private static final String CADENA_TIRADA = " Has caido en: ";	
	private static final String CADENA_ENHORABUENA = "!!!!Enhorabuena!!!!";
	private static final String CADENA_OH_NO ="!!!Oh no, BANCA ROTA!!!";
	
	/**
	 * Funcion que genera e imprime la puntuacion a partir de un numero generado aleatoriamente
	 * @return puntuacion obtenida
	 */
	public int Tirar() {
		Random rand = new Random();
		int numero_aleatorio = rand.nextInt((5-1)+1)+1, puntuacion;
		
		switch(numero_aleatorio) {
			case 1: puntuacion = 10;
			System.out.println(CADENA_ENHORABUENA + CADENA_TIRADA + puntuacion);
				return puntuacion;
			case 2: puntuacion = 20;
			System.out.println(CADENA_ENHORABUENA + CADENA_TIRADA + puntuacion);
				return puntuacion;
			case 3: puntuacion = 30;
				System.out.println(CADENA_ENHORABUENA + CADENA_TIRADA + puntuacion);
				return puntuacion;
			case 4: puntuacion = 40;
				System.out.println(CADENA_ENHORABUENA + CADENA_TIRADA + puntuacion);
				return puntuacion;
			case 5: puntuacion = 0;
				System.out.println(CADENA_OH_NO + CADENA_TIRADA + puntuacion);
				return puntuacion;
		}
		
		return puntuacion = 0;
		
	}
	
}
