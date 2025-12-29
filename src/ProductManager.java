import java.util.*;

public class ProductManager {

    public static Product registrationProduct(String choiceCategory) {
        Map<String, Product> products = FileManager.loadProduct0();
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }


            System.out.println("\n=== Заполнение информации о продукте ===");
            Product product = new Product(id, choiceCategory, scanner);


            products.put(id, product);
            FileManager.saveProduct0(products);

            System.out.println("\nПродукт успешно зарегистрирован!");
            return product;

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации продукта: " + e.getMessage());
            return null;
        }
    }


    public static ComputerComponent registrationComputerComponent(String choiceCategory) {
        Map<String, Product> products = FileManager.loadProduct0();
        Scanner scanner = new Scanner(System.in);

        try {


                System.out.print("\nВведите ID продукта: ");
                String id = scanner.nextLine().toUpperCase().trim();

                while (products.containsKey(id)) {
                    System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                    id = scanner.nextLine().toUpperCase().trim();
                }

                ComputerComponent component = new ComputerComponent(id, choiceCategory, scanner);

                String brand = component.getBrand();
                String model = component.getModel();
                String countryProduction = component.getCountryProduction();
                int productionDate = component.getProductionDate();
                int price = component.getPrice();
                String category = component.getCategory();
                String description = component.getDescription();
                Date addedDate = component.getAddedDate();
                double rating = component.getRating();
                int warrantyMoths = component.getWarrantyMoths();
                int quantityProduct = component.getQuantityProduct();
                Date payDate = component.getPayDate();
                Product product = new Product(id,brand,model,countryProduction,
                        productionDate,price,category,description,addedDate,
                        rating,warrantyMoths,quantityProduct,payDate);


                products.put(id, product);
                FileManager.saveProduct0(products);

            System.out.println("\nКомпонент успешно зарегистрирован!");
            return component;

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации компонента: " + e.getMessage());
            return null;
        }
    }


    public static void registrationCPU(String choiceCategory) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация процессора ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, CPU> cpus = FileManager.loadCPU();

            CPU cpu = new CPU(id, choiceCategory, scanner);

            products.put(id, cpu);
            FileManager.saveProduct0(products);

            cpus.put(id, cpu);
            FileManager.saveCPU(cpus);

            System.out.print("\nРегистрация товара завершена успешно!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации процессора: " + e.getMessage());
        }
    }


    public static void registrationMotherBoard(String choiceCategory) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация материнской платы ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, MotherBoard> motherBoards = FileManager.loadMotherBoard();

            MotherBoard motherBoard = new MotherBoard(id, choiceCategory, scanner);

            products.put(id, motherBoard);
            FileManager.saveProduct0(products);

            motherBoards.put(id, motherBoard);
            FileManager.saveMotherBoard(motherBoards);

            System.out.print("\nМатеринская плата " + motherBoard.getBrand() + " " + motherBoard.getModel() + " успешно зарегистрирована!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации материнской платы: " + e.getMessage());
        }
    }



    public static void registrationGPU(String choiceCategory){

        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация видеокарты ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, GPU> gpus = FileManager.loadGPU();

            GPU gpu = new GPU(id, choiceCategory, scanner);

            products.put(id, gpu);
            FileManager.saveProduct0(products);

            gpus.put(id, gpu);
            FileManager.saveGPU(gpus);

            System.out.print("\nВидеокарта " + gpu.getBrand() + " " + gpu.getModel() + " успешно зарегистрирована!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации видеокарты: " + e.getMessage());
        }
    }



    public static void registrationRAM(String choiceCategory) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация оперативной памяти ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, RAM> rams = FileManager.loadRAM();

            RAM ram = new RAM(id, choiceCategory, scanner);

            products.put(id, ram);
            FileManager.saveProduct0(products);

            rams.put(id, ram);
            FileManager.saveRAM(rams);

            System.out.print("\nОперативная память " + ram.getBrand() + " " + ram.getModel() + " успешно зарегистрирована!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации оперативной памяти: " + e.getMessage());
        }
    }


    public static void registrationStorage(String choiceCategory) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация накопителя ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Storage> storages = FileManager.loadStorage();

            Storage storage = new Storage(id, choiceCategory, scanner);

            products.put(id, storage);
            FileManager.saveProduct0(products);

            storages.put(id, storage);
            FileManager.saveStorage(storages);

            System.out.print("\nНакопитель " + storage.getBrand() + " " + storage.getModel() + " успешно зарегистрирован!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации накопителя: " + e.getMessage());
        }
    }


    public static void registrationPowerSupply(String choiceCategory){

        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация блока питания ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, PowerSupply> powerSupplies = FileManager.loadPowerSupply();

            PowerSupply powerSupply = new PowerSupply(id, choiceCategory, scanner);

            products.put(id, powerSupply);
            FileManager.saveProduct0(products);

            powerSupplies.put(id, powerSupply);
            FileManager.savePowerSupply(powerSupplies);

            System.out.print("\nБлок питания " + powerSupply.getBrand() + " " + powerSupply.getModel() + " успешно зарегистрирован!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации блока питания: " + e.getMessage());
        }
    }


    public static void registrationCase(String choiceCategory){
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация корпуса ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Case> cases = FileManager.loadCase();

            Case computerCase = new Case(id, choiceCategory, scanner);

            products.put(id, computerCase);
            FileManager.saveProduct0(products);

            cases.put(id, computerCase);
            FileManager.saveCase(cases);

            System.out.print("\nКорпус " + computerCase.getBrand() + " " + computerCase.getModel() + " успешно зарегистрирован!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации корпуса: " + e.getMessage());
        }
    }


    public static void registrationCooler(String choiceCategory){
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация кулера ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Cooler> coolers = FileManager.loadCooler();

            Cooler cooler = new Cooler(id, choiceCategory, scanner);

            products.put(id, cooler);
            FileManager.saveProduct0(products);

            coolers.put(id, cooler);
            FileManager.saveCooler(coolers);

            System.out.print("\nКулер " + cooler.getBrand() + " " + cooler.getModel() + " успешно зарегистрирован!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации кулера: " + e.getMessage());
        }


    }


    public static void registrationSoftware(String choiceCategory){
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация программного обеспечения ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Software> softwareMap = FileManager.loadSoftware();

            Software software = new Software(id, choiceCategory, scanner);

            products.put(id, software);
            FileManager.saveProduct0(products);

            softwareMap.put(id, software);
            FileManager.saveSoftware(softwareMap);

            System.out.print("\nПрограммное обеспечение " + software.getBrand() + " " + software.getModel() + " успешно зарегистрировано!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации программного обеспечения: " + e.getMessage());
        }

    }


