package com.clinica.clinica;
import java.util.ArrayList;

public class paciente {
		private String nomePaciente;
		private String CPF;
		private int idade;
		private char genero;
		private ArrayList<String> Alergias;
		private String observacoes;
		
		
		public paciente(String nomePaciente, String CPF, int idade, char genero, String observacoes) {
			this.nomePaciente=nomePaciente;
			this.CPF=CPF;
			this.idade = idade;
			this.genero = genero;
			this.observacoes = observacoes;
		}
		
		
}
