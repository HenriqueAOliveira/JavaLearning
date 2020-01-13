
public class TestaBanco {
	public static void main(String[] args) {
		Cliente Henrique = new Cliente();
		Henrique.cpf = "448.579.918-29";
		Henrique.nome = "Henrique Augusto de Oliveira";
		Henrique.profissao = "Analista de Sistemas";
		
		Conta contaDoHenrique = new Conta();
		contaDoHenrique.depositaDinheiro(100);
		
		contaDoHenrique.titular = Henrique;
		Conta contaDaJucineide = new Conta();
		contaDaJucineide.titular = new Cliente();
		System.out.println(contaDoHenrique.titular.nome);
	}
}
