import java.util.Scanner;

public class GPU extends ComputerComponent{

    private int vramSize;           // Объем видеопамяти (ГБ)
    private String memoryType;      // Тип памяти (GDDR6, GDDR6X)
    private int cudaCores;          // Количество CUDA ядер
    private double baseFrequency;   // Базовая частота (МГц)
    private double boostFrequency;  // Турбо частота (МГц)
    private int memoryBusWidth;     // Ширина шины памяти (бит)
    private String coolingType;     // Тип охлаждения
    private int powerConnectors;    // Количество разъемов питания
    private String typePCIe;         // тип PCIe
    private String videoOutput;     // типы видеовыходов


    public GPU(String id, String category, Scanner scanner) {
        super(id, category, scanner);
        setVramSize(scanner);
        setMemoryType(scanner);
        setCudaCores(scanner);
        setBaseFrequency(scanner);
        setBoostFrequency(scanner);
        setMemoryBusWidth(scanner);
        setCoolingType(scanner);
        setPowerConnectors(scanner);
        setTypePCIe(scanner);
        setVideoOutput(scanner);
    }

    public int getVramSize() {
        return vramSize;
    }

    public void setVramSize(Scanner scanner) {
        boolean cycleVramSize = true;
        while (cycleVramSize) {
            System.out.print("\nВведите объем видеопамяти в ГБ (1-64): ");

            try {
                int vramSize = scanner.nextInt();
                scanner.nextLine();
                while (vramSize < 1 || vramSize > 64) {
                    System.out.print("\nНекорректный объем видеопамяти!\n" +
                            "Введите значение ещё раз (1-64 ГБ): ");
                    vramSize = scanner.nextInt();
                    scanner.nextLine();
                }
                this.vramSize = vramSize;
                cycleVramSize = false;
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
        System.out.print("\nВведите тип памяти (GDDR5, GDDR6, GDDR6X, GDDR7): ");
        this.memoryType = scanner.nextLine();
    }

    public int getCudaCores() {
        return cudaCores;
    }

    public void setCudaCores(Scanner scanner) {
        boolean cycleCudaCores = true;
        while (cycleCudaCores) {
            System.out.print("\nВведите количество CUDA ядер (256-30000): ");

            try {
                int cudaCores = scanner.nextInt();
                scanner.nextLine();
                while (cudaCores < 256 || cudaCores > 30000) {
                    System.out.print("\nНекорректное количество CUDA ядер!\n" +
                            "Введите значение ещё раз (256-18432): ");
                    cudaCores = scanner.nextInt();
                    scanner.nextLine();
                }
                this.cudaCores = cudaCores;
                cycleCudaCores = false;
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
        boolean cycleBaseFrequency = true;
        while (cycleBaseFrequency) {
            System.out.print("\nВведите базовую частоту в МГц (800-2500): ");

            try {
                double baseFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (baseFrequency < 800 || baseFrequency > 2500) {
                    System.out.print("\nНекорректная базовая частота!\n" +
                            "Введите значение ещё раз (800-2500 МГц): ");
                    baseFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                this.baseFrequency = baseFrequency;
                cycleBaseFrequency = false;
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

    public double getBoostFrequency() {
        return boostFrequency;
    }

    public void setBoostFrequency(Scanner scanner) {
        boolean cycleBoostFrequency = true;
        while (cycleBoostFrequency) {
            System.out.print("\nВведите турбо частоту в МГц (" + this.baseFrequency + "-3000): ");

            try {
                double boostFrequency = scanner.nextDouble();
                scanner.nextLine();
                while (boostFrequency < this.baseFrequency || boostFrequency > 3000) {
                    System.out.print("\nНекорректная турбо частота!\n" +
                            "Введите значение ещё раз (" + this.baseFrequency + "-3000 МГц): ");
                    boostFrequency = scanner.nextDouble();
                    scanner.nextLine();
                }
                this.boostFrequency = boostFrequency;
                cycleBoostFrequency = false;
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

    public int getMemoryBusWidth() {
        return memoryBusWidth;
    }

    public void setMemoryBusWidth(Scanner scanner) {
        boolean cycleMemoryBusWidth = true;
        while (cycleMemoryBusWidth) {
            System.out.print("\nВведите ширину шины памяти в битах (64, 128, 192, 256, 384, 512, 1024): ");

            try {
                int memoryBusWidth = scanner.nextInt();
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

                this.memoryBusWidth = memoryBusWidth;
                cycleMemoryBusWidth = false;

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

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(Scanner scanner) {
        System.out.print("\nВведите тип охлаждения (воздушное, жидкостное, гибридное): ");
        this.coolingType = scanner.nextLine();
    }

    public int getPowerConnectors() {
        return powerConnectors;
    }

    public void setPowerConnectors(Scanner scanner) {
        boolean cyclePowerConnectors = true;
        while (cyclePowerConnectors) {
            System.out.print("\nВведите количество 8-пиновых разъемов питания (0-3): ");

            try {
                int powerConnectors = scanner.nextInt();
                scanner.nextLine();
                while (powerConnectors < 0 || powerConnectors > 3) {
                    System.out.print("\nНекорректное количество разъемов питания!\n" +
                            "Введите значение ещё раз (0-3): ");
                    powerConnectors = scanner.nextInt();
                    scanner.nextLine();
                }
                this.powerConnectors = powerConnectors;
                cyclePowerConnectors = false;
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

    public String getTypePCIe() {
        return typePCIe;
    }

    public void setTypePCIe(Scanner scanner) {
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
                        this.typePCIe = "PCIe 3.0";
                        cycleTypePCIe = false;
                        break;
                    case 2:
                        this.typePCIe = "PCIe 4.0";
                        cycleTypePCIe = false;
                        break;
                    case 3:
                        this.typePCIe = "PCIe 5.0";
                        cycleTypePCIe = false;
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

    public String getVideoOutput() {
        return videoOutput;
    }

    public void setVideoOutput(Scanner scanner) {
        int hdmiPorts = 0;
        int displayPorts = 0;
        int vgaPorts = 0;
        int dviDPorts = 0;
        int dviIPorts = 0;

        // HDMI порты
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

        // DisplayPort порты
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

        // VGA порты
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

        // DVI-D порты
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

        // DVI-I порты
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

        this.videoOutput = String.format("HDMI: %d, DisplayPort: %d, VGA: %d, DVI-D: %d, DVI-I: %d",
                hdmiPorts, displayPorts, vgaPorts, dviDPorts, dviIPorts);
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Интерфейсы подключения задней панели: " + getInterfaceType());
        System.out.println("Объем видеопамяти: " + getVramSize() + " ГБ " + getMemoryType());
        System.out.println("Количество вычислительных ядер: " + getCudaCores());
        System.out.println("Базовая частота: " + getBaseFrequency() + " МГц");
        System.out.println("Турбо частота: " + getBoostFrequency() + " МГц");
        System.out.println("Ширина шины памяти: " + getMemoryBusWidth() + " бит");
        System.out.println("Тип охлаждения: " + getCoolingType());
        System.out.println("Разъемы питания: " + getPowerConnectors() + "x 8-pin");
        System.out.println("Поддерживаемые видеовыходы: " + getVideoOutput());
        System.out.println("Версия PCIe: " + getTypePCIe());
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
