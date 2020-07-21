(set-env!
 :resource-paths #{"resources"}
 :dependencies '[[cljsjs/boot-cljsjs "0.10.5" :scope "test"]
                 [cljsjs/react "16.8.6-0"]
                 [cljsjs/react-dom "16.8.6-0"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom {:project     'cljsjs/simplebar-react
      :version     +version+
      :description "SimpleBar does only one thing: replace the browser's default scrollbar with a custom CSS-styled one without losing performances"
      :url         "https://grsmto.github.io/simplebar/"
      :scm         {:url "https://github.com/nohaapav/simplebar-react"}
      :license     {"MIT" "http://opensource.org/licenses/MIT"}})

(deftask package []
  (comp
   (run-commands :commands [["npm" "install" "--include-dev"]
                            ["npm" "run" "build:dev"]
                            ["npm" "run" "build:prod"]
                            ["rm" "-rf" "./node_modules"]])
   (sift :move {#".*simplebar-react.inc.js"     "cljsjs/simplebar-react/development/simplebar-react.inc.js"
                #".*simplebar-react.min.inc.js" "cljsjs/simplebar-react/production/simplebar-react.min.inc.js"})
   (sift :include #{#"^cljsjs"})
   (deps-cljs :foreign-libs [{:file           #"simplebar-react.inc.js"
                              :file-min       #"simplebar-react.min.inc.js"
                              :provides       ["simplebar"
                                               "simplebar-react"]
                              :global-exports '{"simplebar"                        SimpleBar
                                                "simplebar-react"                  SimpleBarReact}
                              :requires       ["react" "react-dom"]}]
              :externs [#"simplebar-react.js"])
   (pom)
   (jar)
   (validate-checksums)))