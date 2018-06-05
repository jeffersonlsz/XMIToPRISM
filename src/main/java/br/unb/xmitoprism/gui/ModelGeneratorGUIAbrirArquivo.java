package br.unb.xmitoprism.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ModelGeneratorGUIAbrirArquivo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelGeneratorGUIAbrirArquivo frame = new ModelGeneratorGUIAbrirArquivo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public ModelGeneratorGUIAbrirArquivo() {
		setTitle("Choose the file to be converterd ...");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		// set current directory as "D://"
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("UML Files (*.uml)", "uml");
		fileChooser.setFileFilter(filter);
		contentPane.add(fileChooser, BorderLayout.CENTER);
		int returnVal = fileChooser.showOpenDialog(this);
		System.out.println(returnVal);

		if (returnVal == JFileChooser.APPROVE_OPTION) {

			String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(caminhoArquivo);

			String textoLido = null;
			try {
				textoLido = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			getContentPane().removeAll();
			JTextArea texto = new JTextArea(textoLido);
			JScrollPane scrollPane = new JScrollPane(texto);

			JButton btnSair = new JButton("Sair");
			JButton btnToPrism = new JButton("toPRISM");
			JPanel painelBotoes = new JPanel(new FlowLayout());

			btnToPrism.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnToPrism) {
						System.out.println("toPRISM dialog");
						ModelGeneratorGUIPRISM janelaPrism = new ModelGeneratorGUIPRISM(caminhoArquivo);
						janelaPrism.setVisible(true);
					}

				}
			});
			painelBotoes.add(btnToPrism);
			painelBotoes.add(btnSair);

			getContentPane().add(scrollPane, BorderLayout.CENTER);
			getContentPane().add(painelBotoes, BorderLayout.SOUTH);

			repaint();
			update(getGraphics());

		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("User has clicked cancel option");
			this.setVisible(false);

		}

	}

}
