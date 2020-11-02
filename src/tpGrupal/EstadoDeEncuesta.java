package tpGrupal;

public interface EstadoDeEncuesta {
	public Boolean puedeResponder();
	public EstadoDeEncuesta getSiguienteEstado();
	public void agregarPregunta(Pregunta p, Encuesta e);
	public void eliminarPregunta(Pregunta p, Encuesta e) ;
}
