package rns;

import rns.service.NodeService;
import rns.tree.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

import static rns.constants.Operations.DELETE;
import static rns.constants.Operations.END;
import static rns.constants.Operations.INSERT;
import static rns.constants.Operations.SEARCH;

public class MainAutomatic {
	static Scanner view = new Scanner(System.in);

	private static NodeService nodeService = new NodeService();

	public static void main(String[] args) {
		Node root = null;
		root =nodeService.insert(root, 5);
		print(root);
		root =nodeService.insert(root, 10);
		print(root);
		root =nodeService.insert(root, 15);
		print(root);
		root =nodeService.delete(root, 10);
		print(root);
	}

	private static void print(Node node) {
		System.out.println("---------");
		System.out.println((nodeService.toTreeString("", true, "", node)));
	}

}
