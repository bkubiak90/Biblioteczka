package bk90.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

//singleton class
public class Utils {

    /**
     *  tworzenie bazy danych aplikacji (6 )
     */
    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String FAVORITE_BOOKS = "favorite_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";

    private static Utils instance;
    /**
     * tworzenie bazy danych aplikacji (1)
     */
    private SharedPreferences sharedPreferences;


//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> favoriteBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadBooks;
//    private static ArrayList<Book> allBooks;


    private Utils(Context context) {
        /**
         *  tworzenie bazy danych aplikacji (2)
         */
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);
        if (null == getAllBooks()) {
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        if (null == getFavoriteBooks()) {
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getAlreadyReadBooks()) {
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()) {
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReadBooks()) {
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

    }

    private void initData() {
        /**
         *  tworzenie bazy danych aplikacji (3)
         */
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "Władca Pierścieni: Trylogia", "Tolkien John Ronald Reuel", 1280, "https://ecsmedia.pl/c/wladca-pierscieni-druzyna-pierscienia-dwie-wieze-powrot-krola-b-iext41745185.jpg", "",
                "Niełatwo powiedzieć, na czym polega tajemnica uroku wywieranego przez \"Władcę Pierścieni\". Miał niewątpliwie rację C.S Lewis, pisząc: \"Dla nas, żyjących w paskudnym, zmaterializowanym i pozbawionym romantyzmu świecie możliwość powrotu dzięki tej książce do czasów heroicznych przygód, barwnych, przepysznych i wręcz bezwstydnie pięknych opowieści jest czymś niezwykle ważnym\".\n" +
                        "\n" +
                        "Równie istotna jest przyjemność, jaką czytelnik czerpie z odkrywania złożonego, ale logicznie skonstruowanego uniwersum tej opowieści. Umożliwiają to dołączone do książki mapy oraz obszerne dodatki.\n" +
                        "\n" +
                        "\"Władca Pierścieni\" to jedna z najbardziej niezwykłych książek w całej współczesnej literaturze. Ogromna, z epickim rozmachem napisana powieść wprowadza nas w wykreowany przez wyobraźnię autora świat - fantastyczny, lecz ukazany wszechstronnie i szczegółowo, równie pełny i bogaty jak świat realny. Przykuwająca uwagę i wzruszająca, zabawna, choć momentami także przerażająca, opowieść ta rzuca na czytelnika czar, od którego nawet po zakończeniu lektury trudno się uwolnić. W ciągu pięćdziesięciu przeszło lat od pierwszego wydania \"Władcy Pierścieni\" miliony ludzi na całym świecie uległy temu urokowi."));

        books.add(new Book(2, "Metro 2033", "Glukhovsky Dmitry", 592, "https://ecsmedia.pl/c/uniwersum-metro-2033-metro-2033-b-iext44139349.jpg", "",
                "Rok 2033. Świat w wyniku konfliktu atomowego został obrócony w stertę gruzu. Jednym z ostatnich – może ostatnim? – ze skupisk ludzkości pozostaje moskiewskie metro. Od ponad 20 lat ludzie, którzy ocaleli z piekła wojny, próbują uchronić co tylko się da z minionej przeszłości. Zamknięci w podziemnym świecie, w którym brakuje wszystkiego, a nade wszystko energii, skazani są na regres.\n" +
                        "\n" +
                        "Na powierzchni pojawiły się zmutowane pod wpływem promieniowania nowe gatunki i będąc lepiej przystosowanymi do życia w warunkach ciągłej radiacji zastąpiły człowieka. Zaczynają też przenikać do metra. Czas człowieka przeminął. Ale czy na pewno?"));

