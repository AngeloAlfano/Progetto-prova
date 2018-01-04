package model;

public class Conto {

	private double saldo;
	private Utente utente;

	public Conto() {
	}
	

	public Conto(double saldo, Utente utente) {
		this.saldo = saldo;
		this.utente = utente;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	@Override
	public String toString() {
		return "Conto [saldo=" + saldo + ", utente=" + utente + "]";
	}


}