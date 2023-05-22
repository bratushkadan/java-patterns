#!/bin/zsh

set -a 

cd src

javac main/java/com/pracs/P$1/*.java

java "main/java/com/pracs/P$1/Main.java"
