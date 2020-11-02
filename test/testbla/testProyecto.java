package testbla;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import tpGrupal.Activa;
import tpGrupal.Desactivada;
import tpGrupal.Encuesta;
import tpGrupal.EncuestaFinalizada;
import tpGrupal.Investigador;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.PreguntaRespuesta;
import tpGrupal.Proyecto;
import tpGrupal.RespuestaMultiple;
import tpGrupal.RespuestaSimple;
import tpGrupal.VeinteCreadasUltimamente;

class testProyecto { 
	
	private Proyecto proyecto1;
	private PreguntaAbierta preguntaAbierta;
	private RespuestaSimple respuesta1;
	private PreguntaRespuesta preguntaRespuesta;
	
	private RespuestaMultiple listaRespuestas;
	private ArrayList <Encuesta>encuestas = new ArrayList<Encuesta>();
	
	private Encuesta encuesta1;
	
	private ArrayList<RespuestaSimple> lsRespuestas = new ArrayList<RespuestaSimple>();
	
	
	
	private ArrayList <Pregunta>preguntas = new ArrayList<Pregunta>();
	private ArrayList <PreguntaRespuesta>preguntasRespuestas = new ArrayList<PreguntaRespuesta>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		preguntaAbierta = new PreguntaAbierta ("lol");
		respuesta1 = new RespuestaSimple ("Esta es la respuesta");
		listaRespuestas = new RespuestaMultiple(lsRespuestas);
		
		preguntas.add(preguntaAbierta);
		preguntas.add(preguntaAbierta);
		listaRespuestas.agregarRespuesta(respuesta1);
		encuesta1 = new Encuesta (preguntas);
		preguntaRespuesta = new PreguntaRespuesta(preguntaAbierta,listaRespuestas);
		
		preguntasRespuestas.add(preguntaRespuesta);
		
		encuestas.add(encuesta1);
		
		proyecto1 = new Proyecto ("dasdas", "lassdaso", encuestas ); 
		
		
	}

	@Test 
	void testGetterEncuesta() {
		assertEquals (1, proyecto1.getEncuestas().size());
	}
	
	@Test
	void testProyectoTieneEncuestaFinalizada() {
		EncuestaFinalizada encuesta1 = mock(EncuestaFinalizada.class); 
		
		proyecto1.agregarEncuestaFinalizada(encuesta1);
		
		assertTrue (proyecto1.getEncuestasFinalizadas().contains(encuesta1));
	}
	
	@Test
	void testGetEncuestasACtivas() {
		Encuesta e1 = mock(Encuesta.class);
		when(e1.puedeResponder()).thenReturn(true);
		Encuesta e2 = mock(Encuesta.class);
		when(e2.puedeResponder()).thenReturn(false);
		Encuesta e3 = mock(Encuesta.class);
		when(e3.puedeResponder()).thenReturn(true);
		
		ArrayList<Encuesta> listaEncuestas = new ArrayList<Encuesta>() ;
		listaEncuestas.add(e1); listaEncuestas.add(e2); listaEncuestas.add(e3);
		
		Proyecto p = new Proyecto("adb", "abc", listaEncuestas);
		
		assertTrue(p.getEncuestasActivas().contains(e1));
		assertTrue(p.getEncuestasActivas().contains(e3));
	}
	
	
	@Test
	void testFinalizarProyecto() {
		ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>() ;
		listaPreguntas.add(preguntaAbierta) ;
		listaPreguntas.add(preguntaAbierta) ;
		Encuesta enc = new Encuesta(listaPreguntas) ;
		ArrayList<Encuesta> listaEncuestas = new ArrayList<Encuesta>() ; 
		listaEncuestas.add(enc) ;
		listaEncuestas.add(enc) ;
		Proyecto proyecto = new Proyecto("asd","asd",listaEncuestas) ;
		proyecto.finalizarProyecto();
		assertTrue(proyecto.esFinalizado()) ;
	}
	
	@Test
	void testDosProyectosSeComparanSegunSuInicial() {
		Proyecto p1;
		Proyecto p2;
		
		String a = "a";
		String b = "b";
		
		ArrayList<Encuesta> lsEnc = new ArrayList<Encuesta>();
		Encuesta e = mock(Encuesta.class);
		lsEnc.add(e);
		
		p1 = new Proyecto ("b", "prop", lsEnc);
		p2 = new Proyecto("a", "prop", lsEnc);

		
		assertEquals(p1.getDescripcion().compareTo(p2.getDescripcion()),1);
	}
	
	@Test
	void testProyectoDevuelveLasEncuestasDelMismoAño() {
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>() ;
		preguntaAbierta = mock(PreguntaAbierta.class) ;
		lsPreguntas.add(preguntaAbierta) ;
		Encuesta enc = new Encuesta(lsPreguntas,2019) ; 
		lsEncuestas.add(enc) ; 
		lsEncuestas.add(enc) ; 
		Proyecto p = new Proyecto("asd","asd",lsEncuestas) ;
		
		assertEquals(p.getUltimasEncuestas(2019).size(),2) ;
	}

	@Test
	void testComparacionDeDosProyectos() {
		ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>() ;
		Proyecto p = new Proyecto("b","asd",lsEncuestas) ;
		Proyecto p1 = new Proyecto("a","asd",lsEncuestas) ;
		assertEquals(p.compare(p1),1) ;
	}
	
}
