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
## Bestellung über den Webshop
Die Bestellung über den Webshop läuft im Regelfall folgendermaßen ab:  
Ein Kunde betritt den Webshop und informiert sich über die Produkte.  
Nach einiger Suche wählt der Kunde ein Produkt <span style="color:#ff3300">P</span> mit der Produktid <span style=color:pink>ID</span> aus. Er kommt nun auf die Produktseite.  
Nachfolgend fragt der Browser beim Webshop die <span style=color:pink>ID</span> and und erhält das Objekt <span style="color:#ff3300">P</span> zurück.  

![Produktabruf](/Fachliche_Beschreibung/plantuml/Images/AbrufProdukt/AbrufProdukt.svg)

Dieses Objekt beinhaltet folgende Daten:  
- Produktbeschreibung <span style="color:#b3b3ff">PB</span>
- Transparenzinformationen <span style="color:#8080ff">TI</span>
- Tipps zur Verwendung <span style ="color:#e6e6ff">VT</span>
- einen Preis <span style="color:#3333ff">G</span>
- eine sessionale Verfügbarkeit <span style="color:#e600e6">V</span>
- einen vorgeschlagenen Lieferintervall <span style="color:#4d9900">I</span>

![Produkt](/Fachliche_Beschreibung/plantuml/Images/Produkt/Produkt.svg)

Hat der Kunde während des Bestellprozesses Fragen zum Produkt oder zum Ablauf, so kann er jederzeit über die Infohotline den Kundenservice konaktieren.  

Ist der Kunde mit dem Produkt <span style="color:#ff3300">P</span> zufrieden, und möchte dieses bestellen, so wählt er eine Menge und einen Lieferintervall und kann dieses nun seiner Abobox hinzufügen.  

![Abobox](/Fachliche_Beschreibung/plantuml/Images/Abobox/Abobox.svg)

