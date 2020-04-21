# Ohjelmistotekniikka, harjoitustyö #
## Opintokalenteri

Opintokalenteri on ohjelma, joka on suunniteltu lähinnä omaan käyttöön. Siellä voi olla joko oppilaana tai ylläpitäjänä. Oppilaana voit nähdä käytävät kurssit ja milloin ne voi käydä. Periodi näkymiä voi nähdä joko periodi , lukukausi tai koko vuosi kerrallaan. Ylläpitäjä voi lisätä ja poistaa kursseja.

## Dokumentaatio 

[Ajankäyttö](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/TyöAikakirjanpito.md)

[Määrittelydokumentti](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Vaativuusmaarittely.md)

[Arkkitehtuuri](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Arkkitehtuuri.md)

## Releaset

[Viikko 5](https://github.com/miljaniemi/ot-harjoitustyo/releases)

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
