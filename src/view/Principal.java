package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {
	 public static void main (String []args) {
		 KillController Kill = new KillController();

		 
        int option = 0;
		 do { 
			 option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Mostrar Processos\n" +
		                                                                 "2 - Matar Processo\n"+
		                                                                 "3 - Sair"));
					 
         	switch(option) {
         	case 1: 
         		 String process = "TASKLIST /FO TABLE";
        		 Kill.readProcess(process);
        		 break;
            
         	case 2: 
         		String param = "notepad.exe";
				Kill.KillProcess(param);
        		break;
        		
         	case 3:
         		JOptionPane.showInputDialog(null,"Encerrado");
         		break;
         		
   }
         	} while (option != 3);
        	
		 }
	 }

		 
		// String os = Kill.os();
		// System.out.println(os);
		 
		
		 
		
	 
	



