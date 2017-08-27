package org.solovev.spark.sample;

import com.google.common.base.Preconditions;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * User: Constantine Solovev
 * Created: 27.08.17  14:36
 */


public class Parquet2Json {

    public static void main(String[] args) {
        AppConfig config = AppConfig.fromArgs(args);
        Parquet2Json app = new Parquet2Json(config);
        app.run();
    }

    private static SparkConf getDefaultConfig() {
        return new SparkConf()
            .setAppName("Spark hello world app")
            .set("spark.executor.memory", "1g")
            .set("spark.executor.cores", "1")
            .set("spark.cores.max", "8");
    }

    private AppConfig config;
    private SparkSession spark;

    Parquet2Json(AppConfig config) {
        this.config = config;
        this.spark = SparkSession.builder()
            .config(getDefaultConfig())
            .appName("Export dmp events job (cli)")
            .getOrCreate();
    }


    private void run() {
        Dataset<Row> dataFrame = spark.read().parquet(config.input);
        dataFrame.printSchema();
        dataFrame.write().json(config.output);
    }


    private static class AppConfig {
        private String input;
        private String output;

        public AppConfig(String input, String output) {
            this.input = input;
            this.output = output;
        }

        public static AppConfig fromArgs(String[] args) {
            // todo use common cli
            Preconditions.checkArgument(args.length > 1, "2 params required, input and output folder.");
            return new AppConfig(args[0], args[1]);
        }

    }
}
