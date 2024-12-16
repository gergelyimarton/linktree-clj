(defproject linktree "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [metosin/reitit "0.5.18"] 
                 [ring/ring-core "1.9.6"] 
                 [ring/ring-jetty-adapter "1.9.6"] 
                 [hiccup "2.0.0-RC4"]]
  :main linktree.core  ;; itt állítsd be a fő namespace-t
  :plugins [[lein-ring "0.12.5"]] 
  :ring {:handler linktree.core/app} 
  :uberjar-name "linktree-standalone.jar")

