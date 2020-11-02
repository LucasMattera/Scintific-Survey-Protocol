package testbla;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Encuesta;
import tpGrupal.IProyecto;
import tpGrupal.Pregunta;
import tpGrupal.PreguntaAbierta;
import tpGrupal.Proyecto;
import tpGrupal.ProyectoGeneral;

class testProyectoGeneral {

	private ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>();
	private ArrayList<Pregunta> lsPreguntas = new ArrayList<Pregunta>();
	private ArrayList<IProyecto> proyectos = new ArrayList<IProyecto>();
	private ArrayList<IProyecto> proyectos2 = new ArrayList<IProyecto>();
	private Pregunta pregunta1;
	private Encuesta encuesta1;
	private Proyecto proyecto;
	private ProyectoGeneral proyectoGeneral2;
	private ProyectoGeneral proyectoGeneral;
	
	@BeforeEach
	void setUp() throws Exception {
		
		pregunta1 = new PreguntaAbierta("enc");
		lsPreguntas.add(pregunta1);
		encuesta1 = new Encuesta(lsPreguntas);
		lsEncuestas.add(encuesta1);
		proyecto = new Proyecto("bla", "bla", lsEncuestas);
		proyectos.add(proyecto);
		proyectos2.add(proyecto);
		proyectos2.add(proyecto);
		proyectoGeneral2 = new ProyectoGeneral(proyectos2);
		proyectos.add(proyecto);
		proyectos.add(proyectoGeneral2);
		proyectoGeneral = new ProyectoGeneral(proyectos);
		
	} 

	@Test
	void testElProyectoTieneXCantidadDeEncuestas() {
		assertEquals(proyecto.getEncuestas().size(), 1);
	}
	
	@Test
	void testProyectoGeneralCalculaSuCantidadDeProyectos() {
		assertEquals(proyectoGeneral.getProyectos().size(), 3);
	}
	
	@Test
	void testProyectoGeneralCalculaSuCantidadDeProyectos2() {
		assertEquals(proyectoGeneral2.getProyectos().size(), 2);
	}
	
	@Test
	void testCuandoFinalizoUnProyectoGeneralSeFinalizanTodosSusSubproyectos() {  //REVISAR
		proyectoGeneral.finalizarProyecto();
		
		assertTrue(proyectoGeneral.esFinalizado());
	}

}
