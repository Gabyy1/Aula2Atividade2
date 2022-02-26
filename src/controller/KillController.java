package controller;

import java.io.IOException;

public class KillController {
  public KillController() {
	 super(); 

	}
  public String os() {
	  String os = System.getProperty("os.name");
	  return os;
  }
   public void KillProcess(String param) {
	   String cmdPid = "TASKILL /PID";
	   String cmdNome = "TASKILL /iM";
	   int pid = 0;
	   StringBuffer buffer = new StringBuffer();
	   
	   try{
		   pid = Integer.parseInt(param);
		   buffer.append(cmdPid );
		   buffer.append(pid);
	   }
	   catch(NumberFormatException e) {
		   buffer.append(cmdNome );
		   buffer.append(param);
	   }
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}	   
   }
}
