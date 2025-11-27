Project: games (FIAP Java examples)

What I added
- New domain entities: `Genre` and `Developer` (in `br.com.fiap.model`).
- `Game` now references `Genre` and `Developer` with `@ManyToOne`.
- `GameDao` gained `buscarTodos()` to list games.
- `Main` was updated to persist a sample Genre + Developer + Game and to list all games.

How to build and run
1. Install Maven on Windows (add `mvn` to PATH) or open the project in an IDE (IntelliJ/VS Code with Maven support).
2. From `c:\dev\java\games` run:

```powershell
mvn -DskipTests package
```

3. Run the `Main` class (IDE run configuration or using `java -cp target/classes;"%USER_M2%\.m2\repository\..." br.com.fiap.Main` — simpler via IDE).

Notes / troubleshooting
- The project uses Jakarta Persistence (Hibernate). Building requires Maven to download dependencies.
- In this environment `mvn` wasn't available, and compiling with `javac` failed because the Jakarta/hibernate classes weren't on the classpath.
- `src/main/resources/META-INF/persistence.xml` currently contains plain DB credentials. Don't commit real credentials to source control; consider using environment variables or an external configuration for production.

If you'd like, I can:
- Add a small JUnit test for the model objects.
- Create a Maven wrapper so contributors can build without installing Maven.
- Replace raw DB credentials in `persistence.xml` with property placeholders and a README showing how to supply them.
