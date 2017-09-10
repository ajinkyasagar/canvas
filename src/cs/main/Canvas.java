package cs.main;

import java.util.function.Consumer;

public class Canvas  {
	char[][] canvasArray;
	int w, h;
	 Consumer<Character> charprint=	 System.out::print;
	Consumer<String> text=	System.out::println;
	public Canvas(int w, int h) {
		h+=2;
		w+=2;
		this.w = w;
		this.h = h;
		canvasArray = new char[h][w];		
		drawLine.draw(0, 0, this.w-1, 0, '-');
		drawLine.draw(0, this.h-1, this.w-1, this.h-1, '-');
		drawLine.draw(0, 1, 0, this.h-2, '|');
		drawLine.draw(this.w-1, 1, this.w-1, this.h-2, '|');		
	}
	
	public void render() {		
		for(int i=0;i<this.h;i++) {
			for(int j=0;j<this.w;j++) {				 
				charprint.accept(canvasArray[i][j]);
			}
			text.accept("");
		}
	}
	
	public Draw drawLine= (x1,y1,x2,y2,mchar)->{for(int i=y1; i<=y2; i++) {
		for(int j=x1; j<=x2; j++) {
			canvasArray[i][j] = mchar;				
		}
	}	
	};
	

	
	public void drawRectangle(int x1, int y1, int x2, int y2, char mchar) {
		drawLine.draw(x1,y1, x2, y1, mchar);
		drawLine.draw(x1,y1, x1, y2, mchar);
		drawLine.draw(x2,y1, x2, y2, mchar);
		drawLine.draw(x1,y2, x2, y2, mchar);
	}
	
	public void bucketFill(int x, int y, char mchar) throws InterruptedException {
		if((int)canvasArray[y][x] != 0) {
			return;
		}
		
		if(x > 0 || x < this.h || y > 0 || y  < this.w) {
			if((int)canvasArray[y][x] == 0)
				canvasArray[y][x] = mchar;
			bucketFill(x+1,y, mchar);
			bucketFill(x-1,y, mchar);
			bucketFill(x,y-1, mchar);
			bucketFill(x,y+1, mchar);			
		}
	}

	
}
