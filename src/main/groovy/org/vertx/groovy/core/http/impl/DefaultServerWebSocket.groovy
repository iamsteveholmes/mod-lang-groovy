package org.vertx.groovy.core.http.impl

import org.vertx.groovy.core.buffer.Buffer
import org.vertx.groovy.core.http.ServerWebSocket
import org.vertx.java.core.Handler
import org.vertx.java.core.http.MultiMap

/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
class DefaultServerWebSocket implements ServerWebSocket {

  private org.vertx.java.core.http.ServerWebSocket jServerWebSocket

  DefaultServerWebSocket(org.vertx.java.core.http.ServerWebSocket jServerWebSocket) {
    this.jServerWebSocket = jServerWebSocket
  }

  @Override
  String getBinaryHandlerID() {
    jServerWebSocket.binaryHandlerID()
  }

  @Override
  String getTextHandlerID() {
    jServerWebSocket.textHandlerID()
  }

  @Override
  ServerWebSocket writeBinaryFrame(Buffer data) {
    jServerWebSocket.writeBinaryFrame(data.toJavaBuffer())
    this
  }

  @Override
  ServerWebSocket writeTextFrame(String str) {
    jServerWebSocket.writeTextFrame(str)
    this
  }

  @Override
  ServerWebSocket closeHandler(Closure handler) {
    jServerWebSocket.closeHandler(handler as Handler)
    this
  }

  @Override
  void close() {
    jServerWebSocket.close()
  }

  @Override
  ServerWebSocket leftShift(Buffer buff) {
    return write(buff)
  }

  @Override
  ServerWebSocket leftShift(String str) {
    return write(new Buffer(str))
  }

  @Override
  ServerWebSocket dataHandler(Closure handler) {
    jServerWebSocket.dataHandler({handler(new Buffer(it))} as Handler)
    this
  }

  @Override
  ServerWebSocket pause() {
    jServerWebSocket.pause()
    this
  }

  @Override
  ServerWebSocket resume() {
    jServerWebSocket.resume()
    this
  }

  @Override
  ServerWebSocket endHandler(Closure endHandler) {
    jServerWebSocket.endHandler(endHandler as Handler)
    this
  }

  @Override
  ServerWebSocket write(Buffer data) {
    jServerWebSocket.write(data.toJavaBuffer())
    this
  }

  @Override
  ServerWebSocket setWriteQueueMaxSize(int maxSize) {
    jServerWebSocket.setWriteQueueMaxSize(maxSize)
    this
  }

  @Override
  boolean isWriteQueueFull() {
    jServerWebSocket.writeQueueFull()
  }

  @Override
  ServerWebSocket drainHandler(Closure handler) {
    jServerWebSocket.drainHandler(handler as Handler)
    this
  }

  @Override
  ServerWebSocket exceptionHandler(Closure handler) {
    jServerWebSocket.exceptionHandler(handler as Handler)
    this
  }

  @Override
  String getPath() {
    jServerWebSocket.path()
  }

  @Override
  MultiMap getHeaders() {
    jServerWebSocket.headers()
  }

  @Override
  void reject() {
    jServerWebSocket.reject()
  }
}
