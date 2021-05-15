
public abstract class Staff implements ICalculator {
	private String id;
	private String fullName;
	private int age;
	private double coefficientPay;
	private String dateJoining;
	private String workPart;
	private int daysOff;
	
	/* 
	 * Day la lop truu tuong nen khong the tao doi tuong Staff
	 * Ham khoi tao de lop con co the goi super() 
	 */
	Staff() {
		
	}
	
	Staff(String id, String fullName, int age, double coefficientPay, String dateJoining, String workPart, int daysOff) {
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.coefficientPay = coefficientPay;
		this.dateJoining = dateJoining;
		this.workPart = workPart;
		this.daysOff = daysOff;
	}
	
	/* Duoi day la cac phuong thuc get va set cho cac thuoc tinh cua lop Staff */
	void setId(String id) {
		this.id = id;
	}
	
	String getId() {
		return this.id;
	}
	
	void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	String getFullName() {
		return this.fullName;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	int getAge() {
		return this.age;
	}
	
	void setCoefficientPay(double coefficientPay) {
		this.coefficientPay = coefficientPay;
	}
	
	Double getCoefficientPay() {
		return this.coefficientPay;
	}
	
	void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}
	
	String getDateJoining() {
		return this.dateJoining;
	}
	
	void setWorkPart(String workPart) {
		this.workPart = workPart;
	}
	
	String getWorkPart() {
		return this.workPart;
	}
	
	void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}
	
	int getDaysOff() {
		return this.daysOff;
	}
	
	//Phuong thuc truu tuong toString de cac lop con trien khai
	@Override
	abstract public String toString();
}
