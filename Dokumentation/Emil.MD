# Ditt namn
Emil Sivertsson

## Projektet

### Beskrivning av projektet
Jag har skrivit en Todo applikation som använder sig av en databas för att lagra användare och deras todos.<br>
Användaren kan skapa nya användare och se deras todos.<br>
Användarna kan skapa todos, markera dem som klara, ta bort dem och uppdatera dem.<br>
Applikationen har tillhörande tester som testar alla funktioner i applikationen, utom några få exceptions, som jag inte lyckades täcka. <br>
Applikationen har även en CI integrering med Github Actions som kör testerna vid varje push till main.<br>


### Vad du har gjort
Jag har skrivit applikationen, tester och CI integreringen. <br>

## Planering

### Lösningsförslag innan uppgiften påbörjas
Min plan är att ha följande:<br>
- User klass, som agerar objektdataklass. <br>
- Todo klass som gör detsamma. <br>
- facade för både User och Todo som hanterar alla anrop till databasen och skapande av nya objekt.<br>
- SQLite klass som hanterar all kommunikation med databasen.<br>
- Input klass som hanterar all input från användaren.<br>
- Output klass som hanterar all output till användaren.<br>
- Application klass som hanterar applikationen.<br>

Det här är det jag gjorde till planeringen.<br>

#### Första Flowcharten
![Basic flow](Planing%2FbasicFlow.jpg)

#### Andra Flowcharten
![basicFlowchart](Planing%2Ffirstflow.jpg)

#### UML
![UML](Planing%2Fuml.jpg)

#### Board
![Board](Planing%2Fboard.jpg)


## Arbetet och dess genomförande

### Vad som varit svårt
Att testa databasen var det absolut svåraste. Jag fick invänta Marcus Lathund, men även då fick jag använda Chatgpt för att få hjälp.<br>
Jag förstår det mesta av testen, men jag skulle aldrig kunna ha kommit på det själv.<br>
Det dök upp mycket problem med CI integrationen, men jag fick hjälp av Marcus att lösa det.<br>

### Beskriv lite olika lösningar du gjort
- En övergripande lösningen är att jag kollar om det finns Users eller Todos, innan användaren kan göra något med dem.<br>
Detsamma gäller om användaren vill interagera med en specifik Todo eller User, så kollar jag om den finns.<br>
- Jag har valt att Stänga och öppna databasen mellan varje anrop, för att undvika att databasen blir låst.<br>
- Om användaren tar bort en User så ska applikationen ta bort alla Todos som tillhör den användaren.<br>

### Beskriv något som var besvärligt att få till
Jag har haft mycket problem med att få till min CI, själva interaktion funkade utan problem, <br>
men Github hittade inte mina tester. Så jag var tvungen att ta hjälp av marcus som hittade en lösning, vilket var <br>
man var tvungen att lägga till en "dont skip tests" i yml filen.<br>

### Beskriv om du fått byta lösning och varför i sådana fall
Jag tänkte från början att jag skulle kunna använda ett interface med CRUD metoderna, som jag kunde implementera i <br>
både User- och Todofacade, men eftersom några av metoderna krävde olika parametrar, så fick jag skriva om det.<br>

## Reflektion & Slutsatser

### Vad gick bra
Fruktansvärt roligt projekt. Jag har lärt mig om CI, och det är verkligen något jag vill fortsätta lära mig mer om.<br>
Önskar att vi haft 2 veckor istället för 1, så att jag kunde ha gjort en GUI också.<br>

### Vad gick dåligt
Inget gick direkt dåligt, Det blev bara mycket frustration när jag inte kunde få till min CI och databas-tester.<br>
Jag är så klart en Completionist som gärna vill testa alla möjliga utfall.<br>
Vilket gör att jag blir väldigt frustrated när jag inte kan få till det.<br>

