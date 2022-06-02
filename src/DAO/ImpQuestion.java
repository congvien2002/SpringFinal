package DAO;

import java.util.List;

import org.hibernate.Session;

import Model.HibernateUtils;
import entity.Question;

public class ImpQuestion implements DAO<Question>{

	public ImpQuestion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Question> selectAll() {
		Session ss = HibernateUtils.getSessionFactory().openSession();

		// Mở phiên giao dịch
		ss.beginTransaction();

		// Thực hiện truy vấn >>> Query sử dụng ngôn ngữ HQL (ngôn ngữ truy vấn ~ SQL)
		// >>> thao tác trên object
		List<Question> lst = ss.createQuery("from Question").list();

		// Đóng phiên
		ss.close();

		return lst;
	}

	@Override
	public Question detail(int id) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
//		Employee emp = (Employee) ss.createQuery("from Employee where id = :idemp")
//				.setParameter("idemp", id).getSingleResult();
		Question emp = (Question) ss.get(Question.class, id);

		ss.close();
		return emp;
	}
	@Override
	public List<Question> search(String data) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		List<Question> lst = ss.createQuery("from Question WHERE description like:search").setParameter("search","%" + data + "%").list();
		ss.close();
		return lst;
	}

	@Override
	public boolean insert(Question e) {
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
	public boolean update(Question e) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
		try {
			ss.update(e);
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
			Question eDel = ss.get(Question.class, i);
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

}
