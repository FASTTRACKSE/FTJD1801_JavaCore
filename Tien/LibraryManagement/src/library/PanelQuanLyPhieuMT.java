package library;

import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelQuanLyPhieuMT extends JPanel {
	ResultSet rs = null;
	ResultSet rsMaBanDoc = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexThree, indexOne;
	String one, two, three;
	Vector<Vector> vecCbb;
	String mbd, tinhTrang;
	ActionComboBox atnCbb = new ActionComboBox();

	public PanelQuanLyPhieuMT() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from phieumuontra");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsMaBanDoc = stmt.executeQuery("select MaBanDoc, HoTen from bandoc");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(3, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã giao dịch");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnSeven = new JPanel();
		pnSeven.setLayout(new FlowLayout());
		JLabel lblMaBanDoc = new JLabel("Mã bạn đọc");
		JComboBox cbbMaBanDoc = new JComboBox();
		cbbMaBanDoc.setPreferredSize(new Dimension(200, 30));
		lblMaBanDoc.setFont(fontOne);
		cbbMaBanDoc.setFont(fontOne);
		grTop.add(lblMaBanDoc);
		pnSeven.add(cbbMaBanDoc);
		grTop.add(pnSeven);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblNgayMuon = new JLabel("Ngày mượn");
		JTextField txtNgayMuon = new JTextField(15);
		lblNgayMuon.setFont(fontOne);
		txtNgayMuon.setFont(fontOne);
		grTop.add(lblNgayMuon);
		pnFour.add(txtNgayMuon);
		grTop.add(pnFour);

		JPanel pnFive = new JPanel();
		pnFive.setLayout(new FlowLayout());
		JLabel lblSLMuon = new JLabel("Số lượng mượn");
		JTextField txtSLMuon = new JTextField(15);
		lblSLMuon.setFont(fontOne);
		txtSLMuon.setFont(fontOne);
		grTop.add(lblSLMuon);
		pnFive.add(txtSLMuon);
		grTop.add(pnFive);

		JPanel pnEight = new JPanel();
		pnEight.setLayout(new FlowLayout());
		JLabel lblTinhTrang = new JLabel("Tình trạng");
		JComboBox cbbTinhTrang = new JComboBox();
		cbbTinhTrang.addItem("Đang mượn");
		cbbTinhTrang.addItem("Chưa trả hết");
		cbbTinhTrang.addItem("Đã trả");
		cbbTinhTrang.setPreferredSize(new Dimension(200, 30));
		lblTinhTrang.setFont(fontOne);
		cbbTinhTrang.setFont(fontOne);
		grTop.add(lblTinhTrang);
		pnEight.add(cbbTinhTrang);
		grTop.add(pnEight);

		vecCbb = atnCbb.ArrComboBox(rsMaBanDoc);
		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbMaBanDoc.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}

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
		cbbType.addItem("Mã sách");
		cbbType.addItem("Tên sách");
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
		DefaultTableModel tblSach = new DefaultTableModel();
		tblSach.addColumn("Mã giao dịch");
		tblSach.addColumn("Mã bạn đọc");
		tblSach.addColumn("Ngày mượn");
		tblSach.addColumn("Số lượng mượn");
		tblSach.addColumn("Tình trạng");

		final JTable tbl = new JTable(tblSach);
		try {
			while (rs.next()) {
				String maGD = rs.getString(1);
				String maBanDoc = rs.getString(2);
				String ngayMuon = rs.getString(3);
				String soLuongMuon = rs.getString(4);
				String tinhTrang = rs.getString(5);
				Vector<String> vec = new Vector<String>();
				vec.add(maGD);
				vec.add(maBanDoc);
				vec.add(ngayMuon);
				vec.add(soLuongMuon);
				vec.add(tinhTrang);
				tblSach.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách phiếu mượn trả");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 400));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		cbbMaBanDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				indexThree = cbbMaBanDoc.getSelectedIndex();
				mbd = (String) vecCbb.get(0).get(indexThree);
			}
		});
		
		cbbTinhTrang.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				tinhTrang = (String) cbbTinhTrang.getSelectedItem();
			}
		});

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String id = (String) tbl.getValueAt(row, 0);
				txtID.setText(id);

				String maBD = (String) tbl.getValueAt(row, 1);
				for (int i = 0; i < vecCbb.get(0).size(); i++) {
					if (vecCbb.get(0).get(i).equals(maBD)) {
						one = (String) vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i);
					}
				}
				cbbMaBanDoc.setSelectedItem(one);

				String ngayMuon = (String) tbl.getValueAt(row, 2);
				txtNgayMuon.setText(ngayMuon);

				String soLuongMuon = (String) tbl.getValueAt(row, 3);
				txtSLMuon.setText(soLuongMuon);

				String tinhTrang = (String) tbl.getValueAt(row, 4);
				cbbTinhTrang.setSelectedItem(tinhTrang);
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
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtID.setText("");
				txtNgayMuon.setText("");
				txtSLMuon.setText("");
				cbbTinhTrang.setSelectedIndex(0);
				cbbMaBanDoc.setSelectedIndex(0);
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into phieumuontra values(\'" + txtID.getText() + "\',\'" + mbd + "\',\'"
							+ txtNgayMuon.getText() + "\',\'" + txtSLMuon.getText() + "\',\'" + tinhTrang
							+ "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery("select * from phieumuontra");

					while (rs.next()) {
						String maGD = rs.getString(1);
						String maBanDoc = rs.getString(2);
						String ngayMuon = rs.getString(3);
						String soLuongMuon = rs.getString(4);
						String tinhTrang = rs.getString(5);
						Vector<String> vec = new Vector<String>();
						vec.add(maGD);
						vec.add(maBanDoc);
						vec.add(ngayMuon);
						vec.add(soLuongMuon);
						vec.add(tinhTrang);
						tblSach.addRow(vec);
					}
					tbl.setModel(tblSach);
					tblSach.fireTableDataChanged();

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
					stmt.execute(
							"update phieumuontra set maBanDoc = \'" + mbd + "\', NgayMuon = \'" + txtNgayMuon.getText()
									+ "\', SoLuongMuon = \'" + txtSLMuon.getText() + "\', TinhTrang = \'"
									+ tinhTrang + "\' where MaGiaoDich = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery("select * from phieumuontra");

					while (rs.next()) {
						String maGD = rs.getString(1);
						String maBanDoc = rs.getString(2);
						String ngayMuon = rs.getString(3);
						String soLuongMuon = rs.getString(4);
						String tinhTrang = rs.getString(5);
						Vector<String> vec = new Vector<String>();
						vec.add(maGD);
						vec.add(maBanDoc);
						vec.add(ngayMuon);
						vec.add(soLuongMuon);
						vec.add(tinhTrang);
						tblSach.addRow(vec);
					}
					tbl.setModel(tblSach);
					tblSach.fireTableDataChanged();

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
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Thao tác này sẽ xóa dữ liệu của phiếu mượn trả ở bảng chi tiết mượn trả!!!", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						stmt.execute("delete from chitietmuontra where MaGiaoDich = \'" + txtID.getText() + "\'");
						stmt.execute("delete from phieumuontra where MaGiaoDich = \'" + txtID.getText() + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
						tblSach.setRowCount(0);
						rs = stmt.executeQuery("select * from phieumuontra");

						while (rs.next()) {
							String maGD = rs.getString(1);
							String maBanDoc = rs.getString(2);
							String ngayMuon = rs.getString(3);
							String soLuongMuon = rs.getString(4);
							String tinhTrang = rs.getString(5);
							Vector<String> vec = new Vector<String>();
							vec.add(maGD);
							vec.add(maBanDoc);
							vec.add(ngayMuon);
							vec.add(soLuongMuon);
							vec.add(tinhTrang);
							tblSach.addRow(vec);
						}
						tbl.setModel(tblSach);
						tblSach.fireTableDataChanged();

					} catch (Exception ex) {
						// TODO: handle exception
						System.err.println(ex);
					}
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
						tblSach.setRowCount(0);
						rs = stmt.executeQuery("select * from phieumuontra");

						while (rs.next()) {
							String maGD = rs.getString(1);
							String maBanDoc = rs.getString(2);
							String ngayMuon = rs.getString(3);
							String soLuongMuon = rs.getString(4);
							String tinhTrang = rs.getString(5);
							Vector<String> vec = new Vector<String>();
							vec.add(maGD);
							vec.add(maBanDoc);
							vec.add(ngayMuon);
							vec.add(soLuongMuon);
							vec.add(tinhTrang);
							tblSach.addRow(vec);
						}
						tbl.setModel(tblSach);
						tblSach.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery("select * from phieumuontra where MaGiaoDich like \'%"
									+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maGD = rs.getString(1);
								String maBanDoc = rs.getString(2);
								String ngayMuon = rs.getString(3);
								String soLuongMuon = rs.getString(4);
								String tinhTrang = rs.getString(5);
								Vector<String> vec = new Vector<String>();
								vec.add(maGD);
								vec.add(maBanDoc);
								vec.add(ngayMuon);
								vec.add(soLuongMuon);
								vec.add(tinhTrang);
								tblSach.addRow(vec);
							}
							tbl.setModel(tblSach);
							tblSach.fireTableDataChanged();

						} else if (index == 1) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"select * from phieumuontra where MaBanDoc like \'%" + txtValue.getText() + "%\'");

							while (rs.next()) {
								String maGD = rs.getString(1);
								String maBanDoc = rs.getString(2);
								String ngayMuon = rs.getString(3);
								String soLuongMuon = rs.getString(4);
								String tinhTrang = rs.getString(5);
								Vector<String> vec = new Vector<String>();
								vec.add(maGD);
								vec.add(maBanDoc);
								vec.add(ngayMuon);
								vec.add(soLuongMuon);
								vec.add(tinhTrang);
								tblSach.addRow(vec);
							}
							tbl.setModel(tblSach);
							tblSach.fireTableDataChanged();

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
