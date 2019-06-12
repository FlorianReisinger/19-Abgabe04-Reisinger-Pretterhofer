# Lab Report #
## Vertiefende Gesamtwiederholung ##


Student01: Thomas Pretterhofer

Student02: Florian Reisinger


Repository: <a href="https://github.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer">https://github.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer</a>

# Tasklist #

- [x] 1. Übertragen Angabe Taskliste in Markdown Readme

- [x] 2. Einspielen Queue Vorlage aus Repository:  
https://github.com/michaelulm/software-configuration-management/tree/master/test-automation/Queue  
            
- [ ] 3. Taskergebnisse Schritt für Schritt auf Git stellen
  - [ ] Führung Taskliste
  - [ ] Veröffentlichung in Git mit aktuell durchgeführten Tätigkeiten, z.B. Testfälle geschrieben so wird auch in der Taskliste diese Aufgabe als erledigt markiert und Testfälle inkl. geänderter Taskliste ins Repository übertragen.
    
- [x] 4. Korrigieren Sie den Code bzw. Debuggen Sie ihn um die Fehler zu finden
  - [x] Es befinden sich gesamt 3 Fehler im Source Code.
  - [x] Bei Bedarf Optimieren Sie das Queue Beispiel.
  - [x] Ergänzen Sie das Beispiel nach eigenen Ermessen um es testen zu können.
  
- [x] 5. Erstellen Sie für Klasse und alle Methoden Kommentare um mittels Javadoc eine API Dokumentation zu erzeugen
  - [x] Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report.
  
- [x] 6. Erstellung JUnit Tests (vollständig testen, mehrere Varianten)
  - [x] Sie werden die „selben“ Testfälle mehrfach erstellen müssen um „mehrere Variationen“ für einen möglichst vollständigen Test zu erreichen. Achten Sie dabei mit unterschiedlichen Daten zu testen.
  - [x] JavaDoc Kommentare erstellen.
  - [x] Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report.
  
- [x] 7. Passen Sie Ihr pom.xml auf das Projekt an, damit Sie das Projekt erstellen aber auch Dokumentation generieren können.
  - [x] EntwicklerInnen Informationen hinzufügen.
  - [x] Integration Logging Bibliothek log4j mittels Maven Dependencies.
  
- [x] 8. Log4j (Version 2) integrieren und in jeder Methode ins Log schreiben
  - [x] Siehe aktualisiertes Stack Beispiel.
  - [x] Erstellen Sie einen Statischen Logger der auf die Konsole schreibt.
  - [x] Konfigurieren Sie Logger über ein properties File.
  - [x] Geben Sie eine Info Lognachricht bei Aufruf einer jeden Methode aus.
  - [x] Geben Sie eine Error Lognachricht aus bevor Sie einen Fehler werfen.
  - [x] Ergebnisse (Konsolenausgabe) als Bild in Dokumentation einfließen lassen.
  
- [x] 9. Maven Site Dokumentation erstellen
  - [x] Inklusive Javadoc Code und Javadoc Test Klassen
  - [x] Inklusive Menü mit Verweis auf manuell erstellte Seite
    - [x] Seite erläutert Funktionsweise Queue
  - [] Geben Sie ein Bild der Maven Site Dokumentation in den Lab Report
    - [] Der Inhalt der manuell erstellten Seite sollte ersichtlich sein
    
- [ ] 10. Erstellung detaillierter und nachvollziehbarer Markdown Lab Report
  - [ ] Übertragung Information aus Labreport Template.
  - [ ] Alle Schritte dieser Übung nachvollziehbar erläutern.
  - [ ] Übung Github Flavor: Erstellen Sie einen Codeblock im Dokument, welcher 3 Zeilen Python und 3 Zeilen Java Source Code korrekt darstellt.
  - [ ] Korrekturlesen Dokumentation
  - [ ] PDF erstellen (zB Dillinger)
  
- [ ] 11. Überprüfung Vollständigkeit der Abgabe
- [ ] 12. Abgabe PDF Version der Abgabe

---

# Dokumentation #

1.) Die Tasklist wurde in die Datei Readme.md kopiert und entsprechend der Markdown Syntax angepasst. Weiters wurde die Projektvorlage Queue in das Repository kopiert.

2.) Debugging der Klasse "Queue.java"


