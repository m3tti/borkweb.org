# Introducing htmc: A Pure CLJS Clone of htmz

In our ongoing quest to simplify workflows and minimize dependencies for Borkweb, we're excited to introduce a new tool that's about to revolutionize the way you build server-side rendered "SPA"-like pages. Say hello to htmc, a ClojureScript clone of the incredibly lightweight htmz library.

# What is htmz?

Htmz is a tiny JavaScript library that leverages browser technologies to provide 80% of the functionality of htmx, but with a fraction of the code. We're talking a whopping 166 bytes of code! The idea behind htmz is simple yet powerful: it enables you to render content when a user clicks on a specific part of the page, all while staying close to browser standards.

# How does htmc work?

We took the htmz code and adapted it to work seamlessly with Borkweb. Our implementation is split into two parts: the ClojureScript code, which can be found in `resources/cljs/htmc.cljs`, and a Clojure function that resides in `src/utils/htmc.clj`.

The JavaScript code is where the magic happens:
```clojure
(defn htmc []
  (let [frame (js/document.querySelector "#htmc")]
    ;; Your extension here
    (js/setTimeout
     #(let [el# (.querySelector js/document (or frame.contentWindow.location.hash nil))]
        (el#.replaceWith.apply el# frame.contentDocument.body.childNodes)))))

(->
 (js/document.getElementById "htmc")
 (.addEventListener "load" htmc))
```
As you can see, the comment `Your extension here` is an invitation to extend the entire handling of htmc. This is where you can get creative and add your own custom functionality.

The Clojure function, on the other hand, is responsible for rendering the cljs code into a script tag ESM module and attaching a hidden iframe:
```clojure
(defn htmc
  "Has to be a function due to the hotreload of the htmc.cljs code. If you want to extend it."
  []
  [:div 
   (c/cljs-module "htmc")
   [:iframe {:id "htmc" :hidden true :name "htmc"}]])
```
# Using htmc

To get started with htmc, simply use the following code:
```clojure
(defn some-page [req]
  [:div#replaceMe]
  [:a {:href "/some/route/with/new/html/content#replaceMe" :target "htmc"} "click me"])
```
This will replace the entire `[:div#replaceMe]` with new content from the given route.

# What's next?

Now it's your turn to unleash the power of htmc! Join the web revolution and start building amazing things with this awesome new feature. As always, we invite you to enjoy the web like it was intended – simple, fast, and fun.

## Links
- [htmz: How it works?](https://kalabasa.github.io/htmz/#how)
