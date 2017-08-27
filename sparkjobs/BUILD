
java_binary(
    name = "Parquet2Json",
    main_class = "org.solovev.spark.sample.Parquet2Json",
    runtime_deps = [
        "spark-sample",
    ],
)

java_library(
    name = "spark-sample",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["src/main/resources/**/*"]),
    deps = [

            "@com_google_guava_guava//jar",

            "@org_scala_lang_scala_library//jar",
            "@org_scala_lang_scala_reflect//jar",
            "@org_scala_lang_modules_scala_parser_combinators_2_11//jar",
            "@org_scala_lang_modules_scala_xml_2_11//jar",

            "@spark_core//jar",
            "@spark_catalyst//jar",
            "@spark_sql//jar",
    ],
)
