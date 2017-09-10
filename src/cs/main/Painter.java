package cs.main;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class is responsible to run main method and will use command line pattern to take decisions
 * @author Sagar Shivaji Thakare
 *
 */

public class Painter {	
	public  Canvas canvas;
	public static  Consumer<String> text=	 System.out::println;
	public static Consumer<String> error=	System.err::println;
	public static void main(String[] args) throws NumberFormatException, InterruptedException {	
	
		Painter painter = new Painter();
		Scanner scan = new Scanner(System.in);
		String command = new String();
		while(!command.equals("Q")) {
			text.accept("enter command:");
			command = scan.nextLine();
			if(!command.equalsIgnoreCase(""))
			{
				
				painter.draw(command,text,error);
			}
		}
		text.accept("Program Terminated");
		scan.close();
	}
	
	/**
	 * This method will folow comand line pattern to judge expected output and render respective shape
	 * @param command
	 * @param text
	 * @param error
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	private  void draw(String command, Consumer<String> text,Consumer<String> error) throws NumberFormatException, InterruptedException {
		
		char ch = command.charAt(0);
		
		String[] cmd;
		try {
			switch(ch) {
				case 'C' :
					cmd = command.split(" ");
					canvas = new Canvas(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]));
					canvas.render();
				break;
				case 'L' :
					cmd = command.split(" ");
					if(canvas == null){
				
						error.accept("Draw a canvas first");
						return;
					}
					canvas.drawLine.draw(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
					canvas.render();
				break;
				case 'R' :
					cmd = command.split(" ");
					if(canvas == null){
						error.accept("Draw a canvas first");
						return;
					}
					canvas.drawRectangle(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]),Integer.parseInt(cmd[4]),'X');
					canvas.render();
				break;
				case 'B' :
					cmd = command.split(" ");
					if(canvas == null){
						error.accept("Draw a canvas first");
						return;
					}
					canvas.bucketFill(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2]),cmd[3].charAt(0));
					canvas.render();
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			text.accept("Invalid command. \n");
			
		} catch (Exception e) {
			text.accept("Error Occured\n");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