Ist der Kunde bereits registriert, aber noch nicht angemeldet, wird er nun zum Login aufgefordert.  
Ist der Kunde nicht nicht registriert, so kann er dies nun nachholen (siehe Prozess [`Registriervorgang`](#registrierungsvorgang)).  
Ist der Kunde erfolgreich eingeloggt, wird das Produkt <span style="color:#ff3300">P</span> der Abobox mit der Menge <span style="color:#00cccc">M</span> und dem gewünschten Lieferintervall <span style="color:#4d9900">I</span> hinzugefügt.  
Der Kunde kann nun weitere Produkte auswählen und diese zu seiner Abobox hinzufügen.    

![Produkt zu Abobox hinzufügen](/Fachliche_Beschreibung/plantuml/Images/ProduktzurAboboxhinzufuegen/ProduktzurAboboxhinzufügen.svg)       

Hat der Kunde seine Auswahl beendet, muss er anschließend seine neue Auswahl bestätigten. Dazu werden ihm alle Artikel in seiner Abobox angezeigt (inklusive Preis, Lieferintervall und Menge), wobei hier die neuen Artikel hervorgehoben werden. Zusätzlich sieht der Kunde auf einen Blick, welche **zusätzlichen Kosten** auf ihn zukommen.  
Der Kunde wird nun aufgefordter, seine Änderung zu prüfen und zu bestätigten.  

Hat der Kunde seine Änderungen bestätigt, so wird geprüft, ob in der Abobox im kleinstmöglichen Lieferintervall mindestens 5 Produkte vorhanden sind. Ist dies nicht der Fall, so wird der Kunde darüber informiert und aufgefordert weitere Produkte zu seiner Abobox hinzuzufügen.  
Sind 5 oder mehr Produkte vorhanden, wird geprüft, ob der Kunde bereits eine aktive Zahlungsmethode hinterlegt hat. Ist dies nicht der Fall, dann startet der Prozess [Zahlungsdaten hinzufügen](#zahlungsdaten-hinzufügen). Sobald Zahlungsdaten vorhanden sind, wird dem Kunden eine Bestellbestätigung ausgegeben und eine Aboänderung per Email zugeschickt. Zusätzlich wird die Abobox in der Datenbank aktualisiert und mit den entsprechenden Artikeln ergänzt.  
Der Kunde wird anschließend zur Startseite zurückgeführt. 

## Registrierungsvorgang
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

![Userobjekt](/Fachliche_Beschreibung/plantuml/Images/User/User.svg)

Dem Nutzer wird nun eine Verficationemail zugesandt. Er hat nun 30 Tage Zeit um seinen Account über diese zu verifizieren.  
Sollte nach 30 Tagen der Status des Nutzers immer noch auf pending, so wird dieser aus der Datenbank gelöscht.  
Aktiviert der Nutzer seinen Account über den Link, so wird der Status von diesem auf "active" gestellt. 

## Login
Der Nutzer wird aufgefordert seine Emailadresse und sein Passwort einzugeben.  
Diese Daten werden per POST Request (Passwort Userseitig in MD5 gehasht) an den Webshop-Server gesendet und dieser schaut in der Datenbank, ob ein Nutzer mit der Email vorhande ist.  
Ist die Emailadresse nicht vorhanden ist, bekommt der Nutzer eine Fehlermeldung ausgegeben.  
Ist der Nutzer vorhanden, so wird geprütft, ob das Passwort mit dem Passwort aus der Datenbank übereinstimmt.  
Ist dies nicht der Fall, so wird eine Fehlermeldung ausgeben. Ansonsten wird eine Sessionid erzeugt und dem User zugesendet. Der Nutzer ist nun eingeloggt.

## Zahlungsarten verwalten
Der Nutzer hat die Möglichkeit seine bereits eingepflegten Zahlungsdaten zu verwalten und zu bearbeiten. Dabei kann er aus verschiedenen Aktionen wählen:  

- Zahlungsart hinzufügen
- Zahlungsart löschen
- Zahlungsart bearbeiten
- Zahlungsart als aktiv kennzeichnen

![User Zahlungsdaten](/Fachliche_Beschreibung/plantuml/Images/UserZahlungsdaten/UserZahlungsdaten.svg)

### Zahlungsdaten hinzufügen
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

![Zahlungsarten](/Fachliche_Beschreibung/plantuml/Images/Zahlungsart/Zahlungsarten.svg)

Der Nutzer gibt nun, basierend auf seiner Wahl entsprechende Daten bei dem Dienstleister ein. Bei erfolgreicher Prüfung bekommt der Webshop einen Verficationtoken des Dienstleisters übermittelt. Diesen hinterlegt er nun mit entsprechender Zahlungsart in der Datenbank.  
Der Nutzer kann jetzt noch auswählen, ob dies seine aktive Zahlungsart sein soll.

![Workflow Zahlungsarten hinzufügen](/Fachliche_Beschreibung/plantuml/Images/WorkflowZahlungsdatenhinzufuegen/zahlungsdaten_hinzufuegen.svg)

### Zahlungsart löschen
Wählt der Nutzer den Button *Zahlungsart löschen* aus, so wird er nochmals gefragt, ob er die Zahlungsart tatsächlich löschen möchte. Wenn der Nutzer dies bestätigt, wird geprüft, ob wenigstens eine weitere Zahlungsart im Kundenkonto hinterlegt ist. Ist dies nicht der Fall und der Kunde hat eine aktive Abobox, so wird dem Benutzer ein Error ausgegeben, mit dem Hinweis, dass mindestens eine aktive Zahlungsart im Konto hinterlegt sein muss.  
Ansonsten werden die Zahlungsdaten aus dem Kundenkonto gelöscht.

![Workflow Zahlungsdaten löschen](/Fachliche_Beschreibung/plantuml/Images/WorkflowZahlungsdatenloeschen/zahlungsdaten_hinzufuegen.svg)

### Zahlungsart bearbeiten
Der Kunde bekommt die hinterlegten Zahlungsdaten angezeigt. Er hat nun die Möglichkeit, diese abzuändern und z.B. die Iban anzupassen. Nach erfolgter Änderung der Zahlungsdaten durchlaufen die einen erneuten Prüfungsprozess und bei erfolgreicher Verifikation wird die Zahlungsart mit dem entsprechend neu generierten Token in der Datenbank aktualisiert.  
Schlägt die Prüfung fehlt, so wird der Kunde auf die fehlgeschlagene Prüfung aufmerksam gemacht und der Vorgang wird abgebrochen.

![Workflow Zahlungsdaten bearbeiten](/Fachliche_Beschreibung/plantuml/Images/WorkflowZahlungsdatenbearbeiten/zahlungsdaten_loeschen.svg)

### Zahlungsart als aktiv kennzeichnen
Der Nutzer hat die Möglichkeit, eine Zahlungsart auszuwählen und diese als aktive Zahlungsart auszuwählen. Aktiv bedeutet, dass ab jetzt von dieser Zahlungsart abgebucht werden wird.  
Wählt der Nutzer eine Zahlungsart als aktiv, so wird in der Datenbank ein entsprechender Eintrag hinterlegt, die Zahlungsart, welche bereits als aktiv gekennzeichnet ist, wird als inaktiv gekennzeichnet.

![Workflow Zahlungsdaten als aktiv kennzeichnen](/Fachliche_Beschreibung/plantuml/Images/WorkflowZahlungsdatenaktiv/aktiv.svg)


## Wertschöpfungskette
Produkte, welche auf dem Webshop gelistet sind, können von den Kunden in Form von Aboboxen erworben werden. Diese Produkte werden dann beim Lieferanten bestellten.  

### 1. Listen von Produkten
Die Zulieferer, welche bereits mit dem Unternehmen zusammenarbeiten, können ihre Produkte direkt einpflegen. Dazu öffnen sie ihr Webpanel und geben ihre Zugangsdaten ein. Nun können sie mit einem Klick auf den Button "Neues Produkt hinzufügen" das Formular aufrufen, welches sie ausfüllen müssen, damit dieses Produkt gelistet werden kann.  
In dem Formular müssen sie folgende Daten angeben:  
- Name des Produktes
- Zusammensetzung (Inhaltsstoffe)
- Preis
- Lieferintervall
- Sessionale Verfügbarkeiten
- Lieferbare Menge
- Transparenzdaten (Feld, Bauer etc.)
- Ein oder mehrere Fotos des Produktes
- Verwendung des Produktes

Nachdem der Lieferant diese Daten eingepflegt hat, werden diese an den Webshop übermittelt. Dieser erstellt nun ein neues Angebot, welches die genannten Daten beinhaltet und speichert dieses in der Datenbank mit dem Status "Neu". Zusätzlich wird die Einkaufsabteilung über das Eintreffen eines neuen Angebots informiert.  
Diese prüft nun das vorliegende Angebot und bestellt bei Intresse (Preis nicht zu hoch, passt ins Produktportfolio) ein Produktmuster beim Lieferanten. Der Status wird nun auf "Muster angefordert" gestellt. Ist nach 4 Wochen kein Muster eingetroffen wird der Status auf "Kein Muster" gestellt.  
Nachdem das Muster eingetroffen wird, wird es an die Qualitätsprüfung weitergeleitet. Der Status ist nun "Prüfung".  
Die Qualitätsprüfung prüft nun:  
- die wesentlichen Eigenschaften des Produktes
- die Einsatzmöglichkeiten des Produktes
- die Transparenzdaten auf nachvollziehbarkeit

Die Prüfungsergebnisse werden in der Datenbank gespeichert.  
Kommt die Qualitätsabteilung zu dem Schluss, dass das Produkt nicht den Anforderungen entspricht, wird dem Liefernanten eine Absage erteilt, mit Feedback, was dieser an dem Produkt verbessern kann. Der Status des Angebots wird auf "Prüfung nicht bestanden" gestellt.  
Ist das Produkt zur Zufriedenheit der Qualitätsprüfung, so wird eine Probe davon an das Labor verschickt. Der Status des Produktes ist nun "Laborprüfung".  
Das Labor prüft das Produkt nun auf Unbedenklichkeit für den angegeben Verwendungzweck und prüft die angegeben Inhaltsstoffe erneut. Danach sendet dieses die Analys an die Qualitätsprüfung zurück. Die Anayse wird nun in der Datenbank hinterlegt.   
Ist die Laboranalyse negativ ausgefallen, so wird dem Lieferanten der Mangel mitgeteilt, und der Status des Produktes auf "Laboranalyse nicht bestanden" gestellt.  
Ist die Laboranalyse ohne Probleme erfolgt, so wird der Status des Angebots auf "angenommen" gestellt und die Einkaufsabteilung informiert.  
Diese erstellt nun aus den vorliegenden Daten einen neuen Produkteintrag in der Datenbank und schaltet dieses Produkt frei.  
Das Produkt bekommt nun den Status "aktiv" und ist ab jetzt im Webshop zu sehen.  

Ist kein Lieferant eingepflegt oder möchte die Einkaufsabteilung das Portfolio erweitern, geht diese selbstständig auf die Suche nach Lieferanten. Das Schema bleibt dabei das gleiche, bis darauf, dass der Lieferant vorab bei Interesse als neuer Lieferant angelegt werden muss.

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Produkt_Listen.png)

### 1.1. Lieferant anlegen
Um einen neuen Lieferanten im Webshop anzulegen, muss dieser einen Fragebogen ausfüllen. Darin vermerkt er folgende Daten:
- Name
- Anschrift
- Telefonnummer
- Email
- Ansprechpartner

Diese Daten werden nun in der Datenbank hinterlegt. Danach bekommt der Lieferant eine Email mit Zugangsdaten zum Webpanel, in welchem er seine Angebote einpflegen kann.

### 2. [`Bestellung durch Kunde`](#bestellung-über-den-Webshop)
Diese kann immer und jederzeit erfolgen, siehe entsprechender Prozess

### 3. Bestellung bei Lieferanten
Immer zum 10. jeden Monats wird der Bedarf an Produkten ermittelt. Dazu wird jede Abobox überprüft und die darin enthaltenen Produkte mit entsprechender Menge addiert. Dies geschieht vollautomatisch und wird vom System übernommen.  
Nachdem eine entsprechende BANF vom System generiert wurde, welche die zu bestellenden Mengen und den damit verbunden Einkaufspreis (welcher aus der Produktdatenbank ermittelt wurde) beinhaltet, muss ein Mitarbeiter des Einkaufes diese gegenprüfen.  
Stell er Mängel fest, so korrigiert er diese per Hand, ansonsten bestätigt er die Korrektheit der BANF.  
Nun werden aus der BANF Anfragen an die einzelnen Händler generiert. Dies geschieht, indem dem jeweiligen Produkt der entsprechende Händler zugeorndet wird und eine neue Lieferanfrage in der Datenbank angelegt wird. Dieser beinhaltet die bestellte Menge, sowie den Einkaufspreis.  
Der Lieferant bekommt diese Anfrage nun im Webpanel angezeigt. Zusätzlich wird er per Email benachrichtigt. Er muss diese Anfrage nun im Webpanel bestätigten oder ablehnen. Nimmt der Lieferant die Anfrage nicht innerhalb von 2 Tagen an, so wird diese automatisch abgelehnt und den Kunden mit entsprechenden Artikeln wird mitgeteilt, dass diese leider in diesem Intervall nicht lieferbar sind.  
Haben alle Lieferanten ihre Anfragen bestätigt, spätestens jedoch zum 15. wird der Zahlungsprozess beim Kunden eingeleitet. Eine Stornierung der Aboboxen ist zu diesem Zeitpunkt nicht mehr möglich. Gleichzeitig werden die generierten Anfragen bei den Händlern bestätigt und ein Lieferauftrag generiert, welcher an die Spedition geschickt wird.  

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Bestellung_Lieferant.png)

### 4. Lieferung abwickeln
Damit die Produkte nach Deutschland ins Lager gelangen können, ist es notwendig diese zu transportieren. Da auch die Zollabwicklung durchgeführt werden muss, hat sich die **Name folgt** dazu entschlossen, eine Importfirma zubeauftragen. Diese kümmert sich nicht nur darum, dass die Produkte beim Händler abgeholt werden, sondern führt auch die Zollabfertigung durch. Nachdem alle Händler ihre Anfragen bestätigt haben bzw. diese abgelehnt wurden, wird der Importfirma eine Liste mit allen Produkten, deren Menge, sowie der Anschrift der entsprechenden Lieferanten übermittelt. Diese Liste wird automatisch aus den Anfragen erzeugt.  
Der Importeur bearbeitet diese Liste nun und gibt Rückmeldung, wann welches Produkt abgeholt wird. Diese Daten werden nun in die entsprechenden Lieferantenaufträge eingepflegt, sodass der Lieferant nachvollziehen kann, wann der Spediteur eintrifft.  

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Lieferung_abwickeln.png)

