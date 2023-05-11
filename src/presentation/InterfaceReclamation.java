package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class InterfaceReclamation extends JFrame {

	private JPanel absolute;
	private JTextField recherche;
	private JScrollPane scrollPane;
	private JTextField valider;
	private JButton blnvalider;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceReclamation frame = new InterfaceReclamation();
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
	public InterfaceReclamation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1217, 713);
		absolute = new JPanel();
		absolute.setForeground(new Color(0, 128, 128));
		absolute.setBackground(new Color(0, 128, 128));
		absolute.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(absolute);
		absolute.setLayout(null);
		
		Label label = new Label("Liste Reclamation");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(478, 38, 264, 39);
		absolute.add(label);
		
		recherche = new JTextField();
		recherche.setBounds(415, 96, 264, 27);
		absolute.add(recherche);
		recherche.setColumns(10);
		
		JButton btnrecherche = new JButton("Recherche");
		btnrecherche.setBounds(761, 96, 85, 27);
		absolute.add(btnrecherche);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 163, 913, 363);
		absolute.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		valider = new JTextField();
		valider.setColumns(10);
		valider.setBounds(415, 564, 264, 27);
		absolute.add(valider);
		
		blnvalider = new JButton("valider");
		blnvalider.setBounds(761, 562, 96, 30);
		absolute.add(blnvalider);
		
		JLabel lblNewLabel = new JLabel("id client");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(257, 92, 153, 27);
		absolute.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id reclamation");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(257, 564, 153, 27);
		absolute.add(lblNewLabel_1);
	}
}
