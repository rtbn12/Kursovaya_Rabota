public class Seller extends User{

    private String sellerKey;

    public Seller(String name, String password, String login, int Role, String sellerKey) {
        super(name, password, login, Role);

        this.sellerKey = sellerKey;
    }
}
