package library;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelQuanLyTheLoai extends JPanel{
	ResultSet rs = null;
	Statement stmt;
	
	public PanelQuanLyTheLoai() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from theloaisach");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		JPanel pnNull = new JPanel();
		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(1, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã thể loại");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên thể loại");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);
		 
		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblNote=new JLabel("Mô tả"); 
		JTextArea txtaNote=new JTextArea(5, 15); 
		JScrollPane scpNote=new JScrollPane(txtaNote);
		scpNote.setPreferredSize(new Dimension(1000, 100));
		lblNote.setFont(fontOne);
		txtaNote.setFont(fontOne);
		pnThree.add(lblNote);
		pnThree.add(pnNull);
		pnThree.add(scpNote);

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
		cbbType.addItem("Mã thể loại");
		cbbType.addItem("Tên thể loại");

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
		DefaultTableModel tblTheLoai = new DefaultTableModel();
		tblTheLoai.addColumn("Mã thể loại");
		tblTheLoai.addColumn("Tên thể loại");
		tblTheLoai.addColumn("Mô tả");

		final JTable tbl = new JTable(tblTheLoai);
		try {
			while (rs.next()) {
				String maTheLoai = rs.getString(1);
				String tenTheLoai = rs.getString(2);
				String moTa = rs.getString(3);
				Vector<String> vec = new Vector<String>();
				vec.add(maTheLoai);
				vec.add(tenTheLoai);
				vec.add(moTa);
				tblTheLoai.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách tác giả");

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

				String note = (String) tbl.getValueAt(row, 2);
				txtaNote.setText(note);
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
				txtaNote.setText("");
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into theloaisach values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtaNote.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblTheLoai.setRowCount(0);
					rs = stmt.executeQuery("Select * from theloaisach");

					while (rs.next()) {
						String maTheLoai = rs.getString(1);
						String tenTheLoai = rs.getString(2);
						String moTa = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTheLoai);
						vec.add(tenTheLoai);
						vec.add(moTa);
						tblTheLoai.addRow(vec);
					}
					tbl.setModel(tblTheLoai);
					tblTheLoai.fireTableDataChanged();

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
					stmt.executeUpdate("update theloaisach set TenTheLoai = \'" + txtName.getText() + "\', MoTa = \'" + txtaNote.getText()
							+ "\' where MaTheLoai = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblTheLoai.setRowCount(0);
					rs = stmt.executeQuery("Select * from theloaisach");

					while (rs.next()) {
						String maTheLoai = rs.getString(1);
						String tenTheLoai = rs.getString(2);
						String moTa = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTheLoai);
						vec.add(tenTheLoai);
						vec.add(moTa);
						tblTheLoai.addRow(vec);
					}
					tbl.setModel(tblTheLoai);
					tblTheLoai.fireTableDataChanged();

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
					stmt.execute("delete from theloaisach where MaTheLoai = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
					tblTheLoai.setRowCount(0);
					rs = stmt.executeQuery("Select * from theloaisach");

					while (rs.next()) {
						String maTheLoai = rs.getString(1);
						String tenTheLoai = rs.getString(2);
						String moTa = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTheLoai);
						vec.add(tenTheLoai);
						vec.add(moTa);
						tblTheLoai.addRow(vec);
					}
					tbl.setModel(tblTheLoai);
					tblTheLoai.fireTableDataChanged();

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
						tblTheLoai.setRowCount(0);
						rs = stmt.executeQuery("Select * from theloaisach");

						while (rs.next()) {
							String maTheLoai = rs.getString(1);
							String tenTheLoai = rs.getString(2);
							String moTa = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(maTheLoai);
							vec.add(tenTheLoai);
							vec.add(moTa);
							tblTheLoai.addRow(vec);
						}
						tbl.setModel(tblTheLoai);
						tblTheLoai.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblTheLoai.setRowCount(0);
							rs = stmt.executeQuery("Select * from theloaisach where MaTheLoai = " + txtValue.getText() + "");

							while (rs.next()) {
								String maTheLoai = rs.getString(1);
								String tenTheLoai = rs.getString(2);
								String moTa = rs.getString(3);
								Vector<String> vec = new Vector<String>();
								vec.add(maTheLoai);
								vec.add(tenTheLoai);
								vec.add(moTa);
								tblTheLoai.addRow(vec);
							}
							tbl.setModel(tblTheLoai);
							tblTheLoai.fireTableDataChanged();

						} else if (index == 1) {
							tblTheLoai.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from theloaisach where TenTheLoai = \'" + txtValue.getText() + "\'");

							while (rs.next()) {
								String maTheLoai = rs.getString(1);
								String tenTheLoai = rs.getString(2);
								String moTa = rs.getString(3);
								Vector<String> vec = new Vector<String>();
								vec.add(maTheLoai);
								vec.add(tenTheLoai);
								vec.add(moTa);
								tblTheLoai.addRow(vec);
							}
							tbl.setModel(tblTheLoai);
							tblTheLoai.fireTableDataChanged();

						}
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		add(grTop);
		add(pnThree);
		add(pnCenter);
		add(pnTable);
	}
}
