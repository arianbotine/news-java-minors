package br.com.alura.inferenciavariavel;

import java.util.HashMap;

public class Teste {
	//var é uma novidade do java 10 - Inferencia de variaveis
	//var teste = "teste"; Não pode declarar assim a nivel de classe
	public static void main(String[] args) {
		//HashMap<String, String> cpfPorNomes = new HashMap<String, String>();
		//var cpfPorNomes = new HashMap<String, String>();
		var cpfPorNomes = new HashMap<>();
		
		cpfPorNomes.put("Jo�o", "04813189");

		System.out.println(cpfPorNomes);
	}
}
