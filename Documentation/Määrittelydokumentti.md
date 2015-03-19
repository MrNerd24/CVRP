# Capacitated Vehicle Routing Problem

Ongelmana on ratkaista nopein tapa jakaa paketteja eri kohteisiin k�ytt�m�ll� yht� tai useampaa autoa. Autoilla on raja kuinka monta pakettia ne voivat kuljettaa. Jos kaikki paketit eiv�t mahdu kerralla, joudutaan laskemaan toinen kierros.

Ongelma ratkaistaan geneettisell� algoritmilla, miss� alussa luodaan monta t�ysin sattumanaraista tapaa ratkaista ongelma. N�iden tapojen tehokkuus lasketaan ja parhaat tavat valitaan uudelle kierrokselle eli generaatiolle. Joka kierroksella edellisen kierrokset parhaista luodaan uusia tapoja jotka ovat hieman erillaisia eli mutatoituineita, ja niihin voidaan my�s yhdistell� kahden vanhemman ominaisuuksia sattumanvaraisesti eli tehd� crossover.

Tavat ratkaista ongelma parantuvat joka generaatiolla, ja jossain vaiheessa pit�isi l�yty� niin hyv� tapa ett� sit� ei voida en��n juurinkaan parantaa.

Jotta voidaan v�ltt�� algoritmin juuttumista lokaaliin maksimiin, voidaan tapoja my�s j�rjest�� sen mukaan kuinka paljon ne eroavat vanhemmistaan. T�ll� tavalla globaali maksimi on helpompi l�yt�� alussa. Loppuakohden erillaisuuden t�rkeytt� voidaan laskea, jolloin kaikki generaatiot toivottavasti j��v�t paikoilleen globaaliin maksimiin.

Tavoitteena on, ett� k�ytt�j� pystyy itse piirt�m��n pisteet tai generoimaan randomeja pisteit�. Sitten h�n luo jonkin m��r�n generaatioita ja lopuksi n�kee parhaimman polun.

Algoritmi ei tule suoriutumaan suuresta generaatio tai paikka m��r�st� ihan silm�nr�p�yksess�. Mutta se on parempi kuin bruteforce.