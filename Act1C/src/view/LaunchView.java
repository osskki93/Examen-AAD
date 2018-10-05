package view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LaunchView extends JFrame {

	private JButton comparar,buscar;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra;
	private JLabel label_f1,label_f2,label_pal;
	private JCheckBox primera;
	
	private JPanel panel;
	private JButton guardarLibro;
	private JButton listarLibros;
	private JLabel lblIdABuscar;
	
	private JTextField txtAnyoBuscar;
	private JButton buscarLibro;
	private JPanel panel_1;
	private JTextField txtAutor;
	private JTextField txtAnyo;
	private JTextField txtEditor;
	private JTextField txtId;
	private JTextField txtNumPags;
	private JTextField txtTitulo;
	private JLabel lblAnyoABuscar;
	private JTextField textFieldAnyoBuscar;
	
	public LaunchView() {
		
		setBounds(200,200,1010,594);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Num letras:");
		label_pal = new JLabel("Palabra:");
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setEditable(false);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		
		listarLibros = new JButton("Listar todos los Libros");
		listarLibros.setPreferredSize(new Dimension(150, 26));
		panel.add(listarLibros);
		
		buscarLibro = new JButton("Buscar por año");
		buscarLibro.setPreferredSize(new Dimension(150, 26));
		panel.add(buscarLibro);
		
		lblIdABuscar = new JLabel("ID a buscar: ");
		panel.add(lblIdABuscar);
		
		txtAnyoBuscar = new JTextField("", 10);
		panel.add(txtAnyoBuscar);
		
		lblAnyoABuscar = new JLabel("Año a buscar:");
		panel.add(lblAnyoABuscar);
		
		textFieldAnyoBuscar = new JTextField();
		panel.add(textFieldAnyoBuscar);
		textFieldAnyoBuscar.setColumns(10);
		panel.add(textArea);
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel, BorderLayout.CENTER);
        
        panel_1 = new JPanel();
        panel.add(panel_1);
        
        txtAutor = new JTextField();
        txtAutor.setColumns(10);
        
        txtAnyo = new JTextField();
        txtAnyo.setColumns(10);
        
        txtEditor = new JTextField();
        txtEditor.setColumns(10);
        
        txtId = new JTextField();
        txtId.setColumns(10);
        
        JLabel lblId = new JLabel("Ident: ");
        
        JLabel lblAutor = new JLabel("Autor: ");
        lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel lblAnyo = new JLabel("A\u00F1o: ");
        lblAnyo.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel lblEditor = new JLabel("Editor: ");
        lblEditor.setHorizontalAlignment(SwingConstants.LEFT);
        
        guardarLibro = new JButton("A\u00F1adir Nuevo Libro");
        guardarLibro.setPreferredSize(new Dimension(150, 26));
        
        JLabel lblPaginas = new JLabel("N\u00FAm p\u00E1gs: ");
        
        txtNumPags = new JTextField();
        txtNumPags.setColumns(10);
        
        JLabel lblTitulo = new JLabel("T\u00EDtulo: ");
        
        txtTitulo = new JTextField();
        txtTitulo.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(lblId)
        								.addComponent(lblAutor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addGap(24)
        							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(gl_panel_1.createSequentialGroup()
        									.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(lblAnyo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_panel_1.createSequentialGroup()
        									.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        									.addGap(11)
        									.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblEditor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGap(4)
        							.addComponent(txtEditor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblPaginas)
        							.addGap(4)
        							.addComponent(txtNumPags, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
        					.addComponent(guardarLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(73))))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblId))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblAutor)
        						.addComponent(txtAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblAnyo)))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblTitulo))
        					.addGap(32)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblEditor)
        					.addComponent(txtEditor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblPaginas))
        				.addComponent(txtNumPags, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(guardarLibro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(43))
        );
        panel_1.setLayout(gl_panel_1);
		
	}	
	
	public JLabel getLabel_f1() {
		return label_f1;
	}

	public void setLabel_f1(JLabel label_f1) {
		this.label_f1 = label_f1;
	}

	public JLabel getLabel_f2() {
		return label_f2;
	}

	public void setLabel_f2(JLabel label_f2) {
		this.label_f2 = label_f2;
	}

	public JLabel getLabel_pal() {
		return label_pal;
	}

	public void setLabel_pal(JLabel label_pal) {
		this.label_pal = label_pal;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JLabel getLblAnyoABuscar() {
		return lblAnyoABuscar;
	}

	public void setLblAnyoABuscar(JLabel lblAnyoABuscar) {
		this.lblAnyoABuscar = lblAnyoABuscar;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}

	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	public JButton getGuardarLibro() {
		return guardarLibro;
	}

	public void setGuardarLibro(JButton guardarLibro) {
		this.guardarLibro = guardarLibro;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtAnyo() {
		return txtAnyo;
	}

	public void setTxtAnyo(JTextField txtAnyo) {
		this.txtAnyo = txtAnyo;
	}

	public JTextField getTxtEditor() {
		return txtEditor;
	}

	public void setTxtEditor(JTextField txtEditor) {
		this.txtEditor = txtEditor;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtNumPags() {
		return txtNumPags;
	}

	public void setTxtNumPags(JTextField txtNumPags) {
		this.txtNumPags = txtNumPags;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}

	public JButton getListarLibros() {
		return listarLibros;
	}

	public void setListarLibros(JButton listarLibros) {
		this.listarLibros = listarLibros;
	}

	public JButton getBuscarLibro() {
		return buscarLibro;
	}

	public void setBuscarLibro(JButton buscarLibro) {
		this.buscarLibro = buscarLibro;
	}

	public JLabel getLblIdABuscar() {
		return lblIdABuscar;
	}

	public void setLblIdABuscar(JLabel lblIdABuscar) {
		this.lblIdABuscar = lblIdABuscar;
	}

	public JTextField getTxtAnyoBuscar() {
		return txtAnyoBuscar;
	}

	public void setTxtAnyoBuscar(JTextField txtAnyoBuscar) {
		this.txtAnyoBuscar = txtAnyoBuscar;
	}

	public JTextField getTextFieldAnyoBuscar() {
		return textFieldAnyoBuscar;
	}

	public void setTextFieldAnyoBuscar(JTextField textFieldAnyoBuscar) {
		this.textFieldAnyoBuscar = textFieldAnyoBuscar;
	}


	
		
}
