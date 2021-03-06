(ns forca.core
  (:gen-class))

(def total-chances 6)
(def key-word "clojure")

(defn you-lost [] (println "Awww...most there! You lost bro! =("))
(defn you-win [] (println "Really? Gratz bro!!!"))

(defn remaining-letters [word right-guesses]
    (remove (fn [chosen-letter] (contains? right-guesses (str chosen-letter))) word))

(defn right-word? [word right-guesses]
    (empty? (remaining-letters word right-guesses)))

(defn contains-letter? [word guess]
    (.contains word guess))

(defn feedback-interface [remaining-chances word right-guesses]
    (println "Remaining chances:" remaining-chances)
    (doseq [character (seq word)]
    (if (contains? right-guesses (str character))
        (print character " ")
        (print "_" " ")))
    (println))

(defn game [remaining-chances word right-guesses]
  (feedback-interface remaining-chances word right-guesses)
  (cond
    (= remaining-chances 0) (you-lost)
    (right-word? word right-guesses) (you-win)
    :else
    (let [guess (read-line)]
        (if (contains-letter? word guess)
            (do
                (println "Whaaaat?! In da hole man!")
                (recur remaining-chances word (conj right-guesses guess)))
            (do
                (println "You failed miserably rofl")
                (recur (dec remaining-chances) word right-guesses))))))

(defn start-game [] (game total-chances key-word #{}))

(defn -main [& args]
    (println "Welcome to Clojure's hangman!")
    (println "Please DO NOT use capslock on guesses")
    (start-game))
