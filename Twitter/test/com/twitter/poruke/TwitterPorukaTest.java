package com.twitter.poruke;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka p=new TwitterPoruka();;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = java.lang.RuntimeException.class) 
	public void testSetKorisnikNull() {
		p=new TwitterPoruka();
		p.setKorisnik(null);
		
	}
	@Test (expected = java.lang.RuntimeException.class) 
	public void testSetKorisnikEmpty() {
		p=new TwitterPoruka();
		p.setKorisnik("");
		
	}
	@Test
	public void testSetKorisnik() {
		
		p.setKorisnik("Nikola");
		assertEquals("Nikola",p.getKorisnik());
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		p.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmpty() {
		p.setPoruka("");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaLong() {
		p.setPoruka("vise od 140 karaktera 11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
	}
	@Test
	public void testSetPoruka() {
		p.setPoruka("Zdravo");
		assertEquals("Zdravo",p.getPoruka());
	}

	@Test
	public void testToString() {
		p.setKorisnik("nikola");
		p.setPoruka("zdravo");
		assertEquals("KORISNIK:nikola PORUKA:zdravo",p.toString());
	}

}
