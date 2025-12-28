import java.util.List;

public class Software extends Product{

    private String softwareType;      // Тип ПО (ОС, антивирус, офис, игра)
    private int licenseDuration;      // Срок лицензии (месяцев, 0 = бессрочная)
    private String supportedOS;       // Поддерживаемые ОС (Windows, macOS, Linux)
    private String systemRequirements; // Системные требования
    private boolean isDigital;        // Цифровая версия (true) или коробочная (false)
    private String languages;         // Поддерживаемые языки

    public Software(String id, String brand, String model,String softwareType,
                    int licenseDuration,String supportedOS,String systemRequirements,
                    boolean isDigital,String languages, String countryProduction,
                    int productionDate,String category, int price, String description, int warrantyMoths) {


        super(id, brand, model, countryProduction,
                productionDate, price,  category,
                description, warrantyMoths);

        this.softwareType = softwareType;
        this.licenseDuration = licenseDuration;
        this.supportedOS = supportedOS;
        this.systemRequirements = systemRequirements;
        this.isDigital = isDigital;
        this.languages = languages;


    }

    public String getSoftwareType() {
        return softwareType;
    }

    public void setSoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }

    public int getLicenseDuration() {
        return licenseDuration;
    }

    public void setLicenseDuration(int licenseDuration) {
        this.licenseDuration = licenseDuration;
    }

    public String getSupportedOS() {
        return supportedOS;
    }

    public void setSupportedOS(String supportedOS) {
        this.supportedOS = supportedOS;
    }

    public String getSystemRequirements() {
        return systemRequirements;
    }

    public void setSystemRequirements(String systemRequirements) {
        this.systemRequirements = systemRequirements;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Override
    public void getFullInfoForClient() {
        System.out.println("\nId: " + getId());
        System.out.println("Категория: " + getCategory());
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Тип программного обеспечения: " + getSoftwareType());
        System.out.println("Срок лицензирования: " + getLicenseDuration() + " месяцев");
        System.out.println("Поддерживаемые операционные системы: " + getSupportedOS());
        System.out.println("Системные требования: " + getSystemRequirements());
        System.out.println("Цифровая версия: " + (isDigital()? "Да" : "Нет"));
        System.out.println("Поддерживаемые языки: " + getLanguages());
        System.out.println("Цена: " + getPrice() + " рублей");
        System.out.println("Страна-производитель: " + getCountryProduction());
        System.out.println("Год релиза: " + getProductionDate());
        System.out.println("Гарантийный срок: " + getWarrantyMoths() + " месяцев");
        System.out.println("Рейтинг: " + getRating() + "из 5!");
        System.out.println("Количество на складе: " + getQuantityProduct() + " шт.");
        System.out.println("Описание: " + getDescription());
    }
}
