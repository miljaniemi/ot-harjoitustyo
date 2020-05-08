# Käyttöohje #

Lataa jar-tiedosto [SCalendar.jar](https://github.com/miljaniemi/ot-harjoitustyo/releases/tag/viikko7)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa (itse käytin *target* kansiota) olisi teidosto *config.properties* , jonne tulee kurssien pysyväistallennus. Tiedoston muoto on seuraava

> courseFile=courses.txt
> passwordFile=password.txt

## Ohjelman käynnistys

Ohjelman saa käynnistettyä komentorivillä

> java -jar SCalendar.jar

Tämä avaa tekstikäyttöliittymän

## Käyttäjän valinta

Tässä vaiheessa saa valita, haluaako käyttää sovellusta opiskelijana vai ylläpitäjänä. Ylläpitäjän näkymään tarvitsee salasanan. Ensimmäisellä kerralla pääsee määrittämään salasanana, muuten käyttöliittymä kysyy aiemmin määriteltyä salasanaa sisäänpääsyyn. Opiskelija voi katsoa kalenteristaan kursseja joko periodi-, lukukausi- tai vuosinäkymä kerrallaan. Ylläpitäjä voi joko lisätä tai poistaa kursseja.

## Uuden kurssin luonti

Ylläpitäjän näkymässä voi luoda uuden kurssin. Käyttöliittymä kyselee käyttäjältä tarvittavat tiedot kurssin luomiseen ja sen jälkeen lisää uuden kurssin kalenteriin, joka liittää sen oikeaan periodiin. Sekä lisää kurssin pysyväistallennukseen. Jos kurssi on jo olemassa, käyttöliittymä herjaa tästä. Se myös herjaa, jos annetut arvot periodille tai opintopisteille on jotain muuta kuin Integer-muodossa.

## Kurssin poistaminen

Ylläpitäjä voi myös poistaa kursseja. Tässä haasteena on muistaa täysin missä muodossa kyseisen kurssin nimi on annettu, muuten sitä ei voi poistaa. Kun tarvittavat parametrit on laitettu ja kurssi poistettu, ilmoittaa käyttöliittymä poistamisen onnistuneen. Se myös herjaa, jos annettu arvo periodille on jotain muuta kuin Integer-muodossa.

## Tietyn kurssin katsominen

Tämä on toiminnallisuus opiskelijalle. Käyttöliittymä kysyy käyttäjältä periodia, joka halutaan katsoa. Jos se ei ole Integer-muodossa, varoittaa käyttöliittymä tästä. Numeron saadessaan se näyttää kyseisen periodin, jos numero oli joko 1,2,3 tai 4. Jos ei, se herjaa tästä.

## Lukukauden tai koko vuoden katsominen

Opiskelija voi katsoa periodeja myös valitsemalla tutkintaan syys- tai kevätlukukauden tai suoraan koko lukuvuoden. 
