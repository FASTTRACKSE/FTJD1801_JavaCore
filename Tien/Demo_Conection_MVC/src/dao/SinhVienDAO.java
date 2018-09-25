package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.SinhVien;
import utils.ConnectionFactory;

public class SinhVienDAO {
	private Connection connection;

	private Statement statement;
	private PreparedStatement preparedStatement;

	public SinhVienDAO() {
		super();
	}

	public ArrayList<SinhVien> getAllSinhVien() {
		String query = "SELECT * FROM sinhvien";

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getString("MaSV"), rs.getString("TenSV"), rs.getInt("NamSinh"));
				list.add(sinhVien);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addNewSinhVien(SinhVien sv) {
		String query = "INSERT INTO sinhvien(MaSV, TenSV, NamSinh) VALUES(?, ?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getMaSV());
			preparedStatement.setString(2, sv.getHoTen());
			preparedStatement.setInt(3, sv.getNamSinh());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void removeSinhVien(SinhVien sv) {
		String query = "DELETE FROM sinhvien WHERE MaSV = ?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getMaSV());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public SinhVien selectSinhVien(String id) {
		String query = "SELECT * FROM sinhvien WHERE MaSV = ?";

		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getString("MaSV"), rs.getString("TenSV"), rs.getInt("NamSinh"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sinhVien;
	}
	
	public void updateSinhVien(SinhVien sv) {
		String query = "UPDATE sinhvien SET TenSV = ?, NamSinh = ? WHERE MaSV = ? ";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(3, sv.getMaSV());
			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setInt(2, sv.getNamSinh());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
