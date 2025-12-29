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


    public static Peripheral registrationPeripheral(String choiceCategory) {
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

        String connectionType = null;
        double cableLength = 0.0;
        boolean isWireless = false;
        boolean hasRGB = false;
        String color = null;

        // Тип подключения
        boolean cycleConnectionType = true;
        while (cycleConnectionType) {
            System.out.print("\nВыберите тип подключения:\n" +
                    "1 - USB\n" +
                    "2 - USB-C\n" +
                    "3 - HDMI\n" +
                    "4 - DisplayPort\n" +
                    "5 - Bluetooth\n" +
                    "6 - Wireless (2.4 ГГц)\n" +
                    "7 - PS/2 (для клавиатур)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        connectionType = "USB";
                        cycleConnectionType = false;
                        break;
                    case 2:
                        connectionType = "USB-C";
                        cycleConnectionType = false;
                        break;
                    case 3:
                        connectionType = "HDMI";
                        cycleConnectionType = false;
                        break;
                    case 4:
                        connectionType = "DisplayPort";
                        cycleConnectionType = false;
                        break;
                    case 5:
                        connectionType = "Bluetooth";
                        cycleConnectionType = false;
                        break;
                    case 6:
                        connectionType = "Wireless (2.4 ГГц)";
                        cycleConnectionType = false;
                        break;
                    case 7:
                        connectionType = "PS/2";
                        cycleConnectionType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Беспроводное устройство или проводное
        boolean cycleIsWireless = true;
        while (cycleIsWireless) {
            System.out.print("\nЭто беспроводное устройство?\n" +
                    "Введите:\n" +
                    "1 - Да, беспроводное\n" +
                    "0 - Нет, проводное\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        isWireless = false;
                        cycleIsWireless = false;
                        break;
                    case 1:
                        isWireless = true;
                        cycleIsWireless = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Длина кабеля (если устройство проводное)
        if (!isWireless) {
            boolean cycleCableLength = true;
            while (cycleCableLength) {
                System.out.print("\nВведите длину кабеля в метрах (0.5 - 3.0): ");

                try {
                    cableLength = scanner.nextDouble();
                    scanner.nextLine();

                    while (cableLength < 0.5 || cableLength > 3.0) {
                        System.out.print("\nНекорректная длина кабеля!\n" +
                                "Введите значение ещё раз (0.5 - 3.0 метра): ");
                        cableLength = scanner.nextDouble();
                        scanner.nextLine();
                    }

                    cycleCableLength = false;

                } catch (InputMismatchException p) {
                    System.out.println("Произошла ошибка!\n" +
                            "Пожалуйста, введите корректное значение!\n" +
                            "В прошлый раз вы ввели букву вместо числа!");
                    scanner.nextLine();
                } catch (Exception p) {
                    System.out.println("Произошла неизвестная ошибка!");
                    scanner.nextLine();
                }
            }
        } else {
            cableLength = 0.0; // Для беспроводных устройств длина кабеля = 0
        }

        // Наличие RGB подсветки
        boolean cycleHasRGB = true;
        while (cycleHasRGB) {
            System.out.print("\nЕсть ли у устройства RGB подсветка?\n" +
                    "Введите:\n" +
                    "1 - если RGB подсветка присутствует\n" +
                    "0 - если RGB подсветка отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasRGB = false;
                        cycleHasRGB = false;
                        break;
                    case 1:
                        hasRGB = true;
                        cycleHasRGB = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Цвет устройства
        boolean cycleColor = true;
        while (cycleColor) {
            System.out.print("\nВыберите цвет устройства:\n" +
                    "1 - Черный\n" +
                    "2 - Белый\n" +
                    "3 - Серый\n" +
                    "4 - Красный\n" +
                    "5 - Синий\n" +
                    "6 - Зеленый\n" +
                    "7 - Другой цвет (введите название)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        color = "Черный";
                        cycleColor = false;
                        break;
                    case 2:
                        color = "Белый";
                        cycleColor = false;
                        break;
                    case 3:
                        color = "Серый";
                        cycleColor = false;
                        break;
                    case 4:
                        color = "Красный";
                        cycleColor = false;
                        break;
                    case 5:
                        color = "Синий";
                        cycleColor = false;
                        break;
                    case 6:
                        color = "Зеленый";
                        cycleColor = false;
                        break;
                    case 7:
                        System.out.print("Введите название цвета: ");
                        color = scanner.nextLine();
                        if (color.trim().isEmpty()) {
                            System.out.println("Цвет не может быть пустым!");
                            continue;
                        }
                        cycleColor = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        return new Peripheral(
                id, brand, model, connectionType,
                cableLength, isWireless, hasRGB,
                color, countryProduction, productionDate,
                price, category, description, warrantyMoths
        );
    }


    public static void registrationMonitor(String choiceCategory){

        Peripheral peripheral = registrationPeripheral(choiceCategory);
        Scanner scanner = new Scanner(System.in);

        String id = peripheral.getId();
        String brand = peripheral.getBrand();
        String model = peripheral.getModel();
        String countryProduction = peripheral.getCountryProduction();
        int productionDate = peripheral.getProductionDate();
        int price = peripheral.getPrice();
        String description = peripheral.getDescription();
        int warrantyMoths = peripheral.getWarrantyMoths();
        String category = peripheral.getCategory();
        String connectionType = peripheral.getConnectionType();
        double cableLength = peripheral.getCableLength();
        boolean isWireless = peripheral.isWireless();
        boolean hasRGB = peripheral.isHasRGB();
        String color = peripheral.getColor();

        double screenSize = 0.0;
        String resolution = null;
        int refreshRate = 0;
        String panelType = null;
        int responseTime = 0;
        boolean hasHDR = false;
        boolean hasBuiltInSpeakers = false;

        // Диагональ экрана
        boolean cycleScreenSize = true;
        while (cycleScreenSize) {
            System.out.print("\nВведите диагональ экрана в дюймах (15.6, 21.5, 24, 27, 32, 34, 49): ");

            try {
                screenSize = scanner.nextDouble();
                scanner.nextLine();

                double[] validSizes = {15.6, 21.5, 24, 27, 32, 34, 49};
                boolean isValid = false;

                for (double size : validSizes) {
                    if (Math.abs(screenSize - size) < 0.1) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная диагональ экрана!\n" +
                            "Введите значение ещё раз (15.6, 21.5, 24, 27, 32, 34, 49 дюймов): ");
                    screenSize = scanner.nextDouble();
                    scanner.nextLine();

                    for (double size : validSizes) {
                        if (Math.abs(screenSize - size) < 0.1) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleScreenSize = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Разрешение экрана
        boolean cycleResolution = true;
        while (cycleResolution) {
            System.out.print("\nВыберите разрешение экрана:\n" +
                    "1 - 1920x1080 (Full HD)\n" +
                    "2 - 2560x1440 (QHD / 2K)\n" +
                    "3 - 3840x2160 (4K UHD)\n" +
                    "4 - 3440x1440 (UltraWide QHD)\n" +
                    "5 - 5120x1440 (Super UltraWide)\n" +
                    "6 - 2560x1080 (UltraWide Full HD)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        resolution = "1920x1080 (Full HD)";
                        cycleResolution = false;
                        break;
                    case 2:
                        resolution = "2560x1440 (QHD / 2K)";
                        cycleResolution = false;
                        break;
                    case 3:
                        resolution = "3840x2160 (4K UHD)";
                        cycleResolution = false;
                        break;
                    case 4:
                        resolution = "3440x1440 (UltraWide QHD)";
                        cycleResolution = false;
                        break;
                    case 5:
                        resolution = "5120x1440 (Super UltraWide)";
                        cycleResolution = false;
                        break;
                    case 6:
                        resolution = "2560x1080 (UltraWide Full HD)";
                        cycleResolution = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Частота обновления
        boolean cycleRefreshRate = true;
        while (cycleRefreshRate) {
            System.out.print("\nВведите частоту обновления экрана в Гц (60, 75, 100, 120, 144, 165, 180, 240, 360): ");

            try {
                refreshRate = scanner.nextInt();
                scanner.nextLine();

                int[] validRates = {60, 75,100, 120, 144, 165, 180, 240, 360};
                boolean isValid = false;

                for (int rate : validRates) {
                    if (refreshRate == rate) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная частота обновления!\n" +
                            "Введите значение ещё раз (60, 75, 120, 144, 165, 240, 360 Гц): ");
                    refreshRate = scanner.nextInt();
                    scanner.nextLine();

                    for (int rate : validRates) {
                        if (refreshRate == rate) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleRefreshRate = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Тип матрицы
        boolean cyclePanelType = true;
        while (cyclePanelType) {
            System.out.print("\nВыберите тип матрицы:\n" +
                    "1 - IPS\n" +
                    "2 - VA\n" +
                    "3 - TN\n" +
                    "4 - OLED\n" +
                    "5 - Nano-IPS\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        panelType = "IPS";
                        cyclePanelType = false;
                        break;
                    case 2:
                        panelType = "VA";
                        cyclePanelType = false;
                        break;
                    case 3:
                        panelType = "TN";
                        cyclePanelType = false;
                        break;
                    case 4:
                        panelType = "OLED";
                        cyclePanelType = false;
                        break;
                    case 5:
                        panelType = "Nano-IPS";
                        cyclePanelType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Время отклика
        boolean cycleResponseTime = true;
        while (cycleResponseTime) {
            System.out.print("\nВведите время отклика в миллисекундах (1, 2, 4, 5, 8): ");

            try {
                responseTime = scanner.nextInt();
                scanner.nextLine();

                int[] validTimes = {1, 2, 4, 5, 8};
                boolean isValid = false;

                for (int time : validTimes) {
                    if (responseTime == time) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное время отклика!\n" +
                            "Введите значение ещё раз (1, 2, 4, 5, 8 мс): ");
                    responseTime = scanner.nextInt();
                    scanner.nextLine();

                    for (int time : validTimes) {
                        if (responseTime == time) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleResponseTime = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Поддержка HDR
        boolean cycleHasHDR = true;
        while (cycleHasHDR) {
            System.out.print("\nПоддерживает ли монитор HDR?\n" +
                    "Введите:\n" +
                    "1 - если HDR поддерживается\n" +
                    "0 - если HDR не поддерживается\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasHDR = false;
                        cycleHasHDR = false;
                        break;
                    case 1:
                        hasHDR = true;
                        cycleHasHDR = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Встроенные колонки
        boolean cycleHasBuiltInSpeakers = true;
        while (cycleHasBuiltInSpeakers) {
            System.out.print("\nЕсть ли у монитора встроенные колонки?\n" +
                    "Введите:\n" +
                    "1 - если встроенные колонки присутствуют\n" +
                    "0 - если встроенные колонки отсутствуют\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasBuiltInSpeakers = false;
                        cycleHasBuiltInSpeakers = false;
                        break;
                    case 1:
                        hasBuiltInSpeakers = true;
                        cycleHasBuiltInSpeakers = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        Map<String, Monitor> monitors = FileManager.loadMonitor();
        monitors.put(id, new Monitor(
                id, brand, model,
                screenSize, resolution,
                refreshRate, panelType,
                responseTime, hasHDR,
                hasBuiltInSpeakers,
                connectionType, cableLength,
                isWireless, hasRGB,
                color, countryProduction,
                productionDate, category, price,
                description, warrantyMoths
        ));

        FileManager.saveMonitor(monitors);
        System.out.print("\nМонитор " + brand + " " + model + " успешно зарегистрирован!");

    }


    public static void registrationMouse(String choiceCategory){
        Peripheral peripheral = registrationPeripheral(choiceCategory);
        Scanner scanner = new Scanner(System.in);

        String id = peripheral.getId();
        String brand = peripheral.getBrand();
        String model = peripheral.getModel();
        String countryProduction = peripheral.getCountryProduction();
        int productionDate = peripheral.getProductionDate();
        int price = peripheral.getPrice();
        String description = peripheral.getDescription();
        int warrantyMoths = peripheral.getWarrantyMoths();
        String category = peripheral.getCategory();
        String connectionType = peripheral.getConnectionType();
        double cableLength = peripheral.getCableLength();
        boolean isWireless = peripheral.isWireless();
        boolean hasRGB = peripheral.isHasRGB();
        String color = peripheral.getColor();

        int dpi = 0;
        int buttonsCount = 0;
        String sensorType = null;
        boolean isGaming = false;

        // Чувствительность (DPI)
        boolean cycleDpi = true;
        while (cycleDpi) {
            System.out.print("\nВведите максимальную чувствительность мыши в DPI (800, 1000, 1600, 3200, 6400, 12000, 16000, 26000): ");

            try {
                dpi = scanner.nextInt();
                scanner.nextLine();

                int[] validDpis = {800, 1000, 1600, 3200, 6400, 12000, 16000, 26000};
                boolean isValid = false;

                for (int validDpi : validDpis) {
                    if (dpi == validDpi) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная чувствительность DPI!\n" +
                            "Введите значение ещё раз (800, 1600, 3200, 6400, 12000, 16000, 26000 DPI): ");
                    dpi = scanner.nextInt();
                    scanner.nextLine();

                    for (int validDpi : validDpis) {
                        if (dpi == validDpi) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleDpi = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Количество кнопок
        boolean cycleButtonsCount = true;
        while (cycleButtonsCount) {
            System.out.print("\nВведите количество кнопок (3, 5, 7, 9, 12, 18): ");

            try {
                buttonsCount = scanner.nextInt();
                scanner.nextLine();

                int[] validButtons = {3, 5, 7, 9, 12, 18};
                boolean isValid = false;

                for (int buttons : validButtons) {
                    if (buttonsCount == buttons) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное количество кнопок!\n" +
                            "Введите значение ещё раз (3, 5, 7, 9, 12, 18 кнопок): ");
                    buttonsCount = scanner.nextInt();
                    scanner.nextLine();

                    for (int buttons : validButtons) {
                        if (buttonsCount == buttons) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleButtonsCount = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Тип сенсора
        boolean cycleSensorType = true;
        while (cycleSensorType) {
            System.out.print("\nВыберите тип сенсора мыши:\n" +
                    "1 - Оптический\n" +
                    "2 - Лазерный\n" +
                    "3 - Оптический высокоточный\n" +
                    "4 - Герконовый (для трекболов)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        sensorType = "Оптический";
                        cycleSensorType = false;
                        break;
                    case 2:
                        sensorType = "Лазерный";
                        cycleSensorType = false;
                        break;
                    case 3:
                        sensorType = "Оптический высокоточный";
                        cycleSensorType = false;
                        break;
                    case 4:
                        sensorType = "Герконовый";
                        cycleSensorType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Игровая мышь или офисная
        boolean cycleIsGaming = true;
        while (cycleIsGaming) {
            System.out.print("\nЭто игровая мышь?\n" +
                    "Введите:\n" +
                    "1 - Да, игровая\n" +
                    "0 - Нет, офисная/обычная\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        isGaming = false;
                        cycleIsGaming = false;
                        break;
                    case 1:
                        isGaming = true;
                        cycleIsGaming = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        Map<String, Mouse> mice = FileManager.loadMouse();
        mice.put(id, new Mouse(
                id, brand, model, dpi,
                buttonsCount, sensorType, isGaming,
                connectionType, cableLength,
                isWireless, hasRGB, color,
                countryProduction, productionDate, category,
                price, description, warrantyMoths
        ));

        FileManager.saveMouse(mice);
        System.out.print("\nМышь " + brand + " " + model + " успешно зарегистрирована!");

    }


    public static void registrationKeyBoard(String choiceCategory){
        Peripheral peripheral = registrationPeripheral(choiceCategory);
        Scanner scanner = new Scanner(System.in);

        String id = peripheral.getId();
        String brand = peripheral.getBrand();
        String model = peripheral.getModel();
        String countryProduction = peripheral.getCountryProduction();
        int productionDate = peripheral.getProductionDate();
        int price = peripheral.getPrice();
        String description = peripheral.getDescription();
        int warrantyMoths = peripheral.getWarrantyMoths();
        String category = peripheral.getCategory();
        String connectionType = peripheral.getConnectionType();
        double cableLength = peripheral.getCableLength();
        boolean isWireless = peripheral.isWireless();
        boolean hasRGB = peripheral.isHasRGB();
        String color = peripheral.getColor();

        String keyboardType = null;
        int countKey = 0;
        String switchType = "Нет";
        String layout = "";
        boolean hasNumpad = false;

        // Тип клавиатуры
        boolean cycleKeyboardType = true;
        while (cycleKeyboardType) {
            System.out.print("\nВыберите тип клавиатуры:\n" +
                    "1 - Механическая\n" +
                    "2 - Мембранная\n" +
                    "3 - Ножничная (ноутбучная)\n" +
                    "4 - Гибридная\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        keyboardType = "Механическая";
                        cycleKeyboardType = false;
                        break;
                    case 2:
                        keyboardType = "Мембранная";
                        cycleKeyboardType = false;
                        break;
                    case 3:
                        keyboardType = "Ножничная (ноутбучная)";
                        cycleKeyboardType = false;
                        break;
                    case 4:
                        keyboardType = "Гибридная";
                        cycleKeyboardType = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Количество клавиш
        boolean cycleCountKey = true;
        while (cycleCountKey) {
            System.out.print("\nВведите количество клавиш (61, 68, 87, 104, 108): ");

            try {
                countKey = scanner.nextInt();
                scanner.nextLine();

                int[] validKeys = {61, 68, 87, 104, 108};
                boolean isValid = false;

                for (int keys : validKeys) {
                    if (countKey == keys) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное количество клавиш!\n" +
                            "Введите значение ещё раз (61, 68, 87, 104, 108 клавиш): ");
                    countKey = scanner.nextInt();
                    scanner.nextLine();

                    for (int keys : validKeys) {
                        if (countKey == keys) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleCountKey = false;

            } catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        // Тип переключателей (только для механических клавиатур)
        if (keyboardType.equals("Механическая")) {
            boolean cycleSwitchType = true;
            while (cycleSwitchType) {
                System.out.print("\nВыберите тип механических переключателей:\n" +
                        "1 - Cherry MX Red (линейные)\n" +
                        "2 - Cherry MX Blue (кликающие)\n" +
                        "3 - Cherry MX Brown (тактильные)\n" +
                        "4 - Cherry MX Black (линейные тяжелые)\n" +
                        "5 - Gateron Red\n" +
                        "6 - Gateron Blue\n" +
                        "7 - Gateron Brown\n" +
                        "8 - Outemu\n" +
                        "9 - Kailh\n" +
                        "Ваш выбор: ");

                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            switchType = "Cherry MX Red";
                            cycleSwitchType = false;
                            break;
                        case 2:
                            switchType = "Cherry MX Blue";
                            cycleSwitchType = false;
                            break;
                        case 3:
                            switchType = "Cherry MX Brown";
                            cycleSwitchType = false;
                            break;
                        case 4:
                            switchType = "Cherry MX Black";
                            cycleSwitchType = false;
                            break;
                        case 5:
                            switchType = "Gateron Red";
                            cycleSwitchType = false;
                            break;
                        case 6:
                            switchType = "Gateron Blue";
                            cycleSwitchType = false;
                            break;
                        case 7:
                            switchType = "Gateron Brown";
                            cycleSwitchType = false;
                            break;
                        case 8:
                            switchType = "Outemu";
                            cycleSwitchType = false;
                            break;
                        case 9:
                            switchType = "Kailh";
                            cycleSwitchType = false;
                            break;
                        default:
                            System.out.println("Такого варианта выбора нет!\n" +
                                    "Пожалуйста, введите корректную цифру!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Произошла ошибка!\n" +
                            "Пожалуйста, введите корректное значение!\n" +
                            "В прошлый раз вы ввели букву вместо числа!");
                    scanner.nextLine();
                } catch (Exception a) {
                    System.out.println("Произошла неизвестная ошибка!");
                    scanner.nextLine();
                }
            }
        }

        // Раскладка (можно выбрать несколько)
        boolean cycleLayout = true;
        while (cycleLayout) {
            System.out.print("\nВыберите раскладку клавиатуры (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Русская (RU)\n" +
                    "2 - Английская (US)\n" +
                    "3 - Европейская (EU)\n" +
                    "4 - Японская (JP)\n" +
                    "5 - Китайская (CN)\n" +
                    "6 - Двуязычная (RU/EN)\n" +
                    "Введите номера выбранных раскладок (например: 1 2 6): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedLayouts = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("RU");
                                break;
                            case 2:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("US");
                                break;
                            case 3:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("EU");
                                break;
                            case 4:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("JP");
                                break;
                            case 5:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("CN");
                                break;
                            case 6:
                                if (selectedLayouts.length() > 0) selectedLayouts.append(", ");
                                selectedLayouts.append("RU/EN");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedLayouts.length() == 0) {
                    System.out.println("Вы не выбрали ни одной раскладки! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                layout = selectedLayouts.toString();
                cycleLayout = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        // Наличие цифрового блока (numpad)
        boolean cycleHasNumpad = true;
        while (cycleHasNumpad) {
            System.out.print("\nЕсть ли у клавиатуры цифровой блок (numpad)?\n" +
                    "Введите:\n" +
                    "1 - Да, цифровой блок присутствует\n" +
                    "0 - Нет, цифровой блок отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasNumpad = false;
                        cycleHasNumpad = false;
                        break;
                    case 1:
                        hasNumpad = true;
                        cycleHasNumpad = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        Map<String, Keyboard> keyboards = FileManager.loadKeyboard();
        keyboards.put(id, new Keyboard(
                id, brand, model,
                keyboardType, countKey,
                switchType, layout, hasNumpad,
                connectionType, cableLength,
                isWireless, hasRGB, color,
                countryProduction, productionDate, category,
                price, description, warrantyMoths
        ));

        FileManager.saveKeyboard(keyboards);
        System.out.print("\nКлавиатура " + brand + " " + model + " успешно зарегистрирована!");

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
