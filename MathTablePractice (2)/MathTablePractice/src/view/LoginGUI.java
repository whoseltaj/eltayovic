package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entity.Student;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField fieldPassword;
	public static Student student;
	private JButton btnParentlogin;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(182, 49, 315, 61);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setBounds(167, 164, 342, 46);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fieldPassword.setBounds(167, 241, 342, 46);
		contentPane.add(fieldPassword);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtUsername.getText()!=null&&fieldPassword.getText()!=null) {
				try {
					InputStream inputStream = getClass().getResourceAsStream("/files/students.txt");
				    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));					
					String s="";
						while( (s=br.readLine()) != null )
						{
							System.out.println(s);
							String data[] = new String[5];
							data = s.split(",");
							System.out.println(data[3]);
							if(data[3].equals(txtUsername.getText()) && data[4].equals(fieldPassword.getText()) )
							{
								student = new Student(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]);
								StudentMainGUI studentGUI = new StudentMainGUI();
								studentGUI.setVisible(true);
								dispose();
								break;
							}
							
							
						}
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(167, 333, 170, 33);
		contentPane.add(btnNewButton);
		
		btnParentlogin = new JButton("Parent Login");
		btnParentlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentLoginGUI Gui = new parentLoginGUI();
				Gui.setVisible(true);
				dispose();
			}
		});
		btnParentlogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnParentlogin.setBounds(347, 333, 162, 33);
		contentPane.add(btnParentlogin);
	}
}