        books.add(new Book(3, "Pan Lodowego Ogrodu", "Jarosław Grzędowicz", 2536, "https://fabrykaslow.com.pl/wp/wp-content/uploads/2018/02/28461669_1700922136636072_1333582213_o.jpg", "",
                "Główny bohater Vuko Drakkainen zostaje wysłany na planetę Midgaard. Mimo że zamieszkują ją człekopodobne stwory, ma zakaz jakikolwiek kontaktów z nimi i ingerowania w rozwój ich nieznanej kultury. Jego zadaniem jest odnaleźć i ewakuować wysłaną tu wcześniej ziemską ekipę badawczą. Trafia jednak na okres najgorszy z możliwych. Na planecie trwa wojna bogów..."));

        books.add(new Book(4, "Nienzniszczalny", "Cezary Gutowski", 288, "https://ecsmedia.pl/c/niezniszczalny-b-iext54088252.jpg", "",
                "„Temat na scenariusz”, „Jeśli wróci, będzie z tego piękny film” – pisali i mówili kibice oraz dziennikarze, gdy kilka miesięcy temu pojawiły się informacje, że Robert Kubica ma szanse, po ośmiu latach przerwy, znów ścigać się w Formule 1. W tym niezwykłym – dla każdego, kto zna losy zdolnego kierowcy – wydarzeniu słusznie dostrzegali potencjał na pasjonującą hollywoodzką story. A przecież Polak pierwsze fragmenty świetnego filmowego scenariusza „pisał” już od lat. Jest w nim wszystko, co kochają widzowie pod każdą szerokością geograficzną: dziecięca pasja, młodzieńcze lata wyrzeczeń, rozłąka z rodziną, wielkie sukcesy i bolesne porażki, dramatyczne wypadki, walka o życie, zdrowie, powrót do wyczynowego sportu… Kariera Roberta jest pełna momentów, w których dokonywał wręcz niewyobrażalnego – pokazujących nie tylko, jakim jest sportowcem, ale przede wszystkim, jakim człowiekiem."));

        books.add(new Book(5, "Alchemik", "Coelho Paulo ", 216, "https://www.swiatksiazki.pl/media/catalog/product/cache/a946e6dbdb55333e1c3d566a3e38b923/1/x/1x99904054810.jpg", "",
                "Książka otwiera te drzwi w naszej duszy, o których istnieniu wolelibyśmy czasami zapomnieć. Każe marzyć, podążać za własnym powołaniem, podejmować ryzyko, pójść w świat i wrócić wystarczająco śmiałym by stawić czoła wszelkim przeszkodom. Baśniowa, alegoryczna powieść o wędrówce andaluzyjskiego pasterza, jest tłem do medytacji nad tym, jak ominąć życiowe pułapki by dotrzeć do samego siebie.\n" +
                        "\n" +
                        "Alchemia Paula Coelho to tajemna wiedza o prawdzie i jej dwu obliczach. Autor burzy wszelkie bariery bojaźni, które powstrzymują strumień naszych pragnień.\n" +
                        "\n" +
                        "Potrzeba Alchemika i jego światowy rozgłos są oczywiste, albowiem lektura książki przemienia w złoto nawet najbardziej zaśniedziałe sprężyny ludzkich marzeń."));

