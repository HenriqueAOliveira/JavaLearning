
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		conta.setNumero(1200);
		System.out.println(conta.getNumeroConta());
		
		Cliente henrique = new Cliente();
		
		conta.setTitular(henrique);
		
		henrique.setNome("Henrique Augusto de Oliveira");
		
		conta.getTitular().setNome("Henrique");
	}
}
