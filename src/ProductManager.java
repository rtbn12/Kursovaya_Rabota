import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {

    public static Product registrationProduct ()
    {
       Map<String,Product> products = FileManager.loadProduct0();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите ID  продукта:");
        String id = scanner.nextLine().toUpperCase().trim();

        while(products.containsKey(id))
        {
            System.out.print("\nТакой ID уже занят!\n" +
                    "Придумай другой!:");
            id = scanner.nextLine();

        }


        System.out.print("\nВведите бренд:");
        String brand = scanner.nextLine();

        System.out.print("\nВведите модель:");
        String model = scanner.nextLine();

        System.out.print("\nВведите страну производителя:");
        String countryProduction = scanner.nextLine();

        System.out.print("\nВведите год производства:");
        int productionDate = scanner.nextInt();

        while((productionDate < 2018) || productionDate > Calendar.getInstance().get(Calendar.YEAR))
        {
            System.out.print("\nНекорректный год производства!\n" +
                    "Введите год производства ещё раз:");
            productionDate = scanner.nextInt();
        }

        System.out.print("\nВведите цену товара:");
        int price = scanner.nextInt();

        while (price <=0 || price>1000_000)
        {
            System.out.print("\nВведена недоступная цена для товара!\n" +
                    "Введите цену ещё раз:");
            price = scanner.nextInt();
        }

//        System.out.print("\nВведите количество единиц товара, поступивших на склад:");
//        int quantity = scanner.nextInt();

//        while(quantity<=0 || quantity > 15)
//        {
//            System.out.print("\nВведено недоступное количество единиц товара!\n" +
//                    "Введите количество единиц товара ещё раз:");
//            quantity = scanner.nextInt();
//        }

        boolean categoryTip = true;
        String category = "";
        while (categoryTip)
        {
            System.out.print("\nВведите категорию товара:\n" +
                    "0-продукт\n" +
                    "1-\n" +
                    "2-\n" +
                    "3-\n" +
                    "Выбор:");

            try {
                int choiceCategory = scanner.nextInt();
                scanner.nextLine();

                switch (choiceCategory)
                {
                    case 0:
                        category = "Товар";
                        categoryTip = false;
                        break;
                    case 1:
                        category = "Заглушка1";
                        categoryTip = false;
                        break;
                    case 2:
                        category = "Заглушка2";
                        categoryTip = false;
                        break;
                    case 3:
                        category = "Заглушка3";
                        categoryTip = false;
                        break;
                    default:
                        System.out.print("\nВведен некорректный вариант! " +
                                "Попробуй ещё раз!");
                }

            }catch (InputMismatchException e) {
                System.out.println("Произошла ошибка!\n" +
                        "Пожалуйста, введите корректное целочисленное значение выбранного варианта!\n" +
                        "В прошлый раз вы ввели букву вместо числа!");
                scanner.nextLine();
            }
            catch (Exception a) {
                System.out.println("Произошла неизвестная ошибка!");
                scanner.nextLine();
            }
        }

        System.out.print("\nВведите описание товара:");
        String description = scanner.nextLine();
        while (description.length()>500)
        {
            System.out.print("\nОписание товара слишком длинное!\n" +
                    "Постарайтесь вместить описание в 500 символов!\n" +
                    "Введите описание ещё раз:");
            description = scanner.nextLine();
        }

        System.out.println("\nВведите срок предоставляемой гарантии на товар в целом количестве месяцев:");
        int warrantyMoths = scanner.nextInt();
        while (warrantyMoths<=0 || warrantyMoths>120)
        {
            System.out.print("\nВы ввели некорректный срок гарантии!\n" +
                    "Введите срок гарантии в месяцах заново!:");
            warrantyMoths = scanner.nextInt();
        }

        System.out.print("\nРегистрация товара завершена успешно!");

        products.put(id,new Product(id,brand,model,countryProduction,productionDate,price,category,description,warrantyMoths));
        FileManager.saveProduct0(products);
        return  new Product(id,brand,model,countryProduction,productionDate,price,category,description,warrantyMoths);


    }
}
