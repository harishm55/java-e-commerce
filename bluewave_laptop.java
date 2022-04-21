package ajp;

import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Component;

public class bluewave_laptop extends JFrame {

	JPanel contentPane;
	JTextField username;
	JTextField mobileno;
	Action action = new SwingAction();
	Action action_1 = new SwingAction_1();
	Action action_2 = new SwingAction_2();
	Action action_3 = new SwingAction_3();
	JTextField modelName;
	JTextField serialno;
	String name,mobile,iss,brand,process,ram,model,serial,area;
	int c=0;
	Action action_4 = new SwingAction_4();
	private JTextField userBrand;
	private JTextField userRam;
	private JTextField UserProcessor;
	private JTextField userStorage;
	private JTable table_1;
	DefaultTableModel model1;
	private final Action action_5 = new SwingAction_5();
	
	String DB_URL = "jdbc:mysql://localhost:3306/bluewave";	
	static final String USER = "root";
	static final String PASS = "19csr055";	
	static final String QUERY = "SELECT brand,processor,ram,storage FROM laps;";
	
	private final Action action_6 = new SwingAction_6();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bluewave_laptop frame = new bluewave_laptop();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try 
		{			
		    Class.forName("com.mysql.cj.jdbc.Driver");		    
		    System.out.println("Registration success");
		} 
		catch (Exception e) 
		{			
		    System.out.println(e.toString());
		}	     
	}

	public bluewave_laptop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//******************************1st tab*********************
		JTabbedPane Main_pane = new JTabbedPane(JTabbedPane.TOP);
		Main_pane.setBounds(29, 45, 768, 573);
		JPanel Login_Tab = new JPanel();
		JLabel user_name = new JLabel("NAME");
		user_name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		user_name.setBackground(Color.WHITE);
		JLabel mobile_no = new JLabel("MOBILE NO");
		mobile_no.setBackground(Color.WHITE);
		mobile_no.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		username = new JTextField();
		mobileno = new JTextField();
		JButton Button_Proceed = new JButton("PROCEED");
		Button_Proceed.setFont(new Font("Tahoma", Font.BOLD, 17));
			
		
		contentPane.add(Main_pane);
		Main_pane.addTab("cus-info", null, Login_Tab, null);
		Login_Tab.add(user_name);
		Login_Tab.add(mobile_no);		
		Login_Tab.add(username);
		Login_Tab.add(mobileno);
		Login_Tab.add(Button_Proceed);
		user_name.setBounds(235, 154, 103, 36);		
		mobile_no.setBounds(235, 201, 103, 30);
		username.setBounds(408, 163, 127, 20);
		mobileno.setBounds(408, 207, 127, 20);
		Button_Proceed.setBounds(330, 262, 127, 41);
		
		username.setColumns(10);
		mobileno.setColumns(10);		
		
		Button_Proceed.setBackground(Color.WHITE);
		Button_Proceed.setForeground(Color.BLACK);
		Login_Tab.setBackground(Color.GRAY);		
		Login_Tab.setLayout(null);
		
		Button_Proceed.setAction(action);
		
		Button_Proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().isEmpty())
				{
					c=0;
					JOptionPane.showMessageDialog(null, "Enter your name");	
				}
				else if(mobileno.getText().isEmpty())
				{
					c=0;
					JOptionPane.showMessageDialog(null, "Enter your Mobile No");
				}
				else
				{
					c=1;
				}
				if(c==1)
				{
					name=username.getText();
				    mobile=mobileno.getText();
					Main_pane.setSelectedIndex(1);
				}
			}
		});
		
		
	//************************3rd tab**************************************************	
				
		JPanel Buy_Tab = new JPanel();
		
		JLabel Brand_choice = new JLabel("Brand");
		Brand_choice.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel Processor_choice = new JLabel("processor");
		Processor_choice.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel Ram_choice = new JLabel("RAM");
		Ram_choice.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JCheckBox option_Dell = new JCheckBox("Dell");
		option_Dell.setFont(new Font("Tahoma", Font.PLAIN, 13));
		option_Dell.setBackground(Color.LIGHT_GRAY);
		JCheckBox option_Hp = new JCheckBox("Hp");
		option_Hp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		option_Hp.setBackground(Color.LIGHT_GRAY);
		JCheckBox option_Asus = new JCheckBox("Asus");
		option_Asus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		option_Asus.setBackground(Color.LIGHT_GRAY);
		
		JRadioButton option_Intel = new JRadioButton("Intel");
		option_Intel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		option_Intel.setBackground(Color.LIGHT_GRAY);
		JRadioButton option_Amd = new JRadioButton("Amd(Ryzen)");
		option_Amd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		option_Amd.setBackground(Color.LIGHT_GRAY);
		
		JComboBox<String> option_Ram = new JComboBox<String>();
		option_Ram.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton next_tab_service = new JButton("New button1");
		next_tab_service.setFont(new Font("Tahoma", Font.BOLD, 16));
		next_tab_service.setBackground(Color.WHITE);
		next_tab_service.setForeground(Color.BLACK);
		ButtonGroup brandGroup = new ButtonGroup();
		ButtonGroup processGroup = new ButtonGroup();
		//++++++++++++++++++++++++++++++++++++2nd tab+++++++++++++++++++++++++++++++++++++++++++++++++
		
		JPanel Help_Tab = new JPanel();
		JLabel help_header = new JLabel("How can we help you?");
		help_header.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		JButton Button_Buy = new JButton("BUY");
		Button_Buy.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Buy.setForeground(new Color(0, 0, 0));
		Button_Buy.setBackground(Color.LIGHT_GRAY);
		JButton Button_Service = new JButton("SERVICE");
		Button_Service.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Service.setForeground(Color.BLACK);
		Button_Service.setBackground(Color.LIGHT_GRAY);
		
		
		Main_pane.addTab("Help", null, Help_Tab, null);
		Help_Tab.add(help_header);
		Help_Tab.add(Button_Buy);
		Help_Tab.add(Button_Service);
		
		help_header.setBounds(274, 41, 204, 75);
		Button_Buy.setBounds(107, 169, 102, 40);
		Button_Service.setBounds(523, 169, 114, 40);
		
		Help_Tab.setBackground(Color.DARK_GRAY);
		help_header.setForeground(Color.WHITE);
		help_header.setBackground(Color.WHITE);
		
		Help_Tab.setLayout(null);
		
		
		Button_Buy.setAction(action_1);
		Button_Service.setAction(action_2);
		
		JButton Button_Build = new JButton("BUILD");
		Button_Build.setAction(action_5);
		Button_Build.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Build.setBackground(Color.LIGHT_GRAY);
		Button_Build.setForeground(Color.BLACK);
		Button_Build.setBounds(322, 170, 102, 40);
		Help_Tab.add(Button_Build);
		
		Button_Buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_pane.setSelectedIndex(2);
			}
		});
		
		Button_Service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_pane.setSelectedIndex(3);
			}
		});
		Button_Build.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_pane.setSelectedIndex(5);
			}
		});
		
