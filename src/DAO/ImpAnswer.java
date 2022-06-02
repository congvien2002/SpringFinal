package DAO;

import java.util.List;

import org.hibernate.Session;

import Model.HibernateUtils;
import entity.Answer;

public class ImpAnswer implements DAO<Answer>{

	public ImpAnswer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Answer> selectAll() {
		Session ss = HibernateUtils.getSessionFactory().openSession();

		// Mở phiên giao dịch
		ss.beginTransaction();

		// Thực hiện truy vấn >>> Query sử dụng ngôn ngữ HQL (ngôn ngữ truy vấn ~ SQL)
		// >>> thao tác trên object
		List<Answer> lst = ss.createQuery("from Answer").list();

		// Đóng phiên
		ss.close();

		return lst;
	}

	@Override
	public Answer detail(int id) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		ss.beginTransaction();
//		Employee emp = (Employee) ss.createQuery("from Employee where id = :idemp")
//				.setParameter("idemp", id).getSingleAnswer();
		Answer emp = (Answer) ss.get(Answer.class, id);

		ss.close();
		return emp;
	}
	@Override
	public List<Answer> search(String data) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		List<Answer> lst = ss.createQuery("from Answer R JOIN Question Q ON R.quesID = Q.id WHERE Q.description like:search").setParameter("search","%" + data + "%").list();
		ss.close();
		return lst;
	}

	@Override
	public boolean insert(Answer e) {
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
	public boolean update(Answer e) {
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
			Answer eDel = ss.get(Answer.class, i);
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
