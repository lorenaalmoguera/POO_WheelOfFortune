package RunGame;

//import java.io.ObjectOutputStream;
//import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.regex.Pattern;
//import java.io.*;

/**
 * Clase Jugador que contiene todo lo relacionado con el jugador.
 * @author Lorena Almoguera Romero 
 *
 */
public class Jugador{
	

//	---------------		ARRAYLIST DE JUGADORES		-----------------	//
	private final static ArrayList<Jugador> misjugadores = new ArrayList<Jugador>();

//		---------------		MENSAJES 		-----------------	//
	private static final String CADENA_INTRODUCIDO_MENSAJE = "Has introducido la fecha: ";
	private static final String CADENA_NECESITAMOS_TU_FECHA = "Necesitamos que nos digas tu fecha de cumpleaños.";
	private static final String CADENA_FORMATO_FECHA ="Recuerda que el formato es dd/mm/aaaa";
	private static final String CADENA_INICIO_CORRECTO ="Credenciales correctas.";

//	---------------		MENSAJES DE GUARDADO 		-----------------	//
	//private static final String CADENA_GUARDANDO = "Guardando datos en: ";

//	---------------		MENSAJES RELACIONADOS CON EL REGISTRO		-----------------	//
	private static final String CADENA_NOMBRE = "Introduce tu nombre: ";
	private static final String CADENA_ALIAS = "Introduce tu alias: ";
	private static final String CADENA_BIENVENIDO_NOMBRE = "Gracias por registrarte con nosotros ";
	private static final String CADENA_INTRODUCE_PASSWORD = "Introduce tu contraseña: ";
	private static final String CADENA_REPITE_PASSWORD = "Repite tu contraseña: ";
	private static final String CADENA_INTRODUCE_USUARIO = "Introduce tu usuario: ";
	private static final String CADENA_ALIAS_CORTO = "WARNING: El alias es demasiado corto";
	private static final String CADENA_USER_EXISTENTE = "WARNING: Ese usuario ya existe.";
	private static final String CADENA_PASS_CORTO = "WARNING: La contraseña debe de tener al menos 6 caracteres";
	
	
//		---------------		DE ERROR 		-----------------	//
	private static final String CADENA_ERROR_PASSWORD = "ERROR: La contraseña no coincide";
	private static final String CADENA_USUARIO_EXISTENTE = "ERROR: Usuario ya existente.";
	private static final String CADENA_ERROR_NOMBRE = "ERROR: Tu nombre solo puede contener letras";
	private static final String CADENA_EDAD_NO_VALIDA = "ERROR: Tienes menos de 10 años. No puedes jugar";
	private static final String CADENA_ERROR_FORMATO_FECHA ="ERROR: Formato INCORRECTO. Por favor, vuelve a introducir la fecha.";
	private static final String CADENA_INICIO_INCORRECTO = "ERROR: compruebe su contraseña o usuario. Intentos restantes: ";

	//		---------------		VARIABLES 		-----------------	//

	//private static final String fichero_puntuacion = "puntuacion.txt";
	//private static final String fichero_registros = "registro.txt";
	private static final String CADENA_INVITADO = "invitado";
	private static LocalDate fechaHoy = LocalDate.now();
	
	private String nombre;
	private String usuario;
	private String password;
	private String fecha_nacimiento;
	private int puntuacion;
//		---------------		DATOS DEL USUARIO		-----------------	//
	
	/**
	 * funcion que pide y comprueba si la fecha introducida por el usuario es valida.
	 * @return devuelve la fecha
	 */
	public static String pedir_cumple() {
		
		String fecha; 
		System.out.println(CADENA_NECESITAMOS_TU_FECHA);
		System.out.println(CADENA_FORMATO_FECHA);
		fecha = main.scanIn.nextLine();
		
		System.out.println(CADENA_INTRODUCIDO_MENSAJE + fecha);
		
		while(validarfecha(fecha) == false) {
			System.out.println(CADENA_ERROR_FORMATO_FECHA);
			System.out.println(CADENA_FORMATO_FECHA);
			fecha = main.scanIn.nextLine();
			System.out.println(CADENA_INTRODUCIDO_MENSAJE + fecha);
		}
		while(validarhoy(fecha) == false) {
			System.out.println(CADENA_ERROR_FORMATO_FECHA);
			System.out.println(CADENA_FORMATO_FECHA);
			fecha = main.scanIn.nextLine();			
			System.out.println(CADENA_INTRODUCIDO_MENSAJE + fecha);

		}
		return fecha;
	}
	
    /**
     * Funcion que le pide los datos al nuevo usuario
     * @param Fecha en formato string
     */
    public void pedir_datos(String Fecha) {
    	String nombre, password, alias;
    	
    	nombre = pedir_nombre();
    	alias = pedir_alias();
    	while(check_existing(alias)==true) {
    		System.out.println(CADENA_USUARIO_EXISTENTE);
    		alias = pedir_alias();
    	}
    	password = pedir_password();
    	
    	setNombre(nombre);
    	setPassword(password);
    	setUsuario(alias);
    	setFecha_nacimiento(Fecha);
    	
    }
    
