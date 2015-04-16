# Rakenne ja O-analyysi

Algoritmi luo uusia generaatiota ja jokaisessa generaatiossa se luo 100 uutta DNA:ta, mutatoi ne, pisteyttää ne ja lopuksi kaikki DNA:t järjestetään.

Joka kerta kun DNA luodaan, se saa isältään ja äidiltään arvot. isältä arvojen hakeminen kestää O(l) aikaa, missä l on sijaintien määrä. Äidiltä arvojen hakeminen kestää O(l^2) aikaa, missä l on sijaintien määrä. Toisen asteen potenssi johtuu siitä että samalla pitää tarkistaa onko sama sijainti tullut jo isätlä. Täten crossover on aikavaatimukseltaan O(l^2)

Mutaatioiden maksimimäärä on käyttäjän asettama. Yksi mutaatio vain vaihtaa kahden sijainnin paikkaa, jolloin mutaation aikavaatimus on O(1). Näin ollen yhden DNA:n kaikkien mutaatioiden aikavaatimus on O(m), missä m on max mutaatioiden määrä.

Pisteiden laskuun tarvitaan laskea reitti, minkä DNA pitää sisällään. Reitin laskemisessa käydään jokaisen sijainnin jokainen paketti läpi. Näin ollen reitin laskemiseen menee O(p) aikaa missä p on kaikkien pakettien määrä.

Pisteisiin lasketaan myös DNA:n eroavaisuus suhteessa vanhempiinsa. Eroavaisuuden laskemisessa käydään isän, äidin ja lapsen sijainnit läpi. Eroavaisuuden laskemisessa menee siis O(l) aikaa missä l on sijaintien määrä. Vakiokerroin on 3. 

Reitin ja eroavaisuuden yhdistävä pisteidenlasku algoritmi tekee vain normaaleja laskutoimituksia vakioajassa. Täten koko pisteiden laskuun menee  O(p+l).

DNA:n pisteitä käytetään järjestämisessä. Järjestämiseen käytetään merge sorttia, jonka aikavaativuus on O(nlog(n)). DNA:n pisteet laitetaan muistiin enismmäisen laskemisen jälkeen. Tällöin järjestämiseen menee O(p*d + dlog(d)) missä d on generaation DNA määrä. Generaatioissa on aina 100 DNA:ta. Joten järjestämiseen menee O(100p + 460) => O(p), missä vakiokerroin on 100

Generaatioita tehdään käyttäjän valitsema määrä. Täten koko algoritmiin menee O(g*(l^2+m+p)) => O(gl^2 + gm + gp), missä g on generaatioiden määrä, ja vakiokerroin on 100