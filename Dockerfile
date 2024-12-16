# # Alapértelmezett kép
# FROM clojure:tools-deps-bullseye-slim AS build

# # Munkakönyvtár beállítása
# WORKDIR /app

# # Leiningen telepítése
# RUN apt-get update && apt-get install -y curl && \
#     curl -o /usr/local/bin/lein https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && \
#     chmod +x /usr/local/bin/lein && \
#     lein

# # Projekt másolása a konténerbe
# COPY . .

# # Függőségek letöltése
# RUN lein deps

# # Alkalmazás lefordítása JAR fájllá
# RUN lein uberjar

# Futtatáshoz használt alap kép
FROM clojure:tools-deps-bullseye-slim

# Munkakönyvtár beállítása
WORKDIR /app

# Lefordított JAR fájl másolása a futtató környezetbe
COPY /target/uberjar/linktree-final-0.1.0-SNAPSHOT-standalone.jar app.jar

# Alkalmazás futtatása
CMD ["java", "-jar", "app.jar"]
