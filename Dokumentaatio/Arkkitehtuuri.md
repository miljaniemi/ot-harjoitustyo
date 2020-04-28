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
![Sekvenssikaavio](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./nytoleoikein.png?raw=true)


## Sekvenssikaaviot

Kun on tekstikäyttöliittymässä valittu, että käytetään ylläpitäjän oikeuksia ja ohjeet on kerrottu. Kirjoitetaan komennoksi yksi ja lisätään kurssi

![kurssin lisäys](https://github.com/miljaniemi/ot-harjoitustyo/blob/master/Dokumentaatio/kuvat./sekvenssikaavio1.png?raw=true)

User eli ohjelman käyttäjä antaa komennon joka kutsuu tekstikäyttöliittymän metodia addcourse(). Tässä komennossa tekstikäyttöjärjestelmä kutsuu Calendar luokan metodia addCourse parametrinaan uusi kurssi, jonka arvot käyttäjä on antanut. Calendar luokan metodissa kutsutaan uuden kurssin getteriä periodin saamiseksi. Tämä palauttaa arvon 4. Tämän jälkeen kun tiedetään kurssin periodi, se lisätään oikeaan listaan. Tekstikäyttöliittymä kutsuu myös pysyväistallennuksesta huolehtivaa FileCourseDao-luokkaa ja sen metodia create heti Calendar luokan kutsun jälkeen. Dao-luokassa se kutsuu sisällään vielä save metodia, joka tallentaa uuden kurssin tiedostoon talteen muodossa *kurssinnimi;periodi;opintopisteet;käyty\n"* ja tässä \n siis tarkoittaa rivin vaihtoa. Kyseisen esimerkin tapauksessa kurssi tallennettaisiin muodossa *Ohjelmistotekniikka;4;5;false\n*
