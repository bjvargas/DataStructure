package rns;

public class Principal {

	public static void main(String[] args) {

		// Primeira parte do trabalho:
		List<Integer> lista = new StaticList<Integer>(11);

		lista.insert(1, 0);
		lista.insert(2, 1);
		lista.insert(3, 2);
		lista.insert(4, 3);
		lista.insert(5, 4);
		lista.insert(13, 5);
		lista.insert(13, 6);
		lista.insert(6, 7);
		lista.insert(6, 8);
		lista.insert(6, 9);
		lista.insert(13, 10);

		int valorChave = 13;

		System.out.println("Existe(m) " + lista.contaElementos(valorChave) + " vezes o valor: '" + valorChave
				+ "' na lista informada.");

		// Segunda parte:
		metodo2();
	}

	private static void metodo2() {
		Metodo2 segundoMetodo = new Metodo2();
		StaticStack<Character> pilhaTrue = new StaticStack<Character>(11);

		pilhaTrue.push(')');
		pilhaTrue.push('D');
		pilhaTrue.push('+');
		pilhaTrue.push('C');
		pilhaTrue.push('(');
		pilhaTrue.push('+');
		pilhaTrue.push(')');
		pilhaTrue.push('B');
		pilhaTrue.push('+');
		pilhaTrue.push('A');
		pilhaTrue.push('(');
		
		StaticStack<Character> pilhaFalse = new StaticStack<Character>(11);

		pilhaFalse.push('(');
		pilhaFalse.push('D');
		pilhaFalse.push('+');
		pilhaFalse.push('C');
		pilhaFalse.push('(');
		pilhaFalse.push('+');
		pilhaFalse.push(')');
		pilhaFalse.push('B');
		pilhaFalse.push('+');
		pilhaFalse.push('A');
		pilhaFalse.push('(');

		StaticStack<Character> pilhaQtdDiferente = new StaticStack<Character>(11);

		pilhaQtdDiferente.push('D');
		pilhaQtdDiferente.push('+');
		pilhaQtdDiferente.push('C');
		pilhaQtdDiferente.push('(');
		pilhaQtdDiferente.push('+');
		pilhaQtdDiferente.push(')');
		pilhaQtdDiferente.push('B');
		pilhaQtdDiferente.push('+');
		pilhaQtdDiferente.push('A');
		pilhaQtdDiferente.push('(');
		
		

		if (segundoMetodo.checkBrackets(pilhaTrue))
			System.out.println("A expressão 1 está correta!");
		else
			System.out.println("A expressão£o está incorreta!");

		if (segundoMetodo.checkBrackets(pilhaFalse))
			System.out.println("A expressão 2 está correta!");
		else
			System.out.println("A expressão£o está incorreta!");
		
		if (segundoMetodo.checkBrackets(pilhaQtdDiferente))
			System.out.println("A expressão 3 está correta!");
		else
			System.out.println("A expressão£o está incorreta!");

	}
}
