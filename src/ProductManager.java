import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {

    public static Product registrationProduct (String choiceCategory)
    {
       Map<String,Product> products = FileManager.loadProduct0();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите ID  продукта:");
        String id = scanner.nextLine().toUpperCase().trim();

        while(products.containsKey(id))
        {
            System.out.print("\nТакой ID уже занят!\n" +
                    "Придумай другой!:");
            id = scanner.nextLine();

        }


        System.out.print("\nВведите бренд:");
        String brand = scanner.nextLine();

        System.out.print("\nВведите модель:");
        String model = scanner.nextLine();

        System.out.print("\nВведите страну производителя:");
        String countryProduction = scanner.nextLine();

        System.out.print("\nВведите год производства:");
        int productionDate = scanner.nextInt();

        while((productionDate < 2018) || productionDate > Calendar.getInstance().get(Calendar.YEAR))
        {
            System.out.print("\nНекорректный год производства!\n" +
                    "Введите год производства ещё раз:");
            productionDate = scanner.nextInt();
        }

        System.out.print("\nВведите цену товара:");
        int price = scanner.nextInt();

        while (price <=0 || price>1000_000)
        {
            System.out.print("\nВведена недоступная цена для товара!\n" +
                    "Введите цену ещё раз:");
            price = scanner.nextInt();
        }


        System.out.print("\nВведите описание товара:");
        String description = scanner.nextLine();
        while (description.length()>500)
        {
            System.out.print("\nОписание товара слишком длинное!\n" +
                    "Постарайтесь вместить описание в 500 символов!\n" +
                    "Введите описание ещё раз:");
            description = scanner.nextLine();
        }

        int warrantyMoths = 0;

        boolean warranty = true;
        while (warranty)
        {
            System.out.print("\nВведите срок предоставляемой гарантии на товар в целом количестве месяцев:");
            try {
                warrantyMoths = scanner.nextInt();
                while (warrantyMoths<=0 || warrantyMoths>120)
                {
                    System.out.print("\nВы ввели некорректный срок гарантии!\n" +
                            "Введите срок гарантии в месяцах заново!:");
                    warrantyMoths = scanner.nextInt();
                }
                warranty = false;
            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение срока гарантии!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }


        
        System.out.print("\nРегистрация товара завершена успешно!");

        products.put(id,new Product(id,brand,model,countryProduction,productionDate,price,choiceCategory,description,warrantyMoths));
        FileManager.saveProduct0(products);
        return  new Product(id,brand,model,countryProduction,productionDate,price,choiceCategory,description,warrantyMoths);


    }

    public static ComputerComponent registrationComputerComponent(String choiceCategory)
    {
        Product product = registrationProduct(choiceCategory);
        Scanner scanner = new Scanner(System.in);

        String id = product.getId();
        String brand = product.getBrand();
        String model = product.getModel();
        String countryProduction = product.getCountryProduction();
        int productionDate = product.getProductionDate();
        int price = product.getPrice();
        String description = product.getDescription();
        int warrantyMoths = product.getWarrantyMoths();
        String category = product.getCategory();

        String interfaceType;
        if(category.equals("Видеокарта"))
        {
            interfaceType = "PCIe";
        } else if (category.equals("Кулер")) {
            interfaceType = "Нет";
        } else if (category.equals("Корпус")) {
            interfaceType = "Нет";
        } else if (category.equals("Блок питания")) {
            interfaceType = "Нет";
        } else if (category.equals("Центральный процессор")) {

        } else if (category.equals("Оперативная память")) {

        } else if (category.equals("Постоянное запоминающее устройство")) {


        } else {
            System.out.print("\nВведите интерфейсы подключения внешних устройств материнской платы:");
            interfaceType = scanner.nextLine();
        }


    }












    public static void registrationCPU(String choiceCategory){}
    public static void registrationMotherBoard(String choiceCategory){}
    public static void registrationGPU(String choiceCategory){}
    public static void registrationRAM(String choiceCategory){}
    public static void registrationStorage(String choiceCategory){}
    public static void registrationPowerSupply(String choiceCategory){}
    public static void registrationCase(String choiceCategory){}
    public static void registrationCooler(String choiceCategory){}
    public static void registrationSoftware(String choiceCategory){}
    public static void registrationMonitor(String choiceCategory){}
    public static void registrationMouse(String choiceCategory){}
    public static void registrationKeyBoard(String choiceCategory){}
}
