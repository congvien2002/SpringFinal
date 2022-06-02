package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.ImpAnswer;
import DAO.ImpCustomer;
import DAO.ImpQuestion;
import entity.Answer;
import entity.Customer;
import entity.Question;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping(value = { "", "/", "/list" })
	public String getAll(Model m) {
		ImpCustomer cusDAO = new ImpCustomer();
		List<Customer> lst = cusDAO.selectAll();

		m.addAttribute("listCus", lst);

		return "customer/list";
	}
	
	@RequestMapping("/init-insert")
	public String initInsert(Model m) {

		Customer cus = new Customer();
		m.addAttribute("cus", cus);

		return "customer/insert";
	}

	@RequestMapping("/insert")
	public String insert(@Valid @ModelAttribute("cus") Customer cus,BindingResult result ,Model m) {

		// TODO: validate dữ liệu
		// TODO: Tích hợp Hibernate để thêm dữ liệu vào database
		if (!result.hasErrors()) {
			// Tích hợp Hibernate để thêm dữ liệu vào database
			ImpCustomer cusDAO = new ImpCustomer();
			boolean isOK = cusDAO.insert(cus);
			if (isOK) {
				m.addAttribute("msgOk", "Thêm dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại!");
			}
		}
		return "customer/insert";
	}
	@RequestMapping("/update/{id}")
	public String initUpdate(@PathVariable(name = "id", required = true) int idcus, Model m) {
		// Load dữ liệu nhân viên theo id
		ImpCustomer cusDAO = new ImpCustomer();
		Customer cus = cusDAO.detail(idcus);
		m.addAttribute("cus", cus);

		return "customer/update";
	}
	@RequestMapping("/store")
	public String update(@Valid @ModelAttribute("cus") Customer cus, BindingResult result, Model m) {
		// Đẩy chuyển tiếp dữ liệu tới trang tiếp theo
		m.addAttribute("cus", cus);

		// Validate dữ liệu
		if (!result.hasErrors()) {
			// Tích hợp Hibernate để thêm dữ liệu vào database
			ImpCustomer cusDAO = new ImpCustomer();
			boolean isOK = cusDAO.update(cus);
			if (isOK) {
				m.addAttribute("msgOk", "Cập nhật dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại khi CẬP NHẬT!");
			}
		}

		return "customer/update";
	}

	@RequestMapping(value = "/delete/{idcus}")
	public String delete(@PathVariable(name = "idcus", required = true) int idcus, Model m) {

		ImpCustomer cusDAO = new ImpCustomer();
		boolean isOK = cusDAO.del(idcus);

		if (isOK) {
			m.addAttribute("msgOk", "Xóa dữ liệu thành công");			
			List<Customer> lst = cusDAO.selectAll();
			m.addAttribute("listCus", lst);
		} else {
			m.addAttribute("msgError", "Thất bại khi XÓA!");
		}

		return "customer/list";
	}
	@RequestMapping(value = "/{id}")
	public String selectById(@PathVariable(name = "id", required = false) int id, Model m) {

		ImpCustomer cusDAO = new ImpCustomer();
		Customer cus = cusDAO.detail(id);

		m.addAttribute("cus", cus);

		return "customer/detail";
	}
	@RequestMapping(value = "/init-login")
	public String initLogin(Model m) {
		return "customer/login";
	}
	@RequestMapping(value = "/login")
	public String login(@RequestParam(name = "name", required = true) String name ,@RequestParam(name = "password", required = true) String pass,HttpServletRequest rq,Model m){
		ImpCustomer cusDao = new ImpCustomer();
		try {
			Customer c = cusDao.login(name, pass);
			rq.getSession().setAttribute("cus", c);
			ImpQuestion quesDAO = new ImpQuestion();
			ImpAnswer aDao = new ImpAnswer();
			List<Question> lst = quesDAO.selectAll();
			List<Answer> lstA = aDao.selectAll();
			m.addAttribute("lstQ", lst);
			m.addAttribute("lstA", lstA);
			m.addAttribute("msgOk","Đăng nhập thành công !");
		}catch(Exception e) {
			if(e.getMessage().equals("No entity found for query")) {
				m.addAttribute("msgErr","Sai thông tin đăng nhập !");
			}
		}
		return "customer/login";
	}
	@RequestMapping("/register")
	public String initRegister( Model m) {
		return "customer/register";
	}
	@RequestMapping("/rgt")
	public String register(@Valid @ModelAttribute("cus") Customer cus,BindingResult result ,HttpServletRequest rq,Model m) {

		// TODO: validate dữ liệu
		// TODO: Tích hợp Hibernate để thêm dữ liệu vào database
		if (!result.hasErrors()) {
			// Tích hợp Hibernate để thêm dữ liệu vào database
			ImpCustomer cusDAO = new ImpCustomer();
			boolean isOK = cusDAO.insert(cus);
			if (isOK) {
				m.addAttribute("msgOk", "Thêm dữ liệu thành công");
				rq.getSession().setAttribute("cus", cus);
			} else {
				m.addAttribute("msgError", "Thất bại!");
			}
		}
		return "customer/insert";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest rq){
		rq.getSession().removeAttribute("cus");
		return "customer/login";
	}
	@RequestMapping(value = "/search")
	public String login(@RequestParam(name = "search", required = false) String search ,Model m){
		ImpCustomer cusDao = new ImpCustomer();
		List<Customer> lst = cusDao.search(search);
		m.addAttribute("listCus", lst);

		return "customer/list";
	}
}
