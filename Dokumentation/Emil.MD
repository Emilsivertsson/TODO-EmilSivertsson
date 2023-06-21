# Ditt namn
Emil Sivertsson

## Projektet

### Beskrivning av projektet
Jag har skrivit en Todo applikation som använder sig av en databas för att lagra användare och deras todos.<br>
Användaren kan skapa nya användare och se deras todos.<br>
Användarna kan skapa todos, markera dem som klara, ta bort dem och uppdatera dem.<br>
Applicationen har tillhörande tester som testar alla funktioner i applikationen, utom några få exceptions, som jag inte lyckades täcka. <br>
Applicationen har även en CI integrering med Github Actions som kör testerna vid varje push till main.<br>


### Vad du har gjort
Jag har skrivit applicationen, tester och CI integreringen. <br>

## Planering

### Lösningsförslag innan uppgiften påbörjas
Min plan är att ha en User klass, som agerar objektdataklass och en Todo klass som gör detsamma.<br>
Jag kommer sen ha en facade som hanterar alla anrop till databasen och skapande av nya objekt.<br>


#### Skisser (exempelvis)

#### Hur du tänker försöka lösa uppgiften.(exempelvis)

#### Pseudokod.(exempelvis)

#### Diagram.(exempelvis)

### Jira/Trello/Github Project och projekthantering enligt Scrum/Kanban

## Arbetet och dess genomförande

### Vad som varit svårt
Att testa databasen var det absolut svåraste. jag fick invänta Marcus Lathund, men även då fick jag använda Chatgpt för att få hjälp.<br>
Jag förstår det mesta av testen, men jag skulle aldrig kunna ha kommit på det själv.<br>

### Beskriv lite olika lösningar du gjort

### Beskriv något som var besvärligt att få till
Jag har haft mycket problem med att få till min CI, själva interationen funkade utan problem, <br>
men Github hittade inte mina tester.

### Beskriv om du fått byta lösning och varför i sådana fall
Jag tänkte från början att jag skulle kunna använda ett interface med CRUD metoderna, som jag kunde implementera i <br>
både User- och Todofacade, men eftersom några av metoderna krävde olika parametrar, så fick jag skriva om det.<br>

## Reflektion & Slutsatser

### Vad gick bra
Fruktansvärt roligt projekt. Jag har lärt mig så mycket om CI, och det är verkligen något jag vill fortsätta lära mig mer om.<br>
Önskar att vi haft 2 veckor istället för 1, så att jag kunde ha gjort en GUI också.<br>

### Vad gick dåligt


### Vad har du lärt dig
Jag har lärt mig så mycket om CI, och en djupare förståelse för Mockito och JUnit.<br>

### Vad hade ni gjort annorlunda om ni gjort om projektet
Om jag haft mer tid, så hade jag valt att jobba mot MongoDB istället för SQLite. jag känner mig säkrare på <br>
sql än no-sql så därför valde jag det eftersom att tiden var knapp.
men jag har privata projekt som jag kommer jobba vidare med i sommar för att lära mig mer om MongoDB.<br>

### Vilka möjligheter ser du med de kunskaper du fått under kursen.


Motivera varför du valt en specifik lösning.
Lämna förslag på förbättringar av din kod.
Lämna exempel på lösningar du valde att **inte** implementera
Lämna förslag på förbättringar av din UI/UX design eller reflektera över den.