

public class Machine {
    static private States currentState = States.INIT;
    static private Events currentEvent = Events.START;
    static private int countTime = 0;
    static private int countMoney = 0;
    static final int price = 5; /*test should check many values*/
    static private final int timeout = 5;

    // enum for Events
    private enum Events {
        START,
        INSERT_COIN,
        NOT_ENOUGH_MONEY,
        ENOUGH_MONEY,
        CANCEL,
        TIME_OUT;
    }

    // enum for coins
    public enum Coins {
        SHEKEL(1),
        SHNEKEL(2),
        FIVE(5),
        TEN(10);

        private int sum;
        //constructor
        Coins(int sum) {
            this.sum = sum;
        }

        public int getSum() {
            return this.sum;
        }
    }

    // State Enums
    private enum States implements Print{
        INIT("INIT - Press START") {
            @Override
            public States getNextState(Events currentEvent) {
                this.print();
                States nextState = INIT;
                if (Events.START == currentEvent) { nextState = READY; }

                return nextState;
            }

            @Override
            public void print() {
                System.out.println(this.getMessage());
            }
        },

        READY("READY - INSERT COIN") {
            @Override
            public States getNextState(Events currentEvent) {
                this.print();
                States nextState = READY;
                if (Events.INSERT_COIN == currentEvent) { nextState = COLLECT_MONEY; }
                else if (Events.TIME_OUT == currentEvent) { nextState = INIT; }
                return nextState;
            }

            @Override
            public void print() {
                System.out.println(this.getMessage());
            }
        },

        COLLECT_MONEY("COLLECT MONEY - ADD COINS OR SELECT PRODUCT") {
            @Override
            public States getNextState(Events currentEvent) {
                this.print();
                States nextState = COLLECT_MONEY;
                if (Events.CANCEL == currentEvent) { nextState = INIT; }
                else if (Events.TIME_OUT == currentEvent) { nextState = INIT; }
                else if (Events.ENOUGH_MONEY == currentEvent) { nextState = PRODUCT_DISTRIBUTED; }

                return nextState;
            }
            @Override
            public void print() {
                System.out.println(this.getMessage());
            }
        },

        PRODUCT_DISTRIBUTED("PRODUCT DISTRIBUTED - THANK YOU") {
            @Override
            public States getNextState(Events currentEvent) {
                return INIT;
            }
            @Override
            public void print() {
                System.out.println(this.getMessage());
            }
        };

        private String message;
        //constructor
        States(final String message){
            this.message = message;
        }

        public String getMessage(){
            return this.message;
        }

        public abstract States getNextState(Events currentEvent);
    }



    //API Methods
    public void start() {
        currentEvent = Events.START;
        currentState = currentState.getNextState(currentEvent);
        Machine machine_object = new Machine(); /*no need to creat object,
                                                 can you current instance using "this"*/

    }

    public void insertCoin(Coins coin){

        currentEvent = Events.INSERT_COIN;
        currentState = currentState.getNextState(currentEvent);
        if (currentState == currentState.INIT) {
            System.out.println("please press start To insert coins");
        }
        else {
            countMoney += coin.getSum();
            System.out.println("money inserted: " + countMoney);
        }
    }

    public void getProduct(){
        if (price > countMoney) {
            currentEvent = Events.NOT_ENOUGH_MONEY;
        }
        else {
            currentEvent = Events.ENOUGH_MONEY;
            countMoney = 0;
        }

        currentState = currentState.getNextState(currentEvent);
        if (currentEvent == currentEvent.ENOUGH_MONEY) {
            System.out.println(currentState.getMessage());
            currentState = currentState.getNextState(currentEvent);
        }
    }

    public void cancel(){
        System.out.println("cancels the purchase, returns " + countMoney + "new israeli shekels");
        countMoney = 0;

        currentEvent = Events.CANCEL;
        currentState = currentState.getNextState(currentEvent);
        System.out.println(currentState.getMessage());

    }
}