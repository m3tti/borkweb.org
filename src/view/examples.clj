(ns view.examples
  (:require
   [hiccup2.core :as h]
   [view.core :as c]
   [view.layout :as l]))

(defn forth [req]
  (str
   (h/html
    [:div#back
     [:div "I'm forth"]
     [:a.btn.btn-primary {:href "/examples/back#back" :target "htmc"} "Back"]])))

(defn back [req]
  (str
   (h/html
    [:div#forth
     [:div "I'm back"]
     [:a.btn.btn-primary {:href "/examples/forth#forth" :target "htmc"} "Forth"]])))

(defn index [req]
  (l/layout
   req
   [:div.container.mb-5
    [:div.row
     [:div.col-12.col-lg-6
      [:div.fs-1 "Pinball"]
      [:a {:href "https://squint-cljs.github.io/squint/?src=https://gist.githubusercontent.com/borkdude/ca3af924dc2526f00361f28dcf5d0bfb/raw/09cd9e17bf0d6fa3655d0e7cbf2c878e19cb894f/pinball.cljs"} "Original"]
      [:canvas#myCanvas {:style "max-width: 400px" :width "400px"}]
      [:div.d-grid
       [:button#button-restart.btn.btn-primary.mb-5.mt-2]]
      (c/cljs-module "pinball")]
     [:div.col-12.col-lg-6
      [:div
       [:div.fs-1 "Preact"]
       [:div#cljs]
       (c/cljs-module "counter")]
      [:div
       [:div.fs-1 "htmc"]
       [:div#forth
        [:div "I'm back"]
        [:a.btn.btn-primary {:href "/examples/forth#forth" :target "htmc"} "Forth"]]]]]]))
