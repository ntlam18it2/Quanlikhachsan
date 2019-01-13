package quanlikhachsan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tftenkhachhang;
	private JTextField tfcmnd;
	private JTextField tfquoctich;
	private JTextField tftuoi;
	private JTextField tflienlac;
	private JTable table_1;
	private JTable table_3;
	java.sql.Connection conn;
	Statement stmt;
	ResultSet rs;
	JScrollPane tableResult1,tableResult2,tableResult3;
	DefaultTableModel model1, model2, model3;
	JTable tb1 = new JTable();
	JTable tb2 = new JTable();
	JTable tb3 = new JTable();
	Vector vData1 = new Vector();
	Vector vData2 = new Vector();
	Vector vTitle1 = new Vector();
	Vector vTitle2 = new Vector();
	public void connectDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			if(conn!=null) System.out.println("Connect Sucess");
			else System.out.println("Connect Fail");
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
					Main frame = new Main();
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
	public Main() {
		setTitle("Khách sạn Your Name");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, 1380, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(30, 144, 255));
		tabbedPane.setBounds(10, 140, 1346, 618);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 10, 300, 557);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTnKhchHng = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblTnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTnKhchHng.setBounds(10, 10, 186, 24);
		panel_2.add(lblTnKhchHng);
		
		JLabel lblCmndthCnCc = new JLabel("CMND/Th\u1EBB c\u0103n c\u01B0\u1EDBc");
		lblCmndthCnCc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCmndthCnCc.setBounds(10, 78, 186, 24);
		panel_2.add(lblCmndthCnCc);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiiTnh.setBounds(10, 149, 186, 24);
		panel_2.add(lblGiiTnh);
		
		JLabel lblQucTch = new JLabel("Qu\u1ED1c t\u1ECBch");
		lblQucTch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblQucTch.setBounds(10, 217, 186, 24);
		panel_2.add(lblQucTch);
		
		JLabel lblTui = new JLabel("Tu\u1ED5i");
		lblTui.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTui.setBounds(10, 285, 186, 24);
		panel_2.add(lblTui);
		
		JLabel lblLinLc = new JLabel("Li\u00EAn l\u1EA1c");
		lblLinLc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLinLc.setBounds(10, 353, 186, 24);
		panel_2.add(lblLinLc);
		
		tftenkhachhang = new JTextField();
		tftenkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tftenkhachhang.setBounds(10, 44, 280, 24);
		panel_2.add(tftenkhachhang);
		tftenkhachhang.setColumns(10);
		
		tfcmnd = new JTextField();
		tfcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfcmnd.setColumns(10);
		tfcmnd.setBounds(10, 112, 280, 24);
		panel_2.add(tfcmnd);
		
		tfquoctich = new JTextField();
		tfquoctich.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfquoctich.setColumns(10);
		tfquoctich.setBounds(10, 251, 280, 24);
		panel_2.add(tfquoctich);
		
		tftuoi = new JTextField();
		tftuoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tftuoi.setColumns(10);
		tftuoi.setBounds(10, 319, 280, 24);
		panel_2.add(tftuoi);
		
		tflienlac = new JTextField();
		tflienlac.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tflienlac.setColumns(10);
		tflienlac.setBounds(10, 387, 280, 24);
		panel_2.add(tflienlac);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(10, 183, 142, 24);
		panel_2.add(comboBox);
		
		JButton btnthemkhachhang = new JButton("Th\u00EAm kh\u00E1ch h\u00E0ng");
		btnthemkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnthemkhachhang.setBounds(60, 451, 178, 24);
		panel_2.add(btnthemkhachhang);
		
		JButton btnxoakhachhang = new JButton("X\u00F3a kh\u00E1ch h\u00E0ng");
		btnxoakhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnxoakhachhang.setBounds(60, 485, 178, 24);
		panel_2.add(btnxoakhachhang);
		
		JButton btnbochon = new JButton("B\u1ECF ch\u1ECDn");
		btnbochon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnbochon.setBounds(60, 519, 178, 24);
		panel_2.add(btnbochon);
		
		JPanel pphong = new JPanel();
		pphong.setBackground(new Color(135, 206, 235));
		pphong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pphong.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ph\u00F2ng tr\u1ED1ng", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pphong.setBounds(320, 10, 220, 300);
		panel_1.add(pphong);
		pphong.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(135, 206, 235));
		panel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kh\u00E1ch h\u00E0ng ch\u1EDD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(561, 10, 220, 300);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel pnv = new JPanel();
		pnv.setBackground(new Color(135, 206, 235));
		pnv.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pnv.setBorder(new TitledBorder(null, "Nh\u00E2n vi\u00EAn ti\u1EBFp nh\u1EADn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		pnv.setBounds(801, 10, 220, 300);
		panel_1.add(pnv);
		pnv.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(135, 206, 235));
		panel_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_7.setBorder(new TitledBorder(null, "Ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_7.setBounds(320, 325, 701, 242);
		panel_1.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_7.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(135, 206, 235));
		panel_3.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch s\u1EA1n", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_3.setBounds(1031, 95, 300, 330);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1ED5ng s\u1ED1 ph\u00F2ng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 28, 151, 28);
		panel_3.add(lblNewLabel);
		
		JLabel label = new JLabel("loading...");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(169, 28, 121, 28);
		panel_3.add(label);
		
		JLabel lblSPhng = new JLabel("S\u1ED1 ph\u00F2ng \u0111\u00E3 \u0111\u1EB7t");
		lblSPhng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSPhng.setBounds(10, 66, 151, 28);
		panel_3.add(lblSPhng);
		
		JLabel lblSPhngTrng = new JLabel("S\u1ED1 ph\u00F2ng tr\u1ED1ng");
		lblSPhngTrng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSPhngTrng.setBounds(10, 104, 151, 28);
		panel_3.add(lblSPhngTrng);
		
		JLabel lblTngSKhch = new JLabel("T\u1ED5ng s\u1ED1 kh\u00E1ch h\u00E0ng");
		lblTngSKhch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTngSKhch.setBounds(10, 142, 151, 28);
		panel_3.add(lblTngSKhch);
		
		JLabel lblKhchHng_1 = new JLabel("Kh\u00E1ch h\u00E0ng \u0111\u00E3 qua");
		lblKhchHng_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKhchHng_1.setBounds(10, 180, 151, 28);
		panel_3.add(lblKhchHng_1);
		
		JLabel lblKhchHngang = new JLabel("Kh\u00E1ch h\u00E0ng \u0111ang ch\u1EDD");
		lblKhchHngang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKhchHngang.setBounds(10, 218, 151, 28);
		panel_3.add(lblKhchHngang);
		
		JLabel lblTngSNhn = new JLabel("T\u1ED5ng s\u1ED1 nh\u00E2n vi\u00EAn");
		lblTngSNhn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTngSNhn.setBounds(10, 256, 151, 28);
		panel_3.add(lblTngSNhn);
		
		JLabel lblNgy = new JLabel("Ng\u00E0y");
		lblNgy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgy.setBounds(10, 294, 151, 28);
		panel_3.add(lblNgy);
		
		JButton btnlammoi = new JButton("L\u00E0m m\u1EDBi");
		btnlammoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnlammoi.setBounds(1084, 23, 161, 51);
		panel_1.add(btnlammoi);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(135, 206, 235));
		panel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_6.setBounds(1054, 450, 244, 95);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btndatphong = new JButton("\u0110\u1EB6T PH\u00D2NG");
		btndatphong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btndatphong.setBounds(59, 10, 131, 32);
		panel_6.add(btndatphong);
		
		JButton btnQuayLi = new JButton("QUAY L\u1EA0I");
		btnQuayLi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnQuayLi.setBounds(59, 53, 131, 32);
		panel_6.add(btnQuayLi);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(30, 144, 255));
		toolBar.setBounds(10, 10, 1346, 120);
		contentPane.add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setLayout(null);
		toolBar.add(panel);
		
		JButton btnkhachhang = new JButton("");
		btnkhachhang.setIcon(new ImageIcon("D:\\Java\\quanlikhachsan\\anh\\khachhang.png"));
		btnkhachhang.setHorizontalTextPosition(SwingConstants.CENTER);
		btnkhachhang.setOpaque(false);
		btnkhachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Khachhang kh = new Khachhang();
				kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				kh.setVisible(true);
				
			}
		});
		btnkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnkhachhang.setBounds(10, 10, 85, 61);
		panel.add(btnkhachhang);
		
		JButton btnphong = new JButton("");
		btnphong.setIcon(new ImageIcon("D:\\Java\\quanlikhachsan\\anh\\phong.png"));
		btnphong.setHorizontalTextPosition(SwingConstants.CENTER);
		btnphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Phong phong = new Phong();
				phong.setVisible(true);
				phong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnphong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnphong.setBounds(117, 10, 85, 61);
		panel.add(btnphong);
		
		JButton btnnhanvien = new JButton("");
		btnnhanvien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnnhanvien.setIcon(new ImageIcon("D:\\Java\\quanlikhachsan\\anh\\nhanvien.png"));
		btnnhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nhanvien nv = new Nhanvien();
				nv.setVisible(true);
				nv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnnhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnnhanvien.setBounds(222, 10, 85, 61);
		panel.add(btnnhanvien);
		
		JButton btndichvu = new JButton("New button");
		btndichvu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dichvu dv = new Dichvu();
				dv.setVisible(true);
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btndichvu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btndichvu.setBounds(329, 10, 85, 61);
		panel.add(btndichvu);
		
		JButton btntraphong = new JButton("New button");
		btntraphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Traphong traphong = new Traphong();
				traphong.setVisible(true);
				traphong.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btntraphong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btntraphong.setBounds(438, 10, 85, 61);
		panel.add(btntraphong);
		
		JButton button_5 = new JButton("New button");
		button_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_5.setBounds(1130, 10, 85, 61);
		panel.add(button_5);
		
		JButton btndangxuat = new JButton("New button");
		btndangxuat.setIcon(new ImageIcon("D:\\Java\\quanlikhachsan\\anh\\exit.png"));
		btndangxuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btndangxuat.setBounds(1252, 10, 58, 61);
		panel.add(btndangxuat);
		
		JLabel lblKhchHng = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblKhchHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKhchHng.setBounds(10, 81, 85, 22);
		panel.add(lblKhchHng);
		
		JLabel lblPhng = new JLabel("Ph\u00F2ng");
		lblPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhng.setBounds(117, 81, 85, 22);
		panel.add(lblPhng);
		
		JLabel lblNhnVin = new JLabel("Nh\u00E2n vi\u00EAn");
		lblNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhnVin.setBounds(222, 81, 85, 22);
		panel.add(lblNhnVin);
		
		JLabel lblPhcV = new JLabel("D\u1ECBch v\u1EE5");
		lblPhcV.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhcV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhcV.setBounds(329, 81, 85, 22);
		panel.add(lblPhcV);
		
		JLabel label_6 = new JLabel("Tr\u1EA3 ph\u00F2ng");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_6.setBounds(438, 81, 85, 22);
		panel.add(label_6);
		
		JLabel label_5 = new JLabel("T\u00E0i kho\u1EA3n");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_5.setBounds(1130, 81, 85, 22);
		panel.add(label_5);
		
		JLabel label_4 = new JLabel("\u0110\u0103ng xu\u1EA5t");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_4.setBounds(1238, 81, 85, 22);
		panel.add(label_4);
		
		
		HienthiPhong();
		model1 = new DefaultTableModel(vData1, vTitle1);
		tb1 = new JTable(model1);
		tableResult1 = new JScrollPane(tb1);
		pphong.add(tableResult1);
		
		
		HienthiNhanvien();
		model3 = new DefaultTableModel(vData2, vTitle2);
		tb3 = new JTable(model3);
		tableResult3 = new JScrollPane(tb3);
		pnv.add(tableResult3);
		
	}
	public void HienthiPhong()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			vData1.clear();
			vTitle1.clear();
			ResultSet rs = stmt.executeQuery("Select Maphong, Tenphong, Loaiphong from phong where TinhTrang ='Chưa đặt'");
			ResultSetMetaData rsm = rs.getMetaData();
			int colum = rsm.getColumnCount();
			for(int i=1;i<=colum;i++)
			{
				vTitle1.add(rsm.getColumnLabel(i));
			}
			while(rs.next())
			{
				Vector row1 = new Vector(colum);
				for(int i=1;i<=colum;i++)
				{
					row1.add(rs.getString(i));
					System.out.println(rsm.getColumnLabel(i));
				}
				vData1.add(row1);
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void HienthiNhanvien()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			vData2.clear();
			vTitle2.clear();
			ResultSet rs = stmt.executeQuery("Select MaNV, TenNV, ChucVu from nhanvien");
			ResultSetMetaData rsm = rs.getMetaData();
			int column = rsm.getColumnCount();
			for(int i=1;i<=column;i++)
			{
				vTitle2.add(rsm.getColumnLabel(i));
			}
			while(rs.next())
			{
				Vector row2 = new Vector(column);
				for(int i=1;i<=column;i++)
				{
					row2.add(rs.getString(i));
					System.out.println(rsm.getColumnLabel(i));
				}
				vData2.add(row2);
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
