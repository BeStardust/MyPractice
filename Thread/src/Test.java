public class Test {
	public static void main(String[] args) {
		
		System.out.println("���߳�ID:" + Thread.currentThread().getId());

		MyThread thread1 = new MyThread("thread1");
		thread1.start(); // �����߳� ������ִ��run

//        MyThread thread2 = new MyThread("thread2");
//        thread2.run();   //�������µ��߳�

	}
}

class MyThread extends Thread {

	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// System.out.println("name:"+name+" ���߳�ID:"+Thread.currentThread().getId());
		System.out
				.println("����һ���̣߳��߳�idΪ" + Thread.currentThread().getId() + "���Ҵ�����\n2019124049\n2019124049\n2019124049");
		// ���߳�ִ����ϣ��߳��Զ���ֹ
		System.out.println(Thread.currentThread().getId() + "���߳���ֹ�˳�");
	}

}
