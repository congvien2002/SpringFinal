package DAO;

import java.util.List;

import org.hibernate.Session;

import Model.HibernateUtils;
import entity.Customer;
import entity.Result;

public class ImpResult implements DAO<Result>{

	public ImpResult() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Result> selectAll() {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();

		// Thực hiện truy vấn >>> Query sử dụng ngôn ngữ HQL (ngôn ngữ truy vấn ~ SQL)
		// >>> thao tác trên object
		List<Result> lst = ss.createQuery("from Result").list();

		// Đóng phiên
		ss.close();

		return lst;
	}

	@Override
	public List<Result> search(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Result e) {
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
	public boolean update(Result e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(int i) {
		// TODO Auto-generated method stub=
		
		return false;
	}

	@Override
	public Result detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Integer> selectAnsID(int i) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();
		List<Integer> count = ss.createNativeQuery("{CALL CountAns(?)}").setParameter(1, i).list();
		ss.close();
		return count;
	}
	public void selectCount(int i,int aid) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();
		ss.createNativeQuery("{CALL SetCount(?,?)}").setParameter(1, i).setParameter(2, aid);
		ss.close();
	}
	public void SetTotal(int i) {
		Session ss = HibernateUtils.getSessionFactory().openSession();
		// Mở phiên giao dịch
		ss.beginTransaction();
		ss.createNativeQuery("{CALL SetTotal(?)}").setParameter(1, i);
		ss.close();
	}
}
