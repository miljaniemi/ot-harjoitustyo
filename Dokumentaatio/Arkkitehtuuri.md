# Arkkitehtuuri kuvaus #

## Rakenne

![pakkaukset](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./pakkauksetvain.png?raw=true)

Pakkauksessa *studyingcalendar.ui* on tekstikäyttöliittymä, *studyingcalendar.domain* luokat Course ja Calendar, joissa Coursessa on nimensä mukaisesti kurssit. Calendar on enemmän näkymä oppilaalle hänen kursseistaan. Eli toisinsanoen pakkaus pitää huolta sovelluslogiikasta. Pakkaus *studyingcalendar.dao* sisältää nimensä mukaisesti tietojen pysyväistallennuskoodin.

## Sovelluslogiikka

Sovelluslogiikka sisältää kaksi luokkaa **Calendar** ja **Course**. Course luoka on itse kursseja varten. Se sisältää lähinnä getterit ja tarvittavat setterit. Luokka Calendar taas hoitaa nimensä mukaisesti kalenterin ylläpidon. Siellä on jokaiselle periodille oma listansa parametreinään Course. Käyttöliittymä lähinnä käyttää hyväkseen Calendar luokkaa, joka taas Coursea. Calendar luokassa toimivat mm. metodit 

- addCourse(Course course)
- deleteCourse(Course course)
- showPeriod(int period)
- showAutumn()
- showSpring()
- showAll()

Joita kutsutaan tekstikäyttöliittymässä.

Alla vielä suhteet luokka-/pakkauskaaviona
![Sekvenssikaavio](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./uusiPakkausKaavio.png?raw=true)


## Sekvenssikaaviot

Alla esitetty kolme tärkeintä tapahtumaa sekvenssikaavioina. Tärkeitä on toki myös oppilaan metodit, mutta niiden sekvenssikaavioit olisivat todella lyhyitä, joten niitä ei ole esitetty.

**Sisäänkirjautuminen ylläpitäjäksi ensimmäistä kertaa**

Kun on käyttöliittymässä valittu, että käytetään ylläpidon oikeuksia, kutsutaan metodia, joka tarkistaa onko määritelty salasanaa vai ei.

![Salasanan luonti](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./UusiSalasana.png?raw=true)

Metodi kutsuu FilePasswordDao-luokkaa, jossa on tallennettuna salasana, jos se on olemassa. Tässä tapauksessa se palauttaa arvon null. Nyt kutsutaan metodia createNewPassword, joka pyytää käyttäjää syöttämään salasanan, jolla tulevaisuudessa kirjaudutaan sisään. Käyttäjä antaa syötteeksi salasanalle "password". Tämän jälkeen käyttöliittymä kutsuu jälleen FilePasswordDao-luokkaa ja sen metodia save(), jonka parametrina on "password", eli String muotoinen salasana. Tämän jälkeen käyttöliittymä kutsuu vielä metodia youreHost() ja avautuu ylläpitäjän näkymä.


**Uuden kurssin luonti**

Nyt on päästy ylläpitäjän oikeuksiin ja voi alkaa lisäämään kurssia. Tätä metodia kutsutaan komennolla 1.

![kurssin lisäys](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./UudenKurssinLuonti.png?raw=true)

User eli ohjelman käyttäjä antaa komennon joka kutsuu tekstikäyttöliittymän metodia addcourse(). Tässä komennossa tekstikäyttöjärjestelmä kutsuu Calendar luokan metodia addCourse parametrinaan uusi kurssi, jonka arvot käyttäjä on antanut. Calendar luokan metodissa kutsutaan uuden kurssin getteriä periodin saamiseksi. Tämä palauttaa arvon 4. Tämän jälkeen kun tiedetään kurssin periodi, se lisätään oikeaan listaan. Tekstikäyttöliittymä kutsuu myös pysyväistallennuksesta huolehtivaa FileCourseDao-luokkaa ja sen metodia create heti Calendar luokan kutsun jälkeen. Dao-luokassa se kutsuu sisällään vielä save metodia, joka tallentaa uuden kurssin tiedostoon talteen muodossa *kurssinnimi;periodi;opintopisteet\n"* ja tässä \n siis tarkoittaa rivin vaihtoa. Kyseisen esimerkin tapauksessa kurssi tallennettaisiin muodossa *Ohjelmistotekniikka;4;5\n*

**Kurssin poistaminen**

Ylläpitäjän tilassa käyttäjä kutsuu kurssin poistamismetodia

![kurssin poisto](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./KurssinPoisto.png?raw=true)

Tekstikäyttöliittymä kutsuu Calendar luokan getList()-metodia, joka palauttaa ArrayListin, jossa on olioina Course-luokan kursseja. Kutsutaan vielä tiettyä periodia 4. Tämän jälkeen käydään listaa läpi ja kusutaan kurssille nimeltä *Ohjelmistotekniikka* tunnuksella *ohte* metodeja getName() seka getPeriod, jotka luokka palauttaa. Näillä arvoilla on löydetty kurssi joka halutaan poistaa. Nyt Calendar luokan metodi poistaa kurssin tiedoistaan (ensin kysyän jälleen metodilla getPeriod() oikean periodin). Myös dao-luokka FileCourseDao poistaa luokan. Tämä poistaa sen myös tiedostosta, joten kun kutsutaan metodia save(), katoaa kurssi pysyväistallennuksestakin.

