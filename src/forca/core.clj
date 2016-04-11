(ns forca.core
  (:gen-class))

(def total-chances 6)

(defn you-lost [] (print "Awww...most there! You lost bro! =("))
(defn you-win [] (print "Really? Gratz bro!!!"))

(defn remaining-letters [word right-guesses]
    (remove (fn [chosen-letter] (contains? right-guesses (str chosen-letter))) word)
)
(defn right-word? [word right-guesses]
    (empty? (remaining-letters word right-guesses))
)

(defn contains-letter? [word guess]
    (.contains word guess)
)

(defn guess! [] (read-line))

(defn game [remaining-chances word right-guesses]
  (defn guess-a-letter [remaining-chances, word, guess, right-guesses]
      (if (contains-letter? word guess)
          (game remaining-chances word (conj right-guesses guess))
          (game (dec remaining-chances) word right-guesses)
      )
  )

  (if (= remaining-chances 0)
      (you-lost)
      (if (right-word? word right-guesses)
          (you-win)
          (guess-a-letter remaining-chances word (guess!) right-guesses)
      )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