//********		
		Main_pane.addTab("Buy", null, Buy_Tab, null);
		Buy_Tab.add(Brand_choice);
		Buy_Tab.add(Processor_choice);
		Buy_Tab.add(Ram_choice);
		Buy_Tab.add(option_Dell);
		Buy_Tab.add(option_Hp);
		Buy_Tab.add(option_Asus);
		Buy_Tab.add(option_Intel);
		Buy_Tab.add(option_Amd);
		option_Ram.addItem("4 GB");
		option_Ram.addItem("8 GB");
		option_Ram.addItem("12 GB");
		option_Ram.addItem("16 GB");
		Buy_Tab.add(option_Ram);
		Buy_Tab.add(next_tab_service);
		brandGroup.add(option_Dell);
		brandGroup.add(option_Hp);
		brandGroup.add(option_Asus);
		processGroup.add(option_Intel);
		processGroup.add(option_Amd);
		
		
		Buy_Tab.setBackground(Color.GRAY);
		option_Dell.setForeground(Color.BLACK);
		option_Hp.setForeground(Color.BLACK);
		option_Asus.setForeground(Color.BLACK);
		option_Intel.setForeground(Color.BLACK);
		option_Amd.setForeground(Color.BLACK);
		option_Ram.setBackground(Color.LIGHT_GRAY);
		option_Ram.setForeground(Color.BLACK);
		
		Buy_Tab.setLayout(null);		
		
		Brand_choice.setBounds(255, 150, 76, 28);		
		Processor_choice.setBounds(255, 213, 89, 28);		
		Ram_choice.setBounds(255, 268, 113, 28);		
		option_Dell.setBounds(393, 154, 56, 23);		
		option_Hp.setBounds(468, 154, 46, 23);		
		option_Asus.setBounds(533, 154, 58, 23);		
		option_Intel.setBounds(393, 217, 56, 23);		
		option_Amd.setBounds(468, 217, 109, 23);		
		option_Ram.setBounds(398, 268, 113, 26);
		next_tab_service.setBounds(502, 342, 113, 40);
		
		
		next_tab_service.setAction(action_4);		
		option_Dell.setActionCommand("Dell");
		option_Hp.setActionCommand("Hp");
		option_Asus.setActionCommand("Asus");
		option_Intel.setActionCommand("Intel");
		option_Amd.setActionCommand("Amd(Ryzen)");
		
		JLabel Buy_Header = new JLabel("BUY");
		Buy_Header.setBackground(Color.WHITE);
		Buy_Header.setHorizontalAlignment(SwingConstants.CENTER);
		Buy_Header.setForeground(Color.DARK_GRAY);
		Buy_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		Buy_Header.setBounds(332, 26, 89, 40);
		Buy_Tab.add(Buy_Header);
		
		JLabel speci_Header = new JLabel("Choose Your Specification");
		speci_Header.setHorizontalAlignment(SwingConstants.CENTER);
		speci_Header.setBackground(Color.BLACK);
		speci_Header.setForeground(Color.WHITE);
		speci_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		speci_Header.setBounds(269, 77, 245, 28);
		Buy_Tab.add(speci_Header);
		ButtonGroup issueGroup = new ButtonGroup();
		
