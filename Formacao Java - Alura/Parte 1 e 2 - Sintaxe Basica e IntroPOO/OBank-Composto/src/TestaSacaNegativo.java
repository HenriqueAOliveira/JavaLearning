
public class TestaSacaNegativo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.depositaDinheiro(200);
	//	System.out.println(conta.saldo);
		
	//	conta.saldo = conta.saldo - 500;
		System.out.println(conta.getSaldo());
	}
}
