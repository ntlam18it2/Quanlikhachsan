package quanlikhachsan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Nhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField tftennv;
	private JTextField tfchucvu;
	private JTextField tfluong;
	private JTextField tfnamsinh;
	private JTextField tfchuthich;
	private JTextField tfmanv;
	private JLabel lbltongnv;
	private JLabel lbltongnvnam;
	private JLabel lbltongnvnu;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	JComboBox cbogioitinh;
	int selectedrow= 0;
	public void connectDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			if(conn != null)System.out.println("Connect Sucess");
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
					Nhanvien frame = new Nhanvien();
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
	public Nhanvien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, 1380, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 79, 399, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 83, 153, 33);
		panel.add(lblNewLabel);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChcV.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChcV.setBounds(10, 126, 153, 33);
		panel.add(lblChcV);
		
		JLabel lblLng = new JLabel("L\u01B0\u01A1ng");
		lblLng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLng.setBounds(10, 169, 153, 33);
		panel.add(lblLng);
		
		JLabel lblNmSinh = new JLabel("N\u0103m sinh");
		lblNmSinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNmSinh.setBounds(10, 212, 153, 33);
		panel.add(lblNmSinh);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGiiTnh.setBounds(10, 255, 153, 33);
		panel.add(lblGiiTnh);
		
		JLabel lblChThch = new JLabel("Ch\u00FA th\u00EDch");
		lblChThch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChThch.setBounds(10, 298, 153, 33);
		panel.add(lblChThch);
		
		JButton btnthem = new JButton("Th\u00EAm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connectDB();
					stmt = (Statement) conn.createStatement();
					String gt ="";
					if(cbogioitinh.getSelectedIndex()==0) gt="Nam";
					else gt ="Nữ";
					int n = stmt.executeUpdate("Insert into nhanvien values ('"+tfmanv.getText()+"','"+tftennv.getText()+"','"+tfchucvu.getText()+"',"
					+Double.parseDouble(tfluong.getText())+","+Integer.parseInt(tfnamsinh.getText())+",'"+gt+"','"+tfchuthich.getText()+"')");
					if (n>0) JOptionPane.showMessageDialog(null, "Succes");
					else JOptionPane.showMessageDialog(null, "Fail");
				
					model.fireTableDataChanged();
					reload();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnthem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnthem.setBounds(140, 363, 131, 33);
		panel.add(btnthem);
		
		JButton btnxoa = new JButton("X\u00F3a");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});
		btnxoa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnxoa.setBounds(140, 406, 131, 33);
		panel.add(btnxoa);
		
		tftennv = new JTextField();
		tftennv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tftennv.setBounds(169, 83, 220, 33);
		panel.add(tftennv);
		tftennv.setColumns(10);
		
		tfchucvu = new JTextField();
		tfchucvu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfchucvu.setColumns(10);
		tfchucvu.setBounds(169, 126, 220, 33);
		panel.add(tfchucvu);
		
		tfluong = new JTextField();
		tfluong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfluong.setColumns(10);
		tfluong.setBounds(169, 169, 220, 33);
		panel.add(tfluong);
		
		tfnamsinh = new JTextField();
		tfnamsinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfnamsinh.setColumns(10);
		tfnamsinh.setBounds(169, 212, 220, 33);
		panel.add(tfnamsinh);
		
		tfchuthich = new JTextField();
		tfchuthich.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfchuthich.setColumns(10);
		tfchuthich.setBounds(169, 298, 220, 33);
		panel.add(tfchuthich);
		
		cbogioitinh = new JComboBox();
		cbogioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbogioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		cbogioitinh.setBounds(169, 255, 220, 33);
		panel.add(cbogioitinh);
		
		JLabel lblMNhnVin = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblMNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMNhnVin.setBounds(10, 40, 153, 33);
		panel.add(lblMNhnVin);
		
		tfmanv = new JTextField();
		tfmanv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tfmanv.setColumns(10);
		tfmanv.setBounds(169, 40, 220, 33);
		panel.add(tfmanv);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(189, 183, 107));
		panel_1.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA nh\u00E2n vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 559, 399, 192);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTngNhnVin_2 = new JLabel("T\u1ED5ng Nh\u00E2n vi\u00EAn n\u1EEF");
		lblTngNhnVin_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTngNhnVin_2.setBounds(10, 149, 173, 33);
		panel_1.add(lblTngNhnVin_2);
		
		JLabel lblTngNhnVin_1 = new JLabel("T\u1ED5ng Nh\u00E2n vi\u00EAn nam");
		lblTngNhnVin_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTngNhnVin_1.setBounds(10, 88, 173, 33);
		panel_1.add(lblTngNhnVin_1);
		
		JLabel lblTngNhnVin = new JLabel("T\u1ED5ng Nh\u00E2n vi\u00EAn");
		lblTngNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTngNhnVin.setBounds(10, 30, 173, 33);
		panel_1.add(lblTngNhnVin);
		
		lbltongnvnu = new JLabel("");
		lbltongnvnu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltongnvnu.setBounds(216, 149, 173, 33);
		panel_1.add(lbltongnvnu);
		
		lbltongnv = new JLabel((String) null);
		lbltongnv.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltongnv.setBounds(216, 30, 173, 33);
		panel_1.add(lbltongnv);
		
		lbltongnvnam = new JLabel((String) null);
		lbltongnvnam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbltongnvnam.setBounds(216, 88, 173, 33);
		panel_1.add(lbltongnvnam);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(189, 183, 107));
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(419, 79, 937, 585);
		contentPane.add(panel_2);
		
		JLabel lblQunLNhn = new JLabel("QU\u1EA2N L\u00CD NH\u00C2N VI\u00CAN");
		lblQunLNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblQunLNhn.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblQunLNhn.setBounds(617, 10, 320, 59);
		contentPane.add(lblQunLNhn);
		
		JButton btnrefresh = new JButton("Refresh");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnrefresh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnrefresh.setBounds(813, 681, 152, 59);
		contentPane.add(btnrefresh);
		
		reload();
		model = new DefaultTableModel(vData, vTitle);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		tb = new JTable(model);
		
		
		Tongnv();
		Tongnvnu();
		Tongnvnam();
		
		
		tb.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				selectedrow = tb.getSelectedRow();
			}
		});
		tableResult = new JScrollPane(tb);
		panel_2.add(tableResult);
		
	}
	
	public void reload()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			vTitle.clear();
			vData.clear();
			ResultSet rs = stmt.executeQuery("Select * from nhanvien");
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
				
				}
				vData.add(row);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void delete()
	{
		try {
			// Lấy ND hàng đã chọn 
			Vector st = (Vector)vData.elementAt(selectedrow);
			// Tạo câu lệnh SQL và xóa dữ liệu khỏi bảng student trong csdl
			String sql = "Delete from nhanvien where MaNV ='"+st.elementAt(0)+"'";
			stmt.executeUpdate(sql);
			// Xóa ND hàng tương ứng trong vData
			vData.remove(selectedrow);
			// Cập nhật lại ND bảng hiển thị trên màn hình
			model.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void Tongnv()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8","root","");
			stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select count(GioiTinh) from nhanvien");
			ResultSetMetaData rsm = rs.getMetaData();
			String tongnv = null;
			while(rs.next())
			{
				tongnv = rs.getString(1);
			}
			lbltongnv.setText(tongnv);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void Tongnvnam()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(GioiTinh) FROM nhanvien WHERE GioiTinh = 'Nam'");
			ResultSetMetaData rsm = rs.getMetaData();
			String tongnvnam = null;
			while(rs.next())
			{
				tongnvnam = rs.getString(1);
			}
			lbltongnvnam.setText(tongnvnam);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void Tongnvnu()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/khachsan?useUnicode=true&characterEncoding=utf-8", "root", "");
			stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(GioiTinh) FROM nhanvien WHERE GioiTinh = 'Nữ'");
			ResultSetMetaData rsm = rs.getMetaData();
			String tongnvnu = null;
			while(rs.next())
			{
				tongnvnu = rs.getString(1);
			}
			lbltongnvnu.setText(tongnvnu);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	}

		
	

		
	