    /**
     * Funcion que imprime los datos introducidos por el usuario
     */
    public void imprimir_datos() {
    	String nombre, alias, fecha;
    	
    	nombre = getNombre();
    	alias = getUsuario();
    	fecha = getFecha_nacimiento();
    	
    	System.out.println("DATOS DEL USUARIO - N: " + nombre + ", A: " + alias + ", BD: " + fecha);
    	
    }
    
    /**
     * Funcion para crear contraseña
     * @return contraseña
     */
    public static String pedir_password() {
    	
    	String password, password_check;
    	
    	System.out.println(CADENA_INTRODUCE_PASSWORD);
    	password = main.scanIn.nextLine();
    	System.out.println(CADENA_REPITE_PASSWORD);
    	password_check = main.scanIn.nextLine();
    	
    	while(password.length()>=6 || password_check.length()>=6) {
    		while(password.equals(password_check) != true) {
    			System.out.println(CADENA_ERROR_PASSWORD);
    			System.out.println(CADENA_INTRODUCE_PASSWORD);
    			password = main.scanIn.nextLine();
    			System.out.println(CADENA_REPITE_PASSWORD);
    			password_check = main.scanIn.nextLine();
    		}
    		return password;
    	}
    	
    	while(password.length()<6 || password_check.length()<6) {
    		System.out.println(CADENA_PASS_CORTO);
    		System.out.println(CADENA_INTRODUCE_PASSWORD);
    		password = main.scanIn.nextLine();
    		System.out.println(CADENA_REPITE_PASSWORD);
        	password_check = main.scanIn.nextLine();
    		while(password.equals(password_check) != true) {
    			System.out.println(CADENA_ERROR_PASSWORD);
    			System.out.println(CADENA_INTRODUCE_PASSWORD);
    			password = main.scanIn.nextLine();
    			System.out.println(CADENA_REPITE_PASSWORD);
    			password_check = main.scanIn.nextLine();
    		}
    	}
    	
    	return password;
    	
    }
    
    /**
     * Funcion que le pide el nombre al usuario
     * @return String
     */
    public static String pedir_nombre() {
    	
    	String name;
    	
    	System.out.println(CADENA_NOMBRE);
    	name = main.scanIn.nextLine();
    	
    	while(Pattern.matches("[a-zA-Z]+",name) != true) { 
    		System.out.println(CADENA_ERROR_NOMBRE);
    		  name = main.scanIn.nextLine();
    		}
    	
    	System.out.println(CADENA_BIENVENIDO_NOMBRE + name);
    	
    	return name;
    	
    }
    
    /**
     * Funcion que le pide el alias al usuario
     * @return String
     */
    public String pedir_alias() {
    	
    	String alias;
    	
    	System.out.println(CADENA_ALIAS);
    	alias = main.scanIn.nextLine();
    	
    	while(alias.length()<1 == true) {
    		System.out.println(CADENA_ALIAS_CORTO);
    		while(check_existing(alias) == true) {
        		System.out.println(CADENA_ALIAS);
            	alias = main.scanIn.nextLine();
        	}
    	}
    	
    	return alias;
    }

//	---------------		FUNCIONES PARA INVITADO	-----------------	//
	
    /**
     * Funcion para el inicio de sesion del invitado
     * @return boolean
     */
	public static boolean pedir_invitado() {
		boolean flag = false;
		String usuario, password;
		int intentos = 3;
		
		while(intentos > 0) {
			System.out.println(CADENA_INTRODUCE_USUARIO);
			usuario = main.scanIn.nextLine();
			System.out.println(CADENA_INTRODUCE_PASSWORD);
			password = main.scanIn.nextLine();
			
			if(usuario.equals(CADENA_INVITADO) && password.equals(CADENA_INVITADO) == true) {
				System.out.println(CADENA_INICIO_CORRECTO);
				flag = true;
				break;
			}else {
				flag = false;
				intentos = intentos - 1;
				System.out.println(CADENA_INICIO_INCORRECTO + intentos);
			}
			
		}
		return flag;
	}
	
//		---------------		FUNCIONES PARA VALIDAR	-----------------	//

/**
 * Funcion que devuelve si la edad del usuario es apta para jugar al juego.
 * @param fecha_string en formato string
 * @param fechaHoy fecha de hoy
 * @return devuelve un booleano
 */
	public static boolean check_Edad(String fecha_string, LocalDate fechaHoy) {
		boolean flag;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(fecha_string,formatter);
		
		int Edad = Period.between(fecha, fechaHoy).getYears();
		if(Edad>10) {
			System.out.println("Gracias, por confirmarnos tu edad: " + Edad);
			flag = true;
		}else {
			System.out.println(CADENA_EDAD_NO_VALIDA);
			System.out.println("Gracias, por confirmarnos tu edad: " + Edad);
			flag = false;
		}
		return flag;
	}
	
