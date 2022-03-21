public class Test {
	public static void main(String[] args) {
		
		System.out.println("主线程ID:" + Thread.currentThread().getId());

		MyThread thread1 = new MyThread("thread1");
		thread1.start(); // 启动线程 创建并执行run

//        MyThread thread2 = new MyThread("thread2");
//        thread2.run();   //不创建新的线程

	}
}

class MyThread extends Thread {

	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
		System.out
				.println("我是一个线程，线程id为" + Thread.currentThread().getId() + "，我创建了\n2019124049\n2019124049\n2019124049");
		// 子线程执行完毕，线程自动终止
		System.out.println(Thread.currentThread().getId() + "，线程终止退出");
	}

}
