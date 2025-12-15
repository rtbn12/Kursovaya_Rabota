public class Keyboard extends Peripheral{


    private String keyboardType;        // Тип (механическая, мембранная, гибридная)
    private int countKey;               // Количество клавиш
    private String switchType;          // Тип переключателей (для механических)
    private String layout;              // Раскладка (RU, EN, EU)
    private boolean hasNumpad;          // Наличие цифрового блока



    public Keyboard(String id, String brand, String model,
                    String keyboardType, int countKey,
                    String switchType, String layout, boolean hasNumpad,
                    String connectionType, double cableLength,
                    boolean isWireless, boolean hasRGB, String color,
                    String countryProduction, int productionDate,
                    int price,  String description,
                    int warrantyMoths) {


        super(id, brand, model, connectionType, cableLength, isWireless,
                hasRGB, color, countryProduction, productionDate, price,
                "Клавиатура", description, warrantyMoths);

        this.keyboardType = keyboardType;
        this.countKey = countKey;
        this.switchType = switchType;
        this.layout = layout;
        this.hasNumpad = hasNumpad;

    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public int getCountKey() {
        return countKey;
    }

    public void setCountKey(int countKey) {
        this.countKey = countKey;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public boolean isHasNumpad() {
        return hasNumpad;
    }

    public void setHasNumpad(boolean hasNumpad) {
        this.hasNumpad = hasNumpad;
    }

    @Override
    public void getFullInfoForClient() {

        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Цена: " + getPrice());
        System.out.println("Тип клавиатуры : " + getKeyboardType());
        System.out.println("Количество клавиш: " + getCountKey());
        System.out.println("Тип переключателей: " + getSwitchType());
        System.out.println("Раскладка: " + getLayout());
        System.out.println("Наличие цифрового блока: " + (isHasNumpad() ? "Да" : "Нет"));
        System.out.println("Цвет устройства: " + getColor());
        System.out.println("Доступные типы подключения: " + getConnectionType());
        System.out.println("Длина кабеля: " + getCableLength() + " м");
        System.out.println("Беспроводное устройство: " + (isWireless() ? "Да" : "Нет"));
        System.out.println("Наличие RGB подсветки: " + (isHasRGB() ? "Да" : "Нет"));
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating());
        System.out.println("Описание: " + getDescription());

    }
}
