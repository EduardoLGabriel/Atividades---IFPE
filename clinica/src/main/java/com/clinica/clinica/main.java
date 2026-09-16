package com.clinica.clinica;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean[][] salas = new boolean[3][3];
		int[] semana = new int[7];
		ArrayList<paciente> pacientes = new ArrayList<>();
		
		int idade = 0;
		int id=0;
		String nome = null;
		String cpf = null;
		
		String genero = null;
		String observacao;
		boolean sair=false;
		
		
		while(sair==false) {
			System.out.print("\nMENU: "
					+ "\n1 - Cadastrar Paciente"
					+ "\n2 - Buscar Paciente por ID"
					+ "\n3 - Listar Pacientes"
					+ "\n4 - Adicionar paciente na fila"
					+ "\n5 - Consultar próximos pacientes"
					+ "\n6 - Atender paciente"
					+ "\n7 - Exibir fila"
					+ "\n8 - Exibir histórico"
					+ "\n9 - Exibir Salas"
					+ "\n10 - Alterar Status da Sala"
					+ "\n11 - Ordenar Paciente po nome"
					+ "\n12 - Ordenar pacientes por idade\n");
			int opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					boolean nomeinValido = true;
					while (nomeinValido) {
						System.out.print("Digite o nome do paciente: \n-> ");
						nome = input.nextLine();
						nomeinValido = !(nome.matches("[a-zA-ZáéíóúàèìòùâêîôûãõäëïöüçÁÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕÄËÏÖÜÇ ]+"));
					}
						
					boolean cpfInvalido = true;
					while (cpfInvalido) {
						System.out.print("Digite o CPF do paciente: \n-> ");
						cpf = input.nextLine();
						cpfInvalido = !(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"));
						if (!(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))) {System.out.println("cpf invalida!");}
					}
					
					boolean idadeInvalida = true;
					boolean menorIdade = false;
					while (idadeInvalida) {
						
						System.out.print("Digite a idade do paciente: \n-> ");
						idade = input.nextInt();
						input.nextLine();
					
						if (idade < 1 && idade > -1) {
							int meses;
						    System.out.println("\nBebê\n");
						    System.out.print("Digite quantos meses possui: \n-> ");
							meses = input.nextInt();
							input.nextLine();
							menorIdade = true;
							idadeInvalida=false;
						} else if (idade > 140) {
						    System.out.println("Idade invalida!");
						} else if (idade < 0) {
							System.out.println("Idade invalida!");
						} else {
							System.out.println("Idade válida!");
							idadeInvalida=false;
						}
					}
					boolean generoInvalido = true;
					while (generoInvalido) {
						System.out.print("Digite o gênero do paciente: \n-> ");
						genero = input.nextLine();
						switch(genero.toLowerCase()) {
							case "masculino":
								generoInvalido = false;
								break;
							case "feminino":
								generoInvalido = false;
								break;
							case "outro":
								generoInvalido = false;
								break;
							default:
								System.out.println("Gênero inválido!");
								break;
							}
						}
						
						System.out.print("Alguma observação do paciente? \n-> ");
						observacao = input.nextLine();
						if (menorIdade) {pacientes.add(new paciente(id, nome, cpf, idade, genero, observacao, true));} 
						else {
						pacientes.add(new paciente(id, nome, cpf, idade, genero, observacao));
						}
						System.out.print("Paciente cadastrado \nNome: "+nome+"\nCPF: "+cpf+"\nID do paciente: "+id+"\n____________________");
						id++;
					break;
				case 2:
					boolean encontrado = false;
					System.out.print("Qual é o ID do paciente? \n-> ");
					int idPesquisa = input.nextInt();
					input.nextLine();
					for(paciente pessoa:pacientes) {
						if (pessoa.getID()==idPesquisa) {
							System.out.print("_________________ \nNome: "+pessoa.getNomePaciente()+"\nCPF: "+pessoa.getCPF()+"\nID do paciente: "+pessoa.getID()+"\nGênero: "+pessoa.getGenero()+"\nObservações: "+pessoa.getObservacoes()+"\n____________________");
							encontrado = true;
						}
					}
					if (!encontrado) {System.out.print("\n[ID de paciente não encontrado!]");}
					break;
				case 3:
					for(paciente pessoa:pacientes) {
						System.out.print("\n_________________ \nNome: "+pessoa.getNomePaciente()+"\nID do paciente: "+pessoa.getID()+"\n____________________");
					}
					break;
				default:
					break;
			}
		}
	}
}
