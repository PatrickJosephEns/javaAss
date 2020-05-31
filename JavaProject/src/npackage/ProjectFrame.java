package npackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class ProjectFrame extends JFrame{

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
		
		drawTable();
		makePie();
		createLineChart();
		createBarChart();
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

		JFreeChart chart = ChartFactory.createPieChart("Top 5 District health boards",data,true,true,Locale.ENGLISH);

		ChartPanel mypanel = new ChartPanel(chart);
		mypanel.setVisible(true);

		tabbedPane.add("Pie Graph",mypanel);
		}

	
		private void createLineChart() {
		XYSeries series1 = new XYSeries("weight");
		series1.add(60,10);
		series1.add(55,140);
		series1.add(50,420);
		series1.add(52,300);
		series1.add(57,20);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);

		//create chart
		JFreeChart chart2 = ChartFactory.createXYLineChart("Deaths", "kgs", "minutes", dataset,PlotOrientation.HORIZONTAL,true,true,true);
		//get a reference to the plot for further customisation
		XYPlot plot = chart2.getXYPlot();

		NumberAxis domain = (NumberAxis) plot.getDomainAxis();
		domain.setRange(45,80);
		domain.setTickUnit(new NumberTickUnit(10));
		domain.setVerticalTickLabels(true);

		NumberAxis range = (NumberAxis) plot.getRangeAxis();
		range.setRange(0,450);
		range.setTickUnit(new NumberTickUnit(50));

		ChartPanel mypanel2 = new ChartPanel(chart2);
		tabbedPane.add("Line Graph",mypanel2);
		tabbedPane.setBackgroundAt(2, Color.LIGHT_GRAY);

		}

		private void createBarChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(70, "Java", "2007");
		dataset.addValue(70, "Java", "2008");
		dataset.addValue(70, "Java", "2011");
		JFreeChart chart3 = ChartFactory.createBarChart("Java","years","percentage",dataset,PlotOrientation.VERTICAL,true,true,true);
		ChartPanel mypanel3 = new ChartPanel(chart3);
		tabbedPane.add("Bar Graph",mypanel3);
		tabbedPane.setBackgroundAt(3, new Color(186, 85, 211));
		}
}
