#set MAVEN_OPTS=-Xmx512m -XX:PermSize=128m -XX:MaxPermSize=256m
mvn clean package -Prun-embedded -DskipTests
