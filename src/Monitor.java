import java.util.Scanner;

public class Monitor extends Peripheral{

    private double screenSize;        // Диагональ экрана (дюймы)
    private String resolution;        // Разрешение (1920x1080, 2560x1440)
    private int refreshRate;          // Частота обновления (Гц)
    private String panelType;         // Тип матрицы (IPS, VA, TN, OLED)
    private int responseTime;         // Время отклика (мс)
    private boolean hasHDR;           // Поддержка HDR
    private boolean hasBuiltInSpeakers; // Встроенные колонки

    public Monitor(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setScreenSize(scanner);
        setResolution(scanner);
        setRefreshRate(scanner);
        setPanelType(scanner);
        setResponseTime(scanner);
        setHasHDR(scanner);
        setHasBuiltInSpeakers(scanner);
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Scanner scanner) {
        boolean cycleScreenSize = true;
        while (cycleScreenSize) {
            System.out.print("\nВведите диагональ экрана в дюймах (15.6, 21.5, 24, 27, 32, 34, 49): ");

            try {
                double screenSize = scanner.nextDouble();
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

                this.screenSize = screenSize;
                cycleScreenSize = false;

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

    public String getResolution() {
        return resolution;
    }

    public void setResolution(Scanner scanner) {
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
                        this.resolution = "1920x1080 (Full HD)";
                        cycleResolution = false;
                        break;
                    case 2:
                        this.resolution = "2560x1440 (QHD / 2K)";
                        cycleResolution = false;
                        break;
                    case 3:
                        this.resolution = "3840x2160 (4K UHD)";
                        cycleResolution = false;
                        break;
                    case 4:
                        this.resolution = "3440x1440 (UltraWide QHD)";
                        cycleResolution = false;
                        break;
                    case 5:
                        this.resolution = "5120x1440 (Super UltraWide)";
                        cycleResolution = false;
                        break;
                    case 6:
                        this.resolution = "2560x1080 (UltraWide Full HD)";
                        cycleResolution = false;
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

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Scanner scanner) {
        boolean cycleRefreshRate = true;
        while (cycleRefreshRate) {
            System.out.print("\nВведите частоту обновления экрана в Гц (60, 75, 100, 120, 144, 165, 180, 240, 360): ");

            try {
                int refreshRate = scanner.nextInt();
                scanner.nextLine();

                int[] validRates = {60, 75, 100, 120, 144, 165, 180, 240, 360};
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

                this.refreshRate = refreshRate;
                cycleRefreshRate = false;

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

    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(Scanner scanner) {
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
                        this.panelType = "IPS";
                        cyclePanelType = false;
                        break;
                    case 2:
                        this.panelType = "VA";
                        cyclePanelType = false;
                        break;
                    case 3:
                        this.panelType = "TN";
                        cyclePanelType = false;
                        break;
                    case 4:
                        this.panelType = "OLED";
                        cyclePanelType = false;
                        break;
                    case 5:
                        this.panelType = "Nano-IPS";
                        cyclePanelType = false;
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

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Scanner scanner) {
        boolean cycleResponseTime = true;
        while (cycleResponseTime) {
            System.out.print("\nВведите время отклика в миллисекундах (1, 2, 4, 5, 8): ");

            try {
                int responseTime = scanner.nextInt();
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

                this.responseTime = responseTime;
                cycleResponseTime = false;

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

    public boolean isHasHDR() {
        return hasHDR;
    }

    public void setHasHDR(Scanner scanner) {
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
                        this.hasHDR = false;
                        cycleHasHDR = false;
                        break;
                    case 1:
                        this.hasHDR = true;
                        cycleHasHDR = false;
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

    public boolean isHasBuiltInSpeakers() {
        return hasBuiltInSpeakers;
    }

    public void setHasBuiltInSpeakers(Scanner scanner) {
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
                        this.hasBuiltInSpeakers = false;
                        cycleHasBuiltInSpeakers = false;
                        break;
                    case 1:
                        this.hasBuiltInSpeakers = true;
                        cycleHasBuiltInSpeakers = false;
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
        System.out.println("Цена: " + getPrice());
        System.out.println("Диагональ экрана: " + getScreenSize() + " дюйм(ов)");
        System.out.println("Разрешение: " + getResolution());
        System.out.println("Частота обновления: " + getRefreshRate() + " Гц");
        System.out.println("Тип матрицы: " + getPanelType());
        System.out.println("Время отклика: " + getResponseTime() + " мс");
        System.out.println("Поддержка HDR: " + (isHasHDR() ? "Да" : "Нет"));
        System.out.println("Встроенные колонки: " + (isHasBuiltInSpeakers() ? "Да" : "Нет"));
        System.out.println("Цвет устройства: " + getColor());
        System.out.println("Доступные типы подключения: " + getConnectionType());
        System.out.println("Длина кабеля: " + getCableLength() + " м");
        System.out.println("Беспроводное устройство: " + (isWireless() ? "Да" : "Нет"));
        System.out.println("Наличие RGB подсветки: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
