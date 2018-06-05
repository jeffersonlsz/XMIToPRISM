package br.unb.xmitoprism.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.unb.xmitoprism.Converter;

import javax.swing.JTextArea;

public class ModelGeneratorGUIPRISM extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModelGeneratorGUIPRISM dialog = new ModelGeneratorGUIPRISM();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelGeneratorGUIPRISM(String arquivoEntrada) {
		// le arquivo de entrada
		criarTextoComPrism(arquivoEntrada);

		// iniciar processo de conversao para prism chamando o Conversor
		Converter conversor = new Converter();
		File fileIn = new File(arquivoEntrada);
		String pathArq = fileIn.getPath();
		System.out.println("arquivo " + pathArq);
		boolean result = conversor.convert(pathArq);

		// popular texto com modelo gerado ou mensagem de erro em caso de
		// insucesso

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextArea textArea;
			JScrollPane textResultPane = null;
			if (result) {
				textArea = new JTextArea(conversor.getPrismResult());

			} else {
				textArea = new JTextArea(
						"Something went wrong during the conversion :\n\n" + conversor.getPrismResult());
			}

			textResultPane = new JScrollPane(textArea);

			contentPanel.add(textResultPane, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModelGeneratorGUIPRISM() {
		setTitle("XMI to PRISM converter");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextArea textArea = new JTextArea();
			contentPanel.add(textArea, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalvar = new JButton("Salvar");
				buttonPane.add(btnSalvar);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void criarTextoComPrism(String arquivoEntrada) {

	}

}
