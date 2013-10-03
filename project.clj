(def VERSION (.trim (slurp "VERSION")))
(def MODULES (-> "MODULES" slurp (.split "\n")))

(eval `(defproject com.pearson.gambit/storm ~VERSION
  :url "http://storm-project.net"
  :description "Distributed and fault-tolerant realtime computation"
  :license {:name "Eclipse Public License - Version 1.0" :url "https://github.com/nathanmarz/storm/blob/master/LICENSE.html"}
  :mailing-list {:name "Storm user mailing list"
                 :archive "https://groups.google.com/group/storm-user"
                 :post "storm-user@googlegroups.com"}
  :dependencies [[storm/storm-console-logging "0.9.0-wip21"]
                 [com.pearson.gambit/storm-core ~VERSION]
                 [com.pearson.gambit/storm-netty ~VERSION]]
  :plugins [[~'lein-sub "0.2.1"]]  
  :min-lein-version "2.0.0"
  :sub [~@MODULES]
  ))
