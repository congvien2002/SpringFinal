package controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.ImpAnswer;
import DAO.ImpQuestion;
import DAO.ImpResult;
import entity.Answer;
import entity.Question;
import entity.Result;


@Controller
@RequestMapping("/result")
public class ResultController {
	
	@RequestMapping(value = { "", "/", "/list" })
	public String list(Model m) {
		ImpQuestion qDao = new ImpQuestion();
		List<Question> lstQ = qDao.selectAll();
		ImpAnswer aDao = new ImpAnswer();
		List<Answer> lstA = aDao.selectAll();
		m.addAttribute("lstQ",lstQ);
		m.addAttribute("lstA",lstA);
		
		return "result/list";
	}
	@RequestMapping("/{id}")
	public String selectById(@PathVariable(name = "id", required = false) int id, Model m) {
		ImpResult rdao = new ImpResult();
		ImpQuestion qDao = new ImpQuestion();
		Question q = qDao.detail(id);
		ImpAnswer aDao = new ImpAnswer();
		List<Answer> lstA = aDao.selectAll();
		List<Integer> lst = rdao.selectAnsID(q.getId());
		for(int item : lst) {
			rdao.selectCount(q.getId(), item);
		}
		
		m.addAttribute("ques",q);
		m.addAttribute("lstA",lstA);
		
		return "result/detail";
	}
	@RequestMapping("/insert")
	public String insert(@Valid @ModelAttribute("result") Result r,BindingResult result ,Model m) {
//		boolean isOK = false;
//		if (!result.hasErrors()) {
//			ImpResult ansDAO = new ImpResult();
//			isOK = ansDAO.insert(r);
//			ImpQuestion qDao = new ImpQuestion();
//			int i = r.getQues().getTotal() + 1;
//			qDao.detail(r.getQues().getId()).setTotal(i);
//			if (isOK) {
//				m.addAttribute("msgOk", "Thêm mới dữ liệu thành công");
//			} else {
//				m.addAttribute("msgError", "Thất bại!");
//			}
//		}
//		ImpQuestion quesDAO = new ImpQuestion();
//		ImpAnswer aDao = new ImpAnswer();
//		List<Question> lst = quesDAO.selectAll();
//		List<Answer> lstA = aDao.selectAll();
//		m.addAttribute("lstQ", lst);
//		m.addAttribute("lstA", lstA);
		System.out.println(r.getId());
		System.out.println(r.getQues().getId());
		System.out.println(r.getAns().getId());
		return "question/list";
	}
}
