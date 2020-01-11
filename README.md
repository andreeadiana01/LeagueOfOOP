#POO - TEMA2 - PROIECT ETAPA 1 & 2 - CIOCAIANU ANDREEA DIANA - 323CA

Etapa 1:

- Am creat pe langa clasele folosite in citirea inputului, cate o clasa pentru fiecare tip de erou, o clasa care implementeaza modul de joc, o clasa factory pentru eroi si o clasa singleton care construieste harta.

- Clasa principala este Hero care se extinde prin mostenire cu Pyromancer, Knight, Rogue si Wizard.

	Hero -- Pyromancer
	     |
	     -- Knight
	     |
	     -- Wizard
	     |
	     -- Rogue		
	      	

- Toate metodele necesare unui erou sunt implementate in clasa Hero, urmand ca metodele specifice atacului unui player sa fie implementate fiecare in clasa player-ului de care apartin.

- Mecanismul de double dispatch : 
	-se presupune ca un erou ataca un inamic, inamicul fiind in acelasi timp cel asupra caruia se face actiunea
	-astfel, am implementat metode abstracte de atac asupra fiecarei clase copil a lui Hero si metoda prin care le accesez pe celelalte si anume isAttackedBy care actioneaza asupra clasei parinte Hero si care imi permite sa realizez lupta din clasa PlayGame

- Clasa Hero :

	- metoda computeLevelUpXp realizeaza calcului limitei superioare de XP pentru cresterea in nivel
	-metoda setTerrainBoost realizeaza o setare de land modifier pentru fiecare erou in functie de tipul lui, acesta urmand sa fie aplicat pe damage-ul dat de fiecare

	-metoda setUnaltered ma ajuta atunci cand wizard aplica deflect, aceasta calculand doar damage-ul dat de fiecare erou fara race modifiers

- Pentru fiecare clasa copil a lui Hero am iplementat cele 2 parti ale atacului combinandu-le in metoda attack, conform cerintei.

- In clasa Constants se gasesc toate constantele necesare oferite in enunt pentru desfasurarea jocului. 

- Clasa PlayGame urmareste etapele jocului de la citirea inputului, la realizarea luptelor cu setarea bonusului de teren, calcularea XP-ului castigatorului si la scrierea outputului in fisierul de iesire.

Etapa 2 :

- Am adaugat in clasele folosite in citirea inputului si mecanismul de citire pentru liniile adaugate in input de catre etapa 2

- Am adaugat si o clasa separata pentru constantele specifice ingerilor.

- Dupa mecanismul eroilor, am creat ingerii si o clasa tip factory pentru ei care ii instantiaza in functie de nume si de pozitia lor pe harta.

- Clasa principala este Angel care joaca rolul de Visitor pentru clasa Hero

- Clasa Angel se extinde dupa cum urmeaza :

	Angel -- DamageAngel
	      |
	      -- DarkAngel
	      |
	      -- Dracula
	      |
	      -- GoodBoy
	      |
	      -- LevelUpAngel
	      |
	      -- LifeGiver
	      |
	      -- SmallAngel
	      |
	      -- Spawner
	      |
	      -- TheDoomer
	      |
	      -- XPAngel
 	
- Visitor Pattern 
	  In clasele copil ale lui Angel exista cate o metoda visit care realizeaza mecanismul de joc al ingerului respectiv si anume modifica hp-ul, xp-ul sau altereaza modificatorii de damage.
	In clasele copil a lui Hero exista metoda accept care asigura interactiunea dintre ingeri si eroi.

-Strategy Pattern 
	In clasele copil ale lui Hero exisra metoda applyStrategy() pe baza interfetei Strategy prin care fiecare erou isi alege strategia de joc.

-Am schimbat mecanismul din PlayGame astfel incat outpu-ul sa fie printat pe parcursul rundelor.


  _____   _   _ U _____ u    U _____ u_   _   ____    
 |_ " _| |'| |'|\| ___"|/    \| ___"|| \ |"| |  _"\   
   | |  /| |_| |\|  _|"       |  _|"<|  \| |/| | | |  
  /| |\ U|  _  |u| |___       | |___U| |\  |U| |_| |\ 
 u |_|U  |_| |_| |_____|      |_____||_| \_| |____/ u 
 _// \\_ //   \\ <<   >>      <<   >>||   \\,-|||_    
(__) (__(_") ("_(__) (__)    (__) (__(_")  (_(__)_)   
