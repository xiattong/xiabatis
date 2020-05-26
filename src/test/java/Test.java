import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class Test extends Thread{

    private static Object lock= new Object();

    public static void main(String[] args) {
        System.out.println("this is main thread");
        Test test = new Test();
        synchronized (test){
            test.start();

        }

    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("this is child thread");
        }
    }

    public void fun(Test test){

    }

}
