
public class TestaMetodo {
	public static void main(String[] args) {
		
		Conta contaTeste = new Conta();
		contaTeste.saldo = 1000;
		
		contaTeste.depositaDinheiro(50);
		boolean saqueDinheiro = contaTeste.sacarDinheiro(2000);
		
		if (saqueDinheiro == false) {
			System.out.println("Deposite dinheiro para poder sacar!");
		} else {
			System.out.println("O saque foi executado com sucesso");
		}
		
		Conta contaDestino = new Conta();
		contaDestino.depositaDinheiro(10000);
		
		contaDestino.transferirDinheiro(100, contaTeste);
		
	}
}
