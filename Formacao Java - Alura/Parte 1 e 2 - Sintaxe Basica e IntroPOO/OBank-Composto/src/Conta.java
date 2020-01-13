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
	int agencia;
	int numero;
	Cliente titular; // Para conectar o titular a classe cliente
					 // Titular � uma refer�ncia ao objeto cliente criado
	
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
}