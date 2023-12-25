package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();
	}

	public void write() {
		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author);

		System.out.printf("%d번 명언이 등록되었습니다.\n", id);
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		System.out.println("번호  /  작가  /  명언  ");
		System.out.println("=".repeat(30));

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { // 배열에서 내림차순으로 출력하기 위해 반복문 실행
			WiseSaying ws = wiseSayings.get(i); // wiseSayings 배열에 저장된 id, content, author 가져와서 ws 변수에 저장

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) { // rq값을 받는 remove 메서드
		int id = rq.getIntParam("id", -1); // rq의 getIntParam 메서드를 실행하여 반환값은 값을 id로 지정

		if (id == -1) { // id가 -1이면 아래 코드 실행
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}

		WiseSaying wiseSaying = wiseSayingService.findById(id); // findByid메서드를 실행하여 반환받은 값을 wiseSaying에 넣어줘

		if (wiseSaying == null) { // wiseSaying값이 null이면 아래의 출력문 출력
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}
		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying); // wiseSaying값이 null이 아니면 wiseSayings 배열에서 해당 값 제거하고

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id); // 삭제 문구 출력

	}

	public void modify(Rq rq) { // rq값을 modify 메서드
		int id = rq.getIntParam("id", -1); // rq의 getIntParam 메서드를 실행하여 반환값은 값을 id로 지정

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null)

		{
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}
		// wiseSaying 값이 null이 아닌경우
		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent()); // wiseSaying의 getcontent메소드를 실행하여 content값 가져옴
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim(); // Container의 getScanner를 통해 입력받은 값을 content로 지정
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);
	}

}