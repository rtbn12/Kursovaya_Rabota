import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

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
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения ОЗУ:\n" +
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
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения Постоянного запоминающего устройства:\n" +
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
            int usbPorts = 0;
            int audioPorts = 0;
            int displayPorts = 0;
            int hdmiPorts = 0;
            int rj45Ports = 0;

            boolean cycleUsbPorts = true;
            while (cycleUsbPorts) {
                System.out.print("\nВведите количество USB портов на задней панели (4-20): ");

                try {
                    usbPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (usbPorts < 4 || usbPorts > 20) {
                        System.out.print("\nНекорректное количество USB портов!\n" +
                                "Введите значение ещё раз (4-20): ");
                        usbPorts = scanner.nextInt();
                        scanner.nextLine();
                    }
                    cycleUsbPorts = false;
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


            boolean cycleAudioPorts = true;
            while (cycleAudioPorts) {
                System.out.print("\nВведите количество аналоговых аудиовыходов (2-8): ");

                try {
                    audioPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (audioPorts < 2 || audioPorts > 8) {
                        System.out.print("\nНекорректное количество аудио портов!\n" +
                                "Введите значение ещё раз (3-8): ");
                        audioPorts = scanner.nextInt();
                        scanner.nextLine();
                    }
                    cycleAudioPorts = false;
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


            boolean cycleDisplayPorts = true;
            while (cycleDisplayPorts) {
                System.out.print("\nВведите количество DisplayPort портов (0-4): ");

                try {
                    displayPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (displayPorts < 0 || displayPorts > 4) {
                        System.out.print("\nНекорректное количество DisplayPort!\n" +
                                "Введите значение ещё раз (0-4): ");
                        displayPorts = scanner.nextInt();
                        scanner.nextLine();
                    }
                    cycleDisplayPorts = false;
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

            boolean cycleHdmiPorts = true;
            while (cycleHdmiPorts) {
                System.out.print("\nВведите количество HDMI портов (0-4): ");

                try {
                    hdmiPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (hdmiPorts < 0 || hdmiPorts > 4) {
                        System.out.print("\nНекорректное количество HDMI портов!\n" +
                                "Введите значение ещё раз (0-4): ");
                        hdmiPorts = scanner.nextInt();
                        scanner.nextLine();
                    }
                    cycleHdmiPorts = false;
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


            boolean cycleRj45Ports = true;
            while (cycleRj45Ports) {
                System.out.print("\nВведите количество RJ45 (сетевых) портов (1-2): ");

                try {
                    rj45Ports = scanner.nextInt();
                    scanner.nextLine();
                    while (rj45Ports < 1 || rj45Ports > 2) {
                        System.out.print("\nНекорректное количество RJ45 портов!\n" +
                                "Введите значение ещё раз (1 или 2): ");
                        rj45Ports = scanner.nextInt();
                        scanner.nextLine();
                    }
                    cycleRj45Ports = false;
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



            interfaceType = String.format("USB: %d, Аудио: %d, DisplayPort: %d, HDMI: %d, RJ45: %d",
                    usbPorts, audioPorts, displayPorts, hdmiPorts, rj45Ports);
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


    public static void registrationCPU(String choiceCategory) {
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
                while(cacheSize <0 || cacheSize>256 || cacheSize%2!=0)
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


    public static void registrationMotherBoard(String choiceCategory) {
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


        String chipset;
        String socket;
        int ramSlots = 0;
        int maxRamCapacity = 0;
        String ramType;
        int m2Slots = 0;
        int sataPorts = 0;
        boolean hasWiFi = false;
        String audioCodec;
        int lanSpeed = 0;

        System.out.print("\nВведите чипсет материнской платы :");
        chipset = scanner.nextLine();

        System.out.print("\nВведите сокет материнской платы :");
        socket = scanner.nextLine();

        boolean cycleRamSlots = true;
        while (cycleRamSlots) {
            System.out.print("\nВведите количество слотов оперативной памяти:");

            try {
                ramSlots = scanner.nextInt();
                scanner.nextLine();
                while (ramSlots < 2 || ramSlots > 8 || ramSlots % 2 != 0) {
                    System.out.print("\nНекорректное количество слотов RAM!\n" +
                            "Введите значение ещё раз: ");
                    ramSlots = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleRamSlots = false;
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

        boolean cycleMaxRamCapacity = true;
        while (cycleMaxRamCapacity) {
            System.out.print("\nВведите максимальный объём поддерживаемой оперативной памяти в ГБ (32, 64, 128, 192, 256): ");

            try {
                maxRamCapacity = scanner.nextInt();
                scanner.nextLine();
                while (maxRamCapacity < 32 || maxRamCapacity > 256 || (maxRamCapacity % 2 != 0 ||maxRamCapacity < 8*ramSlots )) {
                    System.out.print("\nНекорректный максимальный объём RAM!\n" +
                            "Введите значение ещё раз (32, 64, 128, 192, 256): ");
                    maxRamCapacity = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleMaxRamCapacity = false;
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

        System.out.print("\nВведите поддерживаемый тип памяти (DDR4, DDR5, DDR4/DDR5): ");
        ramType = scanner.nextLine();

        boolean cycleM2Slots = true;
        while (cycleM2Slots) {
            System.out.print("\nВведите количество M.2 слотов (0-6): ");

            try {
                m2Slots = scanner.nextInt();
                scanner.nextLine();
                while (m2Slots < 0 || m2Slots > 6) {
                    System.out.print("\nНекорректное количество M.2 слотов!\n" +
                            "Введите значение ещё раз (0-6): ");
                    m2Slots = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleM2Slots = false;
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

        boolean cycleSataPorts = true;
        while (cycleSataPorts) {
            System.out.print("\nВведите количество SATA портов (2-12): ");

            try {
                sataPorts = scanner.nextInt();
                scanner.nextLine();
                while (sataPorts < 2 || sataPorts > 12) {
                    System.out.print("\nНекорректное количество SATA портов!\n" +
                            "Введите значение ещё раз (2-12): ");
                    sataPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleSataPorts = false;
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

        System.out.print("\nВведите аудиокодек (Realtek ALC897, Realtek ALC1220 и т.д.): ");
        audioCodec = scanner.nextLine();


        boolean cyclelanSpeed = true;
        while (cyclelanSpeed) {
            System.out.print("\nВведите скорость сетевой карты: ");

            try {
                lanSpeed = scanner.nextInt();
                scanner.nextLine();
                while (lanSpeed < 0 || lanSpeed > 10000) {
                    System.out.print("\nНекорректная скорость сетевой карты!\n" +
                            "Введите значение ещё раз : ");
                    lanSpeed = scanner.nextInt();
                    scanner.nextLine();
                }
                cyclelanSpeed = false;
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

        boolean cycleHasWiFi = true;
        while (cycleHasWiFi) {
            System.out.print("\nЕсть ли у материнской платы встроенный WiFi модуль?\n" +
                    "Введите:\n" +
                    "1 - если WiFi модуль присутствует\n" +
                    "0 - если WiFi модуль отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasWiFi = false;
                        cycleHasWiFi = false;
                        break;
                    case 1:
                        hasWiFi = true;
                        cycleHasWiFi = false;
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

        Map<String, MotherBoard> motherBoards = FileManager.loadMotherBoard();
        motherBoards.put(id, new MotherBoard(
                id, brand, model, price, interfaceType,
                chipset, socket, ramSlots, maxRamCapacity, ramType,
                m2Slots, sataPorts, hasWiFi, audioCodec, lanSpeed,
                powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveMotherBoard(motherBoards);
        System.out.print("\nМатеринская плата " + brand + " " + model + " успешно зарегистрирована!");
    }



    public static void registrationGPU(String choiceCategory){

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
        String interfaceType = computerComponent.getInterfaceType();;
        double voltage = computerComponent.getVoltage();
        int powerConsumption = computerComponent.getPowerConsumption();
        String dimensions = computerComponent.getDimensions();
        int weight = computerComponent.getWeight();


        int vramSize = 0;
        String memoryType = null;
        int cudaCores = 0;
        double baseFrequency = 0;
        double boostFrequency = 0;
        int memoryBusWidth = 0;
        String coolingType = null;
        int powerConnectors = 0;
        String typePCIe = null;
        String videoOutput = null;


        boolean cycleVramSize = true;
        while (cycleVramSize) {
            System.out.print("\nВведите объем видеопамяти в ГБ (1-24): ");

            try {
                vramSize = scanner.nextInt();
                scanner.nextLine();
                while (vramSize < 1 || vramSize > 64) {
                    System.out.print("\nНекорректный объем видеопамяти!\n" +
                            "Введите значение ещё раз (1-64 ГБ): ");
                    vramSize = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleVramSize = false;
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

        System.out.print("\nВведите тип памяти (GDDR5, GDDR6, GDDR6X, GDDR7): ");
        memoryType = scanner.nextLine();


        boolean cycleCudaCores = true;
        while (cycleCudaCores) {
            System.out.print("\nВведите количество CUDA ядер (256-30000): ");

            try {
                cudaCores = scanner.nextInt();
                scanner.nextLine();
                while (cudaCores < 256 || cudaCores > 30000) {
                    System.out.print("\nНекорректное количество CUDA ядер!\n" +
                            "Введите значение ещё раз (256-18432): ");
                    cudaCores = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleCudaCores = false;
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


        boolean cycleBaseFrequency = true;
        while (cycleBaseFrequency) {
            System.out.print("\nВведите базовую частоту в МГц (800-2500): ");

            try {
                baseFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (baseFrequency < 800 || baseFrequency > 2500) {
                    System.out.print("\nНекорректная базовая частота!\n" +
                            "Введите значение ещё раз (800-2500 МГц): ");
                    baseFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                cycleBaseFrequency = false;
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


        boolean cycleBoostFrequency = true;
        while (cycleBoostFrequency) {
            System.out.print("\nВведите турбо частоту в МГц (" + baseFrequency + "-3000): ");

            try {
                boostFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (boostFrequency < baseFrequency || boostFrequency > 3000) {
                    System.out.print("\nНекорректная турбо частота!\n" +
                            "Введите значение ещё раз (" + baseFrequency + "-3000 МГц): ");
                    boostFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                cycleBoostFrequency = false;
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


        boolean cycleMemoryBusWidth = true;
        while (cycleMemoryBusWidth) {
            System.out.print("\nВведите ширину шины памяти в битах (64, 128, 192, 256, 384, 512, 1024): ");

            try {
                memoryBusWidth = scanner.nextInt();
                scanner.nextLine();

                int[] validBusWidths = {64, 128, 192, 256, 384, 512, 1024};
                boolean isValid = false;

                for (int width : validBusWidths) {
                    if (memoryBusWidth == width) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная ширина шины памяти!\n" +
                            "Введите значение ещё раз (64, 128, 192, 256, 384 бит): ");
                    memoryBusWidth = scanner.nextInt();
                    scanner.nextLine();

                    for (int width : validBusWidths) {
                        if (memoryBusWidth == width) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleMemoryBusWidth = false;

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

        System.out.print("\nВведите тип охлаждения (воздушное, жидкостное, гибридное): ");
        coolingType = scanner.nextLine();


        boolean cyclePowerConnectors = true;
        while (cyclePowerConnectors) {
            System.out.print("\nВведите количество 8-пиновых разъемов питания (0-3): ");

            try {
                powerConnectors = scanner.nextInt();
                scanner.nextLine();
                while (powerConnectors < 0 || powerConnectors > 3) {
                    System.out.print("\nНекорректное количество разъемов питания!\n" +
                            "Введите значение ещё раз (0-3): ");
                    powerConnectors = scanner.nextInt();
                    scanner.nextLine();
                }
                cyclePowerConnectors = false;
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


        boolean cycleTypePCIe = true;
        while (cycleTypePCIe) {
            System.out.print("\nВыберите версию PCIe:\n" +
                    "1 - PCIe 3.0\n" +
                    "2 - PCIe 4.0\n" +
                    "3 - PCIe 5.0\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        typePCIe = "PCIe 3.0";
                        cycleTypePCIe = false;
                        break;
                    case 2:
                        typePCIe = "PCIe 4.0";
                        cycleTypePCIe = false;
                        break;
                    case 3:
                        typePCIe = "PCIe 5.0";
                        cycleTypePCIe = false;
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

        int hdmiPorts = 0;
        int displayPorts = 0;
        int vgaPorts = 0;
        int dviDPorts = 0;
        int dviIPorts = 0;


        boolean cycleHdmiPorts = true;
        while (cycleHdmiPorts) {
            System.out.print("\nВведите количество HDMI портов (0-4): ");

            try {
                hdmiPorts = scanner.nextInt();
                scanner.nextLine();
                while (hdmiPorts < 0 || hdmiPorts > 4) {
                    System.out.print("\nНекорректное количество HDMI портов!\n" +
                            "Введите значение ещё раз (0-4): ");
                    hdmiPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleHdmiPorts = false;
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


        boolean cycleDisplayPorts = true;
        while (cycleDisplayPorts) {
            System.out.print("\nВведите количество DisplayPort портов (0-4): ");

            try {
                displayPorts = scanner.nextInt();
                scanner.nextLine();
                while (displayPorts < 0 || displayPorts > 4) {
                    System.out.print("\nНекорректное количество DisplayPort!\n" +
                            "Введите значение ещё раз (0-4): ");
                    displayPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleDisplayPorts = false;
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


        boolean cycleVgaPorts = true;
        while (cycleVgaPorts) {
            System.out.print("\nВведите количество VGA портов (0-2): ");

            try {
                vgaPorts = scanner.nextInt();
                scanner.nextLine();
                while (vgaPorts < 0 || vgaPorts > 2) {
                    System.out.print("\nНекорректное количество VGA портов!\n" +
                            "Введите значение ещё раз (0-2): ");
                    vgaPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleVgaPorts = false;
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


        boolean cycleDviDPorts = true;
        while (cycleDviDPorts) {
            System.out.print("\nВведите количество DVI-D портов (0-2): ");

            try {
                dviDPorts = scanner.nextInt();
                scanner.nextLine();
                while (dviDPorts < 0 || dviDPorts > 2) {
                    System.out.print("\nНекорректное количество DVI-D портов!\n" +
                            "Введите значение ещё раз (0-2): ");
                    dviDPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleDviDPorts = false;
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


        boolean cycleDviIPorts = true;
        while (cycleDviIPorts) {
            System.out.print("\nВведите количество DVI-I портов (0-2): ");

            try {
                dviIPorts = scanner.nextInt();
                scanner.nextLine();
                while (dviIPorts < 0 || dviIPorts > 2) {
                    System.out.print("\nНекорректное количество DVI-I портов!\n" +
                            "Введите значение ещё раз (0-2): ");
                    dviIPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleDviIPorts = false;
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



        videoOutput = String.format("HDMI: %d, DisplayPort: %d, VGA: %d, DVI-D: %d, DVI-I: %d",
                hdmiPorts, displayPorts, vgaPorts, dviDPorts, dviIPorts);

        Map<String, GPU> gpus = FileManager.loadGPU();
        gpus.put(id, new GPU(
                id, brand, model, price, interfaceType,
                vramSize, memoryType, cudaCores, baseFrequency, boostFrequency,
                memoryBusWidth, coolingType, powerConnectors, typePCIe, videoOutput,
                powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveGPU(gpus);
        System.out.print("\nВидеокарта " + brand + " " + model + " успешно зарегистрирована!");
    }



    public static void registrationRAM(String choiceCategory){
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


        int capacity = 0;
        int frequency = 0;
        int latency = 0;
        String memoryType = null;
        int modulesCount = 0;
        boolean hasRGB = false;
        boolean hasHeatSpreader = false;


        boolean cycleCapacity = true;
        while (cycleCapacity) {
            System.out.print("\nВведите объем одного модуля в ГБ (4, 8, 16, 32, 64): ");

            try {
                capacity = scanner.nextInt();
                scanner.nextLine();

                int[] validCapacities = {4, 8, 16, 32, 64};
                boolean isValid = false;

                for (int cap : validCapacities) {
                    if (capacity == cap) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректный объем модуля!\n" +
                            "Введите значение ещё раз (4, 8, 16, 32, 64 ГБ): ");
                    capacity = scanner.nextInt();
                    scanner.nextLine();

                    for (int cap : validCapacities) {
                        if (capacity == cap) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleCapacity = false;

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

        // Частота памяти
        boolean cycleFrequency = true;
        while (cycleFrequency) {
            System.out.print("\nВведите частоту памяти в МГц (2133, 2400, 2666, 3000, 3200, 3600, 4000, 4400, 4800, 5200, 5600, 6000, 6400, 6800, 7200): ");

            try {
                frequency = scanner.nextInt();
                scanner.nextLine();

                int[] validFrequencies = {2133, 2400, 2666, 3000, 3200, 3600, 4000, 4400, 4800, 5200, 5600, 6000, 6400, 6800, 7200};
                boolean isValid = false;

                for (int freq : validFrequencies) {
                    if (frequency == freq) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная частота памяти!\n" +
                            "Введите значение ещё раз (стандартные значения: 2133-7200 МГц): ");
                    frequency = scanner.nextInt();
                    scanner.nextLine();

                    for (int freq : validFrequencies) {
                        if (frequency == freq) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleFrequency = false;

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

        // Тайминги (латентность)
        boolean cycleLatency = true;
        while (cycleLatency) {
            System.out.print("\nВведите тайминги памяти (CL14, CL16, CL18, CL20, CL22, CL24, CL28, CL30, CL32, CL34, CL36, CL38, CL40): ");

            try {
                System.out.print("\nВведите только число после CL: ");
                latency = scanner.nextInt();
                scanner.nextLine();

                int[] validLatencies = {14, 16, 18, 20, 22, 24, 28, 30, 32, 34, 36, 38, 40};
                boolean isValid = false;

                for (int lat : validLatencies) {
                    if (latency == lat) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректные тайминги!\n" +
                            "Введите значение ещё раз (14-40): ");
                    latency = scanner.nextInt();
                    scanner.nextLine();

                    for (int lat : validLatencies) {
                        if (latency == lat) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleLatency = false;

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

        // Тип памяти (выбор из меню)
        boolean cycleMemoryType = true;
        while (cycleMemoryType) {
            System.out.print("\nВыберите тип памяти:\n" +
                    "1 - DDR4\n" +
                    "2 - DDR5\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        memoryType = "DDR4";
                        cycleMemoryType = false;
                        break;
                    case 2:
                        memoryType = "DDR5";
                        cycleMemoryType = false;
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

        // Количество модулей в комплекте
        boolean cycleModulesCount = true;
        while (cycleModulesCount) {
            System.out.print("\nВведите количество модулей в комплекте (1, 2, 4, 8): ");

            try {
                modulesCount = scanner.nextInt();
                scanner.nextLine();

                int[] validCounts = {1, 2, 4, 8};
                boolean isValid = false;

                for (int count : validCounts) {
                    if (modulesCount == count) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректное количество модулей!\n" +
                            "Введите значение ещё раз (1, 2, 4 или 8): ");
                    modulesCount = scanner.nextInt();
                    scanner.nextLine();

                    for (int count : validCounts) {
                        if (modulesCount == count) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleModulesCount = false;

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

        // Наличие RGB подсветки
        boolean cycleHasRGB = true;
        while (cycleHasRGB) {
            System.out.print("\nЕсть ли у оперативной памяти RGB подсветка?\n" +
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

        // Наличие радиатора охлаждения
        boolean cycleHasHeatSpreader = true;
        while (cycleHasHeatSpreader) {
            System.out.print("\nЕсть ли у оперативной памяти радиатор охлаждения?\n" +
                    "Введите:\n" +
                    "1 - если радиатор присутствует\n" +
                    "0 - если радиатор отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasHeatSpreader = false;
                        cycleHasHeatSpreader = false;
                        break;
                    case 1:
                        hasHeatSpreader = true;
                        cycleHasHeatSpreader = false;
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

        Map<String, RAM> rams = FileManager.loadRAM();
        rams.put(id, new RAM(
                id, brand, model, price, interfaceType,
                capacity, frequency, latency, memoryType, modulesCount,
                hasRGB, hasHeatSpreader,
                powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveRAM(rams);
        System.out.print("\nОперативная память " + brand + " " + model + " успешно зарегистрирована!");
    }


    public static void registrationStorage(String choiceCategory){
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

        int capacity = 0;
        String storageType = null;
        int readSpeed = 0;
        int writeSpeed = 0;
        String formFactor = null;
        int tbw = 0;
        int cacheSize = 0;
        String nandType = null;

        // Емкость накопителя
        boolean cycleCapacity = true;
        while (cycleCapacity) {
            System.out.print("\nВведите емкость накопителя в ГБ (128, 256, 512, 1024, 2048, 4096, 8192): ");

            try {
                capacity = scanner.nextInt();
                scanner.nextLine();

                int[] validCapacities = {128, 256, 512, 1024, 2048, 4096, 8192};
                boolean isValid = false;

                for (int cap : validCapacities) {
                    if (capacity == cap) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректная емкость накопителя!\n" +
                            "Введите значение ещё раз (128, 256, 512, 1024, 2048, 4096, 8192 ГБ): ");
                    capacity = scanner.nextInt();
                    scanner.nextLine();

                    for (int cap : validCapacities) {
                        if (capacity == cap) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleCapacity = false;

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

        // Тип накопителя (SSD, HDD, NVMe)
        boolean cycleStorageType = true;
        while (cycleStorageType) {
            System.out.print("\nВыберите тип накопителя:\n" +
                    "1 - SSD (SATA)\n" +
                    "2 - NVMe SSD\n" +
                    "3 - HDD\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        storageType = "SSD";
                        cycleStorageType = false;
                        break;
                    case 2:
                        storageType = "NVMe SSD";
                        cycleStorageType = false;
                        break;
                    case 3:
                        storageType = "HDD";
                        cycleStorageType = false;
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

        // Форм-фактор
        boolean cycleFormFactor = true;
        while (cycleFormFactor) {
            System.out.print("\nВыберите форм-фактор накопителя:\n" +
                    "1 - 2.5\"\n" +
                    "2 - M.2\n" +
                    "3 - 3.5\"\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        formFactor = "2.5\"";
                        cycleFormFactor = false;
                        break;
                    case 2:
                        formFactor = "M.2";
                        cycleFormFactor = false;
                        break;
                    case 3:
                        formFactor = "3.5\"";
                        cycleFormFactor = false;
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

        // Скорость чтения
        boolean cycleReadSpeed = true;
        while (cycleReadSpeed) {
            System.out.print("\nВведите скорость чтения в МБ/с (минимальное значение 100 МБ/с): ");

            try {
                readSpeed = scanner.nextInt();
                scanner.nextLine();

                while (readSpeed < 100) {
                    System.out.print("\nНекорректная скорость чтения!\n" +
                            "Введите значение ещё раз (не менее 100 МБ/с): ");
                    readSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleReadSpeed = false;

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

        // Скорость записи
        boolean cycleWriteSpeed = true;
        while (cycleWriteSpeed) {
            System.out.print("\nВведите скорость записи в МБ/с (минимальное значение 50 МБ/с): ");

            try {
                writeSpeed = scanner.nextInt();
                scanner.nextLine();

                while (writeSpeed < 50) {
                    System.out.print("\nНекорректная скорость записи!\n" +
                            "Введите значение ещё раз (не менее 50 МБ/с): ");
                    writeSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                // Проверка, чтобы скорость записи не была больше скорости чтения
                if (writeSpeed > readSpeed) {
                    System.out.println("Внимание: Скорость записи не может быть выше скорости чтения!\n" +
                            "Скорость записи установлена равной скорости чтения.");
                    writeSpeed = readSpeed;
                }

                cycleWriteSpeed = false;

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

        // Ресурс записи (TBW)
        boolean cycleTBW = true;
        while (cycleTBW) {
            System.out.print("\nВведите ресурс записи (TBW) в терабайтах: ");

            try {
                tbw = scanner.nextInt();
                scanner.nextLine();

                while (tbw <= 0) {
                    System.out.print("\nНекорректный ресурс записи!\n" +
                            "Введите значение ещё раз (положительное число): ");
                    tbw = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleTBW = false;

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

        // Размер кэша
        boolean cycleCacheSize = true;
        while (cycleCacheSize) {
            System.out.print("\nВведите размер кэша в МБ (0, 64, 128, 256, 512, 1024, 2048): ");

            try {
                cacheSize = scanner.nextInt();
                scanner.nextLine();

                int[] validCacheSizes = {0, 64, 128, 256, 512, 1024, 2048};
                boolean isValid = false;

                for (int cache : validCacheSizes) {
                    if (cacheSize == cache) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректный размер кэша!\n" +
                            "Введите значение ещё раз (0, 64, 128, 256, 512, 1024, 2048 МБ): ");
                    cacheSize = scanner.nextInt();
                    scanner.nextLine();

                    for (int cache : validCacheSizes) {
                        if (cacheSize == cache) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleCacheSize = false;

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

        // Тип памяти NAND
        boolean cycleNandType = true;
        while (cycleNandType) {
            System.out.print("\nВыберите тип памяти NAND:\n" +
                    "1 - TLC\n" +
                    "2 - QLC\n" +
                    "3 - 3D NAND\n" +
                    "4 - MLC (для SSD)\n" +
                    "5 - SLC (для SSD)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        nandType = "TLC";
                        cycleNandType = false;
                        break;
                    case 2:
                        nandType = "QLC";
                        cycleNandType = false;
                        break;
                    case 3:
                        nandType = "3D NAND";
                        cycleNandType = false;
                        break;
                    case 4:
                        nandType = "MLC";
                        cycleNandType = false;
                        break;
                    case 5:
                        nandType = "SLC";
                        cycleNandType = false;
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

        Map<String, Storage> storages = FileManager.loadStorage();
        storages.put(id, new Storage(
                id, brand, model, price, interfaceType,
                capacity, storageType, readSpeed, writeSpeed, formFactor,
                tbw, cacheSize, nandType,
                powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveStorage(storages);
        System.out.print("\nНакопитель " + brand + " " + model + " успешно зарегистрирован!");

    }


    public static void registrationPowerSupply(String choiceCategory){

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

        String efficiency = null;
        String modularity = null;
        int sataConnectors = 0;
        int pcieConnectors = 0;
        int cpuConnectors = 0;
        String fanSize = null;
        String protections = "";


        // Сертификат эффективности
        boolean cycleEfficiency = true;
        while (cycleEfficiency) {
            System.out.print("\nВыберите сертификат эффективности 80 PLUS:\n" +
                    "1 - 80 PLUS Bronze\n" +
                    "2 - 80 PLUS Silver\n" +
                    "3 - 80 PLUS Gold\n" +
                    "4 - 80 PLUS Platinum\n" +
                    "5 - 80 PLUS Titanium\n" +
                    "6 - Без сертификата\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        efficiency = "80 PLUS Bronze";
                        cycleEfficiency = false;
                        break;
                    case 2:
                        efficiency = "80 PLUS Silver";
                        cycleEfficiency = false;
                        break;
                    case 3:
                        efficiency = "80 PLUS Gold";
                        cycleEfficiency = false;
                        break;
                    case 4:
                        efficiency = "80 PLUS Platinum";
                        cycleEfficiency = false;
                        break;
                    case 5:
                        efficiency = "80 PLUS Titanium";
                        cycleEfficiency = false;
                        break;
                    case 6:
                        efficiency = "Без сертификата";
                        cycleEfficiency = false;
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

        // Модульность кабелей
        boolean cycleModularity = true;
        while (cycleModularity) {
            System.out.print("\nВыберите тип модульности кабелей:\n" +
                    "1 - Полная модульность (Full Modular)\n" +
                    "2 - Частичная модульность (Semi Modular)\n" +
                    "3 - Немодульный (Non Modular)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        modularity = "Полная модульность (Full Modular)";
                        cycleModularity = false;
                        break;
                    case 2:
                        modularity = "Частичная модульность (Semi Modular)";
                        cycleModularity = false;
                        break;
                    case 3:
                        modularity = "Немодульный (Non Modular)";
                        cycleModularity = false;
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

        // Количество SATA разъемов
        boolean cycleSataConnectors = true;
        while (cycleSataConnectors) {
            System.out.print("\nВведите количество SATA разъемов (4-12): ");

            try {
                sataConnectors = scanner.nextInt();
                scanner.nextLine();

                while (sataConnectors < 4 || sataConnectors > 12) {
                    System.out.print("\nНекорректное количество SATA разъемов!\n" +
                            "Введите значение ещё раз (4-12): ");
                    sataConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleSataConnectors = false;

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

        // Количество PCI-E разъемов
        boolean cyclePcieConnectors = true;
        while (cyclePcieConnectors) {
            System.out.print("\nВведите количество PCI-E разъемов (6+2 pin) (1-8): ");

            try {
                pcieConnectors = scanner.nextInt();
                scanner.nextLine();

                while (pcieConnectors < 1 || pcieConnectors > 8) {
                    System.out.print("\nНекорректное количество PCI-E разъемов!\n" +
                            "Введите значение ещё раз (1-8): ");
                    pcieConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclePcieConnectors = false;

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

        // Количество CPU разъемов
        boolean cycleCpuConnectors = true;
        while (cycleCpuConnectors) {
            System.out.print("\nВведите количество CPU разъемов (4+4 pin) (1-4): ");

            try {
                cpuConnectors = scanner.nextInt();
                scanner.nextLine();

                while (cpuConnectors < 1 || cpuConnectors > 4) {
                    System.out.print("\nНекорректное количество CPU разъемов!\n" +
                            "Введите значение ещё раз (1-4): ");
                    cpuConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleCpuConnectors = false;

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

        // Размер вентилятора
        boolean cycleFanSize = true;
        while (cycleFanSize) {
            System.out.print("\nВыберите размер вентилятора:\n" +
                    "1 - 80 мм\n" +
                    "2 - 120 мм\n" +
                    "3 - 135 мм\n" +
                    "4 - 140 мм\n" +
                    "5 - Пассивное охлаждение (без вентилятора)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        fanSize = "80 мм";
                        cycleFanSize = false;
                        break;
                    case 2:
                        fanSize = "120 мм";
                        cycleFanSize = false;
                        break;
                    case 3:
                        fanSize = "135 мм";
                        cycleFanSize = false;
                        break;
                    case 4:
                        fanSize = "140 мм";
                        cycleFanSize = false;
                        break;
                    case 5:
                        fanSize = "Пассивное охлаждение";
                        cycleFanSize = false;
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

        // Выбор защит (можно выбрать несколько)
        boolean cycleProtections = true;
        while (cycleProtections) {
            System.out.print("\nВыберите доступные защиты (можно выбрать несколько цифр через пробел):\n" +
                    "1 - OCP (Защита от перегрузки по току)\n" +
                    "2 - OVP (Защита от перенапряжения)\n" +
                    "3 - UVP (Защита от пониженного напряжения)\n" +
                    "4 - OPP (Защита от перегрузки по мощности)\n" +
                    "5 - SCP (Защита от короткого замыкания)\n" +
                    "6 - OTP (Защита от перегрева)\n" +
                    "7 - SIP (Защита от перенапряжения на входе)\n" +
                    "Введите номера выбранных защит (например: 1 2 3 4 5): ");

            try {
                scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedProtections = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("OCP");
                                break;
                            case 2:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("OVP");
                                break;
                            case 3:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("UVP");
                                break;
                            case 4:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("OPP");
                                break;
                            case 5:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("SCP");
                                break;
                            case 6:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("OTP");
                                break;
                            case 7:
                                if (selectedProtections.length() > 0) selectedProtections.append(", ");
                                selectedProtections.append("SIP");
                                break;
                        }
                    } catch (NumberFormatException e) {

                    }
                }

                if (selectedProtections.length() == 0) {
                    System.out.println("Вы не выбрали ни одной защиты! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                protections = selectedProtections.toString();
                cycleProtections = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        Map<String, PowerSupply> powerSupplies = FileManager.loadPowerSupply();
        powerSupplies.put(id, new PowerSupply(
                id, brand, model, price, interfaceType,
                powerConsumption, voltage, efficiency, modularity,
                sataConnectors, pcieConnectors, cpuConnectors, fanSize,
                protections, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.savePowerSupply(powerSupplies);
        System.out.print("\nБлок питания " + brand + " " + model + " успешно зарегистрирован!");
    }


    public static void registrationCase(String choiceCategory){
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

        String caseType = null;
        String motherboardFormFactor = "";
        int driveBays35 = 0;
        int driveBays25 = 0;
        String frontPanel = "";
        boolean hasTemperedGlass = false;
        boolean hasFanSupport = true;
        boolean hasRGB = false;
        boolean hasDustFilters = false;

        // Тип корпуса
        boolean cycleCaseType = true;
        while (cycleCaseType) {
            System.out.print("\nВыберите тип корпуса:\n" +
                    "1 - Full-Tower\n" +
                    "2 - Mid-Tower\n" +
                    "3 - Mini-Tower\n" +
                    "4 - SFF (Small Form Factor)\n" +
                    "5 - HTPC\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        caseType = "Full-Tower";
                        cycleCaseType = false;
                        break;
                    case 2:
                        caseType = "Mid-Tower";
                        cycleCaseType = false;
                        break;
                    case 3:
                        caseType = "Mini-Tower";
                        cycleCaseType = false;
                        break;
                    case 4:
                        caseType = "SFF (Small Form Factor)";
                        cycleCaseType = false;
                        break;
                    case 5:
                        caseType = "HTPC";
                        cycleCaseType = false;
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

        // Поддерживаемые форм-факторы материнских плат (можно выбрать несколько)
        boolean cycleFormFactor = true;
        while (cycleFormFactor) {
            System.out.print("\nВыберите поддерживаемые форм-факторы материнских плат (можно выбрать несколько цифр через пробел):\n" +
                    "1 - ATX\n" +
                    "2 - Micro-ATX\n" +
                    "3 - Mini-ITX\n" +
                    "4 - E-ATX\n" +
                    "Введите номера выбранных форм-факторов (например: 1 2 3): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedFormFactors = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedFormFactors.length() > 0) selectedFormFactors.append(", ");
                                selectedFormFactors.append("ATX");
                                break;
                            case 2:
                                if (selectedFormFactors.length() > 0) selectedFormFactors.append(", ");
                                selectedFormFactors.append("Micro-ATX");
                                break;
                            case 3:
                                if (selectedFormFactors.length() > 0) selectedFormFactors.append(", ");
                                selectedFormFactors.append("Mini-ITX");
                                break;
                            case 4:
                                if (selectedFormFactors.length() > 0) selectedFormFactors.append(", ");
                                selectedFormFactors.append("E-ATX");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedFormFactors.length() == 0) {
                    System.out.println("Вы не выбрали ни одного форм-фактора! Пожалуйста, выберите хотя бы один.");
                    continue;
                }

                motherboardFormFactor = selectedFormFactors.toString();
                cycleFormFactor = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        // Количество отсеков для 3.5" дисков
        boolean cycleDriveBays35 = true;
        while (cycleDriveBays35) {
            System.out.print("\nВведите количество отсеков для 3.5\" дисков (0-10): ");

            try {
                driveBays35 = scanner.nextInt();
                scanner.nextLine();

                while (driveBays35 < 0 || driveBays35 > 10) {
                    System.out.print("\nНекорректное количество отсеков!\n" +
                            "Введите значение ещё раз (0-10): ");
                    driveBays35 = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleDriveBays35 = false;

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

        // Количество отсеков для 2.5" дисков
        boolean cycleDriveBays25 = true;
        while (cycleDriveBays25) {
            System.out.print("\nВведите количество отсеков для 2.5\" дисков (0-8): ");

            try {
                driveBays25 = scanner.nextInt();
                scanner.nextLine();

                while (driveBays25 < 0 || driveBays25 > 8) {
                    System.out.print("\nНекорректное количество отсеков!\n" +
                            "Введите значение ещё раз (0-8): ");
                    driveBays25 = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleDriveBays25 = false;

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

        // Разъемы на передней панели (можно выбрать несколько)
        int usb2Ports = 0;
        int usb3Ports = 0;
        int usbTypeCPorts = 0;
        int audioPorts = 0;
        boolean hasDiskDriveBay = false;

        // USB 2.0 порты
        boolean cycleUsb2Ports = true;
        while (cycleUsb2Ports) {
            System.out.print("\nВведите количество USB 2.0 портов на передней панели (0-4): ");

            try {
                usb2Ports = scanner.nextInt();
                scanner.nextLine();
                while (usb2Ports < 0 || usb2Ports > 4) {
                    System.out.print("\nНекорректное количество USB 2.0 портов!\n" +
                            "Введите значение ещё раз (0-4): ");
                    usb2Ports = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleUsb2Ports = false;
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

        // USB 3.0 порты
        boolean cycleUsb3Ports = true;
        while (cycleUsb3Ports) {
            System.out.print("\nВведите количество USB 3.0 портов на передней панели (0-4): ");

            try {
                usb3Ports = scanner.nextInt();
                scanner.nextLine();
                while (usb3Ports < 0 || usb3Ports > 4) {
                    System.out.print("\nНекорректное количество USB 3.0 портов!\n" +
                            "Введите значение ещё раз (0-4): ");
                    usb3Ports = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleUsb3Ports = false;
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

        // USB Type-C порты
        boolean cycleUsbTypeCPorts = true;
        while (cycleUsbTypeCPorts) {
            System.out.print("\nВведите количество USB Type-C портов на передней панели (0-2): ");

            try {
                usbTypeCPorts = scanner.nextInt();
                scanner.nextLine();
                while (usbTypeCPorts < 0 || usbTypeCPorts > 2) {
                    System.out.print("\nНекорректное количество USB Type-C портов!\n" +
                            "Введите значение ещё раз (0-2): ");
                    usbTypeCPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleUsbTypeCPorts = false;
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

        // Аудио порты (комбинированный аудио/микрофон)
        boolean cycleAudioPorts = true;
        while (cycleAudioPorts) {
            System.out.print("\nВведите количество комбинированных аудио-разъемов (3.5 мм) на передней панели (0-2): ");

            try {
                audioPorts = scanner.nextInt();
                scanner.nextLine();
                while (audioPorts < 0 || audioPorts > 2) {
                    System.out.print("\nНекорректное количество аудио-разъемов!\n" +
                            "Введите значение ещё раз (0-2): ");
                    audioPorts = scanner.nextInt();
                    scanner.nextLine();
                }
                cycleAudioPorts = false;
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

        // Наличие места для дискового привода
        boolean cycleHasDiskDriveBay = true;
        while (cycleHasDiskDriveBay) {
            System.out.print("\nЕсть ли место для установки дискового привода (оптического привода)?\n" +
                    "Введите:\n" +
                    "1 - если место для дискового привода присутствует\n" +
                    "0 - если место для дискового привода отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasDiskDriveBay = false;
                        cycleHasDiskDriveBay = false;
                        break;
                    case 1:
                        hasDiskDriveBay = true;
                        cycleHasDiskDriveBay = false;
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

        // Формируем строку с описанием передней панели
        StringBuilder frontPanelBuilder = new StringBuilder();

        if (usb2Ports > 0) {
            frontPanelBuilder.append("USB 2.0: ").append(usb2Ports).append(" шт");
        }

        if (usb3Ports > 0) {
            if (frontPanelBuilder.length() > 0) frontPanelBuilder.append(", ");
            frontPanelBuilder.append("USB 3.0: ").append(usb3Ports).append(" шт");
        }

        if (usbTypeCPorts > 0) {
            if (frontPanelBuilder.length() > 0) frontPanelBuilder.append(", ");
            frontPanelBuilder.append("USB Type-C: ").append(usbTypeCPorts).append(" шт");
        }

        if (audioPorts > 0) {
            if (frontPanelBuilder.length() > 0) frontPanelBuilder.append(", ");
            frontPanelBuilder.append("Аудио 3.5 мм: ").append(audioPorts).append(" шт");
        }

        if (hasDiskDriveBay) {
            if (frontPanelBuilder.length() > 0) frontPanelBuilder.append(", ");
            frontPanelBuilder.append("Место для дисковода");
        }

        frontPanel = frontPanelBuilder.toString();

        // Наличие закаленного стекла
        boolean cycleHasTemperedGlass = true;
        while (cycleHasTemperedGlass) {
            System.out.print("\nЕсть ли у корпуса боковое закаленное стекло?\n" +
                    "Введите:\n" +
                    "1 - если стекло присутствует\n" +
                    "0 - если стекло отсутствует (металлическая панель)\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasTemperedGlass = false;
                        cycleHasTemperedGlass = false;
                        break;
                    case 1:
                        hasTemperedGlass = true;
                        cycleHasTemperedGlass = false;
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

        // Наличие RGB подсветки
        boolean cycleHasRGB = true;
        while (cycleHasRGB) {
            System.out.print("\nЕсть ли у корпуса встроенная RGB подсветка?\n" +
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

        // Наличие пылевых фильтров
        boolean cycleHasDustFilters = true;
        while (cycleHasDustFilters) {
            System.out.print("\nЕсть ли у корпуса пылевые фильтры?\n" +
                    "Введите:\n" +
                    "1 - если пылевые фильтры присутствуют\n" +
                    "0 - если пылевые фильтры отсутствуют\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasDustFilters = false;
                        cycleHasDustFilters = false;
                        break;
                    case 1:
                        hasDustFilters = true;
                        cycleHasDustFilters = false;
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

        Map<String, Case> cases = FileManager.loadCase();
        cases.put(id, new Case(
                id, brand, model, price, interfaceType, caseType,
                motherboardFormFactor, driveBays35, driveBays25,
                frontPanel, hasTemperedGlass, hasFanSupport,
                hasRGB, hasDustFilters, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveCase(cases);
        System.out.print("\nКорпус " + brand + " " + model + " успешно зарегистрирован!");
    }


    public static void registrationCooler(String choiceCategory){
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

        String coolerType = null;
        String socketCompatibility = "";
        int fanSize = 0;
        int fanSpeed = 0;
        int tdp = 0;
        int heatPipes = 0;
        boolean hasRGB = false;
        boolean hasPwm = false;

        // Тип кулера (процессорный или корпусный)
        boolean cycleCoolerType = true;
        while (cycleCoolerType) {
            System.out.print("\nВыберите тип кулера:\n" +
                    "1 - Процессорный кулер (воздушный)\n" +
                    "2 - Корпусный вентилятор\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        coolerType = "Процессорный (воздушный)";
                        cycleCoolerType = false;
                        break;
                    case 2:
                        coolerType = "Корпусный вентилятор";
                        cycleCoolerType = false;
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

        // Совместимые сокеты (можно выбрать несколько)
        boolean cycleSocketCompatibility = true;
        while (cycleSocketCompatibility) {
            System.out.print("\nВыберите совместимые сокеты (можно выбрать несколько цифр через пробел):\n" +
                    "1 - LGA 1700\n" +
                    "2 - LGA 1200\n" +
                    "3 - LGA 1151\n" +
                    "4 - AM5\n" +
                    "5 - AM4\n" +
                    "6 - AM3+\n" +
                    "7 - TR4\n" +
                    "8 - sTRX4\n" +
                    "9 - нет (для корпусных кулеров)\n" +
                    "Введите номера выбранных сокетов (например: 1 2 4 5): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedSockets = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1700");
                                break;
                            case 2:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1200");
                                break;
                            case 3:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("LGA 1151");
                                break;
                            case 4:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM5");
                                break;
                            case 5:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM4");
                                break;
                            case 6:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("AM3+");
                                break;
                            case 7:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("TR4");
                                break;
                            case 8:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("sTRX4");
                                break;
                            case 9:
                                if (selectedSockets.length() > 0) selectedSockets.append(", ");
                                selectedSockets.append("нет");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedSockets.length() == 0) {
                    System.out.println("Вы не выбрали ни одного сокета! Пожалуйста, выберите хотя бы один.");
                    continue;
                }

                socketCompatibility = selectedSockets.toString();
                cycleSocketCompatibility = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        // Размер вентилятора
        boolean cycleFanSize = true;
        while (cycleFanSize) {
            System.out.print("\nВведите размер вентилятора в мм (80, 92, 120, 140, 200, 240, 280, 360): ");

            try {
                fanSize = scanner.nextInt();
                scanner.nextLine();

                int[] validSizes = {80, 92, 120, 140, 200, 240, 280, 360};
                boolean isValid = false;

                for (int size : validSizes) {
                    if (fanSize == size) {
                        isValid = true;
                        break;
                    }
                }

                while (!isValid) {
                    System.out.print("\nНекорректный размер вентилятора!\n" +
                            "Введите значение ещё раз (80, 92, 120, 140, 200, 240, 280, 360 мм): ");
                    fanSize = scanner.nextInt();
                    scanner.nextLine();

                    for (int size : validSizes) {
                        if (fanSize == size) {
                            isValid = true;
                            break;
                        }
                    }
                }

                cycleFanSize = false;

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

        // Скорость вращения вентилятора
        boolean cycleFanSpeed = true;
        while (cycleFanSpeed) {
            System.out.print("\nВведите максимальную скорость вращения вентилятора в об/мин (800-3000): ");

            try {
                fanSpeed = scanner.nextInt();
                scanner.nextLine();

                while (fanSpeed < 800 || fanSpeed > 3000) {
                    System.out.print("\nНекорректная скорость вращения!\n" +
                            "Введите значение ещё раз (800-3000 об/мин): ");
                    fanSpeed = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleFanSpeed = false;

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

        // Рассеиваемая мощность (TDP)
        boolean cycleTdp = true;
        while (cycleTdp) {
            System.out.print("\nВведите рассеиваемую мощность (TDP) в Ваттах (65-400): ");

            try {
                tdp = scanner.nextInt();
                scanner.nextLine();

                while (tdp < 65 || tdp > 400) {
                    System.out.print("\nНекорректная мощность TDP!\n" +
                            "Введите значение ещё раз (65-400 Вт): ");
                    tdp = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleTdp = false;

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

        // Количество тепловых трубок (только для процессорных кулеров)
        boolean cycleHeatPipes = true;
        while (cycleHeatPipes) {
            System.out.print("\nВведите количество тепловых трубок (0-8): ");

            try {
                heatPipes = scanner.nextInt();
                scanner.nextLine();

                while (heatPipes < 0 || heatPipes > 8) {
                    System.out.print("\nНекорректное количество тепловых трубок!\n" +
                            "Введите значение ещё раз (0-8): ");
                    heatPipes = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleHeatPipes = false;

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

        // Наличие PWM регулировки
        boolean cycleHasPwm = true;
        while (cycleHasPwm) {
            System.out.print("\nПоддерживает ли вентилятор PWM регулировку оборотов?\n" +
                    "Введите:\n" +
                    "1 - если PWM поддерживается\n" +
                    "0 - если PWM не поддерживается\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        hasPwm = false;
                        cycleHasPwm = false;
                        break;
                    case 1:
                        hasPwm = true;
                        cycleHasPwm = false;
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

        // Наличие RGB подсветки
        boolean cycleHasRGB = true;
        while (cycleHasRGB) {
            System.out.print("\nЕсть ли у кулера RGB подсветка?\n" +
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

        Map<String, Cooler> coolers = FileManager.loadCooler();
        coolers.put(id, new Cooler(
                id, brand, model, price, interfaceType, coolerType,
                socketCompatibility, fanSize, fanSpeed, tdp,
                heatPipes, hasRGB, hasPwm,
                powerConsumption, voltage, dimensions, weight,
                countryProduction, productionDate, category,
                description, warrantyMoths
        ));

        FileManager.saveCooler(coolers);
        System.out.print("\nКулер " + brand + " " + model + " успешно зарегистрирован!");


    }


    public static void registrationSoftware(String choiceCategory){
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

        String softwareType = null;
        int licenseDuration = 0;
        String supportedOS = "";
        String systemRequirements = "";
        boolean isDigital = false;
        String languages = "";

        // Тип программного обеспечения
        boolean cycleSoftwareType = true;
        while (cycleSoftwareType) {
            System.out.print("\nВыберите тип программного обеспечения:\n" +
                    "1 - Операционная система\n" +
                    "2 - Антивирус\n" +
                    "3 - Офисный пакет\n" +
                    "4 - Графический редактор\n" +
                    "5 - Игра\n" +
                    "6 - Утилита\n" +
                    "7 - Драйвер\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        softwareType = "Операционная система";
                        cycleSoftwareType = false;
                        break;
                    case 2:
                        softwareType = "Антивирус";
                        cycleSoftwareType = false;
                        break;
                    case 3:
                        softwareType = "Офисный пакет";
                        cycleSoftwareType = false;
                        break;
                    case 4:
                        softwareType = "Графический редактор";
                        cycleSoftwareType = false;
                        break;
                    case 5:
                        softwareType = "Игра";
                        cycleSoftwareType = false;
                        break;
                    case 6:
                        softwareType = "Утилита";
                        cycleSoftwareType = false;
                        break;
                    case 7:
                        softwareType = "Драйвер";
                        cycleSoftwareType = false;
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

        // Срок лицензии
        boolean cycleLicenseDuration = true;
        while (cycleLicenseDuration) {
            System.out.print("\nВведите срок лицензии в месяцах (0 = бессрочная, 1-120 месяцев): ");

            try {
                licenseDuration = scanner.nextInt();
                scanner.nextLine();

                while (licenseDuration < 0 || licenseDuration > 120) {
                    System.out.print("\nНекорректный срок лицензии!\n" +
                            "Введите значение ещё раз (0-120 месяцев): ");
                    licenseDuration = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleLicenseDuration = false;

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

        // Поддерживаемые операционные системы (можно выбрать несколько)
        boolean cycleSupportedOS = true;
        while (cycleSupportedOS) {
            System.out.print("\nВыберите поддерживаемые операционные системы (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Windows 10/11\n" +
                    "2 - Windows 7/8\n" +
                    "3 - macOS\n" +
                    "4 - Linux\n" +
                    "5 - Android\n" +
                    "6 - iOS\n" +
                    "7 - PS5\n" +
                    "8 - PS4/5\n" +
                    "Введите номера выбранных ОС (например: 1 3 4): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedOS = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Windows 10/11");
                                break;
                            case 2:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Windows 7/8");
                                break;
                            case 3:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("macOS");
                                break;
                            case 4:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Linux");
                                break;
                            case 5:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("Android");
                                break;
                            case 6:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("iOS");
                                break;
                            case 7:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("PS5");
                                break;
                            case 8:
                                if (selectedOS.length() > 0) selectedOS.append(", ");
                                selectedOS.append("PS4/5");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedOS.length() == 0) {
                    System.out.println("Вы не выбрали ни одной ОС! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                supportedOS = selectedOS.toString();
                cycleSupportedOS = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        // Системные требования
        boolean cycleSystemRequirements = true;
        while (cycleSystemRequirements) {
            System.out.print("\nВведите системные требования (можно подробно описать требования к железу): ");

            try {
                systemRequirements = scanner.nextLine();

                if (systemRequirements.trim().isEmpty()) {
                    System.out.println("Системные требования не могут быть пустыми! Пожалуйста, введите описание.");
                    continue;
                }

                cycleSystemRequirements = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!");
            }
        }

        // Тип версии (цифровая или коробочная)
        boolean cycleIsDigital = true;
        while (cycleIsDigital) {
            System.out.print("\nВыберите тип версии:\n" +
                    "1 - Цифровая версия (электронный ключ/файл)\n" +
                    "2 - Коробочная версия (физический носитель)\n" +
                    "Ваш выбор: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        isDigital = true;
                        cycleIsDigital = false;
                        break;
                    case 2:
                        isDigital = false;
                        cycleIsDigital = false;
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

        // Поддерживаемые языки (можно выбрать несколько)
        boolean cycleLanguages = true;
        while (cycleLanguages) {
            System.out.print("\nВыберите поддерживаемые языки (можно выбрать несколько цифр через пробел):\n" +
                    "1 - Русский\n" +
                    "2 - Английский\n" +
                    "3 - Немецкий\n" +
                    "4 - Французский\n" +
                    "5 - Испанский\n" +
                    "6 - Китайский\n" +
                    "7 - Японский\n" +
                    "8 - Многоязычная версия\n" +
                    "Введите номера выбранных языков (например: 1 2 8): ");

            try {
                String input = scanner.nextLine();
                String[] choices = input.split(" ");

                StringBuilder selectedLanguages = new StringBuilder();

                for (String choiceStr : choices) {
                    try {
                        int choice = Integer.parseInt(choiceStr);
                        switch (choice) {
                            case 1:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Русский");
                                break;
                            case 2:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Английский");
                                break;
                            case 3:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Немецкий");
                                break;
                            case 4:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Французский");
                                break;
                            case 5:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Испанский");
                                break;
                            case 6:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Китайский");
                                break;
                            case 7:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Японский");
                                break;
                            case 8:
                                if (selectedLanguages.length() > 0) selectedLanguages.append(", ");
                                selectedLanguages.append("Многоязычная");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем некорректные вводы
                    }
                }

                if (selectedLanguages.length() == 0) {
                    System.out.println("Вы не выбрали ни одного языка! Пожалуйста, выберите хотя бы один.");
                    continue;
                }

                languages = selectedLanguages.toString();
                cycleLanguages = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }

        Map<String, Software> softwareMap = FileManager.loadSoftware();
        softwareMap.put(id, new Software(
                id, brand, model, softwareType,
                licenseDuration, supportedOS, systemRequirements,
                isDigital, languages, countryProduction,
                productionDate, category, price, description, warrantyMoths
        ));

        FileManager.saveSoftware(softwareMap);
        System.out.print("\nПрограммное обеспечение " + brand + " " + model + " успешно зарегистрировано!");

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
