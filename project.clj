(defproject gh-utils "0.3.9"
  :description "Create new Github repository from the comfort of your command line; TL;DR; $gh-utils --config ~/Dropbox/config/github.edn --repo my-awesome-idea"
  :url "https://github.com/agilecreativity/gh-utils"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[lein-binplus "0.6.5"]]}
             :uberjar {:aot :all}}
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :bin {:name "gh-utils"
        :bin-path "~/bin"
        :bootclasspath false}
  :plugins [[lein-binplus "0.6.5"]
            [lein-eftest "0.5.1"]
            [lein-cljfmt "0.5.7"]
            [lein-kibit "0.1.6"]
            [jonase/eastwood "0.2.5"]
            [lein-auto "0.1.3"]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.cli "0.4.1"]
                 [irresponsible/tentacles "0.6.3"]
                 [akvo/fs "20180904-152732.6dad3934"]
                 [clj-jgit "0.8.10"]
                 [aero "1.1.3"]]
  :repositories [["jitpack" "https://jitpack.io"]]
  :deploy-repositories [["clojars"  {:sign-releases false :url "https://clojars.org/repo"}]
                        ["snapshots" {:sign-releases false :url "https://clojars.org/repo"}]]
  :main com.agilecreativity.gh_utils.core)
