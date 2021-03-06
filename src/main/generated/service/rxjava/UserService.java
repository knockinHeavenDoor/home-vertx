/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package service.rxjava;

import java.util.Map;
import rx.Observable;
import rx.Single;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


@io.vertx.lang.rxjava.RxGen(service.UserService.class)
public class UserService {

  public static final io.vertx.lang.rxjava.TypeArg<UserService> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new UserService((service.UserService) obj),
    UserService::getDelegate
  );

  private final service.UserService delegate;
  
  public UserService(service.UserService delegate) {
    this.delegate = delegate;
  }

  public service.UserService getDelegate() {
    return delegate;
  }

  public UserService fetchAllUsers(int pageSize, int pageNumber, Handler<AsyncResult<JsonArray>> resultHandler) { 
    delegate.fetchAllUsers(pageSize, pageNumber, resultHandler);
    return this;
  }

  public Single<JsonArray> rxFetchAllUsers(int pageSize, int pageNumber) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      fetchAllUsers(pageSize, pageNumber, fut);
    }));
  }

  public UserService countAllUsers(Handler<AsyncResult<Long>> resultHandler) { 
    delegate.countAllUsers(resultHandler);
    return this;
  }

  public Single<Long> rxCountAllUsers() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      countAllUsers(fut);
    }));
  }

  public UserService insertUser(JsonObject user, Handler<AsyncResult<String>> resultHandler) { 
    delegate.insertUser(user, resultHandler);
    return this;
  }

  public Single<String> rxInsertUser(JsonObject user) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      insertUser(user, fut);
    }));
  }

  public UserService findUser(String username, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.findUser(username, resultHandler);
    return this;
  }

  public Single<JsonObject> rxFindUser(String username) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      findUser(username, fut);
    }));
  }

  public UserService deleteUserById(String id, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.deleteUserById(id, resultHandler);
    return this;
  }

  public Single<JsonObject> rxDeleteUserById(String id) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      deleteUserById(id, fut);
    }));
  }


  public static  UserService newInstance(service.UserService arg) {
    return arg != null ? new UserService(arg) : null;
  }
}
