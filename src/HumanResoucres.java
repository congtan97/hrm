import java.util.*;
public class HumanResoucres {
	
	//Tao mang danh sach nhan vien Binh thuong
	static ArrayList<Staff> employees = new ArrayList<>();
	//Tao mang danh sach nhan vien Quan Ly
	static ArrayList<Staff> managers = new ArrayList<>();
	//Tao mang danh sach cac Bo phan
	static ArrayList<Department> departments = new ArrayList<>();
	
	//Khoi tao cac Bo phan trong cong ty
	static Department dpm1 = new Department("BBB", "Kinh doanh", 0);
	static Department dpm2 = new Department("TTT", "Ky thuat", 0);
	static Department dpm3 = new Department("EEE", "Tai chinh", 0);
	
	public static void main(String args[]) {
		
		//Them 3 bo phan vao mang danh sach cac bo phan
		departments.add(dpm1);
		departments.add(dpm2);
		departments.add(dpm3);
		
		//Tao va them vao danh sach nhung nhan vien va quan ly dau tien
		Staff man1 = new Manager("TT1", "Nguyen Loc", 43, 3.2, "13/04/2003", "Ky thuat", 15, "Technical Leader");
		managers.add(man1);
		Staff man2 = new Manager("TT2", "Tran Huu", 35, 2.6, "25/08/2014", "Ky thuat", 13, "Project Leader");
		managers.add(man2);
		Staff man3 = new Manager("EE1", "Nguyen Quang", 37, 2.3, "15/06/2017", "Tai chinh", 6, "Business Leader");
		managers.add(man3);
		Staff man4 = new Manager("EE2", "Pham Tuan", 29, 1.9, "12/12/2012", "Tai chinh", 7, "Business Leader");
		managers.add(man4);
		
		Staff emp1 = new Employee("T01", "Truong Tan", 23, 1.8, "22/02/2022", "Ky thuat", 12, 32);
		employees.add(emp1);
		Staff emp2 = new Employee("T02", "Ngo Ngoc", 18, 1.2, "30/08/2023", "Ky thuat", 8, 14);
		employees.add(emp2);
		Staff emp3 = new Employee("E01", "Nguyen Anh", 23, 1.4, "13/01/2010", "Tai chinh", 10, 10);
		employees.add(emp3);
		Staff emp4 = new Employee("B01", "Dinh Luc", 30, 2.1, "23/03/2013", "Kinh doanh", 5, 6);
		employees.add(emp4);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Human Resource Management programs");
		
		//Bien true de luon lap lai man hinh lua chon
		while (true) {
			System.out.println("1. Display a list of employees in the company \n"
					 		 + "2. Show departments in the company \n"
					 		 + "3. Show employees by department \n"
					 		 + "4. Add new employees to the company \n"
					 		 + "5. Search employee information by name or ID \n"
					 		 + "6. Display employee payroll in descending order \n"
					 		 + "7. Display employee payroll in ascending order \n"
					 		 + "8. Exit");
			System.out.print("Your choice: ");
			int choice = in.nextInt();
			
			switch (choice) {
			case 1:
				showEmployees();
				break;
			case 2:
				showDepartments();
				break;
			case 3:
				showEmployeesByDepartment();
				break;
			case 4:
				addEmployee();
				break;
			case 5:
				searchEmployee();
				break;
			case 6:
				showPayroll();
				break;
			case 7:
				showOrderedPayroll();
				break;
			case 8:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Please choose from 1 to 8.");
			}
		}
	}
	
	//Phuong thuc hien thi toan bo nhan vien
	public static void showEmployees() {
		//Hien thi cac nhan vien quan ly
		System.out.println("List of Managers:");
		System.out.printf("%-10s %-30s %-10s %-20s %-20s %-20s %-10s %-20s\n", "ID", "Full Name", "Age", "Coefficient Pay", "Date of Joining", "Department", "Daysoff", "Title");
		//Duyet mang nhan vien quan ly
		for (Staff manager: managers) {
			System.out.println(manager.toString());
		}
		//Hien thi cac nhan vien binh thuong
		System.out.println("List of Employees:");
		System.out.printf("%-10s %-30s %-10s %-20s %-20s %-20s %-10s %-20s\n", "ID", "Full Name", "Age", "Coefficient Pay", "Date of Joining", "Department", "Daysoff", "Overtime");
		//Duyet mang nhan vien binh thuong
		for (Staff employee: employees) {
			System.out.println(employee.toString());
		}
	}
	
