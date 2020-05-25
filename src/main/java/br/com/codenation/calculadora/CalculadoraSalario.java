package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private static long calcularSalarioLiquido(double salarioBase) {
		//Valida se o salario base é maior que salario minimo
		if(salarioBase <= 1039) return 0L;

		//Use o Math.round apenas no final do método para arredondar o valor final.
		double salarioBruttoInss = calcularInss(salarioBase);
		double salarioLiquido = calcularIrrf(salarioBruttoInss);


		return Math.round(salarioLiquido);

	}



	private static double calcularInss(double salarioBase) {
		double salarioDescontado = salarioBase;

		if(salarioBase <= 1500) {
			salarioDescontado -= (salarioBase * 0.08);
		} else if(salarioBase > 1500 && salarioBase <= 4000) {
			salarioDescontado -= (salarioBase * 0.09);
		} else {
			salarioDescontado -= (salarioBase * 0.11);
		}


		return salarioDescontado;
	}


	private static double calcularIrrf(double salarioBrutoInss) {
		double salarioIrrf = salarioBrutoInss;
		if(salarioBrutoInss > 6000) {
			salarioIrrf -= (salarioBrutoInss * 0.15);
		} else if(salarioBrutoInss >= 3000.01 && salarioBrutoInss <= 6000) {
			salarioIrrf -= (salarioBrutoInss * 0.075);
		} else {
			return salarioIrrf;
		}

		return salarioIrrf;
	}

	public static void main(String[] args) {
		System.out.println(calcularSalarioLiquido(8900));
	}

}