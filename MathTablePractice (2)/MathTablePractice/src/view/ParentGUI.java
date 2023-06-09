package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dataAccess.abstracts.ResultRepository;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ParentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtArrangement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParentGUI frame = new ParentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public ParentGUI() throws SQLException, NumberFormatException, FileNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		// Create the table model with three columns
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Student");
        model.addColumn("Question");
        model.addColumn("Answer Check");

		BufferedReader br = new BufferedReader(new FileReader("../MathTablePractice/src/files/tests.txt"));
        String s= "";
        // Loop through the result set and add rows to the table model
        while ((s=br.readLine())!=null) {
        	String data[] = new String[3];
        	data = s.split(",");
        	
        	int studentId = Integer.parseInt(data[0]);
            String question = data[1];
            boolean answerCheck = Boolean.parseBoolean(data[2]);
            String name = "";
			BufferedReader br2 = new BufferedReader(new FileReader("../MathTablePractice/src/files/students.txt"));
            String s2 = "";
            
            while((s2 = br2.readLine())!=null) {
            	
            	String data2[] = new String[5];
            	data2=s2.split(",");
            	System.out.println(studentId == Integer.parseInt(data[0]));
            	System.out.println(studentId +" "+ Integer.parseInt(data[0]));
            	if(studentId == Integer.parseInt(data2[0])) {
            		name = data2[1]+" "+data2[2];
            		Object[] row = {name, question, answerCheck };
                    model.addRow(row);
                    break;
            	}

            }

            
            
            }
        
        contentPane.setLayout(null);

        // Create the table with the table model
        JTable table = new JTable(model);

        // Add the table to a scroll pane and add the scroll pane to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 75, 931, 455);
        getContentPane().add(scrollPane);
        
        JButton btnNewButton = new JButton("Log Out");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginGUI gui = new LoginGUI();
        		gui.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(10, 10, 188, 57);
        contentPane.add(btnNewButton);
        
        JButton btn_saveTestArrangement = new JButton("Save");
        btn_saveTestArrangement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ResultRepository.setRange(Integer.parseInt(txtArrangement.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btn_saveTestArrangement.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn_saveTestArrangement.setBounds(753, 8, 188, 57);
        contentPane.add(btn_saveTestArrangement);
        
        txtArrangement = new JTextField();
        txtArrangement.setHorizontalAlignment(SwingConstants.CENTER);
        txtArrangement.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtArrangement.setText("Arrangement");
        txtArrangement.setBounds(583, 8, 160, 57);
        contentPane.add(txtArrangement);
        txtArrangement.setColumns(10);
        txtArrangement.setText(Integer.toString(ResultRepository.getRange()));

		
	}
}
