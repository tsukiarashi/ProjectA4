package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SchoolUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTextField math;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchoolUI frame = new SchoolUI();
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
	public SchoolUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(25, 10, 428, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學校錄取系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 408, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 64));
		panel_1.setBounds(25, 75, 428, 213);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 64, 27);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 51, 64, 27);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 88, 64, 27);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("數學:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 125, 64, 27);
		panel_1.add(lblNewLabel_1_3);
		
		name = new JTextField();
		name.setForeground(new Color(0, 0, 0));
		name.setFont(new Font("新細明體", Font.BOLD, 18));
		name.setBounds(84, 10, 313, 27);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setForeground(Color.BLACK);
		chi.setFont(new Font("新細明體", Font.BOLD, 18));
		chi.setColumns(10);
		chi.setBounds(84, 51, 313, 27);
		panel_1.add(chi);
		
		eng = new JTextField();
		eng.setForeground(Color.BLACK);
		eng.setFont(new Font("新細明體", Font.BOLD, 18));
		eng.setColumns(10);
		eng.setBounds(84, 88, 313, 27);
		panel_1.add(eng);
		
		math = new JTextField();
		math.setForeground(Color.BLACK);
		math.setFont(new Font("新細明體", Font.BOLD, 18));
		math.setColumns(10);
		math.setBounds(84, 125, 313, 27);
		panel_1.add(math);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 255));
		panel_2.setBounds(25, 298, 428, 220);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setFont(new Font("Monospaced", Font.BOLD, 18));
		show.setBounds(10, 10, 408, 200);
		panel_2.add(show);
		
		JButton btnNewButton = new JButton("結果");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String Chi=chi.getText();
				String Eng=eng.getText();
				String Math=math.getText();
				
				Integer C=new Integer(Chi);//Boxing
				Integer E=new Integer(Eng);
				Integer M=new Integer(Math);
				
				
				School s=new School(Name,C,E,M);
				
				if(s.getSum()>=200)
				{
					if(s.getEng()>=75)
					{
						show.setText(s.Success());
					}
					else
					{
						show.setText(s.engError());
					}
				}
				else
				{
					show.setText(s.sumError());
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton.setBounds(154, 162, 159, 41);
		panel_1.add(btnNewButton);
	}

}
