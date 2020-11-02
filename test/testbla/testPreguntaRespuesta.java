package testbla;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Encuesta;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaConOpcionMultiple;
import tpGrupal.PreguntaConOpcionSimple;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;
import tpGrupal.Respuesta;
import tpGrupal.RespuestaAbierta;
import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;

class testPreguntaRespuesta {  

	// PREGUNTA ABIERTA
	private Pregunta preguntaAbierta;
	private PreguntaRespuesta pregRtaLibre;
	private RespuestaSimple respuestaAbierta;

	// PREGUNTA CON OPCIONES RTA SIMPLE
	private PreguntaConOpcionSimple preguntaDeEleccionSimple;
	private PreguntaRespuesta pregRtaUnica;
 
	// PREGUNTA CON OPCIONES RTA MULTIPLE
	private PreguntaConOpcionMultiple preguntaDeEleccionMultiple;
	private RespuestaMultiple respuestasElegidas;
	private PreguntaRespuesta pregRtaMultiple;

	private RespuestaSimple rta1;
	private RespuestaSimple rta2;
	private RespuestaSimple rta3;
	private RespuestaSimple rtaPUltimaPregunta1;
	private RespuestaSimple rtaPUltimaPregunta2;
	private RespuestaSimple rtaPUltimaPregunta3;
	private ArrayList<RespuestaSimple> posiblesRespuestas = new ArrayList<RespuestaSimple>(); 
	private ArrayList<RespuestaSimple> posiblesRespuestasPUltimaPregunta = new ArrayList<RespuestaSimple>(); 
	
	private RespuestaSimple rtaDeterminante ;
	
	private Encuesta encuesta ;
	
	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>() ;

	@BeforeEach
	void setUp() throws Exception {
		
		rta1 = new RespuestaSimple("rta1");
		rta2 = new RespuestaSimple("rta2");
		rta3 = new RespuestaSimple("rta3");
		
		rtaPUltimaPregunta1 = new RespuestaSimple("rta1",0);
		rtaPUltimaPregunta2 = new RespuestaSimple("rta2",0);
		rtaPUltimaPregunta3 = new RespuestaSimple("rta3",0);
		
		posiblesRespuestasPUltimaPregunta.add(rtaPUltimaPregunta1);
		posiblesRespuestasPUltimaPregunta.add(rtaPUltimaPregunta2);
		posiblesRespuestasPUltimaPregunta.add(rtaPUltimaPregunta3);
		
		posiblesRespuestas.add(rta1);
		posiblesRespuestas.add(rta2);
		posiblesRespuestas.add(rta3);
 
		respuestasElegidas = new RespuestaMultiple(posiblesRespuestas);
		
		respuestasElegidas.agregarRespuesta(rta2);
		respuestasElegidas.agregarRespuesta(rta1);
		respuestasElegidas.agregarRespuesta(rta3);
		
		preguntaAbierta = new PreguntaAbierta("Cual es tu numero preferido?");
		rtaDeterminante = new RespuestaSimple("rta");
		preguntaDeEleccionSimple = new PreguntaConOpcionSimple("encunciado", posiblesRespuestasPUltimaPregunta, rtaDeterminante);
		
		preguntaDeEleccionMultiple = new PreguntaConOpcionMultiple("enunciado", posiblesRespuestas);
		preguntas.add(preguntaDeEleccionMultiple) ;
		preguntas.add(preguntaDeEleccionMultiple) ;
		preguntas.add(preguntaAbierta) ;
		preguntas.add(preguntaDeEleccionMultiple) ;
		preguntas.add(preguntaDeEleccionSimple) ;
		
		encuesta = new Encuesta(preguntas) ; 
	}

//PREGUNTA ABIERTA TESTS-------------------------------------------------------------------------------------
	@Test
	void testConstructorDePreguntaAbierta() {
		preguntaAbierta = new PreguntaAbierta("Cual es tu numero preferido?");

		assertEquals("Cual es tu numero preferido?", preguntaAbierta.getContenido());
	}

	@Test
	void testConstructorDeRtaLibre() {
		respuestaAbierta = new RespuestaSimple("esta es mi respuesta libre");

		assertEquals("esta es mi respuesta libre", respuestaAbierta.getRespuesta()); 
	}

