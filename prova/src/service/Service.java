package service;

import java.util.Iterator;
import java.util.Scanner;

import model.Conto;
import model.ListaConti;
import model.ListaUtenti;
import model.Utente;

public class Service {

	ListaUtenti lista = new ListaUtenti();
	ListaConti listaC = new ListaConti();
	Scanner s = new Scanner(System.in);
	Scanner s1 = new Scanner(System.in);

	public ListaUtenti popolaConti() {

		Utente u1 = new Utente("Mario", "Rossi", 22);
		Utente u2 = new Utente("Anna", "Biancon", 18);

		Conto c1 = new Conto(5450, u1);
		Conto c2 = new Conto(3200, u2);

		listaC.add(c1);
		listaC.add(c2);

		System.out.println("La lista di default è: ");

		for (int i = 0; i < listaC.size(); i++) {
			System.out.println(listaC.get(i) + " ");
		}

		return null;

	}

	public ListaUtenti aggiungiAllaLista() {

		System.out.println("Scegli un numero di Utenti da aggiungere compreso tra 1 e 10? ");
		int numero = s.nextInt();
		s.nextLine();

		if (numero == 0 || numero >= 10) {
			System.out.println("Inserimento non consentito");
		} else {
			System.out.println("Inserimento consentito");

			for (int i = 1; i <= numero; i++) {
				Utente utente = new Utente();
				System.out.println("Inserisci nome: ");
				String nome = s.nextLine();
				System.out.println("Inserisci cognome: ");
				String cognome = s.nextLine();
				System.out.println("Inserisci età: ");
				int eta = s.nextInt();
				s.nextLine();

				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setEta(eta);
				lista.add(utente);

			}

		}
		System.out.println("Gli utenti aggiunti sono: ");
		for (int i = (lista.size() - numero); i < lista.size(); i++) {
			System.out.println(lista.get(i) + " ");
		}
		return null;
	}

	public Utente scegliUtenteDaNome(String nome) {

		System.out.println("Inserire il nome dell'utente da ricercare: ");
		if (s.hasNextLine()) {
			nome = s.nextLine();

			for (Utente utente : lista) {
				if (utente.getNome().equalsIgnoreCase(nome)) {
					System.out.println("L'utente scelto è: " + utente.getNome() + " " + utente.getCognome()
							+ ", di anni: " + utente.getEta());

				}
			}
		}
		System.out.println("Fine operazione");
		return null;
	}

	public ListaConti creaConto() {
		Conto conto = new Conto();
		Utente u= new Utente();

		System.out.println("Crea nuovo Conto: ");

		System.out.println("Inserisci saldo: ");
		double saldo = s.nextInt();
		s.nextLine();
		System.out.println("Inserisci nome : ");
		String nome = s.nextLine();
		System.out.println("Inserisci cognome : ");
		String cognome = s.nextLine();
		System.out.println("Inserisci età : ");
		int eta = s.nextInt();

		u.setNome(nome);
		u.setCognome(cognome);
		u.setEta(eta);
		
		conto.setUtente(u);
		conto.setSaldo(saldo);
		listaC.add(conto);
		System.out.println("Il nuovo conto è: " + conto);
		return null;

	}


	public Conto versamento() {
		String nome;

		System.out.println("Inserire il nome dell'utente che deve versare: ");
		if (s.hasNextLine()) {
			nome = s.nextLine();

			for (Conto c : listaC) {
				if (c.getUtente().getNome().equalsIgnoreCase(nome)) {
					System.out.println("L'utente scelto è: " + c.getUtente().getNome() + " "
							+ c.getUtente().getCognome() + ", di anni: " + c.getUtente().getEta());
					System.out.println("La somma da versare è: ");
					int sommaVersata = s.nextInt();
					s.nextLine();

					int nuovoSaldo = (int) (sommaVersata + c.getSaldo());
					System.out.println("Il nuovo saldo è: " + nuovoSaldo);

				}
			}
		}
		return null;
	}

	public Conto prelievo() {
		String nome;

		System.out.println("Inserire il nome dell'utente che deve prelevare: ");
		if (s.hasNextLine()) {
			nome = s.nextLine();

			for (Conto c : listaC) {
				if (c.getUtente().getNome().equalsIgnoreCase(nome)) {
					System.out.println("L'utente scelto è: " + c.getUtente().getNome() + " "
							+ c.getUtente().getCognome() + ", di anni: " + c.getUtente().getEta());
					System.out.println("La somma da prelevare è: ");
					int sommaPrelevata = s.nextInt();
					s.nextLine();
					s.close();

					if (sommaPrelevata < c.getSaldo()) {
						int nuovoSaldo = (int) (c.getSaldo() - sommaPrelevata);
						System.out.println("Il nuovo saldo è: " + nuovoSaldo);
					} else {
						System.out.println("Operazione non ammessa, il saldo residuo è di: " + c.getSaldo());

					}
				}
			}

		}
		return null;

	}
	
	public ListaConti eliminaConto(){

		System.out.println("Si desidera eliminare un conto? true/false");
		boolean b = s.nextBoolean();

		if (b == true) {
			System.out.println("Scegliere il conto da eliminare, digitando il nome dell'utente desiderato: ");
			String nome = s1.nextLine();
			s.close();

			for (Iterator<Conto> iterator = listaC.iterator(); iterator.hasNext();) {
				Conto c = iterator.next();
				if (nome.equals(c.getUtente().getNome())) {
					iterator.remove();
					System.out.println("Utente: " + c.getUtente() + " rimosso");
					System.out.println("la nuova lista è:" + listaC);
				}
				
			}
		}else{
			System.out.println("Operazione completata, arrivederci");

		}
		
		return null;
	}
}
