package com.king.appboard.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length; //  String type 에만 작성가능 
import org.hibernate.validator.constraints.NotEmpty;  //  String type 에만 작성가능 

// DTO 와 같음   sql column 과 같은 이름 으로 설정 
@Alias("boardVO")
public class BoardVO {
	
	private int seq;
	@Length(min = 2, message = "제목은 2자 이상 입력하십시오")
	private String title;
	
	@NotEmpty(message = "내용을 입력하십시오")
	private String content;
	
	@NotEmpty(message = "작성자를 입력하십시오")
	private String writer;
	private int password;
	private Timestamp regDate;
	private int cnt;
	
	//Default Constructor
	public BoardVO() { }

	// Using field(매개변수) Constructor
	public BoardVO( String title, String content, String writer, int password ) {
		super();

		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.cnt = 0;  // 0으로 초기화 할 것이므로 매개변수로 받지 않음 
		
		/* seq 와 regDate 도 자동으로 입력되는 것이므로 매개변수로 값을 전달 받지 않음 */
	}
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
	

}
