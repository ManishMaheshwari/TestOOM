# TestOOM

Test to validate that only Thread gets killed, but process could survival OutOfMemory scenario.

Run with -Xms64M -Xmx64M

Observations:

- When OOM arises in a Thread, the thread gets killed, but other threads continue to survive under stressed memory conditions.
- Initially, the executor runs fast. When memory pressure builds, the execution loops slow down and drag under GC/CPU pressure. 
- The Thread.setDefaultUncaughtExceptionHandler() is executed in context of dying thread. This means that the uncaughtExceptionHandler may or may not be executed, depending on memory conditions.

