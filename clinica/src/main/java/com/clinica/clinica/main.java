package com.clinica.clinica;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean[][] salas = new boolean[3][3];
		int[] semana = new int[7];
		ArrayList<paciente> pacientes = new ArrayList<>();
		Queue<paciente> fila = new LinkedList<>();
		Stack<paciente> historico = new Stack<>();
		
		int idade = 0;
		int id=0;
		String nome = null;
		String cpf = null;
		String genero = null;
		String observacao;
		boolean sair=false;

		pacientes.add(new paciente(
			    1,
			    "Carlos Silva",
			    "111.111.111-11",
			    35,
			    "Masculino",
			    "Hipertensão"
			));

			pacientes.add(new paciente(
			    2,
			    "Ana Santos",
			    "222.222.222-22",
			    18,
			    "Feminino",
			    "Nenhuma observação"
			));

			pacientes.add(new paciente(
			    3,
			    "Bruno Oliveira",
			    "333.333.333-33",
			    25,
			    "Masculino",
			    "Alergia a medicamento"
			));
		
		
		while(sair==false) {
			System.out.print("\nMENU: "
					+ "\n1 - Cadastrar Paciente"
					+ "\n2 - Buscar Paciente por ID"
					+ "\n3 - Listar Pacientes"
					+ "\n4 - Adicionar paciente na fila"
					+ "\n5 - Consultar próximos pacientes"
					+ "\n6 - Atender paciente"
					+ "\n7 - Exibir fila"
					+ "\n8 - Consultar último atendimento"
					+ "\n9 - Remover último atendimento"
					+ "\n10 - Exibir histórico"
					+ "\n11 - Exibir Salas"
					+ "\n12 - Alterar Status da Sala"
					+ "\n13 - Ordenar Paciente"
					+ "\n14 - Exibir estatísticas\n");
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
				case 4:
					System.out.print("Digite o ID do paciente para adicionar na fila: ");
					int idFila = input.nextInt();
					input.nextLine();
					for (paciente pessoa : pacientes) {
						if (pessoa.getID() == idFila) {
							fila.offer(pessoa);
							System.out.println("Paciente adicionado à fila!");
						}
					}
					break;
					case 5:
					paciente proximo = fila.peek();
					if (proximo != null) {
						System.out.println("Próximo paciente: " + proximo.getNomePaciente());
					} else {
						System.out.println("A fila está vazia!");
					}
					break;
					case 6:
					paciente atendido = fila.poll();
					if (atendido != null) {
						historico.push(atendido);
						System.out.println("Paciente atendido: " + atendido.getNomePaciente());
					} else {
						System.out.println("Não há pacientes na fila!");
					}
					break;
					case 7:
					for (paciente pessoa : fila) {
						System.out.println(pessoa.getNomePaciente());
					}
					break;
					case 8:
					paciente ultimo = historico.peek();
					if (ultimo != null) {
						System.out.println("Último atendimento: " + ultimo.getNomePaciente());
					} else {
						System.out.println("O histórico está vazio!");
					}
					break;
					case 9:
					if (!historico.empty()) {
						paciente removido = historico.pop();
						System.out.println("Atendimento removido: " + removido.getNomePaciente());
					} else {
						System.out.println("O histórico está vazio!");
					}
					break;
					case 10:
					System.out.println("Histórico de atendimentos:");
					for (paciente pessoa : historico) {
						System.out.println(pessoa.getNomePaciente());
					}
					break;
					case 11: 
					System.out.print(" Quadro de salas\n");
					int numSala = 1;
					for (int parte=0; parte<salas.length;parte++) {
						
						for (int sala=0;sala<3;sala++) {
							int status = salas[parte][sala] ? 1 : 0;
			                System.out.print("Sala "+numSala+" - [" + (status==1?"Indisponível":"Disponível") + "] \n");
			                numSala++;
						}
					}
				break;
				case 12:
					
					System.out.print("Qual sala deseja utilizar? \n-> ");
					int numSalaUsar = input.nextInt();
					input.nextLine();
					if(numSalaUsar<=3&&numSalaUsar>0) {
						System.out.print("Sala "+numSalaUsar+" - [" + (salas[0][numSalaUsar-1]  ?"Indisponível":"Disponível") + "] \n");
						numSalaUsar-=1;
						salas[0][numSalaUsar]=(salas[0][numSalaUsar]?false:true);
					}
					else if(numSalaUsar>6&&numSalaUsar<=9) {
						System.out.print("Sala "+numSalaUsar+" - [" + (salas[2][numSalaUsar-7]  ?"Indisponível":"Disponível") + "] \n");
						numSalaUsar-=7;
						salas[2][numSalaUsar]=(salas[2][numSalaUsar]?false:true);
					}
					else if(numSalaUsar<0||numSalaUsar>9) {
						System.out.print("Número de sala invalido\n");
					} else {
						System.out.print("Sala "+numSalaUsar+" - [" + (salas[1][numSalaUsar-4]  ?"Indisponível":"Disponível") + "] \n");
						numSalaUsar-=4;
						salas[1][numSalaUsar]=(salas[1][numSalaUsar]?false:true);
					}
					System.out.print("[ Status da sala alterado para "+ (salas[1][numSalaUsar]  ?"Indisponível":"Disponível") + " ] \n");
				break;
				case 13:
					System.out.print("Qual filtro deseja utilizar? \n1 - Nome\n2 - Idade\n-> ");
					int opcaoOrdenar = input.nextInt();
					input.nextLine();
					
					switch(opcaoOrdenar) {
						case 1:
							System.out.println("Pacientes ordenados por nome:");
							pacientes.sort((p1, p2) -> p1.getNomePaciente().compareToIgnoreCase(p2.getNomePaciente()));
							for (paciente paciente : pacientes) {
								System.out.println(paciente.getID()+" - "+paciente.getNomePaciente());
							}
						break;
						case 2:
							pacientes.sort((p1, p2) ->
						    Integer.compare(p1.getIdade(), p2.getIdade()));
							for (paciente paciente : pacientes) {
								System.out.println(paciente.getID()+" - "+paciente.getNomePaciente()+" - "+ paciente.getIdade()+" anos");
							}
						break;
					}
				break;
				default:
					System.out.println("Opção inválida!");
				break;
				case 14:
					for (int i = 0; i < 7; i++) {
						System.out.print("Digite a quantidade de atendimentos do dia " + (i + 1) + ": ");
						semana[i] = input.nextInt();
					}
					int total = 0;
					for (int i = 0; i < 7 ; i++){
						total = total + semana[i];
					}
					System.out.println("Total de pacientes atendidos: " + total);
					int maior = semana[0];
					for (int i = 1; i < 7; i++) {
						if (semana[i] > maior) {
							maior = semana[i];
						}
					}
					System.out.println("Maior quantidade de atendimentos: " + maior);
					break;
			}
		}
	}
}
