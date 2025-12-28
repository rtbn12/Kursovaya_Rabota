import java.util.Scanner;

public class ComputerComponent extends Product{

    private String interfaceType;
    private int powerConsumption;
    private double voltage;


    public ComputerComponent(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setInterfaceType(scanner, category);
        setPowerConsumption(scanner);
        setVoltage(scanner);
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getVoltage() {
        return voltage;
    }




    public void setInterfaceType(Scanner scanner, String category) {
        this.setCategory(category);

        if(category.equals("Видеокарта")) {
            this.interfaceType = "PCIe";
        } else if (category.equals("Кулер")) {
            this.interfaceType = "Нет";
        } else if (category.equals("Корпус")) {
            this.interfaceType = "Нет";
        } else if (category.equals("Блок питания")) {
            this.interfaceType = "Нет";
        } else if (category.equals("Центральный процессор")) {

            boolean cycle = true;
            while (cycle) {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения процессора:\n" +
                        "1-PGA\n" +
                        "2-LGA\n" +
                        "3-BGA\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            this.interfaceType = "PGA";
                            cycle = false;
                            break;
                        case 2:
                            this.interfaceType = "LGA";
                            cycle = false;
                            break;
                        case 3:
                            this.interfaceType = "BGA";
                            cycle = false;
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

        } else if (category.equals("Оперативная память")) {
            boolean cycle = true;
            while (cycle) {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения ОЗУ:\n" +
                        "1-DIMM\n" +
                        "2-SO-DIMM\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            this.interfaceType = "DIMM";
                            cycle = false;
                            break;
                        case 2:
                            this.interfaceType = "SO-DIMM";
                            cycle = false;
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

        } else if (category.equals("Постоянное запоминающее устройство")) {
            boolean cycle = true;
            while (cycle) {
                System.out.print("\nВыберите один из доступных вариантов интерфейса подключения Постоянного запоминающего устройства:\n" +
                        "1-SATA III\n" +
                        "2-M.2\n" +
                        "Ваш выбор:");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            this.interfaceType = "SATA III";
                            cycle = false;
                            break;
                        case 2:
                            this.interfaceType = "M.2";
                            cycle = false;
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

        } else {
            // Для материнской платы
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

            boolean cycleAudioPorts = true;
            while (cycleAudioPorts) {
                System.out.print("\nВведите количество аналоговых аудиовыходов (2-8): ");

                try {
                    audioPorts = scanner.nextInt();
                    scanner.nextLine();
                    while (audioPorts < 2 || audioPorts > 8) {
                        System.out.print("\nНекорректное количество аудио портов!\n" +
                                "Введите значение ещё раз (2-8): ");
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

            this.interfaceType = String.format("USB: %d, Аудио: %d, DisplayPort: %d, HDMI: %d, RJ45: %d",
                    usbPorts, audioPorts, displayPorts, hdmiPorts, rj45Ports);
        }
    }

    public void setPowerConsumption(Scanner scanner) {
        int powerConsumption = 0;
        boolean cyclePower = true;
        while (cyclePower) {
            System.out.print("\nВведите потребляемую мощность устройства: ");

            try {
                powerConsumption = scanner.nextInt();
                scanner.nextLine();
                while (powerConsumption < 0 || powerConsumption > 20000) {
                    System.out.print("\nНекорректное значение потребляемой мощности!\n" +
                            "Введите значение ещё раз: ");
                    powerConsumption = scanner.nextInt();
                    scanner.nextLine();
                }
                this.powerConsumption = powerConsumption;
                cyclePower = false;

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

    public void setVoltage(Scanner scanner) {
        double voltage = 0;
        boolean cycleVoltage = true;
        while (cycleVoltage) {
            System.out.print("\nВведите рабочее напряжение устройства: ");

            try {
                voltage = scanner.nextDouble();
                scanner.nextLine();
                while (voltage < 0 || voltage > 50) {
                    System.out.print("\nНекорректное значение рабочего напряжения!\n" +
                            "Введите значение ещё раз: ");
                    voltage = scanner.nextDouble();
                    scanner.nextLine();
                }
                this.voltage = voltage;
                cycleVoltage = false;

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







}
