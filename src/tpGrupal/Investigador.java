package tpGrupal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Investigador implements Observer { 
	
	private List<DatosDePregunta> datosDePreguntasDeInteres = new ArrayList<DatosDePregunta>() ;
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private List<Pregunta> preguntasImportantes = new ArrayList<Pregunta>();
	private List<Respuesta> respuestasEspecificas = new ArrayList<Respuesta>();
	private Criterio criterioDeOrdenamiento;
	
	
	public Investigador (ArrayList<Proyecto>proyectos) {
		this.proyectos = proyectos;	
	}
	
	public List<Proyecto> getProyectos() { 
		return proyectos ;
	}
	
	public void guardarProyecto(Proyecto proyectoNuevo) {
		proyectos.add(proyectoNuevo) ; 
	}
	
	public void desactivarEncuesta(Encuesta encuesta) {
		encuesta.getProyectoDePertenencia().desactivarEncuesta(encuesta);
	}
	
	public DatosDePregunta getDatosDeUnaPregunta(Pregunta p) {
		DatosDePregunta ret = datosDePreguntasDeInteres.get(0);
		for(DatosDePregunta dato : datosDePreguntasDeInteres) {
			if(dato.getPregunta() == p) {
				ret = dato; 
			}
		}
		return ret;
	}
	
	public void notificar(Pregunta preguntaSujeto, Respuesta rta) {
		DatosDePregunta dato = new DatosDePregunta(preguntaSujeto, rta, preguntaSujeto.getEncuestaALaQuePertenece());
		if(this.respuestasEspecificas.contains(rta) || this.preguntasImportantes.contains(preguntaSujeto)){
			datosDePreguntasDeInteres.add(dato);
		}
	}
	
	public void cambiarEstado(Encuesta encuesta) {
		encuesta.setEstado();
	}

	public void setPreguntasImportantes(ArrayList<Pregunta> pDeInt) {
		preguntasImportantes.addAll(pDeInt);
	}

	public void setRespuestasEspecificas(ArrayList<Respuesta> rDeInt) {
		respuestasEspecificas.addAll(rDeInt);	
	}

	public Criterio getCriterioDeOrdenamiento() {
		return criterioDeOrdenamiento;
	}

	public void setCriterioDeOrdenamiento(Criterio criterioDeOrdenamiento) {
		this.criterioDeOrdenamiento = criterioDeOrdenamiento;
	}
	
	public void ordenarSegun(Criterio c) {
		this.setCriterioDeOrdenamiento(c);
		
		this.criterioDeOrdenamiento.devolverEncuestasPorCriterio(this);
	}
	
}
