**Viikko 4**

Neljännellä viikolla jatkui koodin korjaaminen. Nyt työn alla oli jo Solver luokan doGenerations ja getBest metodit, joiden ajo pitäisi ratkaista CVRP ongelman. Tietenkin testeissä tuli ilmi monia ongelmia, joita korjasin tämän viikon.

Yksi yllättävä oli se että mutaatio metodi sekotti joskus alku sijaintia (0. sijainti) muiden sijaintien kanssa, kun taas crossover varmisti että 0. sijainti on aina ensimmäinen sijainti DNA:ssa. Tämä johti siihen että DNA:n koko kasvoi 0. sijainnin kopioista ja aika mikä kului generaation tekoon kasvoi kokoajan.

Sain kuitenkin algoitmista lopulta toimivan. Se antaa testeissä aina hyvin samantapaisia tuloksia, joka viittaa siihen että se pääsee lähelle globaalia maksimia, varsinkin kun algoritmi palkitsee ensimmäisten generaatioiden aikana erilaisuutta verrattuna vanhempiin.

Nyt kun algoritmi on jokseenkin toimivassa tilassa, pystyy aloittamaan graaffisen käyttöliittymän teon ensiviikolla. Algoritmi myös kaipaisi hieman refactorointia koska koodi on varsin epäselkeää ja välillä pitkää.