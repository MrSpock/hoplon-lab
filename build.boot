#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.1"

(set-env!
  :project      'my-hoplon
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[
                  ;;[org.danielsz/system "0.1.9"]
                  [tailrecursion/boot.core "2.5.1"]
                  [tailrecursion/boot.task   "2.2.4"]
                  [tailrecursion/hoplon      "5.10.25"]
                  [environ                   "1.0.0"]
                  [org.clojure/tools.nrepl "0.2.10"]
                  [clj-postgresql "0.4.0"]
                  ]

  :out-path     "resources/public"
  :src-paths    #{"src/hl" "src/cljs" "src/clj"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require '[tailrecursion.hoplon.boot :refer :all]
         '[tailrecursion.castra.task :as c])

;; (require
;;  '[my-hoplon.systems :refer [dev-system]]
;;  '[system.boot :refer [system run]])


(deftask development
  "Build my-hoplon for development."
  []

  (comp
;;   (system :sys #'dev-system :hot-reload true :auto-start true)
   (watch) (hoplon {:prerender false}) (c/castra-dev-server 'my-hoplon.api)))

(deftask dev-debug
  "Build my-hoplon for development with source maps."
  []
  (comp (watch) (hoplon {:pretty-print true
                         :prerender false
                         :source-map true}) (c/castra-dev-server 'my-hoplon.api)))

(deftask production
  "Build my-hoplon for production."
  []
  (hoplon {:optimizations :advanced}))
