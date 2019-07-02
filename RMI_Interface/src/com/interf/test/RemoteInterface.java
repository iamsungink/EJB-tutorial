package com.interf.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* RMI 프로그래밍을 구성 요소
 * Interface(원격인터페이스)
 * 
 * Server - 원격객체, 서버
 * 
 * 
 * client - 클라이언트
 * 
 * 
 */

/*
 * 원격 이터페이스(Remote Interface) 만들기.
 *  - java.rmi.Remote 인터페이스를 상속 받는다.
 *  - 원격 인터페이스는 public으로 선언한다.
 *  - 이 인터페이스 안에 원격 메소드를 선언한다.
 *  - 원격 메소드는 RemoteException이 선언되야 한다.
 *  
 *  ** 원격 인텊페이스 안에는 추상메소드가 선언되지 않는다.
 *  * 추상메소드가 아닌 비즈니스 메소드가 선언된다.
 *  
 */
public interface RemoteInterface extends Remote{
	//원격메소드
	public String sayHello(String str) throws RemoteException;

}
