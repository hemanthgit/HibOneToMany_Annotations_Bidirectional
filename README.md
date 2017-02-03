# HibOneToMany_Annotations_Bidirectional

When you traverse from the “Many” side to the “One” side in <a href="https://github.com/hemanthgit/HibOneToMany_Annotations_UniDirectional">Unidirectional Mapping</a> , you only need to make reference to one object, which is why the Item class holds a single reference to an Cart class via the private Cart cart instance variable.

However, when you traverse from the “One” to the “Many” side, you will need to hold a reference to MANY objects.
asas
