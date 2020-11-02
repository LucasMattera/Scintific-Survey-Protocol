package tpGrupal;

public class Activa implements EstadoDeEncuesta{

	
	public Boolean puedeResponder() {
		return true;
	}
	
	public void agregarPregunta(Pregunta p, Encuesta e){
	}
	
	public void eliminarPregunta(Pregunta p, Encuesta e) {
	}
	
	public EstadoDeEncuesta getSiguienteEstado() {
		return new Desactivada();
	}
}