- Bugs:
    1.1) **Fehler** im Konstruktor: "public StringQueue(int     maxsize){" ist falsch.
    **Richtig:** "public    StringQueue(int maxSize){".
    1.2)**Fehler** im Konstruktor: "maxSize = maxSize" ist falsch.
    **Richtig:** "this.maxSize = maxSize".
    
    Bug:
    ![Construktor Bug](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_bug_01.PNG)
    
    Fix:
    ![Construktor Fix](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_fix_01.PNG)
      
    2.) **Fehler** in remove() Methode: Vor der if-Abfrage wird mit
    'element = "";' die Variable immer initialisiert, daher kann sie nie null werden.
    **Lösung:** Entfernen dieser Zeile, da diese nicht sinnvoll.
    
    Bug:
    ![remove() Bug](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_bug_02.PNG)

  Fix:
  ![remove() Fix](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_fix_02.PNG)

    3.) **Fehler** in poll() Methode: Hier wird ein Element nur entfernt wenn die    "size == 0" ist, dies würde nie ein Element löschen solange die Queue nicht leer ist, wäre diese leer würde ein Element entfernt werden, welches eine Exception werfen würde.
    **Lösung:** Änderung der If-Abfrage auf "size > 0", sodass dies solange möglich ist, bis die Queue, keine Elemente mehr hat.
    
    Bug:
    ![poll() Bug](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_bug_03.PNG)
    
    Fix:
    ![poll() Fix](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/02_fix_03.PNG)
    
- Erweiterungen/Optimierungen:
    - Der vorgegebene Konstruktor wurde um die Abfrage, ob maxSize kleiner gleich null ist erweitert, in diesem Fall wird eine Exception geworfen.
    - Default Constructor wurde manuell hinzugefügt, um den angegebenen Wert(int maxSize = 5) als default Wert zu nutzen und zu testen, da dieser sonst keine Funktion hat.

3.) Es wurden JavaDoc Kommentare zur Klasse und zu den Methoden hinzugefügt.
- Nach dem hinzufügen der JavaDoc-Kommentare, haben wir einen JavaDoc-Bericht generiert:

    Overview:

    ![JavaDoc Overview](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/03_javaDoc_overview.PNG)

    Interface:
    
    !JavaDoc Queue](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/03_javaDoc_Queue.PNG)
    
    StringQueue-Klasse:
    
    ![JavaDoc StringQueue](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/03_javaDoc_StringQueue.PNG)

4.) Als nächstes werden Junit-Testcases in der Testklasse implementiert.
- Test Default Konstruktor: Es wird getestet ob die Standard-Größe von 5 korrekt ist.
- Test Konstruktor: Bei Queue-Größen von kleiner gleich null wird eine Exception geworfen, da die Queue mindestens 1 Element haben muss.
- Alle Methoden werden einmal mit einer Queue-Größe von 1 (minimale Größe) und einer Queue-Größe von 99 (großer Wert) getestet.

    Overview mit JUnit Testklasse:
    
    ![JavaDoc Overview](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/04_JUnit_Overview.PNG)

    JUnit Testklasse Teil 1:
    
    ![JavaDoc StringQueueTest 1](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/04_JUnit_StringQueueTest_1.PNG)

    JUnit Testklasse Teil 2:
    
    ![JavaDoc StringQueueTest 2](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/04_JUnit_StringQueueTest_2.PNG)
    
    
5.) Abänderungen der pom.xml, sodass die Entwicklerinformationen hinzugefügt worden sind, einen automatische Dokumentation mit Hilfe von Maven-Site erstellt werden kann und zusätzlich wurde noch Log4j (Version 2) integriert.

5.1)Entwickler in das Konfigurationsfile hinzufügen:

![developer pom.xml](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/05_pom_01.PNG)
    
 5.2) Log4j (Version 2) integrieren
 
![log4j pom.xml](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/05_pom_02.PNG)

 5.3)Automatisch generierte Dokumentation(Maven Site) mit integration von JavaDoc!
 Report Bereich(Automatische Dokumentation):
 
![automatedDocumentation pom.xml](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/05_pom_03.PNG)
    
5.4) Report Bereich 02(Automatische Dokumentation):

![automatedDocumentation pom.xml](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/05_pom_04.PNG)

5.5)Build Bereich(Automatische Dokumentation)

![automatedDocumentation pom.xml](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/05_pom_05.PNG)

6) Log4J laut Anweisung integriert. 
 Bei jeden Methodenaufrauf wird ein statischer Log auf der Kommandozeile ausgegeben.
 
![Log4J Ausschnitt Konsolenausgabe](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/06_Log4J.PNG)

7) Mave-Site Dokumentation laut Anweisung implementiert. 
 Hierbei wurde manuell eine Seite hinzugefügt, welche eine Queue beschreibt.
 Weiters wurde noch die "About" Seite manuel adaptiert.
 
![Maven-Site Dokumentation](https://raw.githubusercontent.com/FlorianReisinger/19-Abgabe04-Reisinger-Pretterhofer/master//media/07_MavenSite.PNG)