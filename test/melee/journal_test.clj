(ns melee.journal-test
  (:import (journal.io.api Journal$WriteType Journal$ReadType))
  (:use [clojure.java.io :only [file]]
        [melee.journal]
        [midje.sweet]))

(facts "Durable journal"
  (fact "Async write type"
    (:async write-type) => Journal$WriteType/ASYNC)
  (fact "Sync write type"
    (:sync write-type) => Journal$WriteType/SYNC)
  (fact "Async read type"
    (:async read-type) => Journal$ReadType/ASYNC)
  (fact "Sync read type"
    (:sync read-type) => Journal$ReadType/SYNC)
  (with-open [journal (journal (file "test"))]
    (fact "Create journal"
      journal => truthy)))