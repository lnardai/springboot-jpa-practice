decrypt:
	@ gpg -d ./src/main/java/com/nardai/practice/load/LoadMindExercises.kt.gpg > src/main/java/com/nardai/practice/load/LoadMindExercises.kt
	@ gpg -d ./src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt.gpg > src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt
	@ gpg -d src/main/resources/secrets.properties.gpg > src/main/resources/secrets.properties


encrypt:
	@ gpg --yes --encrypt -u "vikinek" -r "vikinek" src/main/java/com/nardai/practice/load/LoadMindExercises.kt
	@ gpg --yes --encrypt -u "vikinek" -r "vikinek" src/main/java/com/nardai/practice/load/LoadSpaceExercises.kt
	@ gpg --yes --encrypt -u "vikinek" -r "vikinek" src/main/resources/secrets.properties
