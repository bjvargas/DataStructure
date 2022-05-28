package rns;

import rns.service.NodeService;
import rns.tree.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

import static rns.constants.Operations.DELETE;
import static rns.constants.Operations.END;
import static rns.constants.Operations.INSERT;
import static rns.constants.Operations.SEARCH;

public class Main {
	static Scanner view = new Scanner(System.in);

	private static NodeService nodeService = new NodeService();

	public static void main(String[] args) {
		Node root = null;
		String run = "GO";
		System.out.println("Por favor, insira o primeiro número, a raíz da árvore.");
		root = nodeService.insert(root, getInteger());

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
					root = nodeService.insert(root, view.nextInt());
					print(root);
					break;
				case DELETE:
					messageOne(run);
					root = nodeService.delete(root, view.nextInt());
					print(root);
					break;
				case SEARCH:
					messageOne(run);
					existValue(root, view.nextInt());
					print(root);
					break;
				case END:
					run = END;
					break;
				default:
					System.out.println("Por favor escolha uma das opções acima");
			}
		}
		view.close();
	}

	public static void testAutomaticMain(String[] args) {
		Node root = null;
		root =nodeService.insert(root, 5);
		print(root);

		root =nodeService.insert(root, 10);
		print(root);

		root =nodeService.insert(root, 15);
		print(root);
	}

	private static void existValue(Node root, Integer value){
		if(nodeService.search(root, value)){
			System.out.println("Valor encontrado!");
		} else {
			System.out.println("Valor " + value + " não encontrado.");
		}
	}
	private static void print(Node node) {
		System.out.println("---------");
		System.out.println((nodeService.toTreeString("", true, "", node)));
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

}
