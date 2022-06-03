package br.com.fiap.globalsolution.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Janela {
	JFrame jFrame = new JFrame("Gas Station Manager");		
	JTabbedPane abas = new JTabbedPane();
	JPanel page = new JPanel();		
	JPanel buttonBox = new JPanel();
	JPanel radioBox = new JPanel();
	JPanel inputText = new JPanel();
	JLabel name = new JLabel("Nome");
	JTextField inputName = new JTextField();
	JLabel street = new JLabel("Rua");
	JTextField inputStreet = new JTextField();
	JLabel neighboor = new JLabel("Bairro");
	JTextField inputNeighboor = new JTextField();
	JLabel city = new JLabel("Cidade");
	JTextField inputCity = new JTextField();
	JLabel state = new JLabel("Estado");
	JTextField inputState = new JTextField();	
	StarRater starrater = new StarRater(5);		
	
	JButton save = new JButton("Salvar");
	JButton cancel = new JButton("Cancelar");	
	
	String[] colunas = {"id", "nome","nome","rua","bairro","cidade","estado", "avaliação"};
	String tipoPlug[] = {"tipo1", "tipo2", "CSS2", "CHAdeMO"};
	MeuRadioGroup inputPlug = new MeuRadioGroup(new ArrayList<>(Arrays.asList(tipoPlug)));	
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	
	public Janela() {
		
	}
	
	public void init() {
		page.setLayout(new BoxLayout(page, BoxLayout.X_AXIS));
		
		inputText.setLayout(new BoxLayout(inputText, BoxLayout.Y_AXIS));
		inputText.add(name);
		inputText.add(inputName);
		inputText.add(street);
		inputText.add(inputStreet);		
		inputText.add(neighboor);
		inputText.add(inputNeighboor);
		inputText.setMaximumSize(new Dimension(200,140));	
		
		buttonBox.setLayout(new BoxLayout(buttonBox, BoxLayout.X_AXIS));
				
		//this.save.addActionListener(botaoListener);
		buttonBox.add(save);
		buttonBox.add(cancel);
		inputText.add(buttonBox);		
		inputPlug.setLayout(new BoxLayout(inputPlug, BoxLayout.Y_AXIS));
		radioBox.add(inputPlug);
			
		radioBox.setLayout(new BoxLayout(radioBox, BoxLayout.Y_AXIS));		
		//radioBox.add(radio1);
		//radioBox.add(radio2);
		//radioBox.add(radio3);		
		inputPlug.setLayout(new BoxLayout(inputPlug, BoxLayout.Y_AXIS));
		radioBox.add(new JCheckBox("Teste"));
		radioBox.add(starrater);
		radioBox.setMaximumSize(new Dimension(200,150));
		
		page.add(inputText);	
		page.add(radioBox);	
		page.add(radioBox);	
		
		
		jFrame.add(page);
		abas.addTab("Cadastro", page);
		//abas.addTab("Lista", new JScrollPane(tabela));		
		jFrame.add(abas);	
		jFrame.setSize(600, 400);
		
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jFrame.setVisible(true);
	}	
	
}
