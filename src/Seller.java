import java.io.Serializable;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Seller extends User implements Serializable {

    private static final long serialVersionUID = 2L;
    private String sellerKey;
    private static transient Scanner  scanner2 = new Scanner(System.in);



    public Seller(String name, String password, String login, int Role, String sellerKey) {
        super(name, password, login, 0);

        this.sellerKey = sellerKey;
    }

    public  void initScanner()
    {
        if(scanner2 == null)
        {
            scanner2 = new Scanner(System.in);
        }
    }


    public void registrationProduct()
    {
        String category;
        initScanner();
        int registrationChoice;
        boolean registration = true;
        while(registration)
        {
            System.out.print("\nВыберите категорию товара, который хотите добавить:\n" +
                    "1-Центральный процессор\n" +
                    "2-Материнская плата\n" +
                    "3-Видеокарта\n" +
                    "4-Оперативная память\n" +
                    "5-Постоянное запоминающее устройство\n" +
                    "6-Блок питания\n" +
                    "7-Корпус\n" +
                    "8-Кулер\n" +
                    "9-Программное обеспечение\n" +
                    "10-Монитор\n" +
                    "11-Мышь\n" +
                    "12-Клавиатура\n" +
                    "0-Выход в меню продавца\n" +
                    "Ваш выбор:");



            try {
                registrationChoice = scanner2.nextInt();

                switch (registrationChoice)
                {
                    case 1:
                        category = "Центральный процессор";
                        ProductManager.registrationCPU(category);
                        break;
                    case 2:
                        category = "Материнская плата";
                        ProductManager.registrationMotherBoard(category);
                        break;
                    case 3:
                        category = "Видеокарта";
                        ProductManager.registrationGPU(category);
                        break;
                    case 4:
                        category = "Оперативная память";
                        ProductManager.registrationRAM(category);
                        break;
                    case 5:
                        category = "Постоянное запоминающее устройство";
                        ProductManager.registrationStorage(category);
                        break;
                    case 6:
                        category = "Блок питания";
                        ProductManager.registrationPowerSupply(category);
                        break;
                    case 7:
                        category = "Корпус";
                        ProductManager.registrationCase(category);
                        break;
                    case 8:
                        category = "Кулер";
                        ProductManager.registrationCooler(category);
                        break;
                    case 9:
                        category = "Программное обеспечение";
                        ProductManager.registrationSoftware(category);
                        break;
                    case 10:
                        category = "Монитор";
                        ProductManager.registrationMonitor(category);
                        break;
                    case 11:
                        category = "Мышь";
                        ProductManager.registrationMouse(category);
                        break;
                    case 12:
                        category = "Клавиатура";
                        ProductManager.registrationKeyBoard(category);
                        break;
                    case 0:
                        registration = false;
                        break;
                    default:
                        System.out.println("Такого варианта выбора нет!\n" +
                                "Пожалуйста, введите корректное число!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner2.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner2.nextLine();
            }

        }

    }




    }


