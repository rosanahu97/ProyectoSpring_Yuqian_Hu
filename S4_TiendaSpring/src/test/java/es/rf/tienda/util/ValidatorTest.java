package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	final static String ALFANUMERIC="Curso2023";
	final static String ALFANUMERIC_ERROR="Curos234-";
	final static String VACIO="";
	final static String VACIO_ERROR="Hola";
	final static String PHONENUMBER ="12345678912";
	final static String PHONENUMBER_ERROR="12345";
	final static String PHONENUMBER_ERROR_2="holacomoestas";
	final static String EMAIL="curso-2023@gmail.com";
	final static String EMAIL_ERROR="curso!202322";
	final static String EMAIL_ERROR_2="cur@gmail.";
	final static String DNI="23.444.111-G";
	final static String DNI_ERROR="123345566L";
	final static String DNI_ERROR_2="112";
	final static int VALOR=5;
	final static int VALOR_ERROR=15;
	final static int VALOR_MIN=3;
	final static int VALOR_MAX=10;
	final static double VALORDOUBLE=5;
	final static double VALORDOUBLE_ERROR=15;
	final static int LONGITUD_MAX=30;
	final static int LONGITUD_MIN=10;
	final static String TEXTO="HOLA COMO ESTAS?";
	final static String TEXTO_ERROR="HOLA";
	final static LocalDate FECHA_HOY=LocalDate.now();
	final static String FECHA_VALIDA="12/09/2022";
	final static String FECHA_NO_VALIDA="1209/2022";
	final static String PASSWORD="1contRArsen@";
	final static String PASSWORD_ERROR="1234k";
	final static String CODIGO="IN321";
	final static String CODIGO_ERROR="IN3122";
	final static String CODIGO_ERROR_2="in312";
	final static char ESTADO ='A';
	final static char ESTADO_1 ='B';
	final static char ESTADO_ERROR ='a';
	final static char ESTADO_ERROR_1 ='b';
	
	@Test
	void testIsEstadoCorrecto() {
		Assertions.assertTrue(Validator.isEstadoCorrecto(ESTADO));
	}
	@Test
	void testIsEstadoERROR() {
		Assertions.assertFalse(Validator.isEstadoCorrecto(ESTADO_ERROR));
	}
	@Test
	void testIsEstadoCorrecto_1() {
		Assertions.assertTrue(Validator.isEstadoCorrecto(ESTADO_1));
	}
	@Test
	void testIsEstadoERROR_1() {
		Assertions.assertFalse(Validator.isEstadoCorrecto(ESTADO_ERROR_1));
	}

	
	@Test
	void testIsAlfanumeric() {
		Assertions.assertTrue(Validator.isAlfanumeric(ALFANUMERIC));
	}
	@Test
	void testIsAlfanumericError() {
		Assertions.assertFalse(Validator.isAlfanumeric(ALFANUMERIC_ERROR));
	}
	
	@Test
	void testIsCodigoValido() {
		Assertions.assertTrue(Validator.isCodigoValido(CODIGO));
	}
	@Test
	void testIsCodigoValidoError() {
		Assertions.assertFalse(Validator.isCodigoValido(CODIGO_ERROR));
	}
	@Test
	void testIsCodigoValidoError_2() {
		Assertions.assertFalse(Validator.isCodigoValido(CODIGO_ERROR_2));
	}
	
	@Test
	void testIsVacio() {
		Assertions.assertTrue(Validator.isVacio(VACIO));

	}

	@Test
	void testIsVacioError() {
		Assertions.assertFalse(Validator.isVacio(VACIO_ERROR));

	}
	
	@Test
	void testCumplePhoneNumber() {
		Assertions.assertTrue(Validator.cumplePhoneNumber(PHONENUMBER));

	}
	@Test
	void testCumplePhoneNumberError() {
		Assertions.assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_ERROR));

	}
	@Test
	void testCumplePhoneNumberErrorString() {
		Assertions.assertFalse(Validator.cumplePhoneNumber(PHONENUMBER_ERROR_2));

	}

	@Test
	void testIsEmailValido() {
		Assertions.assertTrue(Validator.isEmailValido(EMAIL));
	}
	
	@Test
	void testIsEmailValidoERROR() {
		Assertions.assertFalse(Validator.isEmailValido(EMAIL_ERROR));
	}
	@Test
	void testIsEmailValidoERROR_2() {
		Assertions.assertFalse(Validator.isEmailValido(EMAIL_ERROR_2));
	}
	@Test
	void testCumpleDNI() {
		Assertions.assertTrue(Validator.cumpleDNI(DNI));
	}
	@Test
	void testCumpleDNIError() {
		Assertions.assertFalse(Validator.cumpleDNI(DNI_ERROR));
	}
	@Test
	void testCumpleDNIError_2() {
		Assertions.assertFalse(Validator.cumpleDNI(DNI_ERROR_2));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		Assertions.assertTrue(Validator.cumpleRango(VALOR, VALOR_MIN, VALOR_MAX));
	}
	@Test
	void testCumpleRangoIntIntIntError() {
		Assertions.assertFalse(Validator.cumpleRango(VALOR_ERROR, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntInt() {
		Assertions.assertTrue(Validator.cumpleRango(VALORDOUBLE, VALOR_MIN, VALOR_MAX));

	}
	@Test
	void testCumpleRangoDoubleIntIntError() {
		Assertions.assertFalse(Validator.cumpleRango(VALORDOUBLE_ERROR, VALOR_MIN, VALOR_MAX));
	}

	
	@Test
	void testCumpleLongitud() {
		Assertions.assertTrue(Validator.cumpleLongitud(TEXTO, LONGITUD_MIN, LONGITUD_MAX));

	}
	@Test
	void testCumpleLongitudError() {
		Assertions.assertFalse(Validator.cumpleLongitud(TEXTO_ERROR, LONGITUD_MIN, LONGITUD_MAX));

	}
	
	@Test
	void testValDateMin() {
		Assertions.assertTrue(Validator.valDateMin(FECHA_HOY, FECHA_HOY.minusMonths(1)));

	}
	@Test
	void testValDateMinError() {
		Assertions.assertFalse(Validator.valDateMin(FECHA_HOY.minusMonths(1), FECHA_HOY));

	}
	@Test
	void testValDateMax() {
		Assertions.assertTrue(Validator.valDateMax(FECHA_HOY, FECHA_HOY.plusDays(1)));

	}
	@Test
	void testValDateMaxError() {
		Assertions.assertFalse(Validator.valDateMax(FECHA_HOY.plusDays(1), FECHA_HOY));

	}

	@Test
	void testEsFechaValida() {
		Assertions.assertTrue(Validator.esFechaValida(FECHA_VALIDA));

	}
	@Test
	void testEsFechaValidaError() {
		Assertions.assertFalse(Validator.esFechaValida(FECHA_NO_VALIDA));

	}

	@Test
	void testEsPasswordValida() {
		Assertions.assertTrue(Validator.esPasswordValida(PASSWORD));

	}
	@Test
	void testEsPasswordValidaError() {
		Assertions.assertFalse(Validator.esPasswordValida(PASSWORD_ERROR));

	}

}