### 5. Lagern der Waren
Nachdem der Importeur die Produkte erfolgreich nach Deutschland gebracht hat, werden diese im Zentrallager angenommen. Dabei bekommt jede Lieferung des Importeurs den Status "Qualitätprüfung". Dies bedeutet, dass diese Lieferung erst auf vollständigkeit, Qualität und unbedenklichkeit untersucht werden muss, bevor diese weiterverarbeitet werden kann.  
Die Prüfung nimmt das Qualitätsmanagement vor. Des weiteren, wird von jedem Produkt ein Muster an das Labor geschickt.  
Wenn das Labor Rückmeldung gibt, dass das Produkt einwandfrei ist und auch die Qualitätsprüfung keine Beanstandung hat, wird das entsprechende Produkt freigegeben und bekommt den Status "zur freien Verwendung". Sollten Mängel auftreten, wird es mit dem Status "Sperrbestand" versehen und an die Einkaufsabteilung eskaliert. Diese muss sich nun mit Importeur und Lieferant auseinandersetzen, um die Mängel zu besprechen.  

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Lagerung.png)

### 6. Box packen
Am 25. jeden Monats werden die sogenannten Picker damit beauftragt, die Aboboxen zu packen. Dafür bekommen diese jeweils eine Box zugeteilt. Nun sucht der Picker im Lager die entsprechenden Waren mit entsprechender Menge zusammen und bestätigt jede Ware in seiner Pickerapp.  
Abschließend verpackt der Picker die Waren in der Abobox und bestätigt, dass diese vollständig gepackt ist. Nun wird ein Versandlabel ausgedruckt, welches der Picker auf die Box klebt. Nachdem dies geschehen ist, ruft der Picker den nächsten Auftrag ab.

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Box_packen.png)

