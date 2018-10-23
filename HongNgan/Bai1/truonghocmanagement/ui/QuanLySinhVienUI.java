package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.PhuongDAO;
import Dao.QuanHuyenDAO;

import Dao.QuanLiSinhVienDAO;
import Dao.TinhThanhDAO;

import entity.Phuong;
import entity.QuanHuyen;
import entity.QuanLiLopHoc;
import entity.QuanLiSinhVien;
import entity.TinhThanh;

public class QuanLySinhVienUI extends JFrame {
	ResultSet rs;

	Statement stmt;
	Connection con;

	private ArrayList<QuanLiLopHoc> arrLop = new ArrayList<>();
	private ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	private ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	private ArrayList<Phuong> arrPhuong = new ArrayList<>();
	private ArrayList<QuanLiSinhVien> arrSinhVien = new ArrayList<>();
	private QuanLiSinhVien quanLiSinhVienModel = new QuanLiSinhVien();
	private TinhThanh tinhThanhModel = new TinhThanh();
	private QuanHuyen quanHuyenModel = new QuanHuyen();
	private Phuong phuongModel = new Phuong();
	private QuanLiSinhVienDAO quanLiSinhVienStatement = new QuanLiSinhVienDAO();
	private TinhThanhDAO tinhThanhStatement = new TinhThanhDAO();
	private QuanHuyenDAO quanHuyenStatement = new QuanHuyenDAO();
	private PhuongDAO phuongStatement = new PhuongDAO();
	private String provinceId, districtId, nameTinhThanh, nameQuanHuyen, namePhuong;
	JComboBox cboPhuong1 = new JComboBox();
	JComboBox cboQuan1;
	JComboBox cboTP = new JComboBox();

	JComboBox cboMaLop;
	JTextField txtMaKH;
	JTextField txtHoTen;
	JTextField txtDiaChi;
	JTextField txtDienThoai;
	JTextField txtEmail;
	JButton btnEdit;
	JButton btnDelete;
	JButton btnAdd;
	private DefaultTableModel dm;

	public JPanel pnKhachHang() {

		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thông tin khách hàng");

		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(900, 800));
		dm = new DefaultTableModel();
		dm.addColumn("Mã Sinh Vieen");
		dm.addColumn("Họ tên");

		dm.addColumn("Địa chỉ");

		dm.addColumn("Phường");

		dm.addColumn("Quận");
		dm.addColumn("Tỉnh Thành");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã Lop");
		final JTable tbl = new JTable(dm);
		// ẩn