        books.add(new Book(6, "Wiedźmin. Tom 1-8", "Andrzej Sapkowski", 3310, "https://ecsmedia.pl/c/14711946371287549-jpg-gallery.big-iext43636243.jpg", "",
                "\"Ostatnie życzenie\"\n" +
                        "Później mówiono, że człowiek ów nadszedł od północy, od Bramy Powroźniczej. Nie był stary, ale włosy miał zupełnie białe. Kiedy ściągnął płaszcz, okazało się, że na pasie za plecami ma miecz. Białowłosego przywiodło do miasta królewskie orędzie: trzy tysiące orenów nagrody za odczarowanie nękającej mieszkańców Wyzimy strzygi. Takie czasy nastały. Dawniej po lasach jeno wilki wyły, teraz namnożyło się rozmaitego paskudztwa - gdzie spojrzysz, tam upiory, bazyliszki, diaboły, żywiołaki, wiły i utopce plugawe. A i niebacznie uwolniony z amfory dżinn, potrafiący zamienić życie spokojnego miasta w koszmar, się trafi. Tu nie wystarczą zwykłe czary ani osinowe kołki. Tu trzeba zawodowca. Wiedźmina.\n" +
                        "\n" +
                        "\"Miecz przeznaczenia\"\n" +
                        "Wiedźmiński kodeks stawia tę sprawę w sposób jednoznaczny: wiedźminowi smoka zabijać się nie godzi. To gatunek zagrożony wymarciem. Aczkolwiek w powszechnej opinii to gad najbardziej wredny. Na oszluzgi, widłogony i latawce kodeks polować przyzwala. Ale na smoki - nie.\n" +
                        "\n" +
                        "\"Krew elfów\"\n" +
                        "Tako rzecze Ithlinne, elfia wieszczka i uzdrowicielka: Drżyjcie, albowiem nadchodzi Niszczyciel Narodów. Stratują waszą ziemię i sznurem ją podzielą. Miasta wasze zostaną zburzone i pozbawione mieszkańców. Nietoperz i kruk w domach waszych zamieszkają, drzewo straci liść, zgnije owoc i zgorzknieje ziarno. Zaprawdę powiadam wam, oto nadchodzi czas miecza i topora, wiek wilczej zamieci.\n" +
                        "\n" +
                        "\"Czas pogardy\"\n" +
                        "Świat Ciri i wiedźmina ogarniają płomienie. Nastał zapowiadany przez Ithlinne czas miecza i topora. Czas pogardy. A w czasach pogardy na powierzchnię wypełzają Szczury. Szczury atakujące po szczurzemu, cicho, zdradziecko i okrutnie. Szczury uwielbiające dobrą zabawę i zabijanie. Maruderzy z rozbitych armii, zabłąkane dzieciaki, wyrzutki, dziwna zbieranina stworzona przez wojnę i na wojennym nieszczęściu żerująca.\n" +
                        "\n" +
                        "\"Chrzest ognia\"\n" +
                        "Oto Geraltowa kompania:\n" +
                        "Jaskier, trubadur w kapelusiku z piórkiem egreta. Studiował siedem sztuk wyzwolonych, słynny po wszystkich dworach i zamtuzach. \"Kłamliwa łajza\" i \"zachrypnięty bażant\" to najłagodniejsze z określeń, jakim obdarzają go porzucone kochanki.\n" +
                        "Cahir, czarny rycerz z koszmarów Ciri. Poszukiwany przez najlepszych szpiegów Cesarstwa, Nilfgaardczyk, który dowodzi, że Nilfgaardczykiem wcale nie jest.\n" +
                        "Milva, trafiająca z dwustu kroków łuczniczka. Pyskata i do słów nieparlamentarnych skora.\n" +
                        "Regis, cyrulik intelektualista. Nosi się staroświecko i pachnie ziołowo-korzennie. Osobnik jakby nie z tej bajki.\n" +
                        "\n" +
                        "\"Wieża Jaskółki\"\n" +
                        "Jesienne Ekwinokcjum tegoż dziwnego roku przyniosło rozmaite znaki na niebie i ziemi, które jakoweś klęski niechybnie zwiastowały. Tuż przed północą zerwała się straszliwa zawierucha, zadął potępieńczy wicher, a pędzone po niebie chmury przybrały fantastyczne kształty, wśród których najczęściej powtarzały się sylwetki galopujących koni i jednorożców. Lelki dzikimi głosami wyśpiewywały konajączkę, zaskowyczała beann'shie, zwiastunka rychłej i gwałtownej śmierci. A gdy przecwałował Dziki Gon i rozwiały się chmury, ludzie zobaczyli księżyc - malejący, jak zwykle w czas Zrównania. Ale tej nocy księżyc miał barwę krwi.\n" +
                        "\n" +
                        "\"Pani Jeziora\"\n" +
                        "Ciri wpatruje się w wypukły relief przedstawiający ogromnego łuskowatego węża. Gad, zwinąwszy się w kształt ósemki, wygryzł się zębiskami we własny ogon. To pradawny wąż Uroboros. Symbolizuje nieskończoność i sam jest nieskończonością. Jest wiecznym odchodzeniem i wiecznym powracaniem. Jest czymś, co nie ma ani początku, ani końca.\n" +
                        "\n" +
                        "\"Sezon burz\"\n" +
                        "Nigdy nie mów nigdy! W powieści pojawiają się osoby doskonale czytelnikom znane, jak wierny druh Geralta – bard i poeta Jaskier – oraz jego ukochana, zwodnicza czarodziejka Yennefer, ale na scenę wkraczają też dosłownie i w przenośni postaci z zupełnie innych bajek. Ludzie, nieludzie i magiczną sztuką wyhodowane bestie. Opowieść zaczyna się wedle reguł gatunku: od trzęsienia ziemi, a potem napięcie rośnie. Wiedźmin stacza morderczą walkę z drapieżnikiem, który żyje tylko po to, żeby zabijać, wdaje się w bójkę z rosłymi, niezbyt sympatycznymi strażniczkami miejskimi, staje przed sądem, traci swe słynne miecze i przeżywa burzliwy romans z rudowłosą pięknością, zwaną Koral. A w tle toczą się królewskie i czarodziejskie intrygi. Pobrzmiewają pioruny i szaleją burze."));

