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
                        System.out.println("Заглушка 1");
                        break;
                    case 2:
                        System.out.println("Заглушка 2");
                        break;
                    case 3:
                        System.out.println("Заглушка 3");
                        break;
                    case 4:
                        System.out.println("Заглушка 4");
                        break;
                    case 5:
                        System.out.println("Заглушка 5");
                        break;
                    case 6:
                        System.out.println("Заглушка 6");
                        break;
                    case 7:
                        System.out.println("Заглушка 7");
                        break;
                    case 8:
                        System.out.println("Заглушка 8");
                        break;
                    case 9:
                        System.out.println("Заглушка 9");
                        break;
                    case 10:
                        System.out.println("Заглушка 10");
                        break;
                    case 11:
                        System.out.println("Заглушка 11");
                        break;
                    case 12:
                        System.out.println("Заглушка 12");
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


