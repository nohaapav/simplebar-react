# cljsjs/simplebar-react

SimpleBar does only one thing: replace the browser's default scrollbar with a custom CSS-styled one without losing performances

https://grsmto.github.io/simplebar/

## Packages

* simplebar [5.2.1]
* simplebar-react [2.2.1]

## Setup

To use cljsjs package from local project repo do following:

1. In `project.clj` setup local repository
```
:repositories {"local" "file:repo"}
```

2. Build package
```
boot package install target
```

3. Deploy `.jar` archive to local project repo e.g.
```
mvn deploy:deploy-file -Dfile=simplebar-react-2.2.1-0.jar -DartifactId=simplebar-react -Dversion=2.2.1-0 -DgroupId=cljsjs -Dpackaging=jar -Durl=file:repo
```

4. Finally add dependency to your maven repository
```
lein deps
```

## Usage

[](dependency)
```clojure
[cljsjs/simplebar-react "2.2.1-0"]
```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the ClojureScript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require ["simplebar-react"]))
```

[flibs]: https://clojurescript.org/reference/packaging-foreign-deps