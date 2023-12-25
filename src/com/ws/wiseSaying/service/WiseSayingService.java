package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {

	private WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() { // WiseSayingService 생성자

		wiseSayingRepository = new WiseSayingRepository(); // WiseSayingRepository 객체 생성
	}

	public List<WiseSaying> findAll() { // List<WiseSaying>형의 findAll메서드
		return wiseSayingRepository.findAll(); // wiseSayingRepository의 findAll메서드 실행값 리턴
	}

	public int write(String content, String author) { // content, author를 매개변수로 받는 write메서드

		return wiseSayingRepository.write(content, author); // wiseSayingRepository의 write메서드 실행값 리턴
	}

	public WiseSaying findById(int id) { // id를 매개변수로 하는 findById메소드
		return wiseSayingRepository.findById(id); // wiseSayingRepository의 findById메서드 실행값 리턴
	}

	public void remove(WiseSaying wiseSaying) { // wiseSaying을 매개변수로 받는 remove메서드
		wiseSayingRepository.remove(wiseSaying); // wiseSayingRepository의 remove메서드 실행값 리턴
	}

	public void modify(WiseSaying wiseSaying, String content, String author) { // wiseSaying, content, author을 매개변수로 받는 modify 메서드
		wiseSayingRepository.modify(wiseSaying, content, author); // wiseSayingRepository의 modify메서드 실행값 리턴

	}

}