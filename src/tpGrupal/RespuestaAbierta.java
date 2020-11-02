package tpGrupal;

public class RespuestaAbierta extends Respuesta {
	
private String respuesta ;

	
	public String getRespuesta() {
		return respuesta; 
	}
	

	public RespuestaAbierta(String respuesta) {
		this.respuesta = respuesta ;
	}
	
	public RespuestaAbierta(String respuesta,Integer indice) {
		this.respuesta = respuesta ;
		this.desplazamientoDePregunta = indice;
	}

}
