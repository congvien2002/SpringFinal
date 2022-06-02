package DAO;

import java.util.List;


public interface DAO<T> {
	List<T> selectAll();
	
	List<T> search(String data);
	
	boolean insert(T e);
	
	boolean update(T e);
	
	boolean del(int i);

	T detail(int id);
	
}	
