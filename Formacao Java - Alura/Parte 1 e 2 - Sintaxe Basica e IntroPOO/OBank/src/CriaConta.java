
public class CriaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 400;
		System.out.println("O saldo da primeira conta � " + primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = primeiraConta.saldo + 200;
		System.out.println("O saldo da segunda conta � "+ segundaConta.saldo +
				" e o valor do saldo da primeira conta � " + primeiraConta.saldo);
		
	}
}
