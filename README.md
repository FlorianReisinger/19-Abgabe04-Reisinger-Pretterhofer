# Lab Report #
## Vertiefende Gesamtwiederholung ##

Student01: Thomas Pretterhofer
Student02: Florian Reisinger

Repository: <a href="https://github.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer">https://github.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer</a>


# Tasklist #

- [x] Übertragen Angabe Taskliste in Markdown Readme

- [x] Einspielen Queue Vorlage aus Repository:  
https://github.com/michaelulm/software-configuration-management/tree/master/test-automation/Queue  
            
- [ ] Taskergebnisse Schritt für Schritt auf Git stellen
  + Führung Taskliste
  + Veröffentlichung in Git mit aktuell durchgeführten Tätigkeiten, z.B. Testfälle geschrieben so wird auch in der Taskliste diese Aufgabe als erledigt markiert und Testfälle inkl. geänderter Taskliste ins Repository übertragen.
    
- [ ] Korrigieren Sie den Code bzw. Debuggen Sie ihn um die Fehler zu finden
  + Es befinden sich gesamt 3 Fehler im Source Code.
  + Bei Bedarf Optimieren Sie das Queue Beispiel.
  + Ergänzen Sie das Beispiel nach eigenen Ermessen um es testen zu können.
  
- [ ] Erstellen Sie für Klasse und alle Methoden Kommentare um mittels Javadoc eine API Dokumentation zu erzeugen
  + Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report.
  
- [ ] Erstellung JUnit Tests (vollständig testen, mehrere Varianten)
  + Sie werden die „selben“ Testfälle mehrfach erstellen müssen um „mehrere Variationen“ für einen möglichst vollständigen Test zu erreichen. Achten Sie dabei mit unterschiedlichen Daten zu testen.
  + JavaDoc Kommentare erstellen.
  + Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report.
  
- [ ] Passen Sie Ihr pom.xml auf das Projekt an, damit Sie das Projekt erstellen aber auch Dokumentation generieren können.
  + EntwicklerInnen Informationen hinzufügen.
  + Integration Logging Bibliothek log4j mittels Maven Dependencies.
  
- [ ] Log4j (Version 2) integrieren und in jeder Methode ins Log schreiben
  + Siehe aktualisiertes Stack Beispiel.
  + Erstellen Sie einen Statischen Logger der auf die Konsole schreibt.
  + Konfigurieren Sie Logger über ein properties File.
  + Geben Sie eine Info Lognachricht bei Aufruf einer jeden Methode aus.
  + Geben Sie eine Error Lognachricht aus bevor Sie einen Fehler werfen.
  + Ergebnisse (Konsolenausgabe) als Bild in Dokumentation einfließen lassen.
  
- [ ] Maven Site Dokumentation erstellen
  + Inklusive Javadoc Code und Javadoc Test Klassen
  + Inklusive Menü mit Verweis auf manuell erstellte Seite
    + Seite erläutert Funktionsweise Queue
  + Geben Sie ein Bild der Maven Site Dokumentation in den Lab Report
    + Der Inhalt der manuell erstellten Seite sollte ersichtlich sein
    
- [ ] Erstellung detaillierter und nachvollziehbarer Markdown Lab Report
  + Übertragung Information aus Labreport Template.
  + Alle Schritte dieser Übung nachvollziehbar erläutern.
  + Übung Github Flavor: Erstellen Sie einen Codeblock im Dokument, welcher 3 Zeilen Python und 3 Zeilen Java Source Code korrekt darstellt.
  + Korrekturlesen Dokumentation
  + PDF erstellen (zB Dillinger)
  
- [ ] Überprüfung Vollständigkeit der Abgabe
- [ ] Abgabe PDF Version der Abgabe

---

#Dokumentation#
 
1. Fehler im Konstruktor: "public StringQueue(int maxsize){" ist falsch. Richtig: "public StringQueue(int maxSize){".
   Fehler im Konstruktor: "maxSize = maxSize" ist falsch. Richtig: "this.maxSize = maxSize".
	Bug:
	![Construktor Bug](./media/02_bug_01.png)
	Fix:
	![Construktor Fix](./media/02_fix_01.png)

2. Fehler in remove() Methode: Vor der if-Abfrage wird mit 'element = "";' die Variable immer initialisiert, daher kann sie nie null werden.
	Bug:
	![remove() Bug](./media/02_bug_02.png)
	Fix:
	![remove() Fix](./media/02_fix_02.png)
3. Fehler in poll() Methode: Hier wird ein elment nur entfernt wenn die "size == 0" ist, dies wurde auf "size > 0" geändert.
	Bug:
	![poll() Bug](./media/02_bug_03.png)
	Fix:
	![poll() Fix](./media/02_fix_03.png)

Anm: "private List<String> elements = new ArrayList<String>();" wurde vereinfacht durch "private List<String> elements = new ArrayList<>();"