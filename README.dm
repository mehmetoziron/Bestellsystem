# Datenbank einrichten

Dieses Projekt verwendet MySQL als Datenbank.

Standard-Zugangsdaten

Benutzername: root

Passwort: 1234

Schritte

** Öffne dein MySQL-Tool (z. B. MySQL Workbench, phpMyAdmin oder die Konsole).**

Erstelle eine neue Datenbank:

CREATE DATABASE customermanage;


**Wähle die Datenbank aus:**

USE customermanage;


**Führe anschließend die Datei schema.sql aus, die sich im Projekt befindet:**

- **In MySQL Workbench:**
- File → Open SQL Script → schema.sql → Execute

- **Oder per Konsole:**

- mysql -u root -p customermanage < schema.sql


(Passwort: 1234)

- Nach dem erfolgreichen Ausführen von schema.sql sind alle benötigten Tabellen erstellt und das Projekt ist einsatzbereit.

---

## Screenshots & Funktionen

### 🔐 Login
[![Login](screenshots/bild_1.png)](screenshots/bild_1.png)

Benutzeranmeldung mit E-Mail und Passwort.

---

### 📝 Registrierung
<img src="screenshots/bild_2.png">
<img src="screenshots/bild_3.png">

Neue Benutzer können sich über das Registrierungsformular im System anlegen.

---

### 👤 Kundenverwaltung
<img src="screenshots/bild_4.png">
<img src="screenshots/bild_5.png">
<img src="screenshots/bild_6.png">
<img src="screenshots/bild_7.png">

- Kundenliste anzeigen
- Filtern nach Kundentyp und Name
- Kunden hinzufügen, bearbeiten und löschen

---

### 📦 Produktverwaltung
<img src="screenshots/bild_8.png">
<img src="screenshots/bild_9.png">
<img src="screenshots/bild_10.png">
<img src="screenshots/bild_11.png">

- Produktliste anzeigen
- Filtern nach Code und Lagerbestand
- Produkte hinzufügen, bearbeiten und löschen
- Produkte in den Warenkorb legen

---

### 🛒 Warenkorb & Bestellung
<img src="screenshots/bild_12.png">

- Warenkorbübersicht
- Bestellung erstellen
- Kunde auswählen
- Anzeige von Gesamtpreis und Produktanzahl
- Automatische Prüfung des Lagerbestands
  (bei Unstimmigkeiten werden Warnungen angezeigt und Werte angepasst)

---

### 📑 Bestellungen
<img src="screenshots/bild_13.png">

Übersicht aller erstellten Bestellungen.

---

### 🔄 Automatische Lageraktualisierung
<img src="screenshots/bild_14.png">

Nach einer erfolgreichen Bestellung werden die Lagerbestände der Produkte automatisch aktualisiert.
