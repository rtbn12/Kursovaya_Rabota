import java.util.Scanner;

public class RAM extends ComputerComponent{

    private int capacity;           // Объем одного модуля (ГБ)
    private int frequency;          // Частота (МГц)
    private int latency;            // Тайминги (CL16, CL18)
    private String memoryType;      // Тип памяти (DDR4, DDR5)
    private int modulesCount;       // Количество модулей в комплекте
    private boolean hasRGB;         // RGB подсветка
    private boolean hasHeatSpreader; // Радиатор охлаждения


    // Конструктор для создания новой оперативной памяти через Scanner
    public RAM(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setCapacity(scanner);
        setFrequency(scanner);
        setLatency(scanner);
        setMemoryType(scanner);
        setModulesCount(scanner);
        setHasRGB(scanner);
        setHasHeatSpreader(scanner);
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Scanner scanner) {
        boolean cycleCapacity = true;
        while (cycleCapacity) {
            System.out.print("\nВведите объем одного модуля в ГБ (4, 8, 16, 32, 64): ");

            try {
                int capacity = scanner.nextInt();
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

                this.capacity = capacity;
                cycleCapacity = false;

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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(Scanner scanner) {
        boolean cycleFrequency = true;
        while (cycleFrequency) {
            System.out.print("\nВведите частоту памяти в МГц (2133, 2400, 2666, 3000, 3200, 3600, 4000, 4400, 4800, 5200, 5600, 6000, 6400, 6800, 7200): ");

            try {
                int frequency = scanner.nextInt();
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

                this.frequency = frequency;
                cycleFrequency = false;

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

    public int getLatency() {
        return latency;
    }

    public void setLatency(Scanner scanner) {
        boolean cycleLatency = true;
        while (cycleLatency) {
            System.out.print("\nВведите тайминги памяти (CL14, CL16, CL18, CL20, CL22, CL24, CL28, CL30, CL32, CL34, CL36, CL38, CL40): ");
            System.out.print("\nВведите только число после CL: ");

            try {
                int latency = scanner.nextInt();
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

                this.latency = latency;
                cycleLatency = false;

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
                        this.memoryType = "DDR4";
                        cycleMemoryType = false;
                        break;
                    case 2:
                        this.memoryType = "DDR5";
                        cycleMemoryType = false;
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

    public int getModulesCount() {
        return modulesCount;
    }

    public void setModulesCount(Scanner scanner) {
        boolean cycleModulesCount = true;
        while (cycleModulesCount) {
            System.out.print("\nВведите количество модулей в комплекте (1, 2, 4, 8): ");

            try {
                int modulesCount = scanner.nextInt();
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

                this.modulesCount = modulesCount;
                cycleModulesCount = false;

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

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(Scanner scanner) {
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
                        this.hasRGB = false;
                        cycleHasRGB = false;
                        break;
                    case 1:
                        this.hasRGB = true;
                        cycleHasRGB = false;
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

    public boolean isHasHeatSpreader() {
        return hasHeatSpreader;
    }

    public void setHasHeatSpreader(Scanner scanner) {
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
                        this.hasHeatSpreader = false;
                        cycleHasHeatSpreader = false;
                        break;
                    case 1:
                        this.hasHeatSpreader = true;
                        cycleHasHeatSpreader = false;
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
        System.out.println("Объем одного модуля: " + getCapacity() + " ГБ");
        System.out.println("Количество модулей: " + getModulesCount());
        System.out.println("Общий объем комплекта: " + (getCapacity()*getModulesCount()) + " ГБ");
        System.out.println("Частота: " + getFrequency() + " МГц");
        System.out.println("Тайминги: CL" + getLatency());
        System.out.println("Тип памяти: " + getMemoryType());
        System.out.println("RGB подсветка: " + (hasRGB ? "Да" : "Нет"));
        System.out.println("Радиатор охлаждения: " + (hasHeatSpreader ? "Да" : "Нет"));
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
