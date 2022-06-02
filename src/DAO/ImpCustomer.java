package DAO;

import java.util.List;

import org.hibernate.Session;
import org.springframework.ui.Model;

import Model.HibernateUtils;
import entity.Customer;

public class ImpCustomer implements DAO<Customer>{
	public ImpCustomer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> selectAll() {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();

		// Thực hiện truy vấn >>> Query sử dụng ngôn ngữ HQL (ngôn ngữ truy vấn ~ SQL)
		// >>> thao tác trên object
		List<Customer> lst = ss.createQuery("from Customer").list();

		// Đóng phiên
		ss.close();

		return lst;
	}
	@Override
	public Customer detail(int id) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
//		Employee emp = (Employee) ss.createQuery("from Employee where id = :idemp")
//				.setParameter("idemp", id).getSingleResult();
		Customer emp = (Customer) ss.get(Customer.class, id);

		ss.close();
		return emp;
	}
	@Override
	public List<Customer> search(String data) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		List<Customer> lst = ss.createQuery("from Customer WHERE name like:search").setParameter("search","%"+data+"%").list();
		ss.close();
		return lst;
	}

	@Override
	public boolean insert(Customer e) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
		try {
			ss.save(e);
			ss.getTransaction().commit(); // Xác nhận thay đổi
		} catch (Exception ex) {
			System.out.println("Lỗi: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		} finally {
			ss.close();
		}
		
		return true;
	}

	@Override
	public boolean update(Customer c) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
		try {
			ss.update(c);
			ss.getTransaction().commit(); // Xác nhận thay đổi
		} catch (Exception ex) {
			System.out.println("Lỗi: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		} finally {
			ss.close();
		}
		
		return true;
	}

	@Override
	public boolean del(int i) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
		try {
			Customer eDel = ss.get(Customer.class, i);
			ss.delete(eDel);
			ss.getTransaction().commit(); // Xác nhận thay đổi
		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			ss.close();
		}

		return true;
	}
	public Customer login(String name , String pass) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();
		Customer c = new Customer();
		// Thực hiện truy vấn >>> Query sử dụng ngôn ngữ HQL (ngôn ngữ truy vấn ~ SQL)
		// >>> thao tác trên object
		if(name.contains("@")) {
			c = (Customer) ss.createQuery("from Customer WHERE email like:email AND password like:password").setParameter("email", name).setParameter("password", pass).getSingleResult();
		}else {
			c = (Customer) ss.createQuery("from Customer WHERE phone like:phone AND password like:password").setParameter("phone", name).setParameter("password", pass).getSingleResult();
		}
		ss.close();
		return c;
	}

}
