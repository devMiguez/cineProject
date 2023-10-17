package com.cinema.cinema.entities;

import lombok.Data;

@Data
public abstract class Cinema {
	private String nome;
	private Endereco endereco;
	private String cnpj;
	private String razaoSocial;

	public Cinema(String nome, Endereco endereco, String cnpj, String razaoSocial) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

}
