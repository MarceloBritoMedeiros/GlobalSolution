package br.com.fiap.globalsolution.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.fiap.globalsolution.view.Janela;

public class TableListener  implements MouseListener{
	
private Janela view;
	
	public TableListener(Janela view) {		
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2) {	
			view.carregarDados(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