//************************************4th panel*********************
		
		JPanel Service_Tab = new JPanel();
		JLabel model_Name = new JLabel("Model Name :");
		model_Name.setForeground(Color.BLACK);
		model_Name.setBackground(Color.WHITE);
		model_Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel serial_No = new JLabel("Serial No :");
		serial_No.setForeground(Color.BLACK);
		serial_No.setBackground(Color.WHITE);
		serial_No.setFont(new Font("Tahoma", Font.BOLD, 15));
		modelName = new JTextField();
		modelName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		modelName.setForeground(Color.BLACK);
		modelName.setBackground(Color.LIGHT_GRAY);
		serialno = new JTextField();
		serialno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		serialno.setForeground(Color.BLACK);
		serialno.setBackground(Color.LIGHT_GRAY);
		JLabel Issues = new JLabel("Issues");
		Issues.setForeground(Color.BLACK);
		Issues.setBackground(Color.WHITE);
		Issues.setFont(new Font("Tahoma", Font.BOLD, 15));
		JCheckBox Hardware_issue = new JCheckBox("Hardware");
		Hardware_issue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Hardware_issue.setBackground(Color.LIGHT_GRAY);
		Hardware_issue.setForeground(Color.BLACK);
		JCheckBox software_issue = new JCheckBox("Software");
		software_issue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		software_issue.setForeground(Color.BLACK);
		software_issue.setBackground(Color.LIGHT_GRAY);
		JLabel Others = new JLabel("Others");
		Others.setBackground(Color.WHITE);
		Others.setForeground(Color.BLACK);
		Others.setFont(new Font("Tahoma", Font.BOLD, 15));
		JTextArea others_complains = new JTextArea();
		others_complains.setFont(new Font("Tahoma", Font.PLAIN, 13));
		others_complains.setForeground(Color.BLACK);
		others_complains.setBackground(Color.LIGHT_GRAY);
		JButton next_tab_final = new JButton("New button1");
		next_tab_final.setFont(new Font("Tahoma", Font.BOLD, 17));
		next_tab_final.setForeground(Color.BLACK);
		next_tab_final.setBackground(Color.WHITE);
		
		
		Main_pane.addTab("Service", null, Service_Tab, null);
		Service_Tab.add(model_Name);
		Service_Tab.add(serial_No);
		Service_Tab.add(modelName);
		Service_Tab.add(serialno);
		Service_Tab.add(Issues);
		Service_Tab.add(Hardware_issue);
		Service_Tab.add(software_issue);
		Service_Tab.add(Others);
		Service_Tab.add(others_complains);
		issueGroup.add(Hardware_issue);
		issueGroup.add(software_issue);
		
		Service_Tab.setBackground(Color.DARK_GRAY);
		Service_Tab.setLayout(null);
		
		
		model_Name.setBounds(211, 121, 121, 37);		
		serial_No.setBounds(211, 174, 83, 14);
		modelName.setBounds(361, 129, 194, 20);
		serialno.setBounds(361, 171, 194, 20);
		Issues.setBounds(211, 211, 83, 34);
		Hardware_issue.setBounds(361, 211, 83, 23);
		software_issue.setBounds(473, 211, 83, 23);
		others_complains.setBounds(361, 250, 198, 49);
		Others.setBounds(211, 255, 83, 44);
		next_tab_final.setBounds(456, 342, 106, 34);
		
		
		modelName.setColumns(10);
		serialno.setColumns(10);
		
		next_tab_final.setAction(action_4);	
		Hardware_issue.setActionCommand("Hardware");
		software_issue.setActionCommand("Software");
		
		Service_Tab.add(next_tab_final);
		
		JLabel Service_header = new JLabel("SERVICE");
		Service_header.setHorizontalAlignment(SwingConstants.CENTER);
		Service_header.setForeground(Color.WHITE);
		Service_header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		Service_header.setBounds(310, 58, 106, 29);
		Service_Tab.add(Service_header);
		
		
	    
		model1 = new DefaultTableModel();
		Object[] column= {"Brand","Processor","Ram","Storage"};
		final Object[] row =new Object[4];
		model1.setColumnIdentifiers(column);
		
