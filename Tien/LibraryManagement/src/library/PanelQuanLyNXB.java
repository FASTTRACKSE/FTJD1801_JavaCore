package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

public class PanelQuanLyNXB extends JPanel{
	ResultSet rs = null;
	Statement stmt;
	public PanelQuanLyNXB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from nhaxuatban");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã nhà xuất bản");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên nhà xuất bản");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblAdd = new JLabel("Địa chỉ");
		JTextField txtAdd = new JTextField(15);
		lblAdd.setFont(fontOne);
		txtAdd.setFont(fontOne);
		grTop.add(lblAdd);
		pnThree.add(txtAdd);
		grTop.add(pnThree);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblPhone = new JLabel("Số điện thoại");
		JTextField txtPhone = new JTextField(15);
		lblPhone.setFont(fontOne);
		txtPhone.setFont(fontOne);
		grTop.add(lblPhone);
		pnFour.add(txtPhone);
		grTop.add(pnFour);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(fontOne);
		pnCenter.add(btnAdd);

		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(fontOne);
		pnCenter.add(btnSave);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(fontOne);
		pnCenter.add(btnUpdate);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(fontOne);
		pnCenter.add(btnRemove);

		JLabel lblType = new JLabel("Tìm theo");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Mã nhà xuất bản");
		cbbType.addItem("Tên nhà xuất bản");

		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Dữ liệu: ");
		pnCenter.add(lblValue);
		lblValue.setFont(fontOne);
		JTextField txtValue = new JTextField(15);
		txtValue.setFont(fontOne);
		pnCenter.add(txtValue);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(fontOne);
		pnCenter.add(btnSearch);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new FlowLayout());
		DefaultTableModel tblNhaXuatBan = new DefaultTableModel();
		tblNhaXuatBan.addColumn("Mã nhà xuất bản");
		tblNhaXuatBan.addColumn("Tên nhà xuất bản");
		tblNhaXuatBan.addColumn("Địa chỉ");
		tblNhaXuatBan.addColumn("Số điện thoại");

		final JTable tbl = new JTable(tblNhaXuatBan);
		try {
			while (rs.next()) {
				String maNXB = rs.getString(1);
				String tenNXB = rs.getString(2);
				String diaChi = rs.getString(3);
				String phone = rs.getString(4);
				Vector<String> vec = new Vector<String>();
				vec.add(maNXB);
				vec.add(tenNXB);
				vec.add(diaChi);
				vec.add(phone);
				tblNhaXuatBan.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách nhà xuất bản");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String id = (String) tbl.getValueAt(row, 0);
				txtID.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtName.setText(name);

				String add = (String) tbl.getValueAt(row, 2);
				txtAdd.setText(add);
				
				String phone = (String) tbl.getValueAt(row, 3);
				txtPhone.setText(phone);
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
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtID.setText("");
				txtName.setText("");
				txtAdd.setText("");
				txtPhone.setText("");
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into nhaxuatban values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtAdd.getText() + "\',\'" + txtPhone.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblNhaXuatBan.setRowCount(0);
					rs = stmt.executeQuery("Select * from nhaxuatban");

					while (rs.next()) {
						String maNXB = rs.getString(1);
						String tenNXB = rs.getString(2);
						String diaChi = rs.getString(3);
						String phone = rs.getString(4);
						Vector<String> vec = new Vector<String>();
						vec.add(maNXB);
						vec.add(tenNXB);
						vec.add(diaChi);
						vec.add(phone);
						tblNhaXuatBan.addRow(vec);
					}
					tbl.setModel(tblNhaXuatBan);
					tblNhaXuatBan.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.executeUpdate("update nhaxuatban set TenXuatBan = \'" + txtName.getText() + "\', DiaChi = \'" + txtAdd.getText()
							+ "\', SDT = \'" + txtPhone.getText() + "\' where MaNXB = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblNhaXuatBan.setRowCount(0);
					rs = stmt.executeQuery("Select * from nhaxuatban");

					while (rs.next()) {
						String maNXB = rs.getString(1);
						String tenNXB = rs.getString(2);
						String diaChi = rs.getString(3);
						String phone = rs.getString(4);
						Vector<String> vec = new Vector<String>();
						vec.add(maNXB);
						vec.add(tenNXB);
						vec.add(diaChi);
						vec.add(phone);
						tblNhaXuatBan.addRow(vec);
					}
					tbl.setModel(tblNhaXuatBan);
					tblNhaXuatBan.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					stmt.execute("delete from nhaxuatban where MaNXB = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
					tblNhaXuatBan.setRowCount(0);
					rs = stmt.executeQuery("Select * from nhaxuatban");

					while (rs.next()) {
						String maTacGia = rs.getString(1);
						String tenTacGia = rs.getString(2);
						String nienDai = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTacGia);
						vec.add(tenTacGia);
						vec.add(nienDai);
						tblNhaXuatBan.addRow(vec);
					}
					tbl.setModel(tblNhaXuatBan);
					tblNhaXuatBan.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
				
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (txtValue.getText().equals("")) {
						tblNhaXuatBan.setRowCount(0);
						rs = stmt.executeQuery("Select * from nhaxuatban");

						while (rs.next()) {
							String maNXB = rs.getString(1);
							String tenNXB = rs.getString(2);
							String diaChi = rs.getString(3);
							String phone = rs.getString(4);
							Vector<String> vec = new Vector<String>();
							vec.add(maNXB);
							vec.add(tenNXB);
							vec.add(diaChi);
							vec.add(phone);
							tblNhaXuatBan.addRow(vec);
						}
						tbl.setModel(tblNhaXuatBan);
						tblNhaXuatBan.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblNhaXuatBan.setRowCount(0);
							rs = stmt.executeQuery("Select * from nhaxuatban where MaNXB = " + txtValue.getText() + "");

							while (rs.next()) {
								String maNXB = rs.getString(1);
								String tenNXB = rs.getString(2);
								String diaChi = rs.getString(3);
								String phone = rs.getString(4);
								Vector<String> vec = new Vector<String>();
								vec.add(maNXB);
								vec.add(tenNXB);
								vec.add(diaChi);
								vec.add(phone);
								tblNhaXuatBan.addRow(vec);
							}
							tbl.setModel(tblNhaXuatBan);
							tblNhaXuatBan.fireTableDataChanged();

						} else if (index == 1) {
							tblNhaXuatBan.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from nhaxuatban where TenXuatBan = \'" + txtValue.getText() + "\'");

							while (rs.next()) {
								String maNXB = rs.getString(1);
								String tenNXB = rs.getString(2);
								String diaChi = rs.getString(3);
								String phone = rs.getString(4);
								Vector<String> vec = new Vector<String>();
								vec.add(maNXB);
								vec.add(tenNXB);
								vec.add(diaChi);
								vec.add(phone);
								tblNhaXuatBan.addRow(vec);
							}
							tbl.setModel(tblNhaXuatBan);
							tblNhaXuatBan.fireTableDataChanged();

						}
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		add(grTop);
		add(pnCenter);
		add(pnTable);
	}
}
