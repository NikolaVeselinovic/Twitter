package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * @author Nikola Veselinovic
 * @version 1.0
 * Lista poruka
 *
 */
public class Twitter {
	/**
	 * Atribut koji predstavlja listu objekata TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca sve poruke iz liste
	 * @return vraca listu poruka (LinkedList<TwitterPoruka>)
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Unosi novu poruku u listu
	 * @param korisnik Prima parametar sa imenom korisnika
	 * @param poruka Prima parametar sa sadrzajem poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Vraca odredjeni broj poruka koje sadrze tag
	 * @param maxBroj Uneti koliko zelite poruka da se vrati
	 * @param tag Uneti koji tag zelite da sadrzi poruka
	 * @return Vraca listu poruka koje odgovaraju opisu
	 * @throws RuntimeException baca exception ako se ukao tag unese null ili prazan string
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
}