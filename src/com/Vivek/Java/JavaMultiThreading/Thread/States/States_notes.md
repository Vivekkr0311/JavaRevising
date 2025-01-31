# Thread Life Cycle in Java

The life cycle of a thread in Java represents the different states a thread transitions through during its execution. These states include:

1. **New**
2. **Runnable**
3. **Running**
4. **Blocked/Waiting**
5. **Terminated**

---

## 1. **New**
- **Description:** A thread is in this state when it is created but not yet started.
- **Example:**
    ```java
    Thread t = new Thread();
    ```

## 2. **Runnable**
- **Description:** After the `start()` method is called, the thread enters the `Runnable` state. It is ready to run and is waiting for CPU time.
- **Example:**
    ```java
    t.start();  // Moves to Runnable state
    ```

## 3. **Running**
- **Description:** The thread is in this state when it is executing its `run()` method.
- **Example:**
    ```java
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
    ```

## 4. **Blocked/Waiting**
- **Description:** A thread is in this state when it is waiting for a resource (e.g., I/O or a lock) or for another thread to perform an action.
- **Example:**
    ```java
    synchronized(lock) {
        lock.wait();  // Thread enters waiting state
    }
    ```

## 5. **Terminated**
- **Description:** A thread is in this state when it has finished executing. This happens when the `run()` method exits or the thread is interrupted.
- **Example:**
    ```java
    System.out.println("Thread has terminated");
    ```
