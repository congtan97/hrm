
public class Employee extends Staff implements ICalculator {
	private int overtime;
	
	Employee() {
		super();
	}
	
	Employee(String id, String fullName, int age, double coefficientPay, String dateJoining, String workPart, int daysOff, int overtime) {
		super(id, fullName, age, coefficientPay, dateJoining, workPart, daysOff);
		this.overtime = overtime;
	}
	
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	
	public int getOvertime() {
		return this.overtime;
	}
	
	/* Phuong thuc tinh luong cho nhan vien binh thuong tra ve So tien luong
	 * Cach tinh luong: He so luong * 3,000,000 + So gio lam them * 200,000
	 * Luong trach nhiem tuong ung voi chuc vu
	 */
	@Override
	public double calculateSalary() {
		return (3000000 * this.getCoefficientPay() + 200000 * this.overtime);
	}
	
	//Phuong thuc trien khai toString de hien thi thong tin nhan vien Binh thuong
	@Override
	public String toString() {
		return String.format("%-10s %-30s %-10d %-20f %-20s %-20s %-10d %-10d", this.getId(), this.getFullName(), this.getAge(), this.getCoefficientPay(), this.getDateJoining(), this.getWorkPart(), this.getDaysOff(), this.overtime);
	}
}
