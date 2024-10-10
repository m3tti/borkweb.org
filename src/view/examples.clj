(ns view.examples
  (:require
   [view.core :as c]
   [view.layout :as l]))

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
      [:div.fs-1 "Preact"]
      [:div#cljs]
      (c/cljs-module "counter")]]]))
