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
import entity.Answer;
import entity.Question;


@Controller
@RequestMapping("/answer")
public class AnswerController {

	@RequestMapping("/init-insert/{id}")
	public String initInsert(@PathVariable(name = "id") int id , Model m) {
		Answer ans = new Answer();
		m.addAttribute("ans", ans);
		m.addAttribute("quesid",id);
		return "answer/insert";
	}

	@RequestMapping("/insert")
	public String insert(@Valid @ModelAttribute("ans") Answer ans,BindingResult result ,Model m) {
		boolean isOK = false;
		if (!result.hasErrors()) {
			ImpAnswer ansDAO = new ImpAnswer();
			isOK = ansDAO.insert(ans);
			if (isOK) {
				m.addAttribute("msgOk", "Thêm mới dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại!");
			}
		}
		return "answer/insert";
	}
	@RequestMapping("/init-update/{id}")
	public String initUpdate(@PathVariable(name = "id", required = true) int idques, Model m) {
		ImpAnswer anDAO = new ImpAnswer();
		Answer ans = anDAO.detail(idques);
		m.addAttribute("ans", ans);
		
		return "answer/update";
	}
	@RequestMapping("/store")
	public String update(@Valid @ModelAttribute("ans") Answer ans, BindingResult result , Model m) {
		if (!result.hasErrors()) {
			ImpAnswer ansDAO = new ImpAnswer();
			boolean isOK = ansDAO.update(ans);
			if (isOK) {
				m.addAttribute("msgOk", "Cập nhật dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại khi CẬP NHẬT!");
			}
		}
		m.addAttribute("ans", ans);
		return "answer/update";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(name = "id", required = true) int id, Model m) {

		ImpAnswer ansDAO = new ImpAnswer();
		boolean isOK = ansDAO.del(id);

		if (isOK) {
			m.addAttribute("msgOk", "Xóa dữ liệu thành công");			
		} else {
			m.addAttribute("msgError", "Thất bại khi XÓA!");
		}
		ImpQuestion quesDAO = new ImpQuestion();
		ImpAnswer aDao = new ImpAnswer();
		List<Question> lst = quesDAO.selectAll();
		List<Answer> lstA = aDao.selectAll();
		m.addAttribute("lstQ", lst);
		m.addAttribute("lstA", lstA);
		return "question/list";
	}
	
}
