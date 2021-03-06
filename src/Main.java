import com.awesome.moli.Moli;
import com.awesome.moli.TestSuite;
import com.awesome.moli.TestSuites;

public class Main {
	public static void main(String[] args) {
		
		Moli.describe("Testcases 1", new TestSuites() {
			public void run() {
				it("testcase 1", new TestSuite() {
					public void run() {
						expect("aa").toBe("b");
						expect("aa").toBe("a");
					}
				});
				
				it("testcase 2", new TestSuite() {
					public void run() {
						expect("aa").toBe("aa");
					}
				});
				
				it("testcase 3", new TestSuite() {
					public void run() {
						expect(1).toBe(1);
					}
				});
				
				it("testcase 4", new TestSuite() {
					public void run() {
						expect(null).toBe(null);
					}
					
				});
			}
		});
		
		Moli.describe("Testcases 2", new TestSuites() {
			public void run() {
				it("testcase 1", new TestSuite() {
					public void run() {
						expect("aa").toBe("b");
						expect("aa").toBe("a");
					}
				});
				
				it("testcase 2", new TestSuite() {
					public void run() {
						expect("aa").toBe("aa");
					}
				});
				
				it("testcase 3", new TestSuite() {
					public void run() {
						expect(1).toBe(1);
					}
				});
				
				it("testcase 4", new TestSuite() {
					public void run() {
						expect(null).toBe(null);
					}
					
				});
			}
		});
	}
}
