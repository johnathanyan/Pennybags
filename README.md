Pennybags
=========

Johnathan Yan
Joey Zeng
Hyunwoo Jeung

(- denotes private, + denotes public, () denotes method, * denotes subclass)
Player
=========
- String name
- String shape
- int[] propertyOwned
- int money
- int turnsInJail
- int pos
(+) void buy(int pos)
(+) boolean isBankrupt()
(+) void payRent()


Tile ABSTRACT [Action/Property/FreeParking]
**************************
- String name
- int pos

*FreeParking
=============


*Property
=========
- bool bought
- Player owner
- int[] addons
- int cost
- int rent

*Action [Chance/Community Chest/Jail/LuxuryTax]
=========
inherits variables from Tile Super Class



