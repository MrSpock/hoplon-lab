(ns my-hoplon.api
  (:require [tailrecursion.castra :refer [defrpc]]))



(def r-number (atom 0))

(defrpc get-state []
  (reset! r-number (rand-int 100))
  {:random @r-number}

  )


(defrpc get-username []
  (let [names ["Marcin" "Tomek" "Marta" "Staszek" "Jarek"]]
;;         (loop [r (rand-int 4)]
;;           (if (> r 0)
    ;; {:username (subvec names 0 3)}))
;;             (recur (rand-int 4))))))
     {:username names}
    ))






