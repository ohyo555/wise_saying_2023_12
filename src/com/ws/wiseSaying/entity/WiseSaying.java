package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id;
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) { // id, content, author을 받는 WiseSaying
		this.id = id; // 입력받은 id 넣어줌
		this.content = content; // 입력받은 content 넣어줌
		this.author = author; // 입력받은 author 넣어줌
	}

	public int getId() { // App에서 id 접근할 수 있게 getId 메서드 생성
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}