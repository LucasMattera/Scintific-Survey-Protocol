package tpGrupal;

import java.util.ArrayList;

public class RespuestaSimple extends Respuesta{
	
	private String respuesta ;
	
	public String getRespuesta() {
		return respuesta; 
	}
	
	public RespuestaSimple(String respuesta,Integer desplazamientoDePregunta) {
		this.respuesta = respuesta ;
		this.desplazamientoDePregunta = desplazamientoDePregunta ;
	}
	
	public RespuestaSimple(String respuesta) {
		this.respuesta = respuesta ;
	}

}
