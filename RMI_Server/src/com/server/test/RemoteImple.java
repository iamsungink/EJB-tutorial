package com.server.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.RemoteInterface;

/* 원격 객체(Remote Object)
 *  - 원격인터페이스를 상속받는다.
 *  - java.rmi.server.UnicastRemoteObject 클래스를 상속받는다.
 *  - 기본생성자를 만들고, RemoteException 선언
 *  - 원격인터페이스에 선언된 원격메소드를 구현한다.
 * 
 */
public class RemoteImple extends UnicastRemoteObject implements RemoteInterface {

	protected RemoteImple() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello(String str) throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello!!" + str;
	}

}
