# Ohjelmistotekniikka, harjoitustyö #
## Opintokalenteri

Opintokalenteri on ohjelma, joka on suunniteltu lähinnä omaan käyttöön. Siellä voi olla joko oppilaana tai ylläpitäjänä. Oppilaana voit nähdä käytävät kurssit ja milloin ne voi käydä. Periodi näkymiä voi nähdä joko periodi , lukukausi tai koko vuosi kerrallaan. Ylläpitäjä voi lisätä ja poistaa kursseja.

## Dokumentaatio 

[Ajankäyttö](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/TyöAikakirjanpito.md)

[Määrittelydokumentti](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Vaativuusmaarittely.md)

[Arkkitehtuuri](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Arkkitehtuuri.md)

[Käyttöohje](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Kayttoohje.md)

## Releaset

[Viikko 5](https://github.com/miljaniemi/ot-harjoitustyo/releases/tag/viikko5)
[Viikko 6](https://github.com/miljaniemi/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot
  
### Testaus

Testit saa komentorivillä

> mvn test

Testikattavuusraportin saa komentorivillä

> mvn jacoco:report

### Checkstyle

Checkstyle tiedostoon checkstyle.xml määrittelemät tarkistukset komentorivillä

> mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset löytyvät checkstyle.html:stä, joka löytyy reitillä *StudyingCalendar/target/site/checkstyle.html*

### JavaDoc

JavaDocin saa komentorivillä

>  mvn javadoc:javadoc

**HUOM** jos koodi mvn javadoc:javadoc ei toimi, kokeile komentoriviä *JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/ mvn clean javadoc:javadoc*. Edellä oleva komentorivi saatu Telegramista. Löytyy reitillä *StudyingCalendar/target/site/apidocs/allclasses.html* jonka saa auki kansiossa apidocs komentorivillä

> browse allclasses.html

### Jar-generointi ja avaus

Jar tiedoston voi luoda komentorivillä

> mvn package

Se löytyy kansiosta *StudyingCalendar/target* (oikea on se jonka nimessä **ei** ole sanaa *original*). Releasessa nimi muutettu nimeksi *SClander.jar* ja tätä nimeä käytetään alla. Jos jar-tiedosto, jonka haluat avata eri nimellä, korvaa alla olevaan komentoriviin oikea nimi.

Jar-tiedoston voi avata kansiossa target jonne pääsee reitillä *StudyingCalendar/target/* komentorivillä

> java -jar SCalendar.jar

**HUOM** Huomaa, että myös target kansion sisälle tiedoston nimeltä *config.properties* jonka sisällä lukee *courseFile=courses.txt* sekä toisella rivillä *passwordFile=password.txt*. Muuten sen avaaminen ei onnistu. Huomaa myös, että tämä on eri pysyväistallennus kuin se, joka on kansion StudyingCalendar sisällä ja jota luetaan netBeansin versiossa, joten niiden pysyväistallennetut kurssit voivat vaihdella, riippuen mitä olet tallentanut mihinkin.
