package ui;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import object.DangNhap;
import object.Item;
import service.PhuongQuanService;
import service.ThongTinService;
import service.Connect;
import ui.MainUi;

public class QuanLyKhachHangUi extends JPanel {

	public static Connection con = null;
	public static ResultSet rs = null;
	public static Statement stmt = null;
	DefaultTableModel dm = new DefaultTableModel();
	final JTable tbl = new JTable(dm);
	JComboBox cbbQuan = new JComboBox();
	List<Item> myList = new ArrayList<Item>();
	JComboBox cbbPhuong = new JComboBox();
	JPanel pn = new JPanel();

	ActionListener cbQuanClick = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
			PhuongQuanService phuongService = new PhuongQuanService();

			myList.clear();
			myList.addAll((phuongService.getPhuongList(((Item) cbbQuan.getSelectedItem()).getItemID())));
			// JComboBox cbbPhuong1 = new JComboBox((phuongService.getPhuongList(((Item)
			// cbbQuan.getSelectedItem()).getItemID()).toArray()));
			// cbbPhuong = new JComboBox(list);
			// cbbPhuong.addItem(cbbPhuong1.getSelectedItem());
			
			cbbPhuong.removeAllItems();
			
			for (Item item : myList) {
				cbbPhuong.addItem(item);
			}
			cbbPhuong.updateUI();
			
			nhapDanhSachBang();

