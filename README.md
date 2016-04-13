# Hangman Clojure
First steps on functional programming with Clojure, developing a simple hangman game.

<details>
<summary>Its pretty easy to guess the secret word, but if you dont want to have some fun click here</summary>
The secret word for the clojure's hangman is `clojure`
</details>


## Requirements
* [Leiningen 2.6.1] (http://leiningen.org/#install)
* Clojure 1.8.0
* Java 1.7.0_95

## Usage

##### Running with Leiningen
1. `Git clone` the project
2. Inside your project folder, run `lein run`

##### Running JAR file
1. [Download hangman-0.1.0.jar] (https://drive.google.com/open?id=0B4Fl0pD2BYWcd0wtcE0wZjJoTXc)
2. Execute it with `JVM`:
```
java -jar (Downloaded file path)/hangman-0.1.0.jar
```

## FAQ
##### Got a problem installing Leiningen?
```
cd `mktemp -d`
wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod +x lein
sudo mv lein /usr/local/bin/
lein help
cd -
```

### Bugs
* Does not let you input the whole word.
* Currently the input is case-sensitive, so "A" and "a" are not the same.
* Does not have a list of different keywords
  * List of options to be RNG.
  * User input before the start(Only works with 2 players)

