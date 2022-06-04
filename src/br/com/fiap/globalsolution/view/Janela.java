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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import br.com.fiap.globalsolution.controller.ButtonListener;
import br.com.fiap.globalsolution.controller.TableListener;
import br.com.fiap.globalsolution.dao.PostoDao;
import br.com.fiap.globalsolution.model.Posto;


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
	
	String[] colunas = {"id", "nome","rua","bairro","cidade","estado", "tipo plug", "avaliação"};	
	JRadioButton tipo1 = new JRadioButton("tipo1");
	JRadioButton tipo2 = new JRadioButton("tipo2");
	JRadioButton css2 = new JRadioButton("CSS2");
	JRadioButton chademo = new JRadioButton("CHAdeMO");
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
		inputText.add(state);
		inputText.add(inputState);		
		inputText.add(city);
		inputText.add(inputCity);		
		inputText.setMaximumSize(new Dimension(200,210));	
		
		buttonBox.setLayout(new BoxLayout(buttonBox, BoxLayout.X_AXIS));
		ButtonListener botaoListener = new ButtonListener(this);		
		this.save.addActionListener(botaoListener);
				
		buttonBox.add(save);
		buttonBox.add(cancel);
		inputText.add(buttonBox);		
		
		radioBox.add(tipo1);
		radioBox.add(tipo2);
		radioBox.add(css2);
		radioBox.add(chademo);			
		radioBox.setLayout(new BoxLayout(radioBox, BoxLayout.Y_AXIS));		
			
		
		radioBox.add(starrater);
		radioBox.setMaximumSize(new Dimension(200,150));
		
		page.add(inputText);	
		page.add(radioBox);	
		page.add(radioBox);	
		
		List<Posto> lista = new PostoDao().listarTodos();
		lista.forEach(posto -> tableModel.addRow(posto.getData()));	
		
		jFrame.add(page);
		abas.addTab("Cadastro", page);
		abas.addTab("Lista", new JScrollPane(tabela));		
		jFrame.add(abas);	
		jFrame.setSize(600, 400);
		
		TableListener tableListener = new TableListener(this);
		tabela.addMouseListener(tableListener);
		tabela.setDefaultEditor(Object.class, null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jFrame.setVisible(true);
	}
	
	public void carregarDados(boolean ordenar) {
		tableModel.setRowCount(0);
		List<Posto> lista;
		if(ordenar == false) {
			lista = new PostoDao().listarTodos();
		}else {
			lista = new PostoDao().ordenarTodos();
		}
		
		lista.forEach(posto -> tableModel.addRow(posto.getData()));
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JTabbedPane getAbas() {
		return abas;
	}

	public void setAbas(JTabbedPane abas) {
		this.abas = abas;
	}

	public JPanel getPage() {
		return page;
	}

	public void setPage(JPanel page) {
		this.page = page;
	}

	public JPanel getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(JPanel buttonBox) {
		this.buttonBox = buttonBox;
	}

	public JPanel getRadioBox() {
		return radioBox;
	}

	public void setRadioBox(JPanel radioBox) {
		this.radioBox = radioBox;
	}

	public JPanel getInputText() {
		return inputText;
	}

	public void setInputText(JPanel inputText) {
		this.inputText = inputText;
	}

	public JLabel getName() {
		return name;
	}

	public void setName(JLabel name) {
		this.name = name;
	}

	public JTextField getInputName() {
		return inputName;
	}

	public void setInputName(JTextField inputName) {
		this.inputName = inputName;
	}

	public JLabel getStreet() {
		return street;
	}

	public void setStreet(JLabel street) {
		this.street = street;
	}

	public JTextField getInputStreet() {
		return inputStreet;
	}

	public void setInputStreet(JTextField inputStreet) {
		this.inputStreet = inputStreet;
	}

	public JLabel getNeighboor() {
		return neighboor;
	}

	public void setNeighboor(JLabel neighboor) {
		this.neighboor = neighboor;
	}

	public JTextField getInputNeighboor() {
		return inputNeighboor;
	}

	public void setInputNeighboor(JTextField inputNeighboor) {
		this.inputNeighboor = inputNeighboor;
	}

	public JLabel getCity() {
		return city;
	}

	public void setCity(JLabel city) {
		this.city = city;
	}

	public JTextField getInputCity() {
		return inputCity;
	}

	public void setInputCity(JTextField inputCity) {
		this.inputCity = inputCity;
	}

	public JLabel getState() {
		return state;
	}

	public void setState(JLabel state) {
		this.state = state;
	}

	public JTextField getInputState() {
		return inputState;
	}

	public void setInputState(JTextField inputState) {
		this.inputState = inputState;
	}

	public StarRater getStarrater() {
		return starrater;
	}

	public void setStarrater(StarRater starrater) {
		this.starrater = starrater;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JRadioButton getTipo1() {
		return tipo1;
	}

	public void setTipo1(JRadioButton tipo1) {
		this.tipo1 = tipo1;
	}

	public JRadioButton getTipo2() {
		return tipo2;
	}

	public void setTipo2(JRadioButton tipo2) {
		this.tipo2 = tipo2;
	}

	public JRadioButton getCss2() {
		return css2;
	}

	public void setCss2(JRadioButton css2) {
		this.css2 = css2;
	}

	public JRadioButton getChademo() {
		return chademo;
	}

	public void setChademo(JRadioButton chademo) {
		this.chademo = chademo;
	}	
	
	
	
}
