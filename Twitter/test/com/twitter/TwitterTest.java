package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	TwitterPoruka p;

	@Before
	public void setUp() throws Exception {
		t= new Twitter();
		p= new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testVratiSvePoruke() {
		LinkedList<TwitterPoruka> tp= new LinkedList<TwitterPoruka>();

		p.setKorisnik("Nikola");
		p.setPoruka("zdravo");
		tp.addLast(p);
		t.unesi(p.getKorisnik(), p.getPoruka());
		assertEquals(tp.toString(), t.vratiSvePoruke().toString());
	}

	@Test
	public void testUnesi() {
		p.setKorisnik("Nikola");
		p.setPoruka("zdravo");
		t.unesi(p.getKorisnik(), p.getPoruka());
		assertEquals(p.toString(), t.vratiSvePoruke().getLast().toString());
	}

	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(1, null);
	}
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeEmpty() {
		t.vratiPoruke(1, "");
	}
	@Test
	public void testVratiPoruke() {
		TwitterPoruka[] n = new TwitterPoruka[3];
		t.unesi("Nikola", "prva Poruka");
		n[0] = t.vratiSvePoruke().getLast();
		t.unesi("Pera", " Poruka dva");
		n[1] = t.vratiSvePoruke().getLast();

		t.unesi("Mika", " cao");
		
		assertEquals(n[0], t.vratiPoruke(3, "Poruka")[0]);
		assertEquals(n[1], t.vratiPoruke(3, "Poruka")[1]);
		assertEquals(n[2], t.vratiPoruke(3, "Poruka")[2]);
	}

}
