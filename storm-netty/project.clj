(def ROOT-DIR (subs *file* 0 (- (count *file*) (count "project.clj"))))
(def VERSION (-> ROOT-DIR (str "/../VERSION") slurp (.trim)))

(eval `(defproject com.pearson.gambit/storm-netty ~VERSION
  :dependencies [[com.pearson.gambit/storm-core ~VERSION]
                 [io.netty/netty "3.6.3.Final"]]
  :java-source-paths ["src/jvm"]
  :test-paths ["test/clj"]
  :profiles {:release {}}
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
  :target-path "target"
  :aot :all
  :repositories [["pearson-nexus-releases", "https://nexus.pearsoncmg.com/nexus/content/repositories/releases"],
                 ["pearson-nexus-snapshots", "https://nexus.pearsoncmg.com/nexus/content/repositories/snapshots"]]))
