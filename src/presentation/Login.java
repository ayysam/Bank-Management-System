package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.AgentCRUD;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		AgentCRUD agentcrud= new AgentCRUD();
		this.setTitle("Login");
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Login = new JButton("Se connecte");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long loginUser =Long.parseLong(login.getText());
				String pass= password.getText();
				if (agentcrud.Login(loginUser, pass)!="false") {
					String nom=agentcrud.Login(loginUser, pass);
					JOptionPane.showMessageDialog(null,"welcome "+nom);
					InterfaceOperation O1 =new InterfaceOperation();
					setVisible(false);
					O1.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"no user found");
				}
			
				
			}
		});
		Login.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Login.setBounds(158, 454, 198, 44);
		contentPane.add(Login);
		
		login = new JTextField();
		login.setBounds(168, 187, 294, 35);
		contentPane.add(login);
		login.setColumns(10);
		
		password = new JTextField();
		password.setBounds(168, 282, 294, 35);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 187, 107, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 282, 107, 35);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(500, -19, 520, 613);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("البنك الإسلامي التونسي ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(45, 106, 414, 58);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BIT");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 99));
		lblNewLabel_3.setBounds(86, 201, 302, 194);
		panel.add(lblNewLabel_3);
	}
}
