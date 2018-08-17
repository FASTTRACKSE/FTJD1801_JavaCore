package fasttrackse.quanlytiendien.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.DAO.ThongKeDAO;
import fasttrackse.quanlytiendien.entity.BienLaiEntity;
import fasttrackse.quanlytiendien.entity.ComboItem;
import fasttrackse.quanlytiendien.entity.KhachHangEntity;
import fasttrackse.quanlytiendien.entity.PhuongEntity;
import fasttrackse.quanlytiendien.entity.QuanEntity;

public class PnThongKeUI {
	JPanel pnTxt = new JPanel();
	JPanel pnTxt1 = new JPanel();
	JComboBox cboPhuong;
	JComboBox cboQuan;
	JComboBox cbo;
	JComboBox cbo3;
	JComboBox cboNam;
	JComboBox cboNam1;
	JComboBox cboThang1;
	JTextField month1;
	JTextField year1;
	JTextField month2;
	JTextField year2;
	JTextField msKhachHang;
	DefaultTableModel dm1;
	ArrayList<BienLaiEntity> blList;
	ArrayList<KhachHangEntity> khList;

	public JPanel pnThongKe() {
		ThongKeDAO thongKe = new ThongKeDAO();
		blList = thongKe.taoListBL();
		khList = thongKe.taoListKH();
		JPanel pnThongKe = new JPanel();
		pnThongKe.setLayout(new BorderLayout());
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(3, 1));
		pnThongKe.add(pn1, BorderLayout.NORTH);
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thống kê");
		pnThongKe.setBorder(titlebor2);
		pnThongKe.setPreferredSize(new Dimension(800, 800));
		JPanel pnFilter = new JPanel();
		pn1.add(pnFilter);

		JPanel _pnTxt1 = new JPanel();
		JPanel _pnTxt2 = new JPanel();
		msKhachHang = new JTextField(10);

		pnTxt.add(_pnTxt1);
		pnTxt.add(_pnTxt2);

		_pnTxt1.setVisible(false);
		_pnTxt2.setVisible(false);

		_pnTxt2.add(msKhachHang);
		JPanel pnKhuVuc = new JPanel();
		pnKhuVuc.setLayout(new GridLayout(1, 2));
		cboQuan = new JComboBox<String>();
		cboQuan.addItem(new ComboItem(0, "Quận..."));
		cboQuan();
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem(new ComboItem(0, "Phường..."));

