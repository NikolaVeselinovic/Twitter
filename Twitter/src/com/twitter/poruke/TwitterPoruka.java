package com.twitter.poruke;
/**
 * 
 * @author Nikola Veselinovic
 * @version 1.0.0
 * Klasa sadrzi podatke o korisniku koji salje poruku,
 * kao i sam sadrzaj poruke.
 *
 */
public class TwitterPoruka {
	/**
	 * Atribut korisnik, tipa String, predstavlja ime i prezime korisnika koji salje poruku.
	 */
	private String korisnik;
	/**
	 *Atribut poruka, tipa String, predstavlja sadrzaj poruke koji korisnik salje. 
	 */
	private String poruka;
	
	/**
	 * Metoda getKorisnik, vraca podatke o korisniku
	 * @return Podaci se vracaju u vidu stringa
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda postavlja korisnika na unetu vrednost.
	 * @param String Prihvata parametar, koji predstavlja ime i prezime korisnika.
	 * <br> Nedozvoljene vrednosti:
	 * <ul>
	 * <li>null
	 * <li>prazan string
	 * </ul> 
	 * @throws RuntimeException Ukoliko se unesu nedozvoljene vrednosti.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || !korisnik.isEmpty())
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda getPoruka, vraca sadrzaj poruke
	 * @return Poruka se vraca u vidu stringa
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * Metoda postavlja poruku na unetu vrednost.
	 * @param String Prihvata parametar, koji predstavlja poruku korisnika.
	 * <br> Nedozvoljene vrednosti:
	 * <ul>
	 * <li>null
	 * <li>prazan string
	 * <li>duzina poruke veca od 140 karaktera
	 * </ul> 
	 * @throws RuntimeException Ukoliko se unesu nedozvoljene vrednosti.
	 */
	public void setPoruka(String poruka) {
		if (this.poruka==null || this.poruka == new String("") ||
				this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Metoda toString, vraca sve podatke o jednoj Twwitter poruci
	 * @return Sadrzaj se vraca u vidu stringa
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
