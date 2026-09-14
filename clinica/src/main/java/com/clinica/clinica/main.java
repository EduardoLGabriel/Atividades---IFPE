package com.clinica.clinica;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<paciente> pacientes = new ArrayList<>();
		
		System.out.print("MENU: \n1 - Cadastrar Paciente\n2 - Buscar Paciente\n3 - Listar Pacientes\n");
		int opcao = input.nextInt();
		input.nextLine();
		switch(opcao) {
		case 1:
			
			break;
		default:
			break;
		}
	}
}
