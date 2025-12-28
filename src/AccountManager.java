import java.util.Map;
import java.util.Scanner;

public class AccountManager {

     private static final String sellerKey = "BSU";



    public static Client authorizationClient(){
        Scanner scanner = new Scanner(System.in);
        Map<String,Client> clients = FileManager.loadClient();
        System.out.print("С возвращением, дорогой покупатель!\n" +
                "Сейчас вам предстоит ввести ваши ранее придуманные логин и пароль!\n" +
                "Введите ваш логин:");
        String login = scanner.nextLine();
        while (!clients.containsKey(login))
        {
            System.out.print("\nПокупатель с таким логином пока не зарегистрирован!\n" +
                    "Пожалуйста, введите корректный логин:");
            login = scanner.nextLine();
        }

        Client client = clients.get(login);

        System.out.print("\nВведите ваш пароль:");
        String password = scanner.nextLine();

        while (!password.equals(client.getPassword()))
        {
            System.out.print("\nВы ввели неверный пароль!\n" +
                    "Пожалуйста, попробуйте ввести его ещё раз:");
            password = scanner.nextLine();
        }

        System.out.println("\n Поздравляю с успешной авторизацией!" +
                "\n Доброго времени суток, " + client.getName() + "!");
        return client;
    }




    public static void registrationClient() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Client> clients = FileManager.loadClient();
        Map<String, ShoppingList> shoppingLists = FileManager.loadShoppingLists();

        System.out.print("Приветствую Вас, новый пользователь!\n" +
                "Для успешного прохождения процесса регистрации вам предстоит ввести своё НАСТОЯЩЕЕ имя,\n" +
                "а также, придумать логин и пароль!\n" +
                "Значение пароля при первичном и вторичном вводе должны быть идентичны!\n" +
                "Введите ваше ИМЯ:");
        String name = scanner.nextLine();

        System.out.print("\nПридумайте и введите ваш ЛОГИН:");
        String login = scanner.nextLine();

        while (clients.containsKey(login))
        {
            System.out.print("\nТакой логин уже занят!\n" +
                    "Пожалуйста, придумайте и введите другой:");
            login = scanner.nextLine();
        }

        System.out.println("\nПридумайте и введите ваш ПАРОЛЬ:");
        String password = scanner.nextLine();

        String password2;
        do {
            System.out.println("\nВведите пароль ещё раз:");
            password2 = scanner.nextLine();

            if(!password2.equals(password))
            {
                System.out.print("\nВторичный пароль не соответствует первичному!\n" +
                        "Попробуйте снова!:");
            }
        } while (!password2.equals(password));

        System.out.print("\nПароли совпали!\n" +
                "Регистрация прошла успешно!\n" +
                "Спасибо за регистрацию!");

        clients.put(login,new Client(name,password,login,1));
        shoppingLists.put(login,new ShoppingList());

        FileManager.saveClient(clients);
        FileManager.saveShoppingLists(shoppingLists);


    }




    public static Seller authorizationSeller(){
        Scanner scanner = new Scanner(System.in);
        Map<String,Seller> sellers = FileManager.loadSeller();

        System.out.print("\nПриветствую и желаю хорошего рабочего дня, дорогой Сотрудник!\n" +
                "Сейчас вам предстоит ввести ваши ранее придуманные логин и пароль!\n" +
                "Введите ваш логин:");
        String login = scanner.nextLine();

        while (!sellers.containsKey(login))
        {
            System.out.print("\nСотрудник с таким логином пока не зарегистрирован!\n" +
                    "Попробуйте ввести ваш логин снова!:");
            login = scanner.nextLine();
        }

        Seller seller = sellers.get(login);

        System.out.print("\nВведите ваш пароль:");
        String password = scanner.nextLine();
        while (!password.equals(seller.getPassword()))
        {
            System.out.print("\nВы ввели неверный пароль!\n" +
                    "Попробуйте снова!:");
            password = scanner.nextLine();
        }

        System.out.print("\nАвторизация прошла успешно!\n" +
                "Ещё раз желаю вам, " + seller.getName() + ", хорошего рабочего дня!\n" +
                "Ваш '" + ComputerShop.getName() + "' !");

        return seller;

    }



    public static void registrationSeller(){
        Scanner scanner = new Scanner(System.in);
        Map<String, Seller> sellers = FileManager.loadSeller();

        System.out.print("\nПриветствуем вас в компании '" + ComputerShop.getName() + "' !\n" +
                "Мы ценим каждого сотрудника и очень рады от того, что вы решили присоединиться к нашей дружной семье!\n" +
                "Сейчас вам предстоит Ввести ваше НАСТОЯЩЕЕ имя, а также придумать и ввести логин и пароль, \n" +
                "а также специальное кодовое слово (вам его сообщил действующий сотрудник)!\n" +
                "Для успешного прохождения регистрации значение пароля при первичном и вторичном вводе должны быть идентичны!\n" +
                "Введите ваше ИМЯ:");
        String name = scanner.nextLine();

        System.out.print("\nПридумайте и введите ваш ЛОГИН:");
        String login = scanner.nextLine();
        while (sellers.containsKey(login))
        {
            System.out.print("\nТакой логин уже занят!\n" +
                    "Пожалуйста, придумайте и введите другой:");
            login = scanner.nextLine();
        }

        System.out.print("\nПридумайте и введите ваш ПАРОЛЬ:");
        String password = scanner.nextLine();

        System.out.print("\nВведите пароль ещё раз:");
        String password2 = scanner.nextLine();

        while(!password2.equals(password))
        {
            System.out.print("\nПервичный пароль не соответствует вторичному!\n" +
                    "Попробуйте снова:");
            password2 = scanner.nextLine();
        }

        System.out.print("\nПароли совпали!");

        System.out.print("\nВведите кодовое слово:");
        String sellerKey0 = scanner.nextLine();
        while (!sellerKey0.equals(sellerKey))
        {
            System.out.print("\nВы ввели неверное кодовое слово!\n" +
                    "Попробуйте ещё раз!:");
            sellerKey0 = scanner.nextLine();
        }

        System.out.print("\nРегистрация прошла успешно!\n" +
                "Спасибо за то, что выбрали работать в нашей компании!");

        sellers.put(login, new Seller(name,password,login,0, sellerKey0));
        FileManager.saveSeller(sellers);


    }



}


