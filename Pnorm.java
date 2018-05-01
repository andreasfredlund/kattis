import java.util.Scanner;
				
				
	public class Pnorm {
				
		private static double calcPnorm(double x1, double y1, double x2, double y2, double p) {
	
			if (p == 1) {
				return Math.abs(x1-x2) + Math.abs(y1-y2);
			}
			else {
				return Math.pow(Math.pow(Math.abs(x1-x2),p) +  Math.pow(Math.abs(y1-y2),p) , 1/p);
			}
		}
				
		public static void main(String[] args) {
						
			Scanner scan = new Scanner(System.in);
			
			 double x1 = 0;
			 double y1 = 0;
			 double x2 = 0;
			 double y2 = 0;
			 double p = 0;
			 
			 String end = "0"; 
			 
			 while (!scan.hasNext(end)) {
			 
				 x1 = scan.nextDouble();
				 y1 = scan.nextDouble();
				 x2 = scan.nextDouble();
				 y2 = scan.nextDouble();
				 p = scan.nextDouble();
				 
				 double output = calcPnorm(x1, y1, x2, y2, p);
				 System.out.printf("%.10f\n", output );
			 }
			scan.close();
		}
	}
