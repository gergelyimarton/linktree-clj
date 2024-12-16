(ns linktree.core
  (:require
   [hiccup.core :refer [html5]]
   [reitit.ring :as ring]
   [ring.adapter.jetty :refer [run-jetty]]))

;; Adatok a linkekhez
(def links
  [{:url "https://google.com" :text "Google"}
   {:url "https://github.com" :text "GitHub"}
   {:url "https://clojure.org" :text "Clojure"}])

;; HTML oldal generálása
(defn linktree-page []
  [:html5
   [:head
    [:title "Linktree"]
    [:style "body { font-family: Arial, sans-serif; text-align: center; }
              a { display: block; margin: 10px 0; color: blue; text-decoration: none; }"]]
   [:body
    [:h1 "Welcome to My Linktree!"]
    [:p "Click a link below to visit:"]
    [:ul
     (for [{:keys [url text]} links]
       [:li [:a {:href url} text]])]]])

;; Reitit útvonal
(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get (fn [_]
                  {:status 200
                   :headers {"Content-Type" "text/html"}
                   :body (html5 (linktree-page))})}]])))



;; Szerver indítása
(defn -main [& args]
  (println "Server is running on http://localhost:3000")
  (run-jetty app {:port 3000 :join? false}))

