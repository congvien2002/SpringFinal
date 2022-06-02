package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
import org.springframework.web.multipart.MultipartFile;

import DAO.ImpAnswer;
import DAO.ImpQuestion;
import entity.Answer;
import entity.Question;


@Controller
@RequestMapping("/question")
public class QuestionController {

	@RequestMapping(value = { "", "/", "/list" })
	public String getAll(Model m) {
		ImpQuestion quesDAO = new ImpQuestion();
		ImpAnswer aDao = new ImpAnswer();
		List<Question> lst = quesDAO.selectAll();
		List<Answer> lstA = aDao.selectAll();
		m.addAttribute("lstQ", lst);
		m.addAttribute("lstA", lstA);
		return "question/list";
	}
	@RequestMapping("/init-insert")
	public String initInsert(Model m) {

		Question ques = new Question();
		m.addAttribute("ques", ques);

		return "question/insert";
	}

	@RequestMapping("/insert")
	public String insert(@Valid @ModelAttribute("ques") Question ques,BindingResult result,@RequestParam(name="fileUpload") MultipartFile mf , HttpServletRequest rq ,Model m) {

		// TODO: validate dữ liệu
		// TODO: Tích hợp Hibernate để thêm dữ liệu vào database
		if (!result.hasErrors()) {
			String prjPath = rq.getServletContext().getRealPath("/");
			File parentFile = new File(prjPath);
			String parentPath = parentFile.getParentFile().getPath();

			// String realPath = request.getServletContext().getRealPath("/public");
			String realPath = parentPath + File.separator + "/Public"; // Gốc localhost
			System.out.println("Realpath: " + realPath);
			String filename = mf.getOriginalFilename();
			System.out.println("Filename: " + filename);
			if (!filename.isEmpty()) {
				try {
					File fileDestination = new File(realPath + File.separator + filename);
					byte dataImg[] = mf.getBytes();
					Files.write(fileDestination.toPath(), dataImg, StandardOpenOption.CREATE);

					// Cập nhật thông tin ảnh đại diện cho đối tượng
					ques.setImg(filename);
				} catch (IOException e) {
					System.out.println("Lỗi ghi file ảnh");
					e.printStackTrace();
				}
			}
			// Tích hợp Hibernate để thêm dữ liệu vào database
			ImpQuestion quesDAO = new ImpQuestion();
			boolean isOK = quesDAO.insert(ques);
			if (isOK) {
				m.addAttribute("msgOk", "Thêm dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại!");
			}
			m.addAttribute("ques",ques);
		}
		return "question/insert";
	}
	@RequestMapping("/update/{id}")
	public String initUpdate(@PathVariable(name = "id", required = true) int idques, Model m) {
		// Load dữ liệu nhân viên theo id
		ImpQuestion quesDAO = new ImpQuestion();
		Question ques = quesDAO.detail(idques);
		m.addAttribute("ques", ques);
		
		return "question/update";
	}
	@RequestMapping("/store")
	public String update(@Valid @ModelAttribute("ques") Question ques, BindingResult result,@RequestParam(name = "fileUpload") MultipartFile mf , HttpServletRequest rq , Model m) {
		// Đẩy chuyển tiếp dữ liệu tới trang tiếp theo

		// Validate dữ liệu
		if (!result.hasErrors()) {
			// Xử lý upload file
			String prjPath = rq.getServletContext().getRealPath("/");
			File parentFile = new File(prjPath);
			String parentPath = parentFile.getParentFile().getPath();
			String realPath = parentPath + File.separator + "/Public"; // Gốc localhost
			System.out.println("Realpath: " + realPath);
			String filename = mf.getOriginalFilename();
			System.out.println("Filename: " + filename);
			if (!filename.isEmpty()) {
				try {
					File fileDestination = new File(realPath + File.separator + filename);
					byte dataImg[] = mf.getBytes();
					Files.write(fileDestination.toPath(), dataImg, StandardOpenOption.CREATE);

					// Cập nhật thông tin ảnh đại diện cho đối tượng
					ques.setImg(filename);
				} catch (IOException e) {
					System.out.println("Lỗi ghi file ảnh");
					e.printStackTrace();
				}
			}
			ImpQuestion quesDAO = new ImpQuestion();
			boolean isOK = quesDAO.update(ques);
			if (isOK) {
				m.addAttribute("msgOk", "Cập nhật dữ liệu thành công");
			} else {
				m.addAttribute("msgError", "Thất bại khi CẬP NHẬT!");
			}
		}
		m.addAttribute("ques", ques);
		return "question/update";
	}

	@RequestMapping(value = "/delete/{idques}")
	public String delete(@PathVariable(name = "idques", required = true) int idques, Model m) {

		ImpQuestion quesDAO = new ImpQuestion();
		boolean isOK = quesDAO.del(idques);

		if (isOK) {
			m.addAttribute("msgOk", "Xóa dữ liệu thành công");			
			List<Question> lst = quesDAO.selectAll();
			m.addAttribute("listQ", lst);
		} else {
			m.addAttribute("msgError", "Thất bại khi XÓA!");
		}

		return "question/list";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable(name = "id", required = true) int idques, Model m) {

		ImpQuestion quesDAO = new ImpQuestion();
		Question ques = quesDAO.detail(idques);
		ImpAnswer aDao = new ImpAnswer();
		List<Answer> lstA = aDao.selectAll();
		m.addAttribute("ques", ques);
		m.addAttribute("lstA", lstA);
		return "question/detail";
	}
}
