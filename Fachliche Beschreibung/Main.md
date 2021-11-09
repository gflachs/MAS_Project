# Hallo und herzlich Willkommen zum Projekt **Name folgt**
Wir, also Dounia Bouzidi, Florian Anthes und Gregor Flachs, Studenten der HTW-Berlin, werden uns nachfolgenden mit folgender Aufgabenstellung beschäftigen:

## Aufgabenstellung
>Sie wollen ein Unternehmen gründen.  
Überlegen Sie sich dazu, welche/s Produkt/e und/oder Dienstleistungen Ihr Unternehmen am Markt anbieten soll.  
Sie sollen im Rahmen der Projektarbeit 
für jeden der folgenden Bereiche für Ihr Unternehmen mindestens einen Prozess umsetzen (d.h. 
mindestens 3 Prozesse):  
> - Prozess Auftrag/Bestellung: Wie beauftragt der Kunde Sie / bestellt etwas bei Ihnen? Wie läuft der Prozess dazu ab?  
> - Prozess Wertschöpfung: Wie wird die Leistung in Ihrem Unternehmen erstellt. Wie läuft der Prozess dazu ab?  
> - Prozess Service: Sobald Sie Ihre Leistung (Produkt/Dienstleistung) erbracht haben, welchen Service bietet Ihr Unternehmen bei Fragen, Reklamationen etc. an. Wie sieht der Prozess hierfür aus?
>
> *Quelle: Moodle - Aufgabenstellung zur Projektarbeit (beide Tools)*

## Unternehmensdefintion
In einem ersten Brainstorming legten wir folgende Unternehmenseigenschaften fest:  
Unternehmensart:  
- Webshop zum Erwerben von Naturprodukten aus nicht EU Ländern
- Volle Transparenz bezüglich der Versorgungskette
Dienstleistung: 
-	Import und Verkauf von nicht EU Naturprodukten in einem Subscriptionmodel (ähnlich Hello Fresh Kochboxen).   
-	Beratung zum Einsatz dieser Produkte
-	Volle Transparenz (vom Feld bis zum Endprodukt) 
-	Verarbeitung der Produkte zu weiteren Produkten

## Unternehmensbeschreibung
Die **Name folgt** hat es sich als Ziel gesetzt, der führende Anbieter von Naturprodukten aus Nicht-EU Ländern zu werden.  
Der Vetrieb der Produkte erfolgt über einen Webshop. Kunden erhalten dabei volle Transparenz über die angebotenen Artikel, angefangen bei dem Feld, auf dem dieses gewachsen ist, über den Bauer, welcher dieses geerntet hat bis hin zum Importeur des Artikels. Diese Lieferkette muss zwingend nachvollziehbar sein, stellt diese doch für den Kunden sicher, dass es sich um ökologisch einwandfreie Produkte handelt.  

Die angebotenen Dienstleistungen umfassen dabei vor allem den Erwerb sogeannter Aboboxen über den Webshop (eine Erläuterung hierzu erfolgt später), aber auch die Beratung zum korrekten Einsatz spezifischer Produkte, sowie die Verarbeitung von importierten Produkten.  

Das Subscirptionmodel funktioniert wie folgt:  
Kunden packen eine Box mit Produkten. Diese Box wird nun im gewählten Intervall geliefert (1 Monat, 2 Monate etc.). Dabei kann ein Kunde verschiedene Lieferintervalle bedienen, jedoch müssen zwingend mindestens 5 Produkte (gleich oder verschieden) in der Box vorhanden sein.  
Wenn ein Kunde also bereits eine 1 Monatsbox hat, welche 5 Produkte umfasst und nun eine 2 Monatsbox mit 2 Artikeln befüllt, so wird er die 2 Monatsbox solange geliefert bekommen, wie die 1 Monatsbox auch geliefert wird, da hier aller 2 Monate dann einfach 7 statt 5 Artikel in der gelieferten Box enthalten sind.  

Der Import der Ware erfolgt dabei so, dass es zu so wenig wie möglich Lagerdauer und zu verwendende Lagerfläche kommt. So wird 2 Wochen bevor die entsprechende Aboboxen versendet werden, eine Sammelbestellung bei den Lieferanten ausgelöst. Sobald diese Ware angekommen ist, wird diese in die Boxen verpackt und zum Abozeitpunkt T-2 Tage versendet. Dadurch entstehen ein sehr geringer Bedarf an Lagerkapazitäten. 

