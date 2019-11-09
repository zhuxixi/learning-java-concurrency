#!/usr/bin/env bash
cd /home/proj/learning-java-concurrency/target
java -Xmx1m -classpath  learning-java-concurrency-1.0.0.jar org.zhuzhenxi.learning.concurrency.thread.uncaughtexceptionhandler.UncaughtExceptionHandlerExample
cd /home/proj/learning-java-concurrency
pwd

cd /home/proj/learning-java-concurrency/target
java -Xmx10m -classpath  learning-java-concurrency-1.0.0.jar org.zhuzhenxi.learning.concurrency.thread.stacksize.ThreadCountExample 1000 1000 1000
cd /home/proj/learning-java-concurrency
pwd
