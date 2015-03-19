# Capacitated Vehicle Routing Problem

Ongelmana on ratkaista nopein tapa jakaa paketteja eri kohteisiin käyttämällä yhtä tai useampaa autoa. Autoilla on raja kuinka monta pakettia ne voivat kuljettaa. Jos kaikki paketit eivät mahdu kerralla, joudutaan laskemaan toinen kierros.

Ongelma ratkaistaan geneettisellä algoritmilla, missä alussa luodaan monta täysin sattumanaraista tapaa ratkaista ongelma. Näiden tapojen tehokkuus lasketaan ja parhaat tavat valitaan uudelle kierrokselle eli generaatiolle. Joka kierroksella edellisen kierrokset parhaista luodaan uusia tapoja jotka ovat hieman erillaisia eli mutatoituineita, ja niihin voidaan myös yhdistellä kahden vanhemman ominaisuuksia sattumanvaraisesti eli tehdä crossover.

Tavat ratkaista ongelma parantuvat joka generaatiolla, ja jossain vaiheessa pitäisi löytyä niin hyvä tapa että sitä ei voida enään juurinkaan parantaa.

Jotta voidaan välttää algoritmin juuttumista lokaaliin maksimiin, voidaan tapoja myös järjestää sen mukaan kuinka paljon ne eroavat vanhemmistaan. Tällä tavalla globaali maksimi on helpompi löytää alussa. Loppuakohden erillaisuuden tärkeyttä voidaan laskea, jolloin kaikki generaatiot toivottavasti jäävät paikoilleen globaaliin maksimiin.

Tavoitteena on, että käyttäjä pystyy itse piirtämään pisteet tai generoimaan randomeja pisteitä. Sitten hän luo jonkin määrän generaatioita ja lopuksi näkee parhaimman polun.

Algoritmi ei tule suoriutumaan suuresta generaatio tai paikka määrästä ihan silmänräpäyksessä. Mutta se on parempi kuin bruteforce.