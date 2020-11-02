package testbla;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Encuesta;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaConOpcionMultiple;
import tpGrupal.PreguntaConOpcionSimple;
import tpGrupal.Respuesta;
import tpGrupal.RespuestaSimple;

class testPregunta {

	private Pregunta pregunta;
	private ArrayList<RespuestaSimple> respuestaPosibles = new ArrayList<RespuestaSimple>();
	private RespuestaSimple rta1; 
	private RespuestaSimple rta2;
	
	
	@BeforeEach
	void setUp() throws Exception { 
		rta1 = new RespuestaSimple("rta1");
		rta2 = new RespuestaSimple ("rta2");
		respuestaPosibles.add(rta1);
		respuestaPosibles.add(rta2); 
		pregunta = new PreguntaConOpcionMultiple("enunciado", respuestaPosibles);
	}
	
	@Test 
	void testALaPreguntaSeLePuedeSettearSuEncuesta() {
		PreguntaAbierta pregunta = new PreguntaAbierta("enunciado");
		Pregunta preguntaA = new PreguntaAbierta("enunciado");
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		preguntas.add(pregunta) ;
		preguntas.add(preguntaA) ;
		
		Encuesta encuesta = new Encuesta(preguntas);
		pregunta.setEncuesta(encuesta);
		assertEquals(pregunta.getEncuestaALaQuePertenece(), encuesta);
	}
	
	@Test 
	void testPreguntaSabeAQueEncuestaPertenece() {
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		Pregunta preguntaA = new PreguntaAbierta("enunciado");
		preguntas.add(pregunta);
		preguntas.add(preguntaA);
		
		Encuesta encuesta = new Encuesta(preguntas);
		
		assertEquals(pregunta.getEncuestaALaQuePertenece(), encuesta);
		assertEquals(preguntaA.getEncuestaALaQuePertenece(), encuesta);
	}
	
	@Test
	void testPreguntaConoceSuRespuestaDeterminante() {
		RespuestaSimple rtaDeterminante = new RespuestaSimple("rta");
		PreguntaConOpcionSimple preg = new PreguntaConOpcionSimple("encun", respuestaPosibles, rtaDeterminante);
		assertEquals(preg.getRespuestaDeterminante(), rtaDeterminante);
	}

}
