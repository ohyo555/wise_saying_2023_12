package com.ws;

import java.util.Scanner;

public class Container {
	private static Scanner sc;

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in); // Scanner 객체 생성
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close(); // Scanner 끝내기
	}

	public static Scanner getScanner() {
		return sc; // sc값 리턴
	}
}