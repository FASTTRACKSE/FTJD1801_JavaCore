package fasttrackse.quanlytiendien.entity;

public class ComboItem {
	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String label) {
		this.name = label;
	}

	public void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return this.id;
	}

	public ComboItem(int value, String label) {
		this.id = value;
		this.name = label;
	}

	@Override
	public String toString() {
		return name;
	}
}
