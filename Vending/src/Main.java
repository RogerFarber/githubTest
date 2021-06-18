
public class Main {

    public static void main(String[] args) {
        Machine myMachine = new Machine();

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