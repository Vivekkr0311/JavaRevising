# Locks

- There are two types of lock in java

  1. `Intrinsic`: These are in built with the objects. We
          we cannot see these but they are present, and it used
         when we use 'synchronized' keyword. These are automatic locks
        used by java.
  2. `Extrinsic`: These lock are manually used by the programmer. Programmer
       decides when to lock and unlock the locks. It is used by using a java class
      `java.util.concurrent.Locks`.