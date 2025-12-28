import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Product> listProducts;

    public ShoppingList(){
        listProducts = new ArrayList<>();
    }

    public void addProduct(Product product){
        listProducts.add(product);
    }

    public void printListProduct(){

        if(!listProducts.isEmpty()){

            for(Product product : listProducts){

                product.getMiniInfo();
                //как доработаю класс продукт сделать дополнительно вывод времени покупок
                System.out.println("\n\n");
            }
        }
        else {
            System.out.println("\nВаш список покупок пока что пуст!");

        }

    }
}