### Vad har du lärt dig
Jag har lärt mig så mycket om CI, och en djupare förståelse för Mockito och JUnit.<br>
Jag har även lärt mig att jag måste bli bättre på att fråga om hjälp, istället för att sitta och försöka lösa problemet själv.<br>
En annan viktig lärdom är att jag saknar att jobba med andra och få andras input och tankar.<br>

### Vad hade ni gjort annorlunda om ni gjort om projektet
Om jag haft mer tid, så hade jag valt att jobba mot MongoDB istället för SQLite. <br>
jag känner mig säkrare på sql än no-sql så därför valde jag det eftersom att tiden var knapp. <br>
Men jag har privata projekt som jag kommer jobba vidare med i sommar för att lära mig mer om MongoDB.<br>

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Själva projektet har egentligen varit en repetition med chans att fördjupa sig, vilket varit roligt, <br>
Det som verkligen är nytt är CI med github, vilket jag ser fram emot att djupa mer i.<br>
Jag tror att det kommer driva våra grupprojekt ett steg längre.<br>
om vi kan ha en CI som kör tester vid varje push, så ställer det högre krav på oss att planera bättre <br>
och Stick to the plan.

## Extra

### Motivera varför du valt en specifik lösning.
Jag stötte på problem att min databas blev låst, så jag var tvungen att öppna och stänga den mellan varje anrop.<br>
Även när jag gjorde detta så fick jag problem med att den ibland låste sig. Det visade sig att jag öppnade den <br>
via funktioner som jag inte tänkt på i början, så jag fick refactorear och flytta all instansering av sqlite till User- och Todofacade.<br>
Man skulle kunna säga att det var här jag insåg värdet i en Singelton design pattern.<br>

### Lämna förslag på förbättringar av din kod.
- Min kontroll av om det finns Users eller Todos, borde legat redan i första menyn, och om det inte fanns <br>
några att visa så skulle en alternativ meny visas, där användaren bara kan skapa en ny User eller Todo.<br>
- Jag borde haft en PressTOContinue funktion som jag kunde ha använt i alla utskrifter.<br>
- Om programet skulle växa och bli större, så skulle jag vilja att man använda något annat än det unika ide´t att söka på, <br>
till exempel namn eller email. om man då klickade sig fram genom en GUI och inte behövre skriva in id, så skulle det vara <br>
smidigare. man skulle då slippa att siffrorna med tiden kommer bli väldigt höga.<br>

### Lämna exempel på lösningar du valde att **inte** implementera
- Jag övervägde att använda Objekt mer i applikationen. Till ex, att när en Todo ska visas så hämtas informationen och <br>
läggs till i en Todo-objekt, som sedan skickas tillbaka och skrivs ut för användaren. <br>
och så vidare i alla andra funktioner och samma för Users.
Varför jag inte gjorde det var för att jag inte ville göra det för komplicerat, <br>
och för att det skulle blivit onödigt mycket kod för att skapa objekt och skicka dem fram och tillbaka.<br>
- Jag hade en ursprunglig tanke om att skapa ett CRUD interface som skulle kunna implementeras av både user och Todo klasserna, <br>
Detta visade sig vara svårt då vissa metoder krävde olika parametrar, men när jag fick ett tips av Kristoffer Larsson.<br>
om att använda ett Generiskt interface. Jag undersökte det, men jag blev inte helt på det klara på hur jag skulle göra.<br>
men med lite mer tid så hade det nog gått att lösa.<br>

### Lämna förslag på förbättringar av din UI/UX design eller reflektera över den.
Jag glömde helt bort att tänka på användarvänligheten, så här finns mycket att göra om. <br>
Det snyggaste enligt mig hade varit att öppnat med en meny där man frågar vilket användaren man använder <br>
eller om man vill skapa en ny. Därefter skrivit ut alla Todos som tillhör den användaren, <br>
och frågan om man vill skapa en ny, kolla närmare på, ändra eller ta bort en Todo.<br>
Detta hade varit en mycket bättre lösning, då man fått till en bättre överblick, med mindre klickande genom menyer.<br>

