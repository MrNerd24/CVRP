# Rakenne ja O-analyysi

Algoritmi luo uusia generaatiota ja jokaisessa generaatiossa se luo 100 uutta DNA:ta, mutatoi ne, pisteytt�� ne ja lopuksi kaikki DNA:t j�rjestet��n.

Joka kerta kun DNA luodaan, se saa is�lt��n ja �idilt��n arvot. is�lt� arvojen hakeminen kest�� O(l) aikaa, miss� l on sijaintien m��r�. �idilt� arvojen hakeminen kest�� O(l^2) aikaa, miss� l on sijaintien m��r�. Toisen asteen potenssi johtuu siit� ett� samalla pit�� tarkistaa onko sama sijainti tullut jo is�tl�. T�ten crossover on aikavaatimukseltaan O(l^2)

Mutaatioiden maksimim��r� on k�ytt�j�n asettama. Yksi mutaatio vain vaihtaa kahden sijainnin paikkaa, jolloin mutaation aikavaatimus on O(1). N�in ollen yhden DNA:n kaikkien mutaatioiden aikavaatimus on O(m), miss� m on max mutaatioiden m��r�.

Pisteiden laskuun tarvitaan laskea reitti, mink� DNA pit�� sis�ll��n. Reitin laskemisessa k�yd��n jokaisen sijainnin jokainen paketti l�pi. N�in ollen reitin laskemiseen menee O(p) aikaa miss� p on kaikkien pakettien m��r�.

Pisteisiin lasketaan my�s DNA:n eroavaisuus suhteessa vanhempiinsa. Eroavaisuuden laskemisessa k�yd��n is�n, �idin ja lapsen sijainnit l�pi. Eroavaisuuden laskemisessa menee siis O(l) aikaa miss� l on sijaintien m��r�. Vakiokerroin on 3. 

Reitin ja eroavaisuuden yhdist�v� pisteidenlasku algoritmi tekee vain normaaleja laskutoimituksia vakioajassa. T�ten koko pisteiden laskuun menee  O(p+l).

DNA:n pisteit� k�ytet��n j�rjest�misess�. J�rjest�miseen k�ytet��n merge sorttia, jonka aikavaativuus on O(nlog(n)). DNA:n pisteet laitetaan muistiin enismm�isen laskemisen j�lkeen. T�ll�in j�rjest�miseen menee O(p*d + dlog(d)) miss� d on generaation DNA m��r�. Generaatioissa on aina 100 DNA:ta. Joten j�rjest�miseen menee O(100p + 460) => O(p), miss� vakiokerroin on 100

Generaatioita tehd��n k�ytt�j�n valitsema m��r�. T�ten koko algoritmiin menee O(g*(l^2+m+p)) => O(gl^2 + gm + gp), miss� g on generaatioiden m��r�, ja vakiokerroin on 100