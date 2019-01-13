package quanlikhachsan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Khachhang extends JFrame {

	private JPanel contentPane;
	private JTextField tftenkhachhang;
	private JTextField tfcmnd;
	private JTextField tfquoctich;
	private JTextField tftuoi;
	private JTextField tfsdt;
	private JComboBox cbogioitinh;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	private JTextField tfmakh;
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	
	public void connectDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			if(conn!= null)System.out.println("Connect Sucess");
			else System.out.println("Connect Fail");
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Khachhang frame = new Khachhang();
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
	public Khachhang() {
		setBackground(new Color(0, 255, 255));
		connectDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, 1380, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 204));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 255));
		panel_1.setBounds(10, 95, 320, 656);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 10, 300, 636);
		panel_1.add(panel);
		
		JLabel label = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label.setBounds(10, 93, 186, 24);
		panel.add(label);
		
		JLabel label_1 = new JLabel("CMND/Th\u1EBB c\u0103n c\u01B0\u1EDBc");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_1.setBounds(10, 161, 186, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_2.setBounds(10, 300, 186, 24);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Tu\u1ED5i");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_4.setBounds(10, 368, 186, 24);
		panel.add(label_4);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSinThoi.setBounds(10, 436, 186, 24);
		panel.add(lblSinThoi);
		
		tftenkhachhang = new JTextField();
		tftenkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tftenkhachhang.setColumns(10);
		tftenkhachhang.setBounds(10, 127, 280, 24);
		panel.add(tftenkhachhang);
		
		tfcmnd = new JTextField();
		tfcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfcmnd.setColumns(10);
		tfcmnd.setBounds(10, 195, 280, 24);
		panel.add(tfcmnd);
		
		tftuoi = new JTextField();
		tftuoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tftuoi.setColumns(10);
		tftuoi.setBounds(10, 402, 280, 24);
		panel.add(tftuoi);
		
		tfsdt = new JTextField();
		tfsdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfsdt.setColumns(10);
		tfsdt.setBounds(10, 470, 280, 24);
		panel.add(tfsdt);
		
		cbogioitinh = new JComboBox();
		cbogioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		cbogioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbogioitinh.setBounds(10, 334, 142, 24);
		panel.add(cbogioitinh);
		
		JButton btnthem = new JButton("Th\u00EAm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectDB();
					stmt = (Statement) conn.createStatement();
					String gt = "";
					if(cbogioitinh.getSelectedIndex()==0) gt = "Nam";
					else gt="Nữ";
					int n = stmt.executeUpdate("Insert into khachhang values('"+tfmakh.getText()+"','"+tftenkhachhang.getText()+"',"
					+Integer.parseInt(tfcmnd.getText())+",'"+tfquoctich.getText()+"','"+gt+"',"+Integer.parseInt(tftuoi.getText())+","+Integer.parseInt(tfsdt.getText())+",'')");
					if (n>0) JOptionPane.showMessageDialog(null, "Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
					conn.close();
					stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnthem.setBounds(61, 521, 178, 24);
		panel.add(btnthem);
		
		JButton btnsua = new JButton("S\u1EEDa");
		btnsua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnsua.setBounds(61, 555, 178, 24);
		panel.add(btnsua);
		
		JButton btnxoa = new JButton("X\u00F3a");
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnxoa.setBounds(61, 589, 178, 24);
		panel.add(btnxoa);
		
		JLabel label_3 = new JLabel("Qu\u1ED1c t\u1ECBch");
		label_3.setBounds(10, 229, 186, 24);
		panel.add(label_3);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		tfquoctich = new JTextField();
		tfquoctich.setBounds(10, 263, 280, 24);
		panel.add(tfquoctich);
		tfquoctich.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfquoctich.setColumns(10);
		
		JLabel lblMKhchHng = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng");
		lblMKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMKhchHng.setBounds(10, 25, 186, 24);
		panel.add(lblMKhchHng);
		
		tfmakh = new JTextField();
		tfmakh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfmakh.setColumns(10);
		tfmakh.setBounds(10, 59, 280, 24);
		panel.add(tfmakh);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 204, 255));
		panel_2.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(340, 95, 314, 300);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTngSKhch = new JLabel("T\u1ED5ng s\u1ED1 kh\u00E1ch h\u00E0ng");
		lblTngSKhch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTngSKhch.setBounds(10, 52, 172, 28);
		panel_2.add(lblTngSKhch);
		
		JLabel lblTngSKhch_1 = new JLabel("T\u1ED5ng s\u1ED1 kh\u00E1ch h\u00E0ng nam");
		lblTngSKhch_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTngSKhch_1.setBounds(10, 105, 172, 28);
		panel_2.add(lblTngSKhch_1);
		
		JLabel lblTngSKhch_2 = new JLabel("T\u1ED5ng s\u1ED1 kh\u00E1ch h\u00E0ng n\u1EEF");
		lblTngSKhch_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTngSKhch_2.setBounds(10, 163, 151, 28);
		panel_2.add(lblTngSKhch_2);
		
		JButton btnlammoi = new JButton("L\u00E0m m\u1EDBi");
		btnlammoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnlammoi.setBounds(97, 222, 129, 40);
		panel_2.add(btnlammoi);
		
		JLabel label_6 = new JLabel("loading...");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_6.setBounds(183, 52, 121, 28);
		panel_2.add(label_6);
		
		JLabel lblNewLabel = new JLabel("TH\u1ED0NG K\u00CA KH\u00C1CH H\u00C0NG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel.setBounds(538, 10, 360, 53);
		contentPane.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 204, 255));
		panel_3.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(664, 95, 673, 299);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbltimkhachtheophong = new JLabel("T\u00ECm kh\u00E1ch theo ph\u00F2ng");
		lbltimkhachtheophong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltimkhachtheophong.setBounds(396, 425, 185, 32);
		contentPane.add(lbltimkhachtheophong);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox_1.setBounds(578, 425, 185, 32);
		contentPane.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 204, 255));
		panel_5.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_5.setBounds(845, 463, 492, 288);
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_5.add(scrollPane_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 204, 255));
		panel_4.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_4.setBounds(340, 464, 492, 287);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		
		JLabel lblTmKhchTheo = new JLabel("Tìm khách theo quốc tịch");
		lblTmKhchTheo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTmKhchTheo.setBounds(902, 425, 196, 32);
		contentPane.add(lblTmKhchTheo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(1108, 425, 185, 32);
		contentPane.add(comboBox);
		
		reload();
		model = new DefaultTableModel(vData, vTitle);
		tb = new JTable(model);
		tableResult = new JScrollPane(tb);
		panel_3.add(tableResult);
		
	}
	public void reload()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			vTitle.clear();
			vData.clear();
			ResultSet rs = stmt.executeQuery("Select * from khachhang");
			ResultSetMetaData rsm = rs.getMetaData();
			int num_column =rsm.getColumnCount();
			for(int i=1;i<=num_column;i++)
			{
				vTitle.add(rsm.getColumnLabel(i));
			}
			while(rs.next())
			{
				Vector row = new Vector(num_column);
				for(int i=1;i<=num_column;i++)
				{
					row.add(rs.getString(i));
					System.out.println(rsm.getColumnLabel(i));
				}
				vData.add(row);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
