package br.unb.xmitoprism.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JInternalFrame;
import java.awt.Label;

public class ModelGeneratorGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelGeneratorGUI frame = new ModelGeneratorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModelGeneratorGUI() {
		setTitle("XMI to PRISM converter ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelGeneratorGUIAbrirArquivo janelaAbrirArquivo = new ModelGeneratorGUIAbrirArquivo();
				janelaAbrirArquivo.setVisible(true);

			}
		});
		mnNewMenu.add(mntmAbrir);
	}

}
