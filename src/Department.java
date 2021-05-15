
public class Department {
	private String partCode;
	private String partName;
	private int numEmpls;
	
	Department() {
		
	}
	
	Department(String partCode, String partName, int numEmps) {
		this.partCode = partCode;
		this.partName = partName;
		this.numEmpls = numEmps;
	}
	
	//Phuong thuc thiet lap so luong nhan vien
	public void setNumEmpls(int num) {
		this.numEmpls = num;
	}
	
	//Phuong thuc lay so luong nhan vien
	public int getNumEmpls() {
		return this.numEmpls;
	}
	
	//Phuong thuc thiet lap ten Bo phan
		public void setPartName(String partName) {
			this.partName = partName;
		}
		
	//Phuong thuc lay ten Bo phan
	public String getPartName() {
		return this.partName;
	}
	
	//Ghi de phuong thuc toString de hien thi cac Bo phan
	@Override
	public String toString() {
		return String.format("%-30s%-30s%-30d", this.partCode, this.partName, this.numEmpls);
	}
}
