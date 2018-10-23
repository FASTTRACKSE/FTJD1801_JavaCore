package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
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

import Dao.MonHocDAO;
import Dao.QuanHuyenDAO;
import Dao.QuanLiLopHocDAO;
import Dao.QuanLiSinhVienDAO;
import entity.MonHoc;
import entity.Phuong;
import entity.QuanHuyen;
import entity.QuanLiLopHoc;
import entity.QuanLiSinhVien;
import entity.TinhThanh;

public class BangDiemUI {
	ResultSet rs = null;
	Statement stmt;
	JComboBox cbo1 = new JComboBox();
	private ArrayList<MonHoc> arrMonHoc = new ArrayList<>();
	private ArrayList<MonHoc> arrMonHoc1 = new ArrayList<>();
	private ArrayList<QuanLiLopHoc> arrLop = new ArrayList<>();
	private ArrayList<QuanLiSinhVien> arr = new ArrayList<>();
	private MonHoc quanLiMonHocModel = new MonHoc();
	private MonHocDAO monHocStatement = new MonHocDAO();
	private QuanLiLopHoc quanLiLopHocModel = new QuanLiLopHoc();
	private QuanLiSinhVien quanLiSinhVienModel = new QuanLiSinhVien();
	private QuanLiLopHocDAO lopHocStatement = new QuanLiLopHocDAO();
	private QuanLiSinhVienDAO sinhVienStatement = new QuanLiSinhVienDAO();

