package npackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class ProjectFrame extends JFrame{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ProjectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 41, 311, 191);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Total Cases", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ProjectFrame.class.getResource("/npackage/the-flu-virus.jpg")));
		lblNewLabel.setBounds(203, 83, 103, 69);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 45, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Average", null, panel_1, null);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Recovered", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField.setText(dhb.(0));
	}
}
