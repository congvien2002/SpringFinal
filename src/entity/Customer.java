package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblCustomer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Tên không được để trống")
	@Length(min = 3, max = 50, message = "Tên chứa 3-50 kí tự")
	@Column(name = "name")
	private String name;
	@NotEmpty(message = "Email phải nhập")
	@Pattern(regexp = "[0-9a-z]{1,50}@[0-9a-z.]{5,20}", message = "Email không hợp lệ") // \w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+
	@Column(name = "email")
	private String email;
	@NotEmpty(message = "Số điện thoại phải nhập")
	@Pattern(regexp = "[0][0-9]{9}", message = "Số điện thoại không hợp lệ") // \w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+
	@Column(name = "phone")
	private String phone;
	@NotEmpty(message = "Địa chỉ phải nhập")
	@Column(name = "address")
	private String address;
	@Column(name = "gender")
	private boolean gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Dữ liệu ngày sinh không hợp lệ")
	@Column(name = "dob")
	private Date dob;
	@Column(name="password")
	private String password;
	@Column(name = "status")
	private int status;
	@Column(name = "rules")
	private boolean rules;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id,
			@NotEmpty(message = "Tên không được để trống") @Length(min = 3, max = 50, message = "Tên chứa 3-50 kí tự") String name,
			@NotEmpty(message = "Email phải nhập") @Pattern(regexp = "[0-9a-z]{1,10}@[0-9a-z.]{5,20}", message = "Email không hợp lệ") String email,
			@NotEmpty(message = "Số điện thoại phải nhập") @Pattern(regexp = "[0][0-9]{9}", message = "Số điện thoại không hợp lệ") String phone,
			@NotEmpty(message = "Địa chỉ phải nhập") String address,
			@NotNull(message = "Dữ liệu ngày sinh không hợp lệ") Date dob, boolean gender, String password,
			int status, boolean rules) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
		this.status = status;
		this.rules = rules;
	}

	public Customer(
			@NotEmpty(message = "Tên không được để trống") @Length(min = 3, max = 50, message = "Tên chứa 3-50 kí tự") String name,
			@NotEmpty(message = "Email phải nhập") @Pattern(regexp = "[0-9a-z]{1,10}@[0-9a-z.]{5,20}", message = "Email không hợp lệ") String email,
			@NotEmpty(message = "Số điện thoại phải nhập") @Pattern(regexp = "[0][0-9]{9}", message = "Số điện thoại không hợp lệ") String phone,
			@NotEmpty(message = "Địa chỉ phải nhập") String address,
			@NotNull(message = "Dữ liệu ngày sinh không hợp lệ") Date dob, boolean gender, String password,
			int status, boolean rules) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
		this.status = status;
		this.rules = rules;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isRules() {
		return rules;
	}

	public void setRules(boolean rules) {
		this.rules = rules;
	}

	
	
}