	public JPanel pnBangDiem() {
		JPanel pnTab1 = new JPanel();

		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Bảng Điểm Sinh Viên", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		titlebor2.setTitleFont(titlebor2.getTitleFont().deriveFont(Font.BOLD, 30));
		titlebor2.setTitleColor(Color.BLACK);
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(920, 920));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from bangdiem");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Viên");
		dm.addColumn("Mã Lớp");
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Tên Môn Học");
		dm.addColumn("Kết Quả");

		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				String maSinhVien = rs.getString(1);
				String maLop = rs.getString(2);
				String maMonHoc = rs.getString(3);
				String tenMonHoc = rs.getString(4);
				String ketQua = rs.getString(5);

				Vector<String> vec = new Vector<String>();
				vec.add(maSinhVien);
				vec.add(maLop);
				vec.add(maMonHoc);
				vec.add(tenMonHoc);
				vec.add(ketQua);

				dm.addRow(vec);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		JScrollPane sc = new JScrollPane(tbl);
		pnTab1.add(sc, BorderLayout.CENTER);
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());

		JPanel pnFilter = new JPanel();
		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.SOUTH);
		JButton btnAdd = new JButton("Thêm Điểm");
		pnBtn.add(btnAdd);

		JButton btnEdit = new JButton("Sửa Điểm");
		pnBtn.add(btnEdit);

		JButton btnDelete = new JButton("Xóa Điểm");
		pnBtn.add(btnDelete);

		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(3, 3));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maLop = new JLabel("     Mã Lớp:");
		arrLop = lopHocStatement.sellectAllLop();
		pnText.add(maLop);
		JComboBox cboMaLop = new JComboBox();
		pnText.add(cboMaLop);

		JLabel maSinhVien = new JLabel("   Mã Sinh Viên:");

		pnText.add(maSinhVien);
		JComboBox cboMaSinhVien = new JComboBox();
		pnText.add(cboMaSinhVien);

		for (QuanLiLopHoc x : arrLop) {
			cboMaLop.addItem(x);
		}

		JLabel maMH = new JLabel("   Mã Môn Học:");
		arrMonHoc = monHocStatement.sellectMonHoc();
		pnText.add(maMH);
		JComboBox cboMaMonHoc = new JComboBox();
		pnText.add(cboMaMonHoc);

		JLabel maKhoa = new JLabel("    Tên Môn Học:");
		pnText.add(maKhoa);
		JComboBox cboMaKhoa = new JComboBox();
		pnText.add(cboMaKhoa);

		for (MonHoc x : arrMonHoc) {
			cboMaMonHoc.addItem(x);
		}
		JLabel ketQua = new JLabel("   Kết quả:");
		pnText.add(ketQua);
		JTextField txtKetQua = new JTextField(20);
		pnText.add(txtKetQua);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String masv = (String) tbl.getValueAt(row, 0);
				cboMaSinhVien.setToolTipText(masv);

				String malop = (String) tbl.getValueAt(row, 1);
				cboMaLop.setToolTipText(malop);

				String mamonhoc = (String) tbl.getValueAt(row, 2);
				cboMaMonHoc.setToolTipText(mamonhoc);

				String tenmon = (String) tbl.getValueAt(row, 3);
				cboMaKhoa.setToolTipText(tenmon);

				String diem = (String) tbl.getValueAt(row, 4);
				txtKetQua.setText(diem);

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

			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					stmt.execute(
							"Insert into bangdiem values(\'" + cboMaSinhVien.getItemAt(cboMaSinhVien.getSelectedIndex())
									+ "\',\'" + cboMaLop.getItemAt(cboMaLop.getSelectedIndex()) + "\',\'"
									+ cboMaMonHoc.getItemAt(cboMaMonHoc.getSelectedIndex()) + "\',\'"
									+ cboMaKhoa.getItemAt(cboMaKhoa.getSelectedIndex()) + "\',\'" + txtKetQua.getText()
									+ "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from bangdiem");
					try {
						while (rs.next()) {
							String maSinhVien = rs.getString(1);
							String maLop = rs.getString(2);
							String maMonHoc = rs.getString(3);
							String tenMonHoc = rs.getString(4);
							String ketQua = rs.getString(5);

							Vector<String> vec = new Vector<String>();
							vec.add(maSinhVien);
							vec.add(maLop);
							vec.add(maMonHoc);
							vec.add(tenMonHoc);
							vec.add(ketQua);

							dm.addRow(vec);

						}

					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}

			}
		});

		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String diem = txtKetQua.getText();
					String masv = (String) cboMaSinhVien.getItemAt(cboMaSinhVien.getSelectedIndex());

					stmt.executeUpdate("update bangdiem set ketqua =\"" + diem + "\" where masv = \"" + masv + "\" ");
					JOptionPane.showMessageDialog(null, "Sua thanh cong!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from bangdiem");
					try {
						while (rs.next()) {
							String maSinhVien = rs.getString(1);
							String maLop = rs.getString(2);
							String maMonHoc = rs.getString(3);
							String tenMonHoc = rs.getString(4);
							String ketQua = rs.getString(5);

							Vector<String> vec = new Vector<String>();
							vec.add(maSinhVien);
							vec.add(maLop);
							vec.add(maMonHoc);
							vec.add(tenMonHoc);
							vec.add(ketQua);

							dm.addRow(vec);

						}

					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maSv = txtKetQua.getText();
					if (txtKetQua.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa");
					} else {
						int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa",
								JOptionPane.YES_NO_OPTION);
						if (chose == JOptionPane.YES_OPTION) {
							String maKhoa1 = txtKetQua.getText();

							stmt.executeUpdate("delete from bangdiem WHERE ketqua = \"" + maKhoa1 + "\" ");
							int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
									JOptionPane.YES_NO_OPTION);
							if (ret != JOptionPane.YES_OPTION) {
								return;
							}
							dm.setRowCount(0);
							ResultSet rs = stmt.executeQuery("select * from bangdiem");
							try {
								while (rs.next()) {
									dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
											rs.getString(4), rs.getString(5) });

								}
							} catch (Exception ex1) {
								ex1.printStackTrace();
							}
							tbl.setModel(dm);
							dm.fireTableDataChanged();
						}
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});

		cboMaLop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maLop = null;
				// TODO Auto-generated method stub
				try {
					QuanLiLopHoc item = (QuanLiLopHoc) cboMaLop.getSelectedItem();
					maLop = item.getMaLop();

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				arr = sinhVienStatement.selectAll(maLop);
				cboMaSinhVien.removeAllItems();
				QuanLiSinhVien item = (QuanLiSinhVien) cboMaSinhVien.getSelectedItem();
				cboMaSinhVien.addItem(new QuanLiSinhVien("Chọn SV", null));
				for (QuanLiSinhVien x : arr) {
					cboMaSinhVien.addItem(x);
				}
			}
		});
		cboMaSinhVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		cboMaMonHoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maMonHoc = null;
				try {
					MonHoc item1 = (MonHoc) cboMaMonHoc.getSelectedItem();
					maMonHoc = item1.getMaMon();

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				arrMonHoc1 = monHocStatement.sellectMonHoc1(maMonHoc);
				cboMaKhoa.removeAllItems();
				MonHoc item1 = (MonHoc) cboMaKhoa.getSelectedItem();
				cboMaKhoa.addItem(new MonHoc("", null));
				for (MonHoc x : arrMonHoc1) {
					cboMaKhoa.addItem(x);
				}
			}
		});
		return pnTab1;

	}
}