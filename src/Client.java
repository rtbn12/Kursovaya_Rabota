import java.util.*;

public class Client extends User{

    private double balance;
    private List<Product> shoppingList;
    private LinkedList<Product> shoppingCart;

    public Client(String name, String password, String login, int Role) {
        super(name, password, login, Role);
        this.balance = 0;
        shoppingList = new ArrayList<>();
        shoppingCart = new LinkedList<>();
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
                System.out.println("\n===================================================\n");
            }
        }
        else {
            System.out.println("\nВаш список покупок пока что пуст!");

        }
    }

    public void addShoppingCart(Product product){
        shoppingCart.addFirst(product);
        System.out.println("\nТовар успешно поступил в вашу корзину!");

    }

    public void printShoppingCart(){

        if(!shoppingCart.isEmpty()){

            for(Product product : shoppingCart){

                product.getMiniInfo();
                System.out.println("\n===================================================\n");
            }

        }else{
            System.out.println("\nВаша корзина пока что пуста!");
        }

    }

    public void clearShoppingCart(){
        if(!shoppingCart.isEmpty()){

            shoppingCart.clear();
            System.out.println("\nВаша корзина очищена!");

        }else{
            System.out.println("\nВаша корзина пуста!");
        }
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Product> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public LinkedList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(LinkedList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void removeProductInShoppingCartById(String id) {
        if (shoppingCart.isEmpty()) {
            System.out.println("\nВаша корзина пуста!");

        }else {

            int indexToRemove = -1;

            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getId().equals(id)) {
                    indexToRemove = i;
                    break;
                }
            }

            if (indexToRemove == -1) {

                System.out.println("\nТовар с ID " + id + " не найден в корзине!");


            } else {
                shoppingCart.remove(indexToRemove);
                System.out.println("\nТовар с ID " + id + " успешно удалён из корзины!");
            }
        }



    }

    public void buyProductInShoppingCartById(String id, Scanner scanner){

        if (shoppingCart.isEmpty()) {
            System.out.println("\nВаша корзина пуста!");

        }else {

            int indexToRemove = -1;

            for (int i = 0; i < shoppingCart.size(); i++) {
                if (shoppingCart.get(i).getId().equals(id)) {
                    indexToRemove = i;
                    break;
                }
            }

            if (indexToRemove == -1) {

                System.out.println("\nТовар с ID " + id + " не найден в корзине!");


            } else {

                Product product = shoppingCart.get(indexToRemove);
                boolean bye = ProductManager.buyProductTovar(product,this,scanner);
                if(bye){
                    System.out.println("\nТовар с ID " + id + " успешно куплен!");
                    shoppingCart.remove(indexToRemove);
                    System.out.println("\nТовар с ID " + id + " успешно удалён из корзины!");
                }else{
                    System.out.println("\nПокупка товара не прошла!");
                }

            }
        }

    }

    public void buyALLShoppingCard(Scanner scanner){

        if(!shoppingCart.isEmpty()){

            List<Product> cartCopy = new ArrayList<>(shoppingCart);

           for(Product product : cartCopy){

               boolean bye = ProductManager.buyProductTovar(product,this,scanner);
               if(bye){
                   System.out.println("\nТовар с ID " + product.getId() + " успешно куплен!");
                   shoppingCart.remove(product);
                   System.out.println("\nТовар с ID " + product.getId() + " успешно удалён из корзины!");
               }else{
                   System.out.println("\nПокупка товара не прошла!");
               }

           }

        }else{
            System.out.println("\nВаша корзина пуста!");
        }

    }
}
