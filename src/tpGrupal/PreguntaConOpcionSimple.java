package tpGrupal;

import java.util.ArrayList;
import java.util.List;

public class PreguntaConOpcionSimple extends PreguntaConOpcionMultiple{
	
	private RespuestaSimple respuestaDeterminante;

	public PreguntaConOpcionSimple(String enunciado, ArrayList<RespuestaSimple> respuestaPosibles, RespuestaSimple rtaDeterminante) {
		super(enunciado, respuestaPosibles);
		this.respuestaDeterminante = rtaDeterminante;
	}
	 
	public RespuestaSimple getRespuestaDeterminante() {
		return respuestaDeterminante;
	}
	
	public void responder(Respuesta rta) {
		PreguntaRespuesta pr;
		
		if(rta instanceof RespuestaSimple) {
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
}
