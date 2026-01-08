import java.util.*;

public class ProductManager {

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
    public static Product searchProductForClient(){

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

        return product;


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
    public static void rewritePowerSupply(String id, Scanner scanner) {
        Map<String, PowerSupply> MapPowerSupply = FileManager.loadPowerSupply();
        PowerSupply powerSupply = MapPowerSupply.get(id);

        Map<String, PowerSupply> MapPowerSupply2 = FileManager.loadPowerSupply();
        PowerSupply izmenPowerSupply = MapPowerSupply2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование блока питания (" + powerSupply.getBrand() + " " + powerSupply.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenPowerSupply.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Сертификат эффективности\n" +
                    "3 - Модульность кабелей\n" +
                    "4 - Количество SATA разъемов\n" +
                    "5 - Количество PCI-E разъемов\n" +
                    "6 - Количество CPU разъемов\n" +
                    "7 - Размер вентилятора\n" +
                    "8 - Защиты\n" +
                    "9 - Потребляемая мощность\n" +
                    "10 - Рабочее напряжение\n" +
                    "11 - Страна-производитель\n" +
                    "12 - Год релиза\n" +
                    "13 - Гарантийный срок\n" +
                    "14 - Рейтинг\n" +
                    "15 - Количество на складе\n" +
                    "16 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenPowerSupply.setPrice(scanner);
                        break;
                    case 2:
                        izmenPowerSupply.setEfficiency(scanner);
                        break;
                    case 3:
                        izmenPowerSupply.setModularity(scanner);
                        break;
                    case 4:
                        izmenPowerSupply.setSataConnectors(scanner);
                        break;
                    case 5:
                        izmenPowerSupply.setPcieConnectors(scanner);
                        break;
                    case 6:
                        izmenPowerSupply.setCpuConnectors(scanner);
                        break;
                    case 7:
                        izmenPowerSupply.setFanSize(scanner);
                        break;
                    case 8:
                        izmenPowerSupply.setProtections(scanner);
                        break;
                    case 9:
                        izmenPowerSupply.setPowerConsumption(scanner);
                        break;
                    case 10:
                        izmenPowerSupply.setVoltage(scanner);
                        break;
                    case 11:
                        izmenPowerSupply.setCountryProduction(scanner);
                        break;
                    case 12:
                        izmenPowerSupply.setProductionDate(scanner);
                        break;
                    case 13:
                        izmenPowerSupply.setWarrantyMoths(scanner);
                        break;
                    case 14:
                        izmenPowerSupply.setRating(scanner);
                        break;
                    case 15:
                        izmenPowerSupply.setQuantityProduct(scanner);
                        break;
                    case 16:
                        izmenPowerSupply.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        powerSupply.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenPowerSupply.getFullInfoForClient();

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
                                        MapPowerSupply.put(id, izmenPowerSupply);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenPowerSupply);

                                        FileManager.savePowerSupply(MapPowerSupply);
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
    public static void rewriteCase(String id, Scanner scanner) {
        Map<String, Case> MapCase = FileManager.loadCase();
        Case caseObj = MapCase.get(id);

        Map<String, Case> MapCase2 = FileManager.loadCase();
        Case izmenCase = MapCase2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование корпуса (" + caseObj.getBrand() + " " + caseObj.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenCase.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Тип корпуса\n" +
                    "3 - Поддерживаемые форм-факторы материнских плат\n" +
                    "4 - Количество отсеков для 3.5\" дисков\n" +
                    "5 - Количество отсеков для 2.5\" дисков\n" +
                    "6 - Разъемы на передней панели\n" +
                    "7 - Наличие бокового стекла\n" +
                    "8 - Наличие RGB подсветки\n" +
                    "9 - Наличие пылевых фильтров\n" +
                    "10 - Страна-производитель\n" +
                    "11 - Год релиза\n" +
                    "12 - Гарантийный срок\n" +
                    "13 - Рейтинг\n" +
                    "14 - Количество на складе\n" +
                    "15 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenCase.setPrice(scanner);
                        break;
                    case 2:
                        izmenCase.setCaseType(scanner);
                        break;
                    case 3:
                        izmenCase.setMotherboardFormFactor(scanner);
                        break;
                    case 4:
                        izmenCase.setDriveBays35(scanner);
                        break;
                    case 5:
                        izmenCase.setDriveBays25(scanner);
                        break;
                    case 6:
                        izmenCase.setFrontPanel(scanner);
                        break;
                    case 7:
                        izmenCase.setHasTemperedGlass(scanner);
                        break;
                    case 8:
                        izmenCase.setHasRGB(scanner);
                        break;
                    case 9:
                        izmenCase.setHasDustFilters(scanner);
                        break;
                    case 10:
                        izmenCase.setCountryProduction(scanner);
                        break;
                    case 11:
                        izmenCase.setProductionDate(scanner);
                        break;
                    case 12:
                        izmenCase.setWarrantyMoths(scanner);
                        break;
                    case 13:
                        izmenCase.setRating(scanner);
                        break;
                    case 14:
                        izmenCase.setQuantityProduct(scanner);
                        break;
                    case 15:
                        izmenCase.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        caseObj.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenCase.getFullInfoForClient();

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
                                        MapCase.put(id, izmenCase);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenCase);

                                        FileManager.saveCase(MapCase);
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
    public static void rewriteCooler(String id, Scanner scanner) {
        Map<String, Cooler> MapCooler = FileManager.loadCooler();
        Cooler cooler = MapCooler.get(id);

        Map<String, Cooler> MapCooler2 = FileManager.loadCooler();
        Cooler izmenCooler = MapCooler2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование системы охлаждения (" + cooler.getBrand() + " " + cooler.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenCooler.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Тип кулера\n" +
                    "3 - Совместимые сокеты\n" +
                    "4 - Размер вентилятора\n" +
                    "5 - Скорость вращения вентилятора\n" +
                    "6 - Рассеиваемая мощность (TDP)\n" +
                    "7 - Количество тепловых трубок\n" +
                    "8 - Поддержка PWM\n" +
                    "9 - Наличие RGB подсветки\n" +
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
                        izmenCooler.setPrice(scanner);
                        break;
                    case 2:
                        izmenCooler.setCoolerType(scanner);
                        break;
                    case 3:
                        izmenCooler.setSocketCompatibility(scanner);
                        break;
                    case 4:
                        izmenCooler.setFanSize(scanner);
                        break;
                    case 5:
                        izmenCooler.setFanSpeed(scanner);
                        break;
                    case 6:
                        izmenCooler.setTdp(scanner);
                        break;
                    case 7:
                        izmenCooler.setHeatPipes(scanner);
                        break;
                    case 8:
                        izmenCooler.setHasPwm(scanner);
                        break;
                    case 9:
                        izmenCooler.setHasRGB(scanner);
                        break;
                    case 10:
                        izmenCooler.setPowerConsumption(scanner);
                        break;
                    case 11:
                        izmenCooler.setVoltage(scanner);
                        break;
                    case 12:
                        izmenCooler.setCountryProduction(scanner);
                        break;
                    case 13:
                        izmenCooler.setProductionDate(scanner);
                        break;
                    case 14:
                        izmenCooler.setWarrantyMoths(scanner);
                        break;
                    case 15:
                        izmenCooler.setRating(scanner);
                        break;
                    case 16:
                        izmenCooler.setQuantityProduct(scanner);
                        break;
                    case 17:
                        izmenCooler.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        cooler.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenCooler.getFullInfoForClient();

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
                                        MapCooler.put(id, izmenCooler);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenCooler);

                                        FileManager.saveCooler(MapCooler);
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
    public static void rewriteSoftware(String id, Scanner scanner) {
        Map<String, Software> MapSoftware = FileManager.loadSoftware();
        Software software = MapSoftware.get(id);

        Map<String, Software> MapSoftware2 = FileManager.loadSoftware();
        Software izmenSoftware = MapSoftware2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование программного обеспечения (" + software.getBrand() + " " + software.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenSoftware.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Тип программного обеспечения\n" +
                    "3 - Срок лицензии\n" +
                    "4 - Поддерживаемые операционные системы\n" +
                    "5 - Системные требования\n" +
                    "6 - Тип версии (цифровая/коробочная)\n" +
                    "7 - Поддерживаемые языки\n" +
                    "8 - Страна-производитель\n" +
                    "9 - Год релиза\n" +
                    "10 - Гарантийный срок\n" +
                    "11 - Рейтинг\n" +
                    "12 - Количество на складе\n" +
                    "13 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenSoftware.setPrice(scanner);
                        break;
                    case 2:
                        izmenSoftware.setSoftwareType(scanner);
                        break;
                    case 3:
                        izmenSoftware.setLicenseDuration(scanner);
                        break;
                    case 4:
                        izmenSoftware.setSupportedOS(scanner);
                        break;
                    case 5:
                        izmenSoftware.setSystemRequirements(scanner);
                        break;
                    case 6:
                        izmenSoftware.setIsDigital(scanner);
                        break;
                    case 7:
                        izmenSoftware.setLanguages(scanner);
                        break;
                    case 8:
                        izmenSoftware.setCountryProduction(scanner);
                        break;
                    case 9:
                        izmenSoftware.setProductionDate(scanner);
                        break;
                    case 10:
                        izmenSoftware.setWarrantyMoths(scanner);
                        break;
                    case 11:
                        izmenSoftware.setRating(scanner);
                        break;
                    case 12:
                        izmenSoftware.setQuantityProduct(scanner);
                        break;
                    case 13:
                        izmenSoftware.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        software.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenSoftware.getFullInfoForClient();

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
                                        MapSoftware.put(id, izmenSoftware);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenSoftware);

                                        FileManager.saveSoftware(MapSoftware);
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
    public static void rewriteMonitor(String id, Scanner scanner) {
        Map<String, Monitor> MapMonitor = FileManager.loadMonitor();
        Monitor monitor = MapMonitor.get(id);

        Map<String, Monitor> MapMonitor2 = FileManager.loadMonitor();
        Monitor izmenMonitor = MapMonitor2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование монитора (" + monitor.getBrand() + " " + monitor.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenMonitor.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Диагональ экрана\n" +
                    "3 - Разрешение\n" +
                    "4 - Частота обновления\n" +
                    "5 - Тип матрицы\n" +
                    "6 - Время отклика\n" +
                    "7 - Поддержка HDR\n" +
                    "8 - Наличие встроенных колонок\n" +
                    "9 - Цвет устройства\n" +
                    "10 - Типы подключения\n" +
                    "11 - Длина кабеля\n" +
                    "12 - Беспроводное подключение\n" +
                    "13 - Наличие RGB подсветки\n" +
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
                        izmenMonitor.setPrice(scanner);
                        break;
                    case 2:
                        izmenMonitor.setScreenSize(scanner);
                        break;
                    case 3:
                        izmenMonitor.setResolution(scanner);
                        break;
                    case 4:
                        izmenMonitor.setRefreshRate(scanner);
                        break;
                    case 5:
                        izmenMonitor.setPanelType(scanner);
                        break;
                    case 6:
                        izmenMonitor.setResponseTime(scanner);
                        break;
                    case 7:
                        izmenMonitor.setHasHDR(scanner);
                        break;
                    case 8:
                        izmenMonitor.setHasBuiltInSpeakers(scanner);
                        break;
                    case 9:
                        izmenMonitor.setColor(scanner);
                        break;
                    case 10:
                        izmenMonitor.setConnectionType(scanner);
                        break;
                    case 11:
                        izmenMonitor.setCableLength(scanner);
                        break;
                    case 12:
                        izmenMonitor.setIsWireless(scanner);
                        break;
                    case 13:
                        izmenMonitor.setHasRGB(scanner);
                        break;
                    case 14:
                        izmenMonitor.setCountryProduction(scanner);
                        break;
                    case 15:
                        izmenMonitor.setProductionDate(scanner);
                        break;
                    case 16:
                        izmenMonitor.setWarrantyMoths(scanner);
                        break;
                    case 17:
                        izmenMonitor.setRating(scanner);
                        break;
                    case 18:
                        izmenMonitor.setQuantityProduct(scanner);
                        break;
                    case 19:
                        izmenMonitor.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        monitor.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenMonitor.getFullInfoForClient();

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
                                        MapMonitor.put(id, izmenMonitor);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenMonitor);

                                        FileManager.saveMonitor(MapMonitor);
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
    public static void rewriteMouse(String id, Scanner scanner) {
        Map<String, Mouse> MapMouse = FileManager.loadMouse();
        Mouse mouse = MapMouse.get(id);

        Map<String, Mouse> MapMouse2 = FileManager.loadMouse();
        Mouse izmenMouse = MapMouse2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование мыши (" + mouse.getBrand() + " " + mouse.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenMouse.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Чувствительность (DPI)\n" +
                    "3 - Количество кнопок\n" +
                    "4 - Тип сенсора\n" +
                    "5 - Тип мыши (игровая/обычная)\n" +
                    "6 - Цвет устройства\n" +
                    "7 - Типы подключения\n" +
                    "8 - Длина кабеля\n" +
                    "9 - Беспроводное подключение\n" +
                    "10 - Наличие RGB подсветки\n" +
                    "11 - Страна-производитель\n" +
                    "12 - Год релиза\n" +
                    "13 - Гарантийный срок\n" +
                    "14 - Рейтинг\n" +
                    "15 - Количество на складе\n" +
                    "16 - Описание\n" +
                    "0 - Прекратить редактирование\n" +
                    "Ваш выбор:");

            try {
                Choice = scanner.nextInt();
                scanner.nextLine();

                switch (Choice) {
                    case 1:
                        izmenMouse.setPrice(scanner);
                        break;
                    case 2:
                        izmenMouse.setDpi(scanner);
                        break;
                    case 3:
                        izmenMouse.setButtonsCount(scanner);
                        break;
                    case 4:
                        izmenMouse.setSensorType(scanner);
                        break;
                    case 5:
                        izmenMouse.setIsGaming(scanner);
                        break;
                    case 6:
                        izmenMouse.setColor(scanner);
                        break;
                    case 7:
                        izmenMouse.setConnectionType(scanner);
                        break;
                    case 8:
                        izmenMouse.setCableLength(scanner);
                        break;
                    case 9:
                        izmenMouse.setIsWireless(scanner);  // Исправлено на setIsWireless
                        break;
                    case 10:
                        izmenMouse.setHasRGB(scanner);
                        break;
                    case 11:
                        izmenMouse.setCountryProduction(scanner);
                        break;
                    case 12:
                        izmenMouse.setProductionDate(scanner);
                        break;
                    case 13:
                        izmenMouse.setWarrantyMoths(scanner);
                        break;
                    case 14:
                        izmenMouse.setRating(scanner);
                        break;
                    case 15:
                        izmenMouse.setQuantityProduct(scanner);
                        break;
                    case 16:
                        izmenMouse.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        mouse.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenMouse.getFullInfoForClient();

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
                                        MapMouse.put(id, izmenMouse);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenMouse);

                                        FileManager.saveMouse(MapMouse);
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
    public static void rewriteKeyboard(String id, Scanner scanner) {
        Map<String, Keyboard> MapKeyboard = FileManager.loadKeyboard();
        Keyboard keyboard = MapKeyboard.get(id);

        Map<String, Keyboard> MapKeyboard2 = FileManager.loadKeyboard();
        Keyboard izmenKeyboard = MapKeyboard2.get(id);

        int Choice;
        boolean Cycle = true;
        while (Cycle) {
            System.out.println("\n\n+-+-+-+-+-+-+-+--Редактирование клавиатуры (" + keyboard.getBrand() + " " + keyboard.getModel() + " ID: " + id + ")--+-+-+-+-+-+-+-+");
            izmenKeyboard.getFullInfoForClient();
            System.out.print("\nВыберите номер поля, которое собрались редактировать:\n" +
                    "(Или введите 0, если вы уже отредактировали всё, что нужно):\n" +
                    "1 - Цена\n" +
                    "2 - Тип клавиатуры\n" +
                    "3 - Количество клавиш\n" +
                    "4 - Тип переключателей\n" +
                    "5 - Раскладка клавиатуры\n" +
                    "6 - Наличие цифрового блока\n" +
                    "7 - Цвет устройства\n" +
                    "8 - Типы подключения\n" +
                    "9 - Длина кабеля\n" +
                    "10 - Беспроводное подключение\n" +
                    "11 - Наличие RGB подсветки\n" +
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
                        izmenKeyboard.setPrice(scanner);
                        break;
                    case 2:
                        izmenKeyboard.setKeyboardType(scanner);
                        // После изменения типа клавиатуры может измениться доступность типа переключателей
                        if (!"Механическая".equals(izmenKeyboard.getKeyboardType()) &&
                                !"Нет".equals(izmenKeyboard.getSwitchType())) {
                            izmenKeyboard.setSwitchType(scanner); // Перезапросим тип переключателей
                        }
                        break;
                    case 3:
                        izmenKeyboard.setCountKey(scanner);
                        break;
                    case 4:
                        izmenKeyboard.setSwitchType(scanner);
                        break;
                    case 5:
                        izmenKeyboard.setLayout(scanner);
                        break;
                    case 6:
                        izmenKeyboard.setHasNumpad(scanner);
                        break;
                    case 7:
                        izmenKeyboard.setColor(scanner);
                        break;
                    case 8:
                        izmenKeyboard.setConnectionType(scanner);
                        break;
                    case 9:
                        izmenKeyboard.setCableLength(scanner);
                        break;
                    case 10:
                        izmenKeyboard.setIsWireless(scanner);
                        break;
                    case 11:
                        izmenKeyboard.setHasRGB(scanner);
                        break;
                    case 12:
                        izmenKeyboard.setCountryProduction(scanner);
                        break;
                    case 13:
                        izmenKeyboard.setProductionDate(scanner);
                        break;
                    case 14:
                        izmenKeyboard.setWarrantyMoths(scanner);
                        break;
                    case 15:
                        izmenKeyboard.setRating(scanner);
                        break;
                    case 16:
                        izmenKeyboard.setQuantityProduct(scanner);
                        break;
                    case 17:
                        izmenKeyboard.setDescription(scanner);
                        break;
                    case 0:
                        System.out.println("\n======================== Исходный вариант =========================");
                        keyboard.getFullInfoForClient();
                        System.out.println("\n======================== Конечный вариант =========================");
                        izmenKeyboard.getFullInfoForClient();

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
                                        MapKeyboard.put(id, izmenKeyboard);
                                        Map<String, Product> ProductMap = FileManager.loadProduct0();
                                        ProductMap.put(id, izmenKeyboard);

                                        FileManager.saveKeyboard(MapKeyboard);
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
                                                    rewritePowerSupply(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Корпус":
                                                    rewriteCase(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Кулер":
                                                    rewriteCooler(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Программное обеспечение":
                                                    rewriteSoftware(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Монитор":
                                                    rewriteMonitor(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Мышь":
                                                    rewriteMouse(ID, scanner);
                                                    cycle = false;
                                                    removeRemoveCycle = false;
                                                    break;
                                                case "Клавиатура":
                                                    rewriteKeyboard(ID, scanner);
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

    public static boolean buyProductTovar(Product product,Client client, Scanner scanner){

        Map<String, Product> allProducts = FileManager.loadProduct0();
        boolean buy = true;
        Product freshProduct = allProducts.get(product.getId());
        if(freshProduct == null){
            System.out.println("\nДанный товар уже отсутствует в каталоге!\n" +
                    "Покупка невозможна!");
            buy = false;


        }else{
            product.setQuantityProduct(freshProduct.getQuantityProduct());

            boolean cycle = true;
            while(cycle){


                if(product.getQuantityProduct()==0){
                    System.out.println("\nВы временно не можете купить данный товар!\n" +
                            "Данный товар на данный момент отсутствует на складе!");
                    cycle = false;
                    buy = false;
                }else{

                    if(product.getPrice()<=client.getBalance()){



                        int replayChoice;
                        boolean replayCycle = true;
                        while(replayCycle)
                        {
                            System.out.print("\nВы подтверждаете покупку товара?\n" +
                                    "(Подтверждаете, что совершаете покупку товара осознано, без внешнего принуждающего воздействия)\n" +
                                    "В случае успешной покупки, купленный вами товар отобразится в вашем списке покупок,\n" +
                                    "а с вашего счёта спишется " + product.getPrice()+" рублей(ля)\n" +
                                    "Выберите одно из доступных действий:\n" +
                                    "1 - Подтвердить и завершить процесс покупки\n" +
                                    "0 - Прервать процесс покупки\n" +
                                    "Ваш выбор:");


                            try {
                                replayChoice = scanner.nextInt();
                                scanner.nextLine();

                                switch (replayChoice)
                                {
                                    case 1:

                                        String category = product.getCategory();
                                        String id = product.getId();
                                        int quantity = product.getQuantityProduct();
                                        Map<String, Product> products = FileManager.loadProduct0();

                                        switch (category)
                                        {
                                            case "Центральный процессор":
                                                Map<String, CPU> cpuMap= FileManager.loadCPU();
                                                CPU cpu = cpuMap.get(id);
                                                cpu.setPayDate(new Date());
                                                cpu.setQuantityProduct(quantity-1);
                                                products.put(id, cpu);
                                                cpuMap.put(id,cpu);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveCPU(cpuMap);
                                                client.addShoppingList(cpu);
                                                break;
                                            case "Материнская плата":
                                                Map<String, MotherBoard> MotherBoardMap= FileManager.loadMotherBoard();
                                                MotherBoard MotherBoard = MotherBoardMap.get(id);
                                                MotherBoard.setPayDate(new Date());
                                                MotherBoard.setQuantityProduct(quantity-1);
                                                products.put(id, MotherBoard);
                                                MotherBoardMap.put(id,MotherBoard);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveMotherBoard(MotherBoardMap);
                                                client.addShoppingList(MotherBoard);
                                                break;
                                            case "Видеокарта":
                                                Map<String, GPU> GPUMap= FileManager.loadGPU();
                                                GPU GPU = GPUMap.get(id);
                                                GPU.setPayDate(new Date());
                                                GPU.setQuantityProduct(quantity-1);
                                                products.put(id,GPU);
                                                GPUMap.put(id,GPU);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveGPU(GPUMap);
                                                client.addShoppingList(GPU);
                                                break;
                                            case"Оперативная память":
                                                Map<String, RAM> RAMMap= FileManager.loadRAM();
                                                RAM RAM = RAMMap.get(id);
                                                RAM.setPayDate(new Date());
                                                RAM.setQuantityProduct(quantity-1);
                                                products.put(id, RAM);
                                                RAMMap.put(id,RAM);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveRAM(RAMMap);
                                                client.addShoppingList(RAM);
                                                break;
                                            case "Постоянное запоминающее устройство":
                                                Map<String, Storage> StorageMap= FileManager.loadStorage();
                                                Storage Storage = StorageMap.get(id);
                                                Storage.setPayDate(new Date());
                                                Storage.setQuantityProduct(quantity-1);
                                                products.put(id, Storage);
                                                StorageMap.put(id,Storage);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveStorage(StorageMap);
                                                client.addShoppingList(Storage);
                                                break;
                                            case "Блок питания":
                                                Map<String, PowerSupply> PowerSupplyMap= FileManager.loadPowerSupply();
                                                PowerSupply PowerSupply = PowerSupplyMap.get(id);
                                                PowerSupply.setPayDate(new Date());
                                                PowerSupply.setQuantityProduct(quantity-1);
                                                products.put(id, PowerSupply);
                                                PowerSupplyMap.put(id,PowerSupply);
                                                FileManager.saveProduct0(products);
                                                FileManager.savePowerSupply(PowerSupplyMap);
                                                client.addShoppingList(PowerSupply);
                                                break;
                                            case "Корпус":
                                                Map<String, Case> CaseMap= FileManager.loadCase();
                                                Case Case = CaseMap.get(id);
                                                Case.setPayDate(new Date());
                                                Case.setQuantityProduct(quantity-1);
                                                products.put(id, Case);
                                                CaseMap.put(id,Case);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveCase(CaseMap);
                                                client.addShoppingList(Case);
                                                break;
                                            case "Кулер":
                                                Map<String, Cooler> CoolerMap= FileManager.loadCooler();
                                                Cooler Cooler = CoolerMap.get(id);
                                                Cooler.setPayDate(new Date());
                                                Cooler.setQuantityProduct(quantity-1);
                                                products.put(id, Cooler);
                                                CoolerMap.put(id,Cooler);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveCooler(CoolerMap);
                                                client.addShoppingList(Cooler);
                                                break;
                                            case "Программное обеспечение":
                                                Map<String, Software> SoftwareMap= FileManager.loadSoftware();
                                                Software Software = SoftwareMap.get(id);
                                                Software.setPayDate(new Date());
                                                Software.setQuantityProduct(quantity-1);
                                                products.put(id, Software);
                                                SoftwareMap.put(id,Software);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveSoftware(SoftwareMap);
                                                client.addShoppingList(Software);
                                                break;
                                            case "Монитор":
                                                Map<String, Monitor> MonitorMap= FileManager.loadMonitor();
                                                Monitor Monitor = MonitorMap.get(id);
                                                Monitor.setPayDate(new Date());
                                                Monitor.setQuantityProduct(quantity-1);
                                                products.put(id, Monitor);
                                                MonitorMap.put(id,Monitor);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveMonitor(MonitorMap);
                                                client.addShoppingList(Monitor);
                                                break;
                                            case "Мышь":
                                                Map<String, Mouse> MouseMap= FileManager.loadMouse();
                                                Mouse Mouse = MouseMap.get(id);
                                                Mouse.setPayDate(new Date());
                                                Mouse.setQuantityProduct(quantity-1);
                                                products.put(id, Mouse);
                                                MouseMap.put(id,Mouse);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveMouse(MouseMap);
                                                client.addShoppingList(Mouse);
                                                break;
                                            case "Клавиатура":
                                                Map<String, Keyboard> KeyboardMap= FileManager.loadKeyboard();
                                                Keyboard Keyboard = KeyboardMap.get(id);
                                                Keyboard.setPayDate(new Date());
                                                Keyboard.setQuantityProduct(quantity-1);
                                                products.put(id, Keyboard);
                                                KeyboardMap.put(id,Keyboard);
                                                FileManager.saveProduct0(products);
                                                FileManager.saveKeyboard(KeyboardMap);
                                                client.addShoppingList(Keyboard);

                                                break;
                                        }

                                        client.deductBalance(product.getPrice());
                                        FileManager.rewriteClient(client);

                                        System.out.println("\nПокупка товара прошла успешна!");
                                        replayCycle = false;
                                        cycle = false;


                                        break;

                                    case 0:
                                        replayCycle = false;
                                        cycle = false;
                                        buy = false;
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



                    }else{

                        int dodepChoice;
                        double difference = product.getPrice()- client.getBalance();
                        boolean dodepCycle = true;
                        while(dodepCycle)
                        {
                            System.out.print("\nНа вашем балансе недостаточно средств!\n" +
                                    "Ваш текущий баланс составляет: " + client.getBalance()+ " рублей(ля)!\n\n" +
                                    "Для продолжения процесса покупки необходимо пополнить баланс минимум на " + difference+ " рублей(ля)!\n" +
                                    "Выберите одно из доступных действий:\n" +
                                    "1 - пополнить баланс на "+ difference+ " рублей(ля)\n" +
                                    "0 - Прервать процесс покупки\n" +
                                    "Ваш выбор:");


                            try {
                                dodepChoice = scanner.nextInt();
                                scanner.nextLine();

                                switch (dodepChoice)
                                {
                                    case 1:
                                        client.addBalance(difference);
                                        FileManager.rewriteClient(client);
                                        dodepCycle = false;
                                        break;
                                    case 0:
                                        dodepCycle = false;
                                        cycle = false;
                                        buy = false;
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



            }


        }
        return buy;




    }

}
