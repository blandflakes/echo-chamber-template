(ns leiningen.new.echo-chamber
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files sanitize-ns]]
            [leiningen.core.main :as main]))

(def render (renderer "echo-chamber"))

(defn echo-chamber
  "Applies templating to generate a new echo-chamber project."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :namespace (sanitize-ns name)}]
    (main/info "Generating fresh 'lein new' echo-chamber project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/app.clj" (render "app.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/{{sanitized}}/ring.clj" (render "ring.clj" data)]
             ["README.md" (render "README.md" data)]
             ["test/{{sanitized}}/app_test.clj" (render "test.clj" data)])))
