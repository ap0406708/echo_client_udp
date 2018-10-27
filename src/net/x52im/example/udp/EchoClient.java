/*
 * Copyright (C) 2016 即时通讯网(52im.net) The MobileIMSDK Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/MobileIMSDK
 *  
 * 即时通讯网(52im.net) - 即时通讯技术社区! PROPRIETARY/CONFIDENTIAL.
 * Use is subject to license terms.
 */
package net.x52im.example.udp;

import net.x52im.example.udp.utils.Log;
import net.x52im.example.udp.utils.UDPUtils;

public class EchoClient
{
	public static void main(String[] args) throws Exception
	{
		// 初始化本地UDP的Socket
		LocalUDPSocketProvider.getInstance().initSocket();
		// 启动本地UDP监听（接收数据用的）
		LocalUDPDataReciever.getInstance().startup();
		
		// 循环发送数据给服务端
		while(true)
		{
			// 要发送的数据
			String toServer = "Hi，我是客户端，我的时间戳"+System.currentTimeMillis();
			//byte[] soServerBytes = toServer.getBytes("UTF-8");
			
			/* test m2m */
			byte[] soServerBytes01 = new byte[11];
			soServerBytes01[0]=(byte) 0xff;
			soServerBytes01[1]=0x00;
			soServerBytes01[2]=0x0b;
			//soServerBytes[3]=(byte) 0x95;
			soServerBytes01[3]=0x01;
			soServerBytes01[4]=0x05;
			soServerBytes01[5]=0x05;
			soServerBytes01[6]=0x00;
			soServerBytes01[7]=0x00;
			soServerBytes01[8]=0x01;
			soServerBytes01[9]=0x00;
			soServerBytes01[10]=(byte) 0xff;
			
			byte[] soServerBytes95 = {(byte) 0xff,0x00,0x26,(byte)0x95,0x05,0x05,0x00,0x00,0x01,0x00,0x20,
					(byte)0xda,0x12,(byte)0xd1,0x7e,0x13,(byte)0x89,0x17,0x04,0x06,0x00,0x01,
					0x07,0x50,0x50,0x22,0x12,0x05,0x04,0x00,0x00,0x00,0x00,
					(byte)0x9a,0x00,0x00,0x1e,(byte) 0xff};
			
			byte[] soServerBytes952 = {(byte) 0xff,0x00,0x26,(byte)0x95,0x05,0x05,0x00,0x00,0x01,0x00,0x20,
					(byte)0xda,0x12,(byte)0xd1,0x7e,0x13,(byte)0x89,0x17,0x04,0x06,0x00,0x01,
					0x07,0x50,0x50,0x22,0x12,0x05,0x04,(byte)0xff,0x07,0x00,0x00,
					(byte)0x9a,0x00,0x00,0x1e,(byte) 0xff};
			
			byte[] soServerBytes953 = {(byte) 0xff,0x00,0x26,(byte)0x95,0x05,0x05,0x00,0x00,0x01,0x00,0x20,
					(byte)0xda,0x12,(byte)0xd1,0x7e,0x13,(byte)0x89,0x17,0x04,0x06,0x00,0x01,
					0x07,0x50,0x50,0x22,0x12,0x05,0x04,(byte)0xff,0x04,0x00,0x00,
					(byte)0x9a,0x00,0x00,0x1e,(byte) 0xff};
			
			byte[] soServerBytes954 = {(byte) 0xff,0x00,0x26,(byte)0x95,0x05,0x05,0x00,0x00,0x01,0x00,0x20,
					(byte)0xda,0x12,(byte)0xd1,0x7e,0x13,(byte)0x89,0x17,0x04,0x06,0x00,0x01,
					0x07,0x50,0x50,0x22,0x12,0x05,0x04,(byte)0xff,0x00,0x00,0x00,
					(byte)0x9a,0x00,0x00,0x1e,(byte) 0xff};
			
			byte[] soServerBytes03 = {(byte)0xf0,0x00,0x1f,0x03,0x05,0x05,0x00,0x00,0x01,0x07,0x50,
				(byte)0x50,0x22,0x12,0x05,0x06,(byte)0xc4,(byte)0xab,0x01,(byte)0xb0,(byte)0x76,
				(byte)0xca,0x00,0x01,0x22,0x05,0x00,0x00,0x00,0x1e,(byte)0xff};
			
			// 开始发送
			boolean ok = UDPUtils.send(soServerBytes01, soServerBytes01.length);
			if(ok)
				Log.d("EchoClient", "发往服务端的信息已送出.");
			else
				Log.e("EchoClient", "发往服务端的信息没有成功发出！！！");
			
			// 60秒后进入下一次循环
			Thread.sleep(60000);
		}
	}

}