		cboQuan.addItemListener(new CboPhuong());
		pnKhuVuc.add(cboQuan);
		pnKhuVuc.add(cboPhuong);
		_pnTxt1.add(pnKhuVuc);
		JLabel kh = new JLabel("Khách hàng");
		cbo = new JComboBox<String>();
		cbo.addItem("Khách hàng.....");
		cbo.addItem("Tất cả khách hàng");
		cbo.addItem("Theo khu vực");
		cbo.addItem("Theo mã số khách hàng");
		pnFilter.add(kh);
		pnFilter.add(cbo);
		pnFilter.add(pnTxt);
		cbo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				int n = cbo.getSelectedIndex();
				switch (n) {
				case 0:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(false);
					break;
				case 1:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(false);
					break;
				case 2:
					_pnTxt1.setVisible(true);
					_pnTxt2.setVisible(false);
					break;
				case 3:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(true);
					break;
				}
			}
		});

		JPanel pnFilter1 = new JPanel();
		pn1.add(pnFilter1);
		JLabel bill = new JLabel("Biên lai");
		JPanel _pnTxt3 = new JPanel();
		JPanel _pnTxt4 = new JPanel();
		JPanel _pnTxt5 = new JPanel();

		// JTextField ms = new JTextField(20);

		pnFilter1.add(bill);
		pnTxt1.add(_pnTxt3);
		pnTxt1.add(_pnTxt4);
		pnTxt1.add(_pnTxt5);

		cboNam = new JComboBox();
		int tam = 0;
		for (BienLaiEntity bl : blList) {
			int nam = getYear(bl.getNgayNhap());
			if (nam != tam) {
				cboNam.addItem(nam);
				tam = nam;
			}
		}
		_pnTxt3.add(cboNam);

		month1 = new JTextField(5);
		JLabel m1 = new JLabel("/");
		year1 = new JTextField(5);
		JLabel m2 = new JLabel(" - ");
		month2 = new JTextField(5);
		JLabel m3 = new JLabel("/");
		year2 = new JTextField(5);
		_pnTxt4.add(month1);
		_pnTxt4.add(m1);
		_pnTxt4.add(year1);
		_pnTxt4.add(m2);
		_pnTxt4.add(month2);
		_pnTxt4.add(m3);
		_pnTxt4.add(year2);

		cboNam1 = new JComboBox();
		int tam1 = 0;
		// cboNam1.addItem("Năm .....");
		for (BienLaiEntity bl : blList) {
			int nam = getYear(bl.getChuKiNhap());
			if (nam != tam1) {
				cboNam1.addItem(nam);
				tam1 = nam;
			}
		}
		JLabel m4 = new JLabel("/");

		cboThang1 = new JComboBox();
		// cboThang1.addItem("Tháng ....");
		for (int i = 1; i <= 12; i++) {
			cboThang1.addItem(i);
		}
		_pnTxt5.add(cboNam1);
		_pnTxt5.add(m4);
		_pnTxt5.add(cboThang1);

		_pnTxt3.setVisible(false);
		_pnTxt4.setVisible(false);
		_pnTxt5.setVisible(false);

		cbo3 = new JComboBox<String>();
		cbo3.addItem("Thời gian.....");
		cbo3.addItem("Năm:");
		cbo3.addItem("Khoảng thời gian:");
		cbo3.addItem("Kỳ:");
		pnFilter1.add(cbo3);

		pnFilter1.add(pnTxt1);
		cbo3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				int i = cbo3.getSelectedIndex();
				switch (i) {
				case 0:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(false);
					break;
				case 1:
					_pnTxt3.setVisible(true);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(false);
					break;
				case 2:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(true);
					_pnTxt5.setVisible(false);
					break;
				case 3:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(true);
					break;
				}
			}
		});

		JPanel pnBtn = new JPanel();
		JButton btnSearch = new JButton("Search");
		btnSearch.setSize(30, 40);
		pnBtn.add(btnSearch);
		pn1.add(pnBtn);
		dm1 = new DefaultTableModel();
		dm1.addColumn("Mã khách hàng");
		dm1.addColumn("Mã số công tơ");
		dm1.addColumn("Họ tên");
		dm1.addColumn("Địa chỉ");
		dm1.addColumn("Phường");
		dm1.addColumn("Quận");
		dm1.addColumn("Thời gian");
		dm1.addColumn("Chu kì");
		dm1.addColumn("Chỉ số");
		dm1.addColumn("Số tiền");
		final JTable tbl1 = new JTable(dm1);
		dm1.setRowCount(0);
		for (BienLaiEntity bl : blList) {
			for (KhachHangEntity kh1 : khList) {
				if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
					showResult(bl, kh1);
				}
			}
		}
		tbl1.setModel(dm1);
		dm1.fireTableDataChanged();
		JScrollPane sc = new JScrollPane(tbl1);
		pnThongKe.add(sc, BorderLayout.CENTER);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				int i = cbo3.getSelectedIndex();
				switch (n) {
				case 0:
					dm1.setRowCount(0);
					for (BienLaiEntity bl : blList) {
						for (KhachHangEntity kh1 : khList) {
							if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
								showResult(bl, kh1);
							}
						}
					}
					tbl1.setModel(dm1);
					dm1.fireTableDataChanged();
					break;
				case 1:
					dm1.setRowCount(0);
					for (KhachHangEntity kh1 : khList) {
						for (BienLaiEntity bl : blList) {
							switch (i) {
							case 1:
								if (((int) (cboNam.getSelectedItem())) == getYear(bl.getNgayNhap())) {
									if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
										showResult(bl, kh1);
									}
								}
								break;
							case 2:
								int thang1 = Integer.parseInt(month1.getText());
								int nam1 = Integer.parseInt(year1.getText());
								int thang2 = Integer.parseInt(month2.getText());
								int nam2 = Integer.parseInt(year2.getText());
								int nam = getYear(bl.getNgayNhap());
								int thang = getMonth(bl.getNgayNhap());
								if ((nam1 <= nam) && (nam <= nam2)) {
									if ((thang1 <= thang) && (thang <= thang2)) {
										if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
											showResult(bl, kh1);
										}
									}
								}
								break;
							case 3:
								if (((int) cboNam1.getSelectedItem()) == getYear(bl.getChuKiNhap())) {
									if (((int) cboThang1.getSelectedItem()) == getMonth(bl.getChuKiNhap())) {
										if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
											showResult(bl, kh1);
										}
									}
								}
								break;
							}
						}
					}
					tbl1.setModel(dm1);
					dm1.fireTableDataChanged();
					break;
				case 2:
					dm1.setRowCount(0);
					int index = cboQuan.getSelectedIndex();
					if (index == 0) {
						for (BienLaiEntity bl : blList) {
							for (KhachHangEntity kh1 : khList) {
								if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
									showResult(bl, kh1);
								}
							}
						}
					} else {
						int phuong = ((ComboItem) cboPhuong.getSelectedItem()).getId();
						int quan = ((ComboItem) cboQuan.getSelectedItem()).getId();
						for (BienLaiEntity bl : blList) {
							for (KhachHangEntity kh1 : khList) {
								if ((kh1.getQuan() == quan) && (kh1.getPhuong() == phuong)) {
									switch (i) {
									case 1:
										if (((int) (cboNam.getSelectedItem())) == getYear(bl.getNgayNhap())) {
											if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
												showResult(bl, kh1);
											}
										}
										break;
									case 2:
										int thang1 = Integer.parseInt(month1.getText());
										int nam1 = Integer.parseInt(year1.getText());
										int thang2 = Integer.parseInt(month2.getText());
										int nam2 = Integer.parseInt(year2.getText());
										int nam = getYear(bl.getNgayNhap());
										int thang = getMonth(bl.getNgayNhap());
										if ((nam1 <= nam) && (nam <= nam2)) {
											if ((thang1 <= thang) && (thang <= thang2)) {
												if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
													showResult(bl, kh1);
												}
											}
										}
										break;
									case 3:
										if (((int) cboNam1.getSelectedItem()) == getYear(bl.getChuKiNhap())) {
											if (((int) cboThang1.getSelectedItem()) == getMonth(bl.getChuKiNhap())) {
												if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
													showResult(bl, kh1);
												}
											}
										}
										break;
									}
								}
							}
						}
					}
					tbl1.setModel(dm1);
					dm1.fireTableDataChanged();
					break;
				case 3:
					dm1.setRowCount(0);
					String idKH = msKhachHang.getText();
					for (BienLaiEntity bl : blList) {
						for (KhachHangEntity kh1 : khList) {
							if (idKH.equals(kh1.getMaKhachHang())) {
								switch (i) {
								case 1:
									if (((int) (cboNam.getSelectedItem())) == getYear(bl.getNgayNhap())) {
										if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
											showResult(bl, kh1);
										}
									}
									break;
								case 2:
									int thang1 = Integer.parseInt(month1.getText());
									int nam1 = Integer.parseInt(year1.getText());
									int thang2 = Integer.parseInt(month2.getText());
									int nam2 = Integer.parseInt(year2.getText());
									int nam = getYear(bl.getNgayNhap());
									int thang = getMonth(bl.getNgayNhap());
									if ((nam1 <= nam) && (nam <= nam2)) {
										if ((thang1 <= thang) && (thang <= thang2)) {
											if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
												showResult(bl, kh1);
											}
										}
									}
									break;
								case 3:
									if (((int) cboNam1.getSelectedItem()) == getYear(bl.getChuKiNhap())) {
										if (((int) cboThang1.getSelectedItem()) == getMonth(bl.getChuKiNhap())) {
											if (kh1.getMaSoCongTo() == bl.getMaSoCongToDien()) {
												showResult(bl, kh1);
											}
										}
									}
									break;
								}
							}
						}
					}
				}
			}
		});
		return pnThongKe;
	}

	private void cboQuan() {
		QuanEntity quan = new QuanEntity();
		quan.quan();
		for (QuanEntity quan1 : quan.quan()) {
			cboQuan.addItem(new ComboItem(quan1.getMaQh(), quan1.getTenQuan()));
		}
	}

	private class CboPhuong implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			int i = cboQuan.getSelectedIndex();
			PhuongEntity phuong = new PhuongEntity();
			switch (i) {
			case 0:
				cboPhuong.removeAllItems();
				cboPhuong.addItem("Phường ....");
				break;
			case 1:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 490) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));

					}
				}
				break;
			case 2:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 491) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 3:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 492) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 4:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 493) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 5:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 494) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 6:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 495) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 7:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 497) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 8:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 498) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			}
		}
	}

	private int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	private int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	private int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	private void showResult(BienLaiEntity bl, KhachHangEntity kh) {
		int year = getYear(bl.getNgayNhap());
		int month = getMonth(bl.getNgayNhap());
		int day = getDay(bl.getNgayNhap());
		int namCK = getYear(bl.getChuKiNhap());
		int thangCK = getMonth(bl.getChuKiNhap());
		String ngayNhap = day + "-" + month + "-" + year;
		String chuKiNhap = thangCK + "-" + namCK;
		dm1.addRow(new String[] { kh.getMaKhachHang(), String.valueOf(kh.getMaSoCongTo()), kh.getHoTen(),
				kh.getDiaChi(), String.valueOf(kh.getPhuong()), String.valueOf(kh.getQuan()), ngayNhap, chuKiNhap,
				String.valueOf(bl.getChiSoCongTo()), String.valueOf(bl.getTienDien()) });

	}
}
