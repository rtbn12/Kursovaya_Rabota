import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//проверка работы гита
//Vlad rediska
public class FileManager {

    private static final String CLIENTFILE = "src/Clients.dat";
    private static final String SELLERSFILE = "src/Sellers.dat";
    private static final String PRODUCTFILE = "src/Products.dat";

    public static <T extends User> void  saveUser(Map<String, T> users, String filename){
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename));

            ous.writeObject(users);
            ous.close();

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла!");
        }
    }


    public static <T extends User> Map<String, T> loadUser(String filename){

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));

            Map<String, T> clients = ( Map<String, T>)ois.readObject();

            ois.close();

            return clients;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
            System.out.println("Возвращаю пустую коллекцию!");
            return new HashMap<String, T>(); // ← return ВНУТРИ catch!
        }
    }

    public static <T extends Product> void saveProduct(Map<String,T> products, String filename)
    {

        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename));
            ous.writeObject(products);
            ous.close();

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла!");
        }

    }

    public static <T extends Product> Map<String, T> loadProduct(String filename)
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            Map<String,T> products =  (Map<String,T>)ois.readObject();
            ois.close();
            return products;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
            System.out.println("Возвращаю пустую коллекцию!");
            return new HashMap<String, T>(); // ← return ВНУТРИ catch!
        }
    }

    //Классы обёртки

    public static void saveClient(Map<String,Client> clients)
    {
        saveUser(clients,CLIENTFILE);
    }

    public static void saveSeller(Map<String,Seller> sellers)
    {
        saveUser(sellers,SELLERSFILE);
    }

    public static void saveProduct0(Map<String,Product> products)
    {
        saveProduct(products,PRODUCTFILE);
    }

    public static Map<String,Client> loadClient()
    {
        return loadUser(CLIENTFILE);
    }

    public static Map<String,Seller> loadSeller()
    {
        return loadUser(SELLERSFILE);
    }

    public static Map<String, Product> loadProduct0()
    {
        return loadProduct(PRODUCTFILE);
    }

}
