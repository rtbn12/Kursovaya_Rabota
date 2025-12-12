public class Client extends User{

    private double balance;

    public Client(String name, String password, String login, int Role) {
        super(name, password, login, Role);
        this.balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double money){
        this.balance += money;
    }

    public void deductBalance(double money)
    {
        if(this.balance >= money)
        {
            this.balance -= money;
        }

        else
        {
            System.out.println("Операция не удалась!\n" +
                    "Недостаточный баланс!\n" +
                    "Баланс составляет: "+ getBalance() + " рублей!");
        }
    }
}
