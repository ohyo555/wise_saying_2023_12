package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	private int lastWiseSayingId;
	private List<WiseSaying> wiseSayings;

	public WiseSayingRepository() {

		lastWiseSayingId = 0;
		wiseSayings = new ArrayList<>();  // ArrayList 형태의 wiseSayings 생성
	}

	public void remove(WiseSaying wiseSaying) { // wiseSaying을 매개변수로 받는 remove메서드
		wiseSayings.remove(wiseSaying); // wiseSayings 배열에 wiseSaying 제거
	}

	public WiseSaying findById(int id) { // id를 매개변수로 하는 findById메소드
		for (WiseSaying wiseSaying : wiseSayings) { // wiseSayings 배열 반복
			if (wiseSaying.getId() == id) { // wiseSaying의 getId메서드를 실행한 값과 id값이 같은 경우
				return wiseSaying; // wiseSayings값 리턴
			}
		}

		return null; // 배열에 해당하는 id가 없는 경우 null값 리턴
	}

	public void modify(WiseSaying wiseSaying, String content, String author) { // wiseSaying, content, author을 매개변수로 받는 modify 메서드
		wiseSaying.setContent(content); // wiseSaying의 setContent 메서드를 실행하여 인자로 받은 content값으로 content 수정
		wiseSaying.setAuthor(author); // wiseSaying의 setContent 메서드를 실행하여 인자로 받은 content값으로 content 수정
	}

	public int write(String content, String author) { // content, author를 매개변수로 받는 write메서드
		int id = lastWiseSayingId + 1;

		WiseSaying wiseSaying = new WiseSaying(id, content, author); // id, content, author를 받는 WiseSaying 객체를 만들어서
																	 // wiseSaying 변수에 저장
		wiseSayings.add(wiseSaying); // wiseSayings 배열에 wiseSaying 추가

		lastWiseSayingId = id; // 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id; // id값 반환
	}

	public List<WiseSaying> findAll() { // List<WiseSaying>형의 findAll메서드
		return wiseSayings; // wiseSayings값 리턴
	}

}