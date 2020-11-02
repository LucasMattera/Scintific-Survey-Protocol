package tpGrupal;

import java.util.ArrayList;

public class PreguntaAbierta extends Pregunta {	 
	
	public PreguntaAbierta(String enunciado) {
		super(enunciado);
	}
	
	public void responder(Respuesta rta) { 
		PreguntaRespuesta pr;
		
		if(rta instanceof RespuestaAbierta) {
			if(this.getEncuestaALaQuePertenece().getEstado().puedeResponder()) {
				Encuesta encuesta = this.getEncuestaALaQuePertenece();
				Integer indice = encuesta.getPreguntas().indexOf(this) + rta.getDesplazamiento() ;
				Pregunta siguientePregunta = encuesta.getPreguntas().get(indice) ; 
				this.setindiceDeDesplazamiento(rta.getDesplazamiento());
				encuesta.setPreguntaActual(siguientePregunta);
				pr = new PreguntaRespuesta (this, rta);
				this.notificarObservers(rta);
				encuesta.guardarPreguntaRespondida(pr);
			}
		}	
	}
	
	public ArrayList<Respuesta> getRespuestasEspecificas(){
		return new ArrayList<Respuesta>();
	}
}   
