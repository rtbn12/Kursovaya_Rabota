import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {

    public static Product registrationProduct (String choiceCategory) {
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


        boolean cycleCPU = true;
        int productionDate=0;
        while (cycleCPU)
        {
            System.out.print("\nВведите год производства:");

            try {
                 productionDate = scanner.nextInt();
                scanner.nextLine();
                while((productionDate < 2018) || productionDate > Calendar.getInstance().get(Calendar.YEAR))
                {
                    System.out.print("\nНекорректный год производства!\n" +
                            "Введите год производства ещё раз:");
                    productionDate = scanner.nextInt();
                    scanner.nextLine();
                }

                cycleCPU = false;

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


        int price =0;
        boolean cyclePrice = true;
        while (cyclePrice)
        {
            System.out.print("\nВведите цену товара:");

            try {
                price = scanner.nextInt();
                scanner.nextLine();
                while (price <=0 || price>1000_000)
                {
                    System.out.print("\nВведена недоступная цена для товара!\n" +
                            "Введите цену ещё раз:");
                    price = scanner.nextInt();
                    scanner.nextLine();
                }

                cyclePrice = false;

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
                System.out.print("\nВведите количество аналоговых аудиовыходов (3-8): ");

                try {
                    audioPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (audioPorts < 3 || audioPorts > 8) {
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
                while (lanSpeed < 0 || lanSpeed > 2500) {
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
                while (vramSize < 1 || vramSize > 24) {
                    System.out.print("\nНекорректный объем видеопамяти!\n" +
                            "Введите значение ещё раз (1-24 ГБ): ");
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
            System.out.print("\nВведите количество CUDA ядер (256-18432): ");

            try {
                cudaCores = scanner.nextInt();
                scanner.nextLine();
                while (cudaCores < 256 || cudaCores > 18432) {
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
            System.out.print("\nВведите ширину шины памяти в битах (64, 128, 192, 256, 384): ");

            try {
                memoryBusWidth = scanner.nextInt();
                scanner.nextLine();

                int[] validBusWidths = {64, 128, 192, 256, 384};
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


    public static void registrationStorage(String choiceCategory){}
    public static void registrationPowerSupply(String choiceCategory){}
    public static void registrationCase(String choiceCategory){}
    public static void registrationCooler(String choiceCategory){}
    public static void registrationSoftware(String choiceCategory){}
    public static void registrationMonitor(String choiceCategory){}
    public static void registrationMouse(String choiceCategory){}
    public static void registrationKeyBoard(String choiceCategory){}



    public static void PrintCPU() {
        Map<String,Product> products = FileManager.loadProduct0();
        Map<String,CPU> CPUs = FileManager.loadCPU();

        System.out.println("============================ Базовая информация ================================");

        for (Product product : products.values())
        {

            if (product.getCategory().equals("Центральный процессор")) {
                product.getMiniInfo();
            }
        }

        System.out.println("============================ Полная информация ================================");

        for(CPU cpu : CPUs.values())
        {
            cpu.getFullInfoForClient();
            cpu.getFullInfoForSeller();
        }
    }

    public static void PrintMotherBoard() {
        Map<String, Product> products = FileManager.loadProduct0();
        Map<String, MotherBoard> motherBoards = FileManager.loadMotherBoard();

        System.out.println("\n============================ Базовая информация ================================");

        for (Product product : products.values()) {
            if (product.getCategory().equals("Материнская плата")) {
                product.getMiniInfo();
            }
        }

        System.out.println("\n============================ Полная информация ================================");

        for (MotherBoard mb : motherBoards.values()) {
            mb.getFullInfoForClient();
            mb.getFullInfoForSeller();
        }
    }

    public static void PrintGPU() {
        Map<String, Product> products = FileManager.loadProduct0();
        Map<String, GPU> GPUs = FileManager.loadGPU();

        System.out.println("\n============================ Базовая информация ================================");

        for (Product product : products.values()) {
            if (product.getCategory().equals("Видеокарта")) {
                product.getMiniInfo();
            }
        }

        System.out.println("\n============================ Полная информация ================================");

        for (GPU gpu : GPUs.values()) {
            gpu.getFullInfoForClient();
            gpu.getFullInfoForSeller();
        }
    }

    public static void PrintRAM() {
        Map<String, Product> products = FileManager.loadProduct0();
        Map<String, RAM> RAMs = FileManager.loadRAM();

        System.out.println("\n============================ Базовая информация ================================");

        for (Product product : products.values()) {
            if (product.getCategory().equals("Оперативная память")) {
                product.getMiniInfo();
            }
        }

        System.out.println("\n============================ Полная информация ================================");

        for (RAM ram : RAMs.values()) {
            ram.getFullInfoForClient();
            ram.getFullInfoForSeller();
        }
    }
}
