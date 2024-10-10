(ns view.blog
  (:require
   [clojure.java.io :as io]
   [view.core :as c]
   [view.layout :as l]))

(defn post [req]
  (l/layout
   req
   [:div.container
    [:pre#md.d-none (slurp (io/resource
                         (str "blog/"
                              (get-in req [:params :filename]))))]
    [:div#content]
    (c/cljs-module "markdown")]))

(defn index [req]
  (let [content (map #(when (not (.isDirectory %))
                        (.getName %)) (file-seq (io/file (io/resource "blog/"))))]
    (l/layout
     req
     [:div.container
      [:h1 "Blog"]
      (map #(vec [:div [:a {:href (str "/blog/" %)} %]])
           (filter some? content))])))
