import java.io.*;
import java.util.*;
import java.net.*;

class server
{
     public static void main(String[] args)throws IOException
     {
          DatagramSocket ds = new DatagramSocket(9864);
          byte[] b1 = new byte[1024];
          byte[] b2 = new byte[1024];
          DatagramPacket dpr = new DatagramPacket(b1,b1.length);
          ds.receive(dpr);
          String str = new String(dpr.getData());
          String str1 = str.toUpperCase();
          System.out.println("Message received:"+ str);

          b2 = str1.getBytes();
          InetAddress ip = dpr.getAddress();
          int port = dpr.getPort();
          DatagramPacket dps = new DatagramPacket(b2,b2.length,ip,port);
          ds.send(dps);
     }
}