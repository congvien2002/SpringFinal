package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tblResult")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "quesID",referencedColumnName = "id")
	private Question rques;
	
	@ManyToOne
	@JoinColumn(name = "ansID",referencedColumnName = "id")
	private Answer ans;
	
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	

	public Result(Question rques, Answer ans) {
		super();
		this.rques = rques;
		this.ans = ans;
	}



	public Result(int id, Question rques, Answer ans) {
		super();
		this.id = id;
		this.rques = rques;
		this.ans = ans;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQues() {
		return rques;
	}

	public void setQues(Question ques) {
		this.rques = ques;
	}

	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}

	
	
}
