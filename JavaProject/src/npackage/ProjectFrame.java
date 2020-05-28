package npackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ProjectFrame extends JFrame{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField textField;
	private ArrayList<Dhb> dhbs;
	private JTable table;
	private DefaultTableModel tm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DHBs", "Active", "Recovered", "Deaths", "Total", "Last Day"
			}
		);

	/**
	 * Create the frame.
	 */
	public ProjectFrame(ArrayList<Dhb> dhbs) {
		this.dhbs = dhbs;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 41, 557, 380);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Home", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 532, 330);
		panel_3.add(scrollPane);
				
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
		
		textField.setText(dhbs.get(0).getDhbs());
		
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		drawTable();
	}
	
	public void drawTable() {
		tm.setRowCount(0);
		for(int i = 0; i <19; i++) {
			Object[] object = new Objects[5];
			object[0] = dhbs.get(i).getDhbs();
			object[1] = dhbs.get(i).getActive();
			object[2] = dhbs.get(i).getRecovered();
			object[3] = dhbs.get(i).getDeceased();
			object[4] = dhbs.get(i).getTotal();
			object[5] = dhbs.get(i).getLastDay();
			
			tm.addRow(object);
		}
	}
}
