# Locks
1. tryLock(): It tries to make a lock at the time it is invoked, if lock  is not free then it can say like currently lock is unavailable please don't wait. There is one variation of this which take two parameters, first one is  number which represent  the time, and other one is unit in which time will be  calculated. This variations wait for the duration given in the parameter.

`example`: tryLock() and tryLock(1000, TimeUnit.MILISECONDS);

2. lock():  This method is same as using synchronized keyword.