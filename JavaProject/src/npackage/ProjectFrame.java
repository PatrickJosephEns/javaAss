package npackage;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class ProjectFrame extends JFrame{
	
	private eSort order;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
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
	
	private DefaultTableModel tm2 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DHBs", "Active", "Recovered", "Deaths", "Total", "Last Day"
			}
		);
	
	private DefaultTableModel pg = new DefaultTableModel(
			new Object[][] {
			},
			new String[]
					{
							"Total"
					});
	private JTable table_1;
	private JTextField textField_1;
			

	/**
	 * Create the frame.
	 */
	public ProjectFrame(ArrayList<Dhb> dhbs) {
		order = eSort.CASES;
		this.dhbs = dhbs;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(34, 41, 557, 391);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Home", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 532, 186);
		panel_3.add(scrollPane);
				
		panel = new JPanel();
		tabbedPane.addTab("Search", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(36, 61, 160, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		//search
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchVal = textField.getText();
				Dhb match = Utilities.Search(dhbs, searchVal);
				
				if(match != null) {				
				tm2.setRowCount(0);
				
				Object[] object = new Object[6];
				object[0] = match.getDhbs();
				object[1] = match.getActive();
				object[2] = match.getRecovered();
				object[3] = match.getDeceased();
				object[4] = match.getTotal();
				object[5] = match.getLastDay();
				
				tm2.addRow(object);
				}
			}
		});
		btnNewButton.setBounds(217, 61, 98, 31);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 113, 476, 39);
		panel.add(scrollPane_1);
		
		//seach table
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(tm2);
		
		JLabel lblNewLabel = new JLabel("Search Function");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(36, 11, 241, 39);
		panel.add(lblNewLabel);
		
		//Home tabel
		table = new JTable();
		table.setModel(tm);
		scrollPane.setViewportView(table);
		
		//sort alphabetically button
		JButton btnNewButton_1 = new JButton("Sort by alphabet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("alphabet");
			}
		});
		btnNewButton_1.setBounds(10, 219, 141, 23);
		panel_3.add(btnNewButton_1);
		
		//sort by total cases button
		JButton btnNewButton_2 = new JButton("Sort by total cases");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("total");
			}
		});
		btnNewButton_2.setBounds(207, 219, 149, 23);
		panel_3.add(btnNewButton_2);
		
		//sort by active cases button
		JButton btnNewButton_3 = new JButton("Sort by active");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortData("totalActive");
			}
		});
		btnNewButton_3.setBounds(401, 219, 141, 23);
		panel_3.add(btnNewButton_3);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Calculate", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 61, 123, 43);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Calculate Averages");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(71, 23, 286, 40);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Active");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(Integer.toString(Utilities.averageActive(dhbs)));
			}
		});
		btnNewButton_4.setBounds(95, 115, 111, 43);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Recovered");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(Integer.toString(Utilities.averageRecovered(dhbs)));
			}
		});
		btnNewButton_5.setBounds(236, 115, 121, 43);
		panel_1.add(btnNewButton_5);
		
		
		drawTable();
		makePie();
	}
	
	public void sortData(String button) {
		switch(button) {
		case"alphabet":
			if(order != eSort.ALPHABETICAL) {
			Collections.sort(dhbs, new AlfaCompare());			
			}
			else {
			Collections.reverse(dhbs);	
			}
			order = order.ALPHABETICAL;
			break;
			
		case"total":
			if(order != eSort.CASES) {
			Collections.sort(dhbs, new DhbCompare());			
			}
			else {
			Collections.reverse(dhbs);	
			}
			order = order.CASES;
			break;
			
		case"totalActive":
			if(order != eSort.ACTIVE) {
			Collections.sort(dhbs, new ActiveSort());			
			}
			else {
			Collections.reverse(dhbs);	
			}
			order = order.ACTIVE;
			break;
		}
		drawTable();
	}
	
	public void drawTable() {
		tm.setRowCount(0);
		for(int i = 0; i <19; i++) {
			Object[] object = new Object[6];
			object[0] = dhbs.get(i).getDhbs();
			object[1] = dhbs.get(i).getActive();
			object[2] = dhbs.get(i).getRecovered();
			object[3] = dhbs.get(i).getDeceased();
			object[4] = dhbs.get(i).getTotal();
			object[5] = dhbs.get(i).getLastDay();
			
			tm.addRow(object);
		}
	}

	
	private void makePie() {

		DefaultPieDataset data = new DefaultPieDataset();
		Collections.sort(dhbs,new DhbCompare());
		pg.setRowCount(0);
		
		for(int i = 0; i < 10; i++) {
		data.setValue(dhbs.get(i).getDhbs(), dhbs.get(i).getTotal());
		}

		JFreeChart chart = ChartFactory.createPieChart("Top District health boards",data,true,true,Locale.ENGLISH);

		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);

		tabbedPane.add("Pie Graph",mypanel);
	}
}
