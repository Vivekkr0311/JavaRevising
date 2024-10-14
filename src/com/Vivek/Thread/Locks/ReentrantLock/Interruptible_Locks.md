# Lock Interruptibly in Java

**Lock Interruptibly** refers to a feature in Java's locking mechanism, specifically in the context of the `Lock` interface and its implementation by `ReentrantLock`. It allows a thread to attempt to acquire a lock while being responsive to interruptions.

## Key Features of Lock Interruptibly

1. **Interruptible Lock Acquisition**:
    - A thread can acquire a lock using the `lockInterruptibly()` method.
    - If the thread is waiting for the lock and is interrupted, it receives an `InterruptedException`.

2. **Behavior**:
    - If interrupted while waiting for the lock, the thread will not acquire the lock and will exit the waiting state, throwing an `InterruptedException`.
    - This allows the thread to handle the interruption gracefully, such as cleaning up resources or retrying the operation.

3. **Use Case**:
    - Useful in scenarios where timeout behaviors or responsiveness to cancellation are needed.
    - For example, in a multi-threaded application, if a user cancels a long-running operation requiring a lock, using `lockInterruptibly()` allows the application to respond quickly to that cancellation.

## Example

Here’s a simple example of using `lockInterruptibly()`:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockExample {
    private final Lock lock = new ReentrantLock();

    public void criticalSection() {
        try {
            // Attempt to acquire the lock interruptibly
            lock.lockInterruptibly();
            try {
                // Critical section code here
                System.out.println("Lock acquired, executing critical section.");
                // Simulate some work
                Thread.sleep(1000);
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while waiting for the lock.");
        }
    }

    public static void main(String[] args) {
        InterruptibleLockExample example = new InterruptibleLockExample();
        Thread thread = new Thread(example::criticalSection);
        
        thread.start();
        
        // Interrupt the thread after a short delay
        try {
            Thread.sleep(200); // Give the thread some time to start
            thread.interrupt(); // Interrupt the thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
