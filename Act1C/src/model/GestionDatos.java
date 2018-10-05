package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class GestionDatos {

	public GestionDatos() {

	}

	private FileReader crearFr(String fichero) throws IOException {
		FileReader f1 = new FileReader(fichero);
		return f1;
	}
	
	private void cerrarFr(FileReader f1) throws IOException {
		f1.close();
	}
	
	//TODO: Implementa una función para cerrar ficheros
	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException  {
		
		FileReader f1 = crearFr(fichero1);
		FileReader f2 = crearFr(fichero2);
		
		int a, b;
		
		// Comparamos carácter a carácter los dos ficheros.
		while (((a=f1.read()) != -1) && ((b=f2.read()) != -1)) {
			if (a != b) {
				return false;
			}
		}
		// Confirmamos que ya no podemos leer más de ninguno de los ficheros.
		if (((a=f1.read()) == -1 ) && ((b=f2.read()) == -1)) {
			cerrarFr(f1);
			cerrarFr(f2);
			return true;
		} else {
			cerrarFr(f1);
			cerrarFr(f2);
			return false;
		}
		
	}
	
	public void buscarPalabra (String fichero1, String numLetras) throws IOException{
		FileReader f1 = crearFr(fichero1);
		LineNumberReader b1 = new LineNumberReader(f1);
		
		String cadena = b1.readLine();
		
		Integer.parseInt(cadena);
		Integer.parseInt(numLetras);
		
		while (cadena != null) {
			if (cadena.length() == numLetras.length()) {	
				System.out.println(cadena);
			}
			cadena = b1.readLine();
		}		
	}
	
	public boolean guardarLibro(Libro libro) throws IOException {
		ObjectOutputStream out = null;
		out = new ObjectOutputStream(new FileOutputStream("Libros\\"+libro.getId()+".txt"));		
		out.writeObject(libro);
		cerrar(out);
		return true;		
	}
	
	public Libro recuperarLibro(int anyo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Libro libro = null;
		ObjectInputStream in = null;
		libro = (Libro) in.readObject();
		cerrar(in);
		return libro;
	}
	
	public ArrayList<Libro> listarLibros() throws FileNotFoundException, IOException, ClassNotFoundException {
		Libro libro = null;
		ObjectInputStream in = null;
		ArrayList<Libro> libros= new ArrayList<Libro>();
		File dir = new File("Libros\\");
		String[] ficheros = dir.list();
		
		if (ficheros != null) {
			for (int i=0; i<ficheros.length; i++) {
				in = new ObjectInputStream (new FileInputStream("Libros\\" + ficheros[i]));
				libro = (Libro) in.readObject();
				libros.add(libro);
			}
		}
		return libros;
	}
	
	private boolean cerrar (Closeable IO) {
		try {
			IO.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
