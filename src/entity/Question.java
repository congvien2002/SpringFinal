package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblQuestion")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Nội dung không được để trống !")
	@Column(name = "description")
	private String description;
	@Column(name = "img")
	private String img;
	@Column(name = "total")
	private int total;
	@OneToMany(mappedBy = "ques")
	private List<Answer> lstA;
	
	@OneToMany(mappedBy = "rques")
	private List<Result> lstR;
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public Question(int id, @NotEmpty(message = "Nội dung không được để trống !") String description, String img,
			int total, List<Answer> lstA, List<Result> lstR) {
		super();
		this.id = id;
		this.description = description;
		this.img = img;
		this.total = total;
		this.lstA = lstA;
		this.lstR = lstR;
	}
	public Question(@NotEmpty(message = "Nội dung không được để trống !") String description, String img, int total,
			List<Answer> lstA, List<Result> lstR) {
		super();
		this.description = description;
		this.img = img;
		this.total = total;
		this.lstA = lstA;
		this.lstR = lstR;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Answer> getLstA() {
		return lstA;
	}
	public void setLstA(List<Answer> lstA) {
		this.lstA = lstA;
	}
	public List<Result> getLstR() {
		return lstR;
	}
	public void setLstR(List<Result> lstR) {
		this.lstR = lstR;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", img=" + img + ", total=" + total + ", lstA="
				+ lstA + ", lstR=" + lstR + "]";
	}

	
	
	
}
