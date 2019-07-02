package com.interf.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* RMI ���α׷����� ���� ���
 * Interface(�����������̽�)
 * 
 * Server - ���ݰ�ü, ����
 * 
 * 
 * client - Ŭ���̾�Ʈ
 * 
 * 
 */

/*
 * ���� �������̽�(Remote Interface) �����.
 *  - java.rmi.Remote �������̽��� ��� �޴´�.
 *  - ���� �������̽��� public���� �����Ѵ�.
 *  - �� �������̽� �ȿ� ���� �޼ҵ带 �����Ѵ�.
 *  - ���� �޼ҵ�� RemoteException�� ����Ǿ� �Ѵ�.
 *  
 *  ** ���� �ζ����̽� �ȿ��� �߻�޼ҵ尡 ������� �ʴ´�.
 *  * �߻�޼ҵ尡 �ƴ� ����Ͻ� �޼ҵ尡 ����ȴ�.
 *  
 */
public interface RemoteInterface extends Remote{
	//���ݸ޼ҵ�
	public String sayHello(String str) throws RemoteException;

}
