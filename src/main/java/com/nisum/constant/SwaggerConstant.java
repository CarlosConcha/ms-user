package com.nisum.constant;

public class SwaggerConstant {

	private SwaggerConstant() {
		//hidden constructor
	}
	
	public static final String TAG_NAME = "Desafio Nisum";
	public static final String TAG_DESCRIPTION = "Api RestFul de creacion de usuario";
	public static final String OPERATION_SUMMARY = "User";
	public static final String OPERATION_DESCRIPTION = "Este endpoint le permite crear un nuevo usuario enviando una solicitud POST a la URL especificada. La solicitud debe incluir el nombre del usuario, correo electrónico, contraseña y detalles del teléfono. Los detalles del teléfono deben consistir en el número, el código de ciudad y el código de país. La contraseña debe comenzar con 4 a 8 letras seguidos de 1 a 3 numeros";
	public static final String RESPONSE_BAD_REQUEST_DESCRIPTION = "Campos del request mal ingresados.";
	public static final String RESPONSE_FORBIDDEN_DESCRIPTION = "clave secreta demaciado debil.";
	public static final String RESPONSE_CONFLICT_DESCRIPTION = "Correo duplicado.";
}