	/**
     * Funcion que valida que la fecha es correcta
     * @param fecha en formato string
     * @return true / false
     */
    public static boolean validarfecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } 
        catch (ParseException e){
            return false;
        }
        return true;
        
    }
    
    /**
     * Funcion que verifica si la fecha es menor que la actual
     * @param fecha_string pasamos la fecha como string
     * @return true/false
     */
    public static boolean validarhoy(String fecha_string) {
        
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = date.parse(fecha_string);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date fechaactual = new Date(System.currentTimeMillis());
        
        if(fechaactual.before(fecha) == true) {
            return false;
        }
        else {
            return true;
        }
    }
//	---------------		FUNCIONES SIN PERSISTENCIA	-----------------	//
    
    /**
     * Funcion que comprueba si el usuario ya es existente
     * @param username usuario
     * @return devuelve un booleano
     */
    public boolean check_existing(String username) {
    	String miusuario;
    	
    	for(int i = 0 ; i < misjugadores.size() ; i++) {
    		Jugador mijugadorauxiliar = misjugadores.get(i);
    		miusuario = mijugadorauxiliar.getUsuario();
    		
    		if(miusuario.equals(username) == true) {
    			System.out.println(CADENA_USER_EXISTENTE);
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    /**
     * Funcion que comprueba si el usuario y la contraseña existen
     * @param username usuario
     * @param password contraseña
     * @return devuelve un booleano
     */
    public boolean check_existing_password(String username, String password) {
    	String mipassword;
    	String miusuario;
    	//System.out.println("este es mi arraysize: " + misjugadores.size());
    	
    	for( int i = 0 ; i < misjugadores.size() ; i++) {
    		Jugador mijugadorauxiliar = misjugadores.get(i);
    		miusuario = mijugadorauxiliar.getUsuario();
    		mipassword = mijugadorauxiliar.getPassword();
    		//System.out.println("miusuario" + miusuario);
    		//System.out.println("que pilla" + mipassword);
    		
    		if(mipassword.equals(password) == true && miusuario.equals(username) == true){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Funcion que añade al usuario
     * @param mijugador añade el jugador nuevo
     */
    public static void add_user(Jugador mijugador) {
    	misjugadores.add(mijugador);
    	
    }
    
    /**
     * Funcion que permite al jugador iniciar sesion
     * @param mijugador pasa por parametros el jugador
     * @return boolean
     */
    public boolean iniciar_sesion(Jugador mijugador) {
    
    	String miusuario, mipassword;
    	boolean flag = false;
    	int intentos = 3;
    	
    	while(intentos > 0) {
			System.out.println(CADENA_INTRODUCE_USUARIO);
			miusuario = main.scanIn.nextLine();
			System.out.println(CADENA_INTRODUCE_PASSWORD);
			mipassword = main.scanIn.nextLine();
			
			if(check_existing_password(miusuario, mipassword) == true) {
				flag = true;
				return flag;
			}else {
				
				intentos = intentos-1;
				System.out.println(CADENA_INICIO_INCORRECTO + intentos);
			}
			
		}
		return flag;
    	
    }
    
//	---------------		FUNCIONES DE PERSISTENCIA	-----------------	//
    /*
    public void escribirEnFichero_puntuacion(Jugador player) throws Exception{
    	File file = new File(fichero_puntuacion);
    	
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    	oos.writeObject("Puntuación de: " + player.nombre + " *** " + player.puntuacion + "***" + "\n");
    	oos.close();
    	
    
    }
    
    public void escribirEnFichero_usuario(Jugador player) throws Exception{
    	File file = new File(fichero_registros);
    	String nombre = player.getUsuario();
    	int puntuacion = player.getPuntuacion();
    	String puntuacion_str = Integer.toString(puntuacion);
    	String escribir = "Puntuación del Usuario " + nombre + " es : " + puntuacion_str + ".";
    	
    	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    	oos.writeObject(escribir);
   
    	oos.close();
    	
    
    }*/

//---------------		GETTERS Y SETTERS	-----------------	//
    
    /**
     * Getter del nombre
     * @return devuelve el nombre
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Setter del nombre
	 * @param nombre pasa por parametro
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter del usuario
	 * @return devuelve el usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Setter del usuario
	 * @param usuario pasa por parametro
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Getter de la contraseña
	 * @return la contraseña
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter de la contraseña
	 * @param password pasa por parametro
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Getter de la fecha de nacimiento
	 * @return devuelve la fecha de nacimiento
	 */
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	/**
	 * Setter de la fecha de nacimiento
	 * @param fecha_nacimiento en formato string pasa por parametro
	 */
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	
	/**
	 * Getter de la puntuacion
	 * @return devuelve la puntuacion
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	
	/**
	 * Setter de la puntuacion
	 * @param puntuacion pasa por parametro
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


    
}
