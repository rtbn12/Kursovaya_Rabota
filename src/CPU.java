import java.util.Scanner;

public class CPU extends ComputerComponent{

    private String socket;          // AM4, LGA1700, AM5
    private int coreCount;          // Количество ядер (6, 8, 12)
    private int threadCount;        // Количество потоков (12, 16, 24)
    private double baseFrequency;   // Базовая частота (ГГц)
    private double maxFrequency;    // Максимальная частота (ГГц)
    private int cacheSize;          // Размер кэша (МБ)
    private String memoryType;      // Поддерживаемая память (DDR4, DDR5)
    private boolean hasIntegratedGraphics; // Встроенная графика

    public CPU(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setSocket(scanner);
        setCoreCount(scanner);
        setThreadCount(scanner);
        setBaseFrequency(scanner);
        setMaxFrequency(scanner);
        setCacheSize(scanner);
        setMemoryType(scanner);
        setHasIntegratedGraphics(scanner);
    }


    public String getSocket() {
        return socket;
    }

    public void setSocket(Scanner scanner) {
        System.out.print("\nВведите сокет процессора: ");
        this.socket = scanner.nextLine();
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(Scanner scanner) {
        boolean cyclecoreCount = true;
        while (cyclecoreCount) {
            System.out.print("\nВведите количество ядер процессора: ");

            try {
                int coreCount = scanner.nextInt();
                scanner.nextLine();
                while (coreCount < 0 || coreCount > 256 || coreCount % 2 != 0) {
                    System.out.print("\nНекорректное количество ядер процессора!\n" +
                            "Введите значение ещё раз: ");
                    coreCount = scanner.nextInt();
                    scanner.nextLine();
                }
                this.coreCount = coreCount;
                cyclecoreCount = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Scanner scanner) {
        boolean cyclethreadCount = true;
        while (cyclethreadCount) {
            System.out.print("\nВведите количество потоков процессора: ");

            try {
                int threadCount = scanner.nextInt();
                scanner.nextLine();
                while (threadCount < 0 || threadCount > 512 || threadCount % 2 != 0) {
                    System.out.print("\nНекорректное количество потоков процессора!\n" +
                            "Введите значение ещё раз: ");
                    threadCount = scanner.nextInt();
                    scanner.nextLine();
                }
                this.threadCount = threadCount;
                cyclethreadCount = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public double getBaseFrequency() {
        return baseFrequency;
    }

    public void setBaseFrequency(Scanner scanner) {
        boolean cyclebaseFrequency = true;
        while (cyclebaseFrequency) {
            System.out.print("\nВведите базовую частоту процессора: ");

            try {
                double baseFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (baseFrequency < 0 || baseFrequency > 12) {
                    System.out.print("\nНекорректная базовая частота процессора!\n" +
                            "Введите значение ещё раз: ");
                    baseFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                this.baseFrequency = baseFrequency;
                cyclebaseFrequency = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public double getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(Scanner scanner) {
        boolean cyclemaxFrequency = true;
        while (cyclemaxFrequency) {
            System.out.print("\nВведите максимальную частоту процессора: ");

            try {
                double maxFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (maxFrequency < 0 || maxFrequency > 20 || maxFrequency < this.baseFrequency) {
                    System.out.print("\nНекорректная максимальная частота процессора!\n" +
                            "Введите значение ещё раз: ");
                    maxFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                this.maxFrequency = maxFrequency;
                cyclemaxFrequency = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Scanner scanner) {
        boolean cyclecacheSize = true;
        while (cyclecacheSize) {
            System.out.print("\nВведите объём кэша процессора: ");

            try {
                int cacheSize = scanner.nextInt();
                scanner.nextLine();
                while (cacheSize < 0 || cacheSize > 512 || cacheSize % 2 != 0) {
                    System.out.print("\nНекорректный объём кэша процессора!\n" +
                            "Введите значение ещё раз: ");
                    cacheSize = scanner.nextInt();
                    scanner.nextLine();
                }
                this.cacheSize = cacheSize;
                cyclecacheSize = false;

            } catch (java.util.InputMismatchException p) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное значение!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            } catch (Exception p) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(Scanner scanner) {
        System.out.print("\nВведите поддерживаемые процессором типы памяти: ");
        this.memoryType = scanner.nextLine();
    }

    public boolean isHasIntegratedGraphics() {
        return hasIntegratedGraphics;
    }

    public void setHasIntegratedGraphics(Scanner scanner) {
        boolean cyclehasIntegratedGraphics = true;
        while (cyclehasIntegratedGraphics) {
            System.out.print("\nЕсть ли у процессора встроенная графика?\n" +
                    "Введите:\n" +
                    "1-если встроенная графика присутствует\n" +
                    "0-если встроенная графика отсутствует\n" +
                    "Ваш выбор: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        this.hasIntegratedGraphics = false;
                        cyclehasIntegratedGraphics = false;
                        break;
                    case 1:
                        this.hasIntegratedGraphics = true;
                        cyclehasIntegratedGraphics = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректную цифру!");
                }

            } catch (java.util.InputMismatchException e) {
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



    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейс подключения: " + getInterfaceType());
        System.out.println("Сокет: " + getSocket());
        System.out.println("Количество ядер: " + getCoreCount());
        System.out.println("Количество потоков: " + getThreadCount());
        System.out.println("Базовая частота: " + getBaseFrequency() + " ГГц");
        System.out.println("Максимальная частота: " + getMaxFrequency()+ " ГГц");
        System.out.println("Размер кэша: " + getCacheSize() + " МБ");
        System.out.println("Поддерживаемые типы памяти: " + getMemoryType());
        System.out.println("Наличие встроенного графического ядра: " + (hasIntegratedGraphics?" Да":" Нет"));
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Описание: " + getDescription());
    }
}
