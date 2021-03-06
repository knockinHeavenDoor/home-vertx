package database;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.serviceproxy.ProxyHelper;
import service.HouseService;
import service.UserService;

public class DatabaseVerticle extends AbstractVerticle {

    public static final String CONFIG_MONGO_URL = "host";

    public static final String DB_NAME = "db_name";

    public static final String CONFIG_USERDB_QUEUE = "userdb.queue";

    public static final String CONFIG_HOUSEDB_QUEUE = "housedb.queue";

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        MongoClient mongoClient = MongoClient.createShared(vertx,new JsonObject()
        .put("host",config().getString(CONFIG_MONGO_URL,"127.0.0.1"))
                .put("port",config().getInteger("port",27017))
                .put("maxPoolSize",config().getInteger("maxPoolSize",5))
        .put("db_name",config().getString(DB_NAME, "hourse_property")));

        UserService.create(mongoClient,ready -> {
            if(ready.succeeded()){
                ProxyHelper.registerService(UserService.class,vertx,ready.result(),CONFIG_USERDB_QUEUE);
                startFuture.complete();
            } else {
                startFuture.fail(ready.cause());
            }
        });

        HouseService.create(mongoClient,ready -> {
            if(ready.succeeded()){
                ProxyHelper.registerService(HouseService.class,vertx,ready.result(),CONFIG_HOUSEDB_QUEUE);
                startFuture.complete();
            } else {
                startFuture.fail(ready.cause());
            }
        });
    }
}
