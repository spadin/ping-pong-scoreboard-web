(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html" :charset "iso-8859-1"}]
  [:title "scoreboard-web"]
  (include-css "/stylesheets/scoreboard_web.css")
  (include-js "/javascript/scoreboard_web.js")]
 [:body
  (eval (:template-body joodo.views/*view-context*))
]]