import java.util.*;

public class CircuitsConstruction {
    String circuit;
    int L;
    int at;
   public int maximizeResistance(String circuit, int[] conductors) {
       this.circuit = circuit;
       L = circuit.length();
       at = 0;
       
       //1. USING DFS
       // int getReq = doit();
       
       //2. USING STACK
       Stack<Integer> st = new Stack<>();
       for(int i = circuit.length() - 1; i >= 0; i--){
           char c = circuit.charAt(i);
           
           if(c == 'X') st.add(1);
           else{
               int a = st.pop();
               int b = st.pop();
               if(c == 'A') st.add(a + b);
               else st.add(Math.max(a, b));
           }
       }
       
       int getReq = st.peek();
       
       Arrays.sort(conductors);
       reverse(conductors);
       
       int answer = 0;
       for(int i = 0; i < getReq; i++) answer += conductors[i];
       
       return answer;
   }

   
   
   
   
   
   
   
   private int doit(){
       if(circuit.charAt(at) == 'X'){
           at++;
           return 1;
       }
       
       if(circuit.charAt(at) == 'A'){
           at++;
           return doit() + doit();
       }
       
       if(circuit.charAt(at) == 'B'){
           at++;
           return Math.max(doit(), doit());
       }
       throw new RuntimeException();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   private void reverse(int[] a){
       int i = 0, j = a.length -1;
       while(i < j){
           int t = a[i];
           a[i] = a[j];
           a[j] = t;
           i++; j--;
       }
   }














// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			CircuitsConstructionHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CircuitsConstructionHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class CircuitsConstructionHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			String circuit            = "BXBXX";
			int[] conductors          = {8, 2, 3};
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}
		case 1: {
			String circuit            = "AAXXAXAXX";
			int[] conductors          = {1, 1, 2, 8, 10};
			int expected__            = 22;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}
		case 2: {
			String circuit            = "AXBXX";
			int[] conductors          = {8, 2, 3};
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}
		case 3: {
			String circuit            = "BAAXBXXBXAXXBBAXXBXXAAXXX";
			int[] conductors          = {17, 7, 21, 102, 56, 72, 88, 15, 9, 192, 16, 8, 30};
			int expected__            = 454;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}

		// custom cases

/*      case 4: {
			String circuit            = ;
			int[] conductors          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}*/
/*      case 5: {
			String circuit            = ;
			int[] conductors          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}*/
/*      case 6: {
			String circuit            = ;
			int[] conductors          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CircuitsConstruction().maximizeResistance(circuit, conductors));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
