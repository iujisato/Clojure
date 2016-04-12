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

(defn game [remaining-chances word right-guesses]
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
            (println "Good one! You failed miserably rofl")
            (recur (dec remaining-chances) word right-guesses))))) )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
