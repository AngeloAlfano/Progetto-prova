package run;

import java.util.Scanner;

import service.Service;

public class Main {
//ciaooooo
	static Service service = new Service();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		service.popolaConti();

		System.out.println("Digitare il numero dell'operazione che si desidera eseguire: ");
		System.out.println("1. Aggiungi uno o più utente alla lista");
		System.out.println("2. Scegli un utente dal nome");
		System.out.println("3. Versamento");
		System.out.println("4. Prelievo");
		System.out.println("5. Crea nuovo conto");
		System.out.println("6. Elimina conto");
		int numero = s.nextInt();

		switch (numero) {
		case 1:
			service.aggiungiAllaLista();

			break;
		case 2:
			service.scegliUtenteDaNome(null);

			break;
		case 3:
			service.versamento();

			break;
		case 4:
			service.prelievo();

			break;
		case 5:
			service.creaConto();

			break;
		case 6:
			service.eliminaConto();

			break;

		default:
			System.out.println("Numero non ammesso");
			break;
		}

	}
}
