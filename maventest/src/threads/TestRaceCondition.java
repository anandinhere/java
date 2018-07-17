package threads;

public class TestRaceCondition extends Thread {
	private int instanceVariable = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			TestRaceCondition test = new TestRaceCondition();
			test.start();
		}
	}

	@Override
	public synchronized void start() {
		increment();
		System.out.println(this.instanceVariable);
	}

	public void increment() {
		instanceVariable++;
	}

}
