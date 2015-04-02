**Viikko 4**

Nelj�nnell� viikolla jatkui koodin korjaaminen. Nyt ty�n alla oli jo Solver luokan doGenerations ja getBest metodit, joiden ajo pit�isi ratkaista CVRP ongelman. Tietenkin testeiss� tuli ilmi monia ongelmia, joita korjasin t�m�n viikon.

Yksi yll�tt�v� oli se ett� mutaatio metodi sekotti joskus alku sijaintia (0. sijainti) muiden sijaintien kanssa, kun taas crossover varmisti ett� 0. sijainti on aina ensimm�inen sijainti DNA:ssa. T�m� johti siihen ett� DNA:n koko kasvoi 0. sijainnin kopioista ja aika mik� kului generaation tekoon kasvoi kokoajan.

Sain kuitenkin algoitmista lopulta toimivan. Se antaa testeiss� aina hyvin samantapaisia tuloksia, joka viittaa siihen ett� se p��see l�helle globaalia maksimia, varsinkin kun algoritmi palkitsee ensimm�isten generaatioiden aikana erilaisuutta verrattuna vanhempiin.

Nyt kun algoritmi on jokseenkin toimivassa tilassa, pystyy aloittamaan graaffisen k�ytt�liittym�n teon ensiviikolla. Algoritmi my�s kaipaisi hieman refactorointia koska koodi on varsin ep�selke�� ja v�lill� pitk��.