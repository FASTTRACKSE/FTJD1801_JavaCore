package fasttrackse.quanlytiendien.main;

import fasttrackse.quanlytiendien.DAO.BienLaiDAO;
import fasttrackse.quanlytiendien.UI.LoginUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUI ui = new LoginUI();
		ui.showWindow();
		BienLaiDAO date = new BienLaiDAO();
		date.getDay();
	}

}
