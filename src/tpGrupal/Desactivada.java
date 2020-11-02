package tpGrupal;

public class Desactivada implements EstadoDeEncuesta{
	
	public Boolean puedeResponder() {
		return false;
	}
	
	public void agregarPregunta(Pregunta p, Encuesta e){
	}
	
	public void eliminarPregunta(Pregunta p, Encuesta e) {
	}
	
	public EstadoDeEncuesta getSiguienteEstado() {
		return new Desactivada();
	}
}
