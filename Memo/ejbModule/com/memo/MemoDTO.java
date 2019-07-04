package com.memo;

import java.io.Serializable;

// 분산환경에서 DTO는 반드시 Serializable을 상속 받아야 한다.
public class MemoDTO implements Serializable{
	
	private String no;
	private String writer;
	private String email;
	private String title;
	private String memo;
	private String wdate;
	
	public MemoDTO() {
	}// 기본생성자

	public MemoDTO(String no, String writer, String email, String title, String memo, String wdate) {
		this.no = no;
		this.writer = writer;
		this.email = email;
		this.title = title;
		this.memo = memo;
		this.wdate = wdate;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	

}
