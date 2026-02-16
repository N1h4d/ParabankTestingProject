ParabankTestingProject
Bu repository hazırladığım Cucumber test layihəsini ehtiva edir. Layihə ParaBank veb tətbiqinin funksional testlərini avtomatlaşdırmaq məqsədi daşıyır.

Repository-də source kodlar (src/test/java), feature faylları (src/test/resources) və digər test resursları mövcuddur.

Başlanğıc Addımları
Repository-ni IntelliJ IDEA üzərindən klonlayın:

1.  IntelliJ IDEA-nı açın

2.  New Project → From Version Control seçin

3.  Repository URL-ni daxil edin:
https://github.com/N1h4d/ParabankTestingProject
4. Clone düyməsini basın

Lazım Olan Kitabxanalar
Aşağıdakı dependency-lər pom.xml faylında yer alır. Maven → Reload Project etmək kifayətdir:
- Cucumber JVM
- Selenium Java
- TestNG
- WebDriverManager
- Log4j
- Extent Reports

Layihə Strukturu
ParabankTestingProject/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── pages/           # Page Object Model sinifləri
│   │   │   ├── stepDefinitions/ # Cucumber step definitions
│   │   │   ├── runners/         # Test runner sinifləri
│   │   │   └── utilities/       # Köməkçi siniflər (Driver, ConfigReader)
│   │   └── resources/
│   │       └── features/        # Cucumber feature faylları
├── test-output/                  # Test hesabatları
├── logs/                         # Log faylları
├── configuration.properties      # Konfiqurasiya faylı
└── pom.xml                       # Maven konfiqurasiyası

Testləri İcra Etmək
IntelliJ IDEA üzərindən:
src/test/java/runners paketindəki runner siniflərini sağ klikləyib Run edin

Test Hesabatları
Test icrasından sonra hesabatları aşağıdakı yollarda tapa bilərsiniz:
- Cucumber Report: target/cucumber-reports/index.html
- Extent Report: test-output/ExtentReport.html

Konfiqurasiya
configuration.properties faylında aşağıdakı parametrləri dəyişə bilərsiniz:

properties
browser=chrome
url=https://parabank.parasoft.com/parabank/index.htm
timeout=10
Yenilikləri Almaq
Yeni dərslər və ya dəyişikliklər əlavə edildikdə:

IntelliJ IDEA üzərindən: Git → Pull
Terminal vasitəsilə:
git pull
