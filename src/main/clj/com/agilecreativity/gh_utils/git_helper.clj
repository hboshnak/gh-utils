(ns com.agilecreativity.gh_utils.git_helper
  (:require [clj-jgit.porcelain :as cjp :refer :all]
            [clojure.java.shell :as shell]
            [me.raynes.fs :as fs]))

(defn git-init-commit
  "Run initial git commit on a given directory."
  [base-dir]
  (let [git-repo (cjp/git-init base-dir)]
    (cjp/git-add git-repo ".")
    (cjp/git-commit git-repo "Initial commit")
    (cjp/git-status git-repo)))

(defn git-add-remote
  "Run `git remote add origin git@github.com:username/project.git' on the current project.
  e.g. git remote add <origin|upstream> git@github.com:<username>/<project-name>.git"
  ([username project-name base-dir]
   (git-add-remote username project-name base-dir "origin"))
  ([username project-name base-dir remote-label]
   (let [{:keys [exit out err]}
         (shell/sh "git" "remote" "add"
                   remote-label ;; "upstream" or "origin"
                   (str "git@github.com:" username "/" project-name ".git")
                   :dir base-dir)])))

(defn git-push-remote
  "Run git push send changes to remote repository.
  e.g. git push --set-upstream <origin|upstream> <master|branch-name>"
  ([]
   (git-push-remote "." "origin" "master"))
  ([base-dir]
   (git-push-remote base-dir "origin" "master"))
  ([base-dir remote-label]
   (git-push-remote base-dir remote-label "master"))
  ([base-dir remote-label branch-name]
   (fs/file base-dir)
   ;; e.g. git push --set-upstream <origin|upstream> branch-name
   (let [{:keys [exit out err]}
         (shell/sh "git" "push" "--set-upstream"
                   remote-label
                   branch-name
                   :dir base-dir)])))
