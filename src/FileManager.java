import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FileManager {

    private static final String CLIENTFILE = "src/Clients.dat";
    private static final String SELLERSFILE = "src/Sellers.dat";
    private static final String PRODUCTFILE = "src/Products.dat";
    private static final String SHOPPINGLISTS = "src/ShoppingLists.dat";


    private static final String CPUTFILE = "src/FileCPU.dat";
    private static final String MOTHERBOARDFILE = "src/FileMotherBoard.dat";
    private static final String GPUFILE = "src/fileGPU.dat";
    private static final String RAMFILE = "src/FileRAM.dat";
    private static final String STORAGEFILE = "src/FileStorage.dat";
    private static final String POWERSUPPLYFILE = "src/FilePowerSupply.dat";
    private static final String CASEFILE = "src/FileCase.dat";
    private static final String COLLERFILE = "src/FileColler.dat";
    private static final String SOFTWAREFILE = "src/FileSoftware.dat";
    private static final String MONITORFILE = "src/FileMonitor.dat";
    private static final String MOUSEFILE = "src/FileMouse.dat";
    private static final String KEYBOARDFILE = "src/FileKeyboard.dat";



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

            Map<String, T> users = ( Map<String, T>)ois.readObject();

            ois.close();

            return users;

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




    public static void saveShoppingLists(Map<String, ShoppingList> shoppingLists) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(SHOPPINGLISTS));
            ous.writeObject(shoppingLists);
            ous.close();
        } catch (IOException e) {
            System.out.println("Ошибка сохранения списков покупок: " + e.getMessage());
        }
    }

    public static Map<String, ShoppingList> loadShoppingLists() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SHOPPINGLISTS));
            Map<String, ShoppingList> shoppingLists = (Map<String, ShoppingList>) ois.readObject();
            ois.close();
            return shoppingLists;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки списков покупок: " + e.getMessage());
            System.out.println("Возвращаю пустую коллекцию!");
            return new HashMap<String, ShoppingList>();
        }
    }

    //Классы обёртки

    public static void saveClient(Map<String,Client> clients)
    {
        saveUser(clients,CLIENTFILE);
    }

    public static void rewriteClient(Client client) {
        String login = client.getLogin();
        Map<String, Client> clientMap = loadClient();
        clientMap.get(login);
        clientMap.put(login, client);
        saveClient(clientMap);
    }

    public static void saveSeller(Map<String,Seller> sellers)
    {
        saveUser(sellers,SELLERSFILE);
    }

    public static void saveProduct0(Map<String,Product> products)
    {
        saveProduct(products,PRODUCTFILE);
    }

    public static Map<String, Product> loadProduct0()
    {
        return loadProduct(PRODUCTFILE);
    }

    public static Map<String,Client> loadClient()
    {
        return loadUser(CLIENTFILE);
    }

    public static Map<String,Seller> loadSeller()
    {
        return loadUser(SELLERSFILE);
    }




    public static void saveCPU(Map<String,CPU> products)
    {
        saveProduct(products,CPUTFILE);
    }

    public static Map<String,CPU> loadCPU()
    {
        return loadProduct(CPUTFILE);
    }

    public static void saveMotherBoard(Map<String,MotherBoard> products)
    {
        saveProduct(products,MOTHERBOARDFILE);
    }

    public static Map<String, MotherBoard> loadMotherBoard()
    {
        return loadProduct(MOTHERBOARDFILE);
    }

    public static void saveGPU(Map<String,GPU> products)
    {
        saveProduct(products,GPUFILE);
    }

    public static Map<String, GPU> loadGPU()
    {
        return loadProduct(GPUFILE);
    }

    public static void saveRAM(Map<String,RAM> products)
    {
        saveProduct(products,RAMFILE);
    }

    public static Map<String, RAM> loadRAM()
    {
        return loadProduct(RAMFILE);
    }

    public static void saveStorage(Map<String,Storage> products)
    {
        saveProduct(products,STORAGEFILE);
    }

    public static Map<String, Storage> loadStorage()
    {
        return loadProduct(STORAGEFILE);
    }

    public static void savePowerSupply(Map<String,PowerSupply> products)
    {
        saveProduct(products,POWERSUPPLYFILE);
    }

    public static Map<String, PowerSupply> loadPowerSupply()
    {
        return loadProduct(POWERSUPPLYFILE);
    }

    public static void saveCase(Map<String,Case> products)
    {
        saveProduct(products,CASEFILE);
    }

    public static Map<String, Case> loadCase()
    {
        return loadProduct(CASEFILE);
    }

    public static void saveCooler(Map<String,Cooler> products)
    {
        saveProduct(products,COLLERFILE);
    }

    public static Map<String, Cooler> loadCooler()
    {
        return loadProduct(COLLERFILE);
    }

    public static void saveSoftware(Map<String,Software> products)
    {
        saveProduct(products,SOFTWAREFILE);
    }

    public static Map<String, Software> loadSoftware()
    {
        return loadProduct(SOFTWAREFILE);
    }

    public static void saveMonitor(Map<String,Monitor> products)
    {
        saveProduct(products,MONITORFILE);
    }

    public static Map<String, Monitor> loadMonitor()
    {
        return loadProduct(MONITORFILE);
    }

    public static void saveMouse(Map<String,Mouse> products)
    {
        saveProduct(products,MOUSEFILE);
    }

    public static Map<String,Mouse> loadMouse()
    {
        return loadProduct(MOUSEFILE);
    }

    public static void saveKeyboard(Map<String,Keyboard> products)
    {
        saveProduct(products,KEYBOARDFILE);
    }

    public static Map<String, Keyboard> loadKeyboard()
    {
        return loadProduct(KEYBOARDFILE);
    }





}
