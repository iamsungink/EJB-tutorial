package com.server.test;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.interf.test.Constant;

// 서버
// 원격 객체를 네이밍서버(rmiregistry)에 등록
/*
 * RMI Registry : 원격객체를 관리하고 서비스하는 원격객체 컨테이너(Container)
 * 
 * 바인딩 : 원격객체를 등록하는 과정(Binding)
 * 원격객체 등록방법 : 원격객체를 식별할 수 있는 식별자(Name)와 함께 등록해야 한다.
 */

public class RemoteServer {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
		
		//원격객체를 생성
		RemoteImple imple = new RemoteImple();
		
		//네이밍 서버에 원격 객체를 등록
		Registry registry= LocateRegistry.createRegistry(Constant.RMI_PORT);
		
		//Naming 클래스의 bind() 또는 rebind()메소드를 이용해서 등록할 수 있다.
		// 1) bind() : 등록되어 있는 이름이 존재하면 AlreadyBoundException을 발생시킨다.
		// 2) rebind() : 동일한 이름이 있더라도 예외를 발생시키지 않고 덮어쓰기를 한다.
		
		// 네이밍 서버에 프로토콜을 등록할 때(RMI URL 형식 : rmi://host:port/객체이름)
		// Naming.rebind("rmi://localhost:1099/im,imple);
		// Naming.rebind("im",imple);
		
		registry.bind(Constant.RMI_ID, imple);
		
		System.out.println("[RemoteSever START]!!!");
	}

}
