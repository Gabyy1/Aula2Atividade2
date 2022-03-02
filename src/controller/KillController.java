package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
  public KillController() {
	 super(); 

	}
  public String os() {
	  String os = System.getProperty("os.name");
	  return os;

  }
  
   public void initProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String erro = e.getMessage();
			if (erro.contains("2")) {
				System.err.println("Aplicação não encontrada");
			}
			if (erro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);

				String cmdCred = buffer.toString();

				try {
					Runtime.getRuntime().exec(cmdCred);
				} catch (Exception e1) {
					System.err.println("Chamada de aplicação inválida");
				}
			}
		}
	}
  
  public void readProcess(String process) {
	  	try {
	  		Process p = Runtime.getRuntime().exec(process);
	  		InputStream fluxo = p.getInputStream();
	  		InputStreamReader leitor = new InputStreamReader(fluxo);
	  		BufferedReader buffer = new BufferedReader(leitor);
	  		String linha = buffer.readLine();
	  		while (linha != null) {
	  			System.out.println(linha);
	  			linha = buffer.readLine();
	  		}
	  		buffer.close();
	  		leitor.close();
	  		fluxo.close();
	  	} catch (IOException e) {
	  		System.err.println("Chamada inválida");
	  		//e.printStackTrace();
	  	}
	  	}
 
  public void KillProcess(String param) {
    	
    	 String os = System.getProperty("os.name");
		 String cmdPid = "";
		 String cmdNome = "";
		 if (os.contains("Windows")) {
			// cmdNome = "TASKKILL /IM";
			 cmdPid = "TASKKILL /PID" + param;
			 cmdNome = "TASKKILL /IM " + param; 
			 
		 }
		 if (os.contains("Linux")) {
			 cmdNome = "kill -9";
			 cmdPid = "pkill -f";
			 
		 }
		   int pid = 0;
		   
		   StringBuffer buffer = new StringBuffer();
		   try{
			  // pid = Integer.parseInt(param);
			  // buffer.append(cmdPid );
			 //  buffer.append(pid);
			  buffer.append(cmdNome);
			
		   }
		   catch(NumberFormatException e) {
			  // System.out.println("Erro de formatacao: "+ e.getMessage());
			   pid = Integer.parseInt(param);
			   buffer.append(cmdPid );
			   buffer.append(param);
		   }
		   
		   initProcess(buffer.toString());
  } 
   
      }
		
	
      
  
 
  
  
    