		connect();
		try {
			while (rs.next()) {
				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String id = (String) tbl.getValueAt(row, 0);
				txtMaKH.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtHoTen.setText(name);

				String add = (String) tbl.getValueAt(row, 2);
				txtDiaChi.setText(add);

				String tinh = (String) tbl.getValueAt(row, 5);

				String quan = (String) tbl.getValueAt(row, 4);

				String phuong = (String) tbl.getValueAt(row, 3);

				for (int i = 0; i < arrTinhThanh.size(); i++) {
					if (tinh.equals(arrTinhThanh.get(i).getName())) {
						cboTP.setSelectedItem(arrTinhThanh.get(i));
					}
				}
				for (int i = 0; i < arrQuanHuyen.size(); i++) {
					if (quan.equals(arrQuanHuyen.get(i).getName())) {
						cboQuan1.setSelectedItem(arrQuanHuyen.get(i));
					}
				}
				for (int i = 0; i < arrPhuong.size(); i++) {
					if (phuong.equals(arrPhuong.get(i).getName())) {
						cboPhuong1.setSelectedItem(arrPhuong.get(i));
					}
				}
				String phone = (String) tbl.getValueAt(row, 6);
				txtDienThoai.setText(phone);

				String mail = (String) tbl.getValueAt(row, 7);
				txtEmail.setText(mail);

				String maLop = (String) tbl.getValueAt(row, 8);
				cboMaLop.setSelectedItem(maLop);
			}

		});

		JScrollPane sc = new JScrollPane(tbl);
		pnTab1.add(sc, BorderLayout.CENTER);

		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());

		JPanel pnFilter = new JPanel();
		pn.add(pnFilter, BorderLayout.SOUTH);

		JComboBox cbo = new JComboBox();
		cbo.addItem("Tìm Theo ");
		cbo.addItem("Mã Sinh Viên");
		cbo.addItem("Tên");
		cbo.addItem("Mã Lớp");
		JTextField txtFilter = new JTextField(20);

		// pnFilter.setLayout(new GridLayout(1, 5));

		pnFilter.add(cbo);
		pnFilter.add(txtFilter);
		JButton btnSearch = new JButton("Search");

		btnSearch.setFont(new Font(null, Font.BOLD, 13));
		btnSearch.setPreferredSize(new Dimension(100, 30));

		pnFilter.add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				String text = txtFilter.getText();
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				if (n == 1) {
					String sql;
					if (text.equals(""))
						sql = "select * from hososinhvien";
					else
						sql = "select * from hososinhvien where masv =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 2) {
					String sql;
					if (text.equals(""))
						sql = "select * from hososinhvien";
					else
						sql = "select * from hososinhvien where hoten =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 3) {
					String sql;
					if (text.equals(""))
						sql = "select * from hososinhvien";
					else
						sql = "select * from hososinhvien where malop =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				}

			}

		});

		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.NORTH);
		btnAdd = new JButton("Thêm Sinh Viên");
		pnBtn.add(btnAdd);

		btnEdit = new JButton("Sửa thông tin Sinh vien");

		pnBtn.add(btnEdit);

		btnDelete = new JButton("Xóa Sinh Viên");

		pnBtn.add(btnDelete);

		btnAdd.setFont(new Font(null, Font.BOLD, 13));
		btnDelete.setFont(new Font(null, Font.BOLD, 13));
		btnEdit.setFont(new Font(null, Font.BOLD, 13));
		btnAdd.setPreferredSize(new Dimension(200, 30));
		btnDelete.setPreferredSize(new Dimension(200, 30));
		btnEdit.setPreferredSize(new Dimension(200, 30));

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(9, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maSV = new JLabel("  Mã Sinh Viên");
		pnText.add(maSV);
		txtMaKH = new JTextField(10);
		pnText.add(txtMaKH);

		JLabel hoTen = new JLabel("  Họ tên");
		pnText.add(hoTen);
		txtHoTen = new JTextField(20);
		pnText.add(txtHoTen);

		JLabel diaChi = new JLabel("  Địa chỉ");
		pnText.add(diaChi);
		txtDiaChi = new JTextField(20);
		pnText.add(txtDiaChi);

		JLabel phuong = new JLabel("  Phường");
		pnText.add(phuong);
		cboPhuong1.addItem("Phường...");
		pnText.add(cboPhuong1);

		JLabel quan = new JLabel("  Quận");
		pnText.add(quan);
		cboQuan1 = new JComboBox<String>();
		cboQuan1.addItem("Quận...");

		pnText.add(cboQuan1);

		JLabel tinhthanh = new JLabel("Tỉnh Thành");
		arrTinhThanh = tinhThanhStatement.selectAll();
		pnText.add(tinhthanh);
		cboTP.addItem(new TinhThanh(null, "Chọn Tỉnh"));
		pnText.add(cboTP);

		for (TinhThanh x : arrTinhThanh) {
			cboTP.addItem(x);
		}
		cboTP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					TinhThanh item = (TinhThanh) cboTP.getSelectedItem();
					provinceId = item.getProvinceId();
					// System.out.println(provinceId);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				arrQuanHuyen = quanHuyenStatement.selectQuanHuyen(provinceId);
				cboQuan1.removeAllItems();
				cboQuan1.addItem(new QuanHuyen("Chọn Quận", null));
				for (QuanHuyen x : arrQuanHuyen) {
					cboQuan1.addItem(x);
				}
			}
		});

		cboQuan1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				cboPhuong1.removeAllItems();
				cboQuan1.addItem(new QuanHuyen("Chọn Quận", null));
				for (QuanHuyen x : arrQuanHuyen) {
					cboQuan1.addItem(x);
				}
				try {
					QuanHuyen item = (QuanHuyen) cboQuan1.getSelectedItem();
					districtId = item.getDistricId();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				arrPhuong = phuongStatement.selectPhuong(districtId);
				;
				cboPhuong1.addItem("Chọn Phường");
				for (Phuong x : arrPhuong) {
					cboPhuong1.addItem(x);
				}
			}
		});

		JLabel dienThoai = new JLabel("  Điện Thoại");
		pnText.add(dienThoai);
		txtDienThoai = new JTextField(20);
		pnText.add(txtDienThoai);

		JLabel email = new JLabel("  Email");
		pnText.add(email);
		txtEmail = new JTextField(20);
		pnText.add(txtEmail);

		JLabel maLop = new JLabel("  Mã Lop");
		pnText.add(maLop);
		cboMaLop = new JComboBox();

		pnText.add(cboMaLop);

		try {

			rs = stmt.executeQuery("select * from lophoc");
			while (rs.next()) {
				cboMaLop.addItem(rs.getString(1));
				String strMyString = (String) cboMaLop.getSelectedItem();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String maSv = txtMaKH.getText().toUpperCase();
					String hoTen = txtHoTen.getText();
					String diaChi = txtDiaChi.getText();
					String tinhThanh = cboTP.getSelectedItem().toString();
					String quanHuyen = cboQuan1.getSelectedItem().toString();
					String phuong = cboPhuong1.getSelectedItem().toString();
					String dienThoai = txtDienThoai.getText();
					String email = txtEmail.getText();
					String maLop = cboMaLop.getSelectedItem().toString();

					String kt = "Không trùng";

					if (maLop.equals("Chọn Lớp")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã lớp");
					} else if (tinhThanh.equals("Chọn Tỉnh")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Tỉnh/Thành ");
					} else if (quanHuyen.equals("Chọn Quận")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Quận/Huyện ");
					} else if (phuong.equals("Chọn Phường")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Phường ");
					} else if (maSv.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Sinh viên ");
					} else if (hoTen.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Họ tên ");
					} else if (diaChi.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Địa chỉ ");
					} else if (dienThoai.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Điện thoại ");
					} else if (email.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Email ");

					} else {
						for (QuanLiSinhVien x : arrSinhVien) {
							if (maSv.equals(x.getMaSV())) {
								kt = "Trùng";
							}
						}

						if (kt == "Trùng") {
							JOptionPane.showMessageDialog(null, "Trùng mã sinh viên vui lòng nhập lại");
						} else {
							stmt.executeUpdate("insert into hososinhvien values('" + maSv + "', '" + hoTen + "', '"
									+ diaChi + "','" + phuong + "', '" + quanHuyen + "', '" + tinhThanh + "',  '"
									+ dienThoai + "', '" + email + "', '" + maLop + "')");
							JOptionPane.showMessageDialog(null, "Thêm thanh cong!!!");
							dm.setRowCount(0);
							ResultSet rs = stmt.executeQuery("select * from hososinhvien");
							try {
								while (rs.next()) {
									dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
											rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
											rs.getString(8), rs.getString(9) });

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

		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					txtMaKH.setEditable(true);
					String maSv = txtMaKH.getText();
					String hoTen = txtHoTen.getText();
					String diaChi = txtDiaChi.getText();
					String tinhThanh = cboTP.getSelectedItem().toString();
					String quanHuyen = cboQuan1.getSelectedItem().toString();
					String phuong = cboPhuong1.getSelectedItem().toString();
					String dienThoai = txtDienThoai.getText();
					String email = txtEmail.getText();
					String maLop = cboMaLop.getSelectedItem().toString();
					if (maSv.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần sửa ");
					} else if (tinhThanh.equals("Chọn Tỉnh")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Tỉnh/Thành ");
					} else if (quanHuyen.equals("Chọn Quận")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Quận/Huyện ");
					} else if (phuong.equals("Chọn Phường")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Phường ");
					} else if (maLop.equals("Chọn Lớp")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Mã lớp");
					} else if (hoTen.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Họ tên ");
					} else if (diaChi.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Địa chỉ ");
					} else if (dienThoai.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Điện thoại ");
					} else if (email.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng Nhập mã Email ");

					} else {

						stmt.executeUpdate("update hososinhvien set Hoten='" + hoTen + "', Diachi='" + diaChi
								+ "', Phuong='" + phuong + "', Quan ='" + quanHuyen + "', Tinhthanh ='" + tinhThanh
								+ "', sdt ='" + dienThoai + "', Email ='" + email + "', Malop ='" + maLop
								+ "' where Masv='" + maSv + "'");
						JOptionPane.showMessageDialog(null, "Sua thanh cong!!!");
						dm.setRowCount(0);
						ResultSet rs = stmt.executeQuery("select * from hososinhvien");
						try {
							while (rs.next()) {
								dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
										rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
										rs.getString(8), rs.getString(9) });

							}
						} catch (Exception ex1) {
							ex1.printStackTrace();
						}
						tbl.setModel(dm);
						dm.fireTableDataChanged();
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					String maSv = txtMaKH.getText();
					if (txtMaKH.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn sinh viên cần xóa");
					} else {
						int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa",
								JOptionPane.YES_NO_OPTION);
						if (chose == JOptionPane.YES_OPTION) {
							String maKhoa1 = txtMaKH.getText();

							stmt.executeUpdate("delete from hososinhvien WHERE masv = \"" + maKhoa1 + "\" ");
							int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
									JOptionPane.YES_NO_OPTION);
							if (ret != JOptionPane.YES_OPTION) {
								return;
							}
							dm.setRowCount(0);
							ResultSet rs = stmt.executeQuery("select * from hososinhvien");
							try {
								while (rs.next()) {
									dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
											rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
											rs.getString(8), rs.getString(9) });

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

		return pnTab1;

	}

	private ResultSet connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from hososinhvien");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

}
