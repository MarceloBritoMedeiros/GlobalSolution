package br.com.fiap.globalsolution.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JRadioButton;

import br.com.fiap.globalsolution.dao.PostoDao;
import br.com.fiap.globalsolution.model.Posto;
import br.com.fiap.globalsolution.view.Janela;

public class ButtonListener implements ActionListener {
	private Janela view;
	private PostoDao postoDao = new PostoDao();

	public ButtonListener(Janela view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Posto posto = new Posto();	
		posto.setNome(new String(view.getInputName().getText()));
		posto.setRua(new String(view.getInputStreet().getText()));
		posto.setBairro(new String(view.getInputNeighboor().getText()));
		posto.setCidade(new String(view.getInputCity().getText()));
		posto.setEstado(new String(view.getInputState().getText()));		
		posto.setAvaliacao(view.getStarrater().getSelection());
		posto.setPrice(Float.parseFloat(view.getInputPrice().getText()));
		JRadioButton radios[] = {view.getTipo1(), view.getTipo2(), view.getChademo(), view.getCss2()};
		String tipoPlug = "";
		for(int i=0;i<4;i++) {
			if(radios[i].isSelected()) {
				tipoPlug+=radios[i].getText()+", ";
			}			
			
		}
		posto.setTipoPlug(tipoPlug);
		System.out.println(tipoPlug);
		
		postoDao.inserir(posto);
		
		view.carregarDados(false);
		
		List<Posto> lista = postoDao.listarTodos();
		for(Posto item : lista) {
			System.out.println(item);
		}		
		
	}
}
