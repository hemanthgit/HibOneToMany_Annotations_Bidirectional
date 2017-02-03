# HibOneToMany_Annotations_Bidirectional

When you traverse from the “Many” side to the “One” side in <a href="https://github.com/hemanthgit/HibOneToMany_Annotations_UniDirectional">Unidirectional Mapping</a> , you only need to make reference to one object, which is why the Item class holds a single reference to an Cart class via the private Cart cart instance variable.

However, when you traverse from the “One” to the “Many” side, you will need to hold a reference to MANY objects.

<b><u>Using the <i>mappedBy</i> Property on Bidirectional One-to-Many Relationship:</u></b>
1.We don’t actually need to use the mappedBy property, but your database will be quite a mess if we don’t.
2.The <i>mappedBy</i> property is what we use to tell Hibernate which variable we are using to represent the <b>parent class in our child class</b>.
3.If you were to look at the class definition for the child class (Item) you will see that we have declared an instance variable called itemCart, which is what we used to establish our relationship. All we are doing here is we are telling the Cart class which variable the Item class is using to create the relationship.
4.So! Since we declared the Cart variable with the name itemCart, this is what we need to put in the mappedBy property of the @OneToMany annotation.

What you need to know is that since we have a bidirectional relationship, this means we need to assign objects to EACH side of the relationship. This means that we need to populate both the item.setItemCart() as well as the cart.setItems(). <b>It’s absolutely critical that this be done correctly.</b>

To persist all the objects correctly we’ll need to follow these generic steps

    Instantiate/Load parent object
    Instantiate/Load child objects
    Set the parent object in the child objects
    Create a collection of child objects
    Set the collection of child objects on the parent
    Save the parent




