package com.fivetalk.recommendationservice.spark;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkALS implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(SparkALS.class);
    private static final String path = "recommendation-service/result/save/";
    private static SparkUtil sparkUtil = new SparkUtil();
    private MatrixFactorizationModel model;

    public void trainModel() {
        SparkConf conf = new SparkConf()
                .setAppName("RecommendationALS")
                .setMaster("local[4]").setSparkHome("/Users/baofeng/spark-2.3.2-bin-hadoop2.7/");

        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> data = jsc.textFile("recommendation-service/data/review_triple_index_pure.csv");
        JavaRDD<Rating> ratings = data.map(new Function<String, Rating>() {
            @Override
            public Rating call(String s) {
                String[] sarray = StringUtils.split(StringUtils.trim(s), ",");
                return new Rating(Integer.parseInt(sarray[0]), Integer.parseInt(sarray[1]),
                        Double.parseDouble(sarray[2]));
            }
        });
        // Build the recommendation model using ALS
        int rank = 10;
        int numIterations = 6;
        this.model = ALS.train(JavaRDD.toRDD(ratings), rank, numIterations, 0.01);
//        this.model.save(jsc.sc(), path);
        //为指定用户推荐10个商品(电影)
        Rating[] recommendProducts = model.recommendProducts(2, 10);
        log.info("get recommend result:{}", Arrays.toString(recommendProducts));
    }

    public List<String> getRecommendationByUserId(int userIndex, int topN) {
        Rating[] recommendProduct = this.model.recommendProducts(userIndex, topN);
        List<String> businessIdList = new ArrayList<>();
        for (Rating r : recommendProduct) {
            String businessId = this.sparkUtil.getBusinessIdByIndex(r.product());
            businessIdList.add(businessId);
        }
        return businessIdList;
    }

    public SparkALS() {
        this.trainModel();
    }

    public static void main(String[] args) {
        SparkALS sparkALS = new SparkALS();
        sparkALS.trainModel();
    }
}
