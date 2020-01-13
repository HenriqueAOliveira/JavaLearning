/*
A conta do OBank possuir� como atributos:
	- saldo;
	- ag�ncia;
	- n�mero;
	- titular
 
 A��es poss�veis na conta: depositar, sacar e transferir
 
 */

public class Conta {
	
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular; // Para conectar o titular a classe cliente
					 // Titular � uma refer�ncia ao objeto cliente criado
	private static int total;
	
	public Conta() {
		Conta.total++;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
	
	public int getNumeroConta() {
		return this.numero;
	}
	
	public void setNumero(int Numero) {
		this.numero = Numero;
	}
	
	public void depositaDinheiro(double valor) {
		this.saldo += valor;
	}
	
	public boolean sacarDinheiro(double valor) {
		if (this.saldo < valor) {
			System.out.println("Saldo indispon�vel!");
			return false;
		} else {
			this.saldo -= valor;
			System.out.println("O valor sacado � " + valor + " reais");
			return true;
		}
	}
	
	public boolean transferirDinheiro(double valor, Conta contaDestino) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			contaDestino.depositaDinheiro(valor);
			System.out.println("O valor transferido foi de " + valor + " reais.");
			return true;
		} else {
			System.out.println("Saldo insuficiente para transfer�ncia!");
			return false;
		}
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
}