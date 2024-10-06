(ns view.index
  (:require
   [view.components :as c]
   [database.core :as db]
   [database.user :as user]))

(defn page [req]
  {:status 200
   :body
   (c/layout
    req
    [:div.container
     [:div.row.align-items-center
      [:img.col-12.col-lg-4 {:src "/static/img/logo.svg" :height "300px"}]
      [:div.col
       [:div.fs-2.fw-bold "A Simpler Approach to modern Web Development"]
       [:div "Borkweb is an effort to create a full-stack Babashka/Clojure framework that is simple, minimal and traditional. We provide the tooling that allows developers to work efficiently and effectively, without getting bogged down in unnecessary configurations and integrations."]]]
     [:div.mt-5.row
      [:div.mb-5.col-12.col-lg-4
       [:h3 "No Build"]
       [:div "In a world where complexity is often mistaken for sophistication, we're here to shake things up. We're talking about the \"No Build\" movement, where the focus is on simplicity, elegance, and getting the job done without unnecessary overhead."]]
      [:div.mb-5.col-12.col-lg-4
       [:h3 "Clojure all the way"]
       [:div "Why switch between languages when you can do it all in Clojure? JS provided by Squint and CSS through Gaka. No more context switching, no more mental overhead - just pure, flow."]]
      [:div.mb-5.col-12.col-lg-4
       [:h3 "Modern but traditional"]
       [:div "There's a certain charm to the traditional way of doing things in web development - a simplicity and elegance that's hard to replicate with modern tooling and frameworks. Borkweb tries to embrace that feeling. No bundlers, No build steps. Just Code and Enjoy the outcome."]]]
     [:div.mt-5
      [:h3.text-center "Join the web revolution! Enjoy the web like it was intended!"]]
     [:div.mt-5.mb-5.fs-3
      [:div.text-center
       [:a.text-reset.text-decoration-none {:href "https://github.com/m3tti/borkweb"} (c/icon "github") " github.com/m3tti/borkweb"]]]])})
