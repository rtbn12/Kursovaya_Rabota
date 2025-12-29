import java.util.Scanner;

public class Peripheral extends Product{

    private String connectionType;    // Тип подключения (USB, Bluetooth, Wireless)
    private double cableLength;       // Длина кабеля (м), 0 для беспроводных
    private boolean isWireless;       // Беспроводное устройство
    private boolean hasRGB;           // RGB подсветка
    private String color;             // цвет устройства



    public Peripheral(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setConnectionType(scanner);
        setIsWireless(scanner);
        setCableLength(scanner);
        setHasRGB(scanner);
        setColor(scanner);
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(Scanner scanner) {
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
                        this.connectionType = "USB";
                        cycleConnectionType = false;
                        break;
                    case 2:
                        this.connectionType = "USB-C";
                        cycleConnectionType = false;
                        break;
                    case 3:
                        this.connectionType = "HDMI";
                        cycleConnectionType = false;
                        break;
                    case 4:
                        this.connectionType = "DisplayPort";
                        cycleConnectionType = false;
                        break;
                    case 5:
                        this.connectionType = "Bluetooth";
                        cycleConnectionType = false;
                        break;
                    case 6:
                        this.connectionType = "Wireless (2.4 ГГц)";
                        cycleConnectionType = false;
                        break;
                    case 7:
                        this.connectionType = "PS/2";
                        cycleConnectionType = false;
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

    public double getCableLength() {
        return cableLength;
    }

    public void setCableLength(Scanner scanner) {
        // Если устройство беспроводное, кабель = 0
        if (this.isWireless) {
            this.cableLength = 0.0;
            return;
        }

        boolean cycleCableLength = true;
        while (cycleCableLength) {
            System.out.print("\nВведите длину кабеля в метрах (0.5 - 3.0): ");

            try {
                double cableLength = scanner.nextDouble();
                scanner.nextLine();

                while (cableLength < 0.5 || cableLength > 3.0) {
                    System.out.print("\nНекорректная длина кабеля!\n" +
                            "Введите значение ещё раз (0.5 - 3.0 метра): ");
                    cableLength = scanner.nextDouble();
                    scanner.nextLine();
                }

                this.cableLength = cableLength;
                cycleCableLength = false;

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

    public boolean isWireless() {
        return isWireless;
    }

    public void setIsWireless(Scanner scanner) {
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
                        this.isWireless = false;
                        cycleIsWireless = false;
                        break;
                    case 1:
                        this.isWireless = true;
                        cycleIsWireless = false;
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

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(Scanner scanner) {
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

    public String getColor() {
        return color;
    }

    public void setColor(Scanner scanner) {
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
                        this.color = "Черный";
                        cycleColor = false;
                        break;
                    case 2:
                        this.color = "Белый";
                        cycleColor = false;
                        break;
                    case 3:
                        this.color = "Серый";
                        cycleColor = false;
                        break;
                    case 4:
                        this.color = "Красный";
                        cycleColor = false;
                        break;
                    case 5:
                        this.color = "Синий";
                        cycleColor = false;
                        break;
                    case 6:
                        this.color = "Зеленый";
                        cycleColor = false;
                        break;
                    case 7:
                        System.out.print("Введите название цвета: ");
                        String color = scanner.nextLine();
                        if (color.trim().isEmpty()) {
                            System.out.println("Цвет не может быть пустым!");
                            continue;
                        }
                        this.color = color;
                        cycleColor = false;
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


}
