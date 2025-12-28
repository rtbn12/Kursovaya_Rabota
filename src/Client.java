import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client extends User{

    private double balance;
    private List<Product> shoppingList;

    public Client(String name, String password, String login, int Role) {
        super(name, password, login, Role);
        this.balance = 0;
        shoppingList = new ArrayList<>();
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

    public void addShoppingList(Product product) {
        shoppingList.add(product);
    }

    public void printShoppingList()
    {
        if(!shoppingList.isEmpty()){

            shoppingList.sort(Comparator.comparing(Product::getPayDate).reversed());

            for(Product product : shoppingList){

                product.getMiniInfo();
                product.getFullInformationForShoppingList();
                //как доработаю класс продукт сделать дополнительно вывод времени покупок
                System.out.println("\n\n");
            }
        }
        else {
            System.out.println("\nВаш список покупок пока что пуст!");

        }
    }
}
