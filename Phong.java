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
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Phong extends JFrame {

	private JPanel contentPane;
	private JTextField tftenphong;
	private JTextField tfgiaphong;
	private JTextField tfchuthich;
	private JTextField tfmaphong;
	private JTextField tfmanv;
	private JTextField tfmadv;
	private JComboBox cboloaiphong;
	private JComboBox cbotinhtrang ;
	JLabel lbltongsophong;
	
	Connection conn;
	Statement stmt;
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	public void connectDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			System.out.println("Connect Sucess");
		} catch (Exception e) {
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
					Phong frame = new Phong();
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
	public Phong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, 1380, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA ph\u00F2ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 82, 338, 669);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1ED5ng s\u1ED1 ph\u00F2ng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 49, 140, 41);
		panel.add(lblNewLabel);
		
		JLabel lblSPhngTrng = new JLabel("S\u1ED1 ph\u00F2ng tr\u1ED1ng:");
		lblSPhngTrng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhngTrng.setBounds(10, 124, 140, 41);
		panel.add(lblSPhngTrng);
		
		JLabel lblSPhng = new JLabel("S\u1ED1 ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t:");
		lblSPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhng.setBounds(10, 203, 140, 41);
		panel.add(lblSPhng);
		
		JLabel lblSPhngn = new JLabel("S\u1ED1 ph\u00F2ng \u0111\u01A1n:");
		lblSPhngn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhngn.setBounds(10, 284, 140, 41);
		panel.add(lblSPhngn);
		
		JLabel lblSPhngi = new JLabel("S\u1ED1 ph\u00F2ng \u0111\u00F4i:");
		lblSPhngi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhngi.setBounds(10, 373, 140, 41);
		panel.add(lblSPhngi);
		
		JLabel lblSPhngBa = new JLabel("S\u1ED1 ph\u00F2ng ba:");
		lblSPhngBa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhngBa.setBounds(10, 460, 140, 41);
		panel.add(lblSPhngBa);
		
		JLabel lblSPhngVip = new JLabel("S\u1ED1 ph\u00F2ng Vip:");
		lblSPhngVip.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSPhngVip.setBounds(10, 547, 140, 41);
		panel.add(lblSPhngVip);
		
		lbltongsophong = new JLabel("");
		lbltongsophong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltongsophong.setBounds(188, 49, 140, 41);
		panel.add(lbltongsophong);
		
		JLabel lblsophongtrong = new JLabel("");
		lblsophongtrong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongtrong.setBounds(188, 124, 140, 41);
		panel.add(lblsophongtrong);
		
		JLabel lblsophongdadat = new JLabel("");
		lblsophongdadat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongdadat.setBounds(188, 203, 140, 41);
		panel.add(lblsophongdadat);
		
		JLabel lblsophongdon = new JLabel("");
		lblsophongdon.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongdon.setBounds(188, 284, 140, 41);
		panel.add(lblsophongdon);
		
		JLabel lblsophongdoi = new JLabel("");
		lblsophongdoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongdoi.setBounds(188, 373, 140, 41);
		panel.add(lblsophongdoi);
		
		JLabel lblsophongba = new JLabel("");
		lblsophongba.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongba.setBounds(188, 460, 140, 41);
		panel.add(lblsophongba);
		
		JLabel lblsophongVip = new JLabel("");
		lblsophongVip.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsophongVip.setBounds(188, 547, 140, 41);
		panel.add(lblsophongVip);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(358, 82, 998, 669);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 153));
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch ph\u00F2ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 327, 978, 332);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblTnPhng = new JLabel("T\u00EAn ph\u00F2ng");
		lblTnPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnPhng.setBounds(348, 32, 103, 32);
		panel_1.add(lblTnPhng);
		
		tftenphong = new JTextField();
		tftenphong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tftenphong.setBounds(461, 32, 170, 32);
		panel_1.add(tftenphong);
		tftenphong.setColumns(10);
		
		JLabel lblLoiPhng = new JLabel("Lo\u1EA1i ph\u00F2ng");
		lblLoiPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLoiPhng.setBounds(754, 32, 103, 32);
		panel_1.add(lblLoiPhng);
		
		cboloaiphong = new JComboBox();
		cboloaiphong.setModel(new DefaultComboBoxModel(new String[] {"Phòng đơn", "Phòng đôi", "Phòng ba", "Phòng Vip"}));
		cboloaiphong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cboloaiphong.setBounds(867, 32, 121, 32);
		panel_1.add(cboloaiphong);
		
		JLabel lblGiPhng = new JLabel("Gi\u00E1 ph\u00F2ng");
		lblGiPhng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGiPhng.setBounds(10, 74, 103, 32);
		panel_1.add(lblGiPhng);
		
		tfgiaphong = new JTextField();
		tfgiaphong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfgiaphong.setColumns(10);
		tfgiaphong.setBounds(123, 74, 170, 32);
		panel_1.add(tfgiaphong);
		
		JLabel lblChThch = new JLabel("Ch\u00FA th\u00EDch");
		lblChThch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChThch.setBounds(10, 158, 103, 32);
		panel_1.add(lblChThch);
		
		tfchuthich = new JTextField();
		tfchuthich.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfchuthich.setBounds(123, 158, 508, 88);
		panel_1.add(tfchuthich);
		tfchuthich.setColumns(10);
		
		JButton btnthem = new JButton("Th\u00EAm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectDB();
					stmt = (Statement) conn.createStatement();
					String loaiphong = "";
					if(cboloaiphong.getSelectedIndex()==0) loaiphong = "Phòng đơn";
					if(cboloaiphong.getSelectedIndex()==1) loaiphong = "Phòng đôi";
					if(cboloaiphong.getSelectedIndex()==2) loaiphong = "Phòng ba";
					if(cboloaiphong.getSelectedIndex()==3) loaiphong = "Phòng Vip";
					
					String tinhtrang = "";
					if(cbotinhtrang.getSelectedIndex() == 0) tinhtrang = "Phòng trống";
					else tinhtrang = "Phòng đã đặt";
					int n = stmt.executeUpdate("Insert into phong values ('"+tfmaphong.getText()+"','"+tftenphong.getText()+"','"+loaiphong+"',"
					+Double.parseDouble(tfgiaphong.getText())+",'"+tfchuthich.getText()+"','"+tinhtrang+"','"+tfmanv.getText()+"','"+tfmadv.getText()+"')");
					if(n>0) JOptionPane.showMessageDialog(null,"Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
					conn.close();
					stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnthem.setBounds(753, 143, 131, 39);
		panel_1.add(btnthem);
		
		JButton btnxoa = new JButton("X\u00F3a");
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnxoa.setBounds(753, 207, 131, 39);
		panel_1.add(btnxoa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm ph\u00F2ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(338, 262, 317, 55);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ph\u00F2ng tr\u1ED1ng", "Ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t", "Ph\u00F2ng \u0111\u01A1n", "Ph\u00F2ng \u0111\u00F4i", "Ph\u00F2ng ba", "Ph\u00F2ng Vip"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_3.add(comboBox_1);
		
		JLabel lblmaphong = new JLabel("M\u00E3 ph\u00F2ng");
		lblmaphong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblmaphong.setBounds(10, 32, 103, 32);
		panel_1.add(lblmaphong);
		
		tfmaphong = new JTextField();
		tfmaphong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfmaphong.setColumns(10);
		tfmaphong.setBounds(123, 32, 170, 32);
		panel_1.add(tfmaphong);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblMNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMNhnVin.setBounds(10, 116, 103, 32);
		panel_1.add(lblMNhnVin);
		
		tfmanv = new JTextField();
		tfmanv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfmanv.setColumns(10);
		tfmanv.setBounds(123, 116, 170, 32);
		panel_1.add(tfmanv);
		
		JLabel lblMDchV = new JLabel("M\u00E3 d\u1ECBch v\u1EE5");
		lblMDchV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMDchV.setBounds(348, 116, 103, 32);
		panel_1.add(lblMDchV);
		
		tfmadv = new JTextField();
		tfmadv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfmadv.setColumns(10);
		tfmadv.setBounds(461, 116, 170, 32);
		panel_1.add(tfmadv);
		
		JLabel lblTnhTrng = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblTnhTrng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTnhTrng.setBounds(348, 74, 103, 32);
		panel_1.add(lblTnhTrng);
		
		cbotinhtrang = new JComboBox();
		cbotinhtrang.setModel(new DefaultComboBoxModel(new String[] {"Phòng trống", "Phòng đã đặt"}));
		cbotinhtrang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbotinhtrang.setBounds(461, 74, 170, 32);
		panel_1.add(cbotinhtrang);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1EC6 TH\u1ED0NG PH\u00D2NG");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(555, 10, 260, 59);
		contentPane.add(lblNewLabel_1);
		
		reload();
		model = new DefaultTableModel(vData, vTitle);
		tb = new JTable(model);
		tableResult = new JScrollPane(tb);
		panel_2.add(tableResult);
		
		
		TongSophong();
		
		
	}
	public void reload()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			vTitle.clear();
			vData.clear();
			ResultSet rs = stmt.executeQuery("Select * from phong");
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
	
	public void TongSophong()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(GioiTinh) FROM nhanvien WHERE GioiTinh = 'Nam'");
			ResultSetMetaData rsm = rs.getMetaData();
			String tongsophong = null;
			while(rs.next())
			{
				tongsophong = rs.getString(1);
			}
			lbltongsophong.setText(tongsophong);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
