# PaymentTracker

- MainClass = cz.greyson.PaymentTrackerApplication.java

# Application casti / komponenty:
1) PaymentTrackerApplication.java
    - obsahuje vnitrni pamet aplikace = HaspMap<String, BigDecimal>
    - pokousi se parsovat vstupni soubor => pomoci InputArgumentProcessor.java
    - startuje 2 samostatna vlakna (InputConsoleThread.java a PrinterThread.java)

2) InputConsoleThread.java 
    - jedna se o konzolovou ctecku, ktere ridi zpracovani vstupu z klavesnice
    - k tomu postupne vyuziva InputLineParser.java a LineValidatorImpl.java a InputDataProcessor.java
    
3) PrinterThread.java
    - tiskove vlakno, ktere pouze jedenkrat za urceny cas vytiskne do konzole obsah interni pameti  

4) InputLineParser.java
    - parsuje vstupni hodnoty "USD 1234" na dvoji klic a hodnota

5) LineValidator.java
    - provadi jednoduche validace na delku a datovy typ
    
6) InputDataProcessor.java
    - slouzi ke zpracovani vstupnich dat a jejich ulozeni do interni pameti (provadi kalkulace, scitani atd.)
   

# Externi knihovny (a maven dependencies):
- Guava
- Log4j

# Jak spustit aplikaci:
1) Checkout z gitHub => https://github.com/zdenek-vacek-greyson/PaymentTracker.git
2a) Import maven projektu do IDE a spustit pres MainClass
2b) Spustit "mvn package" nad pom.xml
3b) Spustit "java -jar target/PaymentTracker-1.0-SNAPSHOT-jar-with-dependencies.jar"
anebo "java -jar target/PaymentTracker-1.0-SNAPSHOT-jar-with-dependencies.jar ../input_file.txt" s odkazem na ukazkovy
vstupni soubor

# Jak ukoncit aplikaci:
    - napsani prikazu "exit" anebo "quit" do vstupni konzele