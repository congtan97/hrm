
public class Manager extends Staff implements ICalculator {
	private String title;
	
	Manager() {
		super();
	}
	
	Manager(String id, String fullName, int age, double coefficientPay, String dateJoining, String workPart, int daysOff, String title) {
		super(id, fullName, age, coefficientPay, dateJoining, workPart, daysOff);
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	/* Phuong thuc tinh luong cho nhan vien quan ly tra ve So tien luong
	 * Cach tinh luong: He so luong * 5,000,000 + Luong trach nhiem
	 * Luong trach nhiem tuong ung voi chuc vu
	 */
	@Override
	public double calculateSalary() {
		double Salary = 5000000 * this.getCoefficientPay();
		if (this.getTitle().equals("Business Leader")) {
			Salary += 8000000;
		} else if (this.getTitle().equals("Project Leader")) {
				Salary += 5000000;
			} else if (this.getTitle().equals("Technical Leader")) {
					Salary += 6000000;
				}
			
		return Salary;
	}
	
	//Phuong thuc trien khai toString de hien thi thong tin nhan vien Quan ly
	@Override
	public String toString() {
		return String.format("%-10s %-30s %-10d %-20f %-20s %-20s %-10d %-10s", this.getId(), this.getFullName(), this.getAge(), this.getCoefficientPay(), this.getDateJoining(), this.getWorkPart(), this.getDaysOff(), this.title);
	}
}
