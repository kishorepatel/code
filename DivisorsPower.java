import java.util.*;

public class DivisorsPower {
   public long findArgument(long n) {
      
       long answer = Long.MAX_VALUE;
       
	for(int i = 62; i > 1; i--){
            long x = getRoot(i, n);
            if(x != -1 && divisors(x) == i){
                answer = Math.min(answer, x);
            }
        }
       
        if(answer > n) return -1;
        else return answer;
   }
   
   
   private long getRoot(int p, long n){
       long sr = (long)Math.pow(n, 1./p);
       
       for(long ret = sr-2; ret <= sr + 2; ret++){
           if(ret > 0)
                if(pow(ret, p, n) == n)
                    return ret;
       }
       
       return -1;
   }
   
   
   private long pow(long n, int p, long N){
       long res = 1;
       for(int i = 1; i <= p; i++){
           if(res > N / n) return N+1;
           res *= n;
       }
       
       return res;
   }
   
   private int divisors(long n){
       int cnt = 0;
       int p = 1;
       while(p <= n / p){
           if(n % p == 0){
               cnt++;
               if(n/p != p) cnt++;
           }
           p += 1;
       }
       
       return cnt;
   }















// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			DivisorsPowerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DivisorsPowerHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class DivisorsPowerHarness {
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
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
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
			long n                    = 4;
			long expected__           = 2;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}
		case 1: {
			long n                    = 10;
			long expected__           = -1;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}
		case 2: {
			long n                    = 64;
			long expected__           = 4;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}
		case 3: {
			long n                    = 10000;
			long expected__           = 10;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}
		case 4: {
			long n                    = 2498388559757689L;
			long expected__           = 49983883;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}

		// custom cases

/*      case 5: {
			long n                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}*/
/*      case 6: {
			long n                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}*/
/*      case 7: {
			long n                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new DivisorsPower().findArgument(n));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
