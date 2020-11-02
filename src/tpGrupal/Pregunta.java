package tpGrupal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pregunta { 
	
	protected String enunciado ;
	private Encuesta encuestaDePertenencia; 
	private Integer indiceDeDesplazamiento; 
	
	public Pregunta(String enunciado) {  
		this.enunciado = enunciado ;
	}
	
	public String getContenido() {
		return enunciado;
	}

	public Encuesta getEncuestaALaQuePertenece() {
		return encuestaDePertenencia;
	}
	
	public abstract void responder(Respuesta r);
	
	public void setEncuesta(Encuesta encuesta) {
		encuestaDePertenencia = encuesta;
	}

	public void setindiceDeDesplazamiento(Integer indiceDeDesplazamientoP) {
		indiceDeDesplazamiento = indiceDeDesplazamientoP;	
	}
	
	public Integer getIndiceDeDesplazamiento() {
		return indiceDeDesplazamiento ;
	}
	
	public List<Investigador> getObservadoresDeUnProyecto(Pregunta p){
		return p.getEncuestaALaQuePertenece().getProyectoDePertenencia().getInvestigadoresInteresados();
	}

	public void notificarObservers(Respuesta respuesta) { 
		if ( this.getObservadoresDeUnProyecto(this).size() >= 1 ) {
	     for( Investigador i : this.getObservadoresDeUnProyecto(this)) {
			i.notificar(this,respuesta);  
		 }
		}
     }
	
}

