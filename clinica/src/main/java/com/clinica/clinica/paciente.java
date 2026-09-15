package com.clinica.clinica;
import java.util.ArrayList;

public class paciente {
		private int ID;
		private String nomePaciente;
		private String CPF;
		private int idade;
		private String genero;
		private String observacoes;
		
		
		public paciente(int ID, String nomePaciente, String CPF, int idade, String genero, String observacoes) {
			this.nomePaciente=nomePaciente;
			this.CPF=CPF;
			this.idade = idade;
			this.genero = genero;
			this.observacoes = observacoes;
			this.ID = ID;
		}
		
		
}
