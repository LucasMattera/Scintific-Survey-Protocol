package tpGrupal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Encuesta { 
	
	private List<Pregunta> preguntas;
	private Pregunta preguntaActual;
	private Integer cantidadDeUsos = 0;
	private Proyecto proyecto; 
	private EstadoDeEncuesta estado;
	private List<PreguntaRespuesta> preguntasRespondidas;
	private Integer añoCreacion;

	public Encuesta (ArrayList <Pregunta> preguntasP) { 
		this.preguntas = preguntasP;
		this.setEncuestaParaPreguntas(preguntasP);	 	
		this.preguntaActual = preguntas.get(0);   
		this.estado = new EnEdicion();
		this.preguntasRespondidas = new ArrayList<PreguntaRespuesta>();
	}
	
	public Encuesta (ArrayList <Pregunta> preguntasP,Integer añoCreacion) { 
		this.preguntas = preguntasP;
		this.setEncuestaParaPreguntas(preguntasP);	 	
		this.preguntaActual = preguntas.get(0);   
		this.estado = new EnEdicion();
		this.preguntasRespondidas = new ArrayList<PreguntaRespuesta>();
		this.añoCreacion = añoCreacion ;
	}
	
	public Integer getCantidadDeUsos() {
		return cantidadDeUsos;
	}

	public void setCantidadDeUsos(Integer cantidadDeUsos) {
		this.cantidadDeUsos = cantidadDeUsos;
	}
	
	public Integer getAñoCreacion() {
		return añoCreacion ;
	}
    
	public List<Pregunta> getPreguntas() {
		return preguntas;
	} 
	
	public void setPreguntaActual(Pregunta pregunta) {  
		this.preguntaActual = pregunta ;
	}

	public Pregunta getPreguntaActual() {
		return preguntaActual;
	}

	public Pregunta getSiguientePregunta() {
		Integer indice = preguntas.indexOf(preguntaActual)+ preguntaActual.getIndiceDeDesplazamiento();
			return preguntas.get(indice);
	}

	public void completarEn(Proyecto proyecto) {
		EncuestaFinalizada eF ;
		this.cantidadDeUsos += 1;
		eF = new EncuestaFinalizada(this.getPreguntasRespondidas(), proyecto);
		proyecto.agregarEncuestaFinalizada(eF);	
		this.preguntasRespondidas.removeAll(preguntasRespondidas);
	}
		
	public Integer getCantidadDePreguntas() {
		return this.preguntas.size();
	}
	
	public void setEncuestaParaPreguntas(ArrayList<Pregunta> preguntas2) {
		for(Pregunta p : preguntas2) {
			p.setEncuesta(this);
		}
	}

	public void setProyectoDePertenencia(Proyecto proyectoP) {
		this.proyecto = proyectoP;
	}

	public Proyecto getProyectoDePertenencia() {
		return proyecto;
	} 
	
	public EstadoDeEncuesta getEstado() {
		return this.estado;
	}
	
	public void agregarPregunta(Pregunta p) {
		this.estado.agregarPregunta(p, this);
	}
	
	public void eliminarPregunta(Pregunta p) {
		this.estado.eliminarPregunta(p, this);
	}
	
	public Boolean puedeResponder() { 
		return this.estado.puedeResponder(); 
	} 
 
	public List<PreguntaRespuesta> getPreguntasRespondidas() {
		return preguntasRespondidas ;
	}

	public void guardarPreguntaRespondida(PreguntaRespuesta pr) {
		this.preguntasRespondidas.add(pr);
	}

	public void setEstado() {
		estado = estado.getSiguienteEstado();
	}

	
} 