	//Phuong thuc hien thi tat ca cac Bo phan trong cong ty
	public static void showDepartments() {
		//Tao mang tat ca cac nhan vien va quan ly
		ArrayList<Staff> allStaff = new ArrayList<>();
		//Duyet mang nhan vien Quan ly va them tat ca phan tu vao mang allStaff
		for (Staff staff: managers) { 
			allStaff.add(staff);
		}
		//Duyet mang nhan vien Binh thuong va them tat ca phan tu vao mang allStaff
		for (Staff staff: employees) {
			allStaff.add(staff);
		}
		/* Dem so luong nhan vien tung Bo phan
		 * Neu bo phan nhan vien lam viec trung voi ten Bo phan thi tang so luong nhan vien Bo phan do them 1
		 * Thiet lap so luong nhan vien ve 0 de dem lai tu dau
		 */
		for (Department department: departments) {
				department.setNumEmpls(0);
		}
		for (Staff staff: allStaff) {
			for (Department department: departments) {
				if (staff.getWorkPart().equalsIgnoreCase(department.getPartName())) {
					department.setNumEmpls(department.getNumEmpls() + 1);
				}
			}
		}

		System.out.println("List of Departments:");
		System.out.printf("%-30s%-30s%-30s\n", "Department Code:", "Department Name:", "Number of Employees:");
		for (Department department: departments) {
			System.out.println(department.toString());
		}
	}
	
	//Phuong thuc hien thi cac nhan vien theo Bo phan lam viec
	public static void showEmployeesByDepartment() {
		ArrayList<Staff> allStaff = new ArrayList<>();
		for (Staff staff: managers) {
			allStaff.add(staff);
		}
		for (Staff staff: employees) {
			allStaff.add(staff);
		}
		
		//Dinh nghia lai phuong thuc sort() de sap xep workPart theo thu tu A-Z
		Collections.sort(allStaff, new Comparator<Staff>() {
			//Ghi de phuong thuc compare() de so sanh 2 doi tuong Staff theo workPart
            @Override
            public int compare(Staff s1, Staff s2) { 
                return s1.getWorkPart().compareTo(s2.getWorkPart());
            }
        });
		
		System.out.printf("%-10s %-30s %-10s %-20s %-20s %-20s %-10s %-20s\n", "ID", "Full Name", "Age", "Coefficient Pay", "Date of Joining", "Department", "Daysoff", "Title/Overtime");
		for (Staff staff: allStaff) {
			System.out.println(staff.toString());
		}
	}
	
