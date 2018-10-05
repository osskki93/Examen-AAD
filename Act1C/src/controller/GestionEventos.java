package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_guardar, actionListener_buscarLibro, actionListener_listarLibros;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_guardar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_guardarLibro();
			}
		};
		view.getGuardarLibro().addActionListener(actionListener_guardar);
		
		actionListener_buscarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				try {
					call_buscarLibro(0);
				} catch (NumberFormatException | ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		view.getBuscarLibro().addActionListener(actionListener_buscarLibro);
		
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				if(call_compararContenido()) {
					view.getTextArea().setText("Los Ficheros son iguales.");
				} else {
					view.getTextArea().setText("Los Ficheros son diferentes.");
				}
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);

		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				view.getTextArea().setText(""+call_buscarPalabra());
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_listarLibros = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				call_listarLibros();
			}
		};
		view.getListarLibros().addActionListener(actionListener_listarLibros);
		
	}

	private boolean call_compararContenido() {
		// TODO: Llamar a la función compararContenido de GestionDatos
		try {
			return model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		} catch (IOException e) {
			view.showError("HA HABIDO UN ERROR");
			return false;
		}
	}

	private void call_buscarPalabra() {

		try {
			return model.buscarPalabra(view.getFichero1().getText(),view.getFichero2().getText());;
		} catch (IOException e) {
			view.showError("HA HABIDO UN ERROR, NO HAY NINGUNA PALABRA CON ESE Nº DE CARACTERES");
		}
	}
	
	private void call_guardarLibro() {
		Libro l1 = new Libro(Integer.parseInt(view.getTxtId().getText()), view.getTxtTitulo().getText(), view.getTxtAutor().getText(), Integer.parseInt(view.getTxtAnyo().getText()), view.getTxtEditor().getText(), Integer.parseInt(view.getTxtNumPags().getText()));
		try {
			model.guardarLibro(l1);
			view.getTextArea().setText("Libro Creado");
			limpiarCadenas();
		} catch (IOException e) {
			e.printStackTrace();
			view.showError("Error al guardar el libro.");
		}
	}
	
	private void call_buscarLibro(int anyoBuscar) throws NumberFormatException, FileNotFoundException, ClassNotFoundException, IOException {
			Libro lib = model.recuperarLibro(Integer.parseInt(view.getTextFieldAnyoBuscar().getText().trim()));
			view.getTextArea().setText(null);
			int i=0;
			try {
				ArrayList<Libro> libros = model.listarLibros();
				Iterator it = libros.iterator();
				while(it.hasNext()) {
					Libro l1 = (Libro) it.next();
					if (view.getTextFieldAnyoBuscar() == view.getTxtAnyo()) {
						i++;
					}
					}
				view.getTextArea().setText("Hay " +i+ " libros con el año" +view.getTextFieldAnyoBuscar());
			} catch (ClassNotFoundException | IOException e) {
				view.showError("Error. No se han encontrado libros con ese año");
				e.printStackTrace();
			}
		
	}
	
	private void call_listarLibros() {
		view.getTextArea().setText(null);
		try {
			ArrayList<Libro> libros = model.listarLibros();
			Iterator it = libros.iterator();
			while(it.hasNext()) {
				Libro l1 = (Libro) it.next();
				view.getTextArea().setText(view.getTextArea().getText() + "Identificador: " + l1.getId() + "\nTítulo: " + l1.getTitulo() + "\nAutor: " + l1.getAutor() + "\nAño: " + l1.getAnyo() + "\nEditor " + l1.getEditor() + "\nNumero de páginas: " + l1.getNumPags());
				view.getTextArea().setText(view.getTextArea().getText() + "\n---------------------------------------------------\n");
				
				}
		} catch (ClassNotFoundException | IOException e) {
			view.showError("Error. No se han podido listar los libros");
			e.printStackTrace();
		}
	}
	
	private void limpiarCadenas() {
		view.getTxtId().setText(null);
		view.getTxtTitulo().setText(null);
		view.getTxtAutor().setText(null);
		view.getTxtAnyo().setText(null);
		view.getTxtEditor().setText(null);
		view.getTxtNumPags().setText(null);
	}

}
