package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;

	public App() { // App 생성자 -> 왜 필요하지
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		SystemController systemController = new SystemController(); // SystemController 객체 만들어서 systemController 변수에 넣어줘
		WiseSayingController wiseSayingController = new WiseSayingController(); // WiseSayingController 객체 만들어서
																				// wiseSayingController 변수에 넣어줘

		while (system_status == 1) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim(); // 문자열 입력받는 cmd 변수, 양끝의 빈값은 무시

			Rq rq = new Rq(cmd); // cmd를 매개변수로 한 Rq 객체를 만들어서 rq 변수에 넣음

			switch (rq.getActionCode()) { // rq의 getActionCode메서드 실행
			case "종료": // 그 값이 종료일때
				systemController.exit();
				system_status = 0;
				break;
			case "등록": // 그 값이 등록일때
				wiseSayingController.write();
				break;
			case "목록": // 그 값이 목록일때
				wiseSayingController.list();
				break;
			case "삭제": // 그 값이 삭제일때
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			default: // 그 외
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}

}
