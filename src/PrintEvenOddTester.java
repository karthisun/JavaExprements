public class PrintEvenOddTester {

    public static void main(String... args) {
    	PrintNumber print = new PrintNumber(1,10);
    	new EvenThread(print);
    	new OddThread(print);
    }

}


class PrintNumber {
	int n,min,max;
	boolean flag = false;
	
	PrintNumber(int min,int max){
		this.max = min;
		this.max = max;
	}
	synchronized int printEven() {
		if(!flag) {
			try {
				wait();
				System.out.println("Waiting in even thread");
			}catch(InterruptedException e) {
				
			}
		}
		
		if((this.n % 2)==0) {
			if(n>=1) {
				System.out.println("Even :: "+n);
			}
			
			this.n++;
		}
		flag = false;
		notify();
		return n;
	}
	
	synchronized int printOdd() {
		if(flag) {
			try {
				wait();
				System.out.println("Waiting in odd thread");
			}catch(InterruptedException e) {
				
			}
		}
		
		if((this.n % 2) != 0) {
			System.out.println("Odd :: "+n);
			this.n++;
		}
		flag = true;
		notify();
		return n;
	}
	
	
	
}

class EvenThread implements Runnable{
	PrintNumber printer;
	EvenThread(PrintNumber p){
		Thread t = new Thread(this,"Even");
		t.start();
		this.printer = p;
	}
	public void run() {
		while(printer.n <= printer.max) {
			printer.printEven();
		}
	}
}

class OddThread implements Runnable{
	PrintNumber printer;
	OddThread(PrintNumber p){
		Thread t = new Thread(this,"Odd");
		t.start();
		this.printer = p;
	}
	public void run() {
		while(printer.n <= printer.max) {
			printer.printOdd();
		}
	}
}