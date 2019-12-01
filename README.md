# LeagueOfOOP
etapa 1 proiect POO
#POO - TEMA2 - PROIECT ETAPA 1 - CIOCAIANU ANDREEA DIANA - 323CA

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

  _____   _   _ U _____ u    U _____ u_   _   ____    
 |_ " _| |'| |'|\| ___"|/    \| ___"|| \ |"| |  _"\   
   | |  /| |_| |\|  _|"       |  _|"<|  \| |/| | | |  
  /| |\ U|  _  |u| |___       | |___U| |\  |U| |_| |\ 
 u |_|U  |_| |_| |_____|      |_____||_| \_| |____/ u 
 _// \\_ //   \\ <<   >>      <<   >>||   \\,-|||_    
(__) (__(_") ("_(__) (__)    (__) (__(_")  (_(__)_)   
