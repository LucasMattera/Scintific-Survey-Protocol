package tpGrupal;


public class PreguntaRespuesta  { 
	
	private Pregunta pregunta;
	private Respuesta devolucion;
	
	public PreguntaRespuesta(Pregunta preguntaP, Respuesta devolucion) { 
		this.pregunta = preguntaP; 
		this.devolucion = devolucion; 
		} 
	
	public Pregunta getPregunta() {
		return pregunta;
	}
	
	public  Respuesta getDevolucion() {
		return devolucion;   
	}
}
