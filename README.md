# EstruturasDadosEstatica
Exercício com Tipos Genéricos, Tipos Abstratos de Dados, Listas Estáticas, Pilhas e Filas. 

Método 1:  

Na classe que representa uma lista estática, implemente um método RECURSIVO que recebe um elemento por parâmetro e retorna a quantidade de vezes que este elemento aparece na lista. Você deve fazer os métodos público e privado. Você deve utilizar a seguinte assinatura para o método público: 

public int contaElementos(E el) throws IllegalArgumentException 
 
Método 2:  

Implemente em uma classe chamada Metodo2 o seguinte método: public boolean checkBrackets(Stack s1).  

Esse método verifica se uma expressão matemática tem os parênteses agrupados de forma correta, isto é: 

(1) se o número de parênteses à esquerda e à direita é igual; e  

(2) se todo parêntese aberto é seguido, posteriormente, por um fechamento de parêntese.  

Por exemplo, as expressões “((A+B)” e “A+B(” violam a regra (1) e as expressões “)A+B(-C” e “(A+B)) – (C+D” violam a regra (2). Um exemplo de expressão correta seria: “((A+B)-(C+D))”.  

O método recebe como parâmetro uma pilha que contém os caracteres da expressão matemática e retorna verdadeiro, se os parênteses da expressão estão agrupados de forma correta, ou falso, caso contrário. Uma pilha armazena apenas uma única expressão. Utilize o método equals para a comparação dos objetos. As expressões estão armazenadas na pilha da direta para a esquerda, ou seja, os caracteres da direita são empilhados primeiro. 
