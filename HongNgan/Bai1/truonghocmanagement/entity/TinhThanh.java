package entity;

public class TinhThanh {
	private String name, provinceId;

	public TinhThanh() {
		//
	}

	public TinhThanh(String provinceId, String name) {
		this.name = name;
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
