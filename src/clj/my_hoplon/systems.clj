;; (ns my-hoplon.systems
;;   (:require
;;    [com.stuartsierra.component :as component]

;;    (system.components
;;     [postgres :refer [new-postgres-database]])

;;    [environ.core :refer [env]]))



;; (def devel-pg-config {:classname   "org.postgresql.Driver" ; must be in classpath
;;    :subprotocol "postgresql"
;;    :subname ""
;;    :user     (env :pg-username)
;;    :password (env :pg-password)
;;    :host (env :pg-hostname)})

;; (defn dev-system []
;;   (component/system-map
;;   "Development setup"
;;   :sql (new-postgres-database devel-pg-config)
;;   ))


