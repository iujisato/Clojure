(ns forca.core
  (:gen-class))

(def total-chances 6)
(defn you-lost [] (print "Awww...most there! You lost bro! =("))
(defn game [remaining-chances]
  (if (= remaining-chances 0)
    (you-lost)
    (game(dec remaining-chances 1))
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
