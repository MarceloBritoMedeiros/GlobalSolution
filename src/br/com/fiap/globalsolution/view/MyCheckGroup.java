package br.com.fiap.globalsolution.view;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MyCheckGroup extends JLabel{
private static final long serialVersionUID = 1L;
	
	private List<String> opcoes;
	private ButtonGroup grupo = new ButtonGroup();	

	public MyCheckGroup(List<String> opcoes) {
		super();
		this.opcoes = opcoes;
		init();
	}
	
	private void init() {
		opcoes.forEach(opcao -> {
			JRadioButton radio = new JRadioButton(opcao);
			this.add(radio);
			grupo.add(radio);
		});
	}
	
	public ButtonGroup getGrupo() {
		return grupo;
	}

	public void setGrupo(ButtonGroup grupo) {
		this.grupo = grupo;
	}
}
