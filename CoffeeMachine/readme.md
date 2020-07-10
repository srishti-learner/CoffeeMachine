Overview:

This is a coffee machine project which serves 4 specific beverages as of now.

Basic flow:
All the requests land on the "RequestProcessor" class. This acts like the head of our coffee machine.
It takes few decisions about the product and delegates the task to the "BeverageFactory" which extends "BaseBeverageFactory".
If we think of the Coffee machine as a factory, a factory will manage whole manufacturing process of beverages. Precisely, the job of the package "factory".
We can visualize "factory" package as a factory of similar products and its manufacturing units(BeverageFactory). This factory interacts with the "InventoryManager" which takes care of the inventory and requests for ingredients. When all goes well, the drink is served, otherwise some error is sent back to the factory which either serves or informs the customer about the shortage.
The "RequestProcessor" being the head is also responsible for replenishing the inventory.

Assumptions:
- Same beverage can be served on all the outlets at one time.
- Recipe of a beverage doesn't change.
- Ingredients can be added in any order. (If not so, the design needs to be updated with Ingredient class and its derived objects or LinkedHashMap).
- Inventory is initialized with below default values: 
	  "hot_water": 500,
      "hot_milk": 500,
      "ginger_syrup": 100,
      "sugar_syrup": 100,
      "tea_leaves_syrup": 100
