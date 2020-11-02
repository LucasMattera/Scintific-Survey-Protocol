package testbla;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpGrupal.Criterio;
import tpGrupal.Encuesta;
import tpGrupal.EncuestaFinalizada;
import tpGrupal.Investigador;
import tpGrupal.OrdenadasPorProyectos;
import tpGrupal.Proyecto;
import tpGrupal.VeinteCreadasUltimamente;
import tpGrupal.VeinticincoMasUsadas;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class testCriterio {

	private Investigador i;
	private Proyecto pA;
	private Proyecto pB;
	private Proyecto pC;
	private ArrayList<Proyecto> lsProy = new ArrayList<Proyecto>();
	private ArrayList<Encuesta> lsEnc1 = new ArrayList<Encuesta>();
	private ArrayList<Encuesta> lsEnc = new ArrayList<Encuesta>();
	private Encuesta e1;
	private Encuesta e2;
	private Encuesta e3;
	private Encuesta e4;
	private Encuesta e5;
	private Encuesta e6;
	private Encuesta e7;
	private Encuesta e8;
	private Encuesta e9;
	private Encuesta e10;
	private Encuesta e11;
	private Encuesta e12;
	private Encuesta e13;
	private Encuesta e14;
	private Encuesta e15;
	private Encuesta e16;
	private Encuesta e17;
	private Encuesta e18;
	private Encuesta e19;
	private Encuesta e20;
	private Encuesta e21;
	private Encuesta e22;
	private Encuesta e23;
	private Encuesta e24;
	private Encuesta e25;
	private Encuesta e26;
	private Encuesta e27;
	private Encuesta e28;
	
	private Criterio ordenadasPorProyectos = new OrdenadasPorProyectos();
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		e1 = mock(Encuesta.class);
		e2 = mock(Encuesta.class);
		e3 = mock(Encuesta.class);
		
		lsEnc.add(e1);
		lsEnc.add(e2);
		lsEnc.add(e3);
		
		pA = mock(Proyecto.class);
		when(pA.getDescripcion()).thenReturn("a");	
		when(pA.getEncuestas()).thenReturn(lsEnc);
		
		pB = mock(Proyecto.class);
		when(pB.getDescripcion()).thenReturn("b");
		when(pB.getEncuestas()).thenReturn(lsEnc);
		
		pC = mock(Proyecto.class);
		when(pC.getDescripcion()).thenReturn("c");
		when(pC.getEncuestas()).thenReturn(lsEnc);
		

		lsProy.add(pB);
		lsProy.add(pC);
		lsProy.add(pA);
		
		i = new Investigador(lsProy);
	}

	@Test
	void testCriterioDeEncuestasOrdenadasPorProyectosOrdenaLaListaDeProyectosAlfabeticamente() {
		i.ordenarSegun(ordenadasPorProyectos);
		
		assertEquals(i.getProyectos().get(0), pA);
		assertEquals(i.getProyectos().get(1), pB);
		assertEquals(i.getProyectos().get(2), pC);
	}
	
	
	@Test
	void testCriterioDeEncuestas20CreadasUltimamenteAgregaLaMasReciente() {
		ArrayList<Encuesta> lsAux ;
		VeinteCreadasUltimamente veinteCreadas = new VeinteCreadasUltimamente() ;

		ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>() ;
		ArrayList<Encuesta> encuestas1 = new ArrayList<Encuesta>() ;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>() ;
		
		
		
		e1 = mock(Encuesta.class);
		when(e1.getAñoCreacion()).thenReturn(2019);
		e2 = mock(Encuesta.class);
		when(e2.getAñoCreacion()).thenReturn(2018);
		e3 = mock(Encuesta.class);
		when(e3.getAñoCreacion()).thenReturn(2017);
		
		
		encuestas.add(e3) ; encuestas.add(e3) ; encuestas.add(e2) ; encuestas.add(e1) ; encuestas.add(e2) ; encuestas.add(e3) ;
		encuestas.add(e2);encuestas.add(e2) ; encuestas.add(e3);encuestas.add(e2) ; encuestas.add(e2); encuestas.add(e2) ;
		encuestas.add(e3) ; encuestas.add(e3) ; encuestas.add(e3) ; encuestas.add(e3) ; encuestas.add(e3) ;
		
		encuestas1.add(e3) ; encuestas1.add(e3) ; encuestas1.add(e2) ; encuestas1.add(e2) ; encuestas1.add(e2) ; encuestas1.add(e3) ;
		encuestas1.add(e2) ; encuestas1.add(e2) ; encuestas1.add(e2) ; encuestas1.add(e2) ; encuestas1.add(e2) ;
		encuestas1.add(e3) ; encuestas1.add(e3) ; encuestas1.add(e3) ; encuestas1.add(e3) ;
		
		pA = mock(Proyecto.class);	
		when(pA.getEncuestas()).thenReturn(encuestas);
		
		pB = mock(Proyecto.class);
		when(pB.getEncuestas()).thenReturn(encuestas1);
		
		proyectos.add(pB);
		proyectos.add(pA);
		
		i = new Investigador(proyectos);
		i.ordenarSegun(veinteCreadas) ;
		lsAux = veinteCreadas.devolverEncuestasPorCriterio(i) ;
		assertEquals(lsAux.get(0),e1) ;
		assertEquals(lsAux.get(1),e2) ;
		assertEquals(lsAux.get(2),e2) ;
	}
	
	@Test
	void testCriterioDeEncuestasAgrega20CreadasUltimamente() {
		ArrayList<Encuesta> lsAux ;
		VeinteCreadasUltimamente veinteCreadas = new VeinteCreadasUltimamente() ;
		
		pA = mock(Proyecto.class);	
		when(pA.getEncuestas()).thenReturn(lsEnc);
		
		pB = mock(Proyecto.class);
		when(pB.getEncuestas()).thenReturn(lsEnc1);
		
		lsProy.add(pB);
		lsProy.add(pA);
		
		e1 = mock(Encuesta.class);
		when(e1.getAñoCreacion()).thenReturn(2019);
		e2 = mock(Encuesta.class);
		when(e2.getAñoCreacion()).thenReturn(2018);
		e3 = mock(Encuesta.class);
		when(e3.getAñoCreacion()).thenReturn(2017);
		
		
		lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ; lsEnc.add(e1) ;
		lsEnc.add(e1);lsEnc.add(e1) ; lsEnc.add(e1);lsEnc.add(e2) ; lsEnc.add(e2); lsEnc.add(e2) ;
		lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ; lsEnc.add(e3) ;
		
		lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ; lsEnc1.add(e1) ;
		lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ; lsEnc1.add(e2) ;
		lsEnc1.add(e3) ; lsEnc1.add(e3) ; lsEnc1.add(e3) ; lsEnc1.add(e3) ;
		
		i = new Investigador(lsProy);
		i.ordenarSegun(veinteCreadas) ;
		lsAux = veinteCreadas.devolverEncuestasPorCriterio(i) ;
		assertEquals(lsAux.size(),20) ;
	}

	@Test
	void testVeinticincoMasUsadasDevuelveLasVeinticincoMasUsadas() {

	ArrayList<Proyecto> lsProyectos = new ArrayList <Proyecto>();

	ArrayList<Encuesta> lsEncuestas = new ArrayList<Encuesta>();
	ArrayList<Encuesta> lsEncuestas2 = new ArrayList<Encuesta>();

	e1 = mock(Encuesta.class);	
	when(e1.getCantidadDeUsos()).thenReturn(14) ;
	e2 = mock(Encuesta.class);
	when(e2.getCantidadDeUsos()).thenReturn(12) ;
	e3 = mock(Encuesta.class);
	when(e3.getCantidadDeUsos()).thenReturn(6) ;
	e4 = mock(Encuesta.class);	
	when(e4.getCantidadDeUsos()).thenReturn(7) ;
	e5 = mock(Encuesta.class);
	when(e5.getCantidadDeUsos()).thenReturn(5) ;
	e6 = mock(Encuesta.class);
	when(e6.getCantidadDeUsos()).thenReturn(8) ;
	e7 = mock(Encuesta.class);
	when(e7.getCantidadDeUsos()).thenReturn(9) ;
	e8 = mock(Encuesta.class);
	when(e8.getCantidadDeUsos()).thenReturn(2) ;
	e9 = mock(Encuesta.class);
	when(e9.getCantidadDeUsos()).thenReturn(4) ;
	e10 = mock(Encuesta.class);
	when(e10.getCantidadDeUsos()).thenReturn(3) ;
	e11 = mock(Encuesta.class);
	when(e11.getCantidadDeUsos()).thenReturn(2) ;
	e12 = mock(Encuesta.class);
	when(e12.getCantidadDeUsos()).thenReturn(2) ;
	e13 = mock(Encuesta.class);
	when(e13.getCantidadDeUsos()).thenReturn(2) ;
	e14 = mock(Encuesta.class);	
	when(e14.getCantidadDeUsos()).thenReturn(2) ;
	e15 = mock(Encuesta.class);	
	when(e15.getCantidadDeUsos()).thenReturn(2) ;
	e16 = mock(Encuesta.class);
	when(e16.getCantidadDeUsos()).thenReturn(10) ;
	e17 = mock(Encuesta.class);	
	when(e17.getCantidadDeUsos()).thenReturn(4) ;
	e18 = mock(Encuesta.class);	
	when(e18.getCantidadDeUsos()).thenReturn(32) ;
	e19 = mock(Encuesta.class);	
	when(e19.getCantidadDeUsos()).thenReturn(20) ;
	e20 = mock(Encuesta.class);	
	when(e20.getCantidadDeUsos()).thenReturn(6) ;
	e21 = mock(Encuesta.class);	
	when(e21.getCantidadDeUsos()).thenReturn(30) ;
	e22 = mock(Encuesta.class);	
	when(e22.getCantidadDeUsos()).thenReturn(25) ;
	e23 = mock(Encuesta.class);	
	when(e23.getCantidadDeUsos()).thenReturn(12) ;
	e24 = mock(Encuesta.class);	
	when(e24.getCantidadDeUsos()).thenReturn(18) ;
	e25 = mock(Encuesta.class);	
	when(e25.getCantidadDeUsos()).thenReturn(12) ;
	e26 = mock(Encuesta.class);	
	when(e26.getCantidadDeUsos()).thenReturn(16) ;
	e27 = mock(Encuesta.class);	
	when(e27.getCantidadDeUsos()).thenReturn(3) ;
	e28 = mock(Encuesta.class);
	when(e28.getCantidadDeUsos()).thenReturn(1) ;


	lsEncuestas.add(e1);

	lsEncuestas.add(e2);
	

	lsEncuestas.add(e3);
	

	lsEncuestas.add(e4);
	

	lsEncuestas.add(e5);
	

	lsEncuestas.add(e6);
	


	lsEncuestas.add(e7);
	


	lsEncuestas.add(e8);


	lsEncuestas.add(e9);
	

	lsEncuestas.add(e10);

	lsEncuestas.add(e11);
	

	lsEncuestas.add(e12);

	lsEncuestas.add(e13);

	lsEncuestas.add(e14);

	lsEncuestas.add(e15);

	lsEncuestas.add(e16);

	lsEncuestas.add(e17);

	lsEncuestas.add(e18);

	lsEncuestas.add(e19);

	lsEncuestas.add(e20);

	lsEncuestas.add(e21);

	lsEncuestas.add(e22);

	lsEncuestas.add(e23);

	lsEncuestas.add(e24);

	lsEncuestas.add(e25); 

	lsEncuestas2.add(e26);

	lsEncuestas2.add(e27) ;

	lsEncuestas2.add(e28);


	pA = mock(Proyecto.class);
	when(pA.getEncuestas()).thenReturn(lsEncuestas);

	pB = mock(Proyecto.class);
	when(pB.getEncuestas()).thenReturn(lsEncuestas2);

	lsProyectos.add(pA);

	lsProyectos.add(pB);

	i = new Investigador(lsProyectos);

	VeinticincoMasUsadas veinticinco = new VeinticincoMasUsadas();

	i.ordenarSegun(veinticinco);

	assertEquals(veinticinco.devolverEncuestasPorCriterio(i).size() , 25);
	assertEquals(veinticinco.devolverEncuestasPorCriterio(i).get(0), e18);
	}

	@Test
	void testCriterioO() {
		OrdenadasPorProyectos oPP = new OrdenadasPorProyectos() ;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>() ;
		pA = mock(Proyecto.class);
		pB = mock(Proyecto.class);
		proyectos.add(pA) ;
		proyectos.add(pB) ;
		
		Investigador i = new Investigador(proyectos) ;
		i.setCriterioDeOrdenamiento(oPP);
		
		assertTrue(i.getCriterioDeOrdenamiento() instanceof OrdenadasPorProyectos) ;
	}
	
	
	@Test
	void testTodasLasEncuestasDeUnInvestigador() {
		ArrayList<Encuesta> encuestas1 = new ArrayList<Encuesta>(); 
		ArrayList<Encuesta> encuestas2 = new ArrayList<Encuesta>();
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>(); 
		
		Encuesta e1 = mock(Encuesta.class) ;
		Encuesta e2 = mock(Encuesta.class) ;
		Encuesta e3 = mock(Encuesta.class) ;
		Encuesta e4 = mock(Encuesta.class) ;
		encuestas1.add(e1) ; encuestas1.add(e2) ;
		encuestas2.add(e3) ; encuestas2.add(e4) ;
		Proyecto p1 = mock(Proyecto.class) ;
		when(p1.getEncuestas()).thenReturn(encuestas1) ;
		
		Proyecto p2 = mock(Proyecto.class) ;
		when(p2.getEncuestas()).thenReturn(encuestas2) ;
		proyectos.add(p1) ; proyectos.add(p2) ;		
		Investigador i = new Investigador(proyectos) ;
		Criterio c = new VeinticincoMasUsadas() ;
		
		
		assertTrue(c.getTodasLasEncuestasDeUnInvestigador(i).containsAll(encuestas1)) ;
		assertTrue(c.getTodasLasEncuestasDeUnInvestigador(i).containsAll(encuestas2)) ;
		
	}
	
	@Test
	void testAddHastaNEncuestas() {
		ArrayList<Encuesta> encuestas1 = new ArrayList<Encuesta>(); 
		Encuesta e1 = mock(Encuesta.class) ;
		Encuesta e2 = mock(Encuesta.class) ;
		encuestas1.add(e1) ; encuestas1.add(e2) ;
		Criterio c = new VeinticincoMasUsadas() ;
		assertEquals(c.addHastaNEncuestas(encuestas1, 1).size(),1) ;
		assertEquals(c.addHastaNEncuestas(encuestas1, 2).size(),2) ;
	}
	

}