//*********************************5th panel***************************	
		JPanel Final_Tab = new JPanel();
		Final_Tab.setForeground(Color.DARK_GRAY);
		Final_Tab.setBackground(Color.GRAY);
		Main_pane.addTab("Final", null, Final_Tab, null);
		Final_Tab.setLayout(null);
		
		JLabel cus_name = new JLabel("Name :");
		cus_name.setForeground(Color.BLACK);
		cus_name.setFont(new Font("Tahoma", Font.BOLD, 15));
		cus_name.setBounds(174, 95, 67, 29);
		Final_Tab.add(cus_name);		
		
		JLabel cus_mobile = new JLabel("Mobile");
		cus_mobile.setForeground(Color.BLACK);
		cus_mobile.setFont(new Font("Tahoma", Font.BOLD, 15));
		cus_mobile.setBounds(480, 95, 67, 29);
		Final_Tab.add(cus_mobile);
		
		JLabel cusName = new JLabel("");
		cusName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cusName.setForeground(Color.DARK_GRAY);
		cusName.setBounds(265, 96, 109, 28);
		Final_Tab.add(cusName);
		
		JLabel cusMobile = new JLabel("");
		cusMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cusMobile.setForeground(Color.DARK_GRAY);
		cusMobile.setBounds(572, 96, 122, 28);
		Final_Tab.add(cusMobile);
		
		JLabel brand_choosed = new JLabel("");
		brand_choosed.setBackground(Color.WHITE);
		brand_choosed.setForeground(Color.BLACK);
		brand_choosed.setFont(new Font("Tahoma", Font.BOLD, 15));
		brand_choosed.setBounds(209, 146, 90, 20);
		Final_Tab.add(brand_choosed);
		
		JLabel processor_choosed = new JLabel("");
		processor_choosed.setBackground(Color.WHITE);
		processor_choosed.setForeground(Color.BLACK);
		processor_choosed.setFont(new Font("Tahoma", Font.BOLD, 15));
		processor_choosed.setBounds(209, 180, 133, 14);
		Final_Tab.add(processor_choosed);
		
		JLabel ram_choosed = new JLabel("");
		ram_choosed.setBackground(Color.WHITE);
		ram_choosed.setForeground(Color.BLACK);
		ram_choosed.setFont(new Font("Tahoma", Font.BOLD, 15));
		ram_choosed.setBounds(209, 215, 90, 20);
		Final_Tab.add(ram_choosed);
		
		JLabel product_seialno = new JLabel("");
		product_seialno.setBackground(Color.WHITE);
		product_seialno.setForeground(Color.BLACK);
		product_seialno.setFont(new Font("Tahoma", Font.BOLD, 15));
		product_seialno.setBounds(501, 190, 122, 14);
		Final_Tab.add(product_seialno);
		
		JLabel Product_model = new JLabel("");
		Product_model.setBackground(Color.WHITE);
		Product_model.setForeground(Color.BLACK);
		Product_model.setFont(new Font("Tahoma", Font.BOLD, 15));
		Product_model.setBounds(501, 158, 158, 14);
		Final_Tab.add(Product_model);
		
		JLabel product_issues = new JLabel("");
		product_issues.setBackground(Color.WHITE);
		product_issues.setForeground(Color.BLACK);
		product_issues.setFont(new Font("Tahoma", Font.BOLD, 15));
		product_issues.setBounds(501, 221, 133, 14);
		Final_Tab.add(product_issues);
		
		JLabel others_issues = new JLabel("");
		others_issues.setBackground(Color.WHITE);
		others_issues.setForeground(Color.BLACK);
		others_issues.setFont(new Font("Tahoma", Font.BOLD, 15));
		others_issues.setBounds(501, 249, 212, 20);
		Final_Tab.add(others_issues);
		
		JLabel final_Header = new JLabel("ISSUES SOLVED/FEATURES OF LAP");
		final_Header.setHorizontalAlignment(SwingConstants.CENTER);
		final_Header.setForeground(Color.BLACK);
		final_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		final_Header.setBounds(195, 10, 340, 42);
		Final_Tab.add(final_Header);
		
		
