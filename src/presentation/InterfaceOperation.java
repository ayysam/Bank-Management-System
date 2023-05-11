package presentation;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.*;
import metier.*;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
public class InterfaceOperation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField recherche;
	private JButton btnrecherche;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField rib;
	private JTextField montant;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox typeop;
	private JLabel lblNewLabel_4;
	private JButton valider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceOperation frame = new InterfaceOperation();
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
	public InterfaceOperation() {
		CompteCRUD comptecrud=new CompteCRUD();
		
		   OperationCRUD operationCRUD=new OperationCRUD();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1198, 807);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(551, 258, 515, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//affichage table
		comptecrud.select(table);
		
		recherche = new JTextField();
		recherche.setBounds(551, 223, 342, 26);
		contentPane.add(recherche);
		recherche.setColumns(10);
		
		btnrecherche = new JButton("Rechercher");
		btnrecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recherche compte
				Long riborID=Long.parseLong(recherche.getText());
				comptecrud.rechercheCompte(riborID, table);
			}
		});
		btnrecherche.setBounds(902, 225, 164, 23);
		contentPane.add(btnrecherche);
		
		lblNewLabel_1 = new JLabel("BIT");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(76, 24, 105, 45);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Walid\\Desktop\\tekup\\bank (4).png"));
		lblNewLabel.setBounds(10, 10, 70, 69);
		contentPane.add(lblNewLabel);
		
		rib = new JTextField();
		rib.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rib.setBounds(147, 314, 271, 33);
		contentPane.add(rib);
		rib.setColumns(10);
		
		montant = new JTextField();
		montant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		montant.setColumns(10);
		montant.setBounds(147, 382, 271, 33);
		contentPane.add(montant);
		
		lblNewLabel_2 = new JLabel("RIB");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(-17, 314, 97, 33);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("MONTANT");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_3.setBounds(-1, 377, 138, 38);
		contentPane.add(lblNewLabel_3);
		
		typeop = new JComboBox();
		typeop.setModel(new DefaultComboBoxModel(new String[] {"---------", "versement ", "retrait"}));
		typeop.setBounds(251, 441, 167, 33);
		contentPane.add(typeop);
		
		lblNewLabel_4 = new JLabel("TYPE OPERATION");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4.setBounds(-1, 441, 242, 38);
		contentPane.add(lblNewLabel_4);
		
		valider = new JButton("valider");
		valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long ribtextfield=Long.parseLong(rib.getText());
				double montanttextfield=Double.parseDouble(montant.getText());
				String typopcombobox=typeop.getSelectedItem().toString();
				
			
					
				Operation operation = new Operation(1,ribtextfield,typopcombobox,montanttextfield,java.time.LocalDateTime.now().toString());
				  double totale=0;	 
				if(operationCRUD.add(operation) ==1 && typopcombobox=="versement") {
				            Compte c1 = comptecrud.selectCompte(ribtextfield);
				            totale=c1.getSolde()+montanttextfield;
				            System.out.println(totale);
							 c1.setSolde(totale);
					            comptecrud.modify(c1);
					            comptecrud.select(table);
				            
				            	 
				            	
				            }else if(operationCRUD.add(operation) ==1 && typopcombobox=="retrait"){
				            	 Compte c1 = comptecrud.selectCompte(ribtextfield);
				            	 if(c1.getSolde()>=operation.getMontant()) {
				            		
							          
				            		  totale=c1.getSolde()-montanttextfield;
				            		  System.out.println(totale);
				            		  c1.setSolde(totale);
							            comptecrud.modify(c1);
							            comptecrud.select(table);
				            		
						     }  
				            	
				            }else {
				            	JOptionPane.showConfirmDialog(null,"ereur systeme","Erreur",JOptionPane.PLAIN_MESSAGE);	
				            }
				            
				      
			
				
				
				
		       
				
				
				
				
				
			}
		});
		valider.setBounds(251, 524, 167, 38);
		contentPane.add(valider);
	}
}
