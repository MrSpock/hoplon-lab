(ns my-hoplon.rpc
  (:require-macros
    [tailrecursion.javelin :refer [defc defc=]])
  (:require
   [tailrecursion.javelin]
   [tailrecursion.castra :refer [mkremote]]))


;;(set! cljs.core/*print-fn* #(.log js/console %))

(defc state {:random nil :username nil})
(defc error nil)
(defc loading [])


;; (defc= loaded?      (not= {} state))
;; (defc= loading?     (seq loading))
;; (defc= logged-in?   (not (or (nil? state) (= {} state))))
;; (defc= show-chat?   (and loaded? logged-in?))
;; (defc= show-login?  (and loaded? (not logged-in?)))



(defc= random-number (:random state))
(defc= username (:username state))



;; private
;;(defn do-login!  [user]         (swap! *session* assoc :user user))



(def get-random
  (mkremote 'my-hoplon.api/get-state state error loading))

(def get-username
  (mkremote 'my-hoplon.api/get-username state error loading))


(defn init []
  (get-random)
  ;;(get-username)
  ;;(js/setInterval get-state 500)
  )

