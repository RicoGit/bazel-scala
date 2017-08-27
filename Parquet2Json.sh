#!/bin/bash

spark-submit \
--class org.solovev.spark.sample.Parquet2Json \
/home/rico/dev/self/code/bazel-scala/bazel-bin/sparkjobs/Parquet2Json_deploy.jar /home/rico/dev/self/data/json/test.parquet /home/rico/dev/self/data/json/test.json