	@Test
	void testConstructorDePreguntaRespuestaSimple() {
		
		respuestaAbierta = new RespuestaSimple("esta es mi respuesta libre");
		respuestasElegidas.agregarRespuesta(respuestaAbierta);

		pregRtaLibre = new PreguntaRespuesta(preguntaAbierta, respuestaAbierta);

		assertEquals(preguntaAbierta, pregRtaLibre.getPregunta());
	}

//PREGUNTA CON OPCIONES RTA SIMPLE TESTS-----------------------------------------------------------------------------
	@Test
	void testConstructorDePregunta() {
		RespuestaSimple rtaDeterminante = new RespuestaSimple("rta");
		preguntaDeEleccionSimple = new PreguntaConOpcionSimple("encunciado", posiblesRespuestas, rtaDeterminante);
		
		assertTrue(preguntaDeEleccionSimple.getRespuestasPosibles().containsAll(posiblesRespuestas));
	}

	@Test 
	void testConstructorDePreguntaRespuesta() {  //CASO BORDE
		/*el juego de opciones para responder la ultima pregunta de una encuesta se debe crear con un
		 * indice de desplazamiento de 0
		 */
		
		pregRtaUnica = new PreguntaRespuesta(preguntaDeEleccionSimple, rtaPUltimaPregunta1);
		
		assertEquals(preguntaDeEleccionSimple, pregRtaUnica.getPregunta());
		assertEquals(pregRtaUnica.getDevolucion(), rtaPUltimaPregunta1);
	}

//PREGUNTA CON OPCIONES RTA MULTIPLE-----------------------------------------------------------------------------
	@Test
	void testConstructorDePreguntaPreguntaEleccMultiple() {
		preguntaDeEleccionMultiple = new PreguntaConOpcionMultiple("enunciado", posiblesRespuestas);
		
		assertEquals("enunciado", preguntaDeEleccionMultiple.getContenido());
		assertEquals(posiblesRespuestas, preguntaDeEleccionMultiple.getRespuestasPosibles());
	}

	@Test
	void testConstructorDePreguntaPreguntaRespuestaMultiple() {
		pregRtaMultiple = new PreguntaRespuesta(preguntaDeEleccionMultiple, respuestasElegidas);
		
		assertEquals(preguntaDeEleccionMultiple, pregRtaMultiple.getPregunta());
		assertEquals(respuestasElegidas, pregRtaMultiple.getDevolucion());
	}

//---------------------------------------------------------------------------------------------------------------------	
	
	@Test
	void testCuandoRespondoUnaPreguntaLaEncuestaQueTieneEsaPReguntaActualizaSuPreguntaActualConLaSiguienteDelProtocolo() {
		PreguntaAbierta preg2 = new PreguntaAbierta("pr_proto");
		PreguntaAbierta preg4 = new PreguntaAbierta("pr_proto");
		PreguntaAbierta preg6 = new PreguntaAbierta("pr_proto");
		
		ArrayList<Pregunta> preguntasNeto = new ArrayList<Pregunta>();
	
		
		preguntasNeto.add(preg2);
		preguntasNeto.add(preg4);
		preguntasNeto.add(preg6);
		
		
		Encuesta enc = new Encuesta(preguntasNeto);
		
		enc.setEstado();
		
		RespuestaAbierta rtaCualquiera = new RespuestaAbierta("bla");
				
		ArrayList<Encuesta> encuestasPipi = new ArrayList<Encuesta>() ; 
		encuestasPipi.add(enc) ;
		Proyecto proy = new Proyecto("s","a",encuestasPipi) ;
		
		preg2.responder(rtaCualquiera);
		
		
		assertEquals(enc.getPreguntaActual(), preg4);
		assertNotEquals(enc.getPreguntaActual(), preg6);
	}
	
  @Test
  void testSeRespondeUnaPreguntaMultipleVaASiguientePreguntaDelProtocolo() {
	  PreguntaConOpcionMultiple preg1 = new PreguntaConOpcionMultiple("asd", posiblesRespuestas) ;
	  ArrayList<RespuestaSimple> respuestas = new ArrayList<RespuestaSimple>() ;
	  respuestas.add(rta1) ;
	  respuestas.add(rta2) ;
	  RespuestaMultiple rtaMul = new RespuestaMultiple(respuestas, 1) ;
	  ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>() ;
	  lsPreguntas.add(preg1) ;
	  lsPreguntas.add(preguntaAbierta) ;
	  Encuesta encuesta1 = new Encuesta(lsPreguntas);
	  encuesta1.setEstado();
	  ArrayList<Encuesta> encuestasPipi = new ArrayList<Encuesta>() ; 
	  encuestasPipi.add(encuesta1) ;
	  Proyecto proy = new Proyecto("s","a",encuestasPipi) ;
	  preg1.responder(rtaMul);
	  assertEquals(encuesta1.getPreguntaActual(),preguntaAbierta) ;
  }

}
