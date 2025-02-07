package Model;

public class Employees {
    private int id;
    private String name;
    private String email;
    private String contactNo ;
    private String department;
    private int age;
    private float salary;
    
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String name, String email, String contactNo, String department, int age, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}

	public Employees(String name, String email, String contactNo, String department, int age, float salary) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", department=" + department + ", age=" + age + ", salary=" + salary + "]";
	}
    
	
    
}