### 7. Versand der Boxen
Sind alle Boxen gepackt, jedoch spätestens zum 28. jeden Monats, werden diese zur Post gebracht und versand. Der Kunde erhält nun eine Versandbenachrichtung mit entsprechendem Link.

### 8. Zahlung
Sind alle Anfragen der Lieferanten bearbeitet, wird für jeden Kunden eine Rechnung generiert. Dabei werden momentan Rabatte, nicht verfügbare Produkte etc. berücksichtigt, sodass die ermittelte Rechnungssumme den Produkten entspricht, welche der Kunde in seiner Abobox finden wird. Der Kunde erhält nun eine Email mit der Rechnung und dem Hinweis, dass diese innerhalb der nächsten Tage von seinem Konto abgegbucht werden wird.  
3 Tage nachdem die Email an den Kunden versendet wurde, werden die Zahlungen bei der Bank angewiesen.  
Kann die Abbuchung nicht durchgeführt werden, da z.B. der Kunde nicht genügend Geld auf dem Konto hat, wird eine Mahnung an den Kunden generiert (Mahngebühren = 2.50 €) und an diesen versendet und der Prozess beginnt von vorne.  
Wurden bereits drei Mahnungen an den Kunden versendet, so wird die Rechtsabteilung eingeschaltet, welche sich dann um den weiteren Prozess kümmert.

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Kundenzahlung.png)

