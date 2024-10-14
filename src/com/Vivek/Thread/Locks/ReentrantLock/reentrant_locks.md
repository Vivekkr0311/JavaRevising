# Understanding Lock Counting in ReentrantLock

In **ReentrantLock**, the lock maintains a count of how many times it has been acquired (locked) and released (unlocked) by the same thread. This is called the **hold count**. Here's how it works:

## Lock Counting (Hold Count)

### 1. Locking (`lock()`)
- When a thread calls `lock()`, the lock’s count is incremented by 1.
- If the **same thread** calls `lock()` again (re-enters the lock), the count is incremented again.
- This is why it’s called **ReentrantLock**—the same thread can acquire the lock multiple times without causing a deadlock. Each call to `lock()` increases the count.

### 2. Unlocking (`unlock()`)
- When the thread calls `unlock()`, the lock’s count is decremented by 1.
- The lock will only be fully released when the count reaches **0**.
- If the thread has called `lock()` multiple times, it must call `unlock()` the same number of times to fully release the lock.

## Example

Let's say a thread acquires the lock:

```java
lock.lock();   // Count = 1
lock.lock();   // Count = 2
