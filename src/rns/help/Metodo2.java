package rns.help;

import rns.interfaces.Stack;

public class Metodo2 {

	public boolean checkBrackets(Stack s1) {
		StaticStack<Character> pilhaAtual = new StaticStack<Character>(11);
		Integer contadorParentesesEsquerda = 0;
		Integer contadorParentesesDireita = 0;

		String expressao = s1.toString();

		for (int i = 0; i < expressao.length(); i++) {

			char x = expressao.charAt(i);

			if (x == '(') {
				contadorParentesesEsquerda++;
				pilhaAtual.push(x);

			}

			if (x == ')') {
				contadorParentesesDireita++;
				pilhaAtual.push(x);

			}

			char verificar;

			if (x == '(') {
				verificar = pilhaAtual.pop();
				if (verificar == ')')
					return false;
			}

		}

		if (pilhaAtual.isEmpty()) {
			return false;
		}

		if (contadorParentesesEsquerda != contadorParentesesDireita) {
			return false;
		}

		return true;

	}

}