### 9. Zahlung der Lieferanten
Sind die Waren eingetroffen und haben den Status "freier Bestand" erhalten, so wird die Buchhaltung angewiesen, die entsprechende Rechnung des Lieferanten, welche er im Webpanel hochgeladen hat zu prüfen.  
Bei fehlern auf der Rechnung wird der Lieferant kontaktiert und aufgefordert, seine Rechnung zu korrigieren.  
Ist die Rechnung korrekt, weißt die Buchhaltung die Zahlung dieser an und gibt den Auftrag den Status "abgeschlossen".

![Listen Lieferant](/Fachliche_Beschreibung/bpmn/Zahlung_Lieferant.png)

## Kundenserviceprozesse
Während des Betriebs des Webshops kann es zu vielen verschiedenen Fällen kommen, in welchem der Kunde Rückfragen hat und mit dem Kundenservice in Kontakt treten will. Nachfolgend ist ein Prozess genauer beschrieben:

### Reklamation eines Produktes
Hat der Kunde eine Beanstandung an einem Produkt, z.B. weil dieses während des Transports kaputt gegangen ist oder nicht die versprochenen Kriterien erfüllt, so kann er über den Webshop den Kundenservice kontaktieren. Dazu wählt der Kunde in seiner Bestellhistorie die entsprechende Abobox aus, um welche es geht und wählt darin das zu reklamierende Produkt.  
Nachfolgend füllt er das Reklamationsformular aus:  
- Grund für die Reklamation (Dropdown)
- Kurze Beschreibung
- Dateianhänge wie Fotos etc.

