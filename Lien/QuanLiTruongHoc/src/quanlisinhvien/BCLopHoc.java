package quanlisinhvien;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BCLopHoc extends JPanel {
	ResultSet rs = null;
	ResultSet rsNamHoc = null;
	ResultSet rsLopHoc = null;
	Vector<Vector> cbbVector;
	Vector<String> cbbVector2;
	Statement stmt;
	Connection con;
	int indexCbbNamHoc, indexCbbLopHoc;
	String namHoc, lopHoc;
	List list = new List();

	public BCLopHoc() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanlitruonghoc?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT * from lophoc");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsNamHoc = stmt.executeQuery("select namHoc from lophoc");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		Font fontOne = new Font(Font.SERIF, Font.ITALIC, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JPanel pnNull = new JPanel();
		pnCenter.add(pnNull);

		JPanel pnSeach = new JPanel();
		pnSeach.setLayout(new FlowLayout());
		JLabel lblSeach = new JLabel("Tìm theo");
		JComboBox cbbSeach = new JComboBox();
		cbbSeach.addItem("Tất cả");
		cbbSeach.addItem("Năm học");
		cbbSeach.setPreferredSize(new Dimension(200, 30));
		lblSeach.setFont(fontOne);
		cbbSeach.setFont(fontOne);
		pnCenter.add(lblSeach);
		pnSeach.add(cbbSeach);
		pnCenter.add(pnSeach);

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblNamHoc = new JLabel("Năm học");
		JComboBox cbbNamHoc = new JComboBox();
		cbbNamHoc.setPreferredSize(new Dimension(200, 30));
		lblNamHoc.setFont(fontOne);
		cbbNamHoc.setFont(fontOne);
		pnCenter.add(lblNamHoc);
		pnOne.add(cbbNamHoc);
		pnCenter.add(pnOne);
		cbbVector2 = list.AddList2(rsNamHoc);
		for (int i = 0; i < cbbVector2.size(); i++) {
			cbbNamHoc.addItem(cbbVector2.get(i));
		}

		

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(fontOne);
		pnCenter.add(btnSearch);

		JPanel pnTa = new JPanel();
		pnTa.setLayout(new FlowLayout());
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new FlowLayout());
		DefaultTableModel tblSinhVien = new DefaultTableModel();
		tblSinhVien.addColumn("Mã lớp học");
		tblSinhVien.addColumn("Tên lớp học");
		tblSinhVien.addColumn("Năm học");

		final JTable tbl = new JTable(tblSinhVien);
		try {
			while (rs.next()) {
				String maLH = rs.getString(1);
				String tenLH = rs.getString(2);
				String namHoc = rs.getString(3);

				Vector<String> vec = new Vector<String>();
				vec.add(maLH);
				vec.add(tenLH);
				vec.add(namHoc);

				tblSinhVien.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTa.add(sc);
		pnTa.setBorder(borderTitle);

		cbbNamHoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				indexCbbNamHoc = cbbNamHoc.getSelectedIndex();
				namHoc = cbbVector2.get(indexCbbNamHoc);
			}
		});

		

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbSeach.getSelectedIndex();
					if (index == 0) {
						tblSinhVien.setRowCount(0);
						rs = stmt.executeQuery("Select * from lophoc where namHoc = \'" +namHoc +"\'");
						while (rs.next()) {
							String maLH = rs.getString(1);
							String tenLH = rs.getString(2);
							String namHoc = rs.getString(3);

							Vector<String> vec = new Vector<String>();
							vec.add(maLH);
							vec.add(tenLH);
							vec.add(namHoc);

							tblSinhVien.addRow(vec);
						}
						tbl.setModel(tblSinhVien);
						tblSinhVien.fireTableDataChanged();
					} else {
						if (index == 1) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery("Select * from lophoc where namHoc = \'" +namHoc +"\'");

							while (rs.next()) {
								String maLH = rs.getString(1);
								String tenLH = rs.getString(2);
								String namHoc = rs.getString(3);

								Vector<String> vec = new Vector<String>();
								vec.add(maLH);
								vec.add(tenLH);
								vec.add(namHoc);

								tblSinhVien.addRow(vec);
					}
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						
					}

				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		add(pnCenter);
		add(pnTa);
	}

}
