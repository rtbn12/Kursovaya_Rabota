import java.util.Scanner;

public class PowerSupply extends ComputerComponent{


    private String efficiency;      // Сертификат эффективности (80+ Bronze, Gold, Platinum)
    private String modularity;      // Модульность (Full, Semi, Non)
    private int sataConnectors;     // Количество SATA разъемов
    private int pcieConnectors;     // Количество PCI-E разъемов
    private int cpuConnectors;      // Количество CPU разъемов (4+4 pin, 8 pin)
    private String fanSize;         // Размер вентилятора (мм)
    private String protections;     // Защиты (OCP, OVP, UVP, OPP, SCP)


    public PowerSupply(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setEfficiency(scanner);
        setModularity(scanner);
        setSataConnectors(scanner);
        setPcieConnectors(scanner);
        setCpuConnectors(scanner);
        setFanSize(scanner);
        setProtections(scanner);
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Scanner scanner) {
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
                        this.efficiency = "80 PLUS Bronze";
                        cycleEfficiency = false;
                        break;
                    case 2:
                        this.efficiency = "80 PLUS Silver";
                        cycleEfficiency = false;
                        break;
                    case 3:
                        this.efficiency = "80 PLUS Gold";
                        cycleEfficiency = false;
                        break;
                    case 4:
                        this.efficiency = "80 PLUS Platinum";
                        cycleEfficiency = false;
                        break;
                    case 5:
                        this.efficiency = "80 PLUS Titanium";
                        cycleEfficiency = false;
                        break;
                    case 6:
                        this.efficiency = "Без сертификата";
                        cycleEfficiency = false;
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

    public String getModularity() {
        return modularity;
    }

    public void setModularity(Scanner scanner) {
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
                        this.modularity = "Полная модульность (Full Modular)";
                        cycleModularity = false;
                        break;
                    case 2:
                        this.modularity = "Частичная модульность (Semi Modular)";
                        cycleModularity = false;
                        break;
                    case 3:
                        this.modularity = "Немодульный (Non Modular)";
                        cycleModularity = false;
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

    public int getSataConnectors() {
        return sataConnectors;
    }

    public void setSataConnectors(Scanner scanner) {
        boolean cycleSataConnectors = true;
        while (cycleSataConnectors) {
            System.out.print("\nВведите количество SATA разъемов (4-12): ");

            try {
                int sataConnectors = scanner.nextInt();
                scanner.nextLine();

                while (sataConnectors < 4 || sataConnectors > 12) {
                    System.out.print("\nНекорректное количество SATA разъемов!\n" +
                            "Введите значение ещё раз (4-12): ");
                    sataConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                this.sataConnectors = sataConnectors;
                cycleSataConnectors = false;

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

    public int getPcieConnectors() {
        return pcieConnectors;
    }

    public void setPcieConnectors(Scanner scanner) {
        boolean cyclePcieConnectors = true;
        while (cyclePcieConnectors) {
            System.out.print("\nВведите количество PCI-E разъемов (6+2 pin) (1-8): ");

            try {
                int pcieConnectors = scanner.nextInt();
                scanner.nextLine();

                while (pcieConnectors < 1 || pcieConnectors > 8) {
                    System.out.print("\nНекорректное количество PCI-E разъемов!\n" +
                            "Введите значение ещё раз (1-8): ");
                    pcieConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                this.pcieConnectors = pcieConnectors;
                cyclePcieConnectors = false;

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

    public int getCpuConnectors() {
        return cpuConnectors;
    }

    public void setCpuConnectors(Scanner scanner) {
        boolean cycleCpuConnectors = true;
        while (cycleCpuConnectors) {
            System.out.print("\nВведите количество CPU разъемов (4+4 pin) (1-4): ");

            try {
                int cpuConnectors = scanner.nextInt();
                scanner.nextLine();

                while (cpuConnectors < 1 || cpuConnectors > 4) {
                    System.out.print("\nНекорректное количество CPU разъемов!\n" +
                            "Введите значение ещё раз (1-4): ");
                    cpuConnectors = scanner.nextInt();
                    scanner.nextLine();
                }

                this.cpuConnectors = cpuConnectors;
                cycleCpuConnectors = false;

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

    public String getFanSize() {
        return fanSize;
    }

    public void setFanSize(Scanner scanner) {
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
                        this.fanSize = "80 мм";
                        cycleFanSize = false;
                        break;
                    case 2:
                        this.fanSize = "120 мм";
                        cycleFanSize = false;
                        break;
                    case 3:
                        this.fanSize = "135 мм";
                        cycleFanSize = false;
                        break;
                    case 4:
                        this.fanSize = "140 мм";
                        cycleFanSize = false;
                        break;
                    case 5:
                        this.fanSize = "Пассивное охлаждение";
                        cycleFanSize = false;
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

    public String getProtections() {
        return protections;
    }

    public void setProtections(Scanner scanner) {
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
                        // Пропускаем нечисловые значения
                    }
                }

                if (selectedProtections.length() == 0) {
                    System.out.println("Вы не выбрали ни одной защиты! Пожалуйста, выберите хотя бы одну.");
                    continue;
                }

                this.protections = selectedProtections.toString();
                cycleProtections = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
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
        System.out.println("Потребляемая мощность: " + getPowerConsumption() + " ВТ");
        System.out.println("Рабочее напряжение: " + getVoltage() + " V");
        System.out.println("Сертификат эффективности: " + getEfficiency());
        System.out.println("Модульность: " + getModularity());
        System.out.println("Разъемы SATA: " + getSataConnectors());
        System.out.println("Разъемы PCI-E: " + getPcieConnectors() + " (6+2 pin)");
        System.out.println("Разъемы CPU: " + getCpuConnectors() + " (4+4 pin)");
        System.out.println("Вентилятор: " + getFanSize() + " мм " );
        System.out.println("Защиты: " + getProtections());
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());

    }
}
