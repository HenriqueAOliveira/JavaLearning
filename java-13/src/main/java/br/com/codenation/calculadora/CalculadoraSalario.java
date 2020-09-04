package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double salarioParcial = calcularInss(salarioBase);
		double salarioLiquido = calcularIRFF(salarioParcial);

		if(ehMenorSalarioMinimo(salarioLiquido)){
			return Math.round(0.0);
		} else {
			return Math.round(salarioLiquido);
		}
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double salarioParcial = 0;
		if(salarioBase <= 1500){
			salarioParcial = salarioBase * 0.92;
		} else if(salarioBase > 1500 && salarioBase <= 4000){
			salarioParcial = salarioBase * 0.91;
		} else {
			salarioParcial = salarioBase * 0.89;
		}
		return salarioParcial;

	}

	private double calcularIRFF(double salario) {
		double salarioLiquido = 0.0;
		if(salario <= 3000){
			salarioLiquido = salario;
		} else if(salario > 3000 && salario <= 6000){
			salarioLiquido = salario * 0.925;
		} else {
			salarioLiquido = salario * 0.85;
		}
		return salarioLiquido;
	}

	private boolean ehMenorSalarioMinimo(double salarioLiquido){
		if(salarioLiquido < 1039){
			return true;
		} else {
			return false;
		}
	}

}
