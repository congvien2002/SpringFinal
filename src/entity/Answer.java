package entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tblAnswer")
public class Answer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "Nội dung không được để trống !")
	@Column(name = "description")
	private String description;
	@Column(name = "count")
	private int count;
	
	@ManyToOne
	@JoinColumn(name = "quesID",referencedColumnName = "id")
	private Question ques;
	@OneToMany(mappedBy = "ans",fetch = FetchType.EAGER)
	private List<Result> lstR;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, @NotEmpty(message = "Nội dung không được để trống !") String description, int count,
			Question ques) {
		super();
		this.id = id;
		this.description = description;
		this.count = count;
		this.ques = ques;
	}

	public Answer(@NotEmpty(message = "Nội dung không được để trống !") String description, int count, Question ques) {
		super();
		this.description = description;
		this.count = count;
		this.ques = ques;
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

	public int getcount() {
		return count;
	}

	public void setcount(int count) {
		this.count = count;
	}

	public Question getQues() {
		return ques;
	}

	public void setQues(Question ques) {
		this.ques = ques;
	}

	
	
}
