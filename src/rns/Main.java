package rns;

import rns.help.tree.AVL;
import rns.help.Metodo2;
import rns.help.StaticStack;
import rns.help.tree.Node;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static rns.constants.Operations.DELETE;
import static rns.constants.Operations.END;
import static rns.constants.Operations.INSERT;
import static rns.constants.Operations.SEARCH;

public class Main {
	static Scanner view = new Scanner(System.in);

	public static void main(String[] args) {

		AVL avl = new AVL();
		String run = "GO";
		System.out.println("Por favor, insira o primeiro número, a raíz da árvore.");
		avl.getNodes().add(new Node(getInteger(), null, null, null));

		while(!run.equals(END)) {

			System.out.println("Por favor, informe qual operação deseja realizar: ");
			System.out.println(INSERT);
			System.out.println(DELETE);
			System.out.println(SEARCH);
			System.out.println(END + " para encerrar o programa.");
			run = view.next();
			switch (run.toUpperCase()) {
				case INSERT:
					messageOne(run);
					avl.insert(view.nextInt());
					break;
				case DELETE:
					messageOne(run);
					avl.delete(view.nextInt());
					break;
				case SEARCH:
					messageOne(run);
					avl.search(view.nextInt());
					break;
				case END:
					run = END;
					break;
				default:
					System.out.println("Por favor escolha uma das opções acima");
			}
		}
	}

	private static void messageOne(String run){
		System.out.println("Qual número (nó) deseja " + run + "?");
	}
	private static Integer getInteger() {
		while (true) {
			try {
				return view.nextInt();
			} catch (InputMismatchException e) {
				view.nextLine();
				System.out.println("Valor digitado não é um número inteiro, digite outro valor: ");
			}
		}

	}


//	public static void main(String[] args) {
//
//		// Primeira parte do trabalho:
//		List<Integer> lista = new StaticList<Integer>(11);
//
//		lista.insert(1, 0);
//		lista.insert(2, 1);
//		lista.insert(3, 2);
//		lista.insert(4, 3);
//		lista.insert(5, 4);
//		lista.insert(13, 5);
//		lista.insert(13, 6);
//		lista.insert(6, 7);
//		lista.insert(6, 8);
//		lista.insert(6, 9);
//		lista.insert(13, 10);
//
//		int valorChave = 13;
//
//		System.out.println("Existe(m) " + lista.contaElementos(valorChave) + " vezes o valor: '" + valorChave
//				+ "' na lista informada.");
//
//		// Segunda parte:
//		metodo2();
//	}

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
			System.out.println("A express�o 1 est� correta!");
		else
			System.out.println("A express�o�o est� incorreta!");

		if (segundoMetodo.checkBrackets(pilhaFalse))
			System.out.println("A express�o 2 est� correta!");
		else
			System.out.println("A express�o�o est� incorreta!");
		
		if (segundoMetodo.checkBrackets(pilhaQtdDiferente))
			System.out.println("A express�o 3 est� correta!");
		else
			System.out.println("A express�o�o est� incorreta!");

	}
}
