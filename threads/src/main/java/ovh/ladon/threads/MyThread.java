package ovh.ladon.threads;

public class MyThread extends Thread {

	private String parameter;

	public MyThread(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public void run() {
		while (!"exit".equals(parameter)) {
			System.out.println(isDaemon() ? "daemon" : " user" + " thread " + this.getName() + "(id=" + this.getId());
		}
	}
}