        books.add(new Book(7, "Harry Potter. Tom 1-7", "Rowling J.K.", 3656, "https://cdn.vox-cdn.com/thumbor/X1iZwGtOBjHqKt36tEeHWUWFtjU=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/19289131/harry_potter.jpg", "",
                "\"Harry Potter i kamień filozoficzny\"\n" +
                        "\n" +
                        "Harry Potter to sierota i podrzutek, od niemowlęcia wychowywany przez ciotkę i wuja, którzy podobnie jak ich syn Dudley - traktowali go jak piąte koło u wozu. Pochodzenie chłopca owiane jest tajemnicą, jedyna pamiątka z przeszłości to zagadkowa blizna na jego czole. Skąd jednak biorą się niesamowite zjawiska, które towarzyszą nieświadomemu niczego Potterowi? Wszystko wyjaśni się w jedenaste urodziny chłopca, a będzie to dopiero początek Wielkiej Tajemnicy...\n" +
                        "\n" +
                        "\"Harry Potter i komnata tajemnic\"\n" +
                        "\n" +
                        "Kontynuacja tomu \"Harry Potter i Kamień Filozoficzny\". Jedenastoletniemu Harryemu udało się pokonać czarnoksiężnika, teraz musi zmierzyć się z przerażającym potworem z Komnaty Tajemnic na zamku Hogwart. W dodatku jeden z jego najbliższych przyjaciół znajduje się w śmiertelnym niebezpieczeństwie.\n" +
                        "\n" +
                        "\"Harry Potter i więzień Azkabanu\"\n" +
                        "\n" +
                        "Z ciężkiego więzienia ucieka przestępca. Kim jest? Co łączy go z Harrym? Dlaczego lekcje przepowiadania przyszłości stają się dla Harryego tak bardzo nużące? Tego wszystkiego i wiele więcej dowiecie się z trzeciego tomu przygód niezwykłego chłopca. Poznacie nowego nauczyciela od obrony przed czarną magią. Zobaczycie Hagrida w nowej roli oraz dowiecie się więcej o przeszłości profesora Snape'a.\n" +
                        "\n" +
                        "\"Harry Potter i czara ognia\"\n" +
                        "\n" +
                        "W tym roku w Szkole Magii i Czarodziejstwa Hogwart rozegra się Turniej Trójmagiczny, na który przybędą uczniowie z Bułgarii i Francji. Zgodnie z prastarymi regułami w turnieju uczestniczyć ma trzech uczniów - reprezentantów każdej ze szkół, wybranych przez Czarę Ognia. Dziwnym zbiegiem okoliczności wybranych zostaje czterech... Co z tego wynika dla Harry`ego, jego przyjaciół i całego świata czarodziejów?\n" +
                        "\n" +
                        "\"Harry Potter i zakon Feniksa\"\n" +
                        "\n" +
                        "Harry znów spędza nudne, przykre wakacje w domu Dursleyów. Czeka go piąty rok nauki w Hogwarcie i chciałby jak najszybciej spotkać się ze swoimi najlepszymi przyjaciółmi, Ronem i Hermioną. Ci jednak wyraźnie go zaniedbują. Gdy Harry ma już dość wszystkiego wszystkiego postanawia jakoś zmienić swoją nieznośną sytuację, sprawy przyjmują całkiem nieoczekiwany obrót. Wygląda na to, że nowy rok nauki w Hogwarcie będzie bardzo dramatyczny.\n" +
                        "\n" +
                        "\"Harry Potter i książę półkrwi\"\n" +
                        "\n" +
                        "Po nieudanej próbie przechwycenia przepowiedni Lord Voldemort jest gotów uczynić wszystko, by zawładnąć światem czarodziejów. Organizuje tajemny zamach na swego przeciwnika, a narzędziem w jego ręku staje się jeden z uczniów. Czy jego plan się powiedzie? Tom szósty przygód Harry’ego Pottera przynosi cenne informacje o matce Voldemorta, jego dzieciństwie oraz początkach kariery młodego Toma Riddle’a, które rzucą nowe światło na sylwetkę głównego antagonisty Pottera.\n" +
                        "\n" +
                        "\"Harry Potter i insygnia śmierci\"\n" +
                        "\n" +
                        "Po śmierci Dumbledore'a Zakon Feniksa wzmaga swoją działalność, próbując przeciwstawić się coraz potężniejszym siłom śmierciożerców. Harry wraz z przyjaciółmi opuszcza Hogwart, by odnaleźć sposób na pokonanie Voldemorta. Wyprawa ta pełna niepewności i zwątpienia najeżona jest niebezpieczeństwami, a co gorsza nikt nie wie, czy zakończy się sukcesem i czy wszyscy dotrwają do jej końca.\n" +
                        "\n" +
                        "Dlaczego Dumbledore nie pozostawił Harry'emu czytelnych wskazówek? Czy przeszłość nieżyjącego dyrektora kryje jakieś niezwykłe tajemnice? Jaką rolę odegra Snape przy boku Voldemorta? Czy Harry'emu uda się dotrzeć do najważniejszych miejsc i faktów dotyczących jego rodziny?"));