## Prozesse
### Bestellung über den Webshop
Die Bestellung über den Webshop läuft im Regelfall folgendermaßen ab:  
Ein Kunde betritt den Webshop und informiert sich über die Produkte.  
Nach einiger Suche wählt der Kunde ein Produkt <span style="color:#ff3300">P</span> mit der Produktid <span style=color:pink>ID</span> aus. Er kommt nun auf die Produktseite.  
Nachfolgend fragt der Browser beim Webshop die <span style=color:pink>ID</span> and und erhält das Objekt <span style="color:#ff3300">P</span> zurück.  

![Produktabruf](http://www.plantuml.com/plantuml/svg/5St1ge90583X_NsAUnTtwuasGH2baKYOY2PKcnZ7epCvpiZCEVJwsVQ3d_yGI7ZYoVpyQIiDTyZU_2gYEMm1l7X7WoR5BGVqqbb2Iv5q4moz4L85kCJri_JkXP9W4jf2kh3HKk7_UfLWaCgZRjaEC1jXloE8My_zqdGyKZGliYStejt5TLvKnQCvtTBiUAysTLucvp9FgYoxDXy0)

Dieses Objekt beinhaltet folgende Daten:  
- Produktbeschreibung <span style="color:#b3b3ff">PB</span>
- Transparenzinformationen <span style="color:#8080ff">TI</span>
- Tipps zur Verwendung <span style ="color:#e6e6ff">VT</span>
- einen Preis <span style="color:#3333ff">G</span>
- eine sessionale Verfügbarkeit <span style="color:#e600e6">V</span>
- einen vorgeschlagenen Lieferintervall <span style="color:#4d9900">I</span>
- eine vorgeschlagene Menge <span style="color:#00cccc">M</span>

![Produkt](http://www.plantuml.com/plantuml/svg/3SfHou8m583Xl_9z5zrw8hGWYD0e2b9AAwgRcFFabdEJxHpw-tdvlZp_sah33R8tVufe24i0BxvHgqbnpG6zT9RGKYHT3-tR2Aa2v6drEddtGKdG2srXDswZfSB9R9fXaCgZhjcsC1XXYNi38s-uesWOOqskGxjAgsDH5l4XcoVd-Bb8glnstUQNhDnlxeyV)

Hat der Kunde während des Bestellprozesses Fragen zum Produkt oder zum Ablauf, so kann er jederzeit über die Infohotline den Kundenservice konaktieren.  

Ist der Kunde mit dem Produkt <span style="color:#ff3300">P</span> zufrieden, und möchte dieses bestellen, so wählt er eine Menge und einen Lieferintervall und kann dieses nun seiner Abobox hinzufügen.  
Ist der Kunde bereits registriert, aber noch nicht angemeldet, wird er nun zum Login aufgefordert.  
Ist der Kunde nicht nicht registriert, so kann er dies nun nachholen (siehe Prozess [`Registriervorgang`](#Registriervorgang)).  
Ist der Kunde erfolgreich eingeloggt, wird das Produkt <span style="color:#ff3300">P</span> der Abobox mit der Menge <span style="color:#00cccc">M</span> und dem gewünschten Lieferintervall <span style="color:#4d9900">I</span> hinzugefügt.  
Der Kunde kann nun weitere Produkte auswählen und diese zu seiner Abobox hinzufügen.    

![Produkt zu Abobox hinzufügen](http://www.plantuml.com/plantuml/png/5Sr1ImCn40NWUt-57hpkYDu4iHj5iRIbDeBLYoJPQHARdIp93Ch-UjFBCBptmLjMDeLbJ8lBI2x9W5BIHM2UwXr0CR-TZnp4IiNYCZ4ITowFu8_9k51Xq-llNSa_w1X64mcUMvoY2tXrSwsmkb0mMY4FKp9q7eB61pbnwsSfxVOss_pNdX1fbgEWH-gc9Xyudv3kUxtUxhUVN-f9hmwRDxLQFxxl3hTg__hneXTBfA7PVm00)       

Hat der Kunde seine Auswahl beendet, muss er anschließend seine neue Auswahl bestätigten. Dazu werden ihm alle Artikel in seiner Abobox angezeigt (inklusive Preis, Lieferintervall und Menge), wobei hier die neuen Artikel hervorgehoben werden. Zusätzlich sieht der Kunde auf einen Blick, welche **zusätzlichen Kosten** auf ihn zukommen.  
Der Kunde wird nun aufgefordter, seine Änderung zu prüfen und zu bestätigten.  

Hat der Kunde seine Änderungen bestätigt, so wird geprüft, ob in der Abobox im kleinstmöglichen Lieferintervall mindestens 5 Produkte vorhanden sind. Ist dies nicht der Fall, so wird der Kunde darüber informiert und aufgefordert weitere Produkte zu seiner Abobox hinzuzufügen.  
Sind 5 oder mehr Produkte vorhanden, so wird dem Kunden eine Bestellbestätigung ausgegeben und eine Aboänderung per Email zugeschickt. Zusätzlich wird die Abobox in der Datenbank aktualisiert und mit den entsprechenden Artikeln ergänzt.  
Der Kunde wird anschließend zur Startseite zurückgeführt. 

## Registrierungvorgang
Der Nutzer wird auf das Registrierformular weitergeleitet. Dort gibt er folgende Daten an:  
- Vorname
- Name
- Geburtsdatum
- Straße
- Hausnummer
- Postleitzahl
- Emailadresse
- Passwort

Nach Eingabe der Daten wird der Nutzer nochmals aufgefordert diese zu überprüfen. Anschließend kann er mit "Jetzt registrieren" den Vorgang abschließen.  
Die Daten werden nun ans Backend übermittelt. Nun wird geprüft, ob bereits ein Nutzer mit dieser Emailadresse existiert. Ist dieser Fall, so wird eine Fehlermeldung an den Nutzer zurückgesendet. Er wird aufgefordert eine andere Emailadresse zu nutzen oder sich mit dem bereits existierenden Account einzuolggen ("Passwort vergessen?" - Hinweis).  
Ist die E-Mail noch nicht vorhanden, so wird ein neues Userobject mit einer Userid, einer Adressid, einem Registrierungsdatum und einer Zahlungsdatenid (diese ist erstmal leer) erzeugt und in der Datenbank mit dem Status "pending" gespeichert.  

![Userobjekt](http://www.plantuml.com/plantuml/svg/5Sszgi90443X_Zx5jR3DYALLjB0J1B6MpMJChipEBlE3hszI7JZDDvedzQZyjok273E5ydzsxtO2qFGTbk8vfZ1IRE8aFc2hiBmvOJQudH-lkxOFeKDDHU2wRYwOQNyyNCWmAvKfP87EIJO8daOwz8qSIUQrFm00)

Dem Nutzer wird nun eine Verficationemail zugesandt. Er hat nun 30 Tage Zeit um seinen Account über diese zu verifizieren.  
Sollte nach 30 Tagen der Status des Nutzers immer noch auf pending, so wird dieser aus der Datenbank gelöscht.  
Aktiviert der Nutzer seinen Account über den Link, so wird der Status von diesem auf "active" gestellt. 

## Login
Der Nutzer wird aufgefordert seine Emailadresse und sein Passwort einzugeben.  
Diese Daten werden per POST Request (Passwort Userseitig in MD5 gehasht) an den Webshop-Server gesendet und dieser schaut in der Datenbank, ob ein Nutzer mit der Email vorhande ist.  
Ist die Emailadresse nicht vorhanden ist, bekommt der Nutzer eine Fehlermeldung ausgegeben.  
Ist der Nutzer vorhanden, so wird geprütft, ob das Passwort mit dem Passwort aus der Datenbank übereinstimmt.  
Ist dies nicht der Fall, so wird eine Fehlermeldung ausgeben. Ansonsten wird eine Sessionid erzeugt und dem User zugesendet. Der Nutzer ist nun eingeloggt.

## Zahlungsdaten hinzufügen
Der Nutzer wird aufgefordter sich für eine Zahlungsmethode zu entscheiden. 
Je nach Zahlungsmethode werden verschiedne Sachen abgefragt:
- Paypal
    - Emailadresse
    - Passwort
- Kreditkarte:
    - Kartenummer
    - Inhaber
    - Ablaufdatum
    - CSV
- Debitkarte (Lastschrift)
    - Inhaber
    - IBAN
    - BIC

Der Nutzer gibt nun, basierend auf seiner Wahl entsprechende Daten bei dem Dienstleister ein. Bei erfolgreicher Prüfung bekommt der Webshop einen Verficationtoken des Dienstleisters übermittelt. Diesen hinterlegt er nun mit entsprechender Zahlungsart in der Datenbank.  
Der Nutzer kann jetzt noch auswählen, ob dies seine aktive Zahlungsart sein soll.