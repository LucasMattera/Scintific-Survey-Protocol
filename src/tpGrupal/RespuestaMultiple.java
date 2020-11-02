package tpGrupal;

import java.util.ArrayList;
 
public class RespuestaMultiple extends Respuesta {
	
	private ArrayList<RespuestaSimple> respuestas = new ArrayList<RespuestaSimple>();
	
	public RespuestaMultiple (ArrayList<RespuestaSimple>respuestas, Integer indice) {
		this.respuestas = respuestas;
		this.desplazamientoDePregunta = indice; 
	}
	
	public RespuestaMultiple (ArrayList<RespuestaSimple>respuestas) {
		this.respuestas = respuestas;
		
	}
	
	
	public ArrayList<RespuestaSimple> getRespuestas(){
		return respuestas;
	}
		
	public void agregarRespuesta(RespuestaSimple rta) {
		respuestas.add(rta);	
	}

	public Integer cantidadDeRespuestas() {
		return respuestas.size();
	}
	
}
