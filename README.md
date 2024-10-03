# Role-Playing Game (RPG) Lite - 2022

My first individual Java project done at ISEP. The RPG lite project's goal was to create a computer game where the main character or characters had to defeat all their ennemies. 
:warning: The game is not finished developing, some features do not yet exist, the main goal was to understand how classes, attributes and methods work.

## How it works
At the start of a game, you choose the number of heroes. This determines the number of enemies to be per turn. Next, we choose the class of our heroes: they can be Hunter, Warrior, Mage or Healer. Each hero has a weapon and armor, as well as potions and food. A game is made up of several battles, until you face the boss in the fifth battle if you survive. During a battle, you control each of your heroes in turn; you can decide whether to attack, defend or even use a consumable, such as lembas lembas1 or other food to restore your life, or drink a potion to restore the mana restore the mana of spellcasters. The order in which heroes and enemies attack is determined at the start of each battle. Each class has different attacks. The Hunter shoots arrows (until he runs out of them), the Warrior strikes in close combat, the Healer heals with spells, while the Mage uses magic against enemies.
If the team wins a fight, each character can choose between several options:
- increase the damage we cause;
- increase our resistance to attacks;
- increase potion and food effectiveness;
- increase the number of potions or food;
- increase the number of arrows (for Hunters); decrease mana cost for Wizards, or the effectiveness of their spells.
At the end of a fight (if you haven't yet reached the boss), you start a new one. Heroes who have perished in previous battles do not come back to life.