			System.out.println(myList);
		}
	};

	public QuanLyKhachHangUi() {
		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new GridLayout(10, 2));

		JLabel lbId = new JLabel(" ID");
		pnFlow.add(lbId);
		JTextField txtId = new JTextField(20);
		pnFlow.add(txtId);

		JLabel lbname = new JLabel("Họ tên");
		pnFlow.add(lbname);
		JTextField txtName = new JTextField(20);
		pnFlow.add(txtName);

		JLabel lbAddress = new JLabel("Địa chỉ");
		pnFlow.add(lbAddress);
		JTextField txtAddress = new JTextField(20);
		pnFlow.add(txtAddress);

		JLabel lbQuan = new JLabel(" Quận ");
		pnFlow.add(lbQuan);
		PhuongQuanService quanService = new PhuongQuanService();
		cbbQuan = new JComboBox(quanService.getQuanList().toArray());
		pnFlow.add(cbbQuan);

		JLabel lblPhuong = new JLabel("Phường");
		pnFlow.add(lblPhuong);
		pnFlow.add(cbbPhuong);

		cbbQuan.addActionListener(cbQuanClick);

		JLabel lbDienThoai = new JLabel(" Điện thoại ");
		pnFlow.add(lbDienThoai);
		JTextField txtDienThoai = new JTextField(20);
		pnFlow.add(txtDienThoai);

		JLabel lbEmail = new JLabel(" Email ");
		pnFlow.add(lbEmail);
		JTextField txtEmail = new JTextField(20);
		pnFlow.add(txtEmail);

		JLabel lbSoThe = new JLabel(" Số thẻ ");
		pnFlow.add(lbSoThe);
		JTextField txtSoThe = new JTextField(20);
		pnFlow.add(txtSoThe);

		JLabel lbSoTaiKhoan = new JLabel(" Số tài khoản");
		pnFlow.add(lbSoTaiKhoan);
		JTextField txtSoTaiKhoan = new JTextField(20);
		pnFlow.add(txtSoTaiKhoan);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.Y_AXIS));
		// pnButton.setLayout(new GridLayout(3,1,0,80));
		JButton btnInsert = new JButton(" Thêm ");
		pnButton.add(btnInsert);
		JButton btnUpdate = new JButton(" Sửa ");
		pnButton.add(btnUpdate);
		JButton btnDelete = new JButton(" Xóa ");
		pnButton.add(btnDelete);
		btnUpdate.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnUpdate.getMinimumSize().height));
		btnDelete.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnDelete.getMinimumSize().height));

		JPanel pnFind = new JPanel();
		// pnFind.setLayout(new GridLayout(1,1));
		JLabel lbFind = new JLabel("Tim theo");
		pnFind.add(lbFind);
		JComboBox cbQuan = new JComboBox();
		cbQuan.addItem("Quan");
		pnFind.add(cbQuan);

		JComboBox cbPhuong = new JComboBox();
		pnFind.add(cbPhuong);
		cbPhuong.addItem("Phuong");
		JTextField txtFind = new JTextField(15);
		pnFind.add(txtFind);
		JButton btnFind = new JButton("Find");
		pnFind.add(btnFind);

		dm.addColumn("Mã khách hàng");
		dm.addColumn(" Họ Tên");
		dm.addColumn(" Địa chỉ ");
		dm.addColumn("Phường");
		dm.addColumn(" Quận");
		dm.addColumn(" Điện Thoại ");
		dm.addColumn("Email");
		dm.addColumn(" Số thẻ ATM");
		dm.addColumn(" Số tài khoản ");
		dm.addRow(new String[] { "114", "Trần Văn T ", "22" });
		JScrollPane sc = new JScrollPane(tbl);
		
		tbl.getColumnModel().getColumn(0).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(1).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(2).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(5).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(6).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(7).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(8).setPreferredWidth(400);
		tbl.getColumnModel().getColumn(8).setPreferredWidth(400);
		// load tu table vao textfield( mouse click)
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stu
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

				String s1 = (String) tbl.getValueAt(row, 0);
				txtId.setText(s1);
				String s2 = (String) tbl.getValueAt(row, 1);
				txtName.setText(s2);
				String s3 = (String) tbl.getValueAt(row, 2);
				txtAddress.setText(s3);

				String s4 = (String) tbl.getValueAt(row, 4);
				cbbQuan.getModel().setSelectedItem(new Item(0, s4));
				String s5 = (String) tbl.getValueAt(row, 3);
				cbbPhuong.getModel().setSelectedItem(new Item(0, s5));

				String s6 = (String) tbl.getValueAt(row, 5);
				txtDienThoai.setText(s6);
				String s7 = (String) tbl.getValueAt(row, 6);
				txtEmail.setText(s7);
				String s8 = (String) tbl.getValueAt(row, 7);
				txtSoThe.setText(s8);
				String s9 = (String) tbl.getValueAt(row, 8);
				txtSoTaiKhoan.setText(s9);

			}
		});
		JPanel pn3 = new JPanel();
		pn3.setLayout(new BorderLayout());
		pn3.add(pnFlow, BorderLayout.WEST);
		pn3.add(pnButton, BorderLayout.EAST);

		pn.setLayout(new BorderLayout());
		pn.add(sc, BorderLayout.SOUTH);
		pn.add(pn3, BorderLayout.NORTH);
		pn.add(pnFind, BorderLayout.CENTER);
		// pnFind.setPreferredSize(new Dimension(200, 50));
		this.add(pn);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?useUnicode=true&characterEncoding=utf-8",
					"root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from khachhang");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// csdl load vao bang table
		try {
			rs = stmt.executeQuery("select * from khachhang");
			while (rs.next()) {

				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {

					String id = txtId.getText();
					String hoTen = txtName.getText();
					String diaChi = txtAddress.getText();
					String phuong = cbbPhuong.getSelectedItem().toString();
					String quan = cbbQuan.getSelectedItem().toString();
					String dienThoai = txtDienThoai.getText();
					String email = txtEmail.getText();
					String soThe = txtSoThe.getText();
					String soTaiKhoan = txtSoTaiKhoan.getText();

					stmt = con.createStatement();
					String khachhang = ("insert into khachhang values (\"" + id + "\",\"" + hoTen + "\",\"" + diaChi
							+ "\", \"" + phuong + "\", \"" + quan + "\",\"" + dienThoai + "\",\"" + email + "\",\""
							+ soThe + "\", \"" + soTaiKhoan + "\")");
					rs = stmt.executeQuery("select * from khachhang");
					stmt.executeUpdate(khachhang);

					dm.addRow(new String[] { txtId.getText(), txtName.getText(), txtAddress.getText(),
							cbbPhuong.getSelectedItem().toString(), cbbQuan.getSelectedItem().toString(),
							txtDienThoai.getText(), txtEmail.getText(), txtSoThe.getText(), txtSoTaiKhoan.getText() });

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String sql = "update khachhang set hoTen=?,diaChiNha=?,phuong=?,quan=?,dienThoai=?,email=?,soTheATM=?,soTaiKhoan=? where idKhachHang=?";
					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, txtName.getText());
					preparedStatement.setString(2, txtAddress.getText());
					preparedStatement.setString(3, cbbPhuong.getSelectedItem().toString());
					preparedStatement.setString(4, cbbQuan.getSelectedItem().toString());
					preparedStatement.setString(5, txtDienThoai.getText());
					preparedStatement.setString(6, txtEmail.getText());
					preparedStatement.setString(7, txtSoThe.getText());
					preparedStatement.setString(8, txtSoTaiKhoan.getText());
					preparedStatement.setString(9, txtId.getText());

					int x = preparedStatement.executeUpdate();
					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Update thành công");
						dm.setRowCount(0);
						nhapDanhSachBang();

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String ma = tbl.getValueAt(tbl.getSelectedRow(), 0) + "";
					String sql = "delete from khachhang where idKhachHang=?";
					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setString(1, ma);
					int x = preparedStatement.executeUpdate();

					// chon cot xoa cot
					int y = tbl.getSelectedRow();
					dm.removeRow(y);

					// refreshUi();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
	}

	protected void nhapDanhSachBang() {
		// TODO Auto-generated method stub
		try {
			rs = stmt.executeQuery("select * from khachhang");
			while (rs.next()) {

				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.removeAll();
		this.updateUI();
		this.add(pn);

	}

}
