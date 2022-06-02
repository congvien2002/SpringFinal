package Model;


import java.util.List;

import DAO.ImpAnswer;
import DAO.ImpCustomer;
import DAO.ImpQuestion;
import DAO.ImpResult;
import entity.Result;
public class test {

	public static void main(String[] args) {
		// Lấy dữ liệu phòng ban
		ImpQuestion depDAO = new ImpQuestion();
		ImpCustomer cusDao = new ImpCustomer();
		ImpAnswer aDao = new ImpAnswer();
		ImpResult rDao = new ImpResult();
		List<Result> lstr = rDao.selectAll();
//		List<Question> lst = depDAO.update(1);
//		for (Question dep : lst) {
//			System.err.println(dep.getDescription());
//		}
		for(Result r : lstr) {
			System.err.println(r.getAns().getId());
		}
	}

}
