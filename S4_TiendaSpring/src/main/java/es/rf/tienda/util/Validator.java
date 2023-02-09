package es.rf.tienda.util;

import java.time.LocalDate;
import java.util.regex.Pattern;



/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicaci�n.
 * 
 *  @version	30/01/2023 
 *  @author 	Yuqian Hu
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z\\s]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * car�cteres alfanum�ricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos
	 * y donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;
	
	/**
	 *Patron para validar el codigo de producto 
	 */
	private final static String CODIGO_PATTERN ="^[A-Z]{2}[0-9]{3}";

	
	/* ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanum�ricos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanum�ricos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanum�ricos. <br> 
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		return !isVacio(texto)&&texto.matches(ALFANUMERIC_PATTERN);
	}
	/* ***************************************************************************************
	 * NOMBRE: isCodigoValido                                                                *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Permite verificar que el codigo generado es correcto 
	 * 
	 * @param codigo String a verificar 
	 * 
	 * @return  true, si cumple solo contiene dos letras y tres numeros. <br> 
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean isCodigoValido(String texto){
		return !isVacio(texto)&&texto.matches(CODIGO_PATTERN);
	}
	
	/**
	 * Permite verificar que el estado recibido es correcto o no
	 * @param estado
	 * @return true,si el valor recibido es igual q A o B 
	 * 			y false en caso contrario
	 * 
	 * */
	
	public static boolean isEstadoCorrecto(char estado) {
		return estado=='A' || estado =='B';
	}
	
	public static boolean isVacio( String prueba ){
		return prueba.isEmpty();
	}
	
	/* ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		El phone number debe tener un total de entre 10 y 20, contando d�gitos y espacios.
	 * 		M�nimo aceptable son 10 d�gitos.
	 * 
	 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 d�gitos. 
	 * 		Puede tener espacios, pero siempre con 10 d�gitos como m�nimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		return !isVacio(phoneNumber) && phoneNumber.matches(PHONE_PATTERN)  ;
	}

	/* ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Comprueba si el email tiene un formato que pueda ser v�lido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea v�lido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		return !isVacio(email)&& email.matches(EMAIL_PATTERN);
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Esta funci�n verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		if(!isVacio(dni)) {
		if(dni.matches(DNI_PATTERN )&& dni.length()==LONGITUD_DNI) {
			//extraer la parte numerica del string
			String parteNumerica = dni.substring(0, (dni.length()-2)).replace(".", "");	
			int numerica = Integer.parseInt(parteNumerica);
			//comprobar la ultima letra 
			if(LETRA_DNI.charAt(numerica%23)==dni.toUpperCase().charAt(LONGITUD_DNI-1)) {
				return true;
			}
		}
		}
		return false ;
		
	}
	

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		
		return valor>valorMinimo && valor<valorMaximo;
		
	}
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		return valor>valorMinimo && valor<valorMaximo;
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud m�nima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(
			String texto, 
			int longitudMinima){
		return !isVacio(texto) && texto.length()>=longitudMinima;
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud m�xima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud m�xima.
	 * FECHA: Enero 2023 
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(
			String texto, 
			int longitudMaxima){
		return !isVacio(texto) && texto.length()<=longitudMaxima;
		
	}


	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores m�ximos y m�nimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Yuqian Hu
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(
			String texto, 
			int longitudMinima, 
			int longitudMaxima){

		return !isVacio(texto) && cumpleLongitudMax(texto, longitudMaxima) && cumpleLongitudMin(texto, longitudMinima);
		

	}
	/**
	 * Valida una fecha calendar con m�nimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		return fecha.isAfter(min) || fecha.isEqual(min);
		
	}
	
	/**
	 * Valida una fecha calendar con m�ximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		return fecha.isBefore(max) || fecha.isEqual(max);
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		return !isVacio(fecha) && fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
		
		
	}
	/**
	 * esFechaActual
	 * Recibe un LocalDate y comprueba si coincide con la fecha actual o no
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaActual(LocalDate fecha){
		return fecha.equals(LocalDate.now());
				
	}

	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contrase�a
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
		return !isVacio(password) &&password.matches(PASSWORD_PATTERN);

	}
}
