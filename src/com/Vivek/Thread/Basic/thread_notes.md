# Creating Threads in Java

In Java, threads can be created using two primary approaches:
1. **Implementing the `Runnable` interface**.
2. **Extending the `Thread` class**.

Both methods allow you to define a task that can run concurrently with other parts of your program. Let's explore each method with examples.

---

## 1. Creating Threads Using the `Runnable` Interface

The `Runnable` interface provides a flexible way to define a thread's task without requiring inheritance from the `Thread` class. This is useful when your class needs to extend another class.

### Example Code

````java
package com.Vivek.Thread.Basic.RunnableInterface;

// Implementing the Runnable interface to define a thread task
public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        // Prints the name of the current thread
        System.out.println(Thread.currentThread().getName());
    }
}

package com.Vivek.Thread.Basic.RunnableInterface;

public class MainThread {
    public static void main(String[] args) {
        // Prints the name of the main thread
        System.out.println(Thread.currentThread().getName());

        // Create an instance of ThreadTwo (Runnable)
        ThreadTwo obj = new ThreadTwo();

        // Create a new thread, passing the obj as the Runnable target
        Thread t = new Thread(obj);

        // Start the thread, which invokes the run() method of ThreadTwo
        t.start();
    }
    
}
````


# Creating Threads by Extending the `Thread` Class

In Java, threads can be created by extending the `Thread` class. This method allows you to directly define the behavior of the thread by overriding the `run()` method. The `start()` method begins the execution of the thread, which in turn calls the `run()` method.

## Example Code

````java
package com.Vivek.Thread.Basic.ThreadClass;

public class Basic {
    public static void main(String[] args) {
        // Create an instance of World (which extends Thread)
        World w = new World();
        
        // Start the thread, which calls the run() method in World
        w.start();

        // Print the name of the main thread in a loop
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

package com.Vivek.Thread.Basic.ThreadClass;

public class World extends Thread {
    @Override
    public void run() {
        // Print the name of the current thread in a loop
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
````

