package tpGrupal;

import java.util.List;

public class EncuestaFinalizada {
	private List<PreguntaRespuesta> preguntasRespondidas;
	private Proyecto proyecto;
	
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public EncuestaFinalizada(List<PreguntaRespuesta> pr, Proyecto p) {
		preguntasRespondidas = pr;
		proyecto = p;
		
	}
	
	public List<PreguntaRespuesta> getPreguntasRespondidas(){
		return preguntasRespondidas;
	}

}