//*****************************************Panel-6***************************
		
		
		JPanel Build_Tab = new JPanel();		
		Build_Tab.setForeground(Color.DARK_GRAY);
		Build_Tab.setBackground(Color.DARK_GRAY);
		Main_pane.addTab("PC BUILD", null, Build_Tab, null);
		Build_Tab.setLayout(null);	
		
		JLabel user_Brand = new JLabel("BRAND");
		user_Brand.setFont(new Font("Tahoma", Font.BOLD, 13));
		user_Brand.setForeground(new Color(0, 0, 0));
		user_Brand.setBounds(26, 281, 71, 21);
		Build_Tab.add(user_Brand);
		
		JLabel User_processor = new JLabel("PROCESSOR");
		User_processor.setForeground(Color.BLACK);
		User_processor.setBackground(Color.WHITE);
		User_processor.setFont(new Font("Tahoma", Font.BOLD, 13));
		User_processor.setBounds(269, 281, 106, 21);
		Build_Tab.add(User_processor);
		
		JLabel user_Ram = new JLabel("RAM");
		user_Ram.setForeground(Color.BLACK);
		user_Ram.setBackground(Color.WHITE);
		user_Ram.setFont(new Font("Tahoma", Font.BOLD, 13));
		user_Ram.setBounds(26, 312, 77, 14);
		Build_Tab.add(user_Ram);
		
		JLabel user_Storage = new JLabel("STORAGE");
		user_Storage.setForeground(Color.BLACK);
		user_Storage.setBackground(Color.WHITE);
		user_Storage.setFont(new Font("Tahoma", Font.BOLD, 13));
		user_Storage.setBounds(269, 312, 106, 17);
		Build_Tab.add(user_Storage);
		
		userBrand = new JTextField();
		userBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userBrand.setForeground(Color.BLACK);
		userBrand.setBackground(Color.LIGHT_GRAY);
		userBrand.setToolTipText("Enter the brand");
		userBrand.setBounds(107, 278, 111, 20);
		Build_Tab.add(userBrand);
		userBrand.setColumns(10);
		
		userRam = new JTextField();
		userRam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userRam.setForeground(Color.BLACK);
		userRam.setBackground(Color.LIGHT_GRAY);
		userRam.setToolTipText("Ram needed");
		userRam.setBounds(107, 309, 111, 20);
		Build_Tab.add(userRam);
		userRam.setColumns(10);
		
		UserProcessor = new JTextField();
		UserProcessor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		UserProcessor.setForeground(Color.BLACK);
		UserProcessor.setBackground(Color.LIGHT_GRAY);
		UserProcessor.setToolTipText("Processor requirement");
		UserProcessor.setBounds(385, 278, 86, 20);
		Build_Tab.add(UserProcessor);
		UserProcessor.setColumns(10);
		
		userStorage = new JTextField();
		userStorage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		userStorage.setForeground(Color.BLACK);
		userStorage.setBackground(Color.LIGHT_GRAY);
		userStorage.setToolTipText("Space needed");
		userStorage.setBounds(385, 309, 86, 20);
		Build_Tab.add(userStorage);
		userStorage.setColumns(10);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(51, 92, 420, 170);
		Build_Tab.add(scroll);
		
			table_1 = new JTable();
			table_1.setBackground(Color.GRAY);
			table_1.setForeground(new Color(0, 0, 0));
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i=table_1.getSelectedRow();
					userBrand.setText(model1.getValueAt(i, 0).toString());
					UserProcessor.setText(model1.getValueAt(i, 1).toString());
					userRam.setText(model1.getValueAt(i, 2).toString());
					userStorage.setText(model1.getValueAt(i, 3).toString());
				}
			});
			table_1.setModel(model1);	    
			scroll.setViewportView(table_1);
			
			next_tab_final.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model=modelName.getText();
					serial=serialno.getText();
					area=others_complains.getText();
					iss = issueGroup.getSelection().getActionCommand();
					
					cusName.setText(name);
					cusMobile.setText(mobile);
					Product_model.setText(model);
					product_seialno.setText(serial);
					product_issues.setText(iss);
					others_issues.setText(area);
					
					Main_pane.setSelectedIndex(4);
				}
			});
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(537, 102, 161, 269);
			Build_Tab.add(scrollPane_1);
			
			JTree tree = new JTree();
			tree.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Available ") {
					{
						DefaultMutableTreeNode node_1;
						DefaultMutableTreeNode node_2;
						node_1 = new DefaultMutableTreeNode("Brand");
							node_1.add(new DefaultMutableTreeNode("Dell"));
							node_1.add(new DefaultMutableTreeNode("Hp"));
							node_1.add(new DefaultMutableTreeNode("Lenova"));
							node_1.add(new DefaultMutableTreeNode("Asus"));
							add(node_1);
						node_1 = new DefaultMutableTreeNode("Processor");
							node_2 = new DefaultMutableTreeNode("Intel");
								node_2.add(new DefaultMutableTreeNode("i-3"));
								node_2.add(new DefaultMutableTreeNode("i-5"));
								node_2.add(new DefaultMutableTreeNode("i-7"));
								node_2.add(new DefaultMutableTreeNode("i-9"));
							node_1.add(node_2);
							node_2 = new DefaultMutableTreeNode("Amd");
								node_2.add(new DefaultMutableTreeNode("Ryzen-3"));
								node_2.add(new DefaultMutableTreeNode("Ryzen-5"));
								node_2.add(new DefaultMutableTreeNode("Ryzen-7"));
								node_2.add(new DefaultMutableTreeNode("Ryzen-9"));
							node_1.add(node_2);
							add(node_1);
						node_1 = new DefaultMutableTreeNode("Ram");
							node_1.add(new DefaultMutableTreeNode("4GB"));
							node_1.add(new DefaultMutableTreeNode("8GB"));
							node_1.add(new DefaultMutableTreeNode("12GB"));
							node_1.add(new DefaultMutableTreeNode("16GB"));
							add(node_1);
						node_1 = new DefaultMutableTreeNode("Storage");
							node_2 = new DefaultMutableTreeNode("HDD");
								node_2.add(new DefaultMutableTreeNode("512GB"));
								node_2.add(new DefaultMutableTreeNode("1TB"));
								node_2.add(new DefaultMutableTreeNode("1.5TB"));
								node_2.add(new DefaultMutableTreeNode("2TB"));
								add(node_2);
							node_2 = new DefaultMutableTreeNode("SSD");
								node_2.add(new DefaultMutableTreeNode("256GB"));
								node_2.add(new DefaultMutableTreeNode("512GB"));
								node_2.add(new DefaultMutableTreeNode("1TB"));
							node_1.add(node_2);
							add(node_1);
					}
				}
			));
			tree.setForeground(Color.BLACK);
			tree.setBackground(Color.LIGHT_GRAY);
			scrollPane_1.setViewportView(tree);
			
			
			JPopupMenu popupMenu = new JPopupMenu();
			addPopup(Build_Tab, popupMenu);
			
			JMenuItem mntmNewMenuItem_6 = new JMenuItem("Refresh");
			mntmNewMenuItem_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model1.setRowCount(0);	
				}			
			});
			popupMenu.add(mntmNewMenuItem_6);
			
			JMenuItem mntmNewMenuItem_7 = new JMenuItem("Show features");
			mntmNewMenuItem_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollPane_1.setVisible(true);
					tree.setVisible(true);
				}
			});
			popupMenu.add(mntmNewMenuItem_7);
			
			JMenuItem mntmNewMenuItem_5 = new JMenuItem("Hide Features");
			mntmNewMenuItem_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollPane_1.setVisible(false);
				}
			});
			popupMenu.add(mntmNewMenuItem_5);
			
			JLabel build_Header = new JLabel("BUILD YOUR OWN PC");
			build_Header.setHorizontalAlignment(SwingConstants.CENTER);
			build_Header.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
			build_Header.setBackground(Color.YELLOW);
			build_Header.setForeground(Color.WHITE);
			build_Header.setBounds(180, 28, 291, 53);
			Build_Tab.add(build_Header);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 753, 22);
			Build_Tab.add(menuBar);
			
			JMenu Menu_Display = new JMenu("Display");
			Menu_Display.setForeground(Color.BLACK);
			Menu_Display.setFont(new Font("Tahoma", Font.BOLD, 15));
			menuBar.add(Menu_Display);
			
			JMenuItem Show_Menu = new JMenuItem("show");
			Show_Menu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			Show_Menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model1.setRowCount(0);
					try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						   Statement stmt = conn.createStatement();
						         ResultSet rs = stmt.executeQuery(QUERY);) 
								{
									if(rs.next())
									{ 
										do
										{
										row[0]=rs.getString(1);
										row[1]=rs.getString(2);
										row[2]=rs.getString(3);
										row[3]=rs.getString(4);
										
										model1.addRow(row);	
										}while(rs.next());
									}
									else
									{
										System.out.println("Record Not Found...");
									}
							  }
				   catch (SQLException e1) 
					{
						 e1.printStackTrace();
				    } 				
				}
			});
			Menu_Display.add(Show_Menu);
			
			JMenu clear_menu = new JMenu("clear");
			clear_menu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			Menu_Display.add(clear_menu);
			
			JMenuItem ClearTable = new JMenuItem("clear table");
			ClearTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
			ClearTable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model1.setRowCount(0);
				}
			});
			clear_menu.add(ClearTable);
			
			JMenuItem ClearTree = new JMenuItem("clear tree");
			ClearTree.setFont(new Font("Tahoma", Font.PLAIN, 14));
			ClearTree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tree.setVisible(false);
				}
			});
			clear_menu.add(ClearTree);
			JMenu Menu_Edit = new JMenu("Edit");
			Menu_Edit.setFont(new Font("Tahoma", Font.BOLD, 15));
			Menu_Edit.setForeground(Color.BLACK);
			menuBar.add(Menu_Edit);
			
			JMenuItem Add_data = new JMenuItem("add");
			Add_data.setFont(new Font("Tahoma", Font.PLAIN, 15));
			Add_data.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(userBrand.getText().equals("")||UserProcessor.getText().equals("")||userRam.getText().equals("")||userStorage.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please fill the details");
					}
					else
					{
						row[0]=userBrand.getText();
						row[1]=UserProcessor.getText();
						row[2]=userRam.getText();
						row[3]=userStorage.getText();
						Object str1= row[0];
						Object str2= row[1];
						Object str3= row[2];
						Object str4= row[3];						
						userBrand.setText("");
						UserProcessor.setText("");
						userRam.setText("");
						userStorage.setText("");
						model1.addRow(row);
					
						try
						{
							System.out.println("create stage");
							Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
							Statement stmt = conn.createStatement();
							String QUERY2="INSERT INTO `bluewave`.`laps`"+ " (`brand`, `processor`, `ram`, `storage`,`Current_Time_Stamp`)"+ "VALUES('" +str1+"','"+str2+"','"+str3+"','"+str4+"',CURRENT_TIMESTAMP)";
						          stmt.executeUpdate(QUERY2);
						          System.out.println("Success add");
						}
						catch (SQLException e1) 
						{
							 e1.printStackTrace();
						} 	
					}					
				}
			});
			Menu_Edit.add(Add_data);			
			JMenuItem update_data = new JMenuItem("update");
			update_data.setFont(new Font("Tahoma", Font.PLAIN, 15));
			update_data.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i=table_1.getSelectedRow();
					model1.setValueAt(userBrand.getText(),i,0);
					model1.setValueAt(UserProcessor.getText(),i,1);
					model1.setValueAt(userRam.getText(),i,2);
					model1.setValueAt(userStorage.getText(),i,3);
					userBrand.setText("");
					UserProcessor.setText("");
					userRam.setText("");
					userStorage.setText("");					
				}
			});
			Menu_Edit.add(update_data);			
			JMenu Menu_Exit = new JMenu("Exit");
			Menu_Exit.setForeground(Color.BLACK);
			Menu_Exit.setFont(new Font("Tahoma", Font.BOLD, 15));
			menuBar.add(Menu_Exit);			
			JMenuItem Close = new JMenuItem("close");
			Close.setFont(new Font("Tahoma", Font.PLAIN, 15));
			Close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);					
				}
			});
			Menu_Exit.add(Close);
					
		
		//************************************************************************************
		
		next_tab_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brand= brandGroup.getSelection().getActionCommand();
				process = processGroup.getSelection().getActionCommand();
				ram=option_Ram.getSelectedItem().toString();				
				cusName.setText(name);
				cusMobile.setText(mobile);				
				brand_choosed.setText(brand);
				processor_choosed.setText(process);
				ram_choosed.setText(ram);				
				Main_pane.setSelectedIndex(4);
			}
		});
		
		
		//***************************************************************************************		
		JLabel bluewave_title = new JLabel("BLUEWAVE LAPTOPS");
		bluewave_title.setHorizontalAlignment(SwingConstants.CENTER);
		bluewave_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		bluewave_title.setBounds(264, 11, 287, 45);
		bluewave_title.setBackground(Color.ORANGE);
		bluewave_title.setForeground(Color.BLACK);
		contentPane.add(bluewave_title);		
	}
	
	//****************************************event handler***********************
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "PROCEED");			
		}
		public void actionPerformed(ActionEvent e) {			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "BUY");			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SERVICE");			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");			
		}
		public void actionPerformed(ActionEvent e) {			
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Next");			
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "BUILD");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "CLEAR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
