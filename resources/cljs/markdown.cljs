(require '["https://cdn.jsdelivr.net/npm/showdown@2.1.0/+esm$default" :as showdown])

(let [el (js/document.getElementById "content")
      md (js/document.getElementById "md")
      converter (new showdown/Converter)]
  (set! (.-innerHTML el) (.makeHtml converter (.-innerText md))))
