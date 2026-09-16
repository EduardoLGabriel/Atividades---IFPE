package com.clinica.clinica;
import java.util.ArrayList;

public class paciente {
		private int ID;
		private String nomePaciente = null;
		private String CPF = null;
		private int idade;
		private String genero = null;
		private String observacoes;
		private boolean menorIdade = false;
		
		public paciente(int ID, String nomePaciente, String CPF, int idade, String genero, String observacoes) {
			this.nomePaciente=nomePaciente;
			this.CPF=CPF;
			this.idade = idade;
			this.genero = genero;
			this.observacoes = observacoes;
			this.ID = ID;
		}
		
		public paciente(int ID, String nomePaciente, String CPF, int idade, String genero, String observacoes, boolean menorIdade) {
			this.nomePaciente=nomePaciente;
			this.CPF=CPF;
			this.idade = idade;
			this.genero = genero;
			this.observacoes = observacoes;
			this.ID = ID;
			this.menorIdade=menorIdade;
		}


		public int getID() {
			return ID;
		}


		public void setID(int iD) {
			ID = iD;
		}


		public String getNomePaciente() {
			return nomePaciente;
		}


		public void setNomePaciente(String nomePaciente) {
			this.nomePaciente = nomePaciente;
		}


		public String getCPF() {
			return CPF;
		}


		public void setCPF(String cPF) {
			CPF = cPF;
		}


		public int getIdade() {
			return idade;
		}


		public void setIdade(int idade) {
			this.idade = idade;
		}


		public String getObservacoes() {
			return observacoes;
		}


		public void setObservacoes(String observacoes) {
			this.observacoes = observacoes;
		}


		public String getGenero() {
			return genero;
		}


		public void setGenero(String genero) {
			this.genero = genero;
		}


		public boolean isMenorIdade() {
			return menorIdade;
		}


		public void setMenorIdade(boolean menorIdade) {
			this.menorIdade = menorIdade;
		}
		
		
}
