package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataAccess.abstracts.ResultRepository;
import entity.Student;
import entity.Test;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class StudentMainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAnswer;
	Random rand = new Random();
	private int firstNumb;
	private int secondNumb;
	private int answer;
	private boolean answerCheck;
	private Test test;
	String question;
	public int range = ResultRepository.getRange();
	
	FileWriter fr = new FileWriter("..\\MathTablePractice\\src\\files\\tests.txt",true);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainGUI frame = new StudentMainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StudentMainGUI() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnlogOut = new JButton("Log Out");
		btnlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();
			}
		});
		btnlogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnlogOut.setBounds(10, 10, 135, 40);
		contentPane.add(btnlogOut);
		
		textFieldAnswer = new JTextField();
		textFieldAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAnswer.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldAnswer.setBounds(293, 266, 255, 63);
		contentPane.add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Let's Start");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuestion.setBounds(221, 126, 400, 74);
		contentPane.add(lblQuestion);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textFieldAnswer.getText().isEmpty())
				{
					answerCheck = false;
				}else {
					answerCheck = (Integer.parseInt(textFieldAnswer.getText())==answer);
				}
				question = lblQuestion.getText();
				test = new Test(LoginGUI.student.getId(), question, answerCheck);
				
					try {
						fr.append(test.getStudent_id()+","+test.getQuestion()+","+test.isAnswerCheck()+",\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				textFieldAnswer.setText("");
				
				firstNumb = rand.nextInt(range)+1;
				secondNumb = rand.nextInt(range)+1;
				lblQuestion.setText(firstNumb + " * " + secondNumb + " = ? " );
				answer = firstNumb*secondNumb;
				
				
			}
		});
		btnNextQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNextQuestion.setBounds(293, 339, 255, 40);
		contentPane.add(btnNextQuestion);
		
		JButton btnStartTest = new JButton("Start Test");
		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnStartTest.setEnabled(false);
				btnNextQuestion.setEnabled(true);
				
				firstNumb = rand.nextInt(range)+1;
				secondNumb = rand.nextInt(range)+1;
				lblQuestion.setText(firstNumb + " * " + secondNumb + " = ? " );
				answer = firstNumb*secondNumb;
				
				
				
			}
		});
		btnStartTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStartTest.setBounds(293, 210, 120, 40);
		contentPane.add(btnStartTest);
		
		JButton btnStopTest = new JButton("Stop Test");
		btnStopTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblQuestion.setText("Let's Start");
				btnNextQuestion.setEnabled(false);
				textFieldAnswer.setText("");
				btnStartTest.setEnabled(true);
			
			}
		});
		btnStopTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStopTest.setBounds(422, 210, 126, 40);
		contentPane.add(btnStopTest);
		
		
		
		
		
		
	}

}
