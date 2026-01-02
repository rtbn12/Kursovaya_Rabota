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

    public static Product searchProductForSeller(){

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
                cpu.getFullInfoForSeller();
                break;
            case "Материнская плата":
                Map<String,MotherBoard> MB = FileManager.loadMotherBoard();
                MotherBoard mb = MB.get(id);
                mb.getFullInfoForClient();
                mb.getFullInfoForSeller();
                break;
            case "Видеокарта":
                Map<String,GPU> GPU = FileManager.loadGPU();
                GPU gpu = GPU.get(id);
                gpu.getFullInfoForClient();
                gpu.getFullInfoForSeller();
                break;
            case"Оперативная память":
                Map<String,RAM> RAM = FileManager.loadRAM();
                RAM ram = RAM.get(id);
                ram.getFullInfoForClient();
                ram.getFullInfoForSeller();
                break;
            case "Постоянное запоминающее устройство":
                Map<String,Storage> Storage = FileManager.loadStorage();
                Storage storage = Storage.get(id);
                storage.getFullInfoForClient();
                storage.getFullInfoForSeller();
                break;
            case "Блок питания":
                Map<String,PowerSupply> PowerSupply = FileManager.loadPowerSupply();
                PowerSupply powerSupply = PowerSupply.get(id);
                powerSupply.getFullInfoForClient();
                powerSupply.getFullInfoForSeller();
                break;
            case "Корпус":Map<String,Case> Case = FileManager.loadCase();
                Case ccase = Case.get(id);
                ccase.getFullInfoForClient();
                ccase.getFullInfoForSeller();
                break;
            case "Кулер":Map<String,Cooler> Cooler = FileManager.loadCooler();
                Cooler cooler = Cooler.get(id);
                cooler.getFullInfoForClient();
                cooler.getFullInfoForSeller();
                break;
            case "Программное обеспечение":
                Map<String,Software> Software = FileManager.loadSoftware();
                Software software = Software.get(id);
                software.getFullInfoForClient();
                software.getFullInfoForSeller();
                break;
            case "Монитор":
                Map<String,Monitor> Monitor = FileManager.loadMonitor();
                Monitor monitor = Monitor.get(id);
                monitor.getFullInfoForClient();
                monitor.getFullInfoForSeller();
                break;
            case "Мышь":
                Map<String,Mouse> Mouse = FileManager.loadMouse();
                Mouse mouse = Mouse.get(id);
                mouse.getFullInfoForClient();
                mouse.getFullInfoForSeller();
                break;
            case "Клавиатура":
                Map<String,Keyboard> Keyboard = FileManager.loadKeyboard();
                Keyboard keyboard = Keyboard.get(id);
                keyboard.getFullInfoForClient();
                keyboard.getFullInfoForSeller();
                break;

        }

        return product;

    }



    public static void printFullInformationCPU(){

        Map<String, CPU> cpus = FileManager.loadCPU();

        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог процессоров =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if(!cpus.isEmpty()){
            for(CPU cpu : cpus.values()){
                cpu.getFullInfoForClient();
                cpu.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        }
        else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationRAM() {
        Map<String, RAM> rams = FileManager.loadRAM();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог ОЗУ =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!rams.isEmpty()) {
            for (RAM ram : rams.values()) {
                ram.getFullInfoForClient();
                ram.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationMotherboard() {
        Map<String, MotherBoard> motherboards = FileManager.loadMotherBoard();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог материнских плат =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!motherboards.isEmpty()) {
            for (MotherBoard motherboard : motherboards.values()) {
                motherboard.getFullInfoForClient();
                motherboard.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationGPU() {
        Map<String, GPU> gpus = FileManager.loadGPU();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог видеокарт =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!gpus.isEmpty()) {
            for (GPU gpu : gpus.values()) {
                gpu.getFullInfoForClient();
                gpu.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationStorage() {
        Map<String, Storage> storages = FileManager.loadStorage();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог ПЗУ =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!storages.isEmpty()) {
            for (Storage storage : storages.values()) {
                storage.getFullInfoForClient();
                storage.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationPowerSupply() {
        Map<String, PowerSupply> powerSupplies = FileManager.loadPowerSupply();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог блоков питания =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!powerSupplies.isEmpty()) {
            for (PowerSupply powerSupply : powerSupplies.values()) {
                powerSupply.getFullInfoForClient();
                powerSupply.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationCase() {
        Map<String, Case> cases = FileManager.loadCase();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог компьютерных корпусов =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!cases.isEmpty()) {
            for (Case computerCase : cases.values()) {
                computerCase.getFullInfoForClient();
                computerCase.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationCooler() {
        Map<String, Cooler> coolers = FileManager.loadCooler();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог кулеров =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!coolers.isEmpty()) {
            for (Cooler cooler : coolers.values()) {
                cooler.getFullInfoForClient();
                cooler.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationSoftware() {
        Map<String, Software> softwareMap = FileManager.loadSoftware();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог ПО =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!softwareMap.isEmpty()) {
            for (Software software : softwareMap.values()) {
                software.getFullInfoForClient();
                software.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationMonitor() {
        Map<String, Monitor> monitors = FileManager.loadMonitor();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог мониторов =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!monitors.isEmpty()) {
            for (Monitor monitor : monitors.values()) {
                monitor.getFullInfoForClient();
                monitor.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationMouse() {
        Map<String, Mouse> mice = FileManager.loadMouse();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог мышей =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!mice.isEmpty()) {
            for (Mouse mouse : mice.values()) {
                mouse.getFullInfoForClient();
                mouse.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }

    public static void printFullInformationKeyboard() {
        Map<String, Keyboard> keyboards = FileManager.loadKeyboard();
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+= Каталог клавиатур =+=+=+=+=+=+=+=+=+=+=+=+=+=");

        if (!keyboards.isEmpty()) {
            for (Keyboard keyboard : keyboards.values()) {
                keyboard.getFullInfoForClient();
                keyboard.getFullInfoForSeller();
                System.out.println("\n=========================================================================\n");
            }
        } else {
            System.out.println("\nТоваров данной категории пока что нет в магазине!");
        }
    }




    public static void removeTovarAndProduct(Scanner scanner){


        int removeChoice;
        boolean removeCycle = true;
        while(removeCycle)
        {
            System.out.println("\n+=+=+=+=+=+=+=+=+=+=+=+= Удаления товара =+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Точно удалить товар\n" +
                    "0 - Вернуться назад\n" +
                    "Ваш выбор:");


            try {
                removeChoice = scanner.nextInt();
                scanner.nextLine();

                switch (removeChoice)
                {
                    case 1:
                        int removeRemoveChoice;
                        boolean removeRemoveCycle = true;
                        while(removeRemoveCycle)
                        {
                            Map<String, Product> products = FileManager.loadProduct0();
                            System.out.print("\nВведите id товара, который будет удалён:");
                            String id = scanner.nextLine();

                            while(!products.containsKey(id)){
                                System.out.print("\nТовара с таким id не найдено!\n" +
                                        "Пожалуйста, попробуйте ввести id товара ещё раз:");
                                id = scanner.nextLine();
                            }

                            boolean cycle = true;
                            while (cycle){
                                System.out.print("\nВы точно хотите продолжить удаление товара?\n" +
                                        "ПОСЛЕДСТВИЯ БУДУТ НЕ ОБРАТИМЫ!\n" +
                                        "Введите 1 - если хотите продолжить процесс удаления товара!\n" +
                                        "Введите 0 - если хотите прервать процесс удаления!\n" +
                                        "Ваш выбор:");

                                try {
                                    removeRemoveChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (removeRemoveChoice)
                                    {
                                        case 1:

                                            Product product = products.get(id);
                                            String category = product.getCategory();

                                            products.remove(id);
                                            FileManager.saveProduct0(products);

                                            switch (category){

                                                case "Центральный процессор":
                                                    Map<String, CPU> CPUMap = FileManager.loadCPU();
                                                    CPUMap.remove(id);
                                                    FileManager.saveCPU(CPUMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Материнская плата":
                                                    Map<String, MotherBoard> MBMap = FileManager.loadMotherBoard();
                                                    MBMap.remove(id);
                                                    FileManager.saveMotherBoard(MBMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Видеокарта":
                                                    Map<String, GPU> GPUMap = FileManager.loadGPU();
                                                    GPUMap.remove(id);
                                                    FileManager.saveGPU(GPUMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case"Оперативная память":
                                                    Map<String, RAM> RAMMap = FileManager.loadRAM();
                                                    RAMMap.remove(id);
                                                    FileManager.saveRAM(RAMMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Постоянное запоминающее устройство":
                                                    Map<String, Storage> StorageMap = FileManager.loadStorage();
                                                    StorageMap.remove(id);
                                                    FileManager.saveStorage(StorageMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Блок питания":
                                                    Map<String, PowerSupply> PowerSupplyMap = FileManager.loadPowerSupply();
                                                    PowerSupplyMap.remove(id);
                                                    FileManager.savePowerSupply(PowerSupplyMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Корпус":
                                                    Map<String, Case> CaseMap = FileManager.loadCase();
                                                    CaseMap.remove(id);
                                                    FileManager.saveCase(CaseMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Кулер":
                                                    Map<String, Cooler> CoolerMap = FileManager.loadCooler();
                                                    CoolerMap.remove(id);
                                                    FileManager.saveCooler(CoolerMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Программное обеспечение":
                                                    Map<String, Software> SoftwareMap = FileManager.loadSoftware();
                                                    SoftwareMap.remove(id);
                                                    FileManager.saveSoftware(SoftwareMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Монитор":
                                                    Map<String, Monitor> MonitorMap = FileManager.loadMonitor();
                                                    MonitorMap.remove(id);
                                                    FileManager.saveMonitor(MonitorMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Мышь":
                                                    Map<String, Mouse> MouseMap = FileManager.loadMouse();
                                                    MouseMap.remove(id);
                                                    FileManager.saveMouse(MouseMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Клавиатура":
                                                    Map<String, Keyboard> KeyboardMap = FileManager.loadKeyboard();
                                                    KeyboardMap.remove(id);
                                                    FileManager.saveKeyboard(KeyboardMap);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;

                                            }

                                            System.out.println("\nУдаление товара прошло успешно!");

                                            break;
                                        case 0:
                                            System.out.println("\nУдаление было отменено!");
                                            cycle = false;
                                            removeRemoveCycle = false;
                                            break;
                                        default:
                                            System.out.println("Такого варианта выбора нет!\n" +
                                                    "Пожалуйста, введите корректное число!");
                                    }

                                }catch (InputMismatchException e) {
                                    System.out.println("Произошла ошибка!\n" +
                                            "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                            "В прошлый раз вы ввели букву вместо числа!");
                                    scanner.nextLine();
                                }
                                catch (Exception a) {
                                    System.out.println("Произошла неизвестная ошибка!");
                                    scanner.nextLine();
                                }
                            }


                        }
                        break;
                    case 0:
                        removeCycle = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }



    }



    public static void rewriteCPU(String id, Scanner scanner){

        Map<String, CPU> MapCPU = FileManager.loadCPU();
        CPU cpu = MapCPU.get(id);

        Map<String, CPU> MapCPU2 = FileManager.loadCPU();
        CPU  izmenCPU = MapCPU2.get(id);



        int Choice;
        boolean Cycle = true;
        while(Cycle)
        {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование процессора (" + cpu.getFullName() + id + ")--+-+-+-+-+-+-+-+");
            izmenCPU.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Интерфейс подключения\n" +
                    "3 - Сокет\n" +
                    "4 - Количество ядер\n" +
                    "5 - Количество потоков\n" +
                    "6 - Базовая частота\n" +
                    "7 - Максимальная частота\n" +
                    "8 - Размер кэша\n" +
                    "9 - Поддерживаемые типы памяти\n" +
                    "10 - Наличие встроенного графического ядра\n" +
                    "11 - Потребляемая мощность\n" +
                    "12 - Рабочее напряжение\n" +
                    "13 - Страна-производитель\n" +
                    "14 - Год релиза\n" +
                    "15 - Гарантийный срок\n" +
                    "16 - Рейтинг\n" +
                    "17 - Количество на складе\n" +
                    "18 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");
            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice)
                {
                    case 1: izmenCPU.setPrice(scanner);
                        break;
                    case 2: izmenCPU.setInterfaceType(scanner, izmenCPU.getCategory());
                        break;
                    case 3: izmenCPU.setSocket(scanner);
                        break;
                    case 4: izmenCPU.setCoreCount(scanner);
                        break;
                    case 5: izmenCPU.setThreadCount(scanner);
                        break;
                    case 6: izmenCPU.setBaseFrequency(scanner);
                        break;
                    case 7: izmenCPU.setMaxFrequency(scanner);
                        break;
                    case 8: izmenCPU.setCacheSize(scanner);
                        break;
                    case 9: izmenCPU.setMemoryType(scanner);
                        break;
                    case 10: izmenCPU.setHasIntegratedGraphics(scanner);
                        break;
                    case 11: izmenCPU.setPowerConsumption(scanner);
                        break;
                    case 12: izmenCPU.setVoltage(scanner);
                        break;
                    case 13: izmenCPU.setCountryProduction(scanner);
                        break;
                    case 14: izmenCPU.setProductionDate(scanner);
                        break;
                    case 15: izmenCPU.setWarrantyMoths(scanner);
                        break;
                    case 16: izmenCPU.setRating(scanner);
                        break;
                    case 17: izmenCPU.setQuantityProduct(scanner);
                        break;
                    case 18: izmenCPU.setDescription(scanner);
                        break;
                    case 0:

                        System.out.println("\n======================== Исходный вариант =========================");
                        cpu.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenCPU.getFullInfoForClient();
                        int printChoice;
                        boolean print = true;
                        while(print)
                        {
                            System.out.print("\nВыберите одно из доступных действий:\n" +
                                    "1 - Сохранить все изменения\n" +
                                    "0 - Отменить изменения(оставить оригинал)\n" +
                                    "Ваш выбор:");


                            try {
                                printChoice = scanner.nextInt();

                                switch (printChoice)
                                {
                                    case 1:
                                        MapCPU.put(id, izmenCPU);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenCPU);

                                        FileManager.saveCPU(MapCPU);
                                        FileManager.saveProduct0(ProductMap);
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nВаши изменения были сохранены!");
                                        break;
                                    case 0:
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nИзменения были отменены!");

                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректное число!");
                                }

                            }catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            }
                            catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }

                        }
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


    }

    public static void rewriteMotherBoard(String id, Scanner scanner) {

        Map<String, MotherBoard> MapMB = FileManager.loadMotherBoard();
        MotherBoard mb = MapMB.get(id);

        Map<String, MotherBoard> MapMB2 = FileManager.loadMotherBoard();
        MotherBoard izmenMB = MapMB2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование материнской платы (" + mb.getBrand() + " " + mb.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenMB.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Интерфейс подключения\n" +
                    "3 - Чипсет\n" +
                    "4 - Сокет\n" +
                    "5 - Количество слотов RAM\n" +
                    "6 - Максимальный объем RAM\n" +
                    "7 - Тип памяти\n" +
                    "8 - Количество M.2 слотов\n" +
                    "9 - Количество SATA портов\n" +
                    "10 - Аудиокодек\n" +
                    "11 - Скорость сетевой карты\n" +
                    "12 - Наличие WiFi\n" +
                    "13 - Потребляемая мощность\n" +
                    "14 - Рабочее напряжение\n" +
                    "15 - Страна-производитель\n" +
                    "16 - Год релиза\n" +
                    "17 - Гарантийный срок\n" +
                    "18 - Рейтинг\n" +
                    "19 - Количество на складе\n" +
                    "20 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenMB.setPrice(scanner);
                        break;
                    case 2:
                        izmenMB.setInterfaceType(scanner, izmenMB.getCategory());
                        break;
                    case 3:
                        izmenMB.setChipset(scanner);
                        break;
                    case 4:
                        izmenMB.setSocket(scanner);
                        break;
                    case 5:
                        izmenMB.setRamSlots(scanner);
                        break;
                    case 6:
                        izmenMB.setMaxRamCapacity(scanner);
                        break;
                    case 7:
                        izmenMB.setRamType(scanner);
                        break;
                    case 8:
                        izmenMB.setM2Slots(scanner);
                        break;
                    case 9:
                        izmenMB.setSataPorts(scanner);
                        break;
                    case 10:
                        izmenMB.setAudioCodec(scanner);
                        break;
                    case 11:
                        izmenMB.setLanSpeed(scanner);
                        break;
                    case 12:
                        izmenMB.setHasWiFi(scanner);
                        break;
                    case 13:
                        izmenMB.setPowerConsumption(scanner);
                        break;
                    case 14:
                        izmenMB.setVoltage(scanner);
                        break;
                    case 15:
                        izmenMB.setCountryProduction(scanner);
                        break;
                    case 16:
                        izmenMB.setProductionDate(scanner);
                        break;
                    case 17:
                        izmenMB.setWarrantyMoths(scanner);
                        break;
                    case 18:
                        izmenMB.setRating(scanner);
                        break;
                    case 19:
                        izmenMB.setQuantityProduct(scanner);
                        break;
                    case 20:
                        izmenMB.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        mb.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenMB.getFullInfoForClient();

                        int printChoice;
                        boolean print = true;
                        while (print) {
                            System.out.print("\nВыберите одно из доступных действий:\n" +
                                    "1 - Сохранить все изменения\n" +
                                    "0 - Отменить изменения (оставить оригинал)\n" +
                                    "Ваш выбор:");

                            try {
                                printChoice = scanner.nextInt();

                                switch (printChoice) {
                                    case 1:
                                        MapMB.put(id, izmenMB);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenMB);

                                        FileManager.saveMotherBoard(MapMB);
                                        FileManager.saveProduct0(ProductMap);
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nВаши изменения были сохранены!");
                                        break;
                                    case 0:
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nИзменения были отменены!");
                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректное число!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public static void rewriteGPU(String id, Scanner scanner) {
        Map<String, GPU> MapGPU = FileManager.loadGPU();
        GPU gpu = MapGPU.get(id);

        Map<String, GPU> MapGPU2 = FileManager.loadGPU();
        GPU izmenGPU = MapGPU2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование видеокарты (" + gpu.getBrand() + " " + gpu.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenGPU.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Объем видеопамяти\n" +
                    "3 - Тип памяти\n" +
                    "4 - Количество CUDA ядер\n" +
                    "5 - Базовая частота\n" +
                    "6 - Турбо частота\n" +
                    "7 - Ширина шины памяти\n" +
                    "8 - Тип охлаждения\n" +
                    "9 - Количество разъемов питания\n" +
                    "10 - Версия PCIe\n" +
                    "11 - Видеовыходы\n" +
                    "12 - Потребляемая мощность\n" +
                    "13 - Рабочее напряжение\n" +
                    "14 - Страна-производитель\n" +
                    "15 - Год релиза\n" +
                    "16 - Гарантийный срок\n" +
                    "17 - Рейтинг\n" +
                    "18 - Количество на складе\n" +
                    "19 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenGPU.setPrice(scanner);
                        break;
                    case 2:
                        izmenGPU.setVramSize(scanner);
                        break;
                    case 3:
                        izmenGPU.setMemoryType(scanner);
                        break;
                    case 4:
                        izmenGPU.setCudaCores(scanner);
                        break;
                    case 5:
                        izmenGPU.setBaseFrequency(scanner);
                        break;
                    case 6:
                        izmenGPU.setBoostFrequency(scanner);
                        break;
                    case 7:
                        izmenGPU.setMemoryBusWidth(scanner);
                        break;
                    case 8:
                        izmenGPU.setCoolingType(scanner);
                        break;
                    case 9:
                        izmenGPU.setPowerConnectors(scanner);
                        break;
                    case 10:
                        izmenGPU.setTypePCIe(scanner);
                        break;
                    case 11:
                        izmenGPU.setVideoOutput(scanner);
                        break;
                    case 12:
                        izmenGPU.setPowerConsumption(scanner);
                        break;
                    case 13:
                        izmenGPU.setVoltage(scanner);
                        break;
                    case 14:
                        izmenGPU.setCountryProduction(scanner);
                        break;
                    case 15:
                        izmenGPU.setProductionDate(scanner);
                        break;
                    case 16:
                        izmenGPU.setWarrantyMoths(scanner);
                        break;
                    case 17:
                        izmenGPU.setRating(scanner);
                        break;
                    case 18:
                        izmenGPU.setQuantityProduct(scanner);
                        break;
                    case 19:
                        izmenGPU.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        gpu.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenGPU.getFullInfoForClient();

                        int printChoice;
                        boolean print = true;
                        while (print) {
                            System.out.print("\nВыберите одно из доступных действий:\n" +
                                    "1 - Сохранить все изменения\n" +
                                    "0 - Отменить изменения (оставить оригинал)\n" +
                                    "Ваш выбор:");

                            try {
                                printChoice = scanner.nextInt();

                                switch (printChoice) {
                                    case 1:
                                        MapGPU.put(id, izmenGPU);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenGPU);

                                        FileManager.saveGPU(MapGPU);
                                        FileManager.saveProduct0(ProductMap);
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nВаши изменения были сохранены!");
                                        break;
                                    case 0:
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nИзменения были отменены!");
                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректное число!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public static void rewriteRAM(String id, Scanner scanner) {
        Map<String, RAM> MapRAM = FileManager.loadRAM();
        RAM ram = MapRAM.get(id);

        Map<String, RAM> MapRAM2 = FileManager.loadRAM();
        RAM izmenRAM = MapRAM2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование оперативной памяти (" + ram.getBrand() + " " + ram.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenRAM.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Интерфейс подключения\n" +
                    "3 - Объем одного модуля\n" +
                    "4 - Частота\n" +
                    "5 - Тайминги (CL)\n" +
                    "6 - Тип памяти\n" +
                    "7 - Количество модулей в комплекте\n" +
                    "8 - RGB подсветка\n" +
                    "9 - Радиатор охлаждения\n" +
                    "10 - Потребляемая мощность\n" +
                    "11 - Рабочее напряжение\n" +
                    "12 - Страна-производитель\n" +
                    "13 - Год релиза\n" +
                    "14 - Гарантийный срок\n" +
                    "15 - Рейтинг\n" +
                    "16 - Количество на складе\n" +
                    "17 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenRAM.setPrice(scanner);
                        break;
                    case 2:
                        izmenRAM.setInterfaceType(scanner, izmenRAM.getCategory());
                        break;
                    case 3:
                        izmenRAM.setCapacity(scanner);
                        break;
                    case 4:
                        izmenRAM.setFrequency(scanner);
                        break;
                    case 5:
                        izmenRAM.setLatency(scanner);
                        break;
                    case 6:
                        izmenRAM.setMemoryType(scanner);
                        break;
                    case 7:
                        izmenRAM.setModulesCount(scanner);
                        break;
                    case 8:
                        izmenRAM.setHasRGB(scanner);
                        break;
                    case 9:
                        izmenRAM.setHasHeatSpreader(scanner);
                        break;
                    case 10:
                        izmenRAM.setPowerConsumption(scanner);
                        break;
                    case 11:
                        izmenRAM.setVoltage(scanner);
                        break;
                    case 12:
                        izmenRAM.setCountryProduction(scanner);
                        break;
                    case 13:
                        izmenRAM.setProductionDate(scanner);
                        break;
                    case 14:
                        izmenRAM.setWarrantyMoths(scanner);
                        break;
                    case 15:
                        izmenRAM.setRating(scanner);
                        break;
                    case 16:
                        izmenRAM.setQuantityProduct(scanner);
                        break;
                    case 17:
                        izmenRAM.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        ram.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenRAM.getFullInfoForClient();

                        int printChoice;
                        boolean print = true;
                        while (print) {
                            System.out.print("\nВыберите одно из доступных действий:\n" +
                                    "1 - Сохранить все изменения\n" +
                                    "0 - Отменить изменения (оставить оригинал)\n" +
                                    "Ваш выбор:");

                            try {
                                printChoice = scanner.nextInt();

                                switch (printChoice) {
                                    case 1:
                                        MapRAM.put(id, izmenRAM);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenRAM);

                                        FileManager.saveRAM(MapRAM);
                                        FileManager.saveProduct0(ProductMap);
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nВаши изменения были сохранены!");
                                        break;
                                    case 0:
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nИзменения были отменены!");
                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректное число!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public static void rewriteStorage(String id, Scanner scanner) {
        Map<String, Storage> MapStorage = FileManager.loadStorage();
        Storage storage = MapStorage.get(id);

        Map<String, Storage> MapStorage2 = FileManager.loadStorage();
        Storage izmenStorage = MapStorage2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование накопителя (" + storage.getBrand() + " " + storage.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenStorage.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Интерфейс подключения\n" +
                    "3 - Тип накопителя\n" +
                    "4 - Емкость\n" +
                    "5 - Форм-фактор\n" +
                    "6 - Скорость чтения\n" +
                    "7 - Скорость записи\n" +
                    "8 - Ресурс записи (TBW)\n" +
                    "9 - Размер кэша\n" +
                    "10 - Тип памяти NAND\n" +
                    "11 - Потребляемая мощность\n" +
                    "12 - Рабочее напряжение\n" +
                    "13 - Страна-производитель\n" +
                    "14 - Год релиза\n" +
                    "15 - Гарантийный срок\n" +
                    "16 - Рейтинг\n" +
                    "17 - Количество на складе\n" +
                    "18 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenStorage.setPrice(scanner);
                        break;
                    case 2:
                        izmenStorage.setInterfaceType(scanner, izmenStorage.getCategory());
                        break;
                    case 3:
                        izmenStorage.setStorageType(scanner);
                        break;
                    case 4:
                        izmenStorage.setCapacity(scanner);
                        break;
                    case 5:
                        izmenStorage.setFormFactor(scanner);
                        break;
                    case 6:
                        izmenStorage.setReadSpeed(scanner);
                        // После изменения скорости чтения нужно проверить скорость записи
                        if (izmenStorage.getWriteSpeed() > izmenStorage.getReadSpeed()) {
                            System.out.println("\nВнимание! Скорость записи (" + izmenStorage.getWriteSpeed() +
                                    " МБ/с) больше скорости чтения (" + izmenStorage.getReadSpeed() +
                                    " МБ/с). Рекомендуется изменить скорость записи.");
                        }
                        break;
                    case 7:
                        izmenStorage.setWriteSpeed(scanner);
                        break;
                    case 8:
                        izmenStorage.setTbw(scanner);
                        break;
                    case 9:
                        izmenStorage.setCacheSize(scanner);
                        break;
                    case 10:
                        izmenStorage.setNandType(scanner);
                        break;
                    case 11:
                        izmenStorage.setPowerConsumption(scanner);
                        break;
                    case 12:
                        izmenStorage.setVoltage(scanner);
                        break;
                    case 13:
                        izmenStorage.setCountryProduction(scanner);
                        break;
                    case 14:
                        izmenStorage.setProductionDate(scanner);
                        break;
                    case 15:
                        izmenStorage.setWarrantyMoths(scanner);
                        break;
                    case 16:
                        izmenStorage.setRating(scanner);
                        break;
                    case 17:
                        izmenStorage.setQuantityProduct(scanner);
                        break;
                    case 18:
                        izmenStorage.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        storage.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenStorage.getFullInfoForClient();

                        int printChoice;
                        boolean print = true;
                        while (print) {
                            System.out.print("\nВыберите одно из доступных действий:\n" +
                                    "1 - Сохранить все изменения\n" +
                                    "0 - Отменить изменения (оставить оригинал)\n" +
                                    "Ваш выбор:");

                            try {
                                printChoice = scanner.nextInt();

                                switch (printChoice) {
                                    case 1:
                                        MapStorage.put(id, izmenStorage);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenStorage);

                                        FileManager.saveStorage(MapStorage);
                                        FileManager.saveProduct0(ProductMap);
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nВаши изменения были сохранены!");
                                        break;
                                    case 0:
                                        print = false;
                                        Cycle = false;
                                        System.out.println("\nИзменения были отменены!");
                                        break;
                                    default:
                                        System.out.println("Такого варианта выбора нет!\n" +
                                                "Пожалуйста, введите корректное число!");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Произошла ошибка!\n" +
                                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                        "В прошлый раз вы ввели букву вместо числа!");
                                scanner.nextLine();
                            } catch (Exception a) {
                                System.out.println("Произошла неизвестная ошибка!");
                                scanner.nextLine();
                            }
                        }
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public static void reWriteTovarAndProduct(Scanner scanner){

        int removeChoice;
        boolean removeCycle = true;
        while(removeCycle)
        {
            System.out.println("\n+=+=+=+=+=+=+=+=+=+=+=+= Изменение товара =+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.print("\nВыберите одно из доступных действий:\n" +
                    "1 - Точно изменить товар\n" +
                    "0 - Вернуться назад\n" +
                    "Ваш выбор:");


            try {
                removeChoice = scanner.nextInt();
                scanner.nextLine();

                switch (removeChoice)
                {
                    case 1:
                        int removeRemoveChoice;
                        boolean removeRemoveCycle = true;
                        while(removeRemoveCycle)
                        {
                            Product product = searchProductForSeller();
                            boolean cycle = true;
                            while (cycle){
                                System.out.print("\nВы точно хотите продолжить процесс редактирования данного товара товара?\n" +
                                        "Введите 1 - если хотите продолжить процесс редактирования товара!\n" +
                                        "Введите 0 - если хотите прервать процесс редактирования!\n" +
                                        "Ваш выбор:");

                                try {
                                    removeRemoveChoice = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (removeRemoveChoice)
                                    {
                                        case 1:

                                            String ID = product.getId();
                                            String category = product.getCategory();

                                            switch (category){

                                                case "Центральный процессор":
                                                    rewriteCPU(ID,scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Материнская плата":
                                                    rewriteMotherBoard(ID,scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Видеокарта":
                                                    rewriteGPU(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case"Оперативная память":
                                                    rewriteRAM(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Постоянное запоминающее устройство":
                                                    rewriteStorage(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Блок питания":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Корпус":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Кулер":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Программное обеспечение":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Монитор":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Мышь":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Клавиатура":

                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;

                                            }

                                            System.out.println("\nРедактирование (отмена редактирований) товара прошли успешно!");

                                            break;
                                        case 0:
                                            System.out.println("\nРедактирование было отменено!");
                                            cycle = false;
                                            removeRemoveCycle = false;
                                            break;
                                        default:
                                            System.out.println("Такого варианта выбора нет!\n" +
                                                    "Пожалуйста, введите корректное число!");
                                    }

                                }catch (InputMismatchException e) {
                                    System.out.println("Произошла ошибка!\n" +
                                            "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                                            "В прошлый раз вы ввели букву вместо числа!");
                                    scanner.nextLine();
                                }
                                catch (Exception a) {
                                    System.out.println("Произошла неизвестная ошибка!");
                                    scanner.nextLine();
                                }
                            }


                        }
                        break;
                    case 0:
                        removeCycle = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }



    }





}
