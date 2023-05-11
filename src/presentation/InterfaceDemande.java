package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.DemandeCRUD;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import metier.Demande;
public class InterfaceDemande extends JFrame {

	private JPanel contentPane;
	private JTextField idDemande;
	private JTable table;
	private JTextField idUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDemande frame = new InterfaceDemande();
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
	public InterfaceDemande() {
		DemandeCRUD demandeCRUD = new DemandeCRUD();
		setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Demande carnet de cheque");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(342, 66, 424, 49);
		contentPane.add(lblNewLabel);
		
		idDemande = new JTextField();
		idDemande.setBounds(631, 212, 110, 24);
		contentPane.add(idDemande);
		idDemande.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Entrer l'id de la demande");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(374, 210, 238, 18);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 310, 667, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		demandeCRUD.select(table);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idDemande.getText());
				demandeCRUD.rechercheDemande(id,table);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(489, 258, 110, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("L'id de la demande traité");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(258, 573, 185, 13);
		contentPane.add(lblNewLabel_2);
		
		idUpdate = new JTextField();
		idUpdate.setBounds(453, 572, 96, 19);
		contentPane.add(idUpdate);
		idUpdate.setColumns(10);
		
		JComboBox etat = new JComboBox();
		etat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etat.setModel(new DefaultComboBoxModel(new String[] {"en attente", "acceptee", "refusee"}));
		etat.setBounds(603, 570, 110, 18);
		contentPane.add(etat);
		
		JButton valider = new JButton("Valider");
		valider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_demande = Integer.parseInt(idUpdate.getText());
		        Demande d = demandeCRUD.selectDemande(id_demande);
		        d.setEtat(String.valueOf(etat.getSelectedItem()));
				demandeCRUD.modify(d);
			}
		});
		valider.setBounds(464, 625, 85, 21);
		contentPane.add(valider);
	}
}