Abschließend schickt der Kunde das Formular an den Kundenservice.  
Der Webshop generiert nun aus diesem Formular automatisch ein neues Ticket für den Kundenservice.  
Ein Mitarbeiter des Kundenservice nimmt dieses Ticket nun auf und startet die Bearbeitung. Zuerst prüft er, ob die Beschreibung ein Reklamationsgrund darstellt. Danach wird geprüft, ob die Fotos etc. den Sachverhalt ordentlich dokumentieren.  
Kommt der Kundenservicemitarbeiter zu dem Schluss, dass hier kein Grund für eine Reklamation vorliegt, so kontaktiert er den Kunden teilt ihm dies begründet über das Ticket mit. Abschließend markiert er das Ticket als geschlossen.  
Ist eine Reklamation nachvollziehbar, so erstellt der Mitarbeiter einen neuen Erstattungsauftrag und sendet diesen an die Buchhaltung. Zusätzlich informiert er den Kunden über die bevorstehende Erstattung. Außerdem hinterlegt in der Lieferantendatenbank einen Vermerk bezüglich der Erstattung. Abschließend markiert er das Ticket als erledigt.  
Die Buchhaltung bearbeitet den Erstattungsantrag und überweist dem Kunden das Geld zurück. 

![Kundenreklamation](/Fachliche_Beschreibung/bpmn/Kundenreklamation.png)

## Projektplan

![Projektplan](/Fachliche_Beschreibung/plantuml/Images/Projektplan/Projektplan.svg)
