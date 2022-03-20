import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class PID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        while(true) {
            try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

}
