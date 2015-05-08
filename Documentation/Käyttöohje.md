# K‰yttˆohje

Ohjelmassa voi ratkoa CVRP ongelman, eli lyhyin reitti autoille vied‰ paketteja eri sijainteihin niin ett‰ autoilla on painorajoituksia.

Ohjelmassa k‰ytt‰j‰ voi luoda oman kartan tai generoida sattumanvaraisen kartan. karttoja voi aina muokata ja lis‰t‰ autoja tai paketteja. Ikkunan oikeassa reunassa on lista kaikista elementeist‰, ja niit‰ voi muokata.

Yl‰osassa ikkunaa voi ohjata ohjelmaa:

- New: Luo uuden tyhj‰n kartan.

- Reset: S‰ilytt‰‰ kartan, mutta ratkaisu unohdetaan.

- Locations in random: Sijaintien m‰‰r‰ kun uusi sattumanvarainen kartta generoidaan.

- Random map: Luo uuden sattumanvaraisen kartan. Kartalla on aluksi 1 auto, ja jokaisella sijainnilla on 0-5 eri pakettia, joiden paino on 0-50. Sijaintien m‰‰r‰ on k‰ytt‰j‰n valitsema.

- Amount of generations: Ajettavien generaatioiden m‰‰r‰. Minimi arvo on 1.

- Do generations: ajaa kerralla k‰ytt‰j‰n valitseman m‰‰r‰n sukupolvia. Mit‰ enemm‰n generaatioita, sit‰ parempi vastaus. 10000 sukupolvea on usein tarpeeksi.

- Max mutations: m‰‰ritt‰‰ kuinka paljon yksitt‰inen ratkaisu voi mutatoitua. Esim jos arvo on 20, voi mutaatioita tapahtua sattumanvaraisesti 0-20.

- Difference decrease: Arvo v‰lilt‰ 0-1, mik‰ m‰‰rittelee kuinka paljon erillaisuuden painotus laskee per generaatio. Esim jos difference distance on aluksi 100 ja decrease 0.80, distance laskee joka sukupolvella 20%. 100 -> 80 -> 64 -> 51 -> 41 -> 32 jne.

- Fitness- ja difference distance: N‰iden arvojen suhde toisiinsa m‰‰rittelee kuinka paljon ratkaisut painottavat joko pituuden laskemista tai erillaisuutta. Difference distance laskee joka sukupolvella, kunnes se putoaa alle 1, jolloin painotetaan vain pient‰ pituutta. Difference distance palaa asetettuun arvoon, kun kartan resetoi. 