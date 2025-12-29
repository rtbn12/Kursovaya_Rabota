import java.util.Scanner;

public class Case extends ComputerComponent{


    private String caseType;        // Тип корпуса (Full-Tower, Mid-Tower, Mini-Tower)
    private String motherboardFormFactor; // Поддерживаемые форм-факторы (ATX, mATX, ITX)
    private int driveBays35;        // Отсеки для 3.5" дисков
    private int driveBays25;        // Отсеки для 2.5" дисков
    private String frontPanel;      // Разъемы на передней панели (USB, Audio)
    private boolean hasTemperedGlass; // Боковое стекло
    private boolean hasFanSupport;      // Поддержка вентиляторов
    private boolean hasRGB;         // RGB подсветка
    private boolean hasDustFilters; // Пылевые фильтры


    public Case(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setCaseType(scanner);
        setMotherboardFormFactor(scanner);
        setDriveBays35(scanner);
        setDriveBays25(scanner);
        setFrontPanel(scanner);
        setHasTemperedGlass(scanner);
        setHasRGB(scanner);
        setHasDustFilters(scanner);
        this.hasFanSupport = true;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(Scanner scanner) {
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
                        this.caseType = "Full-Tower";
                        cycleCaseType = false;
                        break;
                    case 2:
                        this.caseType = "Mid-Tower";
                        cycleCaseType = false;
                        break;
                    case 3:
                        this.caseType = "Mini-Tower";
                        cycleCaseType = false;
                        break;
                    case 4:
                        this.caseType = "SFF (Small Form Factor)";
                        cycleCaseType = false;
                        break;
                    case 5:
                        this.caseType = "HTPC";
                        cycleCaseType = false;
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

    public String getMotherboardFormFactor() {
        return motherboardFormFactor;
    }

    public void setMotherboardFormFactor(Scanner scanner) {
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

                this.motherboardFormFactor = selectedFormFactors.toString();
                cycleFormFactor = false;

            } catch (Exception e) {
                System.out.println("Произошла ошибка при вводе!\n" +
                        "Пожалуйста, введите цифры через пробел.");
            }
        }
    }

    public int getDriveBays35() {
        return driveBays35;
    }

    public void setDriveBays35(Scanner scanner) {
        boolean cycleDriveBays35 = true;
        while (cycleDriveBays35) {
            System.out.print("\nВведите количество отсеков для 3.5\" дисков (0-10): ");

            try {
                int driveBays35 = scanner.nextInt();
                scanner.nextLine();

                while (driveBays35 < 0 || driveBays35 > 10) {
                    System.out.print("\nНекорректное количество отсеков!\n" +
                            "Введите значение ещё раз (0-10): ");
                    driveBays35 = scanner.nextInt();
                    scanner.nextLine();
                }

                this.driveBays35 = driveBays35;
                cycleDriveBays35 = false;

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

    public int getDriveBays25() {
        return driveBays25;
    }

    public void setDriveBays25(Scanner scanner) {
        boolean cycleDriveBays25 = true;
        while (cycleDriveBays25) {
            System.out.print("\nВведите количество отсеков для 2.5\" дисков (0-8): ");

            try {
                int driveBays25 = scanner.nextInt();
                scanner.nextLine();

                while (driveBays25 < 0 || driveBays25 > 8) {
                    System.out.print("\nНекорректное количество отсеков!\n" +
                            "Введите значение ещё раз (0-8): ");
                    driveBays25 = scanner.nextInt();
                    scanner.nextLine();
                }

                this.driveBays25 = driveBays25;
                cycleDriveBays25 = false;

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

    public String getFrontPanel() {
        return frontPanel;
    }

    public void setFrontPanel(Scanner scanner) {
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

        // Аудио порты
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

        this.frontPanel = frontPanelBuilder.toString();
    }

    public boolean isHasTemperedGlass() {
        return hasTemperedGlass;
    }

    public void setHasTemperedGlass(Scanner scanner) {
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
                        this.hasTemperedGlass = false;
                        cycleHasTemperedGlass = false;
                        break;
                    case 1:
                        this.hasTemperedGlass = true;
                        cycleHasTemperedGlass = false;
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

    public boolean isHasFanSupport() {
        return hasFanSupport;
    }

    public void setHasFanSupport(boolean hasFanSupport) {
        this.hasFanSupport = hasFanSupport;
    }

    public boolean isHasRGB() {
        return hasRGB;
    }

    public void setHasRGB(Scanner scanner) {
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

    public boolean isHasDustFilters() {
        return hasDustFilters;
    }

    public void setHasDustFilters(Scanner scanner) {
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
                        this.hasDustFilters = false;
                        cycleHasDustFilters = false;
                        break;
                    case 1:
                        this.hasDustFilters = true;
                        cycleHasDustFilters = false;
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
        System.out.println("Тип корпуса: " + getCaseType());
        System.out.println("Поддерживаемые платы: " + getMotherboardFormFactor());
        System.out.println("Отсеки 3.5 : " + getDriveBays35());
        System.out.println("Отсеки 2.5 : " + getDriveBays25());
        System.out.println("Разъёмы передней панели: " + getFrontPanel());
        System.out.println("Боковое стекло: " + (isHasTemperedGlass() ? "Закаленное стекло" : "Металл"));
        System.out.println("Поддержка вентиляторов: " + (isHasFanSupport()? "Да" : "Нет"));
        System.out.println("RGB подсветка: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Пылевые фильтры: " + (isHasDustFilters() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
