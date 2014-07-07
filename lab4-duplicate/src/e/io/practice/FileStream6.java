package e.io.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream6 {
	
	public static void main (String[] args) throws IOException {
		
		DataOutputStream dos = new DataOutputStream (new FileOutputStream ("dosTest1.txt"));
		dos.writeInt(100);
		dos.writeBoolean(true);
		dos.writeChar('A');
		dos.writeFloat(3.14f);
		dos.close();
		
		DataInputStream dis = new DataInputStream (new FileInputStream ("dosTest1.txt"));
		
		int i = dis.readInt();
		boolean j = dis.readBoolean();
		char c = dis.readChar();
		float f = dis.readFloat();
		dis.close();
		
		System.out.println (i + " " + j + " " + c + " " + f);
		
		
	}

}
