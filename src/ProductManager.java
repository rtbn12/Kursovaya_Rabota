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
        scanner.nextLine();

        while((productionDate < 2018) || productionDate > Calendar.getInstance().get(Calendar.YEAR))
        {
            System.out.print("\nНекорректный год производства!\n" +
                    "Введите год производства ещё раз:");
            productionDate = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("\nВведите цену товара:");
        int price = scanner.nextInt();
        scanner.nextLine();

        while (price <=0 || price>1000_000)
        {
            System.out.print("\nВведена недоступная цена для товара!\n" +
                    "Введите цену ещё раз:");
            price = scanner.nextInt();
            scanner.nextLine();
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
                scanner.nextLine();
                while (warrantyMoths<=0 || warrantyMoths>120)
                {
                    System.out.print("\nВы ввели некорректный срок гарантии!\n" +
                            "Введите срок гарантии в месяцах заново!:");
                    warrantyMoths = scanner.nextInt();
                    scanner.nextLine();
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

        String interfaceType = null;
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

            boolean cycle = true;
            while (cycle)
            {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения процессора:\n" +
                        "1-PGA\n" +
                        "2-LGA\n" +
                        "3-BGA\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice)
                    {
                        case 1:
                            interfaceType = "PGA";
                            cycle = false;
                            break;
                        case 2:
                            interfaceType = "LGA";
                            cycle = false;
                            break;
                        case 3:
                            interfaceType = "BGA";
                            cycle = false;
                            break;
                        default:
                            System.out.println("Такого варианта выбора нет!\n" +
                                    "Пожалуйста, введите корректную цифру!");
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Произошла ошибка!\n" +
                            "Пожалуйста, введите корректное значение!\n" +
                            "В прошлый раз вы ввели букву вместо числа!");
                    scanner.nextLine();
                }
                catch (Exception a) {
                    System.out.println("Произошла неизвестная ошибка!");
                    scanner.nextLine();
                }
            }

        } else if (category.equals("Оперативная память")) {
            boolean cycle = true;
            while (cycle)
            {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения ОЗУ: " +
                        "1-DIMM\n" +
                        "2-SO-DIMM\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice)
                    {
                        case 1:
                            interfaceType = "DIMM";
                            cycle = false;
                            break;
                        case 2:
                            interfaceType = "SO-DIMM";
                            cycle = false;
                            break;
                        default:
                            System.out.println("Такого варианта выбора нет!\n" +
                                    "Пожалуйста, введите корректную цифру!");
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Произошла ошибка!\n" +
                            "Пожалуйста, введите корректное значение!\n" +
                            "В прошлый раз вы ввели букву вместо числа!");
                    scanner.nextLine();
                }
                catch (Exception a) {
                    System.out.println("Произошла неизвестная ошибка!");
                    scanner.nextLine();
                }
            }

        } else if (category.equals("Постоянное запоминающее устройство")) {
            boolean cycle = true;
            while (cycle)
            {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения Постоянного запоминающего устройства: " +
                        "1-SATA III\n" +
                        "2-M.2\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice)
                    {
                        case 1:
                            interfaceType = "SATA III";
                            cycle = false;
                            break;
                        case 2:
                            interfaceType = "M.2";
                            cycle = false;
                            break;
                        default:
                            System.out.println("Такого варианта выбора нет!\n" +
                                    "Пожалуйста, введите корректную цифру!");
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Произошла ошибка!\n" +
                            "Пожалуйста, введите корректное значение!\n" +
                            "В прошлый раз вы ввели букву вместо числа!");
                    scanner.nextLine();
                }
                catch (Exception a) {
                    System.out.println("Произошла неизвестная ошибка!");
                    scanner.nextLine();
                }
            }

        } else {
            System.out.print("\nВведите интерфейсы подключения внешних устройств материнской платы:");
            interfaceType = scanner.nextLine();
        }



        int powerConsumption =0;
        boolean cyclePower = true;
        while (cyclePower)
        {
            System.out.print("\nВведите потребляемую мощность устройства:");

            try {
                  powerConsumption = scanner.nextInt();
                scanner.nextLine();
                while(powerConsumption <0 || powerConsumption>2000)
                {

                    System.out.print("\nНекорректное значение потребляемой мощности!\n" +
                            "Введите значение ещё раз:");
                    powerConsumption = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclePower = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }

        double voltage = 0;
        boolean cycleVoltage = true;
        while (cycleVoltage)
        {
            System.out.print("\nВведите рабочее напряжение устройства:");

            try {
                voltage = scanner.nextDouble();
                scanner.nextLine();
                while(voltage <0 || voltage>15)
                {

                    System.out.print("\nНекорректное значение рабочего напряжения!\n" +
                            "Введите значение ещё раз:");
                    voltage = scanner.nextDouble();
                    scanner.nextLine();
                }

                cycleVoltage = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }

        String dimensions;
        System.out.print("\nВведите размеры продукта в миллиметрах в формате A x B x C :");
        dimensions = scanner.nextLine();

        int weight = 0;
        boolean cycleWeight = true;
        while (cycleWeight)
        {
            System.out.print("\nВведите вес устройства в граммах:");

            try {
                weight = scanner.nextInt();
                scanner.nextLine();
                while(weight <0 || weight>10000)
                {

                    System.out.print("\nНекорректное значение веса устройства!\n" +
                            "Введите значение ещё раз:");
                    weight = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleWeight = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


        return new ComputerComponent(id,brand,model,price,interfaceType,
                powerConsumption,voltage,dimensions,weight,
                countryProduction,productionDate,category,description,warrantyMoths);


    }












    public static void registrationCPU(String choiceCategory)
    {
        ComputerComponent computerComponent = registrationComputerComponent(choiceCategory);
        Scanner scanner = new Scanner(System.in);


        String id = computerComponent.getId();
        String brand = computerComponent.getBrand();
        String model = computerComponent.getModel();
        String countryProduction = computerComponent.getCountryProduction();
        int productionDate = computerComponent.getProductionDate();
        int price = computerComponent.getPrice();
        String description = computerComponent.getDescription();
        int warrantyMoths = computerComponent.getWarrantyMoths();
        String category = computerComponent.getCategory();
        String interfaceType = computerComponent.getInterfaceType();
        double voltage = computerComponent.getVoltage();
        int powerConsumption = computerComponent.getPowerConsumption();
        String dimensions = computerComponent.getDimensions();
        int weight = computerComponent.getWeight();


        String socket;          // AM4, LGA1700, AM5
        int coreCount=0;          // Количество ядер (6, 8, 12)
        int threadCount=0;        // Количество потоков (12, 16, 24)
        double baseFrequency=0;   // Базовая частота (ГГц)
        double maxFrequency=0;    // Максимальная частота (ГГц)
        int cacheSize=0;          // Размер кэша (МБ)
        String memoryType;      // Поддерживаемая память (DDR4, DDR5)
        boolean hasIntegratedGraphics=false; // Встроенная графика


        System.out.print("\nВведите сокет процессора:");
        socket = scanner.nextLine();


        boolean cyclecoreCount = true;
        while (cyclecoreCount)
        {
            System.out.print("\nВведите количество ядер процессора:");

            try {
                coreCount = scanner.nextInt();
                scanner.nextLine();
                while(coreCount <0 || coreCount>128 || coreCount%2!=0)
                {

                    System.out.print("\nНекорректное количество ядер процессора!\n" +
                            "Введите значение ещё раз:");
                    coreCount = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclecoreCount = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }

        boolean cyclethreadCount = true;
        while (cyclethreadCount)
        {
            System.out.print("\nВведите количество потоков процессора:");

            try {
                threadCount = scanner.nextInt();
                scanner.nextLine();
                while(threadCount <0 || threadCount>128 || threadCount%2!=0)
                {

                    System.out.print("\nНекорректное количество потоков процессора!\n" +
                            "Введите значение ещё раз:");
                    threadCount = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclethreadCount = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


        boolean cyclebaseFrequency = true;
        while (cyclebaseFrequency)
        {
            System.out.print("\nВведите базовую частоту процессора:");

            try {
                baseFrequency = scanner.nextDouble();
                scanner.nextLine();
                while(baseFrequency <0 || baseFrequency>10)
                {

                    System.out.print("\nНекорректная базовая частота процессора!\n" +
                            "Введите значение ещё раз:");
                    baseFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }

                cyclebaseFrequency = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


        boolean cyclemaxFrequency = true;
        while (cyclemaxFrequency)
        {
            System.out.print("\nВведите максимальную частоту процессора:");

            try {
                maxFrequency = scanner.nextDouble();
                scanner.nextLine();
                while(maxFrequency <0 || maxFrequency>10 || maxFrequency< baseFrequency)
                {

                    System.out.print("\nНекорректная максимальная частота процессора!\n" +
                            "Введите значение ещё раз:");
                    maxFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }

                cyclemaxFrequency = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


        boolean cyclecacheSize = true;
        while (cyclecacheSize)
        {
            System.out.print("\nВведите объём кэша процессора:");

            try {
                cacheSize = scanner.nextInt();
                scanner.nextLine();
                while(cacheSize <0 || cacheSize>64 || cacheSize%2!=0)
                {

                    System.out.print("\nНекорректный объём кэша процессора!\n" +
                            "Введите значение ещё раз:");
                    cacheSize = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclecacheSize = false;

            }catch (InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }

        }


        System.out.print("\nВведите поддерживаемые процессором типы памяти:");
        memoryType = scanner.nextLine();

        boolean cyclehasIntegratedGraphics = true;
        while (cyclehasIntegratedGraphics)
        {
            System.out.print("\nЕсть ли у процессора встроенная графика?\n" +
                    "Введите:\n" +
                    "1-если встроенная графика присутствует\n" +
                    "0-если встроенная графика отсутствует\n" +
                    "Ваш выбор:");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice)
                {
                    case 0:
                        hasIntegratedGraphics = false;
                        cyclehasIntegratedGraphics = false;
                        break;
                    case 1:
                        hasIntegratedGraphics = true;
                        cyclehasIntegratedGraphics = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        Map<String,CPU> CPUs = FileManager.loadCPU();
        CPUs.put(id,new CPU(id,brand,model,price,interfaceType,socket,
                coreCount,threadCount,baseFrequency,maxFrequency,
                cacheSize,memoryType,hasIntegratedGraphics,
                powerConsumption,voltage,dimensions,weight,
                countryProduction,productionDate,category,
                description,warrantyMoths));

        FileManager.saveCPU(CPUs);
        System.out.print("\nРегистрация товара завершена успешно!");
    }









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



    public static void PrintCPU()
    {
        Map<String,Product> products = FileManager.loadProduct0();
        Map<String,CPU> CPUs = FileManager.loadCPU();

        System.out.println("============================Базовая инфа================================");

        for (Product product : products.values())
        {
            product.getMiniInfo();
        }

        System.out.println("============================Полная инфа================================");

        for(CPU cpu : CPUs.values())
        {
            cpu.getFullInfoForClient();
            cpu.getFullInfoForSeller();
        }
    }
}
