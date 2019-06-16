decrypt:
	@ gpg --no-tty -d ./src/main/java/com/nardai/practice/load/LoadMindExercises.kt.gpg > src/main/java/com/nardai/practice/load/LoadMindExercises.kt
	@ gpg --no-tty -d ./src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt.gpg > src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt

encrypt:
	@ gpg --no-tty --encrypt -u "vikinek" -r "vikinek" src/main/java/com/nardai/practice/load/LoadMindExercises.kt
	@ gpg --no-tty --encrypt -u "vikinek" -r "vikinek" src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt