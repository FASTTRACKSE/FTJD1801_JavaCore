package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ThongKeLopHocUI {
	ResultSet rs = null;
	ResultSet rs1 = null;
	Statement stmt;
	public JComboBox cboNamHoc;
	private DefaultTableModel dm;
	private JTable tbLop;
	private JButton btnThoat;

	public JPanel pnThongKe() {
		JPanel pnTab1 = new JPanel();

		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thống kê Lớp Học", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		titlebor2.setTitleFont(titlebor2.getTitleFont().deriveFont(Font.BOLD, 30));
		titlebor2.setTitleColor(Color.BLACK);
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(920, 920));

		JPanel main2 = new JPanel();
		main2.setLayout(new BorderLayout());
		pnTab1.add(main2, BorderLayout.CENTER);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery(" select malop,tenlop,namhoc from lophoc ");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		dm = new DefaultTableModel();

		dm.addColumn("Mã lớp");
		dm.addColumn("Tên lớp");
		dm.addColumn("Năm học");

		tbLop = new JTable(dm);
		try {
			while (rs.next()) {

				String malop = rs.getString(1);
				String tenlop = rs.getString(2);
				String namhoc = rs.getString(3);

				Vector<String> vec = new Vector<String>();

				vec.add(malop);
				vec.add(tenlop);
				vec.add(namhoc);

				dm.addRow(vec);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		JScrollPane sc = new JScrollPane(tbLop);
		main2.add(sc, BorderLayout.CENTER);

		JPanel pnSearch = new JPanel();
		pnSearch.setLayout(new GridLayout(1, 3));

		JComboBox cbo = new JComboBox();
		cbo.addItem("Tất cả ");
		cbo.addItem("Năm Học");

		JTextField txtFilter = new JTextField(20);

		pnSearch.add(cbo);
		pnSearch.add(txtFilter);

		main2.add(pnSearch, BorderLayout.NORTH);

		JButton btnSearch = new JButton("search");

		pnSearch.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txtFilter.getText();
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				try {
					// TODO Auto-generated method stub

					if (n == 0) {
						String sql;
						if (text.equals(""))
							sql = "select * from lophoc";
						else
							sql = "select * from lophoc where namhoc =\'" + text + "\'";

						dm.setRowCount(0);
						ResultSet rs;
						try {
							rs = stmt.executeQuery(sql);

							while (rs.next()) {
								String malop = rs.getString(1);
								String tenlop = rs.getString(2);
								String namhoc = rs.getString(3);

								Vector<String> vec = new Vector<String>();

								vec.add(malop);
								vec.add(tenlop);
								vec.add(namhoc);

								dm.addRow(vec);

							}
						} catch (Exception ex1) {
							ex1.printStackTrace();
						}
						tbLop.setModel(dm);
						dm.fireTableDataChanged();
					} else {
						if (n == 1) {
							String sql;
							if (text.equals(""))
								sql = "select * from lophoc";
							else
								sql = "select * from lophoc where namhoc =\'" + text + "\'";

							dm.setRowCount(0);
							ResultSet rs;
							try {
								rs = stmt.executeQuery(sql);

								while (rs.next()) {
									String malop = rs.getString(1);
									String tenlop = rs.getString(2);
									String namhoc = rs.getString(3);

									Vector<String> vec = new Vector<String>();

									vec.add(malop);
									vec.add(tenlop);
									vec.add(namhoc);

									dm.addRow(vec);

								}

							} catch (Exception ex1) {
								ex1.printStackTrace();
							}
							tbLop.setModel(dm);
							dm.fireTableDataChanged();
						}
					}

				} catch (Exception e2) {
					System.err.println(e2);
				}

			}
		});

		return pnTab1;
	}
}