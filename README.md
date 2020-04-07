# Ohjelmistotekniikka, harjoitustyö 
<h2> Opintokalenteri


<h2> Dokumentaatio

[Ajankäyttö](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/laskarit/viikko2/TyöaikaKirjanpito.md)

[Määrittelydokumentti](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/laskarit/viikko2/Määrittelydokumentti.md)

<h2> Projekti

[Koko projekti](https://github.com/miljaniemi/ot-harjoitustyo/tree/master/StudyingCalendar)

<h2> Komentorivitoiminnot
  
**Testaus**

Testit saa komentorivillä

> mvn test

Testikattavuusraportin saa komentorivillä

> mvn jacoco:report

**Checkstyle**

Checkstyle tiedostoon checkstyle.xml määrittelemät tarkistukset komentorivillä

> mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset löytyvät checkstyle.html:stä, joka löytyy reitillä *target/site/checkstyle.html*
