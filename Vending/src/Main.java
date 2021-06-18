import java.util.Timer;
import java.util.TimerTask;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Machine myMachine = new Machine();
        myMachine.start();

        System.out.println("-----------timeout-----------");
        Thread.sleep(6000);

        System.out.println("-----------Get product-----------");
        myMachine.start();
        myMachine.insertCoin(Machine.Coins.SHEKEL);
        myMachine.insertCoin(Machine.Coins.SHNEKEL);
        myMachine.insertCoin(Machine.Coins.SHNEKEL);
        myMachine.getProduct();
        

        System.out.println("-----------Cancel-----------");
        myMachine.start();
        myMachine.insertCoin(Machine.Coins.SHEKEL);
        myMachine.insertCoin(Machine.Coins.SHNEKEL);
        myMachine.insertCoin(Machine.Coins.SHNEKEL);
        myMachine.cancel();

    }
}