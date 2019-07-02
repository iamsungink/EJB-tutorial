package com.client.test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.interf.test.Constant;
import com.interf.test.RemoteInterface;

// 클라이언트는 네이밍서버에(rmiRegistry) 등록된 원격메소드를 호출한다.

public class RMIClient {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", Constant.RMI_PORT);
		RemoteInterface remoteObj = (RemoteInterface) registry.lookup(Constant.RMI_ID);
		
		String str = remoteObj.sayHello("RMI");
		System.out.println("str >> " + str);
	}

}
