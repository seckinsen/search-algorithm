**Stacks**

![lifo_stack](https://user-images.githubusercontent.com/17251181/39204161-b58c5b0e-47ff-11e8-9668-46b0385e4027.png)

A stack is a container of objects that are inserted and removed according to the `last-in first-out (LIFO)` principle. In the pushdown stacks only two operations are allowed: `push` the item into the stack, and `pop` the item out of the stack. 
A stack is a limited access data structure - elements can be added and removed from the stack only at the top. push adds an item to the top of the stack, pop removes the item from the top. 
A helpful analogy is to think of a stack of books; you can remove only the top book, also you can add a new book on the top.
A stack is a recursive data structure. Here is a structural definition of a Stack:

a stack is either empty or it consistes of a top and the rest which is a stack;

**Queues**

![queue](https://user-images.githubusercontent.com/17251181/39204173-c10a2cf4-47ff-11e8-9cd8-e0dd4887011d.png)

A queue is a container of objects (a linear collection) that are inserted and removed according to the `first-in first-out (FIFO)` principle. 
New additions to a line made to the back of the queue, while removal (or serving) happens in the front. 
In the queue only two operations are allowed `enqueue` and `dequeue`. 
Enqueue means to insert an item into the back of the queue, dequeue means removing the front item. 


The difference between stacks and queues is in removing. 
In a stack we remove the item the most recently added; in a queue, we remove the item the least recently added.
