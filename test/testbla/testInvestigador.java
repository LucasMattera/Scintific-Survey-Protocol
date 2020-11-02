package testbla;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Encuesta;
import tpGrupal.Investigador;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaConOpcionMultiple;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;
import tpGrupal.Respuesta;
import tpGrupal.RespuestaAbierta;
import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;

class testInvestigador {
	
	private Investigador investigador1;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private ArrayList<Proyecto>proyectos = new ArrayList<Proyecto>();
	private ArrayList<Encuesta>encuestas = new ArrayList<Encuesta>();
	private Encuesta encuesta;
	private Encuesta encuesta1;
	private Pregunta pregunta;
	private ArrayList<Pregunta> preguntas;

	@BeforeEach
	void setUp() throws Exception {
		
		preguntas = new ArrayList<Pregunta>();
		 
		pregunta = new PreguntaAbierta("asd?");
		preguntas.add(pregunta);
		preguntas.add(pregunta);
		encuesta = new Encuesta(preguntas) ;	
		encuesta1 = new Encuesta(preguntas) ;	
		encuestas.add(encuesta);
		encuestas.add(encuesta);
		encuestas.add(encuesta1);
		
		
		proyecto1 = new Proyecto ("bla bla","holahola", encuestas);
		proyecto2 = new Proyecto ("2werw","gsdgsd", encuestas);
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		
		investigador1 = new Investigador (proyectos);
	
	}

	@Test
	void testCantidadDeEncuestasDeProyecto() {
		assertEquals (3, proyecto1.getEncuestas().size());
		
	}
	
	@Test
	void testCuandoInvestigadorDesactivaUnaEncuestaEstaCambiaSuEstadoADesactiva() {
		encuesta1.setEstado();
		investigador1.desactivarEncuesta(encuesta1);
		assertFalse(encuesta1.puedeResponder());
	}
	
	@Test
	void testProyectosDeInvestigador() {
		assertEquals (investigador1.getProyectos(),proyectos) ;
	}
	
	@Test
	void testInvestigadorGuardaUnNuevoProyecto() { 
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		Investigador investigador = new Investigador(proyectos);
		investigador.guardarProyecto(proyecto1);
		
		assertTrue(investigador.getProyectos().contains(proyecto1));
	}
	
	@Test
	void testNotificacionDeRespuestaEspecifica() {
		ArrayList<Pregunta> preguntas1 = new ArrayList<Pregunta>() ;
		PreguntaAbierta p = new PreguntaAbierta("asd");
		 PreguntaAbierta p1 = new PreguntaAbierta("asd");
		 PreguntaAbierta p2 = new PreguntaAbierta("asd");
		 PreguntaAbierta p3 = new PreguntaAbierta("asd");
		 PreguntaAbierta p4 = new PreguntaAbierta("asd");
		 RespuestaAbierta r = new RespuestaAbierta("asd");
		 
		 Proyecto proyectoX;
		 ArrayList<Proyecto>proyectosX = new ArrayList<Proyecto>();
		 ArrayList<Encuesta>encuestasX = new ArrayList<Encuesta>();
		 Investigador investigadorX;
		 
		 preguntas1.add(p2) ;
		 preguntas1.add(p1) ; 
		 preguntas1.add(p) ;
		 preguntas1.add(p3) ;
		 preguntas1.add(p4) ;
		 
		 Encuesta encuesta2 = new Encuesta(preguntas1) ;
		 encuestasX.add(encuesta2);
		 proyectoX = new Proyecto("prop", "descr", encuestasX);
		 proyectosX.add(proyectoX);
		 investigadorX = new Investigador(proyectosX);
		 investigadorX.cambiarEstado(encuesta2);
		 
		 ArrayList<Pregunta>pDeInt = new ArrayList<Pregunta>();
		 pDeInt.add(p);
		 
		 ArrayList<Respuesta>rDeInt = new ArrayList<Respuesta>();
		 rDeInt.add(r);
		 
		 investigadorX.setPreguntasImportantes(pDeInt);
		 investigadorX.setRespuestasEspecificas(rDeInt);
		 
		 proyectoX.addInvestigadorInteresado(investigadorX);
		 
		  p.responder(r);
	
		 assertEquals(investigadorX.getDatosDeUnaPregunta(p).getPregunta(), p);
		 assertEquals(investigadorX.getDatosDeUnaPregunta(p).getEncuesta(), encuesta2);
		 assertEquals(investigadorX.getDatosDeUnaPregunta(p).getRespuesta(), r);
	}
	
}