        books.add(new Book(8, "Hobbit", "Tolkien John Ronald Reuel", 320, "https://ecsmedia.pl/c/hobbit-b-iext34518972.jpg", "",
                "„Hobbit” jest początkiem historii kontynuowanej w trylogii „Władca pierścieni”, po którą bardzo chętnie sięgają kolejne pokolenia. Wkrocz śmiało w świat Śródziemia, poznaj kolejnych bohaterów i ich losy. Czy Bilbo przetrwa drogę w góry? Czy wszyscy powrócą z wyprawy? Co stanie się z Thorinem? Sprawdź to sam!"));


        /**
         *  tworzenie bazy danych aplikacji (4) //Gson pozwala na przekonwertowanie obiektu na string
         */
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS, null), type);
        return books;    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null), type);
        return books;
    }

    public ArrayList<Book> getAllBooks() {
        /**
         * tworzenie bazy danych aplikacji (5)
         */
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return books;
    }

    public Book getBookById(int id) {
        ArrayList<Book> books = getAllBooks();
        if (null != books) {
            for (Book b : books) {
                if (b.getId() == id) {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        /**
         * tworzenie bazy danych aplikacji (7)
         */
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToWishlist(Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToCurrentlyReading(Book book) {
        ArrayList<Book> books = getCurrentlyReadBooks();
        if (null != books) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;    }

    public boolean addToFavorite(Book book) {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;    }

    public boolean removeFromAlreadyRead (Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (null != books) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromCurrentlyRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadBooks();
        if (null != books) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (null != books) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeFromFavorites(Book book) {
        ArrayList<Book> books = getFavoriteBooks();
        if (null != books) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
