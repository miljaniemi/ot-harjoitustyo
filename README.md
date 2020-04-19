# Ohjelmistotekniikka, harjoitustyö #
<h2> Opintokalenteri


## Dokumentaatio 

[Ajankäyttö](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/TyöAikakirjanpito.md)

[Määrittelydokumentti](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Vaativuusmaarittely.md)

[Arkkitehtuuri](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Arkkitehtuuri.md)

## Projekti

[Koko projekti](https://github.com/miljaniemi/ot-harjoitustyo/tree/master/StudyingCalendar)

## Komentorivitoiminnot
  
**Testaus**

Testit saa komentorivillä

> mvn test

Testikattavuusraportin saa komentorivillä

> mvn jacoco:report

**Checkstyle**

Checkstyle tiedostoon checkstyle.xml määrittelemät tarkistukset komentorivillä

> mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset löytyvät checkstyle.html:stä, joka löytyy reitillä *target/site/checkstyle.html*