//    public static void registrationPeripheral(String choiceCategory) {
//        Scanner scanner = new Scanner(System.in);
//        Map<String, Product> products = FileManager.loadProduct0();
//
//        try {
//            System.out.println("\n=== Регистрация периферийного устройства ===");
//
//            System.out.print("\nВведите ID продукта: ");
//            String id = scanner.nextLine().toUpperCase().trim();
//
//            while (products.containsKey(id)) {
//                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
//                id = scanner.nextLine().toUpperCase().trim();
//            }
//
//            Map<String, Peripheral> peripherals = FileManager.loadPeripheral();
//
//            Peripheral peripheral = new Peripheral(id, choiceCategory, scanner);
//
//            products.put(id, peripheral);
//            FileManager.saveProduct0(products);
//
//            peripherals.put(id, peripheral);
//            FileManager.savePeripheral(peripherals);
//
//            System.out.print("\nПериферийное устройство " + peripheral.getBrand() + " " + peripheral.getModel() + " успешно зарегистрировано!");
//
//        } catch (Exception e) {
//            System.out.println("\nОшибка при регистрации периферийного устройства: " + e.getMessage());
//        }
//    }


    public static void registrationMonitor(String choiceCategory){

        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация монитора ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Monitor> monitors = FileManager.loadMonitor();

            Monitor monitor = new Monitor(id, choiceCategory, scanner);

            products.put(id, monitor);
            FileManager.saveProduct0(products);

            monitors.put(id, monitor);
            FileManager.saveMonitor(monitors);

            System.out.print("\nМонитор " + monitor.getBrand() + " " + monitor.getModel() + " успешно зарегистрирован!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации монитора: " + e.getMessage());
        }
    }


    public static void registrationMouse(String choiceCategory){
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация мыши ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Mouse> mice = FileManager.loadMouse();

            Mouse mouse = new Mouse(id, choiceCategory, scanner);

            products.put(id, mouse);
            FileManager.saveProduct0(products);

            mice.put(id, mouse);
            FileManager.saveMouse(mice);

            System.out.print("\nМышь " + mouse.getBrand() + " " + mouse.getModel() + " успешно зарегистрирована!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации мыши: " + e.getMessage());
        }

    }


    public static void registrationKeyBoard(String choiceCategory){
        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();

        try {
            System.out.println("\n=== Регистрация клавиатуры ===");

            System.out.print("\nВведите ID продукта: ");
            String id = scanner.nextLine().toUpperCase().trim();

            while (products.containsKey(id)) {
                System.out.print("\nТакой ID уже занят!\nПридумайте другой: ");
                id = scanner.nextLine().toUpperCase().trim();
            }

            Map<String, Keyboard> keyboards = FileManager.loadKeyboard();

            Keyboard keyboard = new Keyboard(id, choiceCategory, scanner);

            products.put(id, keyboard);
            FileManager.saveProduct0(products);

            keyboards.put(id, keyboard);
            FileManager.saveKeyboard(keyboards);

            System.out.print("\nКлавиатура " + keyboard.getBrand() + " " + keyboard.getModel() + " успешно зарегистрирована!");

        } catch (Exception e) {
            System.out.println("\nОшибка при регистрации клавиатуры: " + e.getMessage());
        }

    }







    public static  Map<String,Product> printMiniInfo(String category){

        Map<String,Product> products = FileManager.loadProduct0();
        System.out.println("============================ Базовая информация ================================");
        for (Product product : products.values())
        {

            if (product.getCategory().equals(category)) {
                product.getMiniInfo();
                System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            }
        }

        return products;


    }

    public static void searchProductForClient(){

        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();
        System.out.print("\nВведите id заинтересовавшего вас товара:");
        String id = scanner.nextLine();

        while(!products.containsKey(id)){
            System.out.print("\nТовара с таким id не найдено!\n" +
                    "Пожалуйста, попробуйте ввести id товара ещё раз:");
            id = scanner.nextLine();
        }

        Product product = products.get(id);
        String category = product.getCategory();
        switch (category){

            case "Центральный процессор":
                Map<String,CPU> CPU = FileManager.loadCPU();
                CPU cpu = CPU.get(id);
                cpu.getFullInfoForClient();
                break;
            case "Материнская плата":
                Map<String,MotherBoard> MB = FileManager.loadMotherBoard();
                MotherBoard mb = MB.get(id);
                mb.getFullInfoForClient();
                break;
            case "Видеокарта":
                Map<String,GPU> GPU = FileManager.loadGPU();
                GPU gpu = GPU.get(id);
                gpu.getFullInfoForClient();
                break;
            case"Оперативная память":
                Map<String,RAM> RAM = FileManager.loadRAM();
                RAM ram = RAM.get(id);
                ram.getFullInfoForClient();
                break;
            case "Постоянное запоминающее устройство":
                Map<String,Storage> Storage = FileManager.loadStorage();
                Storage storage = Storage.get(id);
                storage.getFullInfoForClient();
                break;
            case "Блок питания":
                Map<String,PowerSupply> PowerSupply = FileManager.loadPowerSupply();
                PowerSupply powerSupply = PowerSupply.get(id);
                powerSupply.getFullInfoForClient();
                break;
            case "Корпус":Map<String,Case> Case = FileManager.loadCase();
                Case ccase = Case.get(id);
                ccase.getFullInfoForClient();
                break;
            case "Кулер":Map<String,Cooler> Cooler = FileManager.loadCooler();
                Cooler cooler = Cooler.get(id);
                cooler.getFullInfoForClient();
                break;
            case "Программное обеспечение":
                Map<String,Software> Software = FileManager.loadSoftware();
                Software software = Software.get(id);
                software.getFullInfoForClient();
                break;
            case "Монитор":
                Map<String,Monitor> Monitor = FileManager.loadMonitor();
                Monitor monitor = Monitor.get(id);
                monitor.getFullInfoForClient();
                break;
            case "Мышь":
                Map<String,Mouse> Mouse = FileManager.loadMouse();
                Mouse mouse = Mouse.get(id);
                mouse.getFullInfoForClient();
                break;
            case "Клавиатура":
                Map<String,Keyboard> Keyboard = FileManager.loadKeyboard();
                Keyboard keyboard = Keyboard.get(id);
                keyboard.getFullInfoForClient();
                break;

        }


    }

    public static void searchProductForSeller(){

        Scanner scanner = new Scanner(System.in);
        Map<String, Product> products = FileManager.loadProduct0();
        System.out.print("\nВведите id заинтересовавшего вас товара:");
        String id = scanner.nextLine();

        while(!products.containsKey(id)){
            System.out.print("\nТовара с таким id не найдено!\n" +
                    "Пожалуйста, попробуйте ввести id товара ещё раз:");
            id = scanner.nextLine();
        }

        Product product = products.get(id);
        product.getFullInfoForClient();
        product.getFullInfoForSeller();

    }

}