	//Phuong thuc them nhan vien
	public static void addEmployee() {
		Scanner in = new Scanner(System.in);
		System.out.println("1. Add an employee\n2.Add a manager");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Please enter employee information:");
			
			in.nextLine();//Tranh troi dong
			System.out.print("ID: ");
			String id = in.nextLine().toUpperCase();
			
			System.out.print("Full Name: ");
			String fullName = in.nextLine();
			
			System.out.print("Age: ");
			int age = in.nextInt();
			
			System.out.print("Coefficient Pay: ");
			Double coefficientPay = in.nextDouble();
			
			in.nextLine();//Tranh troi dong
			System.out.print("Date of Joining: ");
			String dateJoining = in.nextLine();
			
			System.out.print("Department: ");
			String workPart = in.nextLine();
			
			System.out.print("Days Off: ");
			int daysOff = in.nextInt();
			
			System.out.print("Overtime: ");
			int overtime = in.nextInt();
			
			//Khoi tao nhan vien Binh thuong moi
			Staff newEmployee = new Employee(id, fullName, age, coefficientPay, dateJoining, workPart, daysOff, overtime);
			//Them nhan vien Binh thuong moi vao danh sach nhan vien Binh thuong
			employees.add(newEmployee);
			
			System.out.println("A new employee has been added.");
			break;
		case 2:
			System.out.println("Please enter employee information:");
			
			in.nextLine();
			System.out.println("ID: ");
			String id2 = in.nextLine().toUpperCase();
			
			System.out.println("Full Name: ");
			String fullName2 = in.nextLine();
			
			System.out.println("Age: ");
			int age2 = in.nextInt();
			
			System.out.println("Coefficient Pay: ");
			Double coefficientPay2 = in.nextDouble();
			in.nextLine();
			System.out.println("Date of Joining: ");
			String dateJoining2 = in.nextLine();
			
			System.out.println("Department: ");
			String workPart2 = in.nextLine();
			
			System.out.println("Days Off: ");
			int daysOff2 = in.nextInt();
			
			System.out.println("Choose title of manager:\n1. Business Leader\n2. Project Leader\n3. Technical Leader");
			String title = null;
			choice = in.nextInt();
			switch (choice) {
			case 1:
				title = "Business Leader";
				break;
			case 2:
				title = "Project Leader";
				break;
			case 3:
				title = "Technical Leader";
				break;
			}
			
			//Khoi tao mot Manager moi
			Staff newManager = new Manager(id2, fullName2, age2, coefficientPay2, dateJoining2, workPart2, daysOff2, title);
			//Them manager moi nay vao danh sach Manager
			managers.add(newManager);
			
			System.out.println("An new manager has been added.");
			break;
		}
	}
	
	//Phuong thuc tim kiem nhan vien bang ten hoac ID
	public static void searchEmployee() {
		System.out.println("Enter name or ID to search.");
		Scanner in = new Scanner(System.in);
		System.out.print("Name or ID: ");
		String searchKey = in.nextLine();
		
		//Tao mang danh sach nhan vien tim duoc
		ArrayList<Staff> staffsFound = new ArrayList<>();
		
		//Duyet va tim kiem trong mang Managers
		for (Staff staff : managers) {
			if (staff.getFullName().toUpperCase().contains(searchKey.toUpperCase()) || staff.getId().equals(searchKey.toUpperCase())) {//Neu chuoi searchKey co trong chuoi fullName || ID==searchKey
				staffsFound.add(staff);
			}
		}
		
		//Duyet va tim kiem trong mang Employees
		for (Staff staff : employees) {
			if (staff.getFullName().toUpperCase().contains(searchKey.toUpperCase()) || staff.getId().equals(searchKey.toUpperCase())) {
				staffsFound.add(staff);
			}
		}
		
		if (staffsFound.isEmpty()) {
			System.out.println("No employees or manager is found.");
		} else {
			System.out.printf("%-10s %-30s %-10s %-20s %-20s %-20s %-10s %-10s\n", "ID", "Full Name", "Age", "Coefficient Pay", "Date of Joining", "Department", "Days Off", "Title/Overtime");
			for (Staff staff : staffsFound) {
				System.out.println(staff.toString());
			}
		}
	}
	
	//Phuong thuc hien thi bang luong nhan vien tu cao den thap
	public static void showPayroll() {
		ArrayList<Staff> allStaff = new ArrayList<>();
		for (Staff staff: managers) {
			allStaff.add(staff);
		}
		for (Staff staff: employees) {
			allStaff.add(staff);
		}
		
		//Dinh nghia lai phuong thuc sort() de so sanh 2 Staff
		Collections.sort(allStaff, new Comparator<Staff>() { 
            @Override
            //So sanh 2 doi tuong Staff theo Luong
            public int compare(Staff s1, Staff s2) {
            	//Luong lon hon duoc xep truoc
               if (s1.calculateSalary() < s2.calculateSalary()) { 
            	   return 1;
               } else if (s1.calculateSalary() == s2.calculateSalary()) {
            		   return 0;
               } else {
            		   return -1;
               }
             }
        });
		System.out.println("Display employee payroll in descending order:");
		System.out.printf("%-10s %-20s %-20s %-20s\n", "ID", "Full Name", "Coefficient Pay", "Salary");
		for (Staff staff: allStaff) {
			System.out.printf("%-10s %-20s %-20.2f %-20.0f\n", staff.getId(), staff.getFullName(), +staff.getCoefficientPay(), staff.calculateSalary());
		}
	}
	
	//Phuong thuc hien thi bang luong nhan vien tu thap len cao
	public static void showOrderedPayroll() {
		ArrayList<Staff> allStaff = new ArrayList<>();
		for (Staff staff: managers) {
			allStaff.add(staff);
		}
		for (Staff staff: employees) {
			allStaff.add(staff);
		}
		
		//Dinh nghia lai phuong thuc sort() de so sanh 2 Staff
		Collections.sort(allStaff, new Comparator<Staff>() { 
            @Override
            //So sanh 2 doi tuong Staff theo Luong
            public int compare(Staff s1, Staff s2) {
            	//Luong be hon duoc xep truoc
               if (s1.calculateSalary() < s2.calculateSalary()) { 
            	   return -1;
               } else if (s1.calculateSalary() == s2.calculateSalary()) {
            		   return 0;
               } else {
            		   return 1;
               }
             }
        });
		System.out.println("Display employee payroll in ascending order:");
		System.out.printf("%-10s %-20s %-20s %-20s\n", "ID", "Full Name", "Coefficient Pay", "Salary");
		for (Staff staff: allStaff) {
			System.out.printf("%-10s %-20s %-20.2f %-20.0f\n", staff.getId(), staff.getFullName(), +staff.getCoefficientPay(), staff.calculateSalary());
		}
	}
}
