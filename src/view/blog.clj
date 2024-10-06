(ns view.blog
  (:require
   [clojure.java.io :as io]
   [view.components :as c]))

(defn post [req]
  (c/layout
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
    (c/layout
     req
     [:div.container
      [:h1 "Blog"]
      (map #(vec [:div [:a {:href (str "/blog/" %)} %]])
           (filter some? content))])))
