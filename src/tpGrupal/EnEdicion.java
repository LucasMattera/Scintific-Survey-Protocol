package tpGrupal;

public class EnEdicion implements EstadoDeEncuesta{
	
	public Boolean puedeResponder() {
		return false;
	}
	
	public void agregarPregunta(Pregunta p, Encuesta e){
		e.getPreguntas().add(p);
	}
	
	public void eliminarPregunta(Pregunta p, Encuesta e) {
		e.getPreguntas().remove(p);
	}
	
	public EstadoDeEncuesta getSiguienteEstado() {
		return new Activa();
	}
	
}
