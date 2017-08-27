
1) Run java spark app
2) Java spark app with small fat jar (java_import neverlink etc.)
3) Try out commons cli
4) Try out don't use fat jar and run spark with many jars

5) Try out scala plugin
6) Create scala spark job



Build job:
    bazel build //sparkjobs:Parquet2Json_deploy.jar
Run Job:
    ./Parquet2Json.sh 
    