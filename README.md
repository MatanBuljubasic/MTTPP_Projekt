# MTTPP Projektni zadatak

## Opis testova

### RedditHomePageTest
Test provjerava nalazimo li se na željenoj stranici kada pritisnemo tipku s logom *Reddita*. Provjera se radi tako što se utvrdi postojanje tipke za *login*, postojanje niza objava te nalazi li se određeni tekst u *placeholder* atributu polja za upis pretraživanja.

### RedditSearchResultsPageTest
Test provjerava dobijemo li željene rezultate pretrage nakon pretraživanja određenog pojma. Provjera se radi na način da se u *search bar* unese određeni pojam, zatim se pritisne *enter* i utvrdi se postojanje traženog pojma u naslovu prve objave koju dohvatimo.

### RedditSinglePostPageTest
Test provjerava nalazimo li se na stranici prve objave na glavnoj stranici kada ju kliknemo. Provjera se obavlja tako da se nakon klika na objavu utvrdi postojanje triju tipki koje bi trebale biti na toj stranici.

### RedditSubredditPageTest
Test provjerava nalazimo li se na stranici prvog *subreddita* kojeg pronađemo pod *Popular communities*, nakon što kliknemo na njega. Provjera se radi na način da se poslije klika na *subreddit* utvrdi postojanje *sidebara* koji treba postojati na stranici bilo kojeg *subreddita*, te jednakost *web* adrese na koju smo kliknuli i *web* adrese na kojoj se nalazimo nakon klika.

### RedditUserPageTest
Test provjerava nalazimo li se na stranici autora prve objave na glavnoj stranici. Provjera se obavlja tako da usporedimo ime korisnika čija je objava i korisnika na čijoj smo stranici, utvrdimo postojanje tipki i oznaka koje bi trebale biti na stranici svakog korisnika.

## Opis korištenih metoda i tehnologija

### Selenium WebDriver
Svaki *HTML* element nad kojim se trebala vršiti radnja ili provjera se dohvaćao pomoću *XPatha*, *ID-a* ili imena, te se spremao kao instanca *WebElement* klase *Selenium WebDrivera*. Pomoću instance su se mogle simulirati radnje nad tim elementom kao što su klikanje i unošenje znakova. *Selenium WebDriver* je također pružao *drivere* potrebne za pojedini pretraživač. Uz to, koristile su se i *Wait* naredbe *Selenium WebDrivera*, točnije eksplicitne *Wait* naredbe koje čekaju određeno vrijeme da se traženi element pojavi na zaslonu, inače daje grešku.

### Page Object Model
*POM* (Page Object Model) je oblikovni obrazac za *Selenium WebDriver* koji svaku stranicu stavlja u zasebnu klasu. U ovom projektu se izdvojila bazna klasa *RedditBasePage* koja sadrži sve elemente koji su konstantni na svim stranicama *Reddita*. Nadalje, klasa za svaku stranicu proširuje navedenu baznu klasu s dodatnim elementima.

### .gitignore
.gitignore datoteka je postavljena na način da ignorira sve dinamički generirane datoteke koje se stvore prilikom pokretanja testova.

### Cross Browser testing
Iz klasa za pojedine testove se također izvuklo zajedničko i stavilo se u baznu klasu *RedditBaseTest*. U navedenoj klasu se nalazi *BeforeClass* anotacija koja prije pokretanja svakog testa na temelju zadanog parametra odluči test pokrenuti ili u *Google Chromeu* ili u *Mozilla Firefoxu*.

### Reporting
Pomoću *TestNG-a* se nakon izvršenog testa stvara izvješće o provedenim testovima koje se nalazi u datoteci projekta.

### Shadow DOM
Prilikom izrade ovog projekta se pojavio problem u vezi dohavaćanja određenih elemenata na stranici. Nakon istraživanja se ispostavilo da određeni *shadow root* elementi stvaraju taj problem. Stoga se u nekim situacijama koristila *Shadow* klasa koja se nalazi na https://github.com/sukgu/shadow-automation-selenium. Konstruktoru ove klase se predaje *driver* pretraživača, te se nadalje instanca *Shadow* klase koristi umjesto samog *drivera*.
