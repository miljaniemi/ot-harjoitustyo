# Testausdokumentti

Testejä on suoritettu yksikkö- ja integraatiotestauksen lisäksi myös manuaalisesti järjestelmätasolla. 

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikan eli pakkauksen [studyingcalendar.domain](https://github.com/miljaniemi/ot-harjoitustyo/tree/master/StudyingCalendar/src/main/java/studyingcalendar/domain) automatisoitutestaus on suoritettu lähinnä assertEquals-metodin avulla. Testaus on luokille [Course](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/StudyingCalendar/src/main/java/studyingcalendar/domain/Course.java) ja [Calendar](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/StudyingCalendar/src/main/java/studyingcalendar/domain/Calendar.java). Pysyväistallennus tapahtuu [tekstikäyttöliittymässä](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/StudyingCalendar/src/main/java/studyingcalendar/ui/TextInterface.java), joten testausta varten ei tarvinnut tehdä [dao-luokkien](https://github.com/miljaniemi/ot-harjoitustyo/tree/master/StudyingCalendar/src/main/java/studyingcalendar/dao) feikkiversioita.

### Pysyväistallennus

Pysyväistallennuksen testausta varten luotiin tilapäiset tekstitiedostot hyödyntäen JUnitin TemporaryFoldeja käyttäen.

### Testauskattavuus

Käyttöliittymäkerrosta ja main-luokkaa lukuunottamatta testauksen rivikattavuus on 92% ja haaraumakattavuus 100%

![testikattavuus](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./Screenshot%20at%202020-05-08%2017-02-45.png?raw=true)

Testaamatta jäivät molempien dao luokkien virheen kaappaukset, sekä luokassa FilePasswordDao metodin getPassword(), kohta jossa palautetaan null.

## Järjestelmätestaus

Tämä testaus on suoritettu manuaalisesti

### Asennus ja konfigurointi

Sovellus ladattu, haettu ja asennettu [käyttöohjeen](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Kayttoohje.md) mukaan. Testaus on tehty macOS Catalina käyttöjärjestelmällä, sekä etätyöpöydän Linux-ympäristössä. Mukana on myös tiedosto *config.properties*, jonka tärkeydestä toimivuuden kannalta on mainittu käyttöohjeen lisäksi myös jar-tiedoston lataamisen yhteydessä. 

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/Vaativuusmaarittely.md) ja käyttöohjeen toiminallisuudet testattu. Myös mahdollisimman väärällä syötteellä, testatakseen sen toimintaa virheelliseen syötteeseen.

### Sovellukseen jääneet laatuongelmat

Periodin nimi on haastavasti havaittavissa sen kursseihin verrattuna. Se ei myöskään ilmoita, jos kurssin poisto ei onnistunut. Samoin kurssin lisäyksen onnistumisesta ei ilmoiteta. Checkstyle antaa kaksi virhettä, kahdesta liian pitkästä metodista. Ne ovat pitkiä virheellisen syötteen ilmoittamisen vuoksi, joten nämä virheet voi katsoa läpi sormien.
