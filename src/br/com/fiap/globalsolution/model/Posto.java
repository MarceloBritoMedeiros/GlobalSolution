package br.com.fiap.globalsolution.model;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String tipoPlug;
	private int avaliacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getTipoPlug() {
		return tipoPlug;
	}
	public void setTipoPlug(String tipoPlug) {
		this.tipoPlug = tipoPlug;
	}
	
	public Vector<String> getData(){
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(nome);
		data.add(rua);
		data.add(bairro);		
		data.add(cidade);
		data.add(estado);
		data.add(tipoPlug);
		data.add(Integer.toString(avaliacao));
		return data;
		
	}
	
